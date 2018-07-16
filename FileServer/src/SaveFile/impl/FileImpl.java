/**
 */
package SaveFile.impl;

import SaveFile.File;
import SaveFile.SaveFileFactory;
import SaveFile.SaveFilePackage;
import SaveFile.TimeUnit;
import SaveFile.Timer;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link SaveFile.impl.FileImpl#getName <em>Name</em>}</li>
 *   <li>{@link SaveFile.impl.FileImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link SaveFile.impl.FileImpl#getCreateAt <em>Create At</em>}</li>
 *   <li>{@link SaveFile.impl.FileImpl#getTimer <em>Timer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FileImpl extends MinimalEObjectImpl.Container implements File {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected String extension = EXTENSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreateAt() <em>Create At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateAt()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATE_AT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreateAt() <em>Create At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateAt()
	 * @generated
	 * @ordered
	 */
	protected Date createAt = CREATE_AT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTimer() <em>Timer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimer()
	 * @generated
	 * @ordered
	 */
	protected Timer timer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaveFilePackage.Literals.FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaveFilePackage.FILE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtension(String newExtension) {
		String oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaveFilePackage.FILE__EXTENSION, oldExtension, extension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreateAt() {
		return createAt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateAt(Date newCreateAt) {
		Date oldCreateAt = createAt;
		createAt = newCreateAt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaveFilePackage.FILE__CREATE_AT, oldCreateAt, createAt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimer(Timer newTimer, NotificationChain msgs) {
		Timer oldTimer = timer;
		timer = newTimer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaveFilePackage.FILE__TIMER, oldTimer, newTimer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimer(Timer newTimer) {
		if (newTimer != timer) {
			NotificationChain msgs = null;
			if (timer != null)
				msgs = ((InternalEObject)timer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaveFilePackage.FILE__TIMER, null, msgs);
			if (newTimer != null)
				msgs = ((InternalEObject)newTimer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SaveFilePackage.FILE__TIMER, null, msgs);
			msgs = basicSetTimer(newTimer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaveFilePackage.FILE__TIMER, newTimer, newTimer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaveFilePackage.FILE__TIMER:
				return basicSetTimer(null, msgs);
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
			case SaveFilePackage.FILE__NAME:
				return getName();
			case SaveFilePackage.FILE__EXTENSION:
				return getExtension();
			case SaveFilePackage.FILE__CREATE_AT:
				return getCreateAt();
			case SaveFilePackage.FILE__TIMER:
				return getTimer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SaveFilePackage.FILE__NAME:
				setName((String)newValue);
				return;
			case SaveFilePackage.FILE__EXTENSION:
				setExtension((String)newValue);
				return;
			case SaveFilePackage.FILE__CREATE_AT:
				setCreateAt((Date)newValue);
				return;
			case SaveFilePackage.FILE__TIMER:
				setTimer((Timer)newValue);
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
			case SaveFilePackage.FILE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SaveFilePackage.FILE__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
				return;
			case SaveFilePackage.FILE__CREATE_AT:
				setCreateAt(CREATE_AT_EDEFAULT);
				return;
			case SaveFilePackage.FILE__TIMER:
				setTimer((Timer)null);
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
			case SaveFilePackage.FILE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SaveFilePackage.FILE__EXTENSION:
				return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
			case SaveFilePackage.FILE__CREATE_AT:
				return CREATE_AT_EDEFAULT == null ? createAt != null : !CREATE_AT_EDEFAULT.equals(createAt);
			case SaveFilePackage.FILE__TIMER:
				return timer != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", extension: ");
		result.append(extension);
		result.append(", createAt: ");
		result.append(createAt);
		result.append(')');
		return result.toString();
	}

	@Override
	public void addTimer(long duration, TimeUnit unit) {
		Timer timer = SaveFileFactory.eINSTANCE.createTimer();
		timer.setUnit(unit);
		timer.setDuration(duration);
		setTimer(timer);
	}

} //FileImpl
