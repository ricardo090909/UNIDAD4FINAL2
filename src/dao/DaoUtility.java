package dao;


import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

import java.util.stream.Collectors;

import modelo.Book;

import modelo.Prestamo;
import modelo.Directivos;
import modelo.Student;
import modelo.Teacher;




public class DaoUtility {
	
	private static final String ALUMNOS_FILE = "recursos/alumnos.txt";
    private static final String DOCENTES_FILE = "recursos/docentes.txt";
    private static final String DIRECTIVOS_FILE = "recursos/directivos.txt";
    private static final String PRESTAMOS_FILE = "recursos/prestamos.txt";
    private static final String LIBROS_FILE = "recursos/libros.txt";
	// Método para leer los datos de un archivo de texto y devolverlos como una lista de cadenas
	/*
	 * private static List<String> getInputData(String ruta) throws
	 * FileNotFoundException{ File file = new File(ruta); Scanner flujoEntrada = new
	 * Scanner(file);
	 * 
	 * List<String> listaCadenas = new ArrayList<>(); while (flujoEntrada.hasNext())
	 * { String cadenaLibro = flujoEntrada.nextLine();
	 * listaCadenas.add(cadenaLibro); } flujoEntrada.close(); return listaCadenas; }
	 */
    
    
	//este metodo carga todo al archivo 
	//flewrite es el que se encarga de escribir las cosas en el archivo
	  private static void cargarDatos(String filePath, String data) {
	        try (FileWriter writer = new FileWriter(filePath, true)) {
	            writer.write(data + "\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  
	    public static void guardarAlumno(Student alumno) {
	        String data = alumno.toString(); 
	        cargarDatos(ALUMNOS_FILE, data);
	    }

	    public static void guardarDocente(Teacher docente) {
	        String data = docente.toString(); 
	        cargarDatos(DOCENTES_FILE, data);
	    }

	    public static void guardarDirectivo(Directivos directivo) {
	        String data = directivo.toString(); 
	        cargarDatos(DIRECTIVOS_FILE, data);
	    }

	    public static void guardarPrestamo(Prestamo prestamo) {
	        String data = prestamo.toString(); 
	        cargarDatos(PRESTAMOS_FILE, data);
	    }
	    public static void guardarBook(Book book) {
	        String data = book.toString(); 
	        cargarDatos(LIBROS_FILE, data);
	    }
	    
	   
	
	// Método para obtener los libros del archivo de texto y convertirlos en objetos de la clase Book			
	/*
	 * public static Book[] getInputBooks(String ruta) { try { List<String>
	 * ListaLibros = getInputData(ruta); Book[] libros = new
	 * Book[ListaLibros.size()]; for (int i = 0; i < ListaLibros.size(); i++) { Book
	 * libro = doLibro(ListaLibros.get(i)); libros[i] = libro; } return libros; }
	 * catch (FileNotFoundException e) {
	 * System.out.println("El archivo no fue encontrado"); return null; } }
	 */
	
	 // Método para procesar una cadena y convertirla en un objeto de la clase Book
		/*
		 * private static Book doLibro(String cadena) { String[] atributosLibro =
		 * cadena.split("\t"); Book libro = new Book();
		 * libro.setIsbn(atributosLibro[0]); libro.setTitulo(atributosLibro[1]);
		 * libro.setAutor(atributosLibro[2]); libro.setEditorial(atributosLibro[3]);
		 * libro.setEdicion(atributosLibro[4]); libro.setIdioma(atributosLibro[5]);
		 * libro.setVolumen(Integer.parseInt(atributosLibro[6])); return libro; }
		 */
	
					
	/*
	 * public static Student[] getInputStudents(String ruta) { try { List<String>
	 * listaAlumnos = getInputData(ruta); Student[] alumnos = new
	 * Student[listaAlumnos.size()]; for (int i = 0; i < listaAlumnos.size(); i++) {
	 * Student alumno = doAlumno(listaAlumnos.get(i)); alumnos[i] = alumno; } return
	 * alumnos; } catch (FileNotFoundException e) {
	 * System.out.println("El archivo no fue encontrado"); return null; } }
	 */
	/*
	 * private static Student doAlumno(String cadena) { String[] atributosAlumno =
	 * cadena.split("\t"); Student alumno = new Student();
	 * alumno.setNumeroControl(atributosAlumno[0]);
	 * alumno.setNombre(atributosAlumno[1]); alumno.setPaterno(atributosAlumno[2]);
	 * alumno.setMaterno(atributosAlumno[3]);
	 * alumno.setGenero(doGenero(atributosAlumno[4]));
	 * alumno.setFechaNacimiento(doFechaNacimiento(atributosAlumno[5],
	 * atributosAlumno[6],atributosAlumno[7]));
	 * alumno.setDomicilio(doDomicilio(atributosAlumno[8],atributosAlumno[9],
	 * atributosAlumno[10],atributosAlumno[11],atributosAlumno[12],atributosAlumno[
	 * 13],atributosAlumno[14])); alumno.setEmail(atributosAlumno[15]);
	 * alumno.setTelefono(atributosAlumno[16]);
	 * alumno.setCarrera(atributosAlumno[17]);
	 * alumno.setSemestre(atributosAlumno[18]);
	 * alumno.setGrupo(atributosAlumno[19]); return alumno; }
	 */
	
					
	/*
	 * public static Teacher[] getInputTeachers(String ruta) { try { List<String>
	 * listaDocentes = getInputData(ruta); Teacher[] docentes = new
	 * Teacher[listaDocentes.size()]; for (int i = 0; i < listaDocentes.size(); i++)
	 * { Teacher docente = doDocente(listaDocentes.get(i)); docentes[i] = docente; }
	 * return docentes; } catch (FileNotFoundException e) {
	 * System.out.println("El archivo no fue encontrado"); return null; } }
	 */
	/*
	 * private static Teacher doDocente(String cadena) { String[] atributosTeacher =
	 * cadena.split("\t"); Teacher teacher = new Teacher();
	 * teacher.setCurp(atributosTeacher[0]); teacher.setNombre(atributosTeacher[1]);
	 * teacher.setPaterno(atributosTeacher[2]);
	 * teacher.setMaterno(atributosTeacher[3]);
	 * teacher.setGenero(doGenero(atributosTeacher[4]));
	 * teacher.setFechaNacimiento(doFechaNacimiento(atributosTeacher[5],
	 * atributosTeacher[6], atributosTeacher[7]));//Year, month, day
	 * teacher.setDomicilio(doDomicilio(atributosTeacher[8], atributosTeacher[9],
	 * atributosTeacher[10], atributosTeacher[11], atributosTeacher[12],
	 * atributosTeacher[13], atributosTeacher[14]));//calle, num.Casa, orientacion,
	 * colonia, municipio, estado, codigo postal
	 * teacher.setRfc(atributosTeacher[15]);
	 * teacher.setPuesto(doPuesto(atributosTeacher[16]));
	 * teacher.setHorario(atributosTeacher[17]);
	 * teacher.setSueldo(Double.parseDouble(atributosTeacher[18]));
	 * teacher.setTitulo(atributosTeacher[19]);
	 * teacher.setAcademia(atributosTeacher[20]);
	 * teacher.setJefeInmediato(atributosTeacher[21]); return teacher; }
	 */
						
	/*
	 * public static Directivos[] getInputManagers(String ruta) { try { List<String>
	 * listaDirectivos = getInputData(ruta); Directivos[] directivos = new
	 * Directivos[listaDirectivos.size()]; for (int i = 0; i <
	 * listaDirectivos.size(); i++) { Directivos directivo =
	 * doManager(listaDirectivos.get(i)); directivos[i] = directivo; } return
	 * directivos; } catch (FileNotFoundException e) {
	 * System.out.println("El archivo no fue encontrado"); return null; } }
	 */
	/*
	 * private static Directivos doManager(String cadena) { String[]
	 * atributosManager = cadena.split("\t"); Directivos manager = new Directivos();
	 * manager.setCurp(atributosManager[0]); manager.setNombre(atributosManager[1]);
	 * manager.setPaterno(atributosManager[2]);
	 * manager.setMaterno(atributosManager[3]);
	 * manager.setGenero(doGenero(atributosManager[4]));
	 * manager.setFechaNacimiento(doFechaNacimiento(atributosManager[5],
	 * atributosManager[6], atributosManager[7]));//Year, month, day
	 * manager.setDomicilio(doDomicilio(atributosManager[8], atributosManager[9],
	 * atributosManager[10], atributosManager[11], atributosManager[12],
	 * atributosManager[13], atributosManager[14]));//calle, num.Casa, orientacion,
	 * colonia, municipio, estado, codigo postal
	 * manager.setRfc(atributosManager[15]);
	 * manager.setPuesto(doPuesto(atributosManager[16]));
	 * manager.setHorario(atributosManager[17]);
	 * manager.setSueldo(Double.parseDouble(atributosManager[18]));
	 * manager.setGradoEstudios(atributosManager[19]);
	 * manager.setTipoDirectivo(doTipoDirectivo(atributosManager[20]));
	 * manager.setCompensacion(Double.parseDouble(atributosManager[21])); return
	 * manager; }
	 */


	
					
	/*
	 * private static Genero doGenero(String genero) { return
	 * (genero.equalsIgnoreCase("MASCULINO") ? Genero.MASCULINO : Genero.FEMENINO);
	 * }
	 */
	/*
	 * private static LocalDate doFechaNacimiento(String year, String month, String
	 * day) { LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(year),
	 * Integer.parseInt(month), Integer.parseInt(day)); return fechaNacimiento; }
	 */
	/*
	 * private static Domicilio doDomicilio(String calle,String numeroCasa,String
	 * orientacion,String colonia,String ciudad,String estado,String codigoPostal) {
	 * Domicilio domicilio = new Domicilio(); domicilio.setCalle(calle);
	 * domicilio.setNumeroCasa(Integer.parseInt(numeroCasa));
	 * domicilio.setOrientacion(doOrientacion(orientacion));
	 * domicilio.setColonia(colonia); domicilio.setCiudad(ciudad);
	 * domicilio.setEstado(estado); domicilio.setCodigoPostal(codigoPostal); return
	 * domicilio; }
	 */
	/*
	 * private static Orientacion doOrientacion(String orientacion) { if
	 * (orientacion.equalsIgnoreCase("SUR")) return Orientacion.SUR; else if
	 * (orientacion.equalsIgnoreCase("PONIENTE")) return Orientacion.PONIENTE; else
	 * if (orientacion.equalsIgnoreCase("ORIENTE")) return Orientacion.ORIENTE; else
	 * return Orientacion.NORTE; } private static PuestoTrabajo doPuesto(String
	 * puesto) { if (puesto.equalsIgnoreCase("DIRECTOR")) return
	 * PuestoTrabajo.DIRECTOR; else if (puesto.equalsIgnoreCase("SUBDIRECTOR"))
	 * return PuestoTrabajo.SUBDIRECTOR; else if
	 * (puesto.equalsIgnoreCase("JEFE_DEPARTAMENTO")) return
	 * PuestoTrabajo.JEFE_DEPARTAMENTO; else if
	 * (puesto.equalsIgnoreCase("COORDINADOR")) return PuestoTrabajo.COORDINADOR;
	 * else if (puesto.equalsIgnoreCase("DOCENTE")) return PuestoTrabajo.DOCENTE;
	 * else if (puesto.equalsIgnoreCase("AUXILIAR_ADMINISTRATIVO")) return
	 * PuestoTrabajo.AUXILIAR_ADMINISTRATIVO; else if
	 * (puesto.equalsIgnoreCase("PREFECTO")) return PuestoTrabajo.PREFECTO; else if
	 * (puesto.equalsIgnoreCase("BIBLIOTECARIO")) return
	 * PuestoTrabajo.BIBLIOTECARIO; else return PuestoTrabajo.ORIENTADOR; }
	 * 
	 * private static TipoDirectivo doTipoDirectivo(String tipoDirectivo) { if
	 * (tipoDirectivo.equalsIgnoreCase("SUBDIRECTOR_ACADEMICO")) return
	 * TipoDirectivo.SUBDIRECTOR_ACADEMICO; else if(
	 * tipoDirectivo.equalsIgnoreCase("SUBDIRECTOR_ADMINISTRATIVO")) return
	 * TipoDirectivo.SUBDIRECTOR_ADMINISTRATIVO; else return null; }
	 */
	
	/*
	 * // Método principal utilizado para probar la funcionalidad de la clase public
	 * static void main(String[] args) { // Se obtienen los libros del archivo
	 * "libros.txt" y se muestran por consola Book[] libros =
	 * getInputBooks("recursos/libros.txt"); for(Book libro : libros) {
	 * System.out.println(libro); } }
	 */

	
}
