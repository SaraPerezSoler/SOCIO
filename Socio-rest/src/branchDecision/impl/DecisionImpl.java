/**
 */
package branchDecision.impl;

import branchDecision.BranchDecisionPackage;
import branchDecision.Decision;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import socioProjects.BranchGroup;
import socioProjects.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Decision</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link branchDecision.impl.DecisionImpl#getName <em>Name</em>}</li>
 *   <li>{@link branchDecision.impl.DecisionImpl#getChosenBranch <em>Chosen Branch</em>}</li>
 *   <li>{@link branchDecision.impl.DecisionImpl#getStart <em>Start</em>}</li>
 *   <li>{@link branchDecision.impl.DecisionImpl#getMergedDate <em>Merged Date</em>}</li>
 *   <li>{@link branchDecision.impl.DecisionImpl#getMessageId <em>Message Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DecisionImpl extends MinimalEObjectImpl.Container implements Decision {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChosenBranch() <em>Chosen Branch</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getChosenBranch()
	 * @generated
	 * @ordered
	 */
	protected Project chosenBranch;

	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final Date START_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected Date start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #getMergedDate() <em>Merged Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMergedDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date MERGED_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMergedDate() <em>Merged Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMergedDate()
	 * @generated
	 * @ordered
	 */
	protected Date mergedDate = MERGED_DATE_EDEFAULT;
	/**
	 * The default value of the '{@link #getMessageId() <em>Message Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageId()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessageId() <em>Message Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageId()
	 * @generated
	 * @ordered
	 */
	protected String messageId = MESSAGE_ID_EDEFAULT;

	private String path;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BranchDecisionPackage.Literals.DECISION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.DECISION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Project getChosenBranch() {
		if (chosenBranch != null && chosenBranch.eIsProxy()) {
			InternalEObject oldChosenBranch = (InternalEObject)chosenBranch;
			chosenBranch = (Project)eResolveProxy(oldChosenBranch);
			if (chosenBranch != oldChosenBranch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BranchDecisionPackage.DECISION__CHOSEN_BRANCH, oldChosenBranch, chosenBranch));
			}
		}
		return chosenBranch;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Project basicGetChosenBranch() {
		return chosenBranch;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setChosenBranch(Project newChosenBranch) {
		Project oldChosenBranch = chosenBranch;
		chosenBranch = newChosenBranch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.DECISION__CHOSEN_BRANCH, oldChosenBranch, chosenBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStart(Date newStart) {
		Date oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.DECISION__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getMergedDate() {
		return mergedDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMergedDate(Date newMergedDate) {
		Date oldMergedDate = mergedDate;
		mergedDate = newMergedDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.DECISION__MERGED_DATE, oldMergedDate, mergedDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMessageId() {
		return messageId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessageId(String newMessageId) {
		String oldMessageId = messageId;
		messageId = newMessageId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.DECISION__MESSAGE_ID, oldMessageId, messageId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BranchDecisionPackage.DECISION__NAME:
				return getName();
			case BranchDecisionPackage.DECISION__CHOSEN_BRANCH:
				if (resolve) return getChosenBranch();
				return basicGetChosenBranch();
			case BranchDecisionPackage.DECISION__START:
				return getStart();
			case BranchDecisionPackage.DECISION__MERGED_DATE:
				return getMergedDate();
			case BranchDecisionPackage.DECISION__MESSAGE_ID:
				return getMessageId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BranchDecisionPackage.DECISION__NAME:
				setName((String)newValue);
				return;
			case BranchDecisionPackage.DECISION__CHOSEN_BRANCH:
				setChosenBranch((Project)newValue);
				return;
			case BranchDecisionPackage.DECISION__START:
				setStart((Date)newValue);
				return;
			case BranchDecisionPackage.DECISION__MERGED_DATE:
				setMergedDate((Date)newValue);
				return;
			case BranchDecisionPackage.DECISION__MESSAGE_ID:
				setMessageId((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BranchDecisionPackage.DECISION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BranchDecisionPackage.DECISION__CHOSEN_BRANCH:
				setChosenBranch((Project)null);
				return;
			case BranchDecisionPackage.DECISION__START:
				setStart(START_EDEFAULT);
				return;
			case BranchDecisionPackage.DECISION__MERGED_DATE:
				setMergedDate(MERGED_DATE_EDEFAULT);
				return;
			case BranchDecisionPackage.DECISION__MESSAGE_ID:
				setMessageId(MESSAGE_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BranchDecisionPackage.DECISION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BranchDecisionPackage.DECISION__CHOSEN_BRANCH:
				return chosenBranch != null;
			case BranchDecisionPackage.DECISION__START:
				return START_EDEFAULT == null ? start != null : !START_EDEFAULT.equals(start);
			case BranchDecisionPackage.DECISION__MERGED_DATE:
				return MERGED_DATE_EDEFAULT == null ? mergedDate != null : !MERGED_DATE_EDEFAULT.equals(mergedDate);
			case BranchDecisionPackage.DECISION__MESSAGE_ID:
				return MESSAGE_ID_EDEFAULT == null ? messageId != null : !MESSAGE_ID_EDEFAULT.equals(messageId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", start: ");
		result.append(start);
		result.append(", mergedDate: ");
		result.append(mergedDate);
		result.append(", messageId: ");
		result.append(messageId);
		result.append(')');
		return result.toString();
	}

	public Project getBranch(String branchName) {
		for (Project b : getBranchs()) {
			if (b.getName().equalsIgnoreCase(branchName)) {
				return b;
			}
			String completeName=b.getCompleteName();
			//boolean otro=completeName.contains(branchName);
			if (completeName.equalsIgnoreCase(branchName)) {
				return b;
			}
		}
		return null;
	}

	public String decisionInformation() {
		String cad = "Branch group: " + getName();
		if (getChosenBranch()!=null){
			cad += "\n\t+ Selected: " + getChosenBranch().getCompleteName();
		}else{
			cad += "\n\t+ Not Selected yet ";
		}
		cad += "\n\t All branchs:";
		for (Project p : getBranchs()) {
			cad += "\n\t\t+" + p.getCompleteName();
		}
		return cad;
	}
	
	public Project getProject(){
		if (eContainer() instanceof Project){
			return (Project)eContainer();
		}
		return null;
	}
	public List<Project> getBranchs(){
		if (this.eContainer() instanceof BranchGroup) {
			return ((BranchGroup)this.eContainer()).getBranchs();
		}
		return null;
	}
	public String getFilePath() {
		return path;
	}
	public void setFilePath(String path) {
		this.path = path;
	}

} // DecisionImpl
