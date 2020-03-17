/**
 */
package generator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.UserInteraction#getIntent <em>Intent</em>}</li>
 *   <li>{@link generator.UserInteraction#getSrc <em>Src</em>}</li>
 *   <li>{@link generator.UserInteraction#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getUserInteraction()
 * @model
 * @generated
 */
public interface UserInteraction extends Interaction {
	/**
	 * Returns the value of the '<em><b>Intent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intent</em>' reference.
	 * @see #setIntent(Intent)
	 * @see generator.GeneratorPackage#getUserInteraction_Intent()
	 * @model required="true"
	 * @generated
	 */
	Intent getIntent();

	/**
	 * Sets the value of the '{@link generator.UserInteraction#getIntent <em>Intent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intent</em>' reference.
	 * @see #getIntent()
	 * @generated
	 */
	void setIntent(Intent value);

	/**
	 * Returns the value of the '<em><b>Src</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link generator.BotInteraction#getOutcoming <em>Outcoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src</em>' container reference.
	 * @see #setSrc(BotInteraction)
	 * @see generator.GeneratorPackage#getUserInteraction_Src()
	 * @see generator.BotInteraction#getOutcoming
	 * @model opposite="outcoming" transient="false"
	 * @generated
	 */
	BotInteraction getSrc();

	/**
	 * Sets the value of the '{@link generator.UserInteraction#getSrc <em>Src</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src</em>' container reference.
	 * @see #getSrc()
	 * @generated
	 */
	void setSrc(BotInteraction value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link generator.BotInteraction#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(BotInteraction)
	 * @see generator.GeneratorPackage#getUserInteraction_Target()
	 * @see generator.BotInteraction#getIncoming
	 * @model opposite="incoming" containment="true"
	 * @generated
	 */
	BotInteraction getTarget();

	/**
	 * Sets the value of the '{@link generator.UserInteraction#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(BotInteraction value);

} // UserInteraction
