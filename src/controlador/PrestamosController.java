package controlador;

import static mx.edu.itzitacuaro.tecnm.utilidades.Utility.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.DaoUtility;
import interfaces.Operable;
import modelo.Prestamo;

public class PrestamosController {

    private static Operable prestamos;

    public static void initDataPrestamos(Operable prestamos) {
        PrestamosController.prestamos = prestamos;
    }

    public static class OyenteRegistrarPrestamos implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!prestamos.isFull()) {
                do {
                	//hice todo esto por que no pude juntarlo con los datos que ya solicitaba osea este metodo no esta usando 
                    String tipoPersona = leer("Quien solicita el libro? (ALUMNO, DOCENTE, DIRECTIVO): ");
                    String id = null;
                    String isbn = null;
                    boolean identificador = false;
                    while (!identificador) {
                        if (tipoPersona.equals("ALUMNO")) {
                            id = leer("Ingrese el Numero de Control: ");
                            identificador = true;
                        } else if (tipoPersona.equals("DOCENTE")) {
                            id = leer("Ingrese el CURP: ");
                            identificador = true;
                        } else if (tipoPersona.equals("DIRECTIVO")) {
                            id = leer("Ingrese el CURP: ");
                            identificador = true;
                        } else {
                            mostrar("Tipo de persona no valida");
                        }
                    }
                    isbn = leer("Ingrese el ISBN del libro: ");                 
                    int position = prestamos.getPosition(id);
                    if (!prestamos.exist(position)) {
                        Prestamo nuevoPrestamo = new Prestamo(id, isbn, tipoPersona);
                        prestamos.add(nuevoPrestamo);
                        DaoUtility.guardarPrestamo(nuevoPrestamo);
                        mostrar("Prestamo registrado");
                    } else {
                        mostrar("Ya se ha prestado este libro");
                    }
                } while (!prestamos.isFull() && continuar("¿Deseas registrar otro prestamo?"));
            } else {
                mostrar("El grupo de prestamos esta lleno");
            }
        }
    }
    

    public static class OyenteDevolverPrestamos implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String identificador = leer("Ingrese el identificador de la persona que devuelve el libro (CURP o Numero de Control): ");
            int position = prestamos.getPosition(identificador);
            if (prestamos.exist(position)) {
                prestamos.remove(position);
                mostrar("Prestamo devuelto");
            } else {
                mostrar("No se encontro un prstamo con ese identificador.");
            }
        }
    }

    public static class OyenteRenovarPrestamos implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String identificador = leer("Ingrese el identificador de la persona que renueva el prstamo (CURP o Numero de Control): ");
            int position = prestamos.getPosition(identificador);
            if (prestamos.exist(position)) {
                Prestamo prestamo = (Prestamo) prestamos.getItem(position);         
                mostrar("Prestamo renovado.");
            } else {
                mostrar("No se encontro un prestamo con ese identificador.");
            }
        }
    }
}
