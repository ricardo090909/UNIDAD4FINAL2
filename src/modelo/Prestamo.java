package modelo;

import interfaces.Keyable;

public class Prestamo implements Keyable {
    private String identificador;
    private String isbn;
    private String tipoPersona;

    public Prestamo(String identificador, String isbn, String tipoPersona) {
        this.identificador = identificador;
        this.isbn = isbn;
        this.tipoPersona = tipoPersona;
    }

    @Override
    public String getKey() {
        return identificador;
    }

    @Override
    public String getAtributeComparable() {
        return isbn;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Prestamo) {
            Prestamo other = (Prestamo) o;
            return this.isbn.compareTo(other.isbn);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ID :"+identificador + "\t"+ "ISBN :" + isbn + "\t"+ tipoPersona;
    }

    // Getters y setters adicionales

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
}
