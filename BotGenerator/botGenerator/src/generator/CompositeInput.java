/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.CompositeInput#getTokens <em>Tokens</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getCompositeInput()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='tokenComplexEntity'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot tokenComplexEntity='\n\t\t\tself.tokens-&gt;forAll(t| t.oclIsTypeOf(Literal) or t.oclIsTypeOf(EntityToken))'"
 * @generated
 */
public interface CompositeInput extends EObject {
	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
	 * The list contents are of type {@link generator.Token}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' containment reference list.
	 * @see generator.GeneratorPackage#getCompositeInput_Tokens()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Token> getTokens();

} // CompositeInput
