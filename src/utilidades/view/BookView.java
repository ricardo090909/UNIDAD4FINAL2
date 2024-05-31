package utilidades.view;

import modelo.Book;
import static mx.edu.itzitacuaro.tecnm.utilidades.Utility.*;

public class BookView {
	 // Método estático que solicita información sobre un libro al usuario y devuelve un objeto Book con esa información
	public static Book getBookView(String isbn) {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitulo(leer("Ingrese el titulo del libro"));
		book.setAutor(leer("Ingrese el nombre del autor"));
		book.setEditorial(leer("Ingrese la editorial"));
		book.setEdicion(leer("Ingrese la edicion"));
		book.setIdioma(leer("Ingresa el idioma"));
		book.setVolumen(leerInt("Ingrese el numero de volumen"));
		
		return book;
	}
}
