/**
 */
package branchDecision.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import branchDecision.BranchDecisionPackage;
import branchDecision.Order;
import branchDecision.Preference;
import branchDecision.Round;
import socioProjects.Project;
import socioProjects.User;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Round</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link branchDecision.impl.RoundImpl#getRoundId <em>Round Id</em>}</li>
 *   <li>{@link branchDecision.impl.RoundImpl#getConsensusMeasure <em>Consensus Measure</em>}</li>
 *   <li>{@link branchDecision.impl.RoundImpl#getUserPreferences <em>User Preferences</em>}</li>
 *   <li>{@link branchDecision.impl.RoundImpl#getConsensusOrder <em>Consensus Order</em>}</li>
 *   <li>{@link branchDecision.impl.RoundImpl#getRoundDate <em>Round Date</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoundImpl extends MinimalEObjectImpl.Container implements Round {
	/**
	 * The default value of the '{@link #getRoundId() <em>Round Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoundId()
	 * @generated
	 * @ordered
	 */
	protected static final int ROUND_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRoundId() <em>Round Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoundId()
	 * @generated
	 * @ordered
	 */
	protected int roundId = ROUND_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getConsensusMeasure() <em>Consensus Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsensusMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final double CONSENSUS_MEASURE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getConsensusMeasure() <em>Consensus Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsensusMeasure()
	 * @generated
	 * @ordered
	 */
	protected double consensusMeasure = CONSENSUS_MEASURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUserPreferences() <em>User Preferences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserPreferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Preference> userPreferences;

	/**
	 * The cached value of the '{@link #getConsensusOrder() <em>Consensus Order</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsensusOrder()
	 * @generated
	 * @ordered
	 */
	protected EList<Order> consensusOrder;
	
	/**
	 * The default value of the '{@link #getRoundDate() <em>Round Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoundDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date ROUND_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoundDate() <em>Round Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoundDate()
	 * @generated
	 * @ordered
	 */
	protected Date roundDate = ROUND_DATE_EDEFAULT;

	private final double b=0.5;
	private long timer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoundImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BranchDecisionPackage.Literals.ROUND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRoundId() {
		return roundId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoundId(int newRoundId) {
		int oldRoundId = roundId;
		roundId = newRoundId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.ROUND__ROUND_ID, oldRoundId, roundId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getConsensusMeasure() {
		return consensusMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsensusMeasure(double newConsensusMeasure) {
		double oldConsensusMeasure = consensusMeasure;
		consensusMeasure = newConsensusMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.ROUND__CONSENSUS_MEASURE, oldConsensusMeasure, consensusMeasure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Preference> getUserPreferences() {
		if (userPreferences == null) {
			userPreferences = new EObjectContainmentEList<Preference>(Preference.class, this, BranchDecisionPackage.ROUND__USER_PREFERENCES);
		}
		return userPreferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Order> getConsensusOrder() {
		if (consensusOrder == null) {
			consensusOrder = new EObjectContainmentEList<Order>(Order.class, this, BranchDecisionPackage.ROUND__CONSENSUS_ORDER);
		}
		return consensusOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getRoundDate() {
		return roundDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoundDate(Date newRoundDate) {
		Date oldRoundDate = roundDate;
		roundDate = newRoundDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.ROUND__ROUND_DATE, oldRoundDate, roundDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BranchDecisionPackage.ROUND__USER_PREFERENCES:
				return ((InternalEList<?>)getUserPreferences()).basicRemove(otherEnd, msgs);
			case BranchDecisionPackage.ROUND__CONSENSUS_ORDER:
				return ((InternalEList<?>)getConsensusOrder()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BranchDecisionPackage.ROUND__ROUND_ID:
				return getRoundId();
			case BranchDecisionPackage.ROUND__CONSENSUS_MEASURE:
				return getConsensusMeasure();
			case BranchDecisionPackage.ROUND__USER_PREFERENCES:
				return getUserPreferences();
			case BranchDecisionPackage.ROUND__CONSENSUS_ORDER:
				return getConsensusOrder();
			case BranchDecisionPackage.ROUND__ROUND_DATE:
				return getRoundDate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BranchDecisionPackage.ROUND__ROUND_ID:
				setRoundId((Integer)newValue);
				return;
			case BranchDecisionPackage.ROUND__CONSENSUS_MEASURE:
				setConsensusMeasure((Double)newValue);
				return;
			case BranchDecisionPackage.ROUND__USER_PREFERENCES:
				getUserPreferences().clear();
				getUserPreferences().addAll((Collection<? extends Preference>)newValue);
				return;
			case BranchDecisionPackage.ROUND__CONSENSUS_ORDER:
				getConsensusOrder().clear();
				getConsensusOrder().addAll((Collection<? extends Order>)newValue);
				return;
			case BranchDecisionPackage.ROUND__ROUND_DATE:
				setRoundDate((Date)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BranchDecisionPackage.ROUND__ROUND_ID:
				setRoundId(ROUND_ID_EDEFAULT);
				return;
			case BranchDecisionPackage.ROUND__CONSENSUS_MEASURE:
				setConsensusMeasure(CONSENSUS_MEASURE_EDEFAULT);
				return;
			case BranchDecisionPackage.ROUND__USER_PREFERENCES:
				getUserPreferences().clear();
				return;
			case BranchDecisionPackage.ROUND__CONSENSUS_ORDER:
				getConsensusOrder().clear();
				return;
			case BranchDecisionPackage.ROUND__ROUND_DATE:
				setRoundDate(ROUND_DATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BranchDecisionPackage.ROUND__ROUND_ID:
				return roundId != ROUND_ID_EDEFAULT;
			case BranchDecisionPackage.ROUND__CONSENSUS_MEASURE:
				return consensusMeasure != CONSENSUS_MEASURE_EDEFAULT;
			case BranchDecisionPackage.ROUND__USER_PREFERENCES:
				return userPreferences != null && !userPreferences.isEmpty();
			case BranchDecisionPackage.ROUND__CONSENSUS_ORDER:
				return consensusOrder != null && !consensusOrder.isEmpty();
			case BranchDecisionPackage.ROUND__ROUND_DATE:
				return ROUND_DATE_EDEFAULT == null ? roundDate != null : !ROUND_DATE_EDEFAULT.equals(roundDate);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (roundId: ");
		result.append(roundId);
		result.append(", consensusMeasure: ");
		result.append(consensusMeasure);
		result.append(", roundDate: ");
		result.append(roundDate);
		result.append(')');
		return result.toString();
	}

	@Override
	public void calculateConsensus(List<Project> branchs, double beta) throws Exception {
		
		
		List<Preference> preferences=getUserPreferences();
		if (preferences.isEmpty()){
			this.consensusMeasure=0;
			return;
		}
		Double[][][] usersPreferences=new Double[preferences.size()][][];
		for (int i=0; i<preferences.size(); i++){
			Preference p=preferences.get(i);
			usersPreferences[i]=p.getFuzzyPreference(branchs);
		}
		
		collectivePreference(getColectiveFuzzyPreference(usersPreferences), branchs);
		
		List<Double[]> prox=new ArrayList<Double[]>();
		for(Preference p: preferences){
			prox.add(proximityForEachUserForEachAlternative(getDifference(this.getConsensusOrder(), p.getOrder()), b));
		}
		Double[] consensusDegradeOnAlter= new Double[branchs.size()];
		for (int i=0; i<branchs.size();i++){
			double suma=0;
			for (Double[] p: prox){
				suma+=p[i]/prox.size();
			}
			consensusDegradeOnAlter[i]=1-suma;
		}
		int sol=getSol();
		double suma=0;
		for (int i=0; i<consensusDegradeOnAlter.length;i++){
			
			suma+=consensusDegradeOnAlter[i]/consensusDegradeOnAlter.length;
		}
		double part1=(1-beta)*suma;
		double part2=beta*consensusDegradeOnAlter[sol];
		this.consensusMeasure=part1+part2;
	}
	
	private int getSol(){
		int sol=0;
		for (int i=0; i<getConsensusOrder().size(); i++){
			Order o1=getConsensusOrder().get(i);
			Order o2=getConsensusOrder().get(sol);
			if (o1.getPos()<o2.getPos()){
				sol=i;
			}
		}
		return sol;
	}
	
	private Double[] proximityForEachUserForEachAlternative(Integer[] vector, double b){
		int n=vector.length;
		Double[] prox=new Double[n];
		for (int i=0; i<n; i++){
			double v=vector[i];
			if (v<0){
				v=v*-1.0;
			}
			prox[i]=Math.pow(v/(n-1), b);
		}
		return prox;
		
		
	}
	
	
	private Integer[] getDifference(List<Order> consensusOrder2, List<Order> order) {
		Integer[] vector=new Integer[order.size()];
		for (int i=0; i<order.size(); i++){
			vector[i]=consensusOrder2.get(i).getPos()-order.get(i).getPos();
		}
		return vector;
	}

	private Double[][] getColectiveFuzzyPreference(Double[][][] usersPreferences){
		int n=usersPreferences.length; //numero de usuarios
		double a=0.3;
		double b=0.8;
		Double[] w=getW(a, b, n);
		Double[][] colPreferences=new Double[usersPreferences[0].length][usersPreferences[0][0].length];
		for (int i=0; i<usersPreferences[0].length; i++){
			for (int j=0; j<usersPreferences[0][i].length; j++){
				colPreferences[i][j]=0.0;
				Double[] pk=new Double[n];
				for (int k=0; k<n; k++){
					pk[k]=usersPreferences[k][i][j];
				}
				Arrays.sort(pk);
				for (int k=0; k<n; k++){
					colPreferences[i][j]+=w[k]*pk[k];
				}
			}
			
		}
		return colPreferences;
		
	}
	
	private Double[] getW(double a, double b, int n){
		Double [] w= new Double[n];
		for (int k=0; k<n; k++){
			w[k]=getQ((k+1.0)/n, a, b)-getQ(k*1.0/n, a, b);
		}
		return w;
	}
	private Double getQ(double r, double a, double b){
		if (r<a){
			return 0.0;
		}else if (r>b){
			return 1.0;
		}else{
			return ((r-a)/(b-a));
		}
	}
	
	private void collectivePreference(Double[][] colectiveFuzzyPreference, List<Project> branchs){
		Double[] w=getW(0.5, 1, colectiveFuzzyPreference[0].length);
		Double[] values=new Double[colectiveFuzzyPreference.length];
		Double[] copy=new Double[colectiveFuzzyPreference.length];
		for (int i=0; i<colectiveFuzzyPreference.length; i++){
			values[i]=0.0;
			Double[] pj=new Double[colectiveFuzzyPreference[i].length];
			for (int j=0; j<colectiveFuzzyPreference[i].length; j++){
				pj[j]=colectiveFuzzyPreference[i][j];
			}
			Arrays.sort(pj);
			for (int j=0; j<colectiveFuzzyPreference[i].length; j++){
				values[i]+=w[j]*pj[j];
			}
			copy[i]=values[i];
		}
		Arrays.sort(copy);
		Integer[] posiciones= new Integer[values.length];
		int pos=1;
		for (int i=copy.length-1; i>=0; i--){
			for (int j=0; j<values.length; j++){
				if (copy[i]==values[j]){
					posiciones[j]=pos;
				}
			}
			pos++;
		}
		
		for (int i=0; i<branchs.size(); i++){
			Project p=branchs.get(i);
			Order order=BranchDecisionFactoryImpl.eINSTANCE.createOrder();
			order.setProjectName(p.getCompleteName());
			order.setPos(posiciones[i]);
			this.getConsensusOrder().add(order);
		}
	}
	
	public Order getFirst(){
		if (getConsensusOrder().isEmpty()){
			return null;
		}
		Order min=getConsensusOrder().get(0);
		for (Order o: getConsensusOrder()){
			if (min.getPos()>o.getPos()){
				min=o;
			}
		}
		return min;
	}
	
	public Map<User, Double> proximityMeasures(double beta){
		List<Preference> preferences=getUserPreferences();
		Map<User, Double> proximityMeasures=new HashMap<>();
		int sol=getSol();
		for(Preference p: preferences){
			Double[] proxs=proximityForEachUserForEachAlternative(getDifference(this.getConsensusOrder(), p.getOrder()), b);
			Double suma=0.0;
			for (Double prox: proxs){
				suma+=prox/proxs.length;
			}
			Double part1=(1-beta)*(1-suma);
			Double part2=beta*proxs[sol];
			proximityMeasures.put(p.getUser(), part1+part2);
			
		
		}
		return proximityMeasures;
	}

	@Override
	public void addUserPreference(Preference p) {
		for (Preference p2: getUserPreferences()){
			if (p2.getUser().equals(p.getUser())){
				return;
			}
		}
		
		getUserPreferences().add(p);
		
	}

	public long getTimer() {
		return timer;
	}

	public void setTimer(long timer) {
		this.timer = timer;
	}

} //RoundImpl
