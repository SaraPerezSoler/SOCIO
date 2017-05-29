package es.uam.app.projects.log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import DslHistory.Action;
import DslHistory.Add;
import DslHistory.CreateMsg;
import DslHistory.Delete;
import DslHistory.History;
import DslHistory.Msg;
import DslHistory.Sentence;
import DslHistory.Update;
import DslHistory.impl.CreateMsgImpl;
import DslHistory.impl.DslHistoryFactoryImpl;
import es.uam.app.actions.ActionModel;
import es.uam.app.actions.Create;
import es.uam.app.actions.Remove;
import es.uam.app.main.Main;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.User;
import es.uam.app.projects.ecore.EcoreControl;

public class HistoryControl {

	private Resource model;
	private String name;
	private History history;

	public HistoryControl(String name, boolean create) {

		ResourceSet resourceSet = EcoreControl.getResourceSet();
		if (create == false) {
			model = resourceSet.getResource(URI.createURI(name), true);
		} else {
			model = resourceSet.createResource(URI.createURI(name));
		}

		if (model.getContents().isEmpty()) {
			history = DslHistoryFactoryImpl.eINSTANCE.createHistory();
			model.getContents().add(history);
			this.save();
		} else {
			history = (History) model.getContents().get(0);
		}
		String[] seg = name.split("/");
		this.name = seg[seg.length - 1];
	}

	public void setCreateMsg(ReceivedMessage msg) {
		CreateMsgImpl createMsg = (CreateMsgImpl) DslHistoryFactoryImpl.eINSTANCE.createCreateMsg();

		DslHistory.User user = getUser(msg.getUser());

		// Guardamos los diferentes atributos
		// user
		createMsg.setUser(user);
		// text
		createMsg.setText(msg.getMsg());
		// sentence
		createMsg.setSentence(msg.getText());
		// date
		createMsg.setDate(msg.getDate());
		// Id
		createMsg.setId(msg.getId());

		history.setCreateMsg(createMsg);

	}

	public ReceivedMessage getCreateMsg() {

		CreateMsg createMsg = history.getCreateMsg();

		DslHistory.User eUser = createMsg.getUser();
		User user = readUser(eUser);

		String msg = createMsg.getText();
		String sentence = createMsg.getSentence();
		Date date = createMsg.getDate();
		String id = createMsg.getId();

		ReceivedMessage retMsg = new ReceivedMessage(msg, user, date, "NewProject", id);
		retMsg.setText(sentence);
		return retMsg;
	}

	public void writeHistoryMsg(ReceivedMessage status) {
		
			// buscamos el usario entre los creados o lo creamos.
			DslHistory.User user = getUser(status.getUser());

			// Creamos un nuevo mensaje
			Msg msg = DslHistoryFactoryImpl.eINSTANCE.createMsg();

			// Guardamos los diferentes atributos
			// user
			msg.setUser(user);
			// text
			msg.setText(status.getMsg());
			// sentence
			Map<String, List<ActionModel>> sentences = status.getSentences();

			Set<String> keys = sentences.keySet();
			for (String k : keys) {
				List<ActionModel> actions = sentences.get(k);
				Sentence s = DslHistoryFactoryImpl.eINSTANCE.createSentence();
				s.setSentence(k);
				for (ActionModel a : actions) {
					s.getCommands().add(writeComand(a));
				}
				msg.getSentences().add(s);
			}
			msg.setUndoable(status.isUndoable());

			// date
			msg.setDate(status.getDate());
			// Id
			msg.setId(status.getId());

			history.getMsg().add(msg);
	}
	public void undoMsg(ReceivedMessage status) {
		Msg msg=findMsg(status);
		if (msg!=null){
			history.getMsg().remove(msg);
		}
		
	}
	
	private DslHistory.User getUser(User user) {

		DslHistory.User eUser = null;

		List<DslHistory.User> users = history.getUsers();
		// Buscamos el user en la lista de los usuarios ya registrados
		eUser = this.existUser(users, user);

		// Si no lo encuentra lo crea
		if (eUser == null) {
			eUser = createUser(user);
			history.getUsers().add(eUser);
		}
		return eUser;

	}

	private DslHistory.User createUser(User user) {

		DslHistory.User eUser = DslHistoryFactoryImpl.eINSTANCE.createUser();
		eUser.setName(user.getName());
		eUser.setNick(user.getNick());
		eUser.setId(user.getId());
		eUser.setChannel(user.getChannel());

		return eUser;
	}

