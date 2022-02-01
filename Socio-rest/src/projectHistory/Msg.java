/**
 */
package projectHistory;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import es.uam.app.projects.emf.Controlador;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Msg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.Msg#getMsg <em>Msg</em>}</li>
 *   <li>{@link projectHistory.Msg#getText <em>Text</em>}</li>
 *   <li>{@link projectHistory.Msg#getId <em>Id</em>}</li>
 *   <li>{@link projectHistory.Msg#getSentences <em>Sentences</em>}</li>
 * </ul>
 *
 * @see projectHistory.ProjectHistoryPackage#getMsg()
 * @model
 * @generated
 */
public interface Msg extends InteractionWithActions {
	/**
	 * Returns the value of the '<em><b>Msg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Msg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Msg</em>' attribute.
	 * @see #setMsg(String)
	 * @see projectHistory.ProjectHistoryPackage#getMsg_Msg()
	 * @model required="true"
	 * @generated
	 */
	String getMsg();

	/**
	 * Sets the value of the '{@link projectHistory.Msg#getMsg <em>Msg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Msg</em>' attribute.
	 * @see #getMsg()
	 * @generated
	 */
	void setMsg(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see projectHistory.ProjectHistoryPackage#getMsg_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link projectHistory.Msg#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Sentences</b></em>' containment reference list.
	 * The list contents are of type {@link projectHistory.Sentence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sentences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sentences</em>' containment reference list.
	 * @see projectHistory.ProjectHistoryPackage#getMsg_Sentences()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Sentence> getSentences();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see projectHistory.ProjectHistoryPackage#getMsg_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link projectHistory.Msg#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getChannel();

	void setSentences(Map<String, List<Action>> actions);

	Map<String, List<Action>> getSentencesMap();

	boolean hasElement(String element);

	boolean hasAction(String action);

	List<Action> getAllActions();

	List<Action> getActionsFromObject(Controlador obj);

	boolean hasProjectId();

	void setProject(String id);

	String getProject();
	
	
	boolean hasProjectName();

	boolean hasText();
	
	String getUserToSearch();
	
	void setUserToSearch(String userToSearch);

	boolean hasUserToSearch();

	long getProjectId();

} // Msg
