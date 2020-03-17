/**
 */
package branchDecision;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import socioProjects.Project;
import socioProjects.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Round</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link branchDecision.Round#getRoundId <em>Round Id</em>}</li>
 *   <li>{@link branchDecision.Round#getConsensusMeasure <em>Consensus Measure</em>}</li>
 *   <li>{@link branchDecision.Round#getUserPreferences <em>User Preferences</em>}</li>
 *   <li>{@link branchDecision.Round#getConsensusOrder <em>Consensus Order</em>}</li>
 *   <li>{@link branchDecision.Round#getRoundDate <em>Round Date</em>}</li>
 * </ul>
 *
 * @see branchDecision.BranchDecisionPackage#getRound()
 * @model
 * @generated
 */
public interface Round extends EObject {
	/**
	 * Returns the value of the '<em><b>Round Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Round Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Round Id</em>' attribute.
	 * @see #setRoundId(int)
	 * @see branchDecision.BranchDecisionPackage#getRound_RoundId()
	 * @model required="true"
	 * @generated
	 */
	int getRoundId();

	/**
	 * Sets the value of the '{@link branchDecision.Round#getRoundId <em>Round Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Round Id</em>' attribute.
	 * @see #getRoundId()
	 * @generated
	 */
	void setRoundId(int value);

	/**
	 * Returns the value of the '<em><b>Consensus Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consensus Measure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consensus Measure</em>' attribute.
	 * @see #setConsensusMeasure(double)
	 * @see branchDecision.BranchDecisionPackage#getRound_ConsensusMeasure()
	 * @model
	 * @generated
	 */
	double getConsensusMeasure();

	/**
	 * Sets the value of the '{@link branchDecision.Round#getConsensusMeasure <em>Consensus Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consensus Measure</em>' attribute.
	 * @see #getConsensusMeasure()
	 * @generated
	 */
	void setConsensusMeasure(double value);

	/**
	 * Returns the value of the '<em><b>User Preferences</b></em>' containment reference list.
	 * The list contents are of type {@link branchDecision.Preference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Preferences</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Preferences</em>' containment reference list.
	 * @see branchDecision.BranchDecisionPackage#getRound_UserPreferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<Preference> getUserPreferences();

	/**
	 * Returns the value of the '<em><b>Consensus Order</b></em>' containment reference list.
	 * The list contents are of type {@link branchDecision.Order}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consensus Order</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consensus Order</em>' containment reference list.
	 * @see branchDecision.BranchDecisionPackage#getRound_ConsensusOrder()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Order> getConsensusOrder();

	/**
	 * Returns the value of the '<em><b>Round Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Round Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Round Date</em>' attribute.
	 * @see #setRoundDate(Date)
	 * @see branchDecision.BranchDecisionPackage#getRound_RoundDate()
	 * @model required="true"
	 * @generated
	 */
	Date getRoundDate();

	/**
	 * Sets the value of the '{@link branchDecision.Round#getRoundDate <em>Round Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Round Date</em>' attribute.
	 * @see #getRoundDate()
	 * @generated
	 */
	void setRoundDate(Date value);

	void calculateConsensus(List<Project> branchs, double beta) throws Exception;
	Order getFirst();
	Map<User, Double> proximityMeasures(double beta);
	
	void addUserPreference(Preference p);
	long getTimer();
	void setTimer(long timer);

} // Round
