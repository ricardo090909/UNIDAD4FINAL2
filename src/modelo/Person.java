package modelo;

import java.time.LocalDate;

import enumeraciones.Genero;
import interfaces.Keyable;

public abstract class Person implements Keyable{
	
	private String clave;
	protected String nombre;
	protected String paterno;
	protected String materno;
	private Genero genero;
	private LocalDate fechaNacimiento;
	private Domicilio domicilio;
	
	protected String  getClave(){
		return clave;
	}
	protected void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	@Override
	public String toString() {
		return  nombre + " " + paterno + " " + materno + " " + genero.getGender() + " " + "Fecha de nacimiento " + fechaNacimiento 
			+ "\nDomicilio " + domicilio.toString();
	}
	@Override
	public String getAtributeComparable() {
		return getPaterno() + getMaterno() + getNombre();
	}
	@Override
	public int compareTo(Object o) {
		Person person = (Person) o;
		return getAtributeComparable().compareTo(person.getAtributeComparable());
	}
	
	
	
}