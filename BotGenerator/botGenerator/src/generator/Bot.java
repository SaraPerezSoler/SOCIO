/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.Bot#getIntents <em>Intents</em>}</li>
 *   <li>{@link generator.Bot#getEntities <em>Entities</em>}</li>
 *   <li>{@link generator.Bot#getActions <em>Actions</em>}</li>
 *   <li>{@link generator.Bot#getFlows <em>Flows</em>}</li>
 *   <li>{@link generator.Bot#getLanguages <em>Languages</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getBot()
 * @model
 * @generated
 */
public interface Bot extends Element {
	/**
	 * Returns the value of the '<em><b>Intents</b></em>' containment reference list.
	 * The list contents are of type {@link generator.Intent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intents</em>' containment reference list.
	 * @see generator.GeneratorPackage#getBot_Intents()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Intent> getIntents();

	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
	 * The list contents are of type {@link generator.Entity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' containment reference list.
	 * @see generator.GeneratorPackage#getBot_Entities()
	 * @model containment="true"
	 * @generated
	 */
	EList<Entity> getEntities();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link generator.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see generator.GeneratorPackage#getBot_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Flows</b></em>' containment reference list.
	 * The list contents are of type {@link generator.UserInteraction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flows</em>' containment reference list.
	 * @see generator.GeneratorPackage#getBot_Flows()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<UserInteraction> getFlows();

	/**
	 * Returns the value of the '<em><b>Languages</b></em>' attribute list.
	 * The list contents are of type {@link generator.Language}.
	 * The literals are from the enumeration {@link generator.Language}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Languages</em>' attribute list.
	 * @see generator.Language
	 * @see generator.GeneratorPackage#getBot_Languages()
	 * @model required="true"
	 * @generated
	 */
	EList<Language> getLanguages();

} // Bot
