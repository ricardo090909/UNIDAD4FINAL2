package modelo;

import enumeraciones.Orientacion;

public class Domicilio{
	
	private String calle;
	private int numeroCasa;
	private Orientacion orientacion;
	private String colonia;
	private String ciudad;
	private String estado;
	private String codigoPostal;
	
	public int getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Orientacion getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(Orientacion orientacion) {
		this.orientacion = orientacion;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getData() {
		return  "\n_Calle " + calle
				+ "\n_Num. Casa" + numeroCasa
				+ "\n_Orientacion " + orientacion
				+ "\n_Colonia " + colonia
				+ "\n_Ciudad " + ciudad
				+ "\n_Estado " + estado
				+ "\n_Codigo postal " + codigoPostal;
	}
	@Override
	public String toString() {
		return  calle + " " + orientacion.getOrientation() + ", Num." + numeroCasa
				+ ", " + colonia + " " + ciudad + " " + estado + ", CP " + codigoPostal;
	}
	
}
