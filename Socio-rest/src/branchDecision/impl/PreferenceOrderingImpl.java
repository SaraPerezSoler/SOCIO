/**
 */
package branchDecision.impl;

import branchDecision.BranchDecisionPackage;
import branchDecision.Order;
import branchDecision.PreferenceOrdering;
import socioProjects.Project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preference Ordering</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link branchDecision.impl.PreferenceOrderingImpl#getOrder <em>Order</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PreferenceOrderingImpl extends PreferenceImpl implements PreferenceOrdering {
	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected EList<Order> order;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreferenceOrderingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BranchDecisionPackage.Literals.PREFERENCE_ORDERING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Order> getOrder() {
		if (order == null) {
			order = new EObjectContainmentEList<Order>(Order.class, this, BranchDecisionPackage.PREFERENCE_ORDERING__ORDER);
		}
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BranchDecisionPackage.PREFERENCE_ORDERING__ORDER:
				return ((InternalEList<?>)getOrder()).basicRemove(otherEnd, msgs);
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
			case BranchDecisionPackage.PREFERENCE_ORDERING__ORDER:
				return getOrder();
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
			case BranchDecisionPackage.PREFERENCE_ORDERING__ORDER:
				getOrder().clear();
				getOrder().addAll((Collection<? extends Order>)newValue);
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
			case BranchDecisionPackage.PREFERENCE_ORDERING__ORDER:
				getOrder().clear();
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
			case BranchDecisionPackage.PREFERENCE_ORDERING__ORDER:
				return order != null && !order.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Double[][] getFuzzyPreference(List<Project> branchs) throws Exception {
		
		List<Order> order=getOrder();
		List<Order> order2=new ArrayList<Order>();
		if (branchs.size()!=order.size()){
			throw new Exception("Order of projects size distinct of branchs size");
		}
		int size=order.size();
		Double [][] fuzzyPreference= new Double[size][size];
		
		for (int i=0; i<size; i++){
			Project b=branchs.get(i);
			for (int j=0; j<size; j++){
				if (b.getCompleteName().equalsIgnoreCase(order.get(j).getProjectName())){
					order2.add(order.get(j));
					break;
				}
			}
		}
		for (int i=0; i<size; i++){
			for (int j=0; j<size; j++){
				double num=order2.get(j).getPos()-order2.get(i).getPos();
				fuzzyPreference[i][j]=0.5*(1.0+(num/(size-1)));
			}
		}
		
		return fuzzyPreference;
	}

} //PreferenceOrderingImpl
