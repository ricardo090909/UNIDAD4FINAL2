package modelo;

public class Teacher extends Worker {
	private String titulo;
	private String academia;
	private String jefe;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAcademia() {
		return academia;
	}
	public void setAcademia(String academia) {
		this.academia = academia;
	}
	public String getJefe() {
		return jefe;
	}
	public void setJefe(String jefe) {
		this.jefe = jefe;
	}
	@Override
	public String toString() {
		return  super.toString() + "Titulo " + titulo + " Academia " + academia + " Jefe  " + jefe;
	}
	
}
