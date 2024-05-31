package modelo;

import java.util.Arrays;

import interfaces.Keyable;
import interfaces.Operable;

public class Container implements Operable{
	private int id;
	private int capacidad;
	private int contador;
	private Keyable[] contenedor;
	
	public Container(int id, int capacidad) {
		this.id = id; // Asigna el identificador proporcionado al atributo id
		this.capacidad = capacidad; // Asigna la capacidad proporcionada al atributo capacidad
		contador = 0; // Inicializa el contador de elementos en 0
		contenedor = new Keyable[capacidad]; // Crea un nuevo arreglo con la capacidad especificada
	}
	@Override
	public boolean isEmpty() {
		return contador == 0;
	}
	@Override
	public boolean isFull() {
		return contador == capacidad;
	}
	@Override
	public void add(Keyable item) {
		contenedor[contador] = item;
		contador++;
	}
	@Override
	public boolean exist(int position) {
		return position >= 0;
	}
	@Override
	public int getPosition(String clave) {
		for (int i = 0; i < contador; i++)
			if (contenedor[i].getKey().equals(clave))
				return i;
		return -1;
	}
	
	// Verifica si la posición es válida y el elemento en esa posición es de un tipo específico, luego lo convierte y devuelve
	// De lo contrario, devuelve null
	@Override
	public Keyable getItem(int position) {
		if (position >= 0) {
			if (contenedor[position] instanceof Student sourceStudent) {
				Student objectStudent = new Student();
				moveTo(objectStudent, sourceStudent);
				return objectStudent;
			} 
			if (contenedor[position] instanceof Teacher sourceTeacher) {
				Teacher objecttTeacher = new Teacher();
				moveTo(objecttTeacher, sourceTeacher);
				return objecttTeacher;
			}
			if (contenedor[position] instanceof Book sourceBook) {
				Book objectBook =  new Book();
				moveTo(objectBook, sourceBook);
				return objectBook;
			}
			if (contenedor[position] instanceof Directivos sourceDirectivo) {
				Directivos objectDirectivo = new Directivos();
				moveTo(objectDirectivo, sourceDirectivo);
				return objectDirectivo;
			}
		}
		return null;
	}
	
	// Elimina el elemento en la posición especificada del contenedor
			// Disminuye el contador de elementos
	@Override
	public void remove(int position) {
		for (int i = 0; i < contador; i++)
			contenedor[i] = contenedor[i + 1];
		contador--;
	}
	
	// Actualiza el elemento en la posición especificada del contenedor con el nuevo elemento proporcionado
	@Override
	public void update(Keyable item,int position) {
		if (position >= 0) {
			if (contenedor[position] instanceof Student objectStudent)
				moveTo(objectStudent, (Student) item);
			if (contenedor[position] instanceof Teacher objectTeacher)
				moveTo(objectTeacher, (Teacher) item);
			if (contenedor[position] instanceof Book objectBook)
				moveTo(objectBook, (Book) item);
			if (contenedor[position] instanceof Directivos objectManager)
				moveTo(objectManager, (Directivos) item);
		}
	}
	
	// Devuelve una cadena que representa la lista de elementos en el contenedor
	@Override
	public String getList(String titulo) {
		String data = titulo;
		for (int i = 0; i < contador; i++)
			data += contenedor[i] + "\n";
		return data;
	}
	private void moveTo(Student objectStudent, Student sourceStudent) {
		objectStudent.setNumeroControl(sourceStudent.getNumeroControl());
		objectStudent.setNombre(sourceStudent.getNombre());
		objectStudent.setPaterno(sourceStudent.getPaterno());
		objectStudent.setMaterno(sourceStudent.getMaterno());
		objectStudent.setGenero(sourceStudent.getGenero());
		objectStudent.setDomicilio(sourceStudent.getDomicilio());
		objectStudent.setFechaNacimiento(sourceStudent.getFechaNacimiento());
		objectStudent.setCarrera(sourceStudent.getCarrera());
		objectStudent.setSemestre(sourceStudent.getSemestre());
		objectStudent.setGrupo(sourceStudent.getGrupo());
		objectStudent.setTelefono(sourceStudent.getTelefono());
		objectStudent.setEmail(sourceStudent.getEmail());
	}
	private void moveTo(Teacher objectTeacher, Teacher sourceTeacher) {
		objectTeacher.setCurp(sourceTeacher.getCurp());
		objectTeacher.setRfc(sourceTeacher.getRfc());
		objectTeacher.setNombre(sourceTeacher.getNombre());
		objectTeacher.setPaterno(sourceTeacher.getPaterno());
		objectTeacher.setMaterno(sourceTeacher.getMaterno());
		objectTeacher.setFechaNacimiento(sourceTeacher.getFechaNacimiento());
		objectTeacher.setGenero(sourceTeacher.getGenero());
		objectTeacher.setDomicilio(sourceTeacher.getDomicilio());
		objectTeacher.setPuesto(sourceTeacher.getPuesto());
		objectTeacher.setHorario(sourceTeacher.getHorario());
		objectTeacher.setSueldo(sourceTeacher.getSueldo());
		objectTeacher.setTitulo(sourceTeacher.getTitulo());
		objectTeacher.setAcademia(sourceTeacher.getAcademia());
		objectTeacher.setJefe(sourceTeacher.getJefe());
	}
	private void moveTo(Book objectBook, Book sourceBook) {
		objectBook.setIsbn(sourceBook.getKey());
		objectBook.setTitulo(sourceBook.getTitulo());
		objectBook.setAutor(sourceBook.getAutor());
		objectBook.setEditorial(sourceBook.getEditorial());
		objectBook.setEdicion(sourceBook.getEdicion());
		objectBook.setIdioma(sourceBook.getIdioma());
		objectBook.setVolumen(sourceBook.getVolumen());
	}
	private void moveTo(Directivos objectManager, Directivos sourceManager) {
		objectManager.setCurp(sourceManager.getCurp());
		objectManager.setNombre(sourceManager.getNombre());
		objectManager.setPaterno(sourceManager.getPaterno());
		objectManager.setMaterno(sourceManager.getMaterno());
		objectManager.setGenero(sourceManager.getGenero());
		objectManager.setFechaNacimiento(sourceManager.getFechaNacimiento());
		objectManager.setDomicilio(sourceManager.getDomicilio());
		objectManager.setRfc(sourceManager.getRfc());
		objectManager.setPuesto(sourceManager.getPuesto());
		objectManager.setHorario(sourceManager.getHorario());
		objectManager.setSueldo(sourceManager.getSueldo());
		objectManager.setGradoEstudios(sourceManager.getGradoEstudios());
		objectManager.setTipoDirectivo(sourceManager.getTipoDirectivo());
		objectManager.setCompensacion(sourceManager.getCompensacion());
	}
	
	@Override
	public void ordenar() {
		for (int i = 0; i < (contador-1); i++)
			for (int j = 0; j < contador; j++)
				if (contenedor[i].getAtributeComparable().compareTo(contenedor[j].getAtributeComparable()) > 0) {
					Keyable aux = contenedor[i];
					contenedor[i] = contenedor[j];
					contenedor[j] = aux;
				}
	}
	// Ordena los elementos en el contenedor utilizando el método sort de la clase Arrays
	@Override
	public void sort() {
		Arrays.sort(contenedor, 0, contador);
	}

}
