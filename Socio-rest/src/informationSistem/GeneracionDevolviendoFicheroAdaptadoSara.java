package informationSistem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;



/**
 * @author Sara Perez Soler This is an example of how to read the Store
 *         metamodel using the EMF libraries (see CreateMetamodel.java to create
 *         it) This main requires the following jars: - org.eclipse.emf.common -
 *         org.eclipse.emf.ecore.xmi - org.eclipse.emf.ecore
 */
public class GeneracionDevolviendoFicheroAdaptadoSara {

	
	public void escribirEnFichero (String texto, String rutaFichero) {

		try {
			FileWriter myWriter = new FileWriter(rutaFichero, true);
			myWriter.write(texto);
			myWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public LinkedHashMap<String, String> devuelveAtributosTablaClase(EClass eClass, List<EClassifier> cElements) {

		List<EClassifier> elements = cElements;

		LinkedHashMap<String, String> atributosClase = new LinkedHashMap<>();

		if (!eClass.isAbstract()) {

			atributosClase.put("id", "Integer");

			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				String tipo = eAttribute.getEType().getInstanceClass().getSimpleName();

				String nombreAtributo = eAttribute.getName();

				if (eAttribute.getUpperBound() == 1) {
					atributosClase.put(nombreAtributo, getAtributoParaInserts(tipo));
				}
			}

			for (EClassifier classifier : elements) {
				if (classifier instanceof EClass) {

					EClass eClassReviewing = (EClass) classifier;

					for (EReference referenciaOtraClase : eClassReviewing.getEAllReferences()) {
						String tipoE = referenciaOtraClase.getEType().getName();
						if (tipoE == eClass.getName()) {

							if (referenciaOtraClase.isContainment()) {

								String nombreVariable = "id_" + eClassReviewing.getName() + "_"
										+ referenciaOtraClase.getName();
								atributosClase.put(nombreVariable, "Integer");

							}
						}
					}
				}
			}
		}
		return atributosClase;

	}

	public LinkedHashMap<String, String> devuelveSoloAtributosTablaClase(EClass eClass, List<EClassifier> cElements) {

		List<EClassifier> elements = cElements;

		LinkedHashMap<String, String> atributosClase = new LinkedHashMap<>();
		System.out.println("PARA LA CLASE " + eClass.getName() + " devuelveSoloAtributosTablaClase (insert) -> ");
		
		if (!eClass.isAbstract()) {

			atributosClase.put("id", "Integer");

			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				
				
				String tipo = eAttribute.getEType().getInstanceClass().getSimpleName();

				String nombreAtributo = eAttribute.getName();
				
				System.out.println("->" + nombreAtributo+ "-" + tipo);

				if (eAttribute.getUpperBound() == 1) {
					atributosClase.put(nombreAtributo, getAtributoParaInserts(tipo));
				}
			}


		}
		return atributosClase;

	}
	
	
	public LinkedHashMap<String, String> devuelveAtributosTablaClaseApoyoASQL(EClass eClass, List<EClassifier> cElements) {

		// En el primer String devuelvo el nombre atributo
		// En el segundo String devuelvo el tipo del atributo

		// contenedor o no de la clase que lo contiene

		List<EClassifier> elements = cElements;

		LinkedHashMap<String, String> atributosClase = new LinkedHashMap<>();

		//atributosClase.put("id", "Integer");


		// Anyadimos el id que siembre habra

		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			// String tipo = eAttribute.getEType().getInstanceClass().getSimpleName();//
			// obtenemos el tipo
			// correspondiente en Java

			if (eAttribute.getUpperBound() == 1) {

				// anyadimos nombre y tipo del atributo
				// atributosClase.put(nombreAtributo, getAtributoParaInserts(tipo));
				// myWriter.write("\t\t + \""+nombreAtributo +" " + tipoCambiadoDeJavaASQL);

			} else {
			}
		} // FIN DE RECORRER EATTRIBUTES que no son tabla a parte

		// AHORA los de getters con atributos de referencia
		// Taking EReferences of the eClass

		for (EClassifier classifier : elements) {
			// Taking the EClass elements
			if (classifier instanceof EClass) {

				EClass eClassReviewing = (EClass) classifier;

				// if (!eClassReviewing.isAbstract()) { // si la clase no es abstracta

				for (EReference referenciaOtraClase : eClassReviewing.getEAllReferences()) {
					String tipoE = referenciaOtraClase.getEType().getName();// obtenemos el tipo correspondiente
																			// en Java

					if (tipoE == eClass.getName()) {// Soy referencia
						// anyadir integer

						if (referenciaOtraClase.isContainment()) { // Si es upper bound = 1 metemos la
																	// referencia
							String nombreVariable = "id_" + eClassReviewing.getName() + "_"
									+ referenciaOtraClase.getName();
							atributosClase.put(nombreVariable, "Integer");

						}
					}
				}

				// }// si la clase no es abstracta
			}
		}

		// } // Fin si no es abstracta

		return atributosClase;

	}

	public LinkedHashMap<String, String> devuelveAtributosNoLista(EClass eClass) {
		LinkedHashMap<String, String> atributosNoLista = new LinkedHashMap<>();

		// nombreAtributo, Tipo

		atributosNoLista.put("id", "Integer");

		// System.out.println(" - EAttributes:");
		// Si se trata de una eClass,

		// anyadimos los atributos de clase
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {

			String tipoE = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());// obtenemos el tipo
																									// correspondiente
																									// en Java
			String nombreAtributo = eAttribute.getName();

			if (eAttribute.getUpperBound() == 1) {// nos fijamos en el upperbound para saber si es atributo o lista

				atributosNoLista.put(nombreAtributo, tipoE);
			}
		}
		// anyadimos los atributos de referencia
		// Taking EReferences of the eClass
		for (EReference eReference : eClass.getEAllReferences()) {
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
			String nombreAtributo = eReference.getName();
			if (eReference.getUpperBound() == 1) {// nos fijamos en el upperbound para saber si es atributo o lista

				atributosNoLista.put(nombreAtributo, tipoE);
			}
		}

		return atributosNoLista;

	}

	public LinkedHashMap<String, String> devuelveAtributosLista(EClass eClass) {
		LinkedHashMap<String, String> atributosLista = new LinkedHashMap<>();
		// Anyadimos el id como en todas las clases:

		// nombreAtributo, Tipo
		// NombreAtributo, Tipo

		// anyadimos los atributos de clase
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {

			String tipoE = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());// obtenemos el tipo
																									// correspondiente
																									// en Java
			String nombreAtributo = eAttribute.getName();

			if (eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) {// nos fijamos en el upperbound
																						// para saber si es atributo o
																						// lista

				atributosLista.put(nombreAtributo, tipoWrapper(tipoE));

			}
		}
		// anyadimos los atributos de referencia
		for (EReference eReference : eClass.getEAllReferences()) {
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
			String nombreAtributo = eReference.getName();

			if (eReference.getUpperBound() == -1 || eReference.getUpperBound() >= 2) {// nos fijamos en el upperbound

				atributosLista.put(nombreAtributo, tipoE);

			}
		}

		return atributosLista;

	}

	public String atributoDevuelveTipo(EClass eClass, String atributoAComprobar) {
		LinkedHashMap<String, String> atributosJava = new LinkedHashMap<>();

		// nombreAtributo, ListaSi
		// NombreAtributo, ListaNo

		atributosJava.put("id", "Integer");

		// System.out.println(" - EAttributes:");
		// Si se trata de una eClass,

		// anyadimos los atributos de clase
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {

			// correspondiente
			String tipoE = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());// obtenemos el tipo
			// en Java
			String nombreAtributo = eAttribute.getName();
			atributosJava.put(nombreAtributo, tipoE);

		}
		// anyadimos los atributos de referencia
		// Taking EReferences of the eClass
		for (EReference eReference : eClass.getEAllReferences()) {
			// String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el
			// tipo correspondiente en Java
			String nombreAtributo = eReference.getName();
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java

			atributosJava.put(nombreAtributo, tipoE);

		}

		String tipo = atributosJava.get(atributoAComprobar);

		return tipo;
	}

	public boolean atributoEsReferencia(EClass eClass, String atributoAComprobar) {
		List<String> atributosReferencia = new ArrayList<String>();

		// System.out.println(" - EAttributes:");
		// Si se trata de una eClass,

		// anyadimos los atributos de clase
		/*
		 * for (EAttribute eAttribute : eClass.getEAllAttributes()) {
		 * 
		 * // correspondiente String tipoE =
		 * tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//
		 * obtenemos el tipo // en Java String nombreAtributo = eAttribute.getName();
		 * atributosJava.put(nombreAtributo, tipoE);
		 * 
		 * }
		 */
		// anyadimos los atributos de referencia
		// Taking EReferences of the eClass
		for (EReference eReference : eClass.getEAllReferences()) {
			// String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el
			// tipo correspondiente en Java
			String nombreAtributo = eReference.getName();
			// String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el
			// tipo correspondiente en Java

			atributosReferencia.add(nombreAtributo);

		}

		return atributosReferencia.contains(atributoAComprobar);
	}

	public boolean atributoNoEsReferencia(EClass eClass, String atributoAComprobar) {
		List<String> atributosNoReferencia = new ArrayList<String>();

		// System.out.println(" - EAttributes:");
		// Si se trata de una eClass,
		atributosNoReferencia.add("id");

		// anyadimos los atributos de clase
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {

			// correspondiente
			// String tipoE =
			// tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//
			// obtenemos el tipo
			// en Java
			String nombreAtributo = eAttribute.getName();
			atributosNoReferencia.add(nombreAtributo);

		}
		// anyadimos los atributos de referencia
		// Taking EReferences of the eClass
		/*
		 * for (EReference eReference : eClass.getEAllReferences()) { // String tipoE =
		 * tipoWrapper(eReference.getEType().getName());// obtenemos el tipo
		 * correspondiente en Java String nombreAtributo = eReference.getName();
		 * //String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el
		 * tipo correspondiente en Java
		 * 
		 * atributosReferencia.add(nombreAtributo);
		 * 
		 * }
		 */

		return atributosNoReferencia.contains(atributoAComprobar);
	}

	public boolean referenciaEsContainment(EClass eClass, String atributoAComprobar) {
		List<String> atributosReferencia = new ArrayList<String>();

		// System.out.println(" - EAttributes:");
		// Si se trata de una eClass,

		// anyadimos los atributos de referencia
		// Taking EReferences of the eClass
		for (EReference eReference : eClass.getEAllReferences()) {
			// String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el
			// tipo correspondiente en Java
			String nombreAtributo = eReference.getName();
			// String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el
			// tipo correspondiente en Java

			if (eReference.isContainment()) {
				atributosReferencia.add(nombreAtributo);
			}

		}

		return atributosReferencia.contains(atributoAComprobar);
	}
	
	public boolean claseEsContainment(EClass eClass, List<EClassifier> elements) {
		List<String> atributosReferencia = new ArrayList<String>();
		Boolean isContainment = false;
		
		// System.out.println(" - EAttributes:");
		// Si se trata de una eClass,

		// anyadimos los atributos de referencia
		// Taking EReferences of the eClass

		for (EClassifier classifier : elements) {
			// Taking the EClass elements
			if (classifier instanceof EClass) {

				EClass eClassReviewing = (EClass) classifier;

				// if (!eClassReviewing.isAbstract()) { // si la clase no es abstracta

				for (EReference referenciaOtraClase : eClassReviewing.getEAllReferences()) {
					String tipoE = referenciaOtraClase.getEType().getName();// obtenemos el tipo correspondiente
																			// en Java

					if (tipoE == eClass.getName()) {// Soy referencia
						// anyadir integer

						if (referenciaOtraClase.isContainment()) { // Si es upper bound = 1 metemos la
																	// referencia
							isContainment=true;

						}
					}
				}

				// }// si la clase no es abstracta
			}
		}


		return isContainment;
	}
	

	public LinkedHashMap<String, String> devuelveAtributosJava(EClass eClass) {
		LinkedHashMap<String, String> atributosJava = new LinkedHashMap<>();

		// nombreAtributo, ListaSi
		// NombreAtributo, ListaNo

		atributosJava.put("id", "ListaNo");

		// System.out.println(" - EAttributes:");
		// Si se trata de una eClass,

		// anyadimos los atributos de clase
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {

			// correspondiente
			// en Java
			String nombreAtributo = eAttribute.getName();

			if (eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) {// nos fijamos en el upperbound
																						// para saber si es atributo o
																						// lista

				atributosJava.put(nombreAtributo, "ListaSi");
				/*
				 * try { myWriter.write("\t" +"private List<" +tipoE+ "> " + nombreAtributo +
				 * ";\n");
				 * 
				 * 
				 * 
				 * } catch (IOException e) { System.out.println("An error occurred.");
				 * e.printStackTrace(); }
				 */
			} else { // si no es una lista
				atributosJava.put(nombreAtributo, "ListaNo");

			}
		}
		// anyadimos los atributos de referencia
		// Taking EReferences of the eClass
		for (EReference eReference : eClass.getEAllReferences()) {
			// String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el
			// tipo correspondiente en Java
			String nombreAtributo = eReference.getName();

			if (eReference.getUpperBound() == -1 || eReference.getUpperBound() >= 2) {// nos fijamos en el upperbound
																						// para saber si es atributo o
																						// lista

				atributosJava.put(nombreAtributo, "ListaSi");

			} else {
				atributosJava.put(nombreAtributo, "ListaNo");

			}
		}

		return atributosJava;
	}

	public LinkedHashMap<String, String> devuelveAtributosTablaArrayPrimitivo(String nombreTabla,
			List<EClassifier> elements) {
		return null;

		/*
		 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
		 * "School_id int NOT NULL," + "nEstudiantes INT," +
		 * "FK abreviado (School_id) REFERENCES School(id) ON DELETE CASCADE," +
		 * "PRIMARY KEY (id)" + ");";//COMENT
		 */

		/* Solo hay que hacer un split del _ */
		/*
		 * Coger de la clase (la primera parte del split) Recorrer sus eattributes y ver
		 * que el eattribute.getname sea igual a la segunda parte del split
		 * 
		 * Devuelves entonces el id int porque lo tienen todas las tablas Devuelves el
		 * id_nombreDeLaClase Devuelves el nombre de la variable (split[1]) y el tipo
		 * que es un eattribute.getType viendo si lo parseamos
		 */

	}

	public LinkedHashMap<String, String> devuelveAtributosTablaClaseRelacionNM(String nombreTabla,
			List<EClassifier> elements) {
		return null;

	}

	public String tipoWrapper(String tipoAEvaluar) {
		String tipoADevolver = "";
		switch (tipoAEvaluar) {

		case "short":
			tipoADevolver = "Short";
			break;

		case "int":

			tipoADevolver = "Integer";
			break;

		case "long":

			tipoADevolver = "Long";
			break;

		case "float":

			tipoADevolver = "Float";
			break;

		case "double":

			tipoADevolver = "Double";
			break;

		case "char":

			tipoADevolver = "Character";
			break;

		case "boolean":

			tipoADevolver = "Boolean";
			break;

		case "Date":

			tipoADevolver = "java.sql.Date";
			break;
		default:

			tipoADevolver = tipoAEvaluar;
		}

		return tipoADevolver;
	}

	public List<String> ordenaClases(List<String> clases) {

		List<String> clasesAOrdenar = clases;

		Collections.sort(clasesAOrdenar);

		return clasesAOrdenar;

	}

	public String getAtributoParaInserts(String tipoAEvaluar) {
		
		System.out.println("Entra al inserts " +tipoAEvaluar );
		
		String tipoADevolver = "";
		switch (tipoAEvaluar) {

		case "String":
			tipoADevolver = "String";
			break;

		case "short":
			tipoADevolver = "Short";
			break;

		case "int":

			tipoADevolver = "Integer";
			break;

		case "long":

			tipoADevolver = "Long";
			break;

		case "float":

			tipoADevolver = "Float";
			break;

		case "Date":

			tipoADevolver = "java.sql.Date";
			break;

		case "double":

			tipoADevolver = "Double";
			break;

		case "char":

			tipoADevolver = "Character";
			break;

		case "boolean":

			tipoADevolver = "Boolean";
			break;

		default:

			tipoADevolver = "Integer";
		}
		System.out.println("Sale un " +tipoADevolver );


		
		return tipoADevolver;
	}

	public String tipoEcoreATipoSQL(String tipoEcore) {
		String tipoSQL = "";
		switch (tipoEcore) {
		case "boolean":
			tipoSQL = "BOOLEAN";
			break;

		case "String":
			tipoSQL = "VARCHAR(255)";
			break;

		case "java.sql.Date":

			tipoSQL = "DATE";
			break;

		case "double":

			tipoSQL = "DOUBLE";
			break;

		case "long":

			tipoSQL = "INT8";
			break;
			
		case "int":

			tipoSQL = "INT";
			break;
			
		case "float":

			tipoSQL = "DECIMAL(4,2)";
			break;
		case "short":

			tipoSQL = "SMALLINT";
			break;

		case "char":
			tipoSQL = "char(1)";
			break;
			
		default:
			tipoSQL = tipoEcore;
		}

		return tipoSQL;
	}

	public String tipoJavaATipoGetResult(String tipoJava) {
		System.out.println("BUSCANDO TIPO:  " + tipoJava);
		String tipoGetResult = "";
		switch (tipoJava) {

		case "Boolean":
			tipoGetResult = "getBoolean";
			break;

		case "String":

			tipoGetResult = "getString";
			break;

		case "java.sql.Date":

			tipoGetResult = "getDate";
			break;

		case "Double":

			tipoGetResult = "getDouble";
			break;

		case "Long":

			tipoGetResult = "getLong";
			break;

		case "Integer":

			tipoGetResult = "getInt";
			break;

		case "Float":

			tipoGetResult = "getFloat";
			break;

		case "Short":

			tipoGetResult = "getShort";
			break;

		default:

			tipoGetResult = "getString";
		}

		return tipoGetResult;
	}
//myWriter.write("\t\tpreparedStatement.setString");
	public String tipoJavaATipoSetResult(String tipoJava) {
		String tipoGetResult = "";
		switch (tipoJava) {

		case "Boolean":
			tipoGetResult = "setBoolean";
			break;

		case "String":

			tipoGetResult = "setString";
			break;

		case "java.sql.Date":

			tipoGetResult = "setDate";
			break;

		case "Double":

			tipoGetResult = "setDouble";
			break;

		case "Long":

			tipoGetResult = "setLong";
			break;

		case "Integer":

			tipoGetResult = "setInt";
			break;

		case "Float":

			tipoGetResult = "setFloat";
			break;

		case "Short":

			tipoGetResult = "setShort";
			break;

		default:

			tipoGetResult = "setString";
		}

		return tipoGetResult;
	}
	
	public String casteoEnFuncionDelTipo(String tipoJava) {
		String tipoGetResult = "";
		switch (tipoJava) {

		case "Boolean":
			tipoGetResult = "Boolean.valueOf(";
			break;

		case "boolean":
			tipoGetResult = "Boolean.valueOf(";
			break;

			
		case "java.sql.Date":

			tipoGetResult = "java.sql.Date.valueOf(";
			break;

		case "Date":

			tipoGetResult = "java.sql.Date.valueOf(";
			break;
		case "Double":

			tipoGetResult = "Double.valueOf(";
			break;

		case "double":

			tipoGetResult = "Double.valueOf(";
			break;
		case "Long":

			tipoGetResult = "Long.valueOf(";
			break;

		case "long":

			tipoGetResult = "Long.valueOf(";
			break;
		case "Integer":

			tipoGetResult = "Integer.valueOf(";
			break;
		case "int":

			tipoGetResult = "Integer.valueOf(";
			break;


		case "Float":

			tipoGetResult = "Float.valueOf(";
			break;
		case "float":

			tipoGetResult = "Float.valueOf(";
			break;

		case "Short":

			tipoGetResult = "Short.valueOf(";
			break;

		case "short":

			tipoGetResult = "Short.valueOf(";
			break;

		default:

			tipoGetResult = "";
		}

		return tipoGetResult;
	}
	
	public String cierraCasteoEnFuncionDelTipo(String tipoJava) {
		String tipoGetResult = "";
		switch (tipoJava) {

		case "Boolean":
			tipoGetResult = ")";
			break;

		case "boolean":
			tipoGetResult = ")";
			break;

			
		case "java.sql.Date":

			tipoGetResult = ")";
			break;

		case "Date":

			tipoGetResult = ")";
			break;
		case "Double":

			tipoGetResult = ")";
			break;

		case "double":

			tipoGetResult = ")";
			break;
		case "Long":

			tipoGetResult = ")";
			break;

		case "long":

			tipoGetResult = ")";
			break;
		case "Integer":

			tipoGetResult = ")";
			break;
		case "int":

			tipoGetResult = ")";
			break;


		case "Float":

			tipoGetResult = ")";
			break;
		case "float":

			tipoGetResult = ")";
			break;

		case "Short":

			tipoGetResult = ")";
			break;

		case "short":

			tipoGetResult = ")";
			break;

		default:

			tipoGetResult = "";
		}

		return tipoGetResult;
	}
	
	/*
	 * public String tipoSQLATipoJava(String tipoSQL) { String tipoJava = ""; switch
	 * (tipoSQL) {
	 * 
	 * case "BOOLEAN": break;
	 * 
	 * case "VARCHAR":
	 * 
	 * tipoJava = "String"; break;
	 * 
	 * case "DATE":
	 * 
	 * tipoJava = "java.sql.Date"; break;
	 * 
	 * case "DOUBLE PRECISION":
	 * 
	 * tipoJava = "double"; break;
	 * 
	 * case "INT8":
	 * 
	 * tipoJava = "long"; break;
	 * 
	 * case "INT":
	 * 
	 * tipoJava = "int"; break;
	 * 
	 * case "SMALLFLOAT":
	 * 
	 * tipoJava = "float"; break;
	 * 
	 * case "SMALLINT":
	 * 
	 * tipoJava = "short"; break;
	 * 
	 * default:
	 * 
	 * tipoJava = "VARCHAR"; } return tipoJava; }
	 */

	public void crearConstructor(EClass eClass, String nombreFichero) {

		// Hacer creacion de fichero .java
		// Hacer bucle imports
		// Ver que tipos son clases y que tipos son tipos primitivos para hacer los
		// imports corrrespondientes
		// System.out.println(" - EAttributes:");
		// Si se trata de una eClass,

		boolean hayListaPorLoQueHayException = false;
		if (!eClass.isAbstract()) {// Si no abstracta

			// CREACION CONSTRUCTOR si la clase no es abstracta

			try {
				FileWriter myWriter = new FileWriter(nombreFichero, true);
				myWriter.write("\n\t" + eClass.getName() + "(");
				myWriter.close();

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			////////////////////////////////

			// MIrar si es mas de uno para saber si poner comas
			//
			int nAtributos = 0;
			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				if (eAttribute.getLowerBound() >= 1)/* Si hay que poner alguno, aumentamos numero de atributos */
					nAtributos++;
			}
			for (EReference eReference : eClass.getEAllReferences()) {
				if (eReference.getLowerBound() >= 1)
					nAtributos++;
			}

			int nAtributosImpresosPorImprimir = nAtributos;

			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				if (eAttribute.getLowerBound() >= 1) {
					String tipoE = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());// obtenemos el
																											// tipo
																											// correspondiente
																											// en Java
					String nombreAtributo = eAttribute.getName();

					// System.out.println("\n\nBUCLE Atrib: " + nombreAtributo + " ");///////////

					/**/

					// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
					// metodo, por ejemplo getName
					String nombreAtributoMayus = "";
					String firstLtr = nombreAtributo.substring(0, 1);
					String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

					// ponemos mayuscula la primera letra
					firstLtr = firstLtr.toUpperCase();
					// concatenamos
					nombreAtributoMayus = firstLtr + restLtrs;

					/**/
					if (eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) {// nos fijamos en el
																								// upperbound para saber
																								// si es atributo o
																								// lista

						try {
							hayListaPorLoQueHayException = true;
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write("List<" + tipoE + ">" + " " + "c" + nombreAtributoMayus);
							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					} else {// NO ES UNA LISTA
							// priteamos el tipo de atributo y su nombre
						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write(tipoE + " " + "c" + nombreAtributoMayus);
							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					}
					// Hemos escrito un atributo asi que disminuimos el num de atributos por
					// imprimir
					nAtributosImpresosPorImprimir--;

					if (nAtributosImpresosPorImprimir > 0) { // Anyadir la coma para el siguiente atributo
						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write(", ");
							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					}
				}
			}

			// anyadimos los atributos de referencia
			// Taking EReferences of the eClass
			for (EReference eReference : eClass.getEAllReferences()) {

				if (eReference.getLowerBound() >= 1) {// miramos si se requiere en el constructor

					String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en
																				// Java

					String nombreAtributo = eReference.getName();

					// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
					// metodo, por ejemplo getName
					String nombreAtributoMayus = "";
					String firstLtr = nombreAtributo.substring(0, 1);
					String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

					// ponemos mayuscula la primera letra
					firstLtr = firstLtr.toUpperCase();
					// concatenamos
					nombreAtributoMayus = firstLtr + restLtrs;

					/**/

					// priteamos el tipo de atributo y su nombre

					if (eReference.getUpperBound() == -1 || eReference.getUpperBound() >= 2) {// si es lista
						hayListaPorLoQueHayException = true;
						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write("List<" + tipoE + ">" + " c" + nombreAtributoMayus);
							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					} else {// Si no es lista
						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write(tipoE + "c" + nombreAtributoMayus);
							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					}

					// System.out.println("\n\nBUCLE Referencias: " + nombreAtributo + " ");

					// priteamos el tipo de atributo y su nombre

					nAtributosImpresosPorImprimir--;

					if (nAtributosImpresosPorImprimir > 0) { // Anyadir la coma para el siguiente atributo
						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write(", ");
							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}

					}

				}

			}

			try {
				FileWriter myWriter = new FileWriter(nombreFichero, true);

				if (hayListaPorLoQueHayException) {
					myWriter.write(") throws Exception {\n");
				} else {

					myWriter.write(") {\n");

				}

				myWriter.close();

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

			/* Ahora hacemos la asignacion de las variables */
			/************************/

			for (EAttribute eAttribute : eClass.getEAllAttributes()) {// ASIGNACION VARIABLES ATRIBUTOS

				String nombreAtributo = eAttribute.getName();
				String tipoE = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());// obtenemos el
																										// tipo
																										// correspondiente
																										// en Java

				/**/
				// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
				// metodo, por ejemplo getName
				String nombreAtributoMayus = "";
				String firstLtr = nombreAtributo.substring(0, 1);
				String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

				// ponemos mayuscula la primera letra
				firstLtr = firstLtr.toUpperCase();
				// concatenamos
				nombreAtributoMayus = firstLtr + restLtrs;

				if (eAttribute.getLowerBound() >= 1) {// si es obligatorio que este en el constructor

					/**/
					// Hacer un caso distinto para cuando la lista tiene upperbound de -1, en el que
					// el if no tenga comprobacion de limite por arriba, si no solo por abajo
					if (eAttribute.getUpperBound() == -1) {// Si es una lista y no tiene limite, no comprobamos el
															// limite superior
						String listaEntrada = "c" + nombreAtributoMayus;
						// COmprobar que la lista sea minimo el lower bound y maximo el upperbound. Si
						// no lo es, se lanza excepcio
						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write("\t\tif (" + listaEntrada + ".size() < " + eAttribute.getLowerBound() + ")");
							myWriter.write("\n\t\t\tthrow new Exception(\"Tamano de la lista no adecuado.\");\n\n");
							myWriter.write(
									"\t\t" + "this." + nombreAtributo + " = " + "c" + nombreAtributoMayus + ";\n");

							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}

					} else if (eAttribute.getUpperBound() >= 2) {// Si es una lista y tiene limite superior, comprobamos
																	// que no sea mayor que este y que el limite
																	// inferior si lo tiene

						String listaEntrada = "c" + nombreAtributoMayus;

						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write("\t\tif (" + listaEntrada + ".size() < " + eAttribute.getLowerBound() + "|| "
									+ listaEntrada + ".size()" + ">" + eAttribute.getLowerBound() + ")");
							myWriter.write("\n\t\t\tthrow new Exception(\"Tamano de la lista no adecuado.\");\n");
							myWriter.write(
									"\t\t" + "this." + nombreAtributo + " = " + "c" + nombreAtributoMayus + ";\n");

							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					} else {// Tira perfect

						// priteamos el tipo de atributo y su nombre
						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write(
									"\t\t" + "this." + nombreAtributo + " = " + "c" + nombreAtributoMayus + ";\n");
							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					}
				} else if (eAttribute.getLowerBound() == 0) {// Si es 0, tenemos que inicializar las listas
					if (eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) {// Si es una lista
						// nombre = new ArrayList<Integer> ();
						// "private List<" +tipoE+ "> " + nombreAtributo + ";")
						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write("\t\t" + "this." + nombreAtributo + " = " + "new ArrayList <" + tipoE + ">"
									+ "();\n");
							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}

					}
				}
			}

			// anyadimos los atributos de referencia
			// Taking EReferences of the eClass
			for (EReference eReference : eClass.getEAllReferences()) {// ASIGNACION VARIABLES REFERENCIAS

				String nombreAtributo = eReference.getName();
				String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java

				// System.out.println("\n\nBUCLE Referencias: " + nombreAtributo + " ");

				// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
				// metodo, por ejemplo getName
				String nombreAtributoMayus = "";
				String firstLtr = nombreAtributo.substring(0, 1);
				String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

				// ponemos mayuscula la primera letra
				firstLtr = firstLtr.toUpperCase();
				// concatenamos
				nombreAtributoMayus = firstLtr + restLtrs;

				if (eReference.getLowerBound() >= 1) {

					// Hacer un caso distinto para cuando la lista tiene upperbound de -1, en el que
					// el if no tenga comprobacion de limite por arriba, si no solo por abajo
					if (eReference.getUpperBound() == -1) {// Si es una lista y no tiene limite, no comprobamos el
															// limite superior
						String listaEntrada = "c" + nombreAtributoMayus;
						// COmprobar que la lista sea minimo el lower bound y maximo el upperbound. Si
						// no lo es, se lanza excepcio
						// nombre = new ArrayList<Integer> ();

						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write(
									"\n\t\tif (" + listaEntrada + ".size() < " + eReference.getLowerBound() + ")\n");
							myWriter.write("\t\t\tthrow new Exception(\"Tamano de la lista no adecuado.\");\n\n");
							myWriter.write(
									"\t\t" + "this." + nombreAtributo + " = " + "c" + nombreAtributoMayus + ";\n");

							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}

					} else if (eReference.getUpperBound() >= 2) {// Si es una lista y tiene limite superior, comprobamos
																	// que no sea mayor que este y que el limite
																	// inferior si lo tiene

						String listaEntrada = "c" + nombreAtributoMayus;

						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);
							myWriter.write("\n\t\tif (" + listaEntrada + ".size() < " + eReference.getLowerBound()
									+ "|| " + listaEntrada + ".size()" + ">" + eReference.getLowerBound() + ")");
							myWriter.write("\n\t\t\tthrow new Exception(\"Tamano de la lista no adecuado.\");\n");
							myWriter.write(
									"\t\t" + "this." + nombreAtributo + " = " + "c" + nombreAtributoMayus + ";\n");

							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					}

					// priteamos el tipo de atributo y su nombre

					// System.out.println("\t" + " this."+ nombreAtributo+" = "
					// +"c"+nombreAtributoMayus+ ";");

				} else if (eReference.getLowerBound() == 0) {// Si es 0, tenemos que inicializar las listas

					if (eReference.getUpperBound() == -1) {// Si no tiene limite superior, no le ponemos limite
						// nombre = new ArrayList<Integer> ();
						// "private List<" +tipoE+ "> " + nombreAtributo + ";")
						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);

							myWriter.write(
									"\t\t" + "this." + nombreAtributo + " = " + "new ArrayList<" + tipoE + ">" + "();");

							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					}

					else if (eReference.getUpperBound() >= 2) {// Si tiene limite superior, lo ponemos
						try {
							FileWriter myWriter = new FileWriter(nombreFichero, true);

							myWriter.write("\t\t" + "this." + nombreAtributo + " = " + "new ArrayList<" + tipoE + ">"
									+ "(" + eReference.getUpperBound() + ");");

							myWriter.close();

						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					}

				}

			}

			/************************/
			/* Fin de la asignacion de variables */
			try {
				FileWriter myWriter = new FileWriter(nombreFichero, true);
				myWriter.write("\n\t" + "}"); // Cerramos el constructor

				myWriter.close();

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		} /* Fin de la creacion del constructor */

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\n\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		/*
		 * CREACION DE M�TODOS PARA CREAR Y DESTRUIR OBJETOS DE LAS REFERENCIAS DESDE LA
		 * CLASE SI CONTAINMENT = TRUE
		 */
		/* Fin de lectura de los elementos */

		// AHORA CREAMOS UN CONSTRUCTOR CON LOS LOWER BOUNDS = 0

	}

	public boolean tienenRelacionNM(EClass eclass1, EClass eclass2) {

		boolean eclass1EsRelacionNConEclass2 = false;
		boolean eclass2EsRelacionMConEclass1 = false;

		for (EReference eReference : eclass1.getEAllReferences()) {// ASIGNACION VARIABLES REFERENCIAS

			// String nombreAtributo = eReference.getName();
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java

			// System.out.println("\n\nBUCLE Referencias: " + nombreAtributo + " ");

			// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
			// metodo, por ejemplo getName
			// String nombreAtributoMayus = "";
			// String firstLtr = nombreAtributo.substring(0, 1);
			// String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			// firstLtr = firstLtr.toUpperCase();
			// concatenamos
			// nombreAtributoMayus = firstLtr + restLtrs;

			if (tipoE == eclass2.getName()) { // la referencia es del tipo de la clase
				if (eReference.getUpperBound() == -1 || eReference.getUpperBound() >= 2) {

					// se cumple la primera condicion
					eclass1EsRelacionNConEclass2 = true;

				}

			}
		}

		for (EReference eReference : eclass2.getEAllReferences()) {// ASIGNACION VARIABLES REFERENCIAS

			// String nombreAtributo = eReference.getName();
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java

			// System.out.println("\n\nBUCLE Referencias: " + nombreAtributo + " ");

			// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
			// metodo, por ejemplo getName
//			String firstLtr = nombreAtributo.substring(0, 1);
//			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			// firstLtr = firstLtr.toUpperCase();
			// concatenamos
//			String nombreAtributoMayus = firstLtr + restLtrs;

			if (tipoE == eclass1.getName()) { // la referencia se llama como la clase
				if (eReference.getUpperBound() == -1 || eReference.getUpperBound() >= 2) {

					// se cumple la primera condicion
					eclass2EsRelacionMConEclass1 = true;

				}

			}
		}

		/*
		 * if (eclass1EsRelacionNConEclass2 && eclass2EsRelacionMConEclass1) {
		 * 
		 * System.out.println("ESTAS DOS CLASES TIENEN RELACION N-M: "
		 * +eclass1.getName() + " y "+eclass2.getName());
		 * 
		 * } else {
		 * 
		 * System.out.println("ESTAS DOS CLASES NOOO TIENEN RELACION N-M: "
		 * +eclass1.getName() + " y "+eclass2.getName());
		 * 
		 * 
		 * }
		 * 
		 * 
		 */

		return eclass1EsRelacionNConEclass2 && eclass2EsRelacionMConEclass1;

	}

	public LinkedHashMap<String, String> crearTablaEnDDBB(EClass eClass, String nombreFichero, String nombreClase,
			List<EClassifier> cElements, List<String> clasesRecorridas, LinkedHashMap<String, String> tablasCreadas) {
		// String SAL= "sadas"
		// + ""

		List<EClassifier> elements = cElements;
		LinkedHashMap<String, Boolean> clasesReferencia = new LinkedHashMap<>(); 

		try {
			// creamos la funcion y creamos la sentencia sql
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\n\tpublic boolean createTable" + eClass.getName()
					+ "(Connection connection) throws SQLException {\n");
			// anyadimos la tabla de la clase
			tablasCreadas.put(eClass.getName(), "siEsPrincipal");// Anyadimos la tabla creada para llevar el seguimiento
			myWriter.write("\n\t\tString sql = \"create table " + eClass.getName() + "(\"\n");
			myWriter.write("\t\t + \"id int  NOT NULL AUTO_INCREMENT," + "\"\n");

			myWriter.close();
		} catch (IOException e) {
			System.out
					.println("Error al introducir la tabla " + eClass.getName() + " la conexion con la base de datos.");
			e.printStackTrace();
			return null;

		}

		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			String tipo = eAttribute.getEType().getInstanceClass().getSimpleName();// obtenemos el tipo
																					// correspondiente en Java
			String nombreAtributo = eAttribute.getName();

			String tipoCambiadoDeJavaASQL = tipoEcoreATipoSQL(tipo);

			if (eAttribute.getUpperBound() == 1) {

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);

					myWriter.write("\t\t + \"" + nombreAtributo + " " + tipoCambiadoDeJavaASQL);

					myWriter.close();

				} catch (IOException e) {
					System.out.println("Error el atributo con upperbound 1");
					e.printStackTrace();
				}

				if (eAttribute.getLowerBound() == 1) {
					try {
						FileWriter myWriter = new FileWriter(nombreFichero, true);

						myWriter.write(" NOT NULL");

						myWriter.close();

					} catch (IOException e) {
						System.out.println("Error el atributo con upperbound 1");
						e.printStackTrace();
					}
				}

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);

					myWriter.write("," + "\"\n");

					myWriter.close();

				} catch (IOException e) {
					System.out.println("Error el atributo con upperbound 1");
					e.printStackTrace();
				}
			} else {
			}
		} // FIN DE RECORRER EATTRIBUTES que no son tabla a parte

		for (EClassifier classifier : elements) {
			// Taking the EClass elements
			if (classifier instanceof EClass) {

				EClass eClassReviewing = (EClass) classifier;

				System.out.println("Chequeando si la clase " + eClass.getName() + " es referencia de "
						+ eClassReviewing.getName());

				// if (eClassReviewing.getName() != eClass.getName()) { // si no es la misma
				// clase

				System.out.println("El nombre es distinto asi que nice\n");

				// if (!eClassReviewing.isAbstract()) {
				for (EReference referenciaOtraClase : eClassReviewing.getEAllReferences()) {
					String tipoE = referenciaOtraClase.getEType().getName();// obtenemos el tipo correspondiente
																			// en Java

					System.out.println("Recorremos referencia: " + tipoE + "\n");

					if (tipoE == eClass.getName()) {// Soy referencia
						// anyadir integer
						System.out.println("YESSS La clase " + eClass.getName() + " es referencia de "
								+ eClassReviewing.getName());
						System.out.println("con upperbound = " + referenciaOtraClase.getUpperBound());
						if (referenciaOtraClase.isContainment()) { // siempre que sea containment metemos el id para el
																	// delete

							try {

								FileWriter myWriter = new FileWriter(nombreFichero, true);

								String nombreVariable = "id_" + eClassReviewing.getName() + "_"
										+ referenciaOtraClase.getName();

								myWriter.write("\t\t + \"" + nombreVariable + " INT ");
								clasesReferencia.put(nombreVariable, true);

								/*
								 * if (referenciaOtraClase.isContainment()) {
								 * clasesReferencia.put(nombreVariable, true); } else {
								 * clasesReferencia.put(nombreVariable, false); }
								 */

								myWriter.close();

							} catch (IOException e) {
								System.out.println("Error el atributo con upperbound 1");
								e.printStackTrace();
							}

							// Comprobamos si ese atributo debe ser not null
							/*
							 * if (referenciaOtraClase.getLowerBound() == 1 nunca ponemos not null porque
							 * para composicion lo miramos desde la interfaz ||
							 * referenciaOtraClase.isContainment()) { try { FileWriter myWriter = new
							 * FileWriter(nombreFichero, true);
							 * 
							 * myWriter.write("NOT NULL");
							 * 
							 * myWriter.close();
							 * 
							 * } catch (IOException e) {
							 * System.out.println("Error el atributo con upperbound 1");
							 * e.printStackTrace(); } }
							 */

							// Cerramos el atributo referencia
							try {
								FileWriter myWriter = new FileWriter(nombreFichero, true);

								myWriter.write("," + "\"\n");

								myWriter.close();

							} catch (IOException e) {
								System.out.println("Error el atributo con upperbound 1");
								e.printStackTrace();
							}

						} /*else { // si no es containemnt no metemos el id ya que
									// se crea una tabla

							try {

								FileWriter myWriter = new FileWriter(nombreFichero, true);

								String nombreVariable = "id_" + eClassReviewing.getName() + "_"
										+ referenciaOtraClase.getName();

								myWriter.write("\t\t + \"" + nombreVariable + " INT ");
								if (referenciaOtraClase.isContainment()) {
									clasesReferencia.put(nombreVariable, true);
								} else {
									clasesReferencia.put(nombreVariable, false);
								}
								myWriter.close();

							} catch (IOException e) {
								System.out.println("Error el atributo con upperbound 1");
								e.printStackTrace();
							}

							// Comprobamos si ese atributo debe ser not null


							// Cerramos el atributo referencia
							try {
								FileWriter myWriter = new FileWriter(nombreFichero, true);

								myWriter.write("," + "\"\n");

								myWriter.close();

							} catch (IOException e) {
								System.out.println("Error el atributo con upperbound 1");
								e.printStackTrace();
							}

							// fin tienenRelacionNM
							// }

						} */// fin del else (no es containemnt)

					}
				}

				// }

			}

		}

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\t\t + \"PRIMARY KEY (id) \"" + "\n");
			myWriter.write("\t\t + \");" + "\";" + "//COMENT\n\n");
			myWriter.write("\t\t System.out.println(sql);\n");
			myWriter.write("\t\tPreparedStatement preparedStatement = connection.prepareStatement(sql);\n");
			myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n\n");
			myWriter.write("\t\tif (rows == 0){\n");
			myWriter.write("\t\t\tSystem.out.println(\"tabla " + eClass.getName() + " creada...\");\n");
			myWriter.write("\t\t}\n");
			myWriter.write("\t\telse{\n");
			myWriter.write("\t\t\tSystem.out.println(\"Error al crear tabla " + eClass.getName() + "\");\n");
			myWriter.write("\t\t\treturn false;\n");
			myWriter.write("\t\t}\n ");
			myWriter.write("\n\t\treturn true;\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n\t}\n"); // Fin de la funcion

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}
		// Creamos funcion para las constraints

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n\tpublic boolean createTable" + eClass.getName()
					+ "Constraints(Connection connection) throws SQLException {\n");
			myWriter.write("\n\t\tList<String> constraints = new ArrayList<String>();\n \n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		int constraintsAnyadidas = 1;
		// inicio bucle for

		for (Map.Entry<String, Boolean> entry : clasesReferencia.entrySet()) {
			String nombreVariable = entry.getKey();
			Boolean esContenido = entry.getValue();

			// Cogemos la clase de la que es referencia
			String[] partes = nombreVariable.split("_");
			String nombreClaseDeLaQueEsContenedor = partes[1];

			if (esContenido == true) { // si es contenedor (contenido)
				try {

					FileWriter myWriter = new FileWriter(nombreFichero, true);

					// REFERENCIA: myWriter.write("\t\t + \"FOREIGN KEY (" + nombreVariable+ ")
					// REFERENCES "+ nombreClaseDeLaQueEsContenedor +"(id) ON DELETE CASCADE" +","+
					// "\"\n");

					myWriter.write("\t\t String sql" + constraintsAnyadidas + "=" + "\"ALTER TABLE " + eClass.getName()
							+ "\"\n");
					myWriter.write(
							"\t\t + \"" + " ADD CONSTRAINT "+nombreVariable+"fk_" + eClass.getName() + constraintsAnyadidas + "\"\n");
					myWriter.write("\t\t + \"" + " FOREIGN KEY (" + nombreVariable + ")" + "\"\n");
					myWriter.write("\t\t + \"" + " REFERENCES " + nombreClaseDeLaQueEsContenedor + "(id)" + "\"\n");
					myWriter.write("\t\t + \"" + " ON DELETE CASCADE" + "\"\n");
					myWriter.write("\t\t + \";" + "\";" + "//COMENT\n");

					myWriter.write("\t\tconstraints.add(sql" + constraintsAnyadidas + ");\n\n");

					myWriter.close();

				} catch (IOException e) {
					System.out.println("Error el atributo con upperbound 1");
					e.printStackTrace();
				}
				constraintsAnyadidas++;
			}

			/*
			 * else {// si no es contenedor (contenido) --> no se pone aqui ya que vamos a
			 * crear otra tabla try { FileWriter myWriter = new FileWriter(nombreFichero,
			 * true);
			 * 
			 * // REFERENCIA: myWriter.write("\t\t + \"FOREIGN KEY (" + nombreVariable+ ")
			 * // REFERENCES "+ nombreClaseDeLaQueEsContenedor +"(id),"+ "\"\n");
			 * 
			 * myWriter.write("\t\t String sql" + constraintsAnyadidas + "=" +
			 * "\"ALTER TABLE " + eClass.getName() + "\"\n"); myWriter.write( "\t\t + \"" +
			 * " ADD CONSTRAINT fk_" + eClass.getName() + constraintsAnyadidas + "\"\n");
			 * myWriter.write("\t\t + \"" + " FOREIGN KEY (" + nombreVariable + ")" +
			 * "\"\n"); myWriter.write("\t\t + \"" + " REFERENCES " +
			 * nombreClaseDeLaQueEsContenedor + "(id)" + "\"\n");
			 * myWriter.write("\t\t + \";" + "\";" + "//COMENT\n");
			 * 
			 * myWriter.write("\t\tconstraints.add(sql" + constraintsAnyadidas + ");\n\n");
			 * 
			 * myWriter.close();
			 * 
			 * } catch (IOException e) {
			 * System.out.println("Error el atributo con upperbound 1");
			 * e.printStackTrace(); } }
			 */
			// FK Abreviado(id_clase1), REFERENCES clase1(id) ON DELETE CASCADE,

			// constraintsAnyadidas++;
		}

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			// Fin bucle for que recorre constraints

			myWriter.write("\n\t\tfor (String constraint : constraints) {\r\n\n");

			myWriter.write("\t\t\t\tPreparedStatement preparedStatement = connection.prepareStatement(constraint);\n");
			myWriter.write("\t\t\t\tpreparedStatement.executeUpdate();\n");

			// myWriter.write("\t\t\t\tint rows = preparedStatement.executeUpdate();\n\n");
			// myWriter.write("\t\t\t\tif (rows == 0){\n");
			// myWriter.write("\t\t\t\t\tSystem.out.println(\"Constraint tabla N-M de " +
			// eClass.getName() +" anyadida...\");\n");
			// myWriter.write("\t\t\t\t}\n");
			// myWriter.write("\t\t\t\telse{\n");
			// myWriter.write("\t\t\t\t\tSystem.out.println(\"Error al anyadir constaint
			// tabla N-M de " + eClass.getName() + "\");\n");
			// myWriter.write("\t\t\t\t\treturn false;\n");
			// myWriter.write("\t\t\t\t}\n ");
			myWriter.write("\n\t\t\t}\n\n");

			myWriter.write("\n\t\treturn true;\n");
			myWriter.write("\n\t}\n\n");

			myWriter.close();
		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		//
		return tablasCreadas;

		// } // Fin si no es abstracta

		// return tablasCreadas;

	} // crearTablasDDBB o como sea

	public void crearConexionDB(EClass eClass, String nombreFichero) {

		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\n\tpublic Connection setConnectionToDB (String pName) throws Exception{");
			myWriter.write("\n\n\t\t" + "Connection connection = null;\n");

			myWriter.write("\t\n\t\t" + "try {\n");
			myWriter.write("\t\n\t\t\t\tClass.forName(\"com.mysql.cj.jdbc.Driver\"); " + "\n");
			myWriter.write("\t\t\t\tString dbURL = \"jdbc:mysql://localhost:3306/jdbcdb\";" + "\n");
			myWriter.write("\t\t\t\tString username = \"root\";\n");
			myWriter.write("\t\t\t\tString password = \"root\";\n");
			myWriter.write("\t\t\t\tconnection = DriverManager.getConnection(dbURL,username, password);" + "\n");
			myWriter.write("\n\t\t\t\t}catch(Exception e){" + "\n");
			myWriter.write("\t\t\t\t\tthrow new RuntimeException(\"Error en la creacion de conexion\");" + "\n");

			myWriter.write("\t\t\t\t}" + "\n");
			myWriter.write("\n\t\treturn connection;\n");

			myWriter.write("\t}" + "\n");
			myWriter.close();
		} catch (IOException e) {
			System.out.println("Error al crear la conexion con la base de datos.");
			e.printStackTrace();
		}

	}

	// TODO:HERENCIA
	// TODO:CONTAINMENT TRUE AGREGAR Y ELIMINAR

	public void crearGetters(EClass eClass, String nombreFichero, String nombreClase) {

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public Integer" + " " + "getId(){\n");
			myWriter.write("\t\t" + " return id" + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// GEtters para atributos
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			String tipo = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());

			// Fin de comprobacion de si el atributo es heredado o no
			String nombreAtributo = eAttribute.getName();
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();
			// concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;


			if (eAttribute.getUpperBound() == 1) {

					escribirEnFichero("\t" + "@Override\n", nombreFichero);
					escribirEnFichero("\t" + "public " + tipo + " " + "get" + nombreAtributoMayus + " () {\n", nombreFichero);
					escribirEnFichero("\t\t" + " return " + nombreAtributo + ";", nombreFichero);
					escribirEnFichero("\n\t" + "}\n",nombreFichero);


			} else if (eAttribute.getUpperBound() >= 2 || eAttribute.getUpperBound() == -1) {// Listas

					escribirEnFichero("\t" + "@Override\n", nombreFichero);
					escribirEnFichero("\t" + "public " + "List<" + tipo + "> " + "get" + nombreAtributoMayus + "() {\n", nombreFichero);
					escribirEnFichero("\t\t" + " return " + nombreAtributo + ";", nombreFichero);
					escribirEnFichero("\n\t" + "}\n",nombreFichero);

			}

		}

		for (EReference eReference : eClass.getEAllReferences()) {
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java

			// Comprobacion si el atributo es heredado o no para poner @override
			EClass clase = eClass;
			String nombreDeLaReferencia = eReference.getName();
			EStructuralFeature featurePropio = clase.getEStructuralFeature(nombreDeLaReferencia);
			boolean esHeredado = false;

			if (featurePropio instanceof EReference) {
				for (EClass superclase : clase.getESuperTypes()) {
					EStructuralFeature featureHeredado = superclase.getEStructuralFeature(nombreDeLaReferencia);
					if (featureHeredado != null && featureHeredado instanceof EReference) {
						esHeredado = true;
						break;
					}
				}

			} else {
				// No se encontró una EReference con el nombre especificado en la clase.
			}
			// Fin de comprobacion de si el atributo es heredado o no

			// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
			// metodo, por ejemplo getName
			String nombreAtributo = eReference.getName();
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();
			// concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;
			if (eReference.getUpperBound() == 1) {

				try {

					FileWriter myWriter = new FileWriter(nombreFichero, true);
					myWriter.write("\t" + "@Override\n");

					myWriter.write("\t" + "public " + tipoE + " get" + nombreAtributoMayus + " () {\n");
					myWriter.write("\t\t" + " return " + nombreAtributo + ";");
					myWriter.write("\n\t" + "}\n");
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

			} else if (eReference.getUpperBound() >= 2 || eReference.getUpperBound() == -1) {// Habra que anyadir List

				try {

					FileWriter myWriter = new FileWriter(nombreFichero, true);

					// Se escribe override siempre porque sobreescribe a la interfaz o a los metodos
					// de padres
					myWriter.write("\t" + "@Override\n");

					myWriter.write("\t" + "public " + "List<" + tipoE + "> " + "get" + nombreAtributoMayus + " () {\n");
					myWriter.write("\t\t" + " return " + nombreAtributo + ";");
					myWriter.write("\n\t" + "}\n");
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			} else {
				// System.out.println("ERROR con el upperbound del atributo " + nombreAtributo);
			}

		}
	}

	public void crearGettersInterfaces(EClass eClass, String nombreFichero, String nombreClase) {

		// Getters para atributos
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			String tipo = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());

			// Comprobacion si el atributo es heredad
			EClass clase = eClass;
			String nombreDelAtributo = eAttribute.getName();
			EStructuralFeature featurePropio = clase.getEStructuralFeature(nombreDelAtributo);
			boolean esHeredado = false;

			if (featurePropio instanceof EAttribute) {
				for (EClass superclase : clase.getESuperTypes()) {
					EStructuralFeature featureHeredado = superclase.getEStructuralFeature(nombreDelAtributo);
					if (featureHeredado != null && featureHeredado instanceof EAttribute) {
						esHeredado = true;
						break;
					}
				}
			} 
			// Fin de comprobacion de si el atributo es heredado o no

			String nombreAtributo = eAttribute.getName();
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();
			// concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;

			if (eAttribute.getUpperBound() == 1) {

				try {
					if (!esHeredado) { // Solo escribimos el metodo si es propio
						FileWriter myWriter = new FileWriter(nombreFichero, true);
						myWriter.write("\n\t" + tipo + " " + "get" + nombreAtributoMayus + " ();\n");
						myWriter.close();
					}

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

			} else if (eAttribute.getUpperBound() >= 2 || eAttribute.getUpperBound() == -1) {// Habra que anyadir List

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);

					if (!esHeredado) {
						myWriter.write("\n\t" + "List<" + tipo + "> " + "get" + nombreAtributoMayus + "();");
						myWriter.close();
					}
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}

		}

		// AHORA los de getters con atributos de referencia
		// Taking EReferences of the eClass

		for (EReference eReference : eClass.getEAllReferences()) {
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java

			// Comprobacion si el atributo es heredado o no para poner @override
			EClass clase = eClass;
			String nombreDeLaReferencia = eReference.getName();
			EStructuralFeature featurePropio = clase.getEStructuralFeature(nombreDeLaReferencia);
			boolean esHeredado = false;

			if (featurePropio instanceof EReference) {
				for (EClass superclase : clase.getESuperTypes()) {
					EStructuralFeature featureHeredado = superclase.getEStructuralFeature(nombreDeLaReferencia);
					if (featureHeredado != null && featureHeredado instanceof EReference) {
						esHeredado = true;
						break;
					}
				}

			} else {
				// No se encontró una EReference con el nombre especificado en la clase.
			}
			// Fin de comprobacion de si el atributo es heredado o no

			// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
			// metodo, por ejemplo getName
			String nombreAtributo = eReference.getName();
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();
			// concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;
			if (eReference.getUpperBound() == 1) {

				try {

					FileWriter myWriter = new FileWriter(nombreFichero, true);
					if (!esHeredado) {
						myWriter.write("\n\t" + tipoE + " get" + nombreAtributoMayus + " ();\n");
						myWriter.close();
					}
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

			} else if (eReference.getUpperBound() >= 2 || eReference.getUpperBound() == -1) {// Habra que anyadir List

				try {

					FileWriter myWriter = new FileWriter(nombreFichero, true);

					if (!esHeredado) {

						myWriter.write("\n\t" + "List<" + tipoE + "> " + "get" + nombreAtributoMayus + "();\n");

						myWriter.close();
					}
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}

		}

	}

	public void crearReadDBPorAtributo(EClass eClass, String nombreFichero, String nombreClase,
			List<EClassifier> cElements) {

		LinkedHashMap<String, String> tipoAtributoYNombreAtributoList = new LinkedHashMap<String, String>();

		int nAtributosCreados = 0;
		ArrayList<String> atributosRecogidos = new ArrayList<String>();
		// Creamos el metodo para buscar por el atributo
		tipoAtributoYNombreAtributoList = devuelveAtributosTablaClase(eClass, cElements);

		for (String nombreVariable : tipoAtributoYNombreAtributoList.keySet()) {

			// nombre de la variable -> i
			// tipo -> tipoAtributoYNombreAtributoList.get(i)

			// String tipo = eAttribute.getEType().getInstanceClass().getSimpleName();//
			// obtenemos el tipo correspondiente
			String tipo = tipoAtributoYNombreAtributoList.get(nombreVariable);// obtenemos el tipo correspondiente
			
			System.out.println("ANTES DE ENTRAR AL GETT - Variable: "  + nombreVariable + " Tipo - " + tipo);
			
			// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
			// metodo, por ejemplo getName
			String nombreAtributo = nombreVariable;
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();
			// concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;

			// Creamos el metodo para buscar por el atributo

			// Se hace un read por cada uno de los atributos para buscar por un atributo
			// dado
			try {

				FileWriter myWriter = new FileWriter(nombreFichero, true);
				myWriter.write("\n\tpublic List<" + nombreClase + "> searchBy" + nombreAtributoMayus
						+ "(Connection connection, " + "String valorAtributo) throws SQLException {\n");
				myWriter.write(
						"\t\tList<" + nombreClase + "> variableRetorno = new ArrayList<" + nombreClase + ">(); \n");

				myWriter.write("\t\tString sql = \"select * from " + nombreClase + " where " + nombreAtributo
						+ " = " + "?" + "\";" + "\n");
				myWriter.write("\t\tPreparedStatement preparedstatement = connection.prepareStatement(sql);\n");
				
				myWriter.write("\t\tpreparedstatement.setString(1,valorAtributo);\n");
				myWriter.write("\t\tResultSet result = preparedstatement.executeQuery();\n");
				myWriter.write("\t\twhile(result.next()) {\n");

				// PREGUNTAR A SARA C�MO MOSTRAMOS LOS VALORES
				// Recorrer todos los valores de la clase

				int nVariablesAEscribir = tipoAtributoYNombreAtributoList.size();
				int variablesEscritas = 0;
				myWriter.write("\t\t\t" + nombreClase + " s = new " + nombreClase + "();\n\n");
				// int nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size();
				for (String i : tipoAtributoYNombreAtributoList.keySet()) {
					// i es el nombre de la variable
					String nombreVariableBucle = i;
					String tipoAtributo = tipoAtributoYNombreAtributoList.get(i);
					// lo otro el valor
					String getResultAUtilizar = tipoJavaATipoGetResult(tipoAtributoYNombreAtributoList.get(i));
					// aqui hay que printear el id por lo que no ponemos el if que lo evita
					myWriter.write("\t\t\t" + tipoAtributoYNombreAtributoList.get(i) + " variable" + variablesEscritas
							+ " = result." + getResultAUtilizar + "(\"" + i + "\")");
					System.out.println("SE IMPRIME ("+tipoAtributo+"):\n");
					System.out.println("\t\t\t" + tipoAtributoYNombreAtributoList.get(i) + " variable" + variablesEscritas
							+ " = result." + getResultAUtilizar + "(\"" + i + "\")");
					System.out.println("SE Finaliza con :\n");
					
					if (tipoAtributo != null) {
						
						if (tipoAtributo == "Character"){
							System.out.println("ACHAAAAAR\n");
							myWriter.write(".charAt(0);//ACHAAAAAR \n");
						}
						else {
							System.out.println("ANOCHAAAAAR\n");

							myWriter.write(";//ANOCHAAAAAR \n");
							

							
						}
					}
					else {
						System.out.println("WTF ES NULL\n");

						
					}

					// PROCESO PARA COGER LA PRIMERA MAYUSCULA

					// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
					// metodo, por ejemplo getName
					// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
					// metodo, por ejemplo getName
					String nombreAtributo2 = i;
					String nombreAtributoMayus2 = "";
					String firstLtr2 = nombreAtributo2.substring(0, 1);
					String restLtrs2 = nombreAtributo2.substring(1, nombreAtributo2.length());

					// ponemos mayuscula la primera letra
					firstLtr2 = firstLtr2.toUpperCase();
					// concatenamos
					nombreAtributoMayus2 = firstLtr2 + restLtrs2;
					// FIN PROCESO PARA COGER LA PRIMERA MAYUSCULA
					myWriter.write("\t\t\t" + "s.set" + nombreAtributoMayus2 + "( variable" + variablesEscritas + ")"
							+ ";\n\n");

					variablesEscritas++;
					// nAtributosPorEscribir--;
				}

				// Fin de leeemos creando un objeto por cada fila
				// empezamos a crear el objeto y anyadirlo a la lista de objetos
				myWriter.write("\t\t\tvariableRetorno.add(s);\n");
				// Bucle para recoger todas las variables usadas y meterlas en el nuevo objeto

				myWriter.write("\t\t}\n");
				myWriter.write("\t\treturn variableRetorno;\n");

				myWriter.write("\t}\n");// fin function
				myWriter.close();

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

		}
	}

	public void crearReadDBPorAtributos(EClass eClass, String nombreFichero, String nombreClase,
			List<EClassifier> cElements) {

		LinkedHashMap<String, String> tipoAtributoYNombreAtributoList = new LinkedHashMap<String, String>();

		int nAtributosCreados = 0;
		ArrayList<String> atributosRecogidos = new ArrayList<String>();
		// Creamos el metodo para buscar por el atributo
		tipoAtributoYNombreAtributoList = devuelveAtributosTablaClase(eClass, cElements);

		for (String nombreVariable : tipoAtributoYNombreAtributoList.keySet()) {

			// nombre de la variable -> i
			// tipo -> tipoAtributoYNombreAtributoList.get(i)

			// String tipo = eAttribute.getEType().getInstanceClass().getSimpleName();//
			// obtenemos el tipo correspondiente
			String tipo = tipoAtributoYNombreAtributoList.get(nombreVariable);// obtenemos el tipo correspondiente

			// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
			// metodo, por ejemplo getName
			String nombreAtributo = nombreVariable;
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();
			// concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;

			// Creamos el metodo para buscar por el atributo

			// Se hace un read por cada uno de los atributos para buscar por un atributo
			// dado
			try {

				FileWriter myWriter = new FileWriter(nombreFichero, true);
				myWriter.write("\n\tpublic List<" + nombreClase + "> searchBy" + nombreAtributoMayus
						+ "(Connection connection, " + tipoWrapper(tipo) + " valorAtributo) throws SQLException {\n");
				myWriter.write(
						"\t\tList<" + nombreClase + "> variableRetorno = new ArrayList<" + nombreClase + ">(); \n");

				myWriter.write("\t\tString sql = \"select * from " + nombreClase + " where " + nombreAtributo
						+ " =  \" + " + "valorAtributo" + ";" + "\n");
				myWriter.write("\t\tStatement statement = connection.createStatement();\n");
				myWriter.write("\t\tResultSet result = statement.executeQuery(sql);\n");
				myWriter.write("\t\twhile(result.next()) {\n");

				// PREGUNTAR A SARA C�MO MOSTRAMOS LOS VALORES
				// Recorrer todos los valores de la clase

				int nVariablesAEscribir = tipoAtributoYNombreAtributoList.size();
				int variablesEscritas = 0;
				myWriter.write("\t\t\t" + nombreClase + " s = new " + nombreClase + "();\n\n");
				// int nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size();
				for (String i : tipoAtributoYNombreAtributoList.keySet()) {
					// i es el tipo
					// lo otro el valor
					String getResultAUtilizar = tipoJavaATipoGetResult(tipoAtributoYNombreAtributoList.get(i));
					// aqui hay que printear el id por lo que no ponemos el if que lo evita
					myWriter.write("\t\t\t" + tipoAtributoYNombreAtributoList.get(i) + " variable" + variablesEscritas
							+ " = result." + getResultAUtilizar + "(\"" + i + "\");\n");

					// PROCESO PARA COGER LA PRIMERA MAYUSCULA

					// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
					// metodo, por ejemplo getName
					// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
					// metodo, por ejemplo getName
					String nombreAtributo2 = i;
					String nombreAtributoMayus2 = "";
					String firstLtr2 = nombreAtributo2.substring(0, 1);
					String restLtrs2 = nombreAtributo2.substring(1, nombreAtributo2.length());

					// ponemos mayuscula la primera letra
					firstLtr2 = firstLtr2.toUpperCase();
					// concatenamos
					nombreAtributoMayus2 = firstLtr2 + restLtrs2;
					// FIN PROCESO PARA COGER LA PRIMERA MAYUSCULA
					myWriter.write("\t\t\t" + "s.set" + nombreAtributoMayus2 + "( variable" + variablesEscritas + ")"
							+ ";\n\n");

					variablesEscritas++;
					// nAtributosPorEscribir--;
				}

				// Fin de leeemos creando un objeto por cada fila
				// empezamos a crear el objeto y anyadirlo a la lista de objetos
				myWriter.write("\t\t\tvariableRetorno.add(s);\n");
				// Bucle para recoger todas las variables usadas y meterlas en el nuevo objeto

				myWriter.write("\t\t}\n");
				myWriter.write("\t\treturn variableRetorno;\n");

				myWriter.write("\t}\n");// fin function
				myWriter.close();

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

		}
	}

	public void crearReadDBPorCualquierCantidadDeIds(EClass eClass, String nombreFichero, String nombreClase,
			List<EClassifier> cElements) {

		LinkedHashMap<String, String> tipoAtributoYNombreAtributoList = new LinkedHashMap<String, String>();

		int nAtributosCreados = 0;
		ArrayList<String> atributosRecogidos = new ArrayList<String>();
		// Creamos el metodo para buscar por el atributo
		tipoAtributoYNombreAtributoList = devuelveAtributosTablaClase(eClass, cElements);

		// nombre de la variable -> i
		// tipo -> tipoAtributoYNombreAtributoList.get(i)

		// String tipo = eAttribute.getEType().getInstanceClass().getSimpleName();//
		// obtenemos el tipo correspondiente

		// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
		// metodo, por ejemplo getName

		// Creamos el metodo para buscar por el atributo

		// Se hace un read por cada uno de los atributos para buscar por un atributo
		// dado
		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\n\tpublic List<" + nombreClase + "> searchByMultipleIds" + "(Connection connection, "
					+ "List<Integer> idsABuscar) throws SQLException {\n");
			myWriter.write("\t\tList<" + nombreClase + "> variableRetorno = new ArrayList<" + nombreClase + ">(); \n");

			myWriter.write("\t\tString sql = \"select * from " + nombreClase + " where id=?\" ;" + "\n");

			//

			myWriter.write("\t\tfor (int i = 1; i < idsABuscar.size(); i++) {" + "\n");
			myWriter.write("\t\t\tsql += \" OR id = ?\";\n");
			myWriter.write("\t\t}\n");

			//

			myWriter.write("\t\tPreparedStatement preparedStatement = connection.prepareStatement(sql);\n");
			myWriter.write("\t\tif (idsABuscar.size()>0) {\n");
			myWriter.write("\t\t\tfor (int i = 0; i < idsABuscar.size(); i++) {\n");
			myWriter.write("\t\t\t\tpreparedStatement.setInt(i + 1, idsABuscar.get(i));\n");
			myWriter.write("\t\t\t}\n");

			myWriter.write("\t\t\tResultSet result = preparedStatement.executeQuery();\n");
			myWriter.write("\t\t\twhile(result.next()) {\n");

			int nVariablesAEscribir = tipoAtributoYNombreAtributoList.size();
			int variablesEscritas = 0;
			myWriter.write("\t\t\t\t" + nombreClase + " s = new " + nombreClase + "();\n\n");
			// int nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size();
			for (String i : tipoAtributoYNombreAtributoList.keySet()) {
				// i es el nombre de la variable
				String nombreVariableBucle = i;
				String tipoAtributo = tipoAtributoYNombreAtributoList.get(i);
				String getResultAUtilizar = tipoJavaATipoGetResult(tipoAtributoYNombreAtributoList.get(i));
				// aqui hay que printear el id por lo que no ponemos el if que lo evita
				myWriter.write("\t\t\t\t" + tipoAtributoYNombreAtributoList.get(i) + " variable" + variablesEscritas
						+ " = result." + getResultAUtilizar + "(\"" + i + "\")");

				
				
				if (tipoAtributo != null) {
					
					if (tipoAtributo == "Character"){
						System.out.println("ACHAAAAAR\n");
						myWriter.write(".charAt(0);//ACHAAAAAR \n");
					}
					else {
						System.out.println("ANOCHAAAAAR\n");

						myWriter.write(";//ANOCHAAAAAR \n");
						

						
					}
				}
				// PROCESO PARA COGER LA PRIMERA MAYUSCULA

				// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
				// metodo, por ejemplo getName
				// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
				// metodo, por ejemplo getName
				String nombreAtributo2 = i;
				String nombreAtributoMayus2 = "";
				String firstLtr2 = nombreAtributo2.substring(0, 1);
				String restLtrs2 = nombreAtributo2.substring(1, nombreAtributo2.length());

				// ponemos mayuscula la primera letra
				firstLtr2 = firstLtr2.toUpperCase();
				// concatenamos
				nombreAtributoMayus2 = firstLtr2 + restLtrs2;
				// FIN PROCESO PARA COGER LA PRIMERA MAYUSCULA
				myWriter.write(
						"\t\t\t\t" + "s.set" + nombreAtributoMayus2 + "( variable" + variablesEscritas + ")" + ";\n\n");

				variablesEscritas++;
				// nAtributosPorEscribir--;
			}

			// Fin de leeemos creando un objeto por cada fila
			// empezamos a crear el objeto y anyadirlo a la lista de objetos
			myWriter.write("\t\t\t\tvariableRetorno.add(s);\n");
			// Bucle para recoger todas las variables usadas y meterlas en el nuevo objeto

			myWriter.write("\t\t\t}\n");
			myWriter.write("\t\t}\n");
			myWriter.write("\t\treturn variableRetorno;\n");

			myWriter.write("\t}\n");// fin function
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public void crearDeleteRowPorId(EClass eClass, String nombreFichero, String nombreClase) {

		// Se hace un read por cada uno de los atributos para buscar por un atributo
		// dado
		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\n\tpublic void deleteById"
					+ "(Connection connection, String valorAtributo) throws SQLException{\n");

			myWriter.write("\t\tString sql = \"delete * from " + nombreClase + " where id = valorAtributo \";" + "\n");
			myWriter.write("\t\tStatement statement = connection.createStatement();\n");
			myWriter.write("\t\tint rows = statement.executeUpdate(sql);\n");
			myWriter.write("\t\t if (rows>0){\n");
			myWriter.write(
					"\t\t\t System.out.println(\"Eliminado satisfactoriamente de tabla " + nombreClase + "\"); \n");
			myWriter.write("\t\t}\n");
			myWriter.write("\t\t else {\n");
			myWriter.write("\t\t\t System.out.println(\"Error al eliminar de la tabla " + nombreClase + "\"); \n");
			myWriter.write("\t\t}\n");

			myWriter.write("\t}\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public void crearClaseSQL(EClass eClass, String nombreFichero, String nombreClase) {

		if (eClass != null) {// para las clases, no sera null. Sera null para las listas creadas como clases
								// o relaciones nm
			try {
				FileWriter myWriter = new FileWriter(nombreFichero, true);
				myWriter.write("package sql;\n");

				myWriter.write("import java.util.*;\n");
				myWriter.write("import java.sql.Connection;\n");
				myWriter.write("import java.sql.DriverManager;\n");
				myWriter.write("import java.sql.PreparedStatement;\n");
				myWriter.write("import java.sql.SQLException;\n");
				myWriter.write("import java.sql.Statement;\n");
				myWriter.write("import java.sql.ResultSet;\n");
				myWriter.write("import javaCode." + eClass.getName() + ";\n");

				myWriter.close();

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

			try {
				FileWriter myWriter = new FileWriter(nombreFichero, true);
				myWriter.write("\npublic class " + eClass.getName() + "SQL");
				myWriter.write(" {" + "\n\n");
				myWriter.close();

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		} else {
			try {
				FileWriter myWriter = new FileWriter(nombreFichero, true);
				myWriter.write("package sql;\n");

				myWriter.write("import java.util.*;\n");
				myWriter.write("import java.sql.Connection;\n");
				myWriter.write("import java.sql.DriverManager;\n");
				myWriter.write("import java.sql.PreparedStatement;\n");
				myWriter.write("import java.sql.SQLException;\n");
				myWriter.write("import java.sql.Statement;\n");
				myWriter.write("import java.sql.ResultSet;\n");
				myWriter.write("import javaCode." + nombreClase + ";\n");

				myWriter.close();

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			/*
			 * try { FileWriter myWriter = new FileWriter(nombreFichero, true);
			 * myWriter.write("\npublic class " + nombreClase + "SQL"); myWriter.write(" {"
			 * + "\n\n"); myWriter.close();
			 * 
			 * } catch (IOException e) { System.out.println("An error occurred.");
			 * e.printStackTrace(); }
			 */
		}

	}

	// Esta funcion va a insertar nuevas rows dentro de una table ya creada.
	// La idea es recoger todos los atributos y referencias y despu�s crear la
	// prepared statemetn:
	// String sql = "insert into student(name, percentage, address) value (?,?,?)";
	// preparedStatement.setString(1,"Sandeep");

	// solo meto atributos upperbound = 1 y que no sean de tipos raros
	// ademas tengo que comprobar si son referencia de alguien para introducir el id
	// si es necesario
	// me voy a hacer funcion que me devuelva los atributos de una clase para saber
	// los que puedo introducir.
	// ademas que me de sus tipos
	public void crearInserts(EClass eClass, String nombreFichero, String nombreClase, List<EClassifier> cElements) {

		LinkedHashMap<String, String> tipoAtributoYNombreAtributoList = new LinkedHashMap<String, String>();
		
		LinkedHashMap<String, String> tipoAtributoYNombreAtributoApoyoSQLList = new LinkedHashMap<String, String>();

		tipoAtributoYNombreAtributoList = devuelveSoloAtributosTablaClase(eClass, cElements);
		
		tipoAtributoYNombreAtributoApoyoSQLList = devuelveAtributosTablaClaseApoyoASQL(eClass, cElements);

		// Se hace un read por cada uno de los atributos para buscar por un atributo
		// dado
		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);
			
			//CREAR EL INSERT NORMAL (PARA CLASES QUE NO SON CONTAINMENT)
			myWriter.write("\n\tpublic void insertRow" + eClass.getName() + " (" + "Connection connection");
			
			System.out.println("ATRIBUTOS INSERT CLASE: " + eClass.getName());

			// int nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size();
			for (String i : tipoAtributoYNombreAtributoList.keySet()) {
				System.out.println("ATRIBUTO INSERT: " + i);
				if (i!="id") {
					myWriter.write(", " + "String" + " " + i + "P");
				}
				// nAtributosPorEscribir--;
			}

			myWriter.write(") throws SQLException {\n");
			myWriter.write("\t\tString sql = \"insert into " + nombreClase + " (");
			int nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size()-1;// quitamos 1 por el id
			
			System.out.println("clase: " + eClass.getName()+" nAtributosPorEscribir = "+nAtributosPorEscribir );

			for (String i : tipoAtributoYNombreAtributoList.keySet()) {
				if (i!="id") {
					myWriter.write(i);
	
					nAtributosPorEscribir--;
					if (nAtributosPorEscribir > 0) {
						myWriter.write(", ");
	
					}
				}
			}
			myWriter.write(") values (");
			nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size()-1;
			for (String i : tipoAtributoYNombreAtributoList.keySet()) {
				
				if (i!="id") {
					myWriter.write("?");
	
					nAtributosPorEscribir--;
					if (nAtributosPorEscribir > 0) {
						myWriter.write(", ");
	
					}
				
				}
			}

			myWriter.write(")\";\n");

			myWriter.write("\t\tPreparedStatement preparedStatement = connection.prepareStatement(sql);\n");

			// logica para anyadir los parametros-
			int atributosAEscribir = 1;
			for (String i : tipoAtributoYNombreAtributoList.keySet()) {
				String tipo = tipoAtributoYNombreAtributoList.get(i);
				
				if (i!="id") {
					//myWriter.write("\t\tpreparedStatement.setString");
					myWriter.write("\t\tpreparedStatement." + tipoJavaATipoSetResult(tipo));
					myWriter.write("("+ atributosAEscribir + ",");
					myWriter.write(casteoEnFuncionDelTipo(tipo));		
					//Comprobacion para hacer casteo en funcion del tipo
					
					
					myWriter.write(""  + i + "P" + ")" + cierraCasteoEnFuncionDelTipo(tipo)+ ";\n");
					
					
					
					atributosAEscribir++;
	
					nAtributosPorEscribir--;
					if (nAtributosPorEscribir > 0) {
						myWriter.write(", ");
	
					}
				}
			}

			// fin de logica para anyadir los parametros
			myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n");
			myWriter.write("\t\tif (rows >0){\n");
			myWriter.write("\t\t\tSystem.out.println(\"Fila insertada correctamente en la tabla" + eClass.getName()
					+ "\");\n");
			myWriter.write("\t\t}\n");

			myWriter.write("\t}\n");// fin function
			
			//CREAR LOS INSERTS BY atributoApoyoSQL
			for (String nomreAtributoApoyoSQL : tipoAtributoYNombreAtributoApoyoSQLList.keySet()) {
				System.out.println("ATRIBUTO APOYO DE LA CLASE "+eClass.getName() +" ->  " + nomreAtributoApoyoSQL);
			
				myWriter.write("\n\tpublic void insertRow" + eClass.getName() + "by" + nomreAtributoApoyoSQL+"(" + "Connection connection");
	
				// int nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size();
				for (String i : tipoAtributoYNombreAtributoList.keySet()) {
					if (i!="id") {
						myWriter.write(", " + "String" + " " + i + "P");
					}
					// nAtributosPorEscribir--;
				}
				
				//anyadimos a manini el atributo por el que vamos
				
				myWriter.write(", " + "String" + " " + nomreAtributoApoyoSQL + "P");
				
				myWriter.write(") throws SQLException {\n");
				myWriter.write("\t\tString sql = \"insert into " + nombreClase + " (");
				nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size()-1; // quitamos 1 por el id
	
				for (String i : tipoAtributoYNombreAtributoList.keySet()) {
					if (i!="id") {
		
						myWriter.write(i);
		
						nAtributosPorEscribir--;
						if (nAtributosPorEscribir > 0) {
							myWriter.write(", ");
		
						}
					}
				}
				
				//anyadimos a manini el atributo de apoyo sql
				
				myWriter.write(", "+nomreAtributoApoyoSQL);
				
				
				myWriter.write(") values (");
				nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size()-1;//quitar el id
				for (String i : tipoAtributoYNombreAtributoList.keySet()) {
					if (i!="id") {
						myWriter.write("?");
		
						nAtributosPorEscribir--;
						if (nAtributosPorEscribir > 0) {
							myWriter.write(", ");
		
						}
					}
				}
	
				//anyadimos a manini el atributo de apoyo sql
				
				myWriter.write(", ?");
				
				myWriter.write(")\";\n");
	
				myWriter.write("\t\tPreparedStatement preparedStatement = connection.prepareStatement(sql);\n");
	
				// logica para anyadir los parametros-
				atributosAEscribir = 1;
				for (String i : tipoAtributoYNombreAtributoList.keySet()) {
					String tipo = tipoAtributoYNombreAtributoList.get(i);
					
					if (i!="id") {
						//myWriter.write("\t\tpreparedStatement.setString");
						myWriter.write("\t\tpreparedStatement." + tipoJavaATipoSetResult(tipo));
						myWriter.write("("+ atributosAEscribir + ",");
						myWriter.write(casteoEnFuncionDelTipo(tipo));		
						//Comprobacion para hacer casteo en funcion del tipo
						
						
						myWriter.write(""  + i + "P" + ")" + cierraCasteoEnFuncionDelTipo(tipo)+ ";\n");
						
						
						
						atributosAEscribir++;
		
						nAtributosPorEscribir--;
						if (nAtributosPorEscribir > 0) {
							myWriter.write(", ");
		
						}
					}
				}
				
				//anyadimos a manini el atributo
				myWriter.write("\t\tpreparedStatement.");
				myWriter.write("setString");
				myWriter.write("(" + atributosAEscribir + ",");
				myWriter.write(nomreAtributoApoyoSQL+"P");
				myWriter.write(");\n");
				
				// fin de logica para anyadir los parametros
				myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n");
				myWriter.write("\t\tif (rows >0){\n");
				myWriter.write("\t\t\tSystem.out.println(\"Fila insertada correctamente en la tabla" + eClass.getName()
						+ "\");\n");
				myWriter.write("\t\t}\n");
	
				myWriter.write("\t}\n");// fin function
				
			}
			//FIN DE CREAR LOS INSERTS BY
			
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
		

		// creamos ahora la funcion que nos indica cual es el id asignado
		
		escribirEnFichero("\n\tpublic Integer getLastRow"+eClass.getName()+ "(Connection connection) throws SQLException {\n", nombreFichero);

		escribirEnFichero("\t\tInteger lastId = -1;\n", nombreFichero);
		escribirEnFichero("\t\tString sql = \"SELECT MAX(id) FROM \" + \"" +eClass.getName()+"\";\n", nombreFichero);
		escribirEnFichero("\t\ttry (PreparedStatement statement = connection.prepareStatement(sql)) {\n", nombreFichero);
		escribirEnFichero("\t\t\tResultSet resultSet = statement.executeQuery();\n", nombreFichero);
		escribirEnFichero("\t\t\tif (resultSet.next()) {\n", nombreFichero);
		escribirEnFichero("\t\t\t\tlastId = resultSet.getInt(1);\n", nombreFichero);
		escribirEnFichero("\t\t\t}\n", nombreFichero);
		escribirEnFichero("\t\t}\n", nombreFichero);
		escribirEnFichero("\t\treturn lastId;\n", nombreFichero);
		escribirEnFichero("\t}\n", nombreFichero);

		
		
	}
	
	

	public void crearReadTablaCompleta(EClass eClass, String nombreFichero, String nombreClase,
			List<EClassifier> cElements) {

		LinkedHashMap<String, String> tipoAtributoYNombreAtributoList = new LinkedHashMap<String, String>();

		int nAtributosCreados = 0;
		ArrayList<String> atributosRecogidos = new ArrayList<String>();
		// Creamos el metodo para buscar por el atributo
		tipoAtributoYNombreAtributoList = devuelveAtributosTablaClase(eClass, cElements);

		// Se hace un read por cada uno de los atributos para buscar por un atributo
		// dado
		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write(
					"\n\tpublic List<" + nombreClase + "> readAll" + " (Connection connection) throws SQLException{\n");
			myWriter.write("\t\tList<" + nombreClase + "> variableRetorno = new ArrayList<" + nombreClase + ">(); \n");

			myWriter.write("\t\tString sql = \"select * from " + nombreClase + "\";" + "\n");
			myWriter.write("\t\tStatement statement = connection.createStatement();\n");
			myWriter.write("\t\tResultSet result = statement.executeQuery(sql);\n");
			myWriter.write("\t\twhile(result.next()) {\n");

			int nVariablesAEscribir = tipoAtributoYNombreAtributoList.size();
			int variablesEscritas = 0;
			myWriter.write("\t\t\t" + nombreClase + " s = new " + nombreClase + "();\n\n");
			// int nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size();
			for (String i : tipoAtributoYNombreAtributoList.keySet()) {
				String nombreVariableBucle = i;
				String tipoAtributo = tipoAtributoYNombreAtributoList.get(i);
				String getResultAUtilizar = tipoJavaATipoGetResult(tipoAtributoYNombreAtributoList.get(i));
				// aqui hay que printear el id por lo que no ponemos el if que lo evita
				myWriter.write("\t\t\t" + tipoAtributoYNombreAtributoList.get(i) + " variable" + variablesEscritas
						+ " = result." + getResultAUtilizar + "(\"" + i + "\")");

				
				if (tipoAtributo != null) {
					
					if (tipoAtributo == "Character"){
						System.out.println("ACHAAAAAR\n");
						myWriter.write(".charAt(0);//ACHAAAAAR \n");
					}
					else {
						System.out.println("ANOCHAAAAAR\n");

						myWriter.write(";//ANOCHAAAAAR \n");
						

						
					}
				}
				
				// PROCESO PARA COGER LA PRIMERA MAYUSCULA

				// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
				// metodo, por ejemplo getName
				String nombreAtributo = i;
				String nombreAtributoMayus = "";
				String firstLtr = nombreAtributo.substring(0, 1);
				String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

				// ponemos mayuscula la primera letra
				firstLtr = firstLtr.toUpperCase();
				// concatenamos
				nombreAtributoMayus = firstLtr + restLtrs;
				// FIN PROCESO PARA COGER LA PRIMERA MAYUSCULA
				myWriter.write(
						"\t\t\t" + "s.set" + nombreAtributoMayus + "( variable" + variablesEscritas + ")" + ";\n\n");
				// System.out.println("\t" + "public " + "void" +" " + "set"+
				// nombreAtributoMayus + " (" + tipo+ " p" + nombreAtributoMayus + ") {\n");

				variablesEscritas++;
				// nAtributosPorEscribir--;
			}

			// Fin de leeemos creando un objeto por cada fila
			// empezamos a crear el objeto y anyadirlo a la lista de objetos
			myWriter.write("\t\t\tvariableRetorno.add(s);\n");
			// Bucle para recoger todas las variables usadas y meterlas en el nuevo objeto
			myWriter.write("\t\t}\n");// fin function

			// ArrayList<String> atributosRecogidos = new ArrayList<String>();

			myWriter.write("\t\treturn variableRetorno;\n");
			myWriter.write("\t}\n\n");// fin function
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	// Esta funcion va a modificar
	public void crearUpdatesTabla(EClass eClass, String nombreFichero, String nombreClase,
			List<EClassifier> cElements) {

		LinkedHashMap<String, String> tipoAtributoYNombreAtributoList = new LinkedHashMap<String, String>();

		tipoAtributoYNombreAtributoList = devuelveAtributosTablaClase(eClass, cElements);

		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write(
					"\n\tpublic void updateTable" + eClass.getName() + " (" + "Connection connection, Integer idP");

			// int nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size();
			for (String i : tipoAtributoYNombreAtributoList.keySet()) {
				// i es el tipo
				// lo otro el valor
				if (i != "id") {
					myWriter.write(", " + tipoAtributoYNombreAtributoList.get(i) + " " + i + "P");
				}
				// nAtributosPorEscribir--;
			}

			myWriter.write(") throws SQLException {\n");
			myWriter.write("\t\tString sql = \"update " + nombreClase + " set ");
			int nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size() - 1; // quitamos 1 por el id

			for (String i : tipoAtributoYNombreAtributoList.keySet()) {
				String nombreVariableBucle = i;
				String tipoAtributo = tipoAtributoYNombreAtributoList.get(i);
				
				if (i != "id") {
					myWriter.write(i + "=?");
				}
				nAtributosPorEscribir--;
				if (nAtributosPorEscribir > 0) {
					myWriter.write(", ");

				}
			}
			myWriter.write(" WHERE id =? ");
			nAtributosPorEscribir = tipoAtributoYNombreAtributoList.size() - 1;

			myWriter.write("\";\n");

			myWriter.write("\t\tPreparedStatement preparedStatement = connection.prepareStatement(sql);\n");

			// logica para anyadir los parametros
			int atributosAEscribir = 1;
			for (String i : tipoAtributoYNombreAtributoList.keySet()) {
//				String nombreVariableBucle = i;
				String tipoAtributo = tipoAtributoYNombreAtributoList.get(i);
				
				
//
				//chaaa
				System.out.println("key: " + i + " value: " + tipoAtributoYNombreAtributoList.get(i));
				if (i != "id") {
					myWriter.write("\t\tpreparedStatement.");
					myWriter.write(tipoJavaATipoSetResult(tipoAtributoYNombreAtributoList.get(i)));



					myWriter.write("(" + atributosAEscribir + ",");
					
					
					if (tipoAtributo == "Character"){
						
						myWriter.write("Character.toString(");
					}
					myWriter.write(i + "P");
					
					if (tipoAtributo == "Character"){
						
						myWriter.write("));\n");
					}else {
						
						myWriter.write(");\n");

					}
					
					
					atributosAEscribir++;
				}
				nAtributosPorEscribir--;

			}
			myWriter.write("\t\tpreparedStatement.setInt(" + atributosAEscribir + ",idP" + ");\n");

			// fin de logica para anyadir los parametros
			myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n");
			myWriter.write("\t\tif (rows >0){\n");
			myWriter.write("\t\t\tSystem.out.println(\"Fila actualizada correctamente en la tabla" + eClass.getName()
					+ "\");\n");
			myWriter.write("\t\t}\n");

			myWriter.write("\t}\n");// fin function
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public void crearSetters(EClass eClass, String nombreFichero) {

		// EClass eClass = (EClass) pclassifier;
		// Hacer creacion de fichero .java
		// Hacer bucle imports

		// BUCLE SETTERS

		// Setter fijo del ID

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public void" + " " + "setId(Integer pId){\n");
			myWriter.write("\t\t" + " this.id = pId" + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Setters para atributos
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			String tipo = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());// obtenemos el tipo
																								// correspondiente en
																								// Java

			// Comprobacion si el atributo es heredado o no para poner @override
			EClass clase = eClass;
			String nombreDelAtributo = eAttribute.getName();
			EStructuralFeature featurePropio = clase.getEStructuralFeature(nombreDelAtributo);
			boolean esHeredado = false;

			if (featurePropio instanceof EAttribute) {
				for (EClass superclase : clase.getESuperTypes()) {
					EStructuralFeature featureHeredado = superclase.getEStructuralFeature(nombreDelAtributo);
					if (featureHeredado != null && featureHeredado instanceof EAttribute) {
						esHeredado = true;
						break;
					}
				}

				// ESTE IF ELSE COMPRUEBA SI EL ATRIBUTO ES HEREDADO O NO Y USO SYSTEM OUT
				// PRINTLN PARA SABERLO
				/*
				 * if (esHeredado) { System.out.println("El atributo " + nombreDelAtributo +
				 * "No es de la clase " + eClass.getName() + "por lo que es heredado"); } else {
				 * System.out.println("El atributo " + nombreDelAtributo + "SI es de la clase" +
				 * eClass.getName() + "por lo que NO es heredado"); }
				 */
			} else {
				// No se encontró un EAttribute con el nombre especificado en la clase.
			}
			// Fin de comprobacion de si el atributo es heredado o no

			// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
			// metodo, por ejemplo getName
			String nombreAtributo = eAttribute.getName();
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();
			// concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;

			if (eAttribute.getUpperBound() == 1) {

				try {

					FileWriter myWriter = new FileWriter(nombreFichero, true);

					myWriter.write("\t" + "@Override\n");
					myWriter.write("\t" + "public " + "void" + " " + "set" + nombreAtributoMayus + " (" + tipo + " p"
							+ nombreAtributoMayus + ") {\n");
					myWriter.write("\t\t" + " this." + nombreAtributo + " = " + "p" + nombreAtributoMayus + ";\n");
					myWriter.write("\t" + "}\n");
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			} else if (eAttribute.getUpperBound() >= 2 || eAttribute.getUpperBound() == -1) {// Habra que anyadir List

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);

					myWriter.write("\t" + "@Override\n");

					myWriter.write("\t" + "public " + "void" + " " + "set" + nombreAtributoMayus + " (List<" + tipo
							+ "> p" + nombreAtributoMayus + ") {\n");
					myWriter.write("\t\t" + " this." + nombreAtributo + " = " + "p" + nombreAtributoMayus + ";\n");
					myWriter.write("\n\t" + "}\n");
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

			}

		}

		// AHORA los de getters con atributos de referencia
		// Taking EReferences of the eClass

		for (EReference eReference : eClass.getEAllReferences()) {
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java

			// Comprobacion si el atributo es heredado o no para poner @override
			EClass clase = eClass;
			String nombreDeLaReferencia = eReference.getName();
			EStructuralFeature featurePropio = clase.getEStructuralFeature(nombreDeLaReferencia);
			boolean esHeredado = false;

			if (featurePropio instanceof EReference) {
				for (EClass superclase : clase.getESuperTypes()) {
					EStructuralFeature featureHeredado = superclase.getEStructuralFeature(nombreDeLaReferencia);
					if (featureHeredado != null && featureHeredado instanceof EReference) {
						esHeredado = true;
						break;
					}
				}

				/*
				 * if (esHeredado) { System.out.println("LAAAAA referencia " +
				 * nombreDeLaReferencia + "No es de la clase " + eClass.getName() +
				 * "por lo que es heredado"); } else { System.out.println("LAAAAA referencia " +
				 * nombreDeLaReferencia + "SI es de la clase" + eClass.getName() +
				 * "por lo que NO es heredado"); }
				 */
			} else {
				// No se encontró una EReference con el nombre especificado en la clase.
			}
			// Fin de comprobacion de si el atributo es heredado o no

			// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
			// metodo, por ejemplo getName
			String nombreAtributo = eReference.getName();
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();

			// concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;

			if (eReference.getUpperBound() == 1) {

				// System.out.println("\t" + "public " + "add" + nombreAtributoMayus + " (" +
				// tipoE + " p" + nombreAtributoMayus + ") {\n");

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);

					myWriter.write("\t" + "@Override\n");

					myWriter.write("\t" + "public " + "void " + "set" + nombreAtributoMayus + " (" + tipoE + " p"
							+ nombreAtributoMayus + ") {\n");
					myWriter.write("\t\t" + " this." + nombreAtributo + " = " + "p" + nombreAtributoMayus + ";");
					myWriter.write("\n\t}\n");

					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			} else if (eReference.getUpperBound() >= 2 || eReference.getUpperBound() == -1) {// Habra que anyadir List

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);

					myWriter.write("\t" + "@Override\n");

					myWriter.write("\t" + "public " + "void" + " " + "set" + nombreAtributoMayus + " (List<" + tipoE
							+ "> p" + nombreAtributoMayus + ") {\n");
					myWriter.write("\t\t" + " this." + nombreAtributo + " = " + "p" + nombreAtributoMayus + ";");
					myWriter.write("\n\t" + "}\n");
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

			}

		}

	}

	public void crearSettersInterfaces(EClass eClass, String nombreFichero) {

		// EClass eClass = (EClass) pclassifier;
		// Hacer creacion de fichero .java
		// Hacer bucle imports

		// BUCLE SETTERS

		// Setters para atributos
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			String tipo = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());// obtenemos el tipo
																								// correspondiente en
																								// Java

			// Comprobacion si el atributo es heredado o no para poner @override
			EClass clase = eClass;
			String nombreDelAtributo = eAttribute.getName();
			EStructuralFeature featurePropio = clase.getEStructuralFeature(nombreDelAtributo);
			boolean esHeredado = false;

			if (featurePropio instanceof EAttribute) {
				for (EClass superclase : clase.getESuperTypes()) {
					EStructuralFeature featureHeredado = superclase.getEStructuralFeature(nombreDelAtributo);
					if (featureHeredado != null && featureHeredado instanceof EAttribute) {
						esHeredado = true;
						break;
					}
				}

				// ESTE IF ELSE COMPRUEBA SI EL ATRIBUTO ES HEREDADO O NO Y USO SYSTEM OUT
				// PRINTLN PARA SABERLO
				/*
				 * if (esHeredado) { System.out.println("El atributo " + nombreDelAtributo +
				 * "No es de la clase " + eClass.getName() + "por lo que es heredado"); } else {
				 * System.out.println("El atributo " + nombreDelAtributo + "SI es de la clase" +
				 * eClass.getName() + "por lo que NO es heredado"); }
				 */
			} else {
				// No se encontró un EAttribute con el nombre especificado en la clase.
			}
			// Fin de comprobacion de si el atributo es heredado o no

			// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
			// metodo, por ejemplo getName
			String nombreAtributo = eAttribute.getName();
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();
			// concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;

			if (eAttribute.getUpperBound() == 1) {

				try {

					FileWriter myWriter = new FileWriter(nombreFichero, true);

					if (!esHeredado) {

						myWriter.write("\n\t" + "void" + " " + "set" + nombreAtributoMayus + " (" + tipo + " p"
								+ nombreAtributoMayus + ");\n");

						myWriter.close();
					}

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			} else if (eAttribute.getUpperBound() >= 2 || eAttribute.getUpperBound() == -1) {// Habra que anyadir List

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);

					if (!esHeredado) {

						myWriter.write("\n\t" + "void" + " " + "set" + nombreAtributoMayus + " (List<" + tipo + "> p"
								+ nombreAtributoMayus + ");\n");
						myWriter.close();

					}

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

			} else {
				System.out.println("ERROR con el upperbound del atributo " + nombreAtributo);

			}

		}

		// AHORA los de getters con atributos de referencia
		// Taking EReferences of the eClass

		for (EReference eReference : eClass.getEAllReferences()) {
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java

			// Comprobacion si el atributo es heredado o no para poner @override
			EClass clase = eClass;
			String nombreDeLaReferencia = eReference.getName();
			EStructuralFeature featurePropio = clase.getEStructuralFeature(nombreDeLaReferencia);
			boolean esHeredado = false;

			if (featurePropio instanceof EReference) {
				for (EClass superclase : clase.getESuperTypes()) {
					EStructuralFeature featureHeredado = superclase.getEStructuralFeature(nombreDeLaReferencia);
					if (featureHeredado != null && featureHeredado instanceof EReference) {
						esHeredado = true;
						break;
					}
				}

			} else {
				// No se encontró una EReference con el nombre especificado en la clase.
			}
			// Fin de comprobacion de si el atributo es heredado o no

			// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
			// metodo, por ejemplo getName
			String nombreAtributo = eReference.getName();
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();

			// concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;

			if (eReference.getUpperBound() == 1) {

				// System.out.println("\t" + "public " + "add" + nombreAtributoMayus + " (" +
				// tipoE + " p" + nombreAtributoMayus + ") {\n");

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);

					if (!esHeredado) {
						myWriter.write("\n\t" + "void " + "set" + nombreAtributoMayus + " (" + tipoE + " p"
								+ nombreAtributoMayus + ");\n");
						myWriter.close();
					}
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			} else if (eReference.getUpperBound() >= 2 || eReference.getUpperBound() == -1) {// Habra que anyadir List

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);

					if (!esHeredado) {

						myWriter.write("\n\t" + "void" + " " + "set" + nombreAtributoMayus + " (List<" + tipoE + "> p"
								+ nombreAtributoMayus + ");\n");
						myWriter.close();
					}

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

			}
		}

	}

	public void crearInterfaces(String rutaFicheroEcore, String pathSalida) {

		// To read a metamodel, we need to open a ecore file (using a resource in EMF)
		// For it we need to create an configure a ResourceSet
		ResourceSet set = new ResourceSetImpl();
		// In the configuration we are going to registry the XMLResourceFactory for the
		// ecore extesion
		// That means all files (or resources) with extension ecore are going to be
		// serialize and deserialize (save and read) in a XML format
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());

		// Using the ResourceSet, we open a resource in a concrete path (the file must
		// be exist previously).
		Resource resource = set.getResource(URI.createURI(rutaFicheroEcore), true);

		// Then we get the first element of the content in the resource, which is an
		// EPackage and the root element
		EPackage storePackage = (EPackage) resource.getContents().get(0);

		// For example, get all the EClassifiers
		List<EClassifier> elements = storePackage.getEClassifiers();
		// Going through the list
		// FUNCION IMPORTS
		for (EClassifier classifier : elements) {
			// Taking the EClass elements
			if (classifier instanceof EClass) {

				EClass eClass = (EClass) classifier;

				// CREAMOS EL DIRECTORIO para codigo JAVA
				//ficheroSalida
				//File carpeta = new File("src/javaCode");
				File carpeta = new File(pathSalida+File.separator+"javaCode");
				if (!carpeta.exists()) {
					boolean resultado = carpeta.mkdirs();
					if (resultado) {
						System.out.println("Carpeta creada exitosamente.");
					} else {
						System.out.println("No se pudo crear la carpeta.");
					}
				}

				// Hacer creacion de fichero .java
				// Hacer bucle imports
				
				//ficheroSalida

				//String nombreFichero = "src/javaCode/";
				String nombreFichero = pathSalida + File.separator +"javaCode"+File.separator;

				nombreFichero += eClass.getName() + "Interface";
				nombreFichero += ".java";

				String nombreClase = eClass.getName(); // para meterlo al getter de db

				String interfaz = nombreClase + "Interface ";

				// Import package y listas

				escribirEnFichero("\npackage javaCode;\n",nombreFichero);

				escribirEnFichero("import java.util.*;\n",nombreFichero);

				escribirEnFichero("\npublic interface " + interfaz,nombreFichero);


				// Comprobacion herencia inmediata
				EClass myClass = eClass; // Clase de la cual se desea obtener las superclases inmediatas
				List<EClass> immediateSuperClasses = myClass.getESuperTypes();
				int padresPorEscribir = immediateSuperClasses.size();

				if (padresPorEscribir > 0) {
					escribirEnFichero("extends ", nombreFichero);

					for (EClass ecl : immediateSuperClasses) {

						escribirEnFichero(ecl.getName() + "Interface", nombreFichero);
						padresPorEscribir--;

						if (padresPorEscribir > 0) {

							escribirEnFichero(", ", nombreFichero);

						}

					}
				}
				// Fin de comprobacion de herencia inmediata

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);
					myWriter.write("{" + "\n\n");
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

				crearGettersInterfaces(eClass, nombreFichero, nombreClase);
				crearSettersInterfaces(eClass, nombreFichero);

				// Cerramos la clase
				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);
					myWriter.write("}");

					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			} /* Fin de procesamiento de clase */

		} /* Fin de lectura de los elementos */

	}

	public void hacerTodo(String rutaFicheroEcore, String nombreModelo, String pathSalida) {
		// To read a metamodel, we need to open a ecore file (using a resource in EMF)
		// For it we need to create an configure a ResourceSet
		ResourceSet set = new ResourceSetImpl();
		List<String> clasesRecorridas = new ArrayList<String>();
		LinkedHashMap<String, String> tablasCreadas = new LinkedHashMap<>();
		LinkedHashMap<String, String> atributosNoLista = new LinkedHashMap<>();
		LinkedHashMap<String, String> atributosLista = new LinkedHashMap<>();
		LinkedHashMap<String, String> atributosJava = new LinkedHashMap<>();

		// In the configuration we are going to registry the XMLResourceFactory for the
		// ecore extesion
		// That means all files (or resources) with extension ecore are going to be
		// serialize and deserialize (save and read) in a XML format
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());

		// Using the ResourceSet, we open a resource in a concrete path (the file must
		// be exist previously).
		Resource resource = set.getResource(URI.createURI(rutaFicheroEcore), true);

		// Then we get the first element of the content in the resource, which is an
		// EPackage and the root element
		EPackage storePackage = (EPackage) resource.getContents().get(0);

		// For example, get all the EClassifiers
		List<EClassifier> elements = storePackage.getEClassifiers();
		// Going through the list
		// FUNCION IMPORTS
		limpiarFicherosJSP(pathSalida);
		limpiarFicherosCodigoServlet(pathSalida);

		// Eliminamos codigo sql
		// LIMPIEZA DE DATOS ANTERIORES
		//File dir = new File("./src/sql");
		File dir = new File(pathSalida + File.separator +"sql");
		File[] files = dir.listFiles((dir1, name) -> name.endsWith(".java"));
		if (files != null) {
			for (File file : files) {
				if (!file.delete()) {
					System.out.println("No se pudo eliminar el archivo " + file.getName());
				} else {
					System.out.println("Archivo " + file.getName() + " eliminado correctamente");

				}
			}
		}

		for (EClassifier classifier : elements) {
			if (classifier instanceof EClass) {

				EClass eClass = (EClass) classifier;

				
				//ficheroSalida
				//File carpeta = new File("src/javaCode");
				File carpeta = new File(pathSalida+File.separator+"javaCode");
				System.out.println("CREANDO FICHERO JAVACODE EN : " + pathSalida+File.separator+"javaCode");
				
				if (!carpeta.exists()) {
					boolean resultado = carpeta.mkdirs();
					if (resultado) {
						System.out.println("Carpeta creada exitosamente.");
					} else {
						System.out.println("No se pudo crear la carpeta.");
					}
				}

				// Creamos ahora la carpeta para el codigo sql
				//ficheroSalida
				//File carpeta2 = new File("src/sql");
				File carpeta2 = new File(pathSalida + File.separator +"sql");
				if (!carpeta2.exists()) {
					boolean resultado = carpeta2.mkdirs();
					if (resultado) {
						System.out.println("Carpeta creada exitosamente.");
					} else {
						System.out.println("No se pudo crear la carpeta.");
					}
				}

				// Hacer creacion de fichero .java
				// Hacer bucle imports
				
				//ficheroSalida

				//String nombreFicheroSQL = "src/sql/";
				String nombreFicheroSQL = pathSalida + File.separator +"sql" + File.separator;
				
				String nombreClase = eClass.getName();
				
				//ficheroSalida
				//String rutaFicherosJava = "src/javaCode/";
				String rutaFicherosJava = pathSalida + File.separator +"javaCode" + File.separator;
				
				String nombreFichero = rutaFicherosJava;
				nombreFichero += nombreClase;
				nombreFichero += ".java";

				
				
				nombreFicheroSQL += eClass.getName() + "SQL";
				nombreFicheroSQL += ".java"; // SE CREA FICHERO SQL

				// File fichero = new File (nombreFichero);

				// introducimos el paquete en el que se encuentra el fichero:

				
					escribirEnFichero("\npackage javaCode;\n",nombreFichero);
					escribirEnFichero("import java.util.*;\n",nombreFichero);


					
				// realizarImports(nombreFichero);

				////////////
				 // para meterlo al getter de db

				// Ver que tipos son clases y que tipos son tipos primitivos para hacer los
				// imports corrrespondientes

				String interfaz = nombreClase + "Interface";

				if (!eClass.isAbstract()) {

					escribirEnFichero("\npublic class " + eClass.getName() + " implements " + interfaz, nombreFichero);

				} else {

					escribirEnFichero("\npublic abstract class " + eClass.getName() + " implements " + interfaz,
							nombreFichero);
				}

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);
					myWriter.write("{" + "\n\n");
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

				// Anyadimos el id como en todas las clases:
				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);
					myWriter.write("\t" + "private Integer id;\n");
					myWriter.close();
					atributosLista.put("Integer", "id");

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

				for (EAttribute eAttribute : eClass.getEAllAttributes()) {

					// obtencion del tipo envoltorio de java si es necesario
					String tipoE = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());

					// obtención del nombre de la variable
					String nombreAtributo = eAttribute.getName();

					if (eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) { // si se trata de una
																								// lista

						escribirEnFichero("\t" + "private List<" + tipoE + "> " + nombreAtributo + ";\n",
								nombreFichero);
						
					} else { // si no es una lista

						escribirEnFichero("\t" + "private " + tipoE + " " + nombreAtributo + ";\n", nombreFichero);

					}
				}

				for (EReference eReference : eClass.getEAllReferences()) {
					String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en
																				// Java
					String nombreAtributo = eReference.getName();

					if (eReference.getUpperBound() == -1 || eReference.getUpperBound() >= 2) {

							escribirEnFichero("\t" + "private List<" + tipoE + "> " + nombreAtributo + ";\n",nombreFichero);

					} else {

							escribirEnFichero("\t" + "private " + tipoE + " " + nombreAtributo + ";\n", nombreFichero);

					}
				}
				

				anyadirImportsYPackage(eClass, nombreFichero, nombreClase);
				definicionDeClase(eClass, nombreFichero, nombreClase);
				declaracionDeAtributos(eClass, nombreFichero, nombreClase);
				creacionDeInterfacesConHerencia(eClass, nombreFichero, nombreClase);
				introducirAtributosPorSiEsReferencia(eClass, elements, nombreFichero,pathSalida);

				crearGetters(eClass, nombreFichero, nombreClase);
				crearSetters(eClass, nombreFichero);

				crearMetodosListas(eClass, nombreFichero);
				crearMetodosAuxiliaresClase(eClass, nombreFichero, elements);

				// Comienzan metodos JDBC
				if (!eClass.isAbstract()) {
					// Metodos JDBC
					crearClaseSQL(eClass, nombreFicheroSQL, nombreClase);

					crearConexionDB(eClass, nombreFicheroSQL);
					// METODO CREACION DE LA TABLA EN LA BASE DE DATOS, solo se crea la tabla de la
					// clase
					tablasCreadas = crearTablaEnDDBB(eClass, nombreFicheroSQL, nombreClase, elements, clasesRecorridas,
							tablasCreadas);

					tablasCreadas = tablasArrayAtributosPrimitivosYCRUD(eClass, nombreFicheroSQL, nombreClase,
							tablasCreadas, elements,pathSalida);

					tablasCreadas = tablasReferencesNoContainmentYCRUD(eClass, nombreFicheroSQL, nombreClase,
							tablasCreadas, elements,pathSalida);

					//CODIGO NO NECESARIO
					//tablasCreadas = crearTablasRelacionesNMYCRUD(eClass, nombreFicheroSQL, nombreClase, tablasCreadas, elements);

					crearInserts(eClass, nombreFicheroSQL, nombreClase, elements);
					// crearMetodosNoContainments(eClass,nombreFichero); Crear de 0, usar funcion
					// crearMetodosListas
					
					crearReadTablaCompleta(eClass, nombreFicheroSQL, nombreClase, elements);
					crearReadDBPorAtributo(eClass, nombreFicheroSQL, nombreClase, elements); // en principio no va a
					crearReadDBPorCualquierCantidadDeIds(eClass, nombreFicheroSQL, nombreClase, elements); // hacer
																											// falta
																											// porque se

					crearDeleteRowPorId(eClass, nombreFicheroSQL, nombreClase);
					crearUpdatesTabla(eClass, nombreFicheroSQL, nombreClase, elements);
					cerrarClaseSQL(eClass, nombreFicheroSQL, nombreClase);

					// Comenzamos a crear codigo JSP

					// Crear pagina principal tablas
					crearShowTabla(eClass, tablasCreadas, elements, nombreModelo, pathSalida);
					crearFormularioCreacion(tablasCreadas, eClass, elements, nombreModelo, pathSalida);
					crearRegistroTabla(tablasCreadas, eClass, elements, nombreModelo, pathSalida);
				}
				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);
					myWriter.write("}");

					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

				System.out.println("Fin de procesamiento de la clase :" + eClass.getName());

			} /* Fin de procesamiento de clase */
		} /* Fin de lectura de los elementos */
		
		crearClaseAuxiliarMetodosEstaticos(elements, pathSalida);
		// Generamos la clase que gestionara la creacion del identificador unico
		//crearFicheroIdentificadorGlobal(pathSalida);

		// Fichero creacion tablas
		crearFicheroGeneracionDDBB(tablasCreadas, elements, nombreModelo, pathSalida);

		// Comenzamos a generar codigo JSP
		crearInicio(tablasCreadas, elements, nombreModelo, pathSalida);

		for (int i = 0; i < tablasCreadas.size(); i++) {
			System.out.println(tablasCreadas.get(i));
		}

	}


	private void anyadirImportsYPackage(EClass eClass, String nombreFichero, String nombreClase) {
		// TODO Auto-generated method stub
		
	}

	private void declaracionDeAtributos(EClass eClass, String nombreFichero, String nombreClase) {
		// TODO Auto-generated method stub
		
	}

	private void creacionDeInterfacesConHerencia(EClass eClass, String nombreFichero, String nombreClase) {
		// TODO Auto-generated method stub
		
	}

	private void definicionDeAtributos(EClass eClass, String nombreFichero, String nombreClase) {
		// TODO Auto-generated method stub
		
	}

	private void definicionDeClase(EClass eClass, String nombreFichero, String nombreClase) {
		// TODO Auto-generated method stub
		
	}

	private void crearRegistroTabla(LinkedHashMap<String, String> tablasCreadas, EClass eClass, List<EClassifier> elements,
			String nombreModelo,String pathSalida) {
		
		
		Integer[] idVariableYClase = {0, 0};
		Integer quienSoy = idVariableYClase[0];
		
		String nombreClase = "Insert"+eClass.getName();
		//ficheroSalida
		//String nombreFichero = "src/codigoServlet/";
		String nombreFichero = pathSalida+ File.separator +"codigoServlet"+ File.separator;

		nombreFichero += nombreClase;
		nombreFichero += ".java"; // SE CREA FICHERO JSP
		System.out.println("Entrando a crear inicio exitosamente.");
		Integer i = 0;
		Integer nVariablesEscritas=0;
		Integer nClasesEscritas=0;
		// eliminamos las tablas que son nm

		for (EClassifier classifier : elements) {
			for (EClassifier innerClassifier : elements) {
				// if (classifier != innerClassifier) {
				String className = classifier.getName();
				String innerClassName = innerClassifier.getName();
				String tableToRemove = className + "_" + innerClassName;
				tablasCreadas.remove(tableToRemove);
				// }
			}
		}
		// CREAMOS EL DIRECTORIO
		//ficheroSalida

		//File carpeta = new File("src/codigoServlet");
		File carpeta = new File(pathSalida + File.separator +"codigoServlet");

		if (!carpeta.exists()) {
			boolean resultado = carpeta.mkdirs();
			if (resultado) {
				System.out.println("Carpeta creada exitosamente.");
			} else {
				System.out.println("No se pudo crear la carpeta.");
			}
		}

		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("package codigoServlet;\n");

			myWriter.write("import java.io.IOException;\n");
			myWriter.write("import java.io.PrintWriter;\n");
			myWriter.write("import java.sql.Connection;\n");
			myWriter.write("import java.sql.DriverManager;\n");
			myWriter.write("import java.sql.PreparedStatement;\n");
			myWriter.write("import java.sql.ResultSet;\n");
			myWriter.write("import java.sql.SQLException;\n");
			myWriter.write("import java.util.ArrayList;\n");
			myWriter.write("import java.util.LinkedHashMap;\n");
			myWriter.write("import java.util.List;\n");
			myWriter.write("import java.util.Map;\n");
			myWriter.write("\n");
			myWriter.write("import javax.servlet.ServletException;\n");
			myWriter.write("import javax.servlet.annotation.WebServlet;\n");
			myWriter.write("import javax.servlet.http.HttpServlet;\n");
			myWriter.write("import javax.servlet.http.HttpServletRequest;\n");
			myWriter.write("import javax.servlet.http.HttpServletResponse;\n");
			myWriter.write("\n");
			myWriter.write("import javaCode.*;\n");
			myWriter.write("import sql.*;\n");
			myWriter.write("\n");
			myWriter.write("@WebServlet(\"/insert" + eClass.getName() + "\")\n");
			myWriter.write("public class Insert" + eClass.getName() + " extends HttpServlet {\n");
			myWriter.write("\n");
			// myWriter.write("\tprivate final static String query = \"select * from
			// user\";\n");
			myWriter.write("\n");
			myWriter.write("\t@Override\n");
			myWriter.write(
					"\tprotected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {\n");
			myWriter.write("\n");
			myWriter.write(
					"\t\tList<" + eClass.getName() + "> variableClase = new ArrayList<" + eClass.getName() + ">(); \n");
			myWriter.write("\t\tLinkedHashMap<String, String> atributosClase = new LinkedHashMap<String, String>();\n");
			myWriter.write("\t\t" + eClass.getName() + "SQL variableClaseSQL= new " + eClass.getName() + "SQL();\n");
			myWriter.write("\t\t" + eClass.getName() + " sj = new " + eClass.getName() + "();\n");
			myWriter.write("\t\t//get PrintWriter\n");
			myWriter.write("\t\tPrintWriter pw = res.getWriter();\n");
			myWriter.write("\t\t//set content type\n");
			myWriter.write("\t\tres.setContentType(\"text/html\");\n");
			myWriter.write("\t\t// link the bootstrap\n");
			myWriter.write("\t\tpw.println(\"<link rel='stylesheet' href =  'css/bootstrap.css'> </link>\");\n");
			myWriter.write("\n");
			myWriter.write("\t\tatributosClase= sj.obtenerAtributosJava();\n");
			myWriter.write("\t\t//load the jdbc driver\n");
			
			//Se crean los try
			myWriter.write("\t\t\ttry {\n");
			myWriter.write("\t\t\t\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
			myWriter.write("\t\t\t}catch(Exception e) {\n");
			myWriter.write("\t\t\t\te.printStackTrace();\n");
			myWriter.write("\t\t\t}\n");
			myWriter.write("\t\t\tConnection connection = null;\n");
			myWriter.write("\t\t\tSystem.out.println(\"HOLAAAAAAAAAAAAAAAA\");\n");

			myWriter.write("\ttry {\n");
			myWriter.write("\t\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
			myWriter.write("\t\tString dbURL = \"jdbc:mysql://localhost:3306/jdbcdb\";\n");
			myWriter.write("\t\tString username = \"root\";\n");
			myWriter.write("\t\tString password = \"root\";\n");
			myWriter.write("\t\tconnection = DriverManager.getConnection(dbURL,username, password);\n");
			//Registrar a la clase
			
			//Lo primero será registrar la clase y obtener el id
			
			
			 myWriter.write("\t\tString last"+eClass.getName() +idVariableYClase[1] +" "  +" = \"-1\";\n");

			
			// Se crea la clase sql
			myWriter.write("\t\t//Se crea la clase principal\n");

			myWriter.write("\t\t"+eClass.getName() +"SQL" +" v_" + eClass.getName() +"SQL"+idVariableYClase[1] +" "  +" = new "+ eClass.getName()+"SQL();"+"\n");
			 
			 
			 
			 
			 //StoreSQL variableClaseSQL= new StoreSQL();
			///////PARTEA - correcto
			// Recorremos los eattributes y vemos si son lista o no 
			Integer atributosDelInsert=0;
			
			// ponemos esto aqui para despues el insert que se correspondan los numeros
			Integer variablesInsertadas=  idVariableYClase[0]; 
			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				if (eAttribute.getUpperBound() == 1) {
				 String nombreEattribute = eAttribute.getName();
				 String tipoEattribute = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//
				 				 
				 myWriter.write("\t\tString " + nombreEattribute +"_"+idVariableYClase[0] +" = req.getParameter(\""+nombreEattribute+"_"+idVariableYClase[0]+"\");\n");
				 
				 idVariableYClase[0] = idVariableYClase[0] + 1;
				 atributosDelInsert++;

				 
				}
			}
			
			// Iniciamos el insert
			myWriter.write("\t\t//Se inserta una fila de la clase principal\n");

			 myWriter.write("\t\tv_" + eClass.getName() +"SQL"+idVariableYClase[1] +".insertRow"  + eClass.getName() + "(" + "connection"+"");

			 if (atributosDelInsert>0) {
				 myWriter.write(",");
				 
			 }
			 
			// Es necesario recorrer el primer bucle de nuevo para crear el insert
			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				if (eAttribute.getUpperBound() == 1) {
					String nombreEattribute = eAttribute.getName();
					String tipoEattribute = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//

					myWriter.write("" + nombreEattribute + "_" + variablesInsertadas);

					atributosDelInsert--;

					if (atributosDelInsert > 0) {
						myWriter.write(",");

					}
					//
					// myWriter.write("\t\t\t\t\t"+eClass.getName() +"SQL" +" v_" + eClass.getName()
					// +"SQL"+idVariableYClase[1] +" " +" = new "+ eClass.getName()+"SQL();"+"\n");

					variablesInsertadas = variablesInsertadas + 1;
					// myWriter.write("\t\t\t\t<td>"+deQuienSoy
					// +"_"+nombreEattribute+"_"+idVariableYClase[0]+"</td>\n");
					// myWriter.write("\t\t\t\t<td><select name=\""+deQuienSoy+"_"+
					// nombreEattribute+"_"+idVariableYClase[0]+"\">\n");
					// myWriter.write("\t\t\t\t\t<option value=\"true\">true</option>\n");
					// myWriter.write("\t\t\t\t\t<option value=\"false\">false</option>\n");
				}

			}
			
			 myWriter.write(");\n\n");

			//Una vez ya se ha creado la row, obtenemos el ultimo id
			 myWriter.write("\t\t"+"last"  + eClass.getName() +""+idVariableYClase[1] +" ="+ "Integer.toString(v_" + eClass.getName() +"SQL"+idVariableYClase[1] +".getLastRow"  + eClass.getName() + "(" + "connection"+"));\n");

			
			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				 String nombreEattribute = eAttribute.getName();
				 String tipoEattribute = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//
					
				 if(eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) { // es una lista
					System.out.println("REVISANDO clase - " + eClass.getName()+ " atributo --> " + nombreEattribute+ " tipo -->  " + tipoEattribute);
					i=0;
					
					//Creamos la clase solo si es necesario
					if (eAttribute.getLowerBound()>0) {
					//Se crea una variable sql con el nombre de la clase SQL _
					myWriter.write("\t\t//Se crea clase para tabla primitivo del atributo " + nombreEattribute +"\n");

					 myWriter.write("\n\t\t"+eClass.getName() + "_" + nombreEattribute +"SQL" +" v_" + eClass.getName()+nombreEattribute +"SQL"+idVariableYClase[1] +" "  +" = new "+ eClass.getName()+ "_" + nombreEattribute +"SQL();"+"\n");
					}
					
					
					for (i=0; i<eAttribute.getLowerBound();i++) {
						
						
						 myWriter.write("\t\tString "+ nombreEattribute +"_"+idVariableYClase[0] +" = req.getParameter(\""+nombreEattribute+"_"+idVariableYClase[0]+"\");\n");

						//se inserta por cada una de las variables introducidas
						 myWriter.write("\t\t" + "v_" + eClass.getName()+nombreEattribute +"SQL"+idVariableYClase[1] +".insertRow"+eClass.getName() + "_" + nombreEattribute  + "(connection,"+"last"  + eClass.getName() +""+idVariableYClase[1]+","+ nombreEattribute +"_"+idVariableYClase[0]+");\n");
						
						 
						 idVariableYClase[0] = idVariableYClase[0] + 1;
					
					}		
				}
			}
		 

		///////PARTEB - correcto
			// primer bucle para ereferences no containments
			for (EReference eReference : eClass.getEAllReferences()) {
				//String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
				String nombreEreference = eReference.getName();
				if (!eReference.isContainment()) {// nos fijamos en el upperbound para saber si es atributo o lista
					//Creamos la clase solo si es necesario
					if (eReference.getLowerBound()>0) {
					//Se crea una variable sql con el nombre de la clase SQL _
					 myWriter.write("\t\t//Se crea clase para tabla EREFERNCE NO CONTAINMENT de la referencia " + nombreEreference +"\n");

					 myWriter.write("\n\t\t"+eClass.getName() + "_" + nombreEreference +"SQL" +" v_" + eClass.getName()+nombreEreference +"SQL"+idVariableYClase[1] +" "  +" = new "+ eClass.getName()+ "_" + nombreEreference +"SQL();"+"\n");
					}
					
					
					
					// si no es containment, que se añada id y punto hasta el lowerbound
					
					
					for (i=0; i<eReference.getLowerBound();i++) {
						
						 myWriter.write("\t\tString "+ nombreEreference +"_"+idVariableYClase[0] +" = req.getParameter(\""+nombreEreference+"_"+idVariableYClase[0]+"\");\n");

						//se inserta por cada una de las variables introducidas
						 myWriter.write("\t\t" + "v_" + eClass.getName()+nombreEreference +"SQL"+idVariableYClase[1] +".insertRow"+eClass.getName() + "_" + nombreEreference  + "(connection,"+"last"  + eClass.getName() +""+idVariableYClase[1]+","+ nombreEreference +"_"+idVariableYClase[0]+");\n");
						
						 
						 idVariableYClase[0] = idVariableYClase[0] + 1;
						 //meter en la tabla intermedia, que se llaman						
					}
				}

			}
			 myWriter.write("\t\t//Se COMIENZA CON LAS REFERENCIAS CONTAINMENT METODO PRINCIPAL-----------------\n");

			///////PARTEC Correcto
			for (EReference eReference : eClass.getEAllReferences()) {
				String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
				String nombreEreference = eReference.getName();
				if (eReference.isContainment()) {// nos fijamos en el upperbound para saber si es atributo o lista
					// si es containment debemos crearlo in situ
					for (i=0; i<eReference.getLowerBound();i++) {
						idVariableYClase = crearRegistroTablaReferencia(eClass,nombreEreference, tipoE, myWriter, eReference,elements,idVariableYClase,quienSoy);
					}
					System.out.println("REVISANDO clase - " + eClass.getName()+ " Referencia --> " + nombreEreference+ " tipo -->  " + tipoE);
					System.out.println("Containment: " +eReference.isContainment() +"\n");
				}

			}


			myWriter.write("\t}catch(SQLException se){\n");

			myWriter.write("\t		pw.println(\"<h2>\" +se.getMessage() + \"</h2>\"  );\n");
			myWriter.write("\t		se.printStackTrace();\n");
			myWriter.write("\t	}\n");
			myWriter.write("\tcatch(Exception e){\n");
			myWriter.write("\t	System.out.println(\"GGGGGGGGGGGGGGG\");\n");

			myWriter.write("\t	e.printStackTrace();\n");
			myWriter.write("\t}\n");

			myWriter.write("\tpw.println(\"</div>\");\n");


			//mostramos la ventana de que se ha introducido correctamente
			myWriter.write("\tpw.println(\"<h2 class = 'bg-success text-light text-center'> Record Inserted Succesfully</h2>\"  );\n");
			myWriter.write("\tpw.println(\"<a href = 'index.jsp'><button class = 'btn btn-primary btn-separado text-decoration-none'>Home</button></a>\");\n");

			myWriter.write("\t//close the stream\n");
			myWriter.write("\tpw.close();\n");
			
			myWriter.write("\t}\n");

			myWriter.write("\t@Override\n");
			myWriter.write(
					"\tprotected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {\n");
			myWriter.write("\tdoGet(req,res);\n");

			myWriter.write("\t}\n");

			myWriter.write("\t}\n");

			
			//FIN
			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		
		
		
	}

	//REFERENCIAS CREACION
	private Integer[] crearRegistroTablaReferencia(EClass eClass, String nombreEreferenceQueSoy, String tipoEReferenceQueSoy,
			FileWriter myWriter, EReference eReferenceQueSoy, List<EClassifier> elements, Integer[] idVariableYClase,
			Integer deQuienSoy) {

		Integer i;
		
		//Asignar clase referencia
		
		// Obtenemos la clase de la que viene la referencia
		EClass eClassReference = eClass;
		for (EClassifier classifier : elements) {
			// Taking the EClass elements
			if (classifier instanceof EClass) {

				EClass eClassReviewing = (EClass) classifier;

				System.out.println("Chequeando si la clase " + eClassReviewing.getName() + " es   "
						+ eClass.getName());

				if (eClassReviewing.getName() == tipoEReferenceQueSoy) { // si no es la misma
					// clase
					eClassReference = eClassReviewing;
				}

			}
		}
		
		
		//
		//anyadimos 1 al numero de clase
		idVariableYClase[1] = idVariableYClase[1] + 1;
		
		Integer quienSoy = idVariableYClase[1];
		try {
		
		 myWriter.write("\t\tString last"+eClassReference.getName() +idVariableYClase[1] +" "  +" = \"-1\";\n");

			
		// Se crea la clase sql
		myWriter.write("\t\t//Se crea la clase principal\n");

		myWriter.write("\t\t"+eClassReference.getName() +"SQL" +" v_" + eClassReference.getName() +"SQL"+idVariableYClase[1] +" "  +" = new "+ eClassReference.getName()+"SQL();"+"\n");
		 
		 
		 
		 //StoreSQL variableClaseSQL= new StoreSQL();
		///////PARTEA - correcto
		// Recorremos los eattributes y vemos si son lista o no 
		Integer atributosDelInsert=0;
		
		//ESTO LO HACEMOS PARA COINCIDIR LOS IDS DE LA LINEA DEL INSERT
		Integer variablesInsertadas = idVariableYClase[0];
		for (EAttribute eAttribute : eClassReference.getEAllAttributes()) {
			if (eAttribute.getUpperBound() == 1) {
			 String nombreEattribute = eAttribute.getName();
			 String tipoEattribute = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//
			 				 
			 myWriter.write("\t\tString " + nombreEattribute +"_"+idVariableYClase[0] +" = req.getParameter(\""+nombreEattribute+"_"+idVariableYClase[0]+"\");\n");
			 			 
			 idVariableYClase[0] = idVariableYClase[0] + 1;
			 atributosDelInsert++;

			 
			}
		}
		
		// Iniciamos el insert
		myWriter.write("\t\t//Se inserta una fila de la clase principal\n");

		 myWriter.write("\t\tv_" + eClassReference.getName() +"SQL"+idVariableYClase[1] +".insertRow"+ eClassReference.getName() +"byid_"  + eClass.getName() + "_" + nombreEreferenceQueSoy+  "(" + "connection"+"");

		 if (atributosDelInsert>0) {
			 myWriter.write(",");
			 
		 }
		 
		 
		// Es necesario recorrer el primer bucle de nuevo para crear el insert
		for (EAttribute eAttribute : eClassReference.getEAllAttributes()) {
			if (eAttribute.getUpperBound() == 1) {
				String nombreEattribute = eAttribute.getName();
				String tipoEattribute = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//

				myWriter.write("" + nombreEattribute + "_" + variablesInsertadas);

				atributosDelInsert--;

				if (atributosDelInsert > 0) {
					myWriter.write(",");

				}
				//
				// myWriter.write("\t\t\t\t\t"+eClass.getName() +"SQL" +" v_" + eClass.getName()
				// +"SQL"+idVariableYClase[1] +" " +" = new "+ eClass.getName()+"SQL();"+"\n");

				variablesInsertadas = variablesInsertadas + 1;
				// myWriter.write("\t\t\t\t<td>"+deQuienSoy
				// +"_"+nombreEattribute+"_"+idVariableYClase[0]+"</td>\n");
				// myWriter.write("\t\t\t\t<td><select name=\""+deQuienSoy+"_"+
				// nombreEattribute+"_"+idVariableYClase[0]+"\">\n");
				// myWriter.write("\t\t\t\t\t<option value=\"true\">true</option>\n");
				// myWriter.write("\t\t\t\t\t<option value=\"false\">false</option>\n");
			}

		}
		//anyadimos a manini el id de quien soy referencia
		myWriter.write(",");
		myWriter.write("last" + eClass.getName() + deQuienSoy); //eClass.getName()???
		//lastItem1
		 myWriter.write(");\n\n");

		//Una vez ya se ha creado la row, obtenemos el ultimo id
		 myWriter.write("\t\t"+"last"  + eClassReference.getName() +""+idVariableYClase[1] +" ="+ "Integer.toString(v_" + eClassReference.getName() +"SQL"+idVariableYClase[1] +".getLastRow"  + eClassReference.getName() + "(" + "connection"+"));\n");

		
		for (EAttribute eAttribute : eClassReference.getEAllAttributes()) {
			 String nombreEattribute = eAttribute.getName();
			 String tipoEattribute = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//
				
			 if(eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) { // es una lista
				System.out.println("REVISANDO clase - " + eClassReference.getName()+ " atributo --> " + nombreEattribute+ " tipo -->  " + tipoEattribute);
				i=0;
				
				//Creamos la clase solo si es necesario
				if (eAttribute.getLowerBound()>0) {
				//Se crea una variable sql con el nombre de la clase SQL _
				myWriter.write("\t\t//Se crea clase para tabla primitivo del atributo " + nombreEattribute +"\n");

				 myWriter.write("\n\t\t"+eClassReference.getName() + "_" + nombreEattribute +"SQL" +" v_" + eClassReference.getName()+nombreEattribute +"SQL"+idVariableYClase[1] +" "  +" = new "+ eClassReference.getName()+ "_" + nombreEattribute +"SQL();"+"\n");
				}
				
				
				for (i=0; i<eAttribute.getLowerBound();i++) {
					
					
					 myWriter.write("\t\tString "+ nombreEattribute +"_"+idVariableYClase[0] +" = req.getParameter(\""+nombreEattribute+"_"+idVariableYClase[0]+"\");\n");

					//se inserta por cada una de las variables introducidas
					 myWriter.write("\t\t" + "v_" + eClassReference.getName()+nombreEattribute +"SQL"+idVariableYClase[1] +".insertRow"+eClassReference.getName() + "_" + nombreEattribute  + "(connection,"+"last"  + eClassReference.getName() +""+idVariableYClase[1]+","+ nombreEattribute +"_"+idVariableYClase[0]+");\n");
					
					 
					 idVariableYClase[0] = idVariableYClase[0] + 1;
				
				}		
			}
		}
	 

	///////PARTEB - correcto
		// primer bucle para ereferences no containments
		for (EReference eReference : eClassReference.getEAllReferences()) {
			//String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
			String nombreEreference = eReference.getName();
			if (!eReference.isContainment()) {// nos fijamos en el upperbound para saber si es atributo o lista
				//Creamos la clase solo si es necesario
				if (eReference.getLowerBound()>0) {
				//Se crea una variable sql con el nombre de la clase SQL _
				 myWriter.write("\t\t//Se crea clase para tabla EREFERNCE NO CONTAINMENT de la referencia " + nombreEreference +"\n");

				 myWriter.write("\n\t\t"+eClassReference.getName() + "_" + nombreEreference +"SQL" +" v_" + eClassReference.getName()+nombreEreference +"SQL"+idVariableYClase[1] +" "  +" = new "+ eClassReference.getName()+ "_" + nombreEreference +"SQL();"+"\n");
				}
				
				// si no es containment, que se añada id y punto hasta el lowerbound
				
				
				for (i=0; i<eReference.getLowerBound();i++) {
					
					 myWriter.write("\t\tString "+ nombreEreference +"_"+idVariableYClase[0] +" = req.getParameter(\""+nombreEreference+"_"+idVariableYClase[0]+"\");\n");

					//se inserta por cada una de las variables introducidas
					 myWriter.write("\t\t" + "v_" + eClassReference.getName()+nombreEreference +"SQL"+idVariableYClase[1] +".insertRow"+eClassReference.getName() + "_" + nombreEreference  + "(connection,"+"last"  + eClassReference.getName() +""+idVariableYClase[1]+","+ nombreEreference +"_"+idVariableYClase[0]+");\n");
					 
					 idVariableYClase[0] = idVariableYClase[0] + 1;
					 //meter en la tabla intermedia, que se llaman						
				}
			}

		}
		 myWriter.write("\t\t//Se COMIENZA CON LAS REFERENCIAS CONTAINMENT METODO REFERENCIA TABLASS -----------------\n");

		///////PARTEC Correcto
		for (EReference eReference : eClassReference.getEAllReferences()) {
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
			String nombreEreference = eReference.getName();
			if (eReference.isContainment()) {// nos fijamos en el upperbound para saber si es atributo o lista
				// si es containment debemos crearlo in situ
				for (i=0; i<eReference.getLowerBound();i++) {
					idVariableYClase = crearRegistroTablaReferencia(eClassReference,nombreEreference, tipoE, myWriter, eReference,elements,idVariableYClase,quienSoy);
				}
				System.out.println("REVISANDO clase - " + eClassReference.getName()+ " Referencia --> " + nombreEreference+ " tipo -->  " + tipoE);
				System.out.println("Containment: " +eReference.isContainment() +"\n");
			}
		}

		}catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		return idVariableYClase;
		
	}

	private void crearFicheroGeneracionDDBB(LinkedHashMap<String, String> tablasCreadas, List<EClassifier> elements,
			String nombreModelo, String pathSalida) {

		// Hacer creacion de fichero .java
		// Hacer bucle imports
		
		String nombreFicheroSQL = pathSalida + File.separator + "sql" + File.separator;
		//ficheroSalida
		String nombreFichero = pathSalida + File.separator + "javaCode" + File.separator;

		nombreFichero += "ficheroCreacionDDBB";
		nombreFichero += ".java";

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\npackage javaCode;\n");

			myWriter.write("import java.util.*;\n");
			myWriter.write("import java.sql.Connection;\n");
			myWriter.write("import java.sql.DriverManager;\n\n");
			myWriter.write("import java.sql.SQLException;\n\n");

			for (String nombreTabla : tablasCreadas.keySet()) {

				String tabla = nombreTabla;

				myWriter.write("import sql." + tabla + "SQL;\n");

			}

			myWriter.write("public class ficheroCreacionDDBB {\n\n");

			myWriter.write("\tpublic static void main(String[] args) throws SQLException{\n\n");

			//
			myWriter.write("\t\ttry {\n");
			myWriter.write("\t\t\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
			myWriter.write("\t\t}catch(Exception e) {\n");
			myWriter.write("\t\t\te.printStackTrace();\n");
			myWriter.write("\t\t}\n");
			myWriter.write("\t\tConnection connection = null;\n");
			myWriter.write("\t\tSystem.out.println(\"EJECUTANDO MAIN QUE CREA DDBB\");\n");

			myWriter.write("try {\n");
			myWriter.write("\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
			myWriter.write("\tString dbURL = \"jdbc:mysql://localhost:3306/jdbcdb\";\n");
			myWriter.write("\tString username = \"root\";\n");
			myWriter.write("\tString password = \"root\";\n");
			myWriter.write("\tconnection = DriverManager.getConnection(dbURL,username, password);\n");
			//
			myWriter.write("\t	}\n");
			myWriter.write("\tcatch(Exception e){\n");
			myWriter.write("\t	System.out.println(\"GGGGGGGGGGGGGGG\");\n");

			myWriter.write("\t	e.printStackTrace();\n");
			myWriter.write("\t}\n");

			// myWriter.write("\t}\n");

			Integer i = 0;
			for (String nombreTabla : tablasCreadas.keySet()) {

				String tabla = nombreTabla;

				myWriter.write("\t\t" + tabla + "SQL var" + i + "= new " + tabla + "SQL();\n");

				myWriter.write("\t\tvar" + i + ".createTable" + tabla + "(connection);\n\n");
				i++;
			}
			//anyadimos las constraints
			 i = 0;
			for (String nombreTabla : tablasCreadas.keySet()) {

				String tabla = nombreTabla;


				myWriter.write("\t\tvar" + i + ".createTable" + tabla + "Constraints(connection);\n\n");
				i++;
			}

			myWriter.write("\t}\n");
			myWriter.write("}");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	private void crearFicheroIdentificadorGlobal(String pathSalida) {
		try {
			FileWriter myWriter = new FileWriter(pathSalida + File.separator +"codigoServlet/GlobalIdGenerator.java", true);
			// myWriter.write("package codigoServlet;\n");
			myWriter.write("public class GlobalIdGenerator {\n\n");
			myWriter.write("    private static GlobalIdGenerator instance = null;\n");
			myWriter.write("    private int counter = 0;\n");
			myWriter.write("\n");
			myWriter.write("    private GlobalIdGenerator() {\n");
			myWriter.write(
					"        // Constructor privado para evitar la creación de instancias desde fuera de la clase\n");
			myWriter.write("    }\n");
			myWriter.write("\n");
			myWriter.write("    public static GlobalIdGenerator getInstance() {\n");
			myWriter.write("        if (instance == null) {\n");
			myWriter.write("            instance = new GlobalIdGenerator();\n");
			myWriter.write("        }\n");
			myWriter.write("        return instance;\n");
			myWriter.write("    }\n");
			myWriter.write("\n");
			myWriter.write("    public synchronized String getNewId() {\n");
			myWriter.write("        counter++;\n");
			myWriter.write("        String id = String.format(\"%010d\", counter);\n");
			myWriter.write("        return id;\n");
			myWriter.write("    }\n");
			myWriter.write("}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void limpiarFicherosJSP(String pathSalida) {
		// limpiamos jsp
		// Eliminamos codigo sql
		// LIMPIEZA DE DATOS ANTERIORES
		//File dir = new File("./src/jsp");
		File dir = new File(pathSalida + File.separator + "jsp");
		File[] files = dir.listFiles((dir1, name) -> name.endsWith(".jsp"));
		if (files != null) {
			for (File file : files) {
				if (!file.delete()) {
					System.out.println("No se pudo eliminar el archivo " + file.getName());
				} else {
					System.out.println("JSP - Archivo " + file.getName() + "eliminado correctamente");

				}
			}
		}

	}

	private void limpiarFicherosCodigoServlet(String pathSalida) {
		// limpiamos jsp
		// Eliminamos codigo sql
		// LIMPIEZA DE DATOS ANTERIORES
		
		//File dir = new File("./src/codigoServlet");
		File dir = new File(pathSalida + File.separator +"codigoServlet");
		File[] files = dir.listFiles((dir1, name) -> name.endsWith(".java"));
		if (files != null) {
			for (File file : files) {
				if (!file.delete()) {
					System.out.println("No se pudo eliminar el archivo " + file.getName());
				} else {
					System.out.println("Archivo " + file.getName() + "eliminado correctamente");

				}
			}
		}

	}

	private void crearClaseAuxiliarMetodosEstaticos(List<EClassifier> elements, String pathSalida) {

		String nombreClase = "MetodosAuxiliares";
		String nombreFichero = pathSalida + File.separator + "javaCode"+File.separator;
		nombreFichero += nombreClase;
		nombreFichero += ".java"; // SE CREA FICHERO JSP

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("package javaCode;\n\n");
			myWriter.write("public class MetodosAuxiliares {\n\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\tpublic static String tipoJavaATipoGetResult(String tipoJava) {\n");
			myWriter.write("\t\tString tipoGetResult = \"\";\n");
			myWriter.write("\t\tswitch (tipoJava) {\n");
			myWriter.write("\t\t\tcase \"Boolean\":\n");
			myWriter.write("\t\t\ttipoGetResult = \"getBoolean\";\n");
			myWriter.write("\t\t\tbreak;\n");
			myWriter.write("\t\tcase \"String\":\n");
			myWriter.write("\t\t\ttipoGetResult = \"getString\";\n");
			myWriter.write("\t\t\tbreak;\n");
			myWriter.write("\t\tcase \"java.sql.Date\":\n");
			myWriter.write("\t\t\ttipoGetResult = \"getDate\";\n");
			myWriter.write("\t\t\tbreak;\n");
			myWriter.write("\t\tcase \"Double\":\n");
			myWriter.write("\t\t\ttipoGetResult = \"getDouble\";\n");
			myWriter.write("\t\t\tbreak;\n");
			myWriter.write("\t\tcase \"Long\":\n");
			myWriter.write("\t\t\ttipoGetResult = \"getLong\";\n");
			myWriter.write("\t\t\tbreak;\n");
			myWriter.write("\t\tcase \"Integer\":\n");
			myWriter.write("\t\t\ttipoGetResult = \"getInt\";\n");
			myWriter.write("\t\t\tbreak;\n");
			myWriter.write("\t\tcase \"Float\":\n");
			myWriter.write("\t\t\ttipoGetResult = \"getFloat\";\n");
			myWriter.write("\t\t\tbreak;\n");
			myWriter.write("\t\tcase \"Short\":\n");
			myWriter.write("\t\t\ttipoGetResult = \"getShort\";\n");
			myWriter.write("\t\t\tbreak;\n");
			myWriter.write("\t\tdefault:\n");
			myWriter.write("\t\t\ttipoGetResult = \"getString\";\n");
			myWriter.write("\t\t}\n");
			myWriter.write("\t\treturn tipoGetResult;\n");
			myWriter.write("\t}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\n}");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	// Creamos los metodos auxiliares para generar el codigo JSP para las tablas
	// clases
	private void crearMetodosAuxiliaresClase(EClass eClass, String nombreFichero, List<EClassifier> elements) {

		LinkedHashMap<String, String> atributosClase = new LinkedHashMap<>();

		atributosClase = devuelveAtributosTablaClase(eClass, elements);

		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);

			/*
			 * public void updateTableSchool (Connection connection, Integer idP, String
			 * nameP) throws SQLException { String sql =
			 * "update School set name=? WHERE id =? )"; PreparedStatement preparedStatement
			 * = connection.prepareStatement(sql); preparedStatement.setString(1,nameP);
			 * preparedStatement.setInt(2,idP); int rows =
			 * preparedStatement.executeUpdate(); if (rows >0){
			 * System.out.println("Fila actualizada correctamente en la tablaSchool"); } }
			 */
			myWriter.write("\tpublic LinkedHashMap<String, String> devuelveAtributosYTiposSQL(){\n");
			myWriter.write("\t\tLinkedHashMap<String, String> atributosClase = new LinkedHashMap<String, String>();\n\n");

			// declaramos las variables
			for (String tipo : atributosClase.keySet()) {
				String tipoVariable = tipo;
				String nombreVariable = atributosClase.get(tipo);
				myWriter.write("\t\tatributosClase.put(\"" + tipoVariable + "\", \"" + nombreVariable + "\");\n");

			}
			myWriter.write("\n");

			// las asignamos al atributosClase
			myWriter.write("\t\treturn atributosClase;\n");

			myWriter.write("\t}\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		// Funcion obtenertiposJava

		try {
			LinkedHashMap<String, String> atributosClaseJava = new LinkedHashMap<String, String>();
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			atributosClaseJava = devuelveAtributosJava(eClass);
			myWriter.write("\tpublic LinkedHashMap<String, String> obtenerAtributosJava(){\n");
			myWriter.write("\t\tLinkedHashMap<String, String> atributosClaseJava = new LinkedHashMap<String, String>();\n\n");
			// declaramos las variables
			for (String tipo : atributosClaseJava.keySet()) {
				String tipoVariable = tipo;
				String nombreVariable = atributosClaseJava.get(tipo);
				myWriter.write("\t\tatributosClaseJava.put(\"" + tipoVariable + "\", \"" + nombreVariable + "\");\n");

			}

			myWriter.write("\n");

			// las asignamos al atributosClase
			myWriter.write("\t\treturn atributosClaseJava;\n");

			myWriter.write("\t}\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		// Funcion obteneratributoslista

		try {
			LinkedHashMap<String, String> atributosClaseLista = new LinkedHashMap<String, String>();
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			atributosClaseLista = devuelveAtributosLista(eClass);
			myWriter.write("\tpublic LinkedHashMap<String, String> obtenerAtributosLista(){\n");
			myWriter.write("\t\tLinkedHashMap<String, String> atributosLista = new LinkedHashMap<String, String>();\n\n");
			// declaramos las variables
			for (String tipo : atributosClaseLista.keySet()) {
				String tipoVariable = tipo;
				String nombreVariable = atributosClaseLista.get(tipo);
				myWriter.write("\t\tatributosLista.put(\"" + tipoVariable + "\", \"" + nombreVariable + "\");\n");

			}

			myWriter.write("\n");

			// las asignamos al atributosClase
			myWriter.write("\t\treturn atributosLista;\n");

			myWriter.write("\t}\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		// Funcion obteneratributosNoLista

		try {
			LinkedHashMap<String, String> atributosClaseNoLista = new LinkedHashMap<String, String>();
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			atributosClaseNoLista = devuelveAtributosNoLista(eClass);
			myWriter.write("\tpublic LinkedHashMap<String, String> obtenerAtributosNoLista(){\n");
			myWriter.write("\t\tLinkedHashMap<String, String> atributosNoLista = new LinkedHashMap<String, String>();\n\n");
			// declaramos las variables
			for (String tipo : atributosClaseNoLista.keySet()) {
				String tipoVariable = tipo;
				String nombreVariable = atributosClaseNoLista.get(tipo);
				myWriter.write("\t\tatributosNoLista.put(\"" + tipoVariable + "\", \"" + nombreVariable + "\");\n");

			}

			myWriter.write("\n");

			// las asignamos al atributosClase
			myWriter.write("\t\treturn atributosNoLista;\n");

			myWriter.write("\t}\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		// funcion auxiliar devuelveAtributosTablaClase
		try {
			LinkedHashMap<String, String> atributosTablaClase = new LinkedHashMap<String, String>();
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			atributosTablaClase = devuelveAtributosTablaClase(eClass, elements);
			myWriter.write("\tpublic LinkedHashMap<String, String> devuelveAtributosTablaClase(){\n");
			myWriter.write("\t\tLinkedHashMap<String, String> atributosTablaClase = new LinkedHashMap<String, String>();\n\n");
			// declaramos las variables
			for (String tipo : atributosTablaClase.keySet()) {
				String tipoVariable = tipo;
				String nombreVariable = atributosTablaClase.get(tipo);
				myWriter.write("\t\tatributosTablaClase.put(\"" + tipoVariable + "\", \"" + nombreVariable + "\");\n");

			}

			myWriter.write("\n");

			// las asignamos al atributosClase
			myWriter.write("\t\treturn atributosTablaClase;\n");

			myWriter.write("\t}\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		// funcion auxiliar atributoEsReferencia

		try {
			List<String> atributosReferencia = new ArrayList<String>();
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\tpublic boolean atributoEsReference(String atributoAComprobar){\n");
			myWriter.write("\t\tList<String> atributosReferencia =  new ArrayList<String>();\n\n");

			for (EAttribute eAttribute : eClass.getEAllAttributes()) {

				String tipoE = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());// obtenemos el
																										// tipo
																										// correspondiente
																										// en Java
				String nombreAtributo = eAttribute.getName();

				if (eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) {// nos fijamos en el
																							// upperbound
																							// para saber si es atributo
																							// o
																							// lista

				} else { // si no es una lista

				}
			}
			// anyadimos los atributos de referencia
			// Taking EReferences of the eClass
			for (EReference eReference : eClass.getEAllReferences()) {
				String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
				String nombreAtributo = eReference.getName();
				atributosReferencia.add(nombreAtributo);
				myWriter.write("\t\t atributosReferencia.add(\"" + nombreAtributo + "\"); \n\n");

				if (eReference.getUpperBound() == -1 || eReference.getUpperBound() >= 2) {// nos fijamos en el
																							// upperbound
				} else {

				}
			}

			myWriter.write("\n");

			// las asignamos al atributosClase
			myWriter.write("\t\treturn atributosReferencia.contains(atributoAComprobar);\n");

			myWriter.write("\t}\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		// funcion auxiliar atributoEsLista

		try {
			List<String> atributosLista = new ArrayList<String>();
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\tpublic boolean atributoEsLista(String atributoAComprobar){\n");
			myWriter.write("\t\tList<String> atributosLista =  new ArrayList<String>();\n\n");

			for (EAttribute eAttribute : eClass.getEAllAttributes()) {

				String tipoE = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());// obtenemos el
																										// tipo
																										// correspondiente
																										// en Java
				String nombreAtributo = eAttribute.getName();

				if (eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) {// nos fijamos en el
																							// upperbound
																							// para saber si es atributo
																							// o
					atributosLista.add(nombreAtributo);
					myWriter.write("\t\t atributosLista.add(\"" + nombreAtributo + "\"); \n\n");
					// lista

				} else { // si no es una lista

				}
			}
			// anyadimos los atributos de referencia
			// Taking EReferences of the eClass
			for (EReference eReference : eClass.getEAllReferences()) {
				String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
				String nombreAtributo = eReference.getName();

				if (eReference.getUpperBound() == -1 || eReference.getUpperBound() >= 2) {// nos fijamos en el
																							// upperbound
					atributosLista.add(nombreAtributo);
					myWriter.write("\t\t atributosLista.add(\"" + nombreAtributo + "\"); \n\n");

				} else {

				}
			}

			myWriter.write("\n");

			// las asignamos al atributosClase
			myWriter.write("\t\treturn atributosLista.contains(atributoAComprobar);\n");

			myWriter.write("\t}\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		// funcion auxiliar atributoNoEsLista

		try {
			List<String> atributosNoEsLista = new ArrayList<String>();
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\tpublic boolean atributoNoEsLista(String atributoAComprobar){\n");
			myWriter.write("\t\tList<String> atributosNoLista =  new ArrayList<String>();\n\n");

			for (EAttribute eAttribute : eClass.getEAllAttributes()) {

				String tipoE = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());// obtenemos el
																										// tipo
																										// correspondiente
																										// en Java
				String nombreAtributo = eAttribute.getName();

				if (eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) {// nos fijamos en el
																							// upperbound
																							// para saber si es atributo
																							// o

				} else { // si no es una lista
					myWriter.write("\t\t atributosNoLista.add(\"" + nombreAtributo + "\"); \n\n");

				}
			}
			// anyadimos los atributos de referencia
			// Taking EReferences of the eClass
			for (EReference eReference : eClass.getEAllReferences()) {
				String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
				String nombreAtributo = eReference.getName();

				if (eReference.getUpperBound() == -1 || eReference.getUpperBound() >= 2) {// nos fijamos en el
																							// upperbound

				} else {
					myWriter.write("\t\t atributosNoLista.add(\"" + nombreAtributo + "\"); \n\n");

				}
			}
			myWriter.write("\t\t atributosNoLista.add(\"" + "id" + "\"); \n\n");

			myWriter.write("\n");

			// las asignamos al atributosClase
			myWriter.write("\t\treturn atributosNoLista.contains(atributoAComprobar);\n");

			myWriter.write("\t}\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		// funcion auxiliar getLowerBoundAtributoDado
		try {
			LinkedHashMap<String, Integer> atributoLowerbound = new LinkedHashMap<String, Integer>();
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			// tipo -> tipoAtributoYNombreAtributoList.get(i)

			myWriter.write("\tpublic Integer devuelveLowerBoundAtributo(String nombreAtributo){\n");
			myWriter.write("\t\tLinkedHashMap<String, Integer> atributoLowerbound = new LinkedHashMap<String, Integer>();\n\n");
			myWriter.write("\t\t//Id obligatorio\n");

			myWriter.write("\t\tatributoLowerbound.put(\"" + "id" + "\", " + "1" + ");\n");
			// declaramos las variables
			myWriter.write("\t\t//Atributos\n");

			for (EAttribute eAttribute : eClass.getEAttributes()) {
				// atributoLowerbound.put(eAttribute.getName())
				myWriter.write("\t\tatributoLowerbound.put(\"" + eAttribute.getName() + "\", "
						+ eAttribute.getLowerBound() + ");\n");
			}

			myWriter.write("\t\t//Referencias\n");

			for (EReference eReference : eClass.getEAllReferences()) {

				myWriter.write("\t\tatributoLowerbound.put(\"" + eReference.getName() + "\", "
						+ eReference.getLowerBound() + ");\n");

			}

			myWriter.write("\n");

			// las asignamos al atributosClase
			myWriter.write("\t\treturn atributoLowerbound.get(nombreAtributo);\n");

			myWriter.write("\t}\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

		// funcion auxiliar getUpperBoundAtributoDado
		try {
			LinkedHashMap<String, Integer> atributoUpperbound = new LinkedHashMap<String, Integer>();
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			// tipo -> tipoAtributoYNombreAtributoList.get(i)

			myWriter.write("\tpublic Integer devuelveUpperBoundAtributo(String nombreAtributo){\n");
			myWriter.write("\t\tLinkedHashMap<String, Integer> atributoUpperbound = new LinkedHashMap<String, Integer>();\n\n");
			// declaramos las variables
			myWriter.write("\t\t//Id obligatorio\n");

			myWriter.write("\t\tatributoUpperbound.put(\"" + "id" + "\", " + "1" + ");\n");

			myWriter.write("\t\t//Atributos\n");

			for (EAttribute eAttribute : eClass.getEAttributes()) {
				// atributoLowerbound.put(eAttribute.getName())
				myWriter.write("\t\tatributoUpperbound.put(\"" + eAttribute.getName() + "\", "
						+ eAttribute.getUpperBound() + ");\n");
			}

			myWriter.write("\t\t//Referencias\n");

			for (EReference eReference : eClass.getEAllReferences()) {

				myWriter.write("\t\tatributoUpperbound.put(\"" + eReference.getName() + "\", "
						+ eReference.getUpperBound() + ");\n");

			}

			myWriter.write("\n");

			// las asignamos al atributosClase
			myWriter.write("\t\treturn atributoUpperbound.get(nombreAtributo);\n");

			myWriter.write("\t}\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

	}
	private void crearShowTabla(EClass eClass, LinkedHashMap<String, String> tablasCreadas, List<EClassifier> elements,
			String nombreModelo, String pathSalida) {

		// CREAMOS EL DIRECTORIO
		//FicheroSalida
		//File carpeta = new File("src/codigoServlet");
		File carpeta = new File(pathSalida+File.separator+"codigoServlet");
		if (!carpeta.exists()) {
			boolean resultado = carpeta.mkdirs();
			if (resultado) {
				System.out.println("Carpeta creada exitosamente.");
			} else {
				System.out.println("No se pudo crear la carpeta.");
			}
		}
		
		String nombreClase = "Show" + eClass.getName();
		//ficheroSalida
		//String nombreFichero = "src/codigoServlet/";
		String nombreFichero = pathSalida+File.separator + "codigoServlet" + File.separator;
		
		nombreFichero += nombreClase;
		nombreFichero += ".java"; // SE CREA FICHERO JSP

		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("package codigoServlet;\n");

			myWriter.write("import java.io.IOException;\n");
			myWriter.write("import java.io.PrintWriter;\n");
			myWriter.write("import java.sql.Connection;\n");
			myWriter.write("import java.sql.DriverManager;\n");
			myWriter.write("import java.sql.PreparedStatement;\n");
			myWriter.write("import java.sql.ResultSet;\n");
			myWriter.write("import java.sql.SQLException;\n");
			myWriter.write("import java.util.ArrayList;\n");
			myWriter.write("import java.util.LinkedHashMap;\n");
			myWriter.write("import java.util.List;\n");
			myWriter.write("import java.util.Map;\n");
			myWriter.write("\n");
			myWriter.write("import javax.servlet.ServletException;\n");
			myWriter.write("import javax.servlet.annotation.WebServlet;\n");
			myWriter.write("import javax.servlet.http.HttpServlet;\n");
			myWriter.write("import javax.servlet.http.HttpServletRequest;\n");
			myWriter.write("import javax.servlet.http.HttpServletResponse;\n");
			myWriter.write("\n");
			myWriter.write("import javaCode." + eClass.getName() + ";\n");
			myWriter.write("import sql." + eClass.getName() + "SQL;\n");
			myWriter.write("\n");
			myWriter.write("@WebServlet(\"/show" + eClass.getName() + "\")\n");
			myWriter.write("public class Show" + eClass.getName() + " extends HttpServlet {\n");
			myWriter.write("\n");
			// myWriter.write("\tprivate final static String query = \"select * from
			// user\";\n");
			myWriter.write("\n");
			myWriter.write("\t@Override\n");
			myWriter.write(
					"\tprotected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {\n");
			myWriter.write("\n");
			myWriter.write(
					"\t\tList<" + eClass.getName() + "> variableClase = new ArrayList<" + eClass.getName() + ">(); \n");
			myWriter.write("\t\tLinkedHashMap<String, String> atributosClase = new LinkedHashMap<String, String>();\n");
			myWriter.write("\t\t" + eClass.getName() + "SQL variableClaseSQL= new " + eClass.getName() + "SQL();\n");
			myWriter.write("\t\t" + eClass.getName() + " sj = new " + eClass.getName() + "();\n");
			myWriter.write("\t\t//get PrintWriter\n");
			myWriter.write("\t\tPrintWriter pw = res.getWriter();\n");
			myWriter.write("\t\t//set content type\n");
			myWriter.write("\t\tres.setContentType(\"text/html\");\n");
			myWriter.write("\t\t// link the bootstrap\n");
			myWriter.write("\t\tpw.println(\"<link rel='stylesheet' href =  'css/bootstrap.css'> </link>\");\n");
			myWriter.write("\n");
			myWriter.write("\t\tatributosClase= sj.obtenerAtributosJava();\n");
			myWriter.write("\t\t//load the jdbc driver\n");
			//
			myWriter.write("\t\ttry {\n");
			myWriter.write("\t\t\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
			myWriter.write("\t\t}catch(Exception e) {\n");
			myWriter.write("\t\t\te.printStackTrace();\n");
			myWriter.write("\t\t}\n");
			myWriter.write("\t\tConnection connection = null;\n");
			myWriter.write("\t\tSystem.out.println(\"HOLAAAAAAAAAAAAAAAA\");\n");

			myWriter.write("try {\n");
			myWriter.write("\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
			myWriter.write("\tString dbURL = \"jdbc:mysql://localhost:3306/jdbcdb\";\n");
			myWriter.write("\tString username = \"root\";\n");
			myWriter.write("\tString password = \"root\";\n");
			myWriter.write("\tconnection = DriverManager.getConnection(dbURL,username, password);\n");

			// myWriter.write("\tPreparedStatement ps =
			// connection.prepareStatement(query);\n");
			// myWriter.write("\tResultSet rs = ps.executeQuery();\n");
			myWriter.write("\tpw.println(\"<div style = 'margin:auto;width:800px;margin-top:100px'>\");\n");
			myWriter.write("\tpw.println(\"<div style = 'margin:auto;width:800px;margin-top:100px'>\");\n");
			myWriter.write(
					"\tpw.println(\"<a href = 'index.jsp'><button class = 'btn btn-outline-success'>Home</button></a>\");\n");
			myWriter.write(
					"\tpw.println(\"<a href = 'index.jsp'><button class = 'btn btn-outline-primary'>Filtrar</button></a>\");\n");
			//Comprobar si es containment o no para mostrar este boton
			if (!claseEsContainment(eClass,elements))
			myWriter.write("\tpw.println(\"<a href = 'create" + eClass.getName()+".jsp'><button class = 'btn btn-outline-primary'>Introducir "
					+ eClass.getName() + "</button></a>\");\n");
			myWriter.write("\tpw.println(\"</div>\");\n");
			myWriter.write("\tpw.println(\"<table class = 'table table-hover table-striped'>\");\n");

			// cabecera edit y delete
			myWriter.write("\tpw.println(\"<tr>\");\n");
			myWriter.write("\tpw.println(\"<th>Edit</th>\");\n");
			myWriter.write("\tpw.println(\"<th>Delete</th>\");\n");
			// cabeceras de los atributos java
			myWriter.write("\tfor (Map.Entry<String, String> entry : atributosClase.entrySet()) {\n");
			myWriter.write("\t\tString clave = entry.getKey();\n");
			myWriter.write("\t\tString valor = entry.getValue();\n");
			//myWriter.write("\t\tif (clave!=\"id\"){;\n");

			myWriter.write("\t\tpw.println(\"<th>\" + clave + \"</th>\");\n");
			myWriter.write("\t\t};\n");

			//myWriter.write("\t}");

			myWriter.write("\tpw.println(\"</tr>\");\n");
			myWriter.write("\t List <" + eClass.getName() + ">" + eClass.getName().toLowerCase() + "s"
					+ "= variableClaseSQL.readAll(connection);\n");

			myWriter.write("\tfor(" + eClass.getName() + " " + eClass.getName().toLowerCase() + " : "
					+ eClass.getName().toLowerCase() + "s) {\n");
			// edit y delete de la fila
			myWriter.write("\t\tpw.println(\"<tr>\");\n");
			myWriter.write("\t\tpw.println(\"<td><a href='editurl?id=\"+" + eClass.getName().toLowerCase()
					+ ".getId()+\"'>Edit</a> </td>\");\n");

			myWriter.write("\t\tpw.println(\"<td><a href='deleteurl?id=\"+" + eClass.getName().toLowerCase()
					+ ".getId()+\"'>Delete</a> </td>\");\n");
			/* Voy por aqui pero bueno */
			// Comenzamos a poner los atributos de la fila
			LinkedHashMap<String, String> variablesJava = devuelveAtributosJava(eClass);
			System.out.println("PRINTEANDO ATRIBUTOS PARA EL SHOW de la clase : " + eClass.getName() + "\n");
			for (Entry<String, String> entry : variablesJava.entrySet()) {
				String nombre = entry.getKey();
				String esLista = entry.getValue();

				String nombreAtributo = nombre;
				String nombreAtributoMayus = "";
				String firstLtr = nombreAtributo.substring(0, 1);
				String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

				// ponemos mayuscula la primera letra
				firstLtr = firstLtr.toUpperCase();

				// concatenamos
				nombreAtributoMayus = firstLtr + restLtrs;

				// primero clasificar por atributos y referencias
				// despues quiza por lista (en referncias quizas no sea necesario
				// despues por containment aunque en referencias no se si es necesario
				//if (nombre != "id") {

					myWriter.write("\t\t//" + nombre + "\n");
					//if (esLista == "ListaSi") {// si es lista

					//} 
						System.out.println(nombre + " si es lista");
						if (atributoNoEsReferencia(eClass, nombre)) { // es eattribute, dos casos, si es lista y si no lo es
							
							if (esLista == "ListaSi") {
								// HACIENDO ACTUAL:DONE
								// para School_nestudaintes:
								//searchById_School
								//myWriter.write("\t\tpw.println(\"<td><a href='"editurl"?id=\"+"
								// showTP = show TablaPrimitivo
								
								myWriter.write("\t\tpw.println(\"<td><a href='showTP"+eClass.getName()+"_"+nombre +"?id=\"+"
										+ eClass.getName().toLowerCase() + ".getId()+\"'>Ver TP</a> </td>\");\n");
							
							}
							else {
							// mostramos el atributo tal cual
							// ESTADO ACTUAL:DONE
							myWriter.write("\t\tpw.println(\"<td>\" + " + eClass.getName().toLowerCase() + ".get"
									+ nombreAtributoMayus + "() + \"</td>\");\n");
							}
						
						
						} else {// es ereference, en este caso se diferencia como lo tratamos en funcion de si es containment o no
							
							//ESTADO ACTUAL: TODO
							if (referenciaEsContainment(eClass, nombre)) { // es Ereference, no es lista, es containment ESTADO: TODO
								//System.out.println("NOMBRE REFERENCIAAAAAA")
								//devuelveAtributosTablaClaseApoyoASQL
								String claseAtributo = atributoDevuelveTipo(eClass,nombre);
								
	
								
								//Ejemplo: School -> students
								// Tengo que ir a la tabla students y preguntar select * from Student where id_School_students = id de la clase en la que estoy
								// esa funcion ya esta hecha, es searchBy searchById_School_students que devuelve un List<Student>
								myWriter.write("\t\tpw.println(\"<td><a href='show" + claseAtributo+  "FB" +"id_"+ eClass.getName()+"_" + nombre + "?id=\"+"
										+ eClass.getName().toLowerCase() + ".getId()+\"'>Ver Containment</a> </td>\");\n");

							}
							//ESTADO ACTUAL: 3
							else { // es Ereference, no es lista,no es containment  ESTADO: TODO
								//llamar al show nombreTablaContenedora_nombreVariable que haga uso de funcion searchById_PersonConcretoGetReferences 
								myWriter.write("\t\tpw.println(\"<td><a href='showRNC" + eClass.getName()+"_"+nombre +"?id=\"+"
										+ eClass.getName().toLowerCase() + ".getId()+\"'>Ver Referencia no COnt</a> </td>\");\n");
							}

						}
					
				//}

			}
			System.out.println("FINNNN" + "\n");

			/*
			 * myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getAtributoTrabajadorAbstracto() + \"</td>\");\n"
			 * ); myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getAddress() + \"</td>\");\n");
			 * myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getId_School_students() + \"</td>\");\n"
			 * ); myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getAtributoTrabajadorConcreto() + \"</td>\");\n"
			 * );
			 */

			myWriter.write("\t\tpw.println(\"</tr>\");\n");
			myWriter.write("\t}\n");

			myWriter.write("\tpw.println(\"</table>\");\n");
			myWriter.write("\t}catch(SQLException se){\n");

			/////////////
			myWriter.write("\t		pw.println(\"<h2>\" +se.getMessage() + \"</h2>\"  );\n");
			myWriter.write("\t		se.printStackTrace();\n");
			myWriter.write("\t	}\n");
			myWriter.write("\tcatch(Exception e){\n");
			myWriter.write("\t	System.out.println(\"GGGGGGGGGGGGGGG\");\n");

			myWriter.write("\t	e.printStackTrace();\n");
			myWriter.write("\t}\n");

			myWriter.write("\tpw.println(\"</div>\");\n");

			myWriter.write("\t//close the stream\n");
			myWriter.write("\tpw.close();\n");
			myWriter.write("\t}\n");

			myWriter.write("\t@Override\n");
			myWriter.write(
					"\tprotected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {\n");
			myWriter.write("\tdoGet(req,res);\n");

			myWriter.write("\t}\n");

			myWriter.write("\t}\n");

			////////////////

			myWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error al imprimir el codigo\n");

		}

		
		
	}

	private void crearShowTablaEreferenceNoContainment(EClass eClass,  List<EClassifier> elements,
		String nombreTabla,String claseDeLaReferencia, String pathSalida) {

		// CREAMOS EL DIRECTORIO
		//ficheroSalida
		//File carpeta = new File("src/codigoServlet");
		File carpeta = new File(pathSalida+File.separator+"codigoServlet");

		if (!carpeta.exists()) {
			boolean resultado = carpeta.mkdirs();
			if (resultado) {
				System.out.println("Carpeta creada exitosamente.");
			} else {
				System.out.println("No se pudo crear la carpeta.");
			}
		}
		
		String nombreClase = "ShowRNC" + nombreTabla;
		//ficheroSalida
		
		String nombreFichero = pathSalida+ File.separator +"codigoServlet" + File.separator;
		nombreFichero += nombreClase;
		nombreFichero += ".java"; // SE CREA FICHERO JSP

		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("package codigoServlet;\n");

			myWriter.write("import java.io.IOException;\n");
			myWriter.write("import java.io.PrintWriter;\n");
			myWriter.write("import java.sql.Connection;\n");
			myWriter.write("import java.sql.DriverManager;\n");
			myWriter.write("import java.sql.PreparedStatement;\n");
			myWriter.write("import java.sql.ResultSet;\n");
			myWriter.write("import java.sql.SQLException;\n");
			myWriter.write("import java.util.ArrayList;\n");
			myWriter.write("import java.util.LinkedHashMap;\n");
			myWriter.write("import java.util.List;\n");
			myWriter.write("import java.util.Map;\n");
			myWriter.write("\n");
			myWriter.write("import javax.servlet.ServletException;\n");
			myWriter.write("import javax.servlet.annotation.WebServlet;\n");
			myWriter.write("import javax.servlet.http.HttpServlet;\n");
			myWriter.write("import javax.servlet.http.HttpServletRequest;\n");
			myWriter.write("import javax.servlet.http.HttpServletResponse;\n");
			myWriter.write("\n");
			myWriter.write("import javaCode." + eClass.getName() + ";\n");
			myWriter.write("import javaCode." + claseDeLaReferencia + ";\n");
			myWriter.write("import javaCode." + nombreTabla + ";\n");

			myWriter.write("import sql." + claseDeLaReferencia + "SQL;\n");
			myWriter.write("import sql." + nombreTabla + "SQL;\n");
			myWriter.write("\n");
			myWriter.write("@WebServlet(\"/showRNC" + nombreTabla + "\")\n");
			myWriter.write("public class ShowRNC" + nombreTabla + " extends HttpServlet {\n");
			myWriter.write("\n");
			// myWriter.write("\tprivate final static String query = \"select * from
			// user\";\n");
			myWriter.write("\n");
			myWriter.write("\t@Override\n");
			myWriter.write(
					"\tprotected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {\n");
			myWriter.write("\n");
			myWriter.write(
					"\t\tList<" + claseDeLaReferencia + "> variableClase = new ArrayList<" + claseDeLaReferencia + ">(); \n");
			myWriter.write("\t\tLinkedHashMap<String, String> atributosClase = new LinkedHashMap<String, String>();\n");
			myWriter.write("\t\t" +nombreTabla + "SQL variableClaseSQL= new " +nombreTabla + "SQL();\n");
			myWriter.write("\t\t" + claseDeLaReferencia + " sj = new " + claseDeLaReferencia + "();\n");
			myWriter.write("\t\t//get PrintWriter\n");
			myWriter.write("\t\tPrintWriter pw = res.getWriter();\n");
			myWriter.write("\t\t//set content type\n");
			myWriter.write("\t\tres.setContentType(\"text/html\");\n");
			myWriter.write("\t\t// link the bootstrap\n");
			myWriter.write("\t\tpw.println(\"<link rel='stylesheet' href =  'css/bootstrap.css'> </link>\");\n");
			myWriter.write("\n");
			myWriter.write("\t\tatributosClase= sj.obtenerAtributosJava();\n");
			myWriter.write("\t\tint id = Integer.parseInt(req.getParameter(\"id\"));\n");

			myWriter.write("\t\t//load the jdbc driver\n");
			//
			myWriter.write("\t\ttry {\n");
			myWriter.write("\t\t\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
			myWriter.write("\t\t}catch(Exception e) {\n");
			myWriter.write("\t\t\te.printStackTrace();\n");
			myWriter.write("\t\t}\n");
			myWriter.write("\t\tConnection connection = null;\n");
			myWriter.write("\t\tSystem.out.println(\"HOLAAAAAAAAAAAAAAAA\");\n");

			myWriter.write("try {\n");
			myWriter.write("\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
			myWriter.write("\tString dbURL = \"jdbc:mysql://localhost:3306/jdbcdb\";\n");
			myWriter.write("\tString username = \"root\";\n");
			myWriter.write("\tString password = \"root\";\n");
			myWriter.write("\tconnection = DriverManager.getConnection(dbURL,username, password);\n");

			// myWriter.write("\tPreparedStatement ps =
			// connection.prepareStatement(query);\n");
			// myWriter.write("\tResultSet rs = ps.executeQuery();\n");
			myWriter.write("\tpw.println(\"<div style = 'margin:auto;width:800px;margin-top:100px'>\");\n");
			myWriter.write("\tpw.println(\"<div style = 'margin:auto;width:800px;margin-top:100px'>\");\n");
			myWriter.write(
					"\tpw.println(\"<a href = 'index.jsp'><button class = 'btn btn-outline-success'>Home</button></a>\");\n");
			myWriter.write(
					"\tpw.println(\"<a href = 'index.jsp'><button class = 'btn btn-outline-primary'>Filtrar</button></a>\");\n");
			myWriter.write("\tpw.println(\"<a href = 'create" +  eClass.getName()+".jsp'><button class = 'btn btn-outline-primary'>Introducir "
					+ eClass.getName() + "</button></a>\");\n");
			myWriter.write("\tpw.println(\"</div>\");\n");
			myWriter.write("\tpw.println(\"<table class = 'table table-hover table-striped'>\");\n");

			// cabecera edit y delete
			myWriter.write("\tpw.println(\"<tr>\");\n");
			myWriter.write("\tpw.println(\"<th>Edit</th>\");\n");
			myWriter.write("\tpw.println(\"<th>Delete</th>\");\n");
			// cabeceras de los atributos java
			myWriter.write("\tfor (Map.Entry<String, String> entry : atributosClase.entrySet()) {\n");
			myWriter.write("\t\tString clave = entry.getKey();\n");
			myWriter.write("\t\tString valor = entry.getValue();\n");
			//myWriter.write("\t\tif (clave!=\"id\"){;\n");

			myWriter.write("\t\tpw.println(\"<th>\" + clave + \"</th>\");\n");
			//myWriter.write("\t\t};\n");

			myWriter.write("\t}");

			myWriter.write("\tpw.println(\"</tr>\");\n");
			myWriter.write("\t List <" + claseDeLaReferencia + ">" + eClass.getName().toLowerCase() + "s"
					+ "= variableClaseSQL.searchById_"+eClass.getName()+"GetReferences(connection,Integer.toString(id));\n");

			myWriter.write("\tfor(" + claseDeLaReferencia + " " + eClass.getName().toLowerCase() + " : "
					+ eClass.getName().toLowerCase() + "s) {\n");
			// edit y delete de la fila
			myWriter.write("\t\tpw.println(\"<tr>\");\n");
			myWriter.write("\t\tpw.println(\"<td><a href='editurl?id=\"+" + eClass.getName().toLowerCase()
					+ ".getId()+\"'>Edit</a> </td>\");\n");

			myWriter.write("\t\tpw.println(\"<td><a href='deleteurl?id=\"+" + eClass.getName().toLowerCase()
					+ ".getId()+\"'>Delete</a> </td>\");\n");
			/* Voy por aqui pero bueno */
			//recorremos todos los elementos hasta llegar a la clase 
			
			EClass eClassReferencia = null;
			
			for (EClassifier classifier : elements) {

				if (classifier instanceof EClass) {

					EClass eClassReviewing = (EClass) classifier;

					if (eClassReviewing.getName() == claseDeLaReferencia) { // si la clase es tiene el
																						// mismo nombre que el tipo

						eClassReferencia = eClassReviewing;

					}

				}
			} // FIN BUSQUEDA CLASE CON NOMBRE			
			
			// Comenzamos a poner los atributos de la fila
			LinkedHashMap<String, String> variablesJava = devuelveAtributosJava(eClassReferencia);// DEBE DEVOLVER LOS DE LA REFERENCIA SSHHH
			System.out.println("PRINTEANDO ATRIBUTOS PARA EL SHOW de la clase : " + eClass.getName() + "\n");
			for (Entry<String, String> entry : variablesJava.entrySet()) {
				String nombre = entry.getKey();
				String esLista = entry.getValue();

				String nombreAtributo = nombre;
				String nombreAtributoMayus = "";
				String firstLtr = nombreAtributo.substring(0, 1);
				String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

				// ponemos mayuscula la primera letra
				firstLtr = firstLtr.toUpperCase();

				// concatenamos
				nombreAtributoMayus = firstLtr + restLtrs;

				// primero clasificar por atributos y referencias
				// despues quiza por lista (en referncias quizas no sea necesario
				// despues por containment aunque en referencias no se si es necesario
				//if (nombre != "id") {

					myWriter.write("\t\t//" + nombre + "\n");
					//if (esLista == "ListaSi") {// si es lista

					//} 
						System.out.println(nombre + " si es lista");
						if (atributoNoEsReferencia(eClass, nombre)) { // es eattribute, dos casos, si es lista y si no lo es
							
							if (esLista == "ListaSi") {
								// HACIENDO ACTUAL:DONE
								// para School_nestudaintes:
								//searchById_School
								//myWriter.write("\t\tpw.println(\"<td><a href='"editurl"?id=\"+"
								// showTP = show TablaPrimitivo
								
								myWriter.write("\t\tpw.println(\"<td><a href='showTP"+eClass.getName()+"_"+nombre +"?id=\"+"
										+ eClass.getName().toLowerCase() + ".getId()+\"'>Ver TP</a> </td>\");\n");
							
							}
							else {
							// mostramos el atributo tal cual
							// ESTADO ACTUAL:DONE
							myWriter.write("\t\tpw.println(\"<td>\" + " + eClass.getName().toLowerCase() + ".get"
									+ nombreAtributoMayus + "() + \"</td>\");\n");
							}
						
						
						} else {// es ereference, en este caso se diferencia como lo tratamos en funcion de si es containment o no
							
							//ESTADO ACTUAL: TODO
							if (referenciaEsContainment(eClass, nombre)) { // es Ereference, no es lista, es containment ESTADO: TODO
								//System.out.println("NOMBRE REFERENCIAAAAAA")
								//devuelveAtributosTablaClaseApoyoASQL
								String claseAtributo = atributoDevuelveTipo(eClass,nombre);
								
	
								
								//Ejemplo: School -> students
								// Tengo que ir a la tabla students y preguntar select * from Student where id_School_students = id de la clase en la que estoy
								// esa funcion ya esta hecha, es searchBy searchById_School_students que devuelve un List<Student>
								myWriter.write("\t\tpw.println(\"<td><a href='show" + claseAtributo+  "FB" +"id_"+ eClass.getName()+"_" + nombre + "?id=\"+"
										+ eClass.getName().toLowerCase() + ".getId()+\"'>Ver Containment</a> </td>\");\n");

							}
							//ESTADO ACTUAL: 3
							else { // es Ereference, no es lista,no es containment  ESTADO: TODO
								//llamar al show nombreTablaContenedora_nombreVariable que haga uso de funcion searchById_PersonConcretoGetReferences 
								myWriter.write("\t\tpw.println(\"<td><a href='showRNC" + eClass.getName()+"_"+nombre +"?id=\"+"
										+ eClass.getName().toLowerCase() + ".getId()+\"'>Ver Referencia NoCont</a> </td>\");\n");
							}

						}
					
				//}

			}
			System.out.println("FINNNN" + "\n");

			/*
			 * myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getAtributoTrabajadorAbstracto() + \"</td>\");\n"
			 * ); myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getAddress() + \"</td>\");\n");
			 * myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getId_School_students() + \"</td>\");\n"
			 * ); myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getAtributoTrabajadorConcreto() + \"</td>\");\n"
			 * );
			 */

			myWriter.write("\t\tpw.println(\"</tr>\");\n");
			myWriter.write("\t}\n");

			myWriter.write("\tpw.println(\"</table>\");\n");
			myWriter.write("\t}catch(SQLException se){\n");

			/////////////
			myWriter.write("\t		pw.println(\"<h2>\" +se.getMessage() + \"</h2>\"  );\n");
			myWriter.write("\t		se.printStackTrace();\n");
			myWriter.write("\t	}\n");
			myWriter.write("\tcatch(Exception e){\n");
			myWriter.write("\t	System.out.println(\"GGGGGGGGGGGGGGG\");\n");

			myWriter.write("\t	e.printStackTrace();\n");
			myWriter.write("\t}\n");

			myWriter.write("\tpw.println(\"</div>\");\n");

			myWriter.write("\t//close the stream\n");
			myWriter.write("\tpw.close();\n");
			myWriter.write("\t}\n");

			myWriter.write("\t@Override\n");
			myWriter.write(
					"\tprotected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {\n");
			myWriter.write("\tdoGet(req,res);\n");

			myWriter.write("\t}\n");

			myWriter.write("\t}\n");

			////////////////

			myWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error al imprimir el codigo\n");

		}

		
		
	}

	private void crearShowTablaFilteredByAtributo(EClass eClass, List<EClassifier> elements, String variableAFiltrar, String pathSalida) {

			// CREAMOS EL DIRECTORIO
			//ficheroSalida
			//File carpeta = new File("src/codigoServlet");
			File carpeta = new File(pathSalida+ File.separator+"codigoServlet");

			if (!carpeta.exists()) {
				boolean resultado = carpeta.mkdirs();
				if (resultado) {
					System.out.println("Carpeta creada exitosamente.");
				} else {
					System.out.println("No se pudo crear la carpeta.");
				}
			}
			
			
			String nombreClase = "Show" + eClass.getName();
			
			//ficheroSalida
			//String nombreFichero = "src/codigoServlet/";
			String nombreFichero = pathSalida +  File.separator +"codigoServlet" + File.separator;
			nombreFichero += nombreClase;
			nombreFichero += "FB"+variableAFiltrar+".java"; // SE CREA FICHERO JSP

			try {

				FileWriter myWriter = new FileWriter(nombreFichero, true);
				myWriter.write("package codigoServlet;\n");

				myWriter.write("import java.io.IOException;\n");
				myWriter.write("import java.io.PrintWriter;\n");
				myWriter.write("import java.sql.Connection;\n");
				myWriter.write("import java.sql.DriverManager;\n");
				myWriter.write("import java.sql.PreparedStatement;\n");
				myWriter.write("import java.sql.ResultSet;\n");
				myWriter.write("import java.sql.SQLException;\n");
				myWriter.write("import java.util.ArrayList;\n");
				myWriter.write("import java.util.LinkedHashMap;\n");
				myWriter.write("import java.util.List;\n");
				myWriter.write("import java.util.Map;\n");
				myWriter.write("\n");
				myWriter.write("import javax.servlet.ServletException;\n");
				myWriter.write("import javax.servlet.annotation.WebServlet;\n");
				myWriter.write("import javax.servlet.http.HttpServlet;\n");
				myWriter.write("import javax.servlet.http.HttpServletRequest;\n");
				myWriter.write("import javax.servlet.http.HttpServletResponse;\n");
				myWriter.write("\n");
				myWriter.write("import javaCode." + eClass.getName() + ";\n");

				myWriter.write("import sql." +  eClass.getName() + "SQL;\n");
				myWriter.write("\n");
				myWriter.write("@WebServlet(\"/show"  +  eClass.getName() +  "FB"+variableAFiltrar+ "\")\n");
				myWriter.write("public class Show" + eClass.getName() + "FB"+variableAFiltrar+ " extends HttpServlet {\n");
				myWriter.write("\n");
				// myWriter.write("\tprivate final static String query = \"select * from
				// user\";\n");
				myWriter.write("\n");
				myWriter.write("\t@Override\n");
				myWriter.write(
						"\tprotected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {\n");
				myWriter.write("\n");
				myWriter.write(
						"\t\tList<" + eClass.getName() + "> variableClase = new ArrayList<" + eClass.getName() + ">(); \n");
				myWriter.write("\t\tLinkedHashMap<String, String> atributosClase = new LinkedHashMap<String, String>();\n");
				myWriter.write("\t\t" +eClass.getName() + "SQL variableClaseSQL= new " +eClass.getName() + "SQL();\n");
				myWriter.write("\t\t" + eClass.getName() + " sj = new " + eClass.getName() + "();\n");
	
				myWriter.write("\t\t//get PrintWriter\n");
				myWriter.write("\t\tPrintWriter pw = res.getWriter();\n");
				myWriter.write("\t\t//set content type\n");
				myWriter.write("\t\tres.setContentType(\"text/html\");\n");
				myWriter.write("\t\t// link the bootstrap\n");
				myWriter.write("\t\tpw.println(\"<link rel='stylesheet' href =  'css/bootstrap.css'> </link>\");\n");
				myWriter.write("\n");
				myWriter.write("\t\tatributosClase= sj.obtenerAtributosJava();\n");
				myWriter.write("\t\tString id = req.getParameter(\"id\");\n");
				//myWriter.write("\t\tString variableAFiltrar = req.getParameter(\"variableAFiltrar\");\n");

				String nombreAtributo = variableAFiltrar;
				String nombreAtributoMayusAFiltrar = "";
				String firstLtr = nombreAtributo.substring(0, 1);
				firstLtr = firstLtr.toUpperCase();
				String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

				nombreAtributoMayusAFiltrar = firstLtr + restLtrs;
				myWriter.write("\t\t//load the jdbc driver\n");
				//
				myWriter.write("\t\ttry {\n");
				myWriter.write("\t\t\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
				myWriter.write("\t\t}catch(Exception e) {\n");
				myWriter.write("\t\t\te.printStackTrace();\n");
				myWriter.write("\t\t}\n");
				myWriter.write("\t\tConnection connection = null;\n");
				myWriter.write("\t\tSystem.out.println(\"HOLAAAAAAAAAAAAAAAA\");\n");

				myWriter.write("try {\n");
				myWriter.write("\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
				myWriter.write("\tString dbURL = \"jdbc:mysql://localhost:3306/jdbcdb\";\n");
				myWriter.write("\tString username = \"root\";\n");
				myWriter.write("\tString password = \"root\";\n");
				myWriter.write("\tconnection = DriverManager.getConnection(dbURL,username, password);\n");

				// myWriter.write("\tPreparedStatement ps =
				// connection.prepareStatement(query);\n");
				// myWriter.write("\tResultSet rs = ps.executeQuery();\n");
				myWriter.write("\tpw.println(\"<div style = 'margin:auto;width:800px;margin-top:100px'>\");\n");
				myWriter.write("\tpw.println(\"<div style = 'margin:auto;width:800px;margin-top:100px'>\");\n");
				myWriter.write(
						"\tpw.println(\"<a href = 'index.jsp'><button class = 'btn btn-outline-success'>Home</button></a>\");\n");
				myWriter.write(
						"\tpw.println(\"<a href = 'index.jsp'><button class = 'btn btn-outline-primary'>Filtrar</button></a>\");\n");
				myWriter.write("\tpw.println(\"<a href = 'create" +  eClass.getName()+".jsp'><button class = 'btn btn-outline-primary'>Introducir "
						+ eClass.getName() + "</button></a>\");\n");
				myWriter.write("\tpw.println(\"</div>\");\n");
				myWriter.write("\tpw.println(\"<table class = 'table table-hover table-striped'>\");\n");

				// cabecera edit y delete
				myWriter.write("\tpw.println(\"<tr>\");\n");
				myWriter.write("\tpw.println(\"<th>Edit</th>\");\n");
				myWriter.write("\tpw.println(\"<th>Delete</th>\");\n");
				// cabeceras de los atributos java
				myWriter.write("\tfor (Map.Entry<String, String> entry : atributosClase.entrySet()) {\n");
				myWriter.write("\t\tString clave = entry.getKey();\n");
				myWriter.write("\t\tString valor = entry.getValue();\n");
				myWriter.write("\t\tif (clave!=\"id\"){;\n");

				myWriter.write("\t\tpw.println(\"<th>\" + clave + \"</th>\");\n");
				myWriter.write("\t\t};\n");

				myWriter.write("\t}");
				myWriter.write("\tpw.println(\"</tr>\");\n");
				myWriter.write("\t List <" + eClass.getName() + ">" + eClass.getName().toLowerCase() + "s"
						+ "= variableClaseSQL.searchBy" + nombreAtributoMayusAFiltrar +  "(connection,id);\n");

				myWriter.write("\tfor(" + eClass.getName() + " " + eClass.getName().toLowerCase() + " : "
						+ eClass.getName().toLowerCase() + "s) {\n");
				// edit y delete de la fila
				myWriter.write("\t\tpw.println(\"<tr>\");\n");
				myWriter.write("\t\tpw.println(\"<td><a href='editurl?id=\"+" + eClass.getName().toLowerCase()
						+ ".getId()+\"'>Edit</a> </td>\");\n");

				myWriter.write("\t\tpw.println(\"<td><a href='deleteurl?id=\"+" + eClass.getName().toLowerCase()
						+ ".getId()+\"'>Delete</a> </td>\");\n");
				/* Voy por aqui pero bueno */
				//recorremos todos los elementos hasta llegar a la clase 
					
				
				// Comenzamos a poner los atributos de la fila
				LinkedHashMap<String, String> variablesJava = devuelveAtributosJava(eClass);// DEBE DEVOLVER LOS DE LA REFERENCIA SSHHH
				
				System.out.println("PRINTEANDO ATRIBUTOS PARA EL SHOW de la clase : " + eClass.getName() + "\n");
				for (Entry<String, String> entry : variablesJava.entrySet()) {
					String nombre = entry.getKey();
					String esLista = entry.getValue();

					 nombreAtributo = nombre;
					 String nombreAtributoMayus = "";
					 firstLtr = nombreAtributo.substring(0, 1);
					 restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

					// ponemos mayuscula la primera letra
					firstLtr = firstLtr.toUpperCase();

					// concatenamos
					nombreAtributoMayus = firstLtr + restLtrs;

					// primero clasificar por atributos y referencias
					// despues quiza por lista (en referncias quizas no sea necesario
					// despues por containment aunque en referencias no se si es necesario
					if (nombre != "id") {

						myWriter.write("\t\t//" + nombre + "\n");
						//if (esLista == "ListaSi") {// si es lista

						//} 
							System.out.println(nombre + " si es lista");
							if (atributoNoEsReferencia(eClass, nombre)) { // es eattribute, dos casos, si es lista y si no lo es
								
								if (esLista == "ListaSi") {
									// HACIENDO ACTUAL:DONE
									// para School_nestudaintes:
									//searchById_School
									//myWriter.write("\t\tpw.println(\"<td><a href='"editurl"?id=\"+"
									// showTP = show TablaPrimitivo
									
									myWriter.write("\t\tpw.println(\"<td><a href='showTP"+eClass.getName()+"_"+nombre +"?id=\"+"
											+ eClass.getName().toLowerCase() + ".getId()+\"'>Ver TP</a> </td>\");\n");
								
								}
								else {
								// mostramos el atributo tal cual
								// ESTADO ACTUAL:DONE
								myWriter.write("\t\tpw.println(\"<td>\" + " + eClass.getName().toLowerCase() + ".get"
										+ nombreAtributoMayus + "() + \"</td>\");\n");
								}
							
							
							} else {// es ereference, en este caso se diferencia como lo tratamos en funcion de si es containment o no
								
								//ESTADO ACTUAL: TODO
								if (referenciaEsContainment(eClass, nombre)) { // es Ereference, no es lista, es containment ESTADO: TODO
									//System.out.println("NOMBRE REFERENCIAAAAAA")
									//devuelveAtributosTablaClaseApoyoASQL
									String claseAtributo = atributoDevuelveTipo(eClass,nombre);

									//Ejemplo: School -> students
									// Tengo que ir a la tabla students y preguntar select * from Student where id_School_students = id de la clase en la que estoy
									// esa funcion ya esta hecha, es searchBy searchById_School_students que devuelve un List<Student>
									myWriter.write("\t\tpw.println(\"<td><a href='show" + claseAtributo+  "FB" +"id_"+ eClass.getName()+"_" + nombre + "?id=\"+"
											+ eClass.getName().toLowerCase() + ".getId()+\"'>Ver Containment</a> </td>\");\n");

								}
								//ESTADO ACTUAL: 3
								else { // es Ereference, no es lista,no es containment  ESTADO: TODO
									//llamar al show nombreTablaContenedora_nombreVariable que haga uso de funcion searchById_PersonConcretoGetReferences 
									myWriter.write("\t\tpw.println(\"<td><a href='showRNC" + eClass.getName()+"_"+nombre +"?id=\"+"
											+ eClass.getName().toLowerCase() + ".getId()+\"'>Ver Referencia NoCont</a> </td>\");\n");
								}

							}
						
					}

				}
				System.out.println("FINNNN" + "\n");


				myWriter.write("\t\tpw.println(\"</tr>\");\n");
				myWriter.write("\t}\n");

				myWriter.write("\tpw.println(\"</table>\");\n");
				myWriter.write("\t}catch(SQLException se){\n");

				/////////////
				myWriter.write("\t		pw.println(\"<h2>\" +se.getMessage() + \"</h2>\"  );\n");
				myWriter.write("\t		se.printStackTrace();\n");
				myWriter.write("\t	}\n");
				myWriter.write("\tcatch(Exception e){\n");
				myWriter.write("\t	System.out.println(\"GGGGGGGGGGGGGGG\");\n");

				myWriter.write("\t	e.printStackTrace();\n");
				myWriter.write("\t}\n");

				myWriter.write("\tpw.println(\"</div>\");\n");

				myWriter.write("\t//close the stream\n");
				myWriter.write("\tpw.close();\n");
				myWriter.write("\t}\n");

				myWriter.write("\t@Override\n");
				myWriter.write(
						"\tprotected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {\n");
				myWriter.write("\tdoGet(req,res);\n");

				myWriter.write("\t}\n");

				myWriter.write("\t}\n");

				////////////////

				myWriter.close();

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error al imprimir el codigo\n");

			}

			
			
		}

	
	private void crearInicio(LinkedHashMap<String, String> tablasCreadas, List<EClassifier> elements, String nombreModelo, String pathSalida) {

		String nombreClase = "index";
		//ficheroSalida
		String nombreFichero = pathSalida+File.separator+"jsp"+File.separator;
		nombreFichero += nombreClase;
		nombreFichero += ".jsp"; // SE CREA FICHERO JSP
		System.out.println("Entrando a crear inicio exitosamente.");

		// eliminamos las tablas que son nm

		for (EClassifier classifier : elements) {
			for (EClassifier innerClassifier : elements) {
				// if (classifier != innerClassifier) {
				String className = classifier.getName();
				String innerClassName = innerClassifier.getName();
				String tableToRemove = className + "_" + innerClassName;
				tablasCreadas.remove(tableToRemove);
				// }
			}
		}
		// CREAMOS EL DIRECTORIO
		//ficheroSalida
		//File carpeta = new File("src/jsp");
		
		File carpeta = new File(pathSalida+File.separator+"jsp");

		if (!carpeta.exists()) {
			boolean resultado = carpeta.mkdirs();
			if (resultado) {
				System.out.println("Carpeta creada exitosamente.");
			} else {
				System.out.println("No se pudo crear la carpeta.");
			}
		}

		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write(
					"<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>\n");
			myWriter.write("<%@ page import=\"java.util.*\"%>\n");
			myWriter.write("\n");
			myWriter.write("<!DOCTYPE html>\n");
			myWriter.write("<html>\n");
			myWriter.write("<head>\n");
			myWriter.write("\t<meta charset=\"UTF-8\">\n");
			myWriter.write("\t<title>Botones desde lista de Strings en JSP</title>\n");
			myWriter.write("\t<!-- Importar Bootstrap -->\n");
			myWriter.write(
					"\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
			myWriter.write("\t<style>\n");
			myWriter.write("\t\t.container {\n");
			myWriter.write("\t\t\tmargin-top: 50px;\n");
			myWriter.write("\t\t}\n");

			myWriter.write("\t\t.btn-separado {\n");
			myWriter.write("\t\t\tmargin-bottom: 10px;\n");
			myWriter.write("\t\t}\n");

			myWriter.write("\t</style>\n");
			myWriter.write("</head>\n");
			myWriter.write("<body>\n");
			myWriter.write("\t<div class=\"container\">\n");
			myWriter.write("\t\t<h1 class=\"text-center\">¡Bienvenido al Sistema de Información!</h1>\n");
			myWriter.write(
					"\t\t<h4 class=\"text-center\">Por favor, escoge una tabla del modelo " + nombreModelo + "</h4>\n");

			myWriter.write("\n");
			myWriter.write("\t<div class=\"list-group\" >\n");
			// Comenzamos a crear los botones de las tablas:

			// BOTON A ELIMINAR
			myWriter.write("\t\t<form method=\"POST\" action=\"" + "index2" + ".jsp\" class=\"text-center\">\n");
			myWriter.write("\t\t\t<button type=\"submit\" name=\"" + "index2"
					+ "\" class=\"btn btn-primary btn-separado\" style=\"width: 35%\">" + "index2.jsp" + "</button>\n");
			myWriter.write("\t\t</form>\n");

			// BOTON A ELIMINAR

			System.out.println("Entrando a crear inicio exitosamente parte 2.");

			for (String tabla : tablasCreadas.keySet()) {
				String esPrincipal = tablasCreadas.get(tabla);// obtenemos si es principal o ni la tabla correspondiente

				System.out.println("Entrando en el loop para la tabla" + tabla);
				// VER SI ESTO FUNCIONA
				if (esPrincipal == "siEsPrincipal") {
					myWriter.write("\t\t<div class='text-center mt-3'>\n");
					myWriter.write("\t\t <a href='show" + tabla
							+ "' class='btn btn-primary btn-separado text-decoration-none' style=\"width: 35%\">" + tabla + "</a>\n");
					myWriter.write("\t\t</div>\n");
				}
			}

			myWriter.write("\t</div>\n");
			myWriter.write("</div>\n");
			myWriter.write("</body>\n");
			myWriter.write("</html>\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

	}

	private void crearFormularioCreacion(LinkedHashMap<String, String> tablasCreadas, EClass eClass, List<EClassifier> elements, String nombreModelo, String pathSalida) {

		String nombreClase = "create"+eClass.getName();
		
		//ficheroSalida
		//String nombreFichero = "src/jsp/";
		String nombreFichero =pathSalida+ File.separator +"jsp"+ File.separator;
		
		nombreFichero += nombreClase;
		
		
		
		nombreFichero += ".jsp"; // SE CREA FICHERO JSP
		System.out.println("Entrando a crear inicio exitosamente.");
		Integer i = 0;
		// eliminamos las tablas que son nm

		Integer variablesCreadas=0;
		Integer idclasesReferenciadas=0;
		
		//El primer valor aumenta cuando una variable es creada
		//El segundo valor aumenta cuando una variable es creada
		Integer[] idVariableYClase = {0, 0};
		Integer quienSoy = idVariableYClase[0];
		
		for (EClassifier classifier : elements) {
			for (EClassifier innerClassifier : elements) {
				// if (classifier != innerClassifier) {
				String className = classifier.getName();
				String innerClassName = innerClassifier.getName();
				String tableToRemove = className + "_" + innerClassName;
				tablasCreadas.remove(tableToRemove);
				// }
			}
		}
		// CREAMOS EL DIRECTORIO
		//ficheroSalida

		//File carpeta = new File("src/jsp");
		File carpeta = new File(pathSalida+File.separator+"jsp");

		if (!carpeta.exists()) {
			boolean resultado = carpeta.mkdirs();
			if (resultado) {
				System.out.println("Carpeta creada exitosamente.");
			} else {
				System.out.println("No se pudo crear la carpeta.");
			}
		}

		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("<!DOCTYPE html>\n");
			myWriter.write("<html>\n");
			myWriter.write("<head>\n");
			myWriter.write("\n");
			myWriter.write("<meta charset=\"ISO-08859-1\">\n");
			myWriter.write("<link rel=\"stylesheet\" href=\"css/bootstrap.css\"></link>\n");
			myWriter.write("<style type=\"text/css\">\n");
			myWriter.write("#frm {\n");
			myWriter.write("\twidth: 500px;\n");
			myWriter.write("\tmargin: auto;\n");
			myWriter.write("\tmargin-top: 100px;\n");
			myWriter.write("}\n");
			myWriter.write("</style>\n");
			myWriter.write("\n");
			//myWriter.write("<title>Insert title here</title>\n");
			myWriter.write("</head>\n");
			myWriter.write("\n");
			myWriter.write("<body class=\"container-fluid\">\n");
			myWriter.write("\n");
			//Registrar a la clase
			myWriter.write("\t<marquee class=\"text-primary\">Registrar " +eClass.getName()+ "</marquee>\n");
			myWriter.write("\t<form action=\"insert" + eClass.getName() +"\" method=\"post\" class=\"form card\" id=\"frm\">\n");
			myWriter.write("\t\t<h2 class=\"bg-primary text-black card-header\">Registrar "+ eClass.getName() +"</h2>\n");
			myWriter.write("\t\t<table class=\"table table-hover\">\n");
			//Creamos la tabla
			//Primero recorremos los eattributes
			
		///////PARTEA - correcto
			// Recorremos los eattributes y vemos si son lista o no 
			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				 String nombreEattribute = eAttribute.getName();
				 String tipoEattribute = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//
				 
				if (eAttribute.getUpperBound() == 1) {

					System.out.println("REVISANDO clase - " + eClass.getName()+ " atributo --> " + nombreEattribute+ " tipo -->  " + tipoEattribute);
					
					if (eAttribute.getLowerBound() == 1) {
					
						idVariableYClase = crearAtributoPrimitivoFormulario(eClass.getName(),nombreEattribute,tipoEattribute,myWriter,true,idVariableYClase,quienSoy);
					}
					else if (eAttribute.getLowerBound() == 0){ //???
						
						idVariableYClase = crearAtributoPrimitivoFormulario(eClass.getName(), nombreEattribute,tipoEattribute,myWriter,false,idVariableYClase,quienSoy);
					}
				}
			}
			
			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				 String nombreEattribute = eAttribute.getName();
				 String tipoEattribute = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//
					
				 if(eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) { // es una lista
					System.out.println("REVISANDO clase - " + eClass.getName()+ " atributo --> " + nombreEattribute+ " tipo -->  " + tipoEattribute);
					i=0;
					for (i=0; i<eAttribute.getLowerBound();i++) {
						idVariableYClase = crearAtributoPrimitivoFormulario(eClass.getName(),nombreEattribute, tipoEattribute, myWriter,true,idVariableYClase,quienSoy);	
					}		
				}
			}
		 

		///////PARTEB - correcto
			// primer bucle para ereferences no containments
			for (EReference eReference : eClass.getEAllReferences()) {
				//String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
				String nombreEreference = eReference.getName();
				if (!eReference.isContainment()) {// nos fijamos en el upperbound para saber si es atributo o lista
					// si no es containment, que se añada id y punto hasta el lowerbound
					for (i=0; i<eReference.getLowerBound();i++) {
						
						idVariableYClase = crearAtributoPrimitivoFormulario(eClass.getName(),nombreEreference, "Integer", myWriter,true,idVariableYClase,quienSoy);
					}
				}

			}
			
			///////PARTEC Correcto
			for (EReference eReference : eClass.getEAllReferences()) {
				String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
				String nombreEreference = eReference.getName();
				if (eReference.isContainment()) {// nos fijamos en el upperbound para saber si es atributo o lista
					// si es containment debemos crearlo in situ
					for (i=0; i<eReference.getLowerBound();i++) {
						idVariableYClase = crearEReferenceFormulario(eClass,nombreEreference, tipoE, myWriter, eReference,elements,idVariableYClase,quienSoy);
					}
					System.out.println("REVISANDO clase - " + eClass.getName()+ " Referencia --> " + nombreEreference+ " tipo -->  " + tipoE);
					System.out.println("Containment: " +eReference.isContainment() +"\n");
				}

			}

			myWriter.write("\n");
			myWriter.write("\t\t\t<tr class=\"card-footer text-center\">\n");
			myWriter.write("\t\t\t\t<td>\n");
			myWriter.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-outline-success\">Register</button>\n");
			myWriter.write("\t\t\t\t</td>\n");
			myWriter.write("\t\t\t\t\t<td>\n");
			myWriter.write("\t\t\t\t\t\t<button type=\"reset\" class=\"btn btn-outline-danger\">Reset</button>\n");
			myWriter.write("\t\t\t\t\t</td>\n");

			myWriter.write("\t\t\t</tr>\n");


			myWriter.write("\t\t\t\t\t</table>\n");


			myWriter.write("\t\t</form>\n");
			myWriter.write("\t\t\t<div class=\"text-center mt-3\">\n");
			myWriter.write("\t\t\t\t<a href=\"index.jsp\" class=\"btn btn-outline-primary text-decoration-none\">Home</a>\n");
			myWriter.write("\t\t\t\t\t<a href=\"show"+eClass.getName()+"\" class=\"btn btn-outline-primary text-decoration-none\">Mostrar Tabla " + eClass.getName() +"</a>\n");
			myWriter.write("\t\t\t</div>\n");
			myWriter.write("\t</body>\n");
			myWriter.write("</html>\n");
			
			
			//FIN
			myWriter.close();

		} catch (IOException e) {
			System.out.println("Error el atributo con upperbound 1");
			e.printStackTrace();
		}

	}
	
	private Integer [] crearAtributoPrimitivoFormulario(String deQuienViene, String nombreEattribute,  String tipoEattribute, 
			FileWriter myWriter,Boolean esObligatorio,Integer []idVariableYClase, Integer deQuienSoy) {

		
		System.out.println("Entrado a crearAtributoPrimitivoFormulario para el atributo " + nombreEattribute);
		try {
		if (tipoEattribute == "java.sql.Date") {
			
			myWriter.write("\t\t\t<tr>\n");
			myWriter.write("\t\t\t\t<td>"+nombreEattribute + "_"+idVariableYClase[0]+"</td>\n");
			myWriter.write("\t\t\t\t<td><input type=\"date\" name=\""+nombreEattribute +"_"+ idVariableYClase[0]+"\"");
				if (esObligatorio) {
					
					myWriter.write("required></td>\n");
				}
				else {
					myWriter.write("></td>\n");

				}
			myWriter.write("\t\t\t</tr>\n");
		}
		
		else if (tipoEattribute == "Boolean") {
			
			if (esObligatorio) {
				myWriter.write("\t\t\t<tr>\n");
				myWriter.write("\t\t\t\t<td>"+nombreEattribute+"_"+idVariableYClase[0]+"</td>\n");
				myWriter.write("\t\t\t\t<td><select name=\""+nombreEattribute+"_"+idVariableYClase[0]+"\">\n");
				myWriter.write("\t\t\t\t\t<option value=\"true\">true</option>\n");
				myWriter.write("\t\t\t\t\t<option value=\"false\">false</option>\n");
				myWriter.write("\t\t\t</select></td>\n");
				myWriter.write("\t\t\t</tr>\n");
				
			}
			
			else {
				myWriter.write("\t\t\t<tr>\n");
				myWriter.write("\t\t\t\t<td>" +nombreEattribute+"_"+idVariableYClase[0]+"</td>\n");
				myWriter.write("\t\t\t\t<td><select name=\""+nombreEattribute+"_"+idVariableYClase[0]+"\">\n");
				myWriter.write("\t\t\t\t\t<option value=\"null\">null</option>\n");
				myWriter.write("\t\t\t\t\t<option value=\"true\">true</option>\n");
				myWriter.write("\t\t\t\t\t<option value=\"false\">false</option>\n");
				myWriter.write("\t\t\t</select></td>\n");
				myWriter.write("\t\t\t</tr>\n");
			}
		}
		//valores numericos no decimales
		else if (tipoEattribute == "Short" || tipoEattribute == "Integer"|| tipoEattribute == "Long"|| tipoEattribute == "Boolean"|| tipoEattribute == "Boolean") {
			
			myWriter.write("\t\t\t<tr>\n");
			myWriter.write("\t\t\t\t<td>"+nombreEattribute +"_"+idVariableYClase[0]+"</td>\n");
			myWriter.write("\t\t\t\t<td><input type=\"number\" name=\""+nombreEattribute +"_"+idVariableYClase[0]+"\" ");
				if (esObligatorio) {
					myWriter.write("required></td>\n");
				}
				else {
					myWriter.write("\t\t\t</tr>\n");

				}
			myWriter.write("\t\t\t</tr>\n");
		}
		//valores numericos  decimales
		else if (tipoEattribute == "Double" || tipoEattribute == "Float") {
			
			myWriter.write("\t\t\t<tr>\n");
			myWriter.write("\t\t\t\t<td>"+nombreEattribute +"_"+idVariableYClase[0]+"</td>\n");
			myWriter.write("\t\t\t\t<td><input type=\"number\" name=\""+nombreEattribute +"_"+idVariableYClase[0]+"\"");
				if (esObligatorio) {
					myWriter.write("step=\"0.01\"required></td>\n");
				}
				else {
					myWriter.write("step=\"0.01\"></td>\n");

				}
			myWriter.write("\t\t\t</tr>\n");
		}
		
		else {
			
			myWriter.write("\t\t\t<tr>\n");
			myWriter.write("\t\t\t\t<td>"+nombreEattribute +"_"+idVariableYClase[0]+"</td>\n");
			myWriter.write("\t\t\t\t<td><input type=\"text\" name=\""+nombreEattribute +"_"+idVariableYClase[0]+"\"");
				if (esObligatorio) {
					myWriter.write("required></td>\n");
				}
				else {
					myWriter.write("></td>\n");

				}
			myWriter.write("\t\t\t</tr>\n");
			
		}
		
		//myWriter.close();

	} catch (IOException e) {
		System.out.println("Error el atributo con upperbound 1");
		e.printStackTrace();
	}
		
		//sumamos 1 al numero de variables añadidas
		idVariableYClase[0] = idVariableYClase[0] + 1;

		
		return idVariableYClase;
		
		
	}
	
	
	//REFERENCIAS CREACION
	private Integer [] crearEReferenceFormulario(EClass eClass, String nombreEreferenceP,  String claseEreference, FileWriter myWriter, EReference eReferenceP, List<EClassifier> elements,Integer [] idVariableYClase,Integer DeQuienSoyReferencia) {

		System.out.println("En clase: " + eClass.getName() + "Creando formulario del tipo " + claseEreference + " para el atributo: "+nombreEreferenceP);
		
		Integer i = 0;
		
		// Obtenemos la clase de la que viene la referencia
		EClass eClassReference = eClass;
		for (EClassifier classifier : elements) {
			// Taking the EClass elements
			if (classifier instanceof EClass) {

				EClass eClassReviewing = (EClass) classifier;

				System.out.println("Chequeando si la clase " + eClassReviewing.getName() + " es   "
						+ eClass.getName());

				if (eClassReviewing.getName() == claseEreference) { // si no es la misma
					// clase
					eClassReference = eClassReviewing;
				}

			}
		}
		
		
		//anyadimos 1 al numero de clase
		idVariableYClase[1] = idVariableYClase[1] + 1;
		
		Integer quienSoy = idVariableYClase[1];
		
		//Anyadimos nombre de la referncia en el formulario
		
		try {
			myWriter.write("\t\t\t<tr class=\"bg-info\">\n");
			myWriter.write("\t\t\t\t<td>"+nombreEreferenceP+" - soy la clase: "+ quienSoy +" Referencia de: "+ DeQuienSoyReferencia + "</td>\n");
			myWriter.write("\t\t\t\t<td></td>\n");
			myWriter.write("\t\t\t</tr>\n");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		///////PARTEA
		// Recorremos los eattributes y vemos si son lista o no 
		for (EAttribute eAttribute : eClassReference.getEAllAttributes()) {
			 String nombreEattribute = eAttribute.getName();
			 String tipoEattribute = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//
			 
			if (eAttribute.getUpperBound() == 1) {

				System.out.println("REVISANDO clase - " + eClassReference.getName()+ " atributo --> " + nombreEattribute+ " tipo -->  " + tipoEattribute);
				
				if (eAttribute.getLowerBound() == 1) {
				
					idVariableYClase = crearAtributoPrimitivoFormulario(eClassReference.getName(),nombreEattribute,tipoEattribute,myWriter,true,idVariableYClase,quienSoy);
				}
				else if (eAttribute.getLowerBound() == 0){ //???
					
					idVariableYClase = crearAtributoPrimitivoFormulario(eClassReference.getName(),nombreEattribute,tipoEattribute,myWriter,false,idVariableYClase,quienSoy);

				}

			}
		} 
		
		for (EAttribute eAttribute : eClassReference.getEAllAttributes()) {
			 String nombreEattribute = eAttribute.getName();
			 String tipoEattribute = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());//
			 
				
			if(eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) { // es una lista
				System.out.println("REVISANDO clase - " + eClassReference.getName()+ " atributo --> " + nombreEattribute+ " tipo -->  " + tipoEattribute);
				i=0;
				for (i=0; i<eAttribute.getLowerBound();i++) {
					idVariableYClase = crearAtributoPrimitivoFormulario(eClassReference.getName(),nombreEattribute, tipoEattribute, myWriter,true,idVariableYClase,quienSoy);	
				}		
			}
		}
		
		///////PARTEC
		for (EReference eReference : eClassReference.getEAllReferences()) {
			//String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
			String nombreEreference = eReference.getName();
			if (!eReference.isContainment()) {// nos fijamos en el upperbound para saber si es atributo o lista
				// si no es containment, que se añada id y punto hasta el lowerbound
				for (i=0; i<eReference.getLowerBound();i++) {
					System.out.println("CLASE: " + eClassReference.getName() + " -> referencia no containment ->" + eReference.getName()+i);
					idVariableYClase = crearAtributoPrimitivoFormulario(eClassReference.getName(),nombreEreference, "Integer", myWriter,true,idVariableYClase,quienSoy);
				}
			}

		}
		
		///////PARTED
		for (EReference eReference : eClassReference.getEAllReferences()) {
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
			String nombreEreference = eReference.getName();
			if (eReference.isContainment()) {// nos fijamos en el upperbound para saber si es atributo o lista
				// si es containment debemos crearlo in situ
				for (i=0; i<eReference.getLowerBound();i++) {
					idVariableYClase = crearEReferenceFormulario(eClassReference,nombreEreference, tipoE, myWriter, eReference,elements,idVariableYClase,quienSoy);
				}
				System.out.println("REVISANDO clase - " + eClassReference.getName()+ " Referencia --> " + nombreEreference+ " tipo -->  " + tipoE);
				System.out.println("Containment: " +eReference.isContainment() +"\n");
			}
			else {
				// si no es containment, que se añada id y punto hasta el lowerbound
				
				System.out.println("REVISANDO clase - " + eClassReference.getName()+ " Referencia --> " + nombreEreference+ " tipo -->  " + tipoE);
				System.out.println("Containment: " +eReference.isContainment() +"\n");
				
			}
		}


		return idVariableYClase;
		////

		
		
	}


	// la idea de esta funcion es poner un id en la clase de la que soy referencia.
	// Nombre del id sera: id_claseDelaQueSoyReferencia, nombreDeEsaVariable
	private void introducirAtributosPorSiEsReferencia(EClass eClass, List<EClassifier> elements, String nombreFichero, String pathSalida) {

		boolean primeroPuesto = false; // para saber si poner el \n y separarlo de las demas variables
		ArrayList<String> atributosAnyadidos = new ArrayList<String>();

		for (EClassifier classifier : elements) {
			// Taking the EClass elements
			if (classifier instanceof EClass) {

				EClass eClassReviewing = (EClass) classifier;

				System.out.println("Chequeando si la clase " + eClass.getName() + " es referencia de "
						+ eClassReviewing.getName());

				// if (eClassReviewing.getName() != eClass.getName()) { // si no es la misma
				// clase

				System.out.println("El nombre es distinto asi que nice\n");

				// if (!eClassReviewing.isAbstract()) {
				for (EReference referenciaOtraClase : eClassReviewing.getEAllReferences()) {
					String tipoE = referenciaOtraClase.getEType().getName();// obtenemos el tipo correspondiente
																			// en Java

					System.out.println("Recorremos referencia: " + tipoE + "\n");

					if (tipoE == eClass.getName()) {// Soy referencia
						// anyadir integer
						System.out.println("YESSS La clase " + eClass.getName() + " es referencia de "
								+ eClassReviewing.getName());
						System.out.println("con upperbound = " + referenciaOtraClase.getUpperBound());
						if (referenciaOtraClase.isContainment()) { // siempre que sea containment metemos el id para el
																	// delete

							try {

								FileWriter myWriter = new FileWriter(nombreFichero, true);

								if (primeroPuesto == false) {
									myWriter.write("\n");
									primeroPuesto = true;

								}

								String nombreVariable = "id_" + eClassReviewing.getName() + "_"
										+ referenciaOtraClase.getName();

								atributosAnyadidos.add(nombreVariable); // anyadimos para despues crear getters y
																		// setters
								myWriter.write("\tprivate Integer " + nombreVariable + ";\n");

								myWriter.close();

							} catch (IOException e) {
								System.out.println("Error el atributo con upperbound 1");
								e.printStackTrace();
							}

							// Comprobamos si ese atributo debe ser not null
							/*
							 * if (referenciaOtraClase.getLowerBound() == 1 nunca ponemos not null porque
							 * para composicion lo miramos desde la interfaz ||
							 * referenciaOtraClase.isContainment()) { try { FileWriter myWriter = new
							 * FileWriter(nombreFichero, true);
							 * 
							 * myWriter.write("NOT NULL");
							 * 
							 * myWriter.close();
							 * 
							 * } catch (IOException e) {
							 * System.out.println("Error el atributo con upperbound 1");
							 * e.printStackTrace(); } }
							 */

							// Cerramos el atributo referencia


						} /*else { // si no es containemnt no metemos el id ya que
									// se crea una tabla

							try {

								FileWriter myWriter = new FileWriter(nombreFichero, true);

								String nombreVariable = "id_" + eClassReviewing.getName() + "_"
										+ referenciaOtraClase.getName();

								myWriter.write("\t\t + \"" + nombreVariable + " INT ");
								if (referenciaOtraClase.isContainment()) {
									clasesReferencia.put(nombreVariable, true);
								} else {
									clasesReferencia.put(nombreVariable, false);
								}
								myWriter.close();

							} catch (IOException e) {
								System.out.println("Error el atributo con upperbound 1");
								e.printStackTrace();
							}

							// Comprobamos si ese atributo debe ser not null


							// Cerramos el atributo referencia
							try {
								FileWriter myWriter = new FileWriter(nombreFichero, true);

								myWriter.write("," + "\"\n");

								myWriter.close();

							} catch (IOException e) {
								System.out.println("Error el atributo con upperbound 1");
								e.printStackTrace();
							}

							// fin tienenRelacionNM
							// }

						} */// fin del else (no es containemnt)

					}
				}

				// }

			}

		}

		// Ahora creamos la propia clase para recoger los atributos del readAll y poder
		// mostrarlos en el JSP, con sus respectivos getters y setters
		// Por ello crearemos los getters y setters de las

		for (String atributo : atributosAnyadidos) {

			// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
			// metodo, por ejemplo getName
			String nombreAtributo = atributo;
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();

			// concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;

			// Creando la propia clase:

			// Creando getters
			try {
				FileWriter myWriter = new FileWriter(nombreFichero, true);

				myWriter.write("\n\n\t" + "public " + "Integer" + " " + "get" + nombreAtributoMayus + " () {\n");
				myWriter.write("\t\t" + " return " + nombreAtributo + ";");
				myWriter.write("\n\t" + "}\n");
				myWriter.close();

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

			// Creando setters

			try {

				FileWriter myWriter = new FileWriter(nombreFichero, true);

				myWriter.write("\n\t" + "public " + "void" + " " + "set" + nombreAtributoMayus + " (" + "Integer "
						+ " p" + nombreAtributoMayus + ") {\n");
				myWriter.write("\t\t" + " this." + nombreAtributo + " = " + "p" + nombreAtributoMayus + ";\n");
				myWriter.write("\t" + "}\n");
				myWriter.close();

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			System.out.println("AAAAPARA LA CLASE " +eClass.getName()  + " anyadimos el id " + atributo);
			crearShowTablaFilteredByAtributo(eClass, elements, atributo,pathSalida);

			
		}

	}

	private LinkedHashMap<String, String> crearTablasRelacionesNMYCRUD(EClass eClass, String nombreFicheroSQLUseless,
			String nombreClase, LinkedHashMap<String, String> tablasCreadas, List<EClassifier> elements) {

		Boolean constructorCreado = false;

		LinkedHashMap<String, Boolean> clasesReferencia = new LinkedHashMap<>(); // contiene el nombre de variable y si es
																		// contenedor o no de la clase que lo contiene

		List<String> clasesAEvaluar = new ArrayList<String>();

		// Going through the list
		// FUNCION IMPORTS

		// ordenaClases

		if (!eClass.isAbstract()) {

			for (EReference eReference : eClass.getEAllReferences()) {

				String nombreAtributo = eReference.getName();

				// limpiamos el array
				if (clasesAEvaluar.size() > 0) {
					clasesAEvaluar.clear();
				}

				clasesAEvaluar.add(eClass.getName());
				clasesAEvaluar.add(eReference.getEType().getName());

				List<String> listaClasesOrdenadas = ordenaClases(clasesAEvaluar);

				String nombrePosibleTablaNM = listaClasesOrdenadas.get(0) + "_" + listaClasesOrdenadas.get(1);

				for (String elemento : tablasCreadas.keySet()) {
					System.out.println(elemento);
				}
				System.out.println("FIN ARRAY");

				EClass eClassAMirarRelacionNM = null;

				for (EClassifier classifier : elements) {

					if (classifier instanceof EClass) {

						EClass eClassReviewing = (EClass) classifier;

						if (eClassReviewing.getName() == eReference.getEType().getName()) { // si la clase es tiene el
																							// mismo nombre que el tipo
																							// de la referencia, tenemos
																							// // la clase

							eClassAMirarRelacionNM = eClassReviewing;

						}

					}
				} // FIN BUSQUEDA CLASE CON NOMBRE

				if (eClassAMirarRelacionNM != null) {// si existe alguna clase que coincida
					if (tienenRelacionNM(eClass, eClassAMirarRelacionNM)) {

						List<String> nombreTablasCreadas = new ArrayList<String>(tablasCreadas.keySet());

						if (!nombreTablasCreadas.contains(nombrePosibleTablaNM)) { // si no existe la tabla, procedemos
																					// a
																					// comprobar si se debe crear

							if (eReference.getUpperBound() >= 2 || eReference.getUpperBound() == -1) { // si resulta que
																										// la referencia
																										// es una lista

								String nombreTabla = nombrePosibleTablaNM;
								String nombreFicheroSQL = "src/sql/";
								nombreFicheroSQL += nombreTabla + "SQL";
								nombreFicheroSQL += ".java"; // SE CREA FICHERO SQL

								// Comprobar si hay alguna clase que exista de ese tipo

								// miramos si coincide la clase a la que hace referencia con esta
								// BUSQUEDA CLASE CON NOMBRE

								// Cogemos la clase de la que es referencia

								crearClaseJavaNM(nombreTabla);

								// crearClaseJavaNMMismoNombre(nombreTabla);
								if (constructorCreado == false) {

									// Anyadimos cabecera
									try {
										FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);
										myWriter.write("package sql;\n");

										myWriter.write("import java.util.*;\n");
										myWriter.write("import java.sql.Connection;\n");
										myWriter.write("import java.sql.DriverManager;\n");
										myWriter.write("import java.sql.PreparedStatement;\n");
										myWriter.write("import java.sql.SQLException;\n");
										myWriter.write("import java.sql.Statement;\n");
										myWriter.write("import java.sql.ResultSet;\n");
										myWriter.write("import javaCode." + nombreTabla + ";\n");

										myWriter.close();

									} catch (IOException e) {
										System.out.println("An error occurred.");
										e.printStackTrace();
									}

									// System.out.print("ENTRAAAAAAAAAAAAAAa");

									try {
										FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);
										myWriter.write("\npublic class " + nombreTabla + "SQL");
										myWriter.write(" {" + "\n\n");
										myWriter.close();

									} catch (IOException e) {
										System.out.println("An error occurred.");
										e.printStackTrace();
									}

									//

									// String nombreTablaE = nombrePosibleTablaNM;
									try {
										// creamos la funcion y creamos la sentencia sql
										FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);
										// ---->clases que se relacionan entre si con nm
										if (eClass.getName() != eClassAMirarRelacionNM.getName()) {

											myWriter.write("\n\tpublic boolean createTable" + nombreTabla
													+ "(Connection connection) throws SQLException {\n");
											// anyadimos la tabla nm
											tablasCreadas.put(nombreTabla, "noEsPrincipal");// Anyadimos la tabla creada
																							// para llevar el
																							// seguimiento //
																							// seguimiento
											myWriter.write(
													"\n\t\tString sql = \"create table " + nombreTabla + "(\"\n");
											myWriter.write("\t\t + \"id int  NOT NULL AUTO_INCREMENT," + "\"\n");
											myWriter.write("\t\t + \"" + "id_" + eClass.getName() + "A int NOT NULL,"
													+ "\"\n");
											myWriter.write("\t\t + \"id_" + eClassAMirarRelacionNM.getName()
													+ "B int NOT NULL," + "\"\n");

											// myWriter.write("\t\t + \""+ "FK abreviado(id_" +eClass.getName() + ")" +
											// " REFERENCES "+eClass.getName() +"(id)\"\n");
											// myWriter.write("\t\t + \""+ "FK abreviado(id_"
											// +eClassAMirarRelacionNM.getName() + ")"+ " REFERENCES "
											// +eClassAMirarRelacionNM.getName() +"(id)\"\n");

										} else {
											// ---->clases que se relacionan entre si con nm
											myWriter.write("\n\tpublic boolean createTable" + nombreTabla
													+ "(Connection connection) throws SQLException {\n");
											tablasCreadas.put(nombreTabla, "noEsPrincipal");// Anyadimos la tabla creada
																							// para llevar el
																							// seguimiento //
																							// seguimiento
											myWriter.write(
													"\n\t\tString sql = \"create table " + nombreTabla + "(\"\n");
											myWriter.write("\t\t + \"id int  NOT NULL AUTO_INCREMENT," + "\"\n");
											myWriter.write("\t\t + \"" + "id_" + eClass.getName() + "A int NOT NULL,"
													+ "\"\n");
											myWriter.write("\t\t + \"id_" + eClassAMirarRelacionNM.getName()
													+ "B int NOT NULL," + "\"\n");
											// myWriter.write("\t\t + \""+ "FK abreviado(id_" +eClass.getName() + ")" +
											// " REFERENCES "+eClass.getName() +"(id)\"\n");
											// myWriter.write("\t\t + \""+ "FK abreviado(id_"
											// +eClassAMirarRelacionNM.getName() + ")"+ " REFERENCES "
											// +eClassAMirarRelacionNM.getName() +"(id)\"\n");

										}

										myWriter.close();
									} catch (IOException e) {
										System.out.println("Error al introducir la tabla " + nombreTabla
												+ " la conexion con la base de datos.");
										e.printStackTrace();

									}

									constructorCreado = true;
								}

								// Comprobamos si ese atributo debe ser not null
								/*
								 * if (eReference.getLowerBound() == 1) { try { FileWriter myWriter = new
								 * FileWriter(nombreFicheroSQL, true);
								 * 
								 * myWriter.write(" NOT NULL");
								 * 
								 * myWriter.close();
								 * 
								 * } catch (IOException e) {
								 * System.out.println("Error el atributo con upperbound 1");
								 * e.printStackTrace(); } }
								 */

								if (constructorCreado == true) {
									try {
										FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

										// Introducimos la FK con la clase de la que viene, que se elimina en cascada ya
										// que
										// no tiene sentido si la clase de la que viene no existe para un tipo primitivo
										// FK(clase2_id), REFERENCES clase2(id) ON DELETE CASCADE,

										myWriter.write("\t\t + \"" + "PRIMARY KEY (id)" + "\"\n");
										myWriter.write("\t\t + \");" + "\";" + "//COMENT\n\n");
										myWriter.write("\t\t System.out.println(sql);\n");
										myWriter.write(
												"\t\tPreparedStatement preparedStatement = connection.prepareStatement(sql); \n");
										myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n\n");
										myWriter.write("\t\tif (rows == 0){\n");
										myWriter.write("\t\t\tSystem.out.println(\"tabla N-M de " + eClass.getName()
												+ " creada...\");\n");
										myWriter.write("\t\t}\n");
										myWriter.write("\t\telse{\n");
										myWriter.write("\t\t\tSystem.out.println(\"Error al crear tabla  N-M de "
												+ eClass.getName() + "\");\n");
										myWriter.write("\t\t\treturn false;\n");
										myWriter.write("\t\t}\n ");
										myWriter.write("\n\t\treturn true;\n");

										myWriter.close();

									} catch (IOException e) {
										System.out.println("Error el atributo con upperbound 1");
										e.printStackTrace();
									}

									try {
										FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

										myWriter.write("\n\t}\n"); // Fin de la funcion

										myWriter.close();

									} catch (IOException e) {
										System.out.println("Error el atributo con upperbound 1");
										e.printStackTrace();
									}

								}
								constructorCreado = false;
								// SI QUEREMOS METER OPERACIONES CRUD DEBERA SER AQUI PIENSO

								// Anyadimos una funcion que ejecute las restricciones de la tabla

								try {
									FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);
									if (eClass.getName() != eClassAMirarRelacionNM.getName()) {

										myWriter.write("\n\tpublic boolean createTable" + nombreTabla
												+ "Constraints(Connection connection) throws SQLException {\n");
										myWriter.write(
												"\n\t\tList<String> constraints = new ArrayList<String>();\n \n");
										myWriter.write("\t\t String sql1 =" + "\"ALTER TABLE " + nombreTabla + "\"\n");
										myWriter.write(
												"\t\t + \"" + " ADD CONSTRAINT "+eReference.getName()+"fk_" + eClass.getName() + "1\"\n");
										myWriter.write(
												"\t\t + \"" + " FOREIGN KEY (id_" + eClass.getName() + "A)" + "\"\n");
										myWriter.write(
												"\t\t + \"" + " REFERENCES " + eClass.getName() + "(id)" + "\"\n");
										myWriter.write("\t\t + \";" + "\";" + "//COMENT\n\n");

										myWriter.write("\t\tString sql2 = " + "\"ALTER TABLE " + nombreTabla + "\"\n");
										myWriter.write("\t\t + \"" + " ADD CONSTRAINT " +eReference.getName() + "fk_"
												+ eClassAMirarRelacionNM.getName() + "2\"\n");
										myWriter.write("\t\t + \"" + " FOREIGN KEY (id_"
												+ eClassAMirarRelacionNM.getName() + "B)" + "\"\n");
										myWriter.write("\t\t + \"" + " REFERENCES " + eClassAMirarRelacionNM.getName()
												+ "(id)" + "\"\n");
										myWriter.write("\t\t + \";" + "\";" + "//COMENT\n\n");

										myWriter.write("\t\tconstraints.add(sql1);\n");
										myWriter.write("\t\tconstraints.add(sql2);\n");

										myWriter.write("\n\t\tfor (String constraint : constraints) {\r\n\n");

										myWriter.write(
												"\t\t\t\tPreparedStatement preparedStatement = connection.prepareStatement(constraint);\n");
										myWriter.write("\t\t\t\tpreparedStatement.executeUpdate();\n");

										// myWriter.write("\t\t\t\tint rows = preparedStatement.executeUpdate();\n\n");
										// myWriter.write("\t\t\t\tif (rows == 0){\n");
										// myWriter.write("\t\t\t\t\tSystem.out.println(\"Constraint tabla N-M de " +
										// eClass.getName() +" anyadida...\");\n");
										// myWriter.write("\t\t\t\t}\n");
										// myWriter.write("\t\t\t\telse{\n");
										// myWriter.write("\t\t\t\t\tSystem.out.println(\"Error al anyadir constaint
										// tabla N-M de " + eClass.getName() + "\");\n");
										// myWriter.write("\t\t\t\t\treturn false;\n");
										// myWriter.write("\t\t\t\t}\n ");
										myWriter.write("\n\t\t\t}\n\n");

										myWriter.write("\n\t\treturn true;\n");
										myWriter.write("\n\t}\n\n");
									}

									else {

										myWriter.write("\n\tpublic boolean createTable" + nombreTabla
												+ "Constraints(Connection connection) throws SQLException {\n");
										myWriter.write(
												"\n\t\tList<String> constraints = new ArrayList<String>();\n \n");
										myWriter.write("\t\t String sql1 =" + "\"ALTER TABLE " + nombreTabla + "\"\n");
										myWriter.write(
												"\t\t + \"" + " ADD CONSTRAINT " + eReference.getName()+"fk_" + eClass.getName() + "1\"\n");
										myWriter.write(
												"\t\t + \"" + " FOREIGN KEY (id_" + eClass.getName() + "A)" + "\"\n");
										myWriter.write(
												"\t\t + \"" + " REFERENCES " + eClass.getName() + "(id)" + "\"\n");
										myWriter.write("\t\t + \";" + "\";" + "//COMENT\n\n");

										myWriter.write("\t\tString sql2 = " + "\"ALTER TABLE " + nombreTabla + "\"\n");
										myWriter.write("\t\t + \"" + " ADD CONSTRAINT " +eReference.getName() +"fk_"
												+ eClassAMirarRelacionNM.getName() + "2\"\n");
										myWriter.write("\t\t + \"" + " FOREIGN KEY (id_"
												+ eClassAMirarRelacionNM.getName() + "B)" + "\"\n");
										myWriter.write("\t\t + \"" + " REFERENCES " + eClassAMirarRelacionNM.getName()
												+ "(id)" + "\"\n");
										myWriter.write("\t\t + \";" + "\";" + "//COMENT\n\n");

										myWriter.write("\t\tconstraints.add(sql1);\n");
										myWriter.write("\t\tconstraints.add(sql2);\n");

										myWriter.write("\n\t\tfor (String constraint : constraints) {\r\n\n");

										myWriter.write(
												"\t\t\t\tPreparedStatement preparedStatement = connection.prepareStatement(constraint);\n");
										myWriter.write("\t\t\t\tpreparedStatement.executeUpdate();\n");

										// myWriter.write("\t\t\t\tint rows = preparedStatement.executeUpdate();\n\n");
										// myWriter.write("\t\t\t\tif (rows == 0){\n");
										// myWriter.write("\t\t\t\t\tSystem.out.println(\"Constraint tabla N-M de " +
										// eClass.getName() +" anyadida...\");\n");
										// myWriter.write("\t\t\t\t}\n");
										// myWriter.write("\t\t\t\telse{\n");
										// myWriter.write("\t\t\t\t\tSystem.out.println(\"Error al anyadir constaint
										// tabla N-M de " + eClass.getName() + "\");\n");
										// myWriter.write("\t\t\t\t\treturn false;\n");
										// myWriter.write("\t\t\t\t}\n ");
										myWriter.write("\n\t\t\t}\n\n");

										myWriter.write("\n\t\treturn true;\n");
										myWriter.write("\n\t}\n\n");

									}
									myWriter.close();
								} catch (IOException e) {
									System.out.println("Error el atributo con upperbound 1");
									e.printStackTrace();
								}
								// myWriter.write("\t\t + \""+ "FK (id_" +eClass.getName() + ")" + " REFERENCES
								// "+eClass.getName() +"(id)\"\n");
								// myWriter.write("\t\t + \""+ "FK (id_" +eClassAMirarRelacionNM.getName() +
								// ")"+ " REFERENCES " +eClassAMirarRelacionNM.getName() +"(id)\"\n");

								// EMPEZAMOS CON LAS OPERACIONES CRUD NM

								// AHora anyadir todas las funciones CRUD NM

								/*
								 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
								 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
								 * + ");";//COMENT
								 */

								// EMPEZAMOS POR EL INSERT NM
								try {
									FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

									if (eClass.getName() != eClassAMirarRelacionNM.getName()) {
										myWriter.write("\n\tpublic boolean insertRow" + nombreTabla
												+ "(Connection connection, String id_" + eClass.getName()
												+ "A, String id_" + eClassAMirarRelacionNM.getName()
												+ "B) throws SQLException {\n");

										myWriter.write("\t\t String sql = \"insert into " + nombreTabla + " (" + "id_"
												+ eClass.getName() + "A, id_" + eClassAMirarRelacionNM.getName() + "B"
												+ ") values (?,?)\";\n");
										myWriter.write(
												"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n");
										myWriter.write(
												"\t\t preparedStatement.setString(1,id_" + eClass.getName() + "A);\n");
										myWriter.write("\t\t preparedStatement.setString(2,id_"
												+ eClassAMirarRelacionNM.getName() + "B);\n");
										myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n");

										myWriter.write("\t\tif (rows >0){\n");

										myWriter.write(
												"\n\t\t\tSystem.out.println(\"Fila insertada correctamente en la "
														+ nombreTabla + "\");\n\n");
										myWriter.write("\t\t}\n");
										myWriter.write("\n\t\treturn true;\n");
										myWriter.write("\t}\n");

									} else {

										myWriter.write("\n\tpublic boolean insertRow" + nombreTabla
												+ "(Connection connection, String id_" + eClass.getName()
												+ "A, String id_" + eClassAMirarRelacionNM.getName()
												+ "B) throws SQLException {\n");

										myWriter.write("\t\t String sql = \"insert into " + nombreTabla + " (" + "id_"
												+ eClass.getName() + "A, id_" + eClassAMirarRelacionNM.getName() + "B"
												+ ") values (?,?)\";\n");
										myWriter.write(
												"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n");
										myWriter.write(
												"\t\t preparedStatement.setString(1,id_" + eClass.getName() + "A);\n");
										myWriter.write("\t\t preparedStatement.setString(2,id_"
												+ eClassAMirarRelacionNM.getName() + "B);\n");
										myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n");

										myWriter.write("\t\tif (rows >0){\n");

										myWriter.write(
												"\n\t\t\tSystem.out.println(\"Fila insertada correctamente en la "
														+ nombreTabla + "\");\n\n");
										myWriter.write("\t\t}\n");
										myWriter.write("\n\t\treturn true;\n");
										myWriter.write("\t}\n");

									}

									myWriter.close();
								} catch (IOException e) {
									System.out.println("Error el atributo con upperbound 1");
									e.printStackTrace();
								}
								// AHORA POR EL READ NM
								/*
								 * String sql = "create table RevoltosoM_RevoltosoN(" + "id int  NOT NULL," +
								 * "id_RevoltosoN int NOT NULL," + "id_RevoltosoM int NOT NULL," +
								 * "PRIMARY KEY (id_RevoltosoN,id_RevoltosoM)" + ");";//COMENT
								 */

								try {
									FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

									// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
									// metodo, por ejemplo getName

									String nombreAtributoMayus = "";
									String firstLtr = nombreAtributo.substring(0, 1);
									String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

									// ponemos mayuscula la primera letra
									firstLtr = firstLtr.toUpperCase();
									// concatenamos
									nombreAtributoMayus = firstLtr + restLtrs;
									if (eClass.getName() != eClassAMirarRelacionNM.getName()) {
										myWriter.write("\n\tpublic List<" + nombreTabla + "> readAll"
												+ "(Connection connection)" + " throws SQLException {\n\n");

										myWriter.write("\t\t List<" + nombreTabla + "> variableRetorno = new ArrayList<"
												+ nombreTabla + ">();\n\n");
										myWriter.write("\t\t String sql = \"select * from " + nombreTabla + "\";\n");
										myWriter.write("\t\t Statement statement = connection.createStatement();\n");
										myWriter.write("\t\t ResultSet result = statement.executeQuery(sql);\n\n");
										myWriter.write("\t\t while(result.next()) {" + "\n");
										myWriter.write("\t\t\t " + nombreTabla + " s = new " + nombreTabla + "();\n\n");

										myWriter.write("\t\t\t Integer id" + " = result.getInt(\"id\");" + "\n");
										myWriter.write("\t\t\t s.setId(id);\n\n");

										myWriter.write("\t\t\t Integer " + "idClase1" + " = result.getInt(\"id_"
												+ eClass.getName() + "\");" + "\n");
										myWriter.write("\t\t\t s.setId_" + eClass.getName() + "A(idClase1);\n\n");

										myWriter.write("\t\t\t Integer " + "idClase2" + " = result.getInt(\"id_"
												+ eClassAMirarRelacionNM.getName() + "\");" + "\n");
										myWriter.write("\t\t\t s.setId_" + eClassAMirarRelacionNM.getName()
												+ "B(idClase2);\n\n");

										myWriter.write("\t\t\t variableRetorno.add(s);\n\n");

										myWriter.write("\t\t}\n");

										myWriter.write("\n\t\treturn variableRetorno;\n");
										myWriter.write("\t}\n");

									} else {

										myWriter.write("\n\tpublic List<" + nombreTabla + "> readAll"
												+ "(Connection connection)" + " throws SQLException {\n\n");

										myWriter.write("\t\t List<" + nombreTabla + "> variableRetorno = new ArrayList<"
												+ nombreTabla + ">();\n\n");
										myWriter.write("\t\t String sql = \"select * from " + nombreTabla + "\";\n");
										myWriter.write("\t\t Statement statement = connection.createStatement();\n");
										myWriter.write("\t\t ResultSet result = statement.executeQuery(sql);\n\n");
										myWriter.write("\t\t while(result.next()) {" + "\n");
										myWriter.write("\t\t\t " + nombreTabla + " s = new " + nombreTabla + "();\n\n");

										myWriter.write("\t\t\t Integer id" + " = result.getInt(\"id\");" + "\n");
										myWriter.write("\t\t\t s.setId(id);\n\n");

										myWriter.write("\t\t\t Integer " + "idClase1" + " = result.getInt(\"id_"
												+ eClass.getName() + "\");" + "\n");
										myWriter.write("\t\t\t s.setId_" + eClass.getName() + "A(idClase1);\n\n");

										myWriter.write("\t\t\t Integer " + "idClase2" + " = result.getInt(\"id_"
												+ eClassAMirarRelacionNM.getName() + "\");" + "\n");
										myWriter.write("\t\t\t s.setId_" + eClassAMirarRelacionNM.getName()
												+ "B(idClase2);\n\n");

										myWriter.write("\t\t\t variableRetorno.add(s);\n\n");

										myWriter.write("\t\t}\n");

										myWriter.write("\n\t\treturn variableRetorno;\n");
										myWriter.write("\t}\n");

									}

									myWriter.close();
								} catch (IOException e) {
									System.out.println("Error el atributo con upperbound 1");
									e.printStackTrace();
								}

								// AHORA POR EL UPDATE NM
								/*
								 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
								 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
								 * + ");";//COMENT
								 */

								try {
									FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

									// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
									// metodo, por ejemplo getName

									String nombreAtributoMayus = "";
									String firstLtr = nombreAtributo.substring(0, 1);
									String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

									// ponemos mayuscula la primera letra
									firstLtr = firstLtr.toUpperCase();
									// concatenamos
									nombreAtributoMayus = firstLtr + restLtrs;
									if (eClass.getName() != eClassAMirarRelacionNM.getName()) {

										myWriter.write("\n\tpublic void updateTable" + nombreTabla
												+ "(Connection connection, Integer idP, " + "Integer id_"
												+ eClass.getName() + "AP, " + "Integer id_"
												+ eClassAMirarRelacionNM.getName() + "BP" + ")"
												+ " throws SQLException {\n\n\n");

										myWriter.write("\t\t String sql = \"Update " + nombreTabla + " set " + "id_"
												+ eClass.getName() + "A=?, " + "id_" + eClassAMirarRelacionNM.getName()
												+ "B=? " + " where " + "id=?" + "\";\n");

										myWriter.write(
												"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n\n");
										myWriter.write("\t\t preparedStatement." + "setInt(1," + "id_"
												+ eClass.getName() + "AP);\n");
										myWriter.write("\t\t preparedStatement." + "setInt(2," + "id_"
												+ eClassAMirarRelacionNM.getName() + "BP);\n");
										myWriter.write("\t\t preparedStatement." + "setInt(3," + "idP" + ");\n\n");

										myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n");

										myWriter.write("\t\tif (rows >0){\n");

										myWriter.write("\t\t\tSystem.out.println(\"Fila insertada correctamente en la "
												+ nombreTabla + "\");\n");
										myWriter.write("\t\t}\n");
										//

										// myWriter.write("\t\t}\n");

										myWriter.write("\t}\n");
									} else {

										myWriter.write("\n\tpublic void updateTable" + nombreTabla
												+ "(Connection connection, Integer idP, " + "Integer id_"
												+ eClass.getName() + "AP, " + "Integer id_"
												+ eClassAMirarRelacionNM.getName() + "BP" + ")"
												+ " throws SQLException {\n\n\n");

										myWriter.write("\t\t String sql = \"Update " + nombreTabla + " set " + "id_"
												+ eClass.getName() + "A=?, " + "id_" + eClassAMirarRelacionNM.getName()
												+ "B=? " + " where " + "id=?" + "\";\n");

										myWriter.write(
												"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n\n");
										myWriter.write("\t\t preparedStatement." + "setInt(1," + "id_"
												+ eClass.getName() + "AP);\n");
										myWriter.write("\t\t preparedStatement." + "setInt(2," + "id_"
												+ eClassAMirarRelacionNM.getName() + "BP);\n");
										myWriter.write("\t\t preparedStatement." + "setInt(3," + "idP" + ");\n\n");

										myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n");

										myWriter.write("\t\tif (rows >0){\n");

										myWriter.write("\t\t\tSystem.out.println(\"Fila insertada correctamente en la "
												+ nombreTabla + "\");\n");
										myWriter.write("\t\t}\n");
										//

										// myWriter.write("\t\t}\n");

										myWriter.write("\t}\n");

									}

									myWriter.close();
								} catch (IOException e) {
									System.out.println("Error el atributo con upperbound 1");
									e.printStackTrace();
								}

								// AHORA POR EL DELETE NM
								/*
								 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
								 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
								 * + ");";//COMENT
								 */

								try {
									FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

									// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
									// metodo, por ejemplo getName

									String nombreAtributoMayus = "";
									String firstLtr = nombreAtributo.substring(0, 1);
									String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

									// ponemos mayuscula la primera letra
									firstLtr = firstLtr.toUpperCase();
									// concatenamos
									nombreAtributoMayus = firstLtr + restLtrs;
									if (eClass.getName() != eClassAMirarRelacionNM.getName()) {

										myWriter.write("\n\tpublic void deleteById"
												+ "(Connection connection, Integer valorAtributo)"
												+ " throws SQLException {\n\n\n");

										myWriter.write("\t\t String sql = \"delete * from  " + nombreTabla + " where "
												+ "id=?" + "\";\n");

										myWriter.write(
												"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n\n");
										myWriter.write(
												"\t\t preparedStatement." + "setInt(1," + "valorAtributo)" + ";\n");

										myWriter.write("\t\t int rows = preparedStatement.executeUpdate();\n");

										myWriter.write("\t\t if (rows >0){\n");

										myWriter.write("\t\t\t System.out.println(\"Fila insertada correctamente en la "
												+ nombreTabla + "\");\n");
										myWriter.write("\t\t }\n");

										myWriter.write("\t }\n");
									} else {

										myWriter.write("\n\tpublic void deleteById"
												+ "(Connection connection, Integer valorAtributo)"
												+ " throws SQLException {\n\n\n");

										myWriter.write("\t\t String sql = \"delete * from  " + nombreTabla + " where "
												+ "id=?" + "\";\n");

										myWriter.write(
												"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n\n");
										myWriter.write(
												"\t\t preparedStatement." + "setInt(1," + "valorAtributo)" + ";\n");

										myWriter.write("\t\t int rows = preparedStatement.executeUpdate();\n");

										myWriter.write("\t\t if (rows >0){\n");

										myWriter.write("\t\t\t System.out.println(\"Fila insertada correctamente en la "
												+ nombreTabla + "\");\n");
										myWriter.write("\t\t }\n");

										myWriter.write("\t }\n");

									}
									myWriter.close();
								} catch (IOException e) {
									System.out.println("Error el atributo con upperbound 1");
									e.printStackTrace();
								}

								// cerramos la clase
								try {
									FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);
									myWriter.write("}" + "\n\n");
									myWriter.close();

								} catch (IOException e) {
									System.out.println("An error occurred.");
									e.printStackTrace();
								}

							} // fin del if del upperbound

						}
					}
				}
			} // FIN DE RECORRER EATTRIBUTES que no son tabla a parte

		} // Fin si no es abstracta

		return tablasCreadas;

	}

	private LinkedHashMap<String, String> tablasArrayAtributosPrimitivosYCRUD(EClass eClass, String nombreFicheroSQLQuitar,
			String nombreClase, LinkedHashMap<String, String> tablasCreadas, List<EClassifier> elements, String pathSalida) {

		Boolean constructorCreado = false;
		Boolean cabeceraDeClaseJavaCreada = false;

		LinkedHashMap<String, Boolean> clasesReferencia = new LinkedHashMap<>(); // contiene el nombre de variable y si es
																		// contenedor o no de la clase que lo contiene

		// FK(clase1_id), REFERENCES clase1(id) ON DELETE CASCADE,

		// Going through the list
		// FUNCION IMPORTS

		// ordenaClases

		if (!eClass.isAbstract()) {

			// Lo del lower se comprobara con los controladores de jsp. Igual que la
			// composición al crear y eliminar on cascade
			// se se trata de un atributo normal, se pone tal cual el tipo. Esto es para los
			// tipos:
			// boolean,String, Date, double, long, int, float, short
			// si nos de ninguno de esos tipos y es un 1 en lower y 1 en upper se pone un
			// int

			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				String tipo = eAttribute.getEType().getInstanceClass().getSimpleName();// obtenemos el tipo
																						// correspondiente en Java

				// Comprobacion si el atributo es heredado o no para poner @override
				EClass clase = eClass;
				String nombreDelAtributo = eAttribute.getName();
				EStructuralFeature featurePropio = clase.getEStructuralFeature(nombreDelAtributo);
				boolean esHeredado = false;

				// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
				// metodo, por ejemplo getName
				String nombreAtributo = eAttribute.getName();

				String tipoCambiadoDeJavaASQL = tipoEcoreATipoSQL(tipo);

				// GESTIONAMOS CREACION DEL NOMBRE DEL FICHERO
				String nombreTabla = eClass.getName() + "_" + nombreAtributo;
				
				//ficheroSalida
				//String nombreFicheroSQL = "src/sql/";
				String nombreFicheroSQL = pathSalida + File.separator + "sql" + File.separator;
				nombreFicheroSQL += nombreTabla + "SQL";
				String nombreClaseSQL = nombreTabla;
				nombreFicheroSQL += ".java"; // SE CREA FICHERO SQL

				// Creamos el metodo para buscar por el atributo; Esto era antes de sacarlo a
				// otra funcion fuera en el main
				// crearReadDB(eClass, nombreFichero, nombreClase,
				// nombreAtributo,nombreAtributoMayus);

				// para los tipos que no son los predeterminados guardaremos un integer que sera
				// el identificador del objeto

				if (eAttribute.getUpperBound() >= 2 || eAttribute.getUpperBound() == -1) {

					if (constructorCreado == false) {
						crearClaseSQL(null, nombreFicheroSQL, nombreClaseSQL);
						try {
							// creamos la funcion y creamos la sentencia sql
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							myWriter.write("\npublic class " + nombreTabla + "SQL");
							myWriter.write(" {" + "\n\n");

							myWriter.write("\n\tpublic boolean createTable" + nombreTabla
									+ "(Connection connection) throws SQLException {\n");
							// anyadimos tabla array primitivo
							tablasCreadas.put(nombreTabla, "noEsPrincipal");// Anyadimos la tabla creada para llevar el
																			// seguimiento
							myWriter.write("\n\t\tString sql = \"create table " + nombreTabla + "(\"\n");
							myWriter.write("\t\t + \"id int NOT NULL AUTO_INCREMENT," + "\"\n");
							myWriter.write("\t\t + \"id_" + eClass.getName() + " int NOT NULL," + "\"\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error al introducir la tabla " + nombreTabla);
							e.printStackTrace();

						}

						constructorCreado = true;
					}

					try {
						FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

						myWriter.write("\t\t + \"" + nombreAtributo + " " + tipoCambiadoDeJavaASQL.toLowerCase());

						myWriter.close();

					} catch (IOException e) {
						System.out.println("Error el atributo con upperbound 1");
						e.printStackTrace();
					}

					// Comprobamos si ese atributo debe ser not null
					// SIEMPRE NOT NULL EN ESA TABLA YA QUE ES REFERNCIADA
					try {
						FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

						myWriter.write(" NOT NULL");

						myWriter.close();

					} catch (IOException e) {
						System.out.println("Error el atributo con upperbound 1");
						e.printStackTrace();
					}

					// Cerramos el atributo
					try {
						FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

						myWriter.write("," + "\"\n");

						myWriter.close();

					} catch (IOException e) {
						System.out.println("Error el atributo con upperbound 1");
						e.printStackTrace();
					}

					if (constructorCreado == true) {
						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Introducimos la FK con la clase de la que viene, que se elimina en cascada ya
							// que
							// no tiene sentido si la clase de la que viene no existe para un tipo primitivo
							// FK (clase2_id), REFERENCES clase2(id) ON DELETE CASCADE,
							// myWriter.write("\t\t + \"FK ("+ eClass.getName() + "_id) REFERENCES "+
							// eClass.getName() +"(id) ON DELETE CASCADE,\"" + "\n");
							myWriter.write("\t\t + \"PRIMARY KEY (id)\"" + "\n");
							myWriter.write("\t\t + \");" + "\";" + "//COMENT\n\n");
							myWriter.write("\t\t System.out.println(sql);\n");
							myWriter.write(
									"\t\tPreparedStatement preparedStatement = connection.prepareStatement(sql);\n");
							myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n\n");
							myWriter.write("\t\tif (rows == 0){\n");
							myWriter.write(
									"\t\t\tSystem.out.println(\"tabla de" + eClass.getName() + " creada...\");\n");
							myWriter.write("\t\t}\n");
							myWriter.write("\t\telse{\n");
							myWriter.write(
									"\t\t\tSystem.out.println(\"Error al crear tabla de" + eClass.getName() + "\");\n");
							myWriter.write("\t\t\treturn false;\n");
							myWriter.write("\t\t}\n ");
							myWriter.write("\n\t\treturn true;\n");
							myWriter.close();

						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}

						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							myWriter.write("\n\t}\n"); // Fin de la funcion

							myWriter.close();

						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}

						// AHORA ANYADIMOS LA FUNCION DE CREAR CONSTRAINTS
						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							myWriter.write("\n\tpublic boolean createTable" + nombreTabla
									+ "Constraints(Connection connection) throws SQLException {\n");
							myWriter.write("\n\t\tList<String> constraints = new ArrayList<String>();\n \n");

							myWriter.write("\t\t String sql1 =" + "\"ALTER TABLE " + nombreTabla + "\"\n");
							myWriter.write("\t\t + \"" + " ADD CONSTRAINT "+nombreAtributo+"fk_Id_" + eClass.getName() + "1\"\n");
							myWriter.write("\t\t + \"" + " FOREIGN KEY (id_" + eClass.getName() + ")" + "\"\n");
							myWriter.write("\t\t + \"" + " REFERENCES " + eClass.getName() + "(id)" + "\"\n");
							myWriter.write("\t\t + \"" + " ON DELETE CASCADE" + "\"\n");
							myWriter.write("\t\t + \";" + "\";" + "//COMENT\n\n");

							myWriter.write("\t\tconstraints.add(sql1);\n");

							myWriter.write("\n\t\tfor (String constraint : constraints) {\r\n\n");

							myWriter.write(
									"\t\t\t\tPreparedStatement preparedStatement = connection.prepareStatement(constraint);\n");
							myWriter.write("\t\t\t\tpreparedStatement.executeUpdate();\n");

							myWriter.write("\n\t\t\t}\n\n");

							myWriter.write("\n\t\treturn true;\n");
							myWriter.write("\n\t}\n\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}
						// myWriter.write("\t\t + \""+ "FK abrebiado (id_" +eClass.getName() + ")" + "
						// REFERENCES "+eClass.getName() +"(id)\"\n");
						// myWriter.write("\t\t + \""+ "FK abreviado (id_"
						// +eClassAMirarRelacionNM.getName() + ")"+ " REFERENCES "
						// +eClassAMirarRelacionNM.getName() +"(id)\"\n");

						// AHora anyadir todas las funciones CRUD

						/*
						 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
						 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
						 * + ");";//COMENT
						 */

						// EMPEZAMOS POR EL INSERT
						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							myWriter.write("\n\tpublic boolean insertRow" + nombreTabla
									+ "(Connection connection, String " + eClass.getName() + "Id"
									+ ", String " + nombreDelAtributo + ") throws SQLException {\n");

							myWriter.write("\t\t String sql = \"insert into " + nombreTabla + " (id_"
									+ eClass.getName() + "," + nombreDelAtributo + ") values (?,?)\";\n");
							myWriter.write(
									"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n");
							myWriter.write("\t\t preparedStatement.setString(1," + eClass.getName() + "Id);\n");
							//myWriter.write("\t\tpreparedStatement.setString");
							System.out.println("QUE TIPO ME ENTRA? "+nombreDelAtributo+"-"+ tipo);

							//myWriter.write("\t\t preparedStatement.setString(2," + nombreDelAtributo + ");\n");
							myWriter.write("\t\tpreparedStatement." + tipoJavaATipoSetResult(tipoWrapper(tipo)));
							myWriter.write("("+ "2" + ",");
							myWriter.write(casteoEnFuncionDelTipo(tipoWrapper(tipo)));		
							//Comprobacion para hacer casteo en funcion del tipo
							
							
							myWriter.write(""  + nombreDelAtributo  + ")" + cierraCasteoEnFuncionDelTipo(tipo)+ ";\n");
							
							myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n");

							myWriter.write("\t\tif (rows >0){\n");

							myWriter.write("\n\t\t\tSystem.out.println(\"Fila insertada correctamente en la "
									+ nombreTabla + "\");\n\n");
							myWriter.write("\t\t}\n");
							myWriter.write("\n\t\treturn true;\n");
							myWriter.write("\t}\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}
						// AHORA POR EL READ
						/*
						 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
						 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
						 * + ");";//COMENT
						 */

						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
							// metodo, por ejemplo getName

							String nombreAtributoMayus = "";
							String firstLtr = nombreAtributo.substring(0, 1);
							String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

							// ponemos mayuscula la primera letra
							firstLtr = firstLtr.toUpperCase();
							// concatenamos
							nombreAtributoMayus = firstLtr + restLtrs;

							myWriter.write("\n\tpublic List<" + nombreTabla + "> readAll" + nombreTabla
									+ "(Connection connection)" + " throws SQLException {\n\n");

							myWriter.write("\t\t List<" + nombreTabla + "> variableRetorno = new ArrayList<"
									+ nombreTabla + ">();\n\n");
							myWriter.write("\t\t String sql = \"select * from " + nombreTabla + "\";\n");
							myWriter.write("\t\t Statement statement = connection.createStatement();\n");
							myWriter.write("\t\t ResultSet result = statement.executeQuery(sql);\n\n");
							myWriter.write("\t\t while(result.next()) {" + "\n");
							myWriter.write("\t\t\t " + nombreTabla + " s = new " + nombreTabla + "();\n\n");

							myWriter.write("\t\t\t Integer id" + " = result.getInt(\"id\");" + "\n");
							myWriter.write("\t\t\t s.setId(id);\n\n");

							myWriter.write("\t\t\t Integer " + "idClase" + " = result.getInt(\"id_" + eClass.getName()
									+ "\");" + "\n");
							myWriter.write("\t\t\t s.setId_" + eClass.getName() + "(idClase);\n\n");

							
							//String tipoCambiadoDeJavaASQL = tipoEcoreATipoSQL(tipo);

							myWriter.write("\t\t\t " + tipoWrapper(tipo) + " variableTipoPrimitivo" + " = result."
									+ tipoJavaATipoGetResult(tipoWrapper(tipo)) + "(\"" + nombreAtributo + "\")");
							
							if (tipo == "char"){
								myWriter.write(".charAt(0);//ACHAAAAAR \n");
							}
							else {
								myWriter.write(";\n");

								
							}
							
							
							myWriter.write("\t\t\t s.set" + nombreAtributoMayus + "(variableTipoPrimitivo);\n\n");

							myWriter.write("\t\t\t variableRetorno.add(s);\n\n");

							myWriter.write("\t\t}\n");

							myWriter.write("\n\t\treturn variableRetorno;\n");
							myWriter.write("\t}\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}
						// AHORA EL SEARCH BY por ID
						/*
						 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
						 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
						 * + ");";//COMENT
						 */

						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
							// metodo, por ejemplo getName

							String nombreAtributoMayus = "";
							String firstLtr = nombreAtributo.substring(0, 1);
							String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

							// ponemos mayuscula la primera letra
							firstLtr = firstLtr.toUpperCase();
							// concatenamos
							nombreAtributoMayus = firstLtr + restLtrs;

							myWriter.write("\n\tpublic List<" + nombreTabla + "> searchById_" + eClass.getName()
									+ "(Connection connection, Integer pId_" + eClass.getName()
									+ ") throws SQLException {\n\n");

							myWriter.write("\t\t List<" + nombreTabla + "> variableRetorno = new ArrayList<"
									+ nombreTabla + ">();\n\n");
							myWriter.write("\t\t String sql = \"select * " + "from " + nombreTabla + " where Id_"
									+ eClass.getName() + "=?" + "\";\n");

							myWriter.write(
									"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n\n");
							myWriter.write("\t\t preparedStatement." + "setInt(1,pId_" + eClass.getName() + ");\n");
							myWriter.write("\t\t ResultSet result = preparedStatement.executeQuery();\n\n");
							myWriter.write("\t\t while(result.next()) {" + "\n");
							myWriter.write("\t\t\t " + nombreTabla + " s = new " + nombreTabla + "();\n\n");

							myWriter.write("\t\t\t Integer id" + " = result.getInt(\"id\");" + "\n");
							myWriter.write("\t\t\t s.setId(id);\n\n");

							myWriter.write("\t\t\t Integer " + "idClase" + " = result.getInt(\"id_" + eClass.getName()
									+ "\");" + "\n");
							myWriter.write("\t\t\t s.setId_" + eClass.getName() + "(idClase);\n\n");

							
						
							
							myWriter.write("\t\t\t " + tipoWrapper(tipo) + " variableTipoPrimitivo" + " = result."
									+ tipoJavaATipoGetResult(tipoWrapper(tipo)) + "(\"" + nombreAtributo + "\")");
							
							if (tipo == "char"){
								myWriter.write(".charAt(0);//ACHAAAAAR \n");
							}
							else {
								
								myWriter.write(";//ACHAAAAAR \n");

							}
			
							
							myWriter.write("\t\t\t s.set" + nombreAtributoMayus + "(variableTipoPrimitivo);\n\n");

							myWriter.write("\t\t\t variableRetorno.add(s);\n\n");

							myWriter.write("\t\t}\n");

							myWriter.write("\n\t\treturn variableRetorno;\n");
							myWriter.write("\t}\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}

						// AHORA POR EL UPDATE
						/*
						 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
						 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
						 * + ");";//COMENT
						 */

						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
							// metodo, por ejemplo getName

							String nombreAtributoMayus = "";
							String firstLtr = nombreAtributo.substring(0, 1);
							String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

							// ponemos mayuscula la primera letra
							firstLtr = firstLtr.toUpperCase();
							// concatenamos
							nombreAtributoMayus = firstLtr + restLtrs;

							myWriter.write("\n\tpublic void updateTable" + nombreTabla
									+ "(Connection connection, Integer idP, " + "Integer Id_" + eClass.getName() + "P, "
									+ tipoWrapper(tipo) + " " + nombreAtributo + "P" + ")"
									+ " throws SQLException {\n\n\n");

							myWriter.write(
									"\t\t String sql = \"Update " + nombreTabla + " set " + "id_" + eClass.getName()
											+ "=?, " + nombreAtributo + "=? " + " where " + "id=?" + "\";\n");

							myWriter.write(
									"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n\n");
							myWriter.write(
									"\t\t preparedStatement." + "setInt(1," + "Id_" + eClass.getName() + "P);\n");
							
							myWriter.write("\t\t preparedStatement." + tipoJavaATipoSetResult(tipoWrapper(tipo)) + "(2,");
							
							if (tipo == "char"){
								myWriter.write("Character.toString(");
							}
			
							
							
							myWriter.write(nombreAtributo + "P");
							
							if (tipo == "char"){
								myWriter.write("));\n");
							}
							
							else{
								myWriter.write(");\n");
							}
							
							myWriter.write("\t\t preparedStatement." + "setInt(3," + "idP" + ");\n\n");

							myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n");

							myWriter.write("\t\tif (rows >0){\n");

							myWriter.write("\t\t\tSystem.out.println(\"Fila actualizada correctamente en la tabla "
									+ nombreTabla + "\");\n");
							myWriter.write("\t\t}\n");
							//

							// myWriter.write("\t\t}\n");

							myWriter.write("\t}\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}

						// AHORA POR EL DELETE
						/*
						 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
						 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
						 * + ");";//COMENT
						 */

						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
							// metodo, por ejemplo getName

							String nombreAtributoMayus = "";
							String firstLtr = nombreAtributo.substring(0, 1);
							String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

							// ponemos mayuscula la primera letra
							firstLtr = firstLtr.toUpperCase();
							// concatenamos
							nombreAtributoMayus = firstLtr + restLtrs;

							myWriter.write(
									"\n\tpublic void deleteById" + "(Connection connection, Integer valorAtributo)"
											+ " throws SQLException {\n\n\n");

							myWriter.write(
									"\t\t String sql = \"delete * from  " + nombreTabla + " where " + "id=?" + "\";\n");

							myWriter.write(
									"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n\n");
							myWriter.write("\t\t preparedStatement." + "setInt(1," + "valorAtributo)" + ";\n");

							myWriter.write("\t\t int rows = preparedStatement.executeUpdate();\n");

							myWriter.write("\t\t if (rows >0){\n");

							myWriter.write("\t\t\t System.out.println(\"Fila eliminada correctamente en la tabla"
									+ nombreTabla + "\");\n");
							myWriter.write("\t\t }\n");

							myWriter.write("\t }\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}
					}

					cerrarClaseSQL(eClass, nombreFicheroSQL, nombreClaseSQL);

					constructorCreado = false;

					// Aqui tenemos que comenzar a crear todo lo de la clase JAVA

					crearClaseJavaArrayAtributoPrimitvo(eClass, nombreTabla, tipoWrapper(tipo),pathSalida);
					
					crearShowTablaAtributoPrimitivo(eClass, nombreTabla, tipoWrapper(tipo),pathSalida);

				} else {
					// System.out.println("El atributo " +nombreAtributo + " algun atributo con
					// upper bound = a 1");
				}
			} // FIN DE RECORRER EATTRIBUTES que no son tabla a parte

		} // Fin si no es abstracta

		return tablasCreadas;

	}

	private void crearShowTablaAtributoPrimitivo(EClass eClass, String nombreTabla, String tipoWrapper, String pathSalida) {

		// CREAMOS EL DIRECTORIO
		//ficheroSalida
		File carpeta = new File("src/codigoServlet");
		if (!carpeta.exists()) {
			boolean resultado = carpeta.mkdirs();
			if (resultado) {
				System.out.println("Carpeta creada exitosamente.");
			} else {
				System.out.println("No se pudo crear la carpeta.");
			}
		}
		
			
		String nombreClase = "ShowTP" + nombreTabla;
		
		//ficheroSalida
		//String nombreFichero = "src/codigoServlet/";
		
		String nombreFichero = pathSalida+ File.separator +"codigoServlet" + File.separator;

		
		nombreFichero += nombreClase;
		nombreFichero += ".java"; // SE CREA FICHERO JSP

		
		//informacion de la tabla
		String[] partes = nombreTabla.split("_");
		String nombreClaseDeLaQueEsContenedor = partes[0];
		String nombreDeLaVariable = partes[1];
		String tipoVariableListada = tipoWrapper;
		
		
		try {

			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("package codigoServlet;\n");

			myWriter.write("import java.io.IOException;\n");
			myWriter.write("import java.io.PrintWriter;\n");
			myWriter.write("import java.sql.Connection;\n");
			myWriter.write("import java.sql.DriverManager;\n");
			myWriter.write("import java.sql.PreparedStatement;\n");
			myWriter.write("import java.sql.ResultSet;\n");
			myWriter.write("import java.sql.SQLException;\n");
			myWriter.write("import java.util.ArrayList;\n");
			myWriter.write("import java.util.LinkedHashMap;\n");
			myWriter.write("import java.util.List;\n");
			myWriter.write("import java.util.Map;\n");
			myWriter.write("\n");
			myWriter.write("import javax.servlet.ServletException;\n");
			myWriter.write("import javax.servlet.annotation.WebServlet;\n");
			myWriter.write("import javax.servlet.http.HttpServlet;\n");
			myWriter.write("import javax.servlet.http.HttpServletRequest;\n");
			myWriter.write("import javax.servlet.http.HttpServletResponse;\n");
			myWriter.write("\n");
			myWriter.write("import javaCode." +nombreTabla + ";\n");
			myWriter.write("import sql." + eClass.getName() + "SQL;\n");
			myWriter.write("import sql." + nombreTabla + "SQL;\n");

			myWriter.write("\n");
			myWriter.write("@WebServlet(\"/showTP" + nombreTabla + "\")\n");
			myWriter.write("public class ShowTP" + nombreTabla + " extends HttpServlet {\n");
			myWriter.write("\n");
			// myWriter.write("\tprivate final static String query = \"select * from
			// user\";\n");
			myWriter.write("\n");
			myWriter.write("\t@Override\n");
			myWriter.write(
					"\tprotected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {\n");
			myWriter.write("\n");
			myWriter.write(
					"\t\tList<" + nombreTabla + "> variableClase = new ArrayList<" + nombreTabla+ ">(); \n");
			//myWriter.write("\t\tLinkedHashMap<String, String> atributosClase = new LinkedHashMap<String, String>();\n");
			myWriter.write("\t\t" + nombreTabla + "SQL variableClaseSQL= new " + nombreTabla + "SQL();\n");
			myWriter.write("\t\t" + nombreTabla + " sj = new " + nombreTabla + "();\n");
			
			myWriter.write("\t\tint id = Integer.parseInt(req.getParameter(\"id\"));\n");

			myWriter.write("\t\t//get PrintWriter\n");
			myWriter.write("\t\tPrintWriter pw = res.getWriter();\n");
			myWriter.write("\t\t//set content type\n");
			myWriter.write("\t\tres.setContentType(\"text/html\");\n");
			myWriter.write("\t\t// link the bootstrap\n");
			myWriter.write("\t\tpw.println(\"<link rel='stylesheet' href =  'css/bootstrap.css'> </link>\");\n");
			myWriter.write("\n");
			myWriter.write("\t\t//load the jdbc driver\n");
			//
			myWriter.write("\t\ttry {\n");
			myWriter.write("\t\t\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
			myWriter.write("\t\t}catch(Exception e) {\n");
			myWriter.write("\t\t\te.printStackTrace();\n");
			myWriter.write("\t\t}\n");
			myWriter.write("\t\tConnection connection = null;\n");
			myWriter.write("\t\tSystem.out.println(\"HOLAAAAAAAAAAAAAAAA\");\n");

			myWriter.write("try {\n");
			myWriter.write("\tClass.forName(\"com.mysql.cj.jdbc.Driver\");\n");
			myWriter.write("\tString dbURL = \"jdbc:mysql://localhost:3306/jdbcdb\";\n");
			myWriter.write("\tString username = \"root\";\n");
			myWriter.write("\tString password = \"root\";\n");
			myWriter.write("\tconnection = DriverManager.getConnection(dbURL,username, password);\n");

			// myWriter.write("\tPreparedStatement ps =
			// connection.prepareStatement(query);\n");
			// myWriter.write("\tResultSet rs = ps.executeQuery();\n");
			myWriter.write("\tpw.println(\"<div style = 'margin:auto;width:800px;margin-top:100px'>\");\n");
			myWriter.write("\tpw.println(\"<div style = 'margin:auto;width:800px;margin-top:100px'>\");\n");
			myWriter.write(
					"\tpw.println(\"<a href = 'index.jsp'><button class = 'btn btn-outline-success'>Home</button></a>\");\n");
			myWriter.write(
					"\tpw.println(\"<a href = 'index.jsp'><button class = 'btn btn-outline-primary'>Filtrar</button></a>\");\n");
			myWriter.write("\tpw.println(\"<a href = 'create" +  nombreDeLaVariable+".jsp'><button class = 'btn btn-outline-primary'>Introducir "
					+ nombreDeLaVariable + "</button></a>\");\n");
			myWriter.write("\tpw.println(\"</div>\");\n");
			myWriter.write("\tpw.println(\"<table class = 'table table-hover table-striped'>\");\n");

			// cabecera edit y delete
			myWriter.write("\tpw.println(\"<tr>\");\n");
			myWriter.write("\tpw.println(\"<th>Edit</th>\");\n");
			myWriter.write("\tpw.println(\"<th>Delete</th>\");\n");
			
			
			//Primero el id del que proviene
			myWriter.write("\t\tpw.println(\"<th>\" + " +"\"Id_" +nombreClaseDeLaQueEsContenedor+ "\" + \"</th>\");\n");

			// cabecera del atributo que se deberia mostrar atributos. Primero el nombre de la variable
			myWriter.write("\t\tpw.println(\"<th>\" + \"" + nombreDeLaVariable +"(" +  tipoVariableListada +")\"" +  "+ \"</th>\");\n");
			
			//myWriter.write("\t\tpw.println(\"<th>\" + clave + \"</th>\");\n");

			myWriter.write("\tpw.println(\"</tr>\");\n"); //cerramos cabecera
			
			
			//Introducir el id recibido por parametro
			myWriter.write("\t List <" + nombreTabla + ">" + nombreTabla.toLowerCase() + "s"
					+ "= variableClaseSQL.searchById_"+nombreClaseDeLaQueEsContenedor+"(connection,id);\n");

			
			// AHORA RELLENAMOS DATOS DE LA TABLA
			myWriter.write("\tfor(" + nombreTabla+ " " + nombreTabla.toLowerCase() + " : "
					+ nombreTabla.toLowerCase() + "s) {\n");
			// edit y delete de la fila
			myWriter.write("\t\tpw.println(\"<tr>\");\n");
			myWriter.write("\t\tpw.println(\"<td><a href='editurl?id=\"+" +nombreTabla.toLowerCase() 
					+ ".getId()+\"'>Edit</a> </td>\");\n");

			myWriter.write("\t\tpw.println(\"<td><a href='deleteurl?id=\"+" +nombreTabla.toLowerCase()
					+ ".getId()+\"'>Delete</a> </td>\");\n");
			/* Voy por aqui pero bueno */
			// Comenzamos a poner los atributos de la fila
			System.out.println("PRINTEANDO ATRIBUTOS PARA EL SHOW de la clase : " + eClass.getName() + "\n");
			
			myWriter.write("\t\tpw.println(\"<td>\" + " + nombreTabla.toLowerCase() + ".getId_"
					+ nombreClaseDeLaQueEsContenedor + "() + \"</td>\");\n");
			
			
			//para pasar a mayuscula la primera letra
			String nombreAtributo = nombreDeLaVariable;
			String nombreAtributoMayus = "";
			String firstLtr = nombreAtributo.substring(0, 1);
			String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());
	
			// ponemos mayuscula la primera letra
			firstLtr = firstLtr.toUpperCase();
	
			 //concatenamos
			nombreAtributoMayus = firstLtr + restLtrs;
			
			myWriter.write("\t\tpw.println(\"<td>\" + " + nombreTabla.toLowerCase() + ".get"
					+ nombreAtributoMayus + "() + \"</td>\");\n");
			System.out.println("FINNNN" + "\n");

			/*
			 * myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getAtributoTrabajadorAbstracto() + \"</td>\");\n"
			 * ); myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getAddress() + \"</td>\");\n");
			 * myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getId_School_students() + \"</td>\");\n"
			 * ); myWriter.
			 * write("\t\tpw.println(\"<td>\" + estudiante.getAtributoTrabajadorConcreto() + \"</td>\");\n"
			 * );
			 */

			myWriter.write("\t\tpw.println(\"</tr>\");\n");
			myWriter.write("\t}\n");

			myWriter.write("\tpw.println(\"</table>\");\n");
			myWriter.write("\t}catch(SQLException se){\n");

			/////////////
			myWriter.write("\t		pw.println(\"<h2>\" +se.getMessage() + \"</h2>\"  );\n");
			myWriter.write("\t		se.printStackTrace();\n");
			myWriter.write("\t	}\n");
			myWriter.write("\tcatch(Exception e){\n");
			myWriter.write("\t	System.out.println(\"GGGGGGGGGGGGGGG\");\n");

			myWriter.write("\t	e.printStackTrace();\n");
			myWriter.write("\t}\n");

			myWriter.write("\tpw.println(\"</div>\");\n");

			myWriter.write("\t//close the stream\n");
			myWriter.write("\tpw.close();\n");
			myWriter.write("\t}\n");

			myWriter.write("\t@Override\n");
			myWriter.write(
					"\tprotected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {\n");
			myWriter.write("\tdoGet(req,res);\n");

			myWriter.write("\t}\n");

			myWriter.write("\t}\n");

			////////////////

			myWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error al imprimir el codigo\n");

		}

		
				
	}

	private LinkedHashMap<String, String> tablasReferencesNoContainmentYCRUD(EClass eClass, String nombreFicheroSQLQuitar,
			String nombreClase, LinkedHashMap<String, String> tablasCreadas, List<EClassifier> elements,String pathSalida) {

		Boolean constructorCreado = false;


		if (!eClass.isAbstract()) {

			// Lo del lower se comprobara con los controladores de jsp. Igual que la
			// composición al crear y eliminar on cascade
			// se se trata de un atributo normal, se pone tal cual el tipo. Esto es para los
			// tipos:
			// boolean,String, Date, double, long, int, float, short
			// si nos de ninguno de esos tipos y es un 1 en lower y 1 en upper se pone un
			// int

			for (EReference eReference : eClass.getEAllReferences()) {
				// String tipo = eReference.getClass().getName();// obtenemos el tipo
				String claseDelAtributo = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo
																						// correspondiente en Java
				String tipo = "int";
				// Comprobacion si el atributo es heredado o no para poner @override
				// String nombreDelAtributo = eReference.getName();
				String nombreDelAtributo = "id_" + claseDelAtributo;

				System.out.println("Referencia de la clase - " + eClass.getName() + " -> " + nombreDelAtributo
						+ " isContainment " + eReference.isContainment()); // correspondiente en Java

				// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
				// metodo, por ejemplo getName
				String nombreAtributo = eReference.getName();


				// GESTIONAMOS CREACION DEL NOMBRE DEL FICHERO
				String nombreTabla = eClass.getName() + "_" + nombreAtributo;
				
				//ficheroSalida
				//String nombreFicheroSQL = "src/sql/";
				String nombreFicheroSQL = pathSalida + File.separator +"sql" + File.separator;
				
				nombreFicheroSQL += nombreTabla + "SQL";
				String nombreClaseSQL = nombreTabla;
				nombreFicheroSQL += ".java"; // SE CREA FICHERO SQL

				// Creamos el metodo para buscar por el atributo; Esto era antes de sacarlo a
				// otra funcion fuera en el main
				// crearReadDB(eClass, nombreFichero, nombreClase,
				// nombreAtributo,nombreAtributoMayus);

				// para los tipos que no son los predeterminados guardaremos un integer que sera
				// el identificador del objeto

				if (!eReference.isContainment()) { // creamos las tablas si no son containment ya que un objet

					if (constructorCreado == false) {
						crearClaseSQL(null, nombreFicheroSQL, nombreClaseSQL);
						try {
							// creamos la funcion y creamos la sentencia sql
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Imports de clase y clase referenciada

							myWriter.write("import javaCode." + eClass.getName() + ";\n");

							if (eClass.getName() != claseDelAtributo) {
								myWriter.write("import javaCode." + claseDelAtributo + ";\n");
							}

							myWriter.write("\npublic class " + nombreTabla + "SQL");
							myWriter.write(" {" + "\n\n");

							myWriter.write("\n\tpublic boolean createTable" + nombreTabla
									+ "(Connection connection) throws SQLException {\n");
							// anyadimos la tabla reference no containment
							tablasCreadas.put(nombreTabla, "noEsPrincipal");// Anyadimos la tabla creada para llevar el
																			// seguimiento
							myWriter.write("\n\t\tString sql = \"create table " + nombreTabla + "(\"\n");
							myWriter.write("\t\t + \"id int NOT NULL AUTO_INCREMENT," + "\"\n");
							myWriter.write("\t\t + \"id_" + eClass.getName() + " int NOT NULL," + "\"\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error al introducir la tabla " + nombreTabla);
							e.printStackTrace();

						}

						constructorCreado = true;
					}

					try {
						FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

						myWriter.write("\t\t + \"id_" + claseDelAtributo + "R " + "" + tipo);

						myWriter.close();

					} catch (IOException e) {
						System.out.println("Error el atributo con upperbound 1");
						e.printStackTrace();
					}

					// Comprobamos si ese atributo debe ser not null
					// SIEMPRE NOT NULL EN ESA TABLA YA QUE ES REFERNCIADA
					try {
						FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

						myWriter.write(" NOT NULL");

						myWriter.close();

					} catch (IOException e) {
						System.out.println("Error el atributo con upperbound 1");
						e.printStackTrace();
					}

					// Cerramos el atributo
					try {
						FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

						myWriter.write("," + "\"\n");

						myWriter.close();

					} catch (IOException e) {
						System.out.println("Error el atributo con upperbound 1");
						e.printStackTrace();
					}

					if (constructorCreado == true) {
						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Introducimos la FK con la clase de la que viene, que se elimina en cascada ya
							// que
							// no tiene sentido si la clase de la que viene no existe para un tipo primitivo
							// FK (clase2_id), REFERENCES clase2(id) ON DELETE CASCADE,
							// myWriter.write("\t\t + \"FK ("+ eClass.getName() + "_id) REFERENCES "+
							// eClass.getName() +"(id) ON DELETE CASCADE,\"" + "\n");
							myWriter.write("\t\t + \"PRIMARY KEY (id)\"" + "\n");
							myWriter.write("\t\t + \");" + "\";" + "//COMENT\n\n");
							myWriter.write("\t\t System.out.println(sql);\n");
							myWriter.write(
									"\t\tPreparedStatement preparedStatement = connection.prepareStatement(sql);\n");
							myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n\n");
							myWriter.write("\t\tif (rows == 0){\n");
							myWriter.write(
									"\t\t\tSystem.out.println(\"tabla de " + eClass.getName() + " creada...\");\n");
							myWriter.write("\t\t}\n");
							myWriter.write("\t\telse{\n");
							myWriter.write("\t\t\tSystem.out.println(\"Error al crear tabla de " + eClass.getName()
									+ "\");\n");
							myWriter.write("\t\t\treturn false;\n");
							myWriter.write("\t\t}\n ");
							myWriter.write("\n\t\treturn true;\n");
							myWriter.close();

						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}

						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							myWriter.write("\n\t}\n"); // Fin de la funcion

							myWriter.close();

						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}

						// AHORA ANYADIMOS LA FUNCION DE CREAR CONSTRAINTS
						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							myWriter.write("\n\tpublic boolean createTable" + nombreTabla
									+ "Constraints(Connection connection) throws SQLException {\n");
							myWriter.write("\n\t\tList<String> constraints = new ArrayList<String>();\n \n");

							myWriter.write("\t\t String sql1 =" + "\"ALTER TABLE " + nombreTabla + "\"\n");
							myWriter.write("\t\t + \"" + " ADD CONSTRAINT " +nombreAtributo +"fk_Id_" + eClass.getName() + "1\"\n");
							myWriter.write("\t\t + \"" + " FOREIGN KEY (id_" + eClass.getName() + ")" + "\"\n");

							myWriter.write("\t\t + \"" + " REFERENCES " + eClass.getName() + "(id)" + "\"\n");
							myWriter.write("\t\t + \"" + " ON DELETE CASCADE" + "\"\n");
							myWriter.write("\t\t + \";" + "\";" + "//COMENT\n\n");

							myWriter.write("\t\t String sql2 =" + "\"ALTER TABLE " + nombreTabla + "\"\n");
							myWriter.write("\t\t + \"" + " ADD CONSTRAINT " +nombreAtributo+"fk_Id_" + eClass.getName() + "2\"\n");
							myWriter.write("\t\t + \"" + " FOREIGN KEY (id_" + claseDelAtributo + "R)" + "\"\n");
							myWriter.write("\t\t + \"" + " REFERENCES " + claseDelAtributo + "(id)" + "\"\n");
							myWriter.write("\t\t + \"" + " ON DELETE CASCADE" + "\"\n");
							myWriter.write("\t\t + \";" + "\";" + "//COMENT\n\n");

							myWriter.write("\t\tconstraints.add(sql1);\n");
							myWriter.write("\t\tconstraints.add(sql2);\n");

							myWriter.write("\n\t\tfor (String constraint : constraints) {\r\n\n");

							myWriter.write(
									"\t\t\t\tPreparedStatement preparedStatement = connection.prepareStatement(constraint);\n");
							myWriter.write("\t\t\t\tpreparedStatement.executeUpdate();\n");

							// myWriter.write("\t\t\t\tint rows = preparedStatement.executeUpdate();\n\n");
							// myWriter.write("\t\t\t\tif (rows == 0){\n");
							// myWriter.write("\t\t\t\t\tSystem.out.println(\"Constraint tabla N-M de " +
							// eClass.getName() +" anyadida...\");\n");
							// myWriter.write("\t\t\t\t}\n");
							// myWriter.write("\t\t\t\telse{\n");
							// myWriter.write("\t\t\t\t\tSystem.out.println(\"Error al anyadir constaint
							// tabla N-M de " + eClass.getName() + "\");\n");
							// myWriter.write("\t\t\t\t\treturn false;\n");
							// myWriter.write("\t\t\t\t}\n ");
							myWriter.write("\n\t\t\t}\n\n");

							myWriter.write("\n\t\treturn true;\n");
							myWriter.write("\n\t}\n\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}
						// myWriter.write("\t\t + \""+ "FK abrebiado (id_" +eClass.getName() + ")" + "
						// REFERENCES "+eClass.getName() +"(id)\"\n");
						// myWriter.write("\t\t + \""+ "FK abreviado (id_"
						// +eClassAMirarRelacionNM.getName() + ")"+ " REFERENCES "
						// +eClassAMirarRelacionNM.getName() +"(id)\"\n");

						// AHora anyadir todas las funciones CRUD

						/*
						 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
						 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
						 * + ");";//COMENT
						 */

						// EMPEZAMOS POR EL INSERT
						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							myWriter.write("\n\tpublic boolean insertRow" + nombreTabla
									+ "(Connection connection, String " + eClass.getName() + "Id"
									+ ", String " + claseDelAtributo + "RId) throws SQLException {\n");

							myWriter.write("\t\t String sql = \"insert into " + nombreTabla + " (id_"
									+ eClass.getName() + ",id_" + claseDelAtributo + "R) values (?,?)\";\n");
							myWriter.write(
									"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n");
							myWriter.write("\t\t preparedStatement.setString(1," + eClass.getName() + "Id);\n");
							myWriter.write("\t\t preparedStatement.setString(2," + claseDelAtributo + "RId);\n");
							myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n");

							myWriter.write("\t\tif (rows >0){\n");

							myWriter.write("\n\t\t\tSystem.out.println(\"Fila insertada correctamente en la "
									+ nombreTabla + "\");\n\n");
							myWriter.write("\t\t}\n");
							myWriter.write("\n\t\treturn true;\n");
							myWriter.write("\t}\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}
						// AHORA POR EL READ
						/*
						 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
						 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
						 * + ");";//COMENT
						 */

						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
							// metodo, por ejemplo getName

							String nombreAtributoMayus = "";
							String firstLtr = nombreAtributo.substring(0, 1);
							String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

							// ponemos mayuscula la primera letra
							firstLtr = firstLtr.toUpperCase();
							// concatenamos
							nombreAtributoMayus = firstLtr + restLtrs;

							myWriter.write("\n\tpublic List<" + nombreTabla + "> readAll" + nombreTabla
									+ "(Connection connection)" + " throws SQLException {\n\n");

							myWriter.write("\t\t List<" + nombreTabla + "> variableRetorno = new ArrayList<"
									+ nombreTabla + ">();\n\n");
							myWriter.write("\t\t String sql = \"select * from " + nombreTabla + "\";\n");
							myWriter.write("\t\t Statement statement = connection.createStatement();\n");
							myWriter.write("\t\t ResultSet result = statement.executeQuery(sql);\n\n");
							myWriter.write("\t\t while(result.next()) {" + "\n");
							myWriter.write("\t\t\t " + nombreTabla + " s = new " + nombreTabla + "();\n\n");

							myWriter.write("\t\t\t Integer id" + " = result.getInt(\"id\");" + "\n");
							myWriter.write("\t\t\t s.setId(id);\n\n");

							myWriter.write("\t\t\t Integer " + "idClase" + " = result.getInt(\"id_" + eClass.getName()
									+ "\");" + "\n");
							myWriter.write("\t\t\t s.setId_" + eClass.getName() + "(idClase);\n\n");

							myWriter.write("\t\t\t " + "Integer " + "idClaseReferencia" + " = result.getInt" + "(\""
									+ "id_" + claseDelAtributo + "R\");" + "\n");
							myWriter.write("\t\t\t s.setId_" + claseDelAtributo + "R(idClaseReferencia);\n\n");

							myWriter.write("\t\t\t variableRetorno.add(s);\n\n");

							myWriter.write("\t\t}\n");

							myWriter.write("\n\t\treturn variableRetorno;\n");
							myWriter.write("\t}\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}
						// AHORA EL SEARCH BY por ID
						/*
						 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
						 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
						 * + ");";//COMENT
						 */

						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
							// metodo, por ejemplo getName

							String nombreAtributoMayus = "";
							String firstLtr = nombreAtributo.substring(0, 1);
							String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

							// ponemos mayuscula la primera letra
							firstLtr = firstLtr.toUpperCase();
							// concatenamos
							nombreAtributoMayus = firstLtr + restLtrs;

							myWriter.write("\n\tpublic List<" + nombreTabla + "> searchById_" + eClass.getName()
									+ "(Connection connection, String pId_" + eClass.getName() + ")"
									+ " throws SQLException {\n\n");

							myWriter.write("\t\t List<" + nombreTabla + "> variableRetorno = new ArrayList<"
									+ nombreTabla + ">();\n\n");
							myWriter.write("\t\t String sql = \"select * " + "from " + nombreTabla + " where id_"
									+ eClass.getName() + "=?" + "\";\n");

							myWriter.write("\t\t Statement statement = connection.createStatement();\n");
							myWriter.write(
									"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n");
							myWriter.write("\t\t preparedStatement.setString(1," + "pId_" + eClass.getName() + ");\n");

							myWriter.write("\t\t ResultSet result = statement.executeQuery(sql);\n\n");
							myWriter.write("\t\t while(result.next()) {" + "\n");
							myWriter.write("\t\t\t " + nombreTabla + " s = new " + nombreTabla + "();\n\n");

							myWriter.write("\t\t\t Integer id" + " = result.getInt(\"id\");" + "\n");
							myWriter.write("\t\t\t s.setId(id);\n\n");

							myWriter.write("\t\t\t Integer " + "idClase" + " = result.getInt(\"id_" + eClass.getName()
									+ "\");" + "\n");
							myWriter.write("\t\t\t s.setId_" + eClass.getName() + "(idClase);\n\n");

							myWriter.write("\t\t\t " + "Integer " + "idClaseReferencia" + " = result.getInt" + "(\""
									+ "id_" + claseDelAtributo + "R\");" + "\n");
							myWriter.write("\t\t\t s.setId_" + claseDelAtributo + "R(idClaseReferencia);\n\n");

							myWriter.write("\t\t\t variableRetorno.add(s);\n\n");

							myWriter.write("\t\t}\n");

							myWriter.write("\n\t\treturn variableRetorno;\n");
							myWriter.write("\t}\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}

						// AHORA EL SEARCH BY para obtener el listado List<claseReferencia> de los
						// referenciados
						/*
						 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
						 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
						 * + ");";//COMENT
						 */

						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
							// metodo, por ejemplo getName

							String nombreAtributoMayus = "";
							String firstLtr = nombreAtributo.substring(0, 1);
							String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

							// ponemos mayuscula la primera letra
							firstLtr = firstLtr.toUpperCase();
							// concatenamos
							nombreAtributoMayus = firstLtr + restLtrs;

							myWriter.write("\n\tpublic List<" + claseDelAtributo + "> searchById_" + eClass.getName()
									+ "GetReferences(Connection connection, String pId_" + eClass.getName() + ")"
									+ " throws SQLException {\n\n");

							myWriter.write("\t\t List<" + nombreTabla + "> variableRetorno = new ArrayList<"
									+ nombreTabla + ">();\n\n");

							myWriter.write("\t\t List<" + "Integer" + "> idsReferenciados = new ArrayList<" + "Integer"
									+ ">();\n\n");

							myWriter.write(
									"\t\t List<" + claseDelAtributo + "> variableRetornoReferenciados = new ArrayList<"
											+ claseDelAtributo + ">();\n\n");
							myWriter.write("\t\t String sql = \"select * " + "from " + nombreTabla + " where id_"
									+ eClass.getName() + "=?" + "\";\n");

							myWriter.write("\t\tPreparedStatement preparedStatement = connection.prepareStatement(sql);\r\n"
									+ ";\n");
							
							myWriter.write("\t\t preparedStatement.setString(1," + "pId_" + eClass.getName() + ");\n");

							myWriter.write("\t\t ResultSet result = preparedStatement.executeQuery();\n\n");
							myWriter.write("\t\t while(result.next()) {" + "\n");
							myWriter.write("\t\t\t " + nombreTabla + " s = new " + nombreTabla + "();\n\n");

							myWriter.write("\t\t\t Integer id" + " = result.getInt(\"id\");" + "\n");
							myWriter.write("\t\t\t s.setId(id);\n\n");

							myWriter.write("\t\t\t Integer " + "idClase" + " = result.getInt(\"id_" + eClass.getName()
									+ "\");" + "\n");
							myWriter.write("\t\t\t s.setId_" + eClass.getName() + "(idClase);\n\n");

							myWriter.write("\t\t\t " + "Integer " + "idClaseReferencia" + " = result.getInt" + "(\""
									+ "id_" + claseDelAtributo + "R\");" + "\n");
							myWriter.write("\t\t\t s.setId_" + claseDelAtributo + "R(idClaseReferencia);\n\n");

							myWriter.write("\t\t\t variableRetorno.add(s);\n\n");

							myWriter.write("\t\t}\n");

							myWriter.write("\t\tfor (" + nombreTabla + " s : variableRetorno) {\n");
							myWriter.write("\t\t\t int id = s.getId_" + claseDelAtributo + "R();\n");
							myWriter.write("\t\t\tidsReferenciados.add(id);\n");
							myWriter.write("\t\t}\n");

							//StudentSQL ref = new StudentSQL();
							myWriter.write(
									"\t\t" + claseDelAtributo + "SQL ref = new " + claseDelAtributo + "SQL();\n");

							myWriter.write(
									"\t\tvariableRetornoReferenciados = ref.searchByMultipleIds(connection,idsReferenciados);\n");

							myWriter.write("\n\t\treturn variableRetornoReferenciados;\n");
							myWriter.write("\t}\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}

						// myWriter.write("\t\t + \"id_" + claseDelAtributo + "R " + ""+tipo);

						// AHORA POR EL UPDATE
						/*
						 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
						 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
						 * + ");";//COMENT
						 */

						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
							// metodo, por ejemplo getName

							String nombreAtributoMayus = "";
							String firstLtr = nombreAtributo.substring(0, 1);
							String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

							// ponemos mayuscula la primera letra
							firstLtr = firstLtr.toUpperCase();
							// concatenamos
							nombreAtributoMayus = firstLtr + restLtrs;

							myWriter.write("\n\tpublic void updateTable" + nombreTabla
									+ "(Connection connection, Integer idP, " + "Integer Id_" + eClass.getName() + "P, "
									+ "Integer Id_" + claseDelAtributo + "RP" + ")" + " throws SQLException {\n\n\n");

							myWriter.write(
									"\t\t String sql = \"Update " + nombreTabla + " set " + "id_" + eClass.getName()
											+ "=?, id_" + claseDelAtributo + "R=? " + " where " + "id=?" + "\";\n");

							myWriter.write(
									"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n\n");
							myWriter.write(
									"\t\t preparedStatement." + "setInt(1," + "Id_" + eClass.getName() + "P);\n");
							myWriter.write(
									"\t\t preparedStatement." + "setInt(2," + "Id_" + claseDelAtributo + "RP);\n");
							myWriter.write("\t\t preparedStatement." + "setInt(3," + "idP" + ");\n\n");

							myWriter.write("\t\tint rows = preparedStatement.executeUpdate();\n");

							myWriter.write("\t\tif (rows >0){\n");

							myWriter.write("\t\t\tSystem.out.println(\"Fila actualizada correctamente en la tabla "
									+ nombreTabla + "\");\n");
							myWriter.write("\t\t}\n");
							//

							// myWriter.write("\t\t}\n");

							myWriter.write("\t}\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}

						// AHORA POR EL DELETE
						/*
						 * String sql = "create table School_nEstudiantes(" + "id int  NOT NULL," +
						 * "School_id int NOT NULL," + "nEstudiantes INT NOT NULL," + "PRIMARY KEY (id)"
						 * + ");";//COMENT
						 */

						try {
							FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);

							// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
							// metodo, por ejemplo getName

							String nombreAtributoMayus = "";
							String firstLtr = nombreAtributo.substring(0, 1);
							String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

							// ponemos mayuscula la primera letra
							firstLtr = firstLtr.toUpperCase();
							// concatenamos
							nombreAtributoMayus = firstLtr + restLtrs;

							myWriter.write(
									"\n\tpublic void deleteById" + "(Connection connection, Integer valorAtributo)"
											+ " throws SQLException {\n\n\n");

							myWriter.write(
									"\t\t String sql = \"delete * from  " + nombreTabla + " where " + "id=?" + "\";\n");

							myWriter.write(
									"\t\t PreparedStatement preparedStatement = connection.prepareStatement(sql);\n\n");
							myWriter.write("\t\t preparedStatement." + "setInt(1," + "valorAtributo)" + ";\n");

							myWriter.write("\t\t int rows = preparedStatement.executeUpdate();\n");

							myWriter.write("\t\t if (rows >0){\n");

							myWriter.write("\t\t\t System.out.println(\"Fila eliminada correctamente en la tabla"
									+ nombreTabla + "\");\n");
							myWriter.write("\t\t }\n");

							myWriter.write("\t }\n");

							myWriter.close();
						} catch (IOException e) {
							System.out.println("Error el atributo con upperbound 1");
							e.printStackTrace();
						}
					}

					cerrarClaseSQL(eClass, nombreFicheroSQL, nombreClaseSQL);

					constructorCreado = false;

					// Aqui tenemos que comenzar a crear todo lo de la clase JAVA
					System.out.println("DEBUG CLASES NO CONTAINMNENT\n");
					System.out.println("Se va a realizar la clase Java:" + nombreTabla + "\n");

					crearClaseJavaEreferenceNoContainment(eClass, nombreTabla, claseDelAtributo,pathSalida);
					
					crearShowTablaEreferenceNoContainment(eClass, elements, nombreTabla,claseDelAtributo,pathSalida);


				} else {
					// System.out.println("El atributo " +nombreAtributo + " algun atributo con
					// upper bound = a 1");
				}
			} // FIN DE RECORRER EReferences que no son tabla a parte

		} // Fin si no es abstracta

		return tablasCreadas;

	}

	private void crearClaseJavaArrayAtributoPrimitvo(EClass claseDeLaQueProviene, String nombreTabla,
			String tipoVariableEnLista, String pathSalida) {

		// Hacer creacion de fichero .java
		// Hacer bucle imports

		//ficheroSalida
		//String nombreFichero = "src/javaCode/";
		String nombreFichero = pathSalida + File.separator +"javaCode" + File.separator;
		
		nombreFichero += nombreTabla;
		nombreFichero += ".java";

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("package javaCode;\n");

			// myWriter.write("import java.util.*;\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// System.out.print("ENTRAAAAAAAAAAAAAAa");

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\npublic class " + nombreTabla);
			myWriter.write(" {" + "\n\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Cogemos la clase de la que es referencia
		String[] partes = nombreTabla.split("_");
		String nombreClaseDeLaQueEsContenedor = partes[0];
		String nombreDeLaVariable = partes[1];
		String tipoVariableListada = tipoVariableEnLista;
		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\t" + "private Integer id;\n");
			myWriter.write("\t" + "private Integer id_" + nombreClaseDeLaQueEsContenedor + ";\n");
			myWriter.write("\t" + "private " + tipoVariableListada + " " + nombreDeLaVariable + ";\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Getter fijo del ID
		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public Integer" + " " + "getId(){\n");
			myWriter.write("\t\t" + " return id" + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Setter fijo del ID

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public void" + " " + "setId(Integer pId){\n");
			myWriter.write("\t\t" + " this.id = pId" + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String nombreAtributo = nombreDeLaVariable;

		// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
		// metodo, por ejemplo getName
		String nombreAtributoMayus = "";
		String firstLtr = nombreAtributo.substring(0, 1);
		String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

		// ponemos mayuscula la primera letra
		firstLtr = firstLtr.toUpperCase();
		// concatenamos
		nombreAtributoMayus = firstLtr + restLtrs;

		/**/
		/////////////////////

		// Getter fijo del atributo de la clase referencia
		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public Integer" + " " + "getId_" + nombreClaseDeLaQueEsContenedor + "(){\n");
			myWriter.write("\t\t" + " return id_" + nombreClaseDeLaQueEsContenedor + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Setter fijo del atributo de la clase referencia

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public void" + " " + "setId_" + nombreClaseDeLaQueEsContenedor + "(Integer pId_"
					+ nombreClaseDeLaQueEsContenedor + "){\n");
			myWriter.write("\t\t" + " this.id_" + nombreClaseDeLaQueEsContenedor + "  = pId_"
					+ nombreClaseDeLaQueEsContenedor + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		/////////////
		// Getter fijo del atributo de la clase referencia
		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public " + tipoVariableListada + " " + "get" + nombreAtributoMayus + "(){\n");
			myWriter.write("\t\t" + " return " + nombreDeLaVariable + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Setter fijo del atributo de la clase referencia

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public void" + " " + "set" + nombreAtributoMayus + "(" + tipoVariableListada + " p"
					+ nombreAtributoMayus + "){\n");
			myWriter.write("\t\t" + " this." + nombreDeLaVariable + "  = p" + nombreAtributoMayus + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("}");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	private void crearClaseJavaEreferenceNoContainment(EClass claseDeLaQueProviene, String nombreTabla,
			String claseDeLaReferencia, String pathSalida) {

		// Hacer creacion de fichero .java
		// Hacer bucle imports
		// Cogemos la clase de la que es referencia

		String[] partes = nombreTabla.split("_");
		String nombreClaseDeLaQueEsContenedor = partes[0];
		String nombreVariable = partes[1];
		String nombreDeLaVariable = claseDeLaReferencia + "_" + nombreVariable;

		//ficheroSalida
		//String nombreFichero = "src/javaCode/";
		String nombreFichero = pathSalida + File.separator +"javaCode" + File.separator;

		
		nombreFichero += nombreTabla;
		nombreFichero += ".java";

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("package javaCode;\n");

			// myWriter.write("import java.util.*;\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// System.out.print("ENTRAAAAAAAAAAAAAAa");

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\npublic class " + nombreTabla);
			myWriter.write(" {" + "\n\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\t" + "private Integer id;\n");
			myWriter.write("\t" + "private Integer id_" + nombreClaseDeLaQueEsContenedor + ";\n");
			myWriter.write("\t" + "private Integer id_" + claseDeLaReferencia + "R;\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Getter fijo del ID
		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public Integer" + " " + "getId(){\n");
			myWriter.write("\t\t" + " return id" + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Setter fijo del ID

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public void" + " " + "setId(Integer pId){\n");
			myWriter.write("\t\t" + " this.id = pId" + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String nombreAtributo = nombreDeLaVariable;

		// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
		// metodo, por ejemplo getName
		String nombreAtributoMayus = "";
		String firstLtr = nombreAtributo.substring(0, 1);
		String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

		// ponemos mayuscula la primera letra
		firstLtr = firstLtr.toUpperCase();
		// concatenamos
		nombreAtributoMayus = firstLtr + restLtrs;

		/**/
		/////////////////////

		// Getter fijo del atributo de la clase referencia
		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public Integer" + " " + "getId_" + nombreClaseDeLaQueEsContenedor + "(){\n");
			myWriter.write("\t\t" + " return id_" + nombreClaseDeLaQueEsContenedor + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Setter fijo del atributo de la clase referencia

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public void" + " " + "setId_" + nombreClaseDeLaQueEsContenedor + "(Integer pId_"
					+ nombreClaseDeLaQueEsContenedor + "){\n");
			myWriter.write("\t\t" + " this.id_" + nombreClaseDeLaQueEsContenedor + "  = pId_"
					+ nombreClaseDeLaQueEsContenedor + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		nombreAtributo = nombreDeLaVariable;

		// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
		// metodo, por ejemplo getName
		nombreAtributoMayus = "";
		firstLtr = nombreAtributo.substring(0, 1);
		restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

		// ponemos mayuscula la primera letra
		firstLtr = firstLtr.toUpperCase();
		// concatenamos
		nombreAtributoMayus = firstLtr + restLtrs;

		/**/
		/////////////////////

		// Getter fijo del atributo de la clase referencia
		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public Integer" + " " + "getId_" + claseDeLaReferencia + "R(){\n");
			myWriter.write("\t\t" + " return id_" + claseDeLaReferencia + "R;");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Setter fijo del atributo de la clase referencia

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public void" + " " + "setId_" + claseDeLaReferencia + "R(Integer pId_"
					+ claseDeLaReferencia + "R){\n");
			myWriter.write("\t\t" + " this.id_" + claseDeLaReferencia + "R  = pId_" + claseDeLaReferencia + "R;");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} /////////////

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("}");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	private void crearClaseJavaNM(String nombreTabla) {

		// Hacer creacion de fichero .java
		// Hacer bucle imports

		String nombreFichero = "src/javaCode/";

		nombreFichero += nombreTabla;
		nombreFichero += ".java";

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("package javaCode;\n");

			// myWriter.write("import java.util.*;\n");

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// System.out.print("ENTRAAAAAAAAAAAAAAa");

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			myWriter.write("\npublic class " + nombreTabla);
			myWriter.write(" {" + "\n\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Cogemos la clase de la que es referencia
		String[] partes = nombreTabla.split("_");
		// String nombreClaseDeLaQueEsContenedor = partes[0];
		String clase2 = partes[0];

		// String nombreDeLaVariable = partes[1];
		String clase1 = partes[1];

		// String tipoVariableListada = tipoVariableEnLista;

		// + "id int NOT NULL,"
		// + "id_RevoltosoN int NOT NULL,"
		// + "id_RevoltosoM int NOT NULL,"

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			if (clase1 != clase2) {

				myWriter.write("\t" + "private Integer id;\n");
				myWriter.write("\t" + "private Integer id_" + clase1 + "A;\n");

				myWriter.write("\t" + "private Integer id_" + clase2 + "B;\n");
			} else {

				myWriter.write("\t" + "private Integer id;\n");
				myWriter.write("\t" + "private Integer id_" + clase1 + "A;\n");
				myWriter.write("\t" + "private Integer id_" + clase2 + "B;\n");

			}

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Getter fijo del ID
		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public Integer" + " " + "getId(){\n");
			myWriter.write("\t\t" + " return id" + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Setter fijo del ID

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("\t" + "public void" + " " + "setId(Integer pId){\n");
			myWriter.write("\t\t" + " this.id = pId" + ";");
			myWriter.write("\n\t" + "}\n");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String nombreAtributo = "id_" + clase1;

		// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
		// metodo, por ejemplo getName
		String nombreAtributoMayus = "";
		String firstLtr = nombreAtributo.substring(0, 1);
		String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

		// ponemos mayuscula la primera letra
		firstLtr = firstLtr.toUpperCase();
		// concatenamos
		nombreAtributoMayus = firstLtr + restLtrs;

		/**/
		/////////////////////

		// Getter fijo del atributo de la clase referencia
		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);
			if (clase1 != clase2) {

				myWriter.write("\n");
				myWriter.write("\t" + "public Integer " + " " + "getId_" + clase1 + "A(){\n");
				myWriter.write("\t\t" + " return id_" + clase1 + "A;");
				myWriter.write("\n\t" + "}\n");

			} else {

				myWriter.write("\n");
				myWriter.write("\t" + "public Integer " + " " + "getId_" + clase1 + "A(){\n");
				myWriter.write("\t\t" + " return id_" + clase1 + "A;");
				myWriter.write("\n\t" + "}\n");

			}
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Setter fijo del atributo de la clase referencia

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			if (clase1 != clase2) {

				myWriter.write("\n");
				myWriter.write("\t" + "public void" + " " + "setId_" + clase1 + "A(Integer pId_" + clase1 + "A){\n");
				myWriter.write("\t\t" + " this.id_" + clase1 + "A  = pId_" + clase1 + "A;");
				myWriter.write("\n\t" + "}\n");

			} else {

				myWriter.write("\n");
				myWriter.write("\t" + "public void" + " " + "setId_" + clase1 + "A(Integer pId_" + clase1 + "A){\n");
				myWriter.write("\t\t" + " this.id_" + clase1 + "A  = pId_" + clase1 + "A;");
				myWriter.write("\n\t" + "}\n");

			}

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		/////////////
		// Getter fijo del atributo de la clase referencia
		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			if (clase1 != clase2) {

				myWriter.write("\n");
				myWriter.write("\t" + "public Integer " + "get" + "Id_" + clase2 + "B(){\n");
				myWriter.write("\t\t" + " return " + "id_" + clase2 + "B;");
				myWriter.write("\n\t" + "}\n");

			} else {

				myWriter.write("\n");
				myWriter.write("\t" + "public Integer " + "get" + "Id_" + clase2 + "B(){\n");
				myWriter.write("\t\t" + " return " + "id_" + clase2 + "B;");
				myWriter.write("\n\t" + "}\n");

			}
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Setter fijo del atributo de la clase referencia

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			if (clase1 != clase2) {

				myWriter.write("\n");
				myWriter.write("\t" + "public void" + " " + "set" + "Id_" + clase2 + "B(" + "Integer " + " p" + "Id_"
						+ clase2 + "B){\n");
				myWriter.write("\t\t" + " this." + "id_" + clase2 + "B  = p" + "Id_" + clase2 + "B;");
				myWriter.write("\n\t" + "}\n");

			} else {
				myWriter.write("\n");
				myWriter.write("\t" + "public void" + " " + "set" + "Id_" + clase2 + "B(" + "Integer " + " p" + "Id_"
						+ clase2 + "B){\n");
				myWriter.write("\t\t" + " this." + "id_" + clase2 + "B  = p" + "Id_" + clase2 + "B;");
				myWriter.write("\n\t" + "}\n");

			}

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try {
			FileWriter myWriter = new FileWriter(nombreFichero, true);

			myWriter.write("\n");
			myWriter.write("}");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	private void cerrarClaseSQL(EClass eClass, String nombreFicheroSQL, String nombreClase) {

		try {
			FileWriter myWriter = new FileWriter(nombreFicheroSQL, true);
			myWriter.write("}");
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void crearMetodosListas(EClass eClass, String nombreFichero) {

		// GEtters para atributos
		// Recorremos los atributos
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			// Si es lista le creamos el metodo
			if (eAttribute.getUpperBound() == -1 || eAttribute.getUpperBound() >= 2) {

				String tipoE = tipoWrapper(eAttribute.getEType().getInstanceClass().getSimpleName());// obtenemos el
				// en Java

				// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
				// metodo, por ejemplo getName
				String nombreAtributo = eAttribute.getName();
				String nombreAtributoMayus = "";
				String firstLtr = nombreAtributo.substring(0, 1);
				String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

				// ponemos mayuscula la primera letra
				firstLtr = firstLtr.toUpperCase();

				// concatenamos
				nombreAtributoMayus = firstLtr + restLtrs;

				// System.out.println("\t" + "public " + "add" + nombreAtributoMayus + " (" +
				// tipoE + " p" + nombreAtributoMayus + ") {\n");

				try {
					FileWriter myWriter = new FileWriter(nombreFichero, true);
					myWriter.write("\t" + "public " + "void " + "add" + nombreAtributoMayus + " (" + tipoE + " p"
							+ nombreAtributoMayus + ") {\n");
					
					if (eAttribute.getUpperBound() != -1) {
						myWriter.write("\t\t" + "if(" + nombreAtributo+".size()<" +eAttribute.getUpperBound()+ ")\n");
	
						myWriter.write("\t\t\t" + "this." + nombreAtributo + ".add(" + "p" + nombreAtributoMayus + ");");
					
					}
					else {
						myWriter.write("\t\t//no tiene upperbound\n");

						myWriter.write("\t\t" + "this." + nombreAtributo + ".add(" + "p" + nombreAtributoMayus + ");");

						
					}
					myWriter.write("\n\t" + "}" + "\n");
					myWriter.write("\t" + "public " + "void " + "delete" + nombreAtributoMayus + " (" + tipoE + " p"
							+ nombreAtributoMayus + ") {\n");
					myWriter.write("\t\t" + "if(" + nombreAtributo+".size()>" +eAttribute.getLowerBound()+ ")\n");

					myWriter.write("\t\t\t" + "this." + nombreAtributo + ".remove(" + "p" + nombreAtributoMayus + ");");
					myWriter.write("\n\t" + "}" + "\n");
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}
		}
		for (EReference eReference : eClass.getEAllReferences()) {
			String tipoE = tipoWrapper(eReference.getEType().getName());// obtenemos el tipo correspondiente en Java
			if (eReference.getUpperBound() == -1 || eReference.getUpperBound() >= 2) {

				// Ponemos en mayuscula el nombre del atibuto para ponerlo en el nombre del
				// metodo, por ejemplo getName
				String nombreAtributo = eReference.getName();
				String nombreAtributoMayus = "";
				String firstLtr = nombreAtributo.substring(0, 1);
				String restLtrs = nombreAtributo.substring(1, nombreAtributo.length());

				// ponemos mayuscula la primera letra
				firstLtr = firstLtr.toUpperCase();

				// concatenamos
				nombreAtributoMayus = firstLtr + restLtrs;

				escribirEnFichero("\t" + "public " + "void " + "add" + nombreAtributoMayus + " (" + tipoE + " p"
						+ nombreAtributoMayus + ") {\n", nombreFichero);

				if (eReference.getUpperBound() != -1) {
					escribirEnFichero("\t\t" + "if(" + nombreAtributo + ".size()<" + eReference.getUpperBound() + ")\n",
							nombreFichero);
					escribirEnFichero("\t\t\t" + "this." + nombreAtributo + ".add(" + "p" + nombreAtributoMayus + ");",
							nombreFichero);
				} else {
					escribirEnFichero("\t\t//no tiene upperbound\n", nombreFichero);
					escribirEnFichero("\t\t" + "this." + nombreAtributo + ".add(" + "p" + nombreAtributoMayus + ");",
							nombreFichero);
				}

				escribirEnFichero("\n\t" + "}" + "\n", nombreFichero);

				escribirEnFichero("\t" + "public " + "void " + "delete" + nombreAtributoMayus + " (" + tipoE + " p"
						+ nombreAtributoMayus + ") {\n", nombreFichero);

				escribirEnFichero("\t\t" + "if(" + nombreAtributo + ".size()>" + eReference.getLowerBound() + ")\n",
						nombreFichero);

				escribirEnFichero("\t\t\t" + "this." + nombreAtributo + ".remove(" + "p" + nombreAtributoMayus + ");",
						nombreFichero);

				escribirEnFichero("\n\t" + "}" + "\n", nombreFichero);
			}
		}
	}

	public static File funcionPrincipal(String path,Resource resource) {

		//salidaFichero
		File src = new File(path);
		if (!src.exists()) {
			src.mkdirs();
		}
		
		String rutaFicheroEcore  = resource.getURI().toString();

		// LIMPIEZA DE DATOS ANTERIORES
		//salidaFichero - creo que dos lineas de abajo no estaban
		File dir = new File(path + File.separator+"javaCode");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		System.out.println("ELIMINANDO EN: "+path + File.separator+"javaCode" );
		File[] files = dir.listFiles((dir1, name) -> name.endsWith(".java"));
		if (files != null) {
			for (File file : files) {
				if (!file.delete()) {
					System.out.println("No se pudo eliminar el archivo " + file.getName());
				} else {
					System.out.println("Archivo " + file.getName() + " "
							+ "eliminado correctamente");

				}
			}
		}
		
		
		System.out.println("La ruta es la siguiente: " + rutaFicheroEcore);
		
		//String[] partes = rutaFicheroEcore.split(File.separator.toString());
		String[] partes = rutaFicheroEcore.split(Pattern.quote(File.separator));

		
		String nombreArchivo = partes[partes.length - 1];
		
		System.out.println("EL NOMBRE DEL ARCHIVO ES EL SIGUIENTE: " + nombreArchivo);
		
		String[] partesNombreArchivo = nombreArchivo.split(Pattern.quote("."));
		String nombreModelo = partesNombreArchivo[0];
		
		System.out.println("EL nombre del modelo ES EL SIGUIENTE: " + nombreModelo);

		//FUNCIONES DE GEN CODIGO
		GeneracionDevolviendoFicheroAdaptadoSara s = new GeneracionDevolviendoFicheroAdaptadoSara();
		s.hacerTodo(rutaFicheroEcore, nombreModelo, path);
		s.crearInterfaces(rutaFicheroEcore, path);

		//./src/javaCode/InicializarDDBB.java
		String filePath =  path + File.separator+"javaCode" + File.separator+"InicializarDDBB.java";
		
        ClassLoader classLoader = GeneracionDevolviendoFicheroAdaptadoSara.class.getClassLoader();
        //salidaFichero - las dos lineas de abajo no estaban
        File baseDir = new File(classLoader.getResource("").getFile());
		if (!baseDir.exists()) {
			baseDir.mkdirs();
		}
		//salidaFichero - las dos lineas de abajo no estaban
        File srcDir = new File(path);
		if (!srcDir.exists()) {
			srcDir.mkdirs();
		}

        
		System.out.println("BASE DE DATOS INICIALIZADA CORRECTAMENTEEE \n");
		return srcDir;
	}

	public static void main(String[] args) {

		//String rutaFicheroEcore = "./models/schoolHerenciaMultiple.ecore";
		//String rutaFicheroEcore = "." + File.separator + "models" + File.separator + "Store.ecore";
		String rutaFicheroEcore = "." + File.separator + "models" + File.separator + "Store.ecore";
		//String rutaFicheroEcore = "./models/HerenciaMultiple.ecore";
		// Modificar el tema del path
		// 2 - Modificar que se le pase un ecore en lugar de una ruta
		//String dondeQuieroCrearSalida = "salida23" + File.separator + "salida24";
		//Fichero en C:/papanatas/src
		String dondeQuieroCrearSalida = "C:" + File.separator +"papanatas" +File.separator +"src";
		//String dondeQuieroCrearSalida ="src";
		 File baseDir = new File(dondeQuieroCrearSalida);
		 System.out.println("Fichero donde quiero crear salida - " + dondeQuieroCrearSalida );
		if (!baseDir.exists()) {
			baseDir.mkdirs();
		}

		
		ResourceSet set = new ResourceSetImpl();

		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());

		// Using the ResourceSet, we open a resource in a concrete path (the file must
		// be exist previously).
		Resource resource = set.getResource(URI.createURI(rutaFicheroEcore), true);

		// Then we get the first element of the content in the resource, which is an
		// EPackage and the root element
		EPackage storePackage = (EPackage) resource.getContents().get(0);
		
		//Pasar fichero ecore en lugar del nombre de la ruta.
		File carpeta = null;
		// abrirlo en el main
		try {
			carpeta = funcionPrincipal(dondeQuieroCrearSalida,resource);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("NOMBRE CARPETA DEVUELTA:" + carpeta.getAbsolutePath());



	}

}
