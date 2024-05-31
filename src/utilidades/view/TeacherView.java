package utilidades.view;

import modelo.Teacher;
import static mx.edu.itzitacuaro.tecnm.utilidades.Utility.*;
import static utilidades.view.GeneralView.*;
import static utilidades.view.PersonView.*;

public class TeacherView {
	
	public static Teacher getTeacherView(String curp) {		
		Teacher teacher = new Teacher();
		teacher.setCurp(curp);
		teacher.setRfc(leer("Ingrese el rfc"));
		teacher.setNombre(leer("Ingrese el nombre"));
		teacher.setPaterno(leer("Ingres el apellido paterno"));
		teacher.setMaterno(leer("Ingrese el apelido materno"));
		teacher.setSueldo(leerDoble("Ingrese su sueldo "));
		teacher.setTitulo(leer("Ingrese su titulo"));
		teacher.setAcademia(leer("Ingrese su academia"));
		teacher.setJefe(leer("Ingrese el nombre de su jefe "));
		teacher.setFechaNacimiento(getFechaNacimiento());
		teacher.setGenero(getGenero());
		teacher.setDomicilio(getDomicilio());
		teacher.setPuesto(getPuestoTrabajo());
		teacher.setHorario(getHorario());
		
		return teacher;
	}
	
}
