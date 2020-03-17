/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Training Phrase</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.TrainingPhrase#getTokens <em>Tokens</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getTrainingPhrase()
 * @model
 * @generated
 */
public interface TrainingPhrase extends EObject {
	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
	 * The list contents are of type {@link generator.Token}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' containment reference list.
	 * @see generator.GeneratorPackage#getTrainingPhrase_Tokens()
	 * @model containment="true"
	 * @generated
	 */
	EList<Token> getTokens();

} // TrainingPhrase
