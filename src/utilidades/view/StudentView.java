package utilidades.view;

import static mx.edu.itzitacuaro.tecnm.utilidades.Utility.*;
import static utilidades.view.GeneralView.*;
import static utilidades.view.PersonView.*;
import modelo.Student;

public class StudentView {
	
	public static Student getStudentView(String numeroControl) {
		Student student = new Student();
		student.setNumeroControl(numeroControl);
		student.setNombre(leer("Ingrese el nombre del alumno"));
		student.setPaterno(leer("Ingrese el apellido paterno"));
		student.setMaterno(leer("Ingres su apellido materno"));
		student.setCarrera("ingrese su carrera");
		student.setSemestre("ingrese su semestre");
		student.setGrupo("ingrese su grupo");
		student.setTelefono(leer("Ingrese el telefono"));
		student.setEmail(leer("Ingrese el email"));
		student.setDomicilio(getDomicilio());
		student.setFechaNacimiento(getFechaNacimiento());
		student.setGenero(getGenero());
		
		return student;
	}
	
	
}
