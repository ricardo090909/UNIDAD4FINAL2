package utilidades.view;

import static mx.edu.itzitacuaro.tecnm.utilidades.Utility.*;
import java.time.LocalDate;
import enumeraciones.Genero;

public class PersonView {
	
	public static Genero getGenero() {
		String genero = "Genero\n"
				+ "Masculino\n"
				+ "Femenino\n"
				+ "Seleccione una opcion M/F";
		String myGenero = leer(genero);
		
		String mayuscula = myGenero.toUpperCase();
		
		char sexo = mayuscula.charAt(0);
		
		return (sexo == 'M'? Genero.MASCULINO : Genero.FEMENINO);
	}
	
	public static LocalDate getFechaNacimiento() {
		int anioNacimiento = leerInt("Anio de nacimiento");
		int mesNacimiento = leerInt("Mes de nacimiento");
		int diaNacimiento = leerInt("Dia de nacimiento");
		
		return LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
	}
	
	
}
