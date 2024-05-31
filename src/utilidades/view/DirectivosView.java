package utilidades.view;

import static mx.edu.itzitacuaro.tecnm.utilidades.Utility.*;
import static utilidades.view.GeneralView.*;
import static utilidades.view.PersonView.*;

import enumeraciones.TipoDirectivo;
import modelo.Directivos;

public class DirectivosView {
	// Método estático que solicita información sobre un directivo al usuario y devuelve un objeto Directivos con esa información
	public static Directivos getManagerView(String curp) {
		Directivos directivo = new Directivos();
		directivo.setCurp(curp);
		directivo.setRfc(leer("Ingrese el rfc"));
		directivo.setNombre(leer("Ingrese el nombre"));
		directivo.setPaterno(leer("Ingres el apellido paterno"));
		directivo.setMaterno(leer("Ingrese el apelido materno"));
		directivo.setSueldo(leerDoble("Ingrese su sueldo "));
		directivo.setGradoEstudios(leer("Ingrese su grado de estudios"));
		directivo.setCompensacion(leerInt("Dijite su compensacion"));
		directivo.setFechaNacimiento(getFechaNacimiento());
		directivo.setGenero(getGenero());
		directivo.setDomicilio(getDomicilio());
		directivo.setPuesto(getPuestoTrabajo());
		directivo.setHorario(getHorario());
		directivo.setTipoDirectivo(getTipoDirectivo());
		
		return directivo;
	}
	
	private static TipoDirectivo getTipoDirectivo() {
		String[] opciones = {
				"Subdirector administrativo ",
				"Sudirector academico "
			
		};
		int opcion = getOptionMenu(opciones,"Dijite el numero de la opcion");
		switch(opcion){
		case 1: return TipoDirectivo.SUBDIRECTOR_ADMINISTRATIVO;
		case 2: return TipoDirectivo.SUBDIRECTOR_ACADEMICO;

		}
		return null;
	}
}
