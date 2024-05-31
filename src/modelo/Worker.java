package modelo;

import enumeraciones.PuestoTrabajo;

public class Worker extends Person {
	
	protected String rfc;
	private PuestoTrabajo puesto;
	private String horario;
	private Double sueldo;
	
	
	
	public String getCurp() {
		return getClave();
	}

	public void setCurp(String curp) {
		setClave(curp);
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public PuestoTrabajo getPuesto() {
		return puesto;
	}
	public void setPuesto(PuestoTrabajo puesto) {
		this.puesto = puesto;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	@Override
	public String getKey() {
		
		return null;
	}
	@Override
	public String toString() {
		return super.toString() + "\n" + "RFC " + rfc + " " + puesto.getPuesto() + " Horario " + horario + " Sueldo " + sueldo;
	}

}