	private DslHistory.User existUser(List<DslHistory.User> users, User user) {
		// Recorre el array de usuarios, si esta el que busca lo devuelve
		for (DslHistory.User us : users) {
			User user2 = readUser(us);
			if (user.equals(user2)) {
				return us;
			}
		}
		return null;
	}

	// Dependiendo del tipo de action que sea
	private Action writeComand(ActionModel atm) {
		if (atm instanceof Create) {
			return newAdd((Create) atm);
		} else if (atm instanceof Remove) {
			return newDelete((Remove) atm);
		} else if (atm instanceof es.uam.app.actions.Update) {
			return newUpdate((es.uam.app.actions.Update) atm);
		} /*
			 * } else if (atm instanceof Is) { return newHerencia((Is) atm); }
			 */
		return null;
	}

	private Add newAdd(Create atm) {
		Add addAction = DslHistoryFactoryImpl.eINSTANCE.createAdd();
		addAction.setElement(atm.getObject().getObject());
		return addAction;

	}

	private Delete newDelete(Remove atm) {
		Delete deleteAction = DslHistoryFactoryImpl.eINSTANCE.createDelete();
		deleteAction.setElement(atm.getObject().getObject());
		return deleteAction;
	}

	private Update newUpdate(es.uam.app.actions.Update upd) {
		Update updateAction = DslHistoryFactoryImpl.eINSTANCE.createUpdate();
		updateAction.setElement(upd.getObject().getObject());
		updateAction.setOld(upd.getOld().getObject());
		updateAction.setNew(upd.getNew().getObject());
		return updateAction;
	}

	public void save() {
		try {
			/*
			 * Save the resource
			 */
			model.save(null);
		} catch (IOException e) {
			Main.log.fatal(e.getMessage());
			;
		}
	}

	public String getname() {
		return name;
	}

	public List<ReceivedMessage> readHistoryMsgs() {

		List<DslHistory.User> users = history.getUsers();
		List<Msg> msgs = history.getMsg();

		List<User> usersList = readUsers(users);
		return readMsgLog(msgs, usersList);
	}

	private List<User> readUsers(List<DslHistory.User> users) {
		List<User> ret = new ArrayList<User>();
		for (DslHistory.User user : users) {
			ret.add(readUser(user));
		}
		return ret;
	}

	private User readUser(DslHistory.User user) {

		String name = user.getName();
		long id = user.getId();
		String nick = user.getNick();
		String channel = user.getChannel();
		return new User(name, id, nick, channel);

	}

	private List<ReceivedMessage> readMsgLog(List<Msg> msgs, List<User> usersList) {

		List<ReceivedMessage> ret = new ArrayList<ReceivedMessage>();

		for (Msg m : msgs) {

			DslHistory.User user = m.getUser();
			long userId = user.getId();
			User u = User.find(usersList, userId);

			String text = m.getText();
			Date fecha = m.getDate();
			String msgId = m.getId();
			boolean undoable=m.isUndoable();
			
			ReceivedMessage msg = new ReceivedMessage(text, u, fecha, name, msgId);
			// msg.setText(text.substring(text.indexOf(name)));
			msg.setSentences(readSentences(m.getSentences()));
			msg.setUndoable(undoable);
			ret.add(msg);

		}
		Collections.sort(ret);

		return ret;
	}

	private Msg findMsg(ReceivedMessage msg) {

		List<Msg> msgs = history.getMsg();

		for (Msg m : msgs) {
			if (m.getId().equals(msg.getId())) {
				return m;
			}
		}

		return null;
	}

	private Map<String, List<ActionModel>> readSentences(List<Sentence> sentences) {
		Map<String, List<ActionModel>> ret = new HashMap<String, List<ActionModel>>();

		for (Sentence s : sentences) {
			List<ActionModel> actions = new ArrayList<>();

			List<Action> commands = s.getCommands();
			for (Action c : commands) {
				if (c instanceof Add) {
					Create a = Create.createAction(((Add) c).getElement());
					if (a != null) {
						actions.add(a);
					}
				} else if (c instanceof Delete) {
					Remove a = Remove.createAction(((Delete) c).getElement());
					if (a != null) {
						actions.add(a);
					}
				} else if (c instanceof Update) {
					es.uam.app.actions.Update a = es.uam.app.actions.Update.createAction(((Update) c).getElement(),
							((Update) c).getOld(), ((Update) c).getNew());
					if (a != null) {
						actions.add(a);
					}
				}
			}
			ret.put(s.getSentence(), actions);
		}

		return ret;
	}

}
