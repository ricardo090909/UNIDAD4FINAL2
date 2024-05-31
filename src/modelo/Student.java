package modelo;

import interfaces.Keyable;

public class Student extends Person implements Keyable{
	private String numeroControl;
	private String carrera;
	private String semestre;
	private String grupo;
	private String telefono;
	private String email;
	
	@Override
	public String getKey() {
		
		return numeroControl;
	}
	
	public String getNumeroControl() {
		return getClave();
	}
	public void setNumeroControl(String numeroControl) {
		setClave(numeroControl);
		this.numeroControl = numeroControl;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return super.toString() + "\n" + "Carrera  " + carrera + "Semestre " + semestre
				+ " Grupo " + grupo + " Telefono " + telefono + " E-mail " + email + "\n";
	}
	
	
	
}
