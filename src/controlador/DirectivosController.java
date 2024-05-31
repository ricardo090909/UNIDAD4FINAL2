package controlador;

import static mx.edu.itzitacuaro.tecnm.utilidades.Utility.*;
import static utilidades.view.DirectivosView.getManagerView;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.DaoUtility;
import interfaces.Operable;
import modelo.Directivos;

public class DirectivosController {
	private static Operable directivosGroup;
	
	public static void initDataDirectivos(Operable directivosGroup) {
		DirectivosController.directivosGroup = directivosGroup;
	}
						
	 public static class OyenteRegistrarDirectivos implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            if (!directivosGroup.isFull()) {
	                do {
	                    String curp = leer("Ingrese su curp");
	                    int position = directivosGroup.getPosition(curp);
	                    if (!directivosGroup.exist(position)) {
	                        Directivos directivo = getManagerView(curp);
	                        directivosGroup.add(directivo);
	                        DaoUtility.guardarDirectivo(directivo);
	                        mostrar("Directivo registrado");
	                    } else {
	                        mostrar("El directivo ya se encuentra registrado");
	                    }
	                } while (!directivosGroup.isFull() && continuar("¿Deseas registrar a otro directivo?"));
	            } else {
	                mostrar("El grupo de directivos se encuentra lleno");
	            }
	        }
	    }
						
	public static class OyenteConsultarDirectivos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!directivosGroup.isEmpty()) {
				do {
					String curp = leer("Ingrese su curp");
					int position = directivosGroup.getPosition(curp);
					if (directivosGroup.exist(position))
						mostrar(directivosGroup.getItem(position).toString());
					else 
						mostrar("Este directivo no se encuentra registrado");
				} while (continuar("Deseas visualizar a otro directivo"));	
			} else 
				mostrar("El grupo de directivos se ecuentra vacio");
    	}
	}
						
	public static class OyenteEliminarDirectivos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!directivosGroup.isEmpty()) {
				do {
					String curp = leer("Ingrese su curp");
					int position = directivosGroup.getPosition(curp);
					if (!directivosGroup.exist(position)) {
						directivosGroup.remove(position);
						mostrar("Directivo eliminado con exito");
					}
				}while(!directivosGroup.isEmpty() && continuar("Deseas eliminar otro docente"));
			} else 
				mostrar("El grupo de directivos se ecuentra vacio");
    	}
	}
						
	public static class OyenteModificarDirectivos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!directivosGroup.isEmpty()) {
    			
    		} else 
    			mostrar("El grupo de directivos se ecuentra vacio");
    	}
	}
				
	public static class OyenteListarDirectivos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!directivosGroup.isEmpty())
				mostrar(directivosGroup.getList("Listado general de Directivos"));
			else
				mostrar("El grupo de docentes se ecuentra vacio");	
    	}
	}
						
	public static class OyenteOrdenarDirectivos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!directivosGroup.isEmpty()) {
				directivosGroup.sort();
    			mostrar("Ordenados con exito");
    		} else 
    			mostrar("El grupo de docentes se encuentra vacio");
    	}
	}
						
	/*
	 * public static class OyenteCargarDirectivos implements ActionListener{ public
	 * void actionPerformed(ActionEvent e) { Directivos[] directivos =
	 * getInputManagers("recursos/directivos.txt"); if (directivos != null ) if (100
	 * > directivos.length) { for (Directivos directivo : directivos) if
	 * (!directivosGroup.exist(directivosGroup.getPosition(directivo .getKey())))
	 * directivosGroup.add(directivo ); mostrar("Carga relaizada con exito"); } else
	 * mostrar("No hay capacidad"); else
	 * mostrar("Error al hacer la carga de archivos"); } }
	 */
    	
	

}
