package controlador;


import static utilidades.view.TeacherView.getTeacherView;
import static mx.edu.itzitacuaro.tecnm.utilidades.Utility.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.DaoUtility;
import interfaces.Operable;
import modelo.Teacher;

public class TeacherController {
	private static Operable teacherGroup;
	
	public static void initDataTeacher(Operable teacherGroup) {
		TeacherController.teacherGroup = teacherGroup;
	}
				
	public static class OyenteRegistrarDocentes implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!teacherGroup.isFull()) {
                do {
                    String curp = leer("Ingrese su curp");
                    int position = teacherGroup.getPosition(curp);
                    if (!teacherGroup.exist(position)) {
                        Teacher docente = getTeacherView(curp);
                        teacherGroup.add(docente);
                        DaoUtility.guardarDocente(docente);
                        mostrar("Docente registrado con exito");
                    } else {
                        mostrar("El docente ya se encuentra registrado");
                    }
                } while (!teacherGroup.isFull() && continuar("Deseas registrar a otro docente"));
            } else {
                mostrar("El grupo de docentes se encuentra lleno");
            }
        }
    }

						
	public static class OyenteConsultarDocentes implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if (!teacherGroup.isEmpty()) {
				do {
					String curp = leer("Ingrese su curp");
					int position = teacherGroup.getPosition(curp);
					if (teacherGroup.exist(position))
						mostrar(teacherGroup.getItem(position).toString());
					else 
						mostrar("Este docente no se encuentra en la sala");
				} while (continuar("Deseas visualizar a otro docente"));	
			} else 
				mostrar("El grupo de docentes se ecuentra vacio");
    	}
    }
					
	public static class OyenteEliminarDocentes implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if (!teacherGroup.isEmpty()) {
				do {
					String curp = leer("Ingrese su curp");
					int position = teacherGroup.getPosition(curp);
					if (!teacherGroup.exist(position)) {
						teacherGroup.remove(position);
						mostrar("Docente eliminado con exito");
					}
				}while(!teacherGroup.isEmpty() && continuar("Deseas eliminar otro docente"));
			} else 
				mostrar("El grupo de docentes se ecuentra vacio");
    	}
    }
						
	public static class OyenteModificarDocentes implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if (!teacherGroup.isEmpty()) {
    			
    		} else 
    			mostrar("El grupo de docentes se ecuentra vacio");
    	}
    }
						
    public static class OyenteListarDocentes implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if (!teacherGroup.isEmpty())
				mostrar(teacherGroup.getList("Listado general de Docnetes"));
			else
				mostrar("El grupo de docentes se ecuentra vacio");	
    	}
    }
						
    public static  class OyenteOrdenarDocentes implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if (!teacherGroup.isEmpty()) {
    			teacherGroup.sort();
    			mostrar("Ordenados con exito");
    		} else 
    			mostrar("El grupo de docentes se encuentra vacio");
    	}
    }
    				
	/*
	 * public static class OyenteCargarDocentes implements ActionListener{ public
	 * void actionPerformed(ActionEvent e) { Teacher[] teachers =
	 * getInputTeachers("recursos/docentes.txt"); if (teachers != null ) if (100 >
	 * teachers.length) { for (Teacher teacher : teachers) if
	 * (!teacherGroup.exist(teacherGroup.getPosition(teacher.getKey())))
	 * teacherGroup.add(teacher); mostrar("Carga relaizada con exito"); } else
	 * mostrar("No hay capacidad"); else
	 * mostrar("Error al hacer la carga de archivos"); } }
	 */

}
