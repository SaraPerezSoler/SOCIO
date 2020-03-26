/**
 */
package generator.impl;

import generator.Action;
import generator.Bot;
import generator.Entity;
import generator.GeneratorPackage;
import generator.Intent;
import generator.Language;
import generator.UserInteraction;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.BotImpl#getIntents <em>Intents</em>}</li>
 *   <li>{@link generator.impl.BotImpl#getEntities <em>Entities</em>}</li>
 *   <li>{@link generator.impl.BotImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link generator.impl.BotImpl#getFlows <em>Flows</em>}</li>
 *   <li>{@link generator.impl.BotImpl#getLanguages <em>Languages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BotImpl extends ElementImpl implements Bot {
	/**
	 * The cached value of the '{@link #getIntents() <em>Intents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntents()
	 * @generated
	 * @ordered
	 */
	protected EList<Intent> intents;

	/**
	 * The cached value of the '{@link #getEntities() <em>Entities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity> entities;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getFlows() <em>Flows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<UserInteraction> flows;

	/**
	 * The cached value of the '{@link #getLanguages() <em>Languages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguages()
	 * @generated
	 * @ordered
	 */
	protected EList<Language> languages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.BOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Intent> getIntents() {
		if (intents == null) {
			intents = new EObjectContainmentEList<Intent>(Intent.class, this, GeneratorPackage.BOT__INTENTS);
		}
		return intents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Entity> getEntities() {
		if (entities == null) {
			entities = new EObjectContainmentEList<Entity>(Entity.class, this, GeneratorPackage.BOT__ENTITIES);
		}
		return entities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<Action>(Action.class, this, GeneratorPackage.BOT__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UserInteraction> getFlows() {
		if (flows == null) {
			flows = new EObjectContainmentEList<UserInteraction>(UserInteraction.class, this, GeneratorPackage.BOT__FLOWS);
		}
		return flows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Language> getLanguages() {
		if (languages == null) {
			languages = new EDataTypeUniqueEList<Language>(Language.class, this, GeneratorPackage.BOT__LANGUAGES);
		}
		return languages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.BOT__INTENTS:
				return ((InternalEList<?>)getIntents()).basicRemove(otherEnd, msgs);
			case GeneratorPackage.BOT__ENTITIES:
				return ((InternalEList<?>)getEntities()).basicRemove(otherEnd, msgs);
			case GeneratorPackage.BOT__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case GeneratorPackage.BOT__FLOWS:
				return ((InternalEList<?>)getFlows()).basicRemove(otherEnd, msgs);
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
			case GeneratorPackage.BOT__INTENTS:
				return getIntents();
			case GeneratorPackage.BOT__ENTITIES:
				return getEntities();
			case GeneratorPackage.BOT__ACTIONS:
				return getActions();
			case GeneratorPackage.BOT__FLOWS:
				return getFlows();
			case GeneratorPackage.BOT__LANGUAGES:
				return getLanguages();
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
			case GeneratorPackage.BOT__INTENTS:
				getIntents().clear();
				getIntents().addAll((Collection<? extends Intent>)newValue);
				return;
			case GeneratorPackage.BOT__ENTITIES:
				getEntities().clear();
				getEntities().addAll((Collection<? extends Entity>)newValue);
				return;
			case GeneratorPackage.BOT__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case GeneratorPackage.BOT__FLOWS:
				getFlows().clear();
				getFlows().addAll((Collection<? extends UserInteraction>)newValue);
				return;
			case GeneratorPackage.BOT__LANGUAGES:
				getLanguages().clear();
				getLanguages().addAll((Collection<? extends Language>)newValue);
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
			case GeneratorPackage.BOT__INTENTS:
				getIntents().clear();
				return;
			case GeneratorPackage.BOT__ENTITIES:
				getEntities().clear();
				return;
			case GeneratorPackage.BOT__ACTIONS:
				getActions().clear();
				return;
			case GeneratorPackage.BOT__FLOWS:
				getFlows().clear();
				return;
			case GeneratorPackage.BOT__LANGUAGES:
				getLanguages().clear();
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
			case GeneratorPackage.BOT__INTENTS:
				return intents != null && !intents.isEmpty();
			case GeneratorPackage.BOT__ENTITIES:
				return entities != null && !entities.isEmpty();
			case GeneratorPackage.BOT__ACTIONS:
				return actions != null && !actions.isEmpty();
			case GeneratorPackage.BOT__FLOWS:
				return flows != null && !flows.isEmpty();
			case GeneratorPackage.BOT__LANGUAGES:
				return languages != null && !languages.isEmpty();
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (languages: ");
		result.append(languages);
		result.append(')');
		return result.toString();
	}

} //BotImpl
