package modelo;

import java.util.ArrayList;
import java.util.List;

import enumeraciones.TipoDirectivo;

public class Directivos extends Worker {
	private List<Directivos> directivos;
	private String gradoEstudios;
	private TipoDirectivo tipoDirectivo;
	private int compensacion;
	
	public String getGradoEstudios() {
		return gradoEstudios;
	}
	public void setGradoEstudios(String gradoEstudios) {
		this.gradoEstudios = gradoEstudios;
	}
	public TipoDirectivo getTipoDirectivo() {
		return tipoDirectivo;
	}
	public void setTipoDirectivo(TipoDirectivo tipoDirectivo) {
		this.tipoDirectivo = tipoDirectivo;
	}
	public int getCompensacion() {
		return compensacion;
	}
	public void setCompensacion(int compensacion) {
		this.compensacion = compensacion;
	}
	
	public List<Directivos> getAllItems() {
        return new ArrayList<>(directivos);
    }
	@Override
	public String toString() {
		return  "RFC:"+ rfc +"," + "Nombre:"+ nombre +"," + "Paterno:"+ paterno +"," + "Materno:"+ materno +"," +  "Grado de estudios :" + gradoEstudios + ", " + tipoDirectivo + ", pago "+ compensacion + "]";
	}
	
	
}
