package controlador;


import static mx.edu.itzitacuaro.tecnm.utilidades.Utility.*;
import static utilidades.view.BookView.getBookView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.DaoUtility;
import interfaces.Operable;
import modelo.Book;


public class BookController {

	private static Operable bookGroup;

	public static void initDataBook(Operable bookGroup) {
		BookController.bookGroup = bookGroup;
	}

	public static class OyenteRegistrarLibros implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!bookGroup.isFull()) {
				do {
					String isbn = leer("Ingrese el isbn ");
					int position = bookGroup.getPosition(isbn);
					if (!bookGroup.exist(position)) {
						Book book = getBookView(isbn);
						bookGroup.add(book);
						DaoUtility.guardarBook(book);
						mostrar("Libro registrado");
					} else {
						mostrar("El libro ya existe");
					}
				} while (!bookGroup.isFull() && continuar("¿Deseas registrar otro?"));
			} else {
				mostrar("El estante esta lleno");
			}
		}
	}

		public static class OyenteListarLibros implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (!bookGroup.isEmpty())
					mostrar(bookGroup.getList("Listado de Libros"));
				else
					mostrar("El estante esta vacio");
			}
		}
		public static class OyenteOrdenarLibros implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (!bookGroup.isEmpty()) {
					bookGroup.sort();
					mostrar("Ordenados ");
				} else
					mostrar("El estante esta vacio");
			}
		}

		public static class OyenteConsultarLibros implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (!bookGroup.isEmpty()) {
					do {
						String isbn = leer("Ingresa el ISBN ");
						int position = bookGroup.getPosition(isbn);
						if (bookGroup.exist(position))
							mostrar(bookGroup.getItem(position).toString());
						else
							mostrar("el libro no existe en el estante");
					} while (continuar("¿Deseas consultar otro libro"));
				} else
					mostrar("El estante se encuentra vacio");
			}
		}

		public static class OyenteEliminarLibros implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (!bookGroup.isEmpty()) {
					do {
						String isbn = leer("Ingresa el ISBN ");
						int position = bookGroup.getPosition(isbn);
						if (bookGroup.exist(position)) {
							bookGroup.remove(position);
							mostrar("Libro eliminado ");
						}
						else
							mostrar("Este libro no existe");
					} while (!bookGroup.isEmpty() && continuar("¿Deseas eliminar otro libro"));
				} else
					mostrar("El estante se encuentra vacio");
			}
		}

		public static class OyenteModificarLibros implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (!bookGroup.isEmpty()) {
					do {
						String isbn = leer("Ingresa el ISBN ");
						int position = bookGroup.getPosition(isbn);
						if (bookGroup.exist(position)) {

						}
						else
							mostrar("Este libro no existe ");
					} while (continuar("¿Deseas modificar otro libro"));
				} else
					mostrar("El estante se encuentra vacio");
			}
		}





		
		/*
		 * public static class OyenteCargarLibros implements ActionListener{ public void
		 * actionPerformed(ActionEvent e) { Book[] libros =
		 * getInputBooks("recursos/libros.txt"); if (libros != null ) if (100 >
		 * libros.length) { for (Book libro : libros) if
		 * (!bookGroup.exist(bookGroup.getPosition(libro.getKey())))
		 * bookGroup.add(libro); mostrar("Carga relaizada"); } else
		 * mostrar("No hay capacidad"); else
		 * mostrar("Error al hacer la carga de archivos");
		 * 
		 * } }
		 * 
		 */


	}

