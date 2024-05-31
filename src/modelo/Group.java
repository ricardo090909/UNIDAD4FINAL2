package modelo;

public class Group {
	private int id;
	private int capacidad;
	private int contador;
	
	public Group(int id, int capacidad) {
		this.capacidad = capacidad;
		this.contador = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	
	public boolean isEmpty() {
		return contador == 0;
	}
	public boolean isFull() {
		return contador == capacidad;
	}
	public boolean exist(int position) {
		return position >= 0;
	}

}
