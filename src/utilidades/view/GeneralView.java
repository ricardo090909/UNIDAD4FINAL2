package utilidades.view;

import static mx.edu.itzitacuaro.tecnm.utilidades.Utility.*;

import enumeraciones.Orientacion;
import enumeraciones.PuestoTrabajo;
import modelo.Domicilio;

public class GeneralView {
	// Método estático que solicita información sobre un domicilio al usuario y devuelve un objeto Domicilio con esa información
	public static Domicilio getDomicilio() {
		String calle = leer("Ingrese la calle del domicilio");
		int numeroCasa = leerInt("Ingrese el numero de casa");	
		String colonia = leer("Ingrese la colonia");
		String ciudad = leer("Ingrese la ciudad");
		String estado = leer("Ingrese el estado");
		String codigoPostal = leer("Ingrese el codigo postal");
		Orientacion orientacion = getOrientacion();
		Domicilio domicilio = new Domicilio();
		
		domicilio.setCalle(calle);
		domicilio.setNumeroCasa(numeroCasa);
		domicilio.setOrientacion(orientacion);
		domicilio.setColonia(colonia);
		domicilio.setCiudad(ciudad);
		domicilio.setEstado(estado);
		domicilio.setCodigoPostal(codigoPostal);
		
		return domicilio;
	}
	
	private static Orientacion getOrientacion() {
		String orient = "Orientacion\n"
				+ "Norte\n"
				+ "Sur\n"
				+ "Este\n"
				+ "Oeste\n"
				+ "Dijite una opcion";
		String laOrientacion = leer(orient);
		String mayusculas = laOrientacion.toUpperCase();
		char orientacion = mayusculas.charAt(0);
		
		if (orientacion == 'N')
			return Orientacion.NORTE;
		else if (orientacion == 'S')
			return Orientacion.SUR;
		else if (orientacion == 'E')
			return Orientacion.ESTE;
		else 
			return Orientacion.OESTE;
	}
	
	public static PuestoTrabajo getPuestoTrabajo() {
		String[] opciones = {
				"Director",
				"Subdirector",
				"Jefe de departamento",
				"Coordinador",
				"Docente",
				"Prefecto",
				"Orientador"};
		int opcion = getOptionMenu(opciones, "Puesto de trabajo");
		switch(opcion) {
		case 1: return PuestoTrabajo.DIRECTOR;
		case 2: return PuestoTrabajo.SUBDIRECTOR;
		case 3: return PuestoTrabajo.JEFE_DEPARTAMENTO;
		case 4: return PuestoTrabajo.COORDINADOR;
		case 5: return PuestoTrabajo.DOCENTE;
		case 7: return PuestoTrabajo.PREFECTO;
		case 9: return PuestoTrabajo.ORIENTADOR;
		}
		return null;
	}
	
	public static String getHorario() {
		String horario = leer("Ingrese la hora de entrada");
		horario += leer("Ingrese la hora de salida");
		return horario;
	}
	
	
	
	
	
	
	
}
