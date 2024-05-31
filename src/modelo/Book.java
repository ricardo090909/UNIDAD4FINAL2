package modelo;

import interfaces.Keyable;

public class Book implements Keyable, Comparable<Object>{
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private String edicion;
	private String idioma;
	private int volumen;
	
	@Override
	public String getKey() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getVolumen() {
		return volumen;
	}
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}
	@Override
	public String toString() {
		return "ISBN: "+ isbn + ", titulo:  " + titulo + ", autor : " + autor + ", editorial:  " + editorial
				+ ", volumen:  " + volumen + ", edicion : " + edicion + ", Idioma : " + idioma;
	}
	@Override
	public int compareTo(Object o) {
		Book book = (Book) o;
		return this.titulo.compareTo(book.getTitulo());
	}
	@Override
	public String getAtributeComparable() {
		return titulo;
	}
	
}
