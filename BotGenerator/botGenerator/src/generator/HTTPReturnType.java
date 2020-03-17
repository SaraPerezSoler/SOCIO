/**
 */
package generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>HTTP Return Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see generator.GeneratorPackage#getHTTPReturnType()
 * @model
 * @generated
 */
public enum HTTPReturnType implements Enumerator {
	/**
	 * The '<em><b>TEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT_VALUE
	 * @generated
	 * @ordered
	 */
	TEXT(0, "TEXT", "TEXT"),

	/**
	 * The '<em><b>STATUS CODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATUS_CODE_VALUE
	 * @generated
	 * @ordered
	 */
	STATUS_CODE(1, "STATUS_CODE", "STATUS_CODE"),

	/**
	 * The '<em><b>IMAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMAGE_VALUE
	 * @generated
	 * @ordered
	 */
	IMAGE(2, "IMAGE", "IMAGE"),

	/**
	 * The '<em><b>DATA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_VALUE
	 * @generated
	 * @ordered
	 */
	DATA(3, "DATA", "DATA");

	/**
	 * The '<em><b>TEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEXT_VALUE = 0;

	/**
	 * The '<em><b>STATUS CODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATUS_CODE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STATUS_CODE_VALUE = 1;

	/**
	 * The '<em><b>IMAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IMAGE_VALUE = 2;

	/**
	 * The '<em><b>DATA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATA_VALUE = 3;

	/**
	 * An array of all the '<em><b>HTTP Return Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final HTTPReturnType[] VALUES_ARRAY =
		new HTTPReturnType[] {
			TEXT,
			STATUS_CODE,
			IMAGE,
			DATA,
		};

	/**
	 * A public read-only list of all the '<em><b>HTTP Return Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<HTTPReturnType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>HTTP Return Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HTTPReturnType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HTTPReturnType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>HTTP Return Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HTTPReturnType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HTTPReturnType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>HTTP Return Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HTTPReturnType get(int value) {
		switch (value) {
			case TEXT_VALUE: return TEXT;
			case STATUS_CODE_VALUE: return STATUS_CODE;
			case IMAGE_VALUE: return IMAGE;
			case DATA_VALUE: return DATA;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private HTTPReturnType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //HTTPReturnType
