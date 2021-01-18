package dialogflow.agent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dialogflow.agent.entities.Entity;
import dialogflow.agent.entities.Entry;
import dialogflow.agent.entities.EntryLanguage;
import dialogflow.agent.intents.Intent;
import dialogflow.agent.intents.TrainingPhrase;
import dialogflow.agent.intents.UserSaysLanguage;
import files.Unzipper;

public class ReadAgent {
	private ObjectMapper mapper = new ObjectMapper().
				configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).
				configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
				.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
	public Agent getAgent(File zip) throws IOException {
		
		
		File agentFiles = new Unzipper(zip.getCanonicalPath()).unzip();
		String agentName = agentFiles.getName();
		Agent agent = null;
		List<Intent> intents = null; 
		List<Entity> entities = null;
		for (File f : agentFiles.listFiles()) {
			if (f.getName().equals("agent.json")) {
				 agent = mapper.readValue(f, Agent.class);
				 agent.setName(agentName);
			} else if (f.getName().equals("intents")) {
				intents = getIntets(f);
			} else if (f.getName().equals("entities")) {
				entities = getEntities(f);
			}
		}
		agent.setEntities(entities);
		agent.setIntents(intents);
		
		return agent;
	}
	
	private List<Intent> getIntets(File intentsFolder) throws JsonParseException, JsonMappingException, IOException{
		Map<String, Intent> intents = new HashMap<>();
		for (File intentFile : intentsFolder.listFiles()) {
			String[] nameSplit = intentFile.getName().replace(".json", "").split("_");

			if (nameSplit.length >=3 && nameSplit[nameSplit.length - 2].equals("usersays")) {
				String language = nameSplit[nameSplit.length - 1];
				String name = intentFile.getName().replace("_usersays_" + language + ".json", "");
				List<TrainingPhrase> phrases = mapper.readValue(intentFile,
						mapper.getTypeFactory().constructCollectionType(List.class, TrainingPhrase.class));
				UserSaysLanguage userSaysLanguage = new UserSaysLanguage();
				userSaysLanguage.setLanguage(language);
				userSaysLanguage.setPhrases(phrases);
				Intent intent = intents.get(name);

				if (intent == null) {
					intent = new Intent();
					intent.setName(name);
					intents.put(name, intent);
				}
				intent.addUsersays(userSaysLanguage);
			} else {
				String name = intentFile.getName().replace(".json", "");
				Intent intent = mapper.readValue(intentFile, Intent.class);
				Intent intentAux = intents.get(name);
				if (intentAux != null) {
					intent.setUsersays(intentAux.getUsersays());
				}
				intents.put(name, intent);
			}
		}
		return new ArrayList<>(intents.values());
	}
	
	private List<Entity> getEntities(File entityFolder) throws JsonParseException, JsonMappingException, IOException{
		Map<String, Entity> entities = new HashMap<>();
		for (File entityFile : entityFolder.listFiles()) {
			String[] nameSplit = entityFile.getName().replace(".json", "").split("_");
			if (nameSplit.length >=3 && nameSplit[nameSplit.length - 2].equals("entries")) {
				String language = nameSplit[nameSplit.length - 1];
				String name = entityFile.getName().replace("_entries_" + language + ".json", "");
				List<Entry> entries = mapper.readValue(entityFile,
						mapper.getTypeFactory().constructCollectionLikeType(List.class, Entry.class));
				EntryLanguage entryLanguage = new EntryLanguage();
				entryLanguage.setLanguage(language);
				entryLanguage.setEntries(entries);
				Entity entity = entities.get(name);
				if (entity == null) {
					entity = new Entity();
					entity.setName(name);
					entities.put(name, entity);
				}
				entity.addEntry(entryLanguage);

			} else {
				String name = entityFile.getName().replace(".json", "");
				Entity entity = mapper.readValue(entityFile, Entity.class);
				Entity entityAux = entities.get(name);
				if (entityAux != null) {
					entity.setEntriesLanguage(entityAux.getEntriesLanguage());
				}
				entities.put(name, entity);
			}
		}
		return new ArrayList<>(entities.values());
	}
}
