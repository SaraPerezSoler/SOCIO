/**
 */
package branchDecision.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import branchDecision.BranchDecisionPackage;
import branchDecision.Consensus;
import branchDecision.Order;
import branchDecision.Preference;
import branchDecision.PreferenceOrdering;
import branchDecision.Round;
import socioProjects.BranchGroup;
import socioProjects.Project;
import socioProjects.User;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Consensus</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link branchDecision.impl.ConsensusImpl#getConsensusRequired <em>Consensus Required</em>}</li>
 *   <li>{@link branchDecision.impl.ConsensusImpl#getRounds <em>Rounds</em>}</li>
 *   <li>{@link branchDecision.impl.ConsensusImpl#getUsers <em>Users</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsensusImpl extends DecisionImpl implements Consensus {
	/**
	 * The default value of the '{@link #getConsensusRequired() <em>Consensus Required</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConsensusRequired()
	 * @generated
	 * @ordered
	 */
	protected static final double CONSENSUS_REQUIRED_EDEFAULT = 0.75;

	/**
	 * The cached value of the '{@link #getConsensusRequired() <em>Consensus Required</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConsensusRequired()
	 * @generated
	 * @ordered
	 */
	protected double consensusRequired = CONSENSUS_REQUIRED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRounds() <em>Rounds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRounds()
	 * @generated
	 * @ordered
	 */
	protected EList<Round> rounds;

	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<User> users;

	protected final double beta = 0.8;
	protected final double MIN = 0.6;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsensusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BranchDecisionPackage.Literals.CONSENSUS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getConsensusRequired() {
		return consensusRequired;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsensusRequired(double newConsensusRequired) {
		double oldConsensusRequired = consensusRequired;
		consensusRequired = newConsensusRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.CONSENSUS__CONSENSUS_REQUIRED, oldConsensusRequired, consensusRequired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Round> getRounds() {
		if (rounds == null) {
			rounds = new EObjectContainmentEList<Round>(Round.class, this, BranchDecisionPackage.CONSENSUS__ROUNDS);
		}
		return rounds;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<User> getUsers() {
		if (users == null) {
			users = new EObjectResolvingEList<User>(User.class, this, BranchDecisionPackage.CONSENSUS__USERS);
		}
		return users;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BranchDecisionPackage.CONSENSUS__ROUNDS:
				return ((InternalEList<?>)getRounds()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BranchDecisionPackage.CONSENSUS__CONSENSUS_REQUIRED:
				return getConsensusRequired();
			case BranchDecisionPackage.CONSENSUS__ROUNDS:
				return getRounds();
			case BranchDecisionPackage.CONSENSUS__USERS:
				return getUsers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BranchDecisionPackage.CONSENSUS__CONSENSUS_REQUIRED:
				setConsensusRequired((Double)newValue);
				return;
			case BranchDecisionPackage.CONSENSUS__ROUNDS:
				getRounds().clear();
				getRounds().addAll((Collection<? extends Round>)newValue);
				return;
			case BranchDecisionPackage.CONSENSUS__USERS:
				getUsers().clear();
				getUsers().addAll((Collection<? extends User>)newValue);
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
			case BranchDecisionPackage.CONSENSUS__CONSENSUS_REQUIRED:
				setConsensusRequired(CONSENSUS_REQUIRED_EDEFAULT);
				return;
			case BranchDecisionPackage.CONSENSUS__ROUNDS:
				getRounds().clear();
				return;
			case BranchDecisionPackage.CONSENSUS__USERS:
				getUsers().clear();
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
			case BranchDecisionPackage.CONSENSUS__CONSENSUS_REQUIRED:
				return consensusRequired != CONSENSUS_REQUIRED_EDEFAULT;
			case BranchDecisionPackage.CONSENSUS__ROUNDS:
				return rounds != null && !rounds.isEmpty();
			case BranchDecisionPackage.CONSENSUS__USERS:
				return users != null && !users.isEmpty();
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (consensusRequired: ");
		result.append(consensusRequired);
		result.append(')');
		return result.toString();
	}

	@Override
	public void calculateConsensus() throws Exception {
		Round round = getRounds().get(getRounds().size() - 1);
		
		if (round.getUserPreferences().size() != getUsers().size()) {
			if (getRounds().size()>1){
				Round round2 = getRounds().get(getRounds().size() - 2);
				for (Preference p2:round2.getUserPreferences()){
					boolean flag=false;
					for (Preference p: round.getUserPreferences()){
						if (p2.getUser().equals(p.getUser())){
							flag=true;
							break;
						}
					}
					if (flag==false){
						round.addUserPreference(copy(p2));
					}
				}
			}
		}		
		round.calculateConsensus(getBranchs(), beta);
	}

	public double getConsensusActualMeasure() {
		return getRounds().get(getRounds().size() - 1).getConsensusMeasure();
	}

	public double getConsensusMaxMeasure() {
		double max = 0;
		for (Round r : getRounds()) {
			if (max < r.getConsensusMeasure()) {
				max = r.getConsensusMeasure();
			}
		}
		return max;
	}

	public Project getConsensusFirstOption() {
		Round round = getRounds().get(getRounds().size() - 1);
		String first = round.getFirst().getProjectName();
		for (Project p : getBranchs()) {
			if (p.getName().equalsIgnoreCase(first) || p.getCompleteName().equalsIgnoreCase(first)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<User> getUsersNoVoted() {
		Round round = getRounds().get(getRounds().size() - 1);
		List<User> notVoted = new ArrayList<User>();
		notVoted.addAll(getUsers());
		for (Preference p : round.getUserPreferences()) {
			notVoted.remove(p.getUser());
		}

		return notVoted;
	}

	@Override
	public boolean setPreference(PreferenceOrdering pref) {
		Round round = getRounds().get(getRounds().size() - 1);
		round.addUserPreference(pref);
		if (round.getUserPreferences().size() == getUsers().size()) {
			return true;
		}
		return false;

	}

	@Override
	public List<Project> getOrder() {

		Round round = getRounds().get(getRounds().size() - 1);
		if (round.getConsensusMeasure() == 0) {
			return getBranchs();
		}
		EList<Order> order = round.getConsensusOrder();

		ECollections.sort(order, new Comparator<Order>() {

			@Override
			public int compare(Order o1, Order o2) {
				return o1.getPos() - o2.getPos();
			}

		});
		List<Project> projectsOrder = new ArrayList<>();
		for (Order o : order) {
			for (Project p : getBranchs()) {
				if (p.getCompleteName().equalsIgnoreCase(o.getProjectName())
						|| p.getName().equalsIgnoreCase(o.getProjectName())) {
					projectsOrder.add(p);
				}
			}
		}

		return projectsOrder;
	}

	@Override
	public Map<User, Double> getUsersReVote(int rNum) {

		Round round = getRounds().get(rNum-1);
		Map<User, Double> usersReVote = new HashMap<User, Double>();
		if (getConsensusActualMeasure() >= getConsensusRequired()) {
			for (User u : getUsersNoVoted()) {
				usersReVote.put(u, 0.0);
			}
		} else {

			Map<User, Double> proximityMeasures = round.proximityMeasures(beta);

			for (User u : getUsers()) {
				if (proximityMeasures.get(u) == null) {
					usersReVote.put(u, 0.0);
				} else if (proximityMeasures.get(u) < MIN) {
					usersReVote.put(u, proximityMeasures.get(u));
				}
			}
		}
		return usersReVote;
	}

	@Override
	public void addRound(Round r) {
		if (getRounds().isEmpty()){
			getRounds().add(r);
		}else{
			Map<User, Double> reVote=getUsersReVote(getRounds().size());
			Set<User> usersReVote=reVote.keySet();
			Round round=getRounds().get(getRounds().size()-1);
			for (Preference p:round.getUserPreferences()){
				if (!usersReVote.contains(p.getUser())){
					
					r.addUserPreference(copy(p));
				}
			}
			getRounds().add(r);
		}
	}
	
	private Preference copy(Preference p){
		Preference p2=BranchDecisionFactoryImpl.eINSTANCE.createPreferenceOrdering();
		p2.setUser(p.getUser());
		for (Order o: p.getOrder()){
			Order o2=BranchDecisionFactoryImpl.eINSTANCE.createOrder();
			o2.setPos(o.getPos());
			o2.setProjectName(o.getProjectName());
			p2.getOrder().add(o2);
		}
		return p2;
	}

	@Override
	public BranchGroup getBranchGroup() {
		if (eContainer() instanceof BranchGroup) {
			return (BranchGroup) eContainer();
		}
		return null;
	}

	@Override
	public EList<Order> getConsensusOrder() {
		return getLastRound().getConsensusOrder();
	}

	@Override
	public Round getLastRound() {
		return getRounds().get(getRounds().size()-1);
	}

	@Override
	public boolean isRevoteCandidate(User u){
		Round round = getLastRound();
		Map<User, Double> proximityMeasures = round.proximityMeasures(beta);
		if (proximityMeasures.get(u)==null || proximityMeasures.get(u)<MIN){
			return true;
		}
		return false;
	}
} // ConsensusImpl
