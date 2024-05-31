package controlador;

import static dao.DaoUtility.*;
import static mx.edu.itzitacuaro.tecnm.utilidades.Utility.*;
import static utilidades.view.StudentView.getStudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.DaoUtility;
import interfaces.Operable;
import modelo.Student;

public class StudentController{
	private static Operable studentGroup;

	public static void initDataStudent(Operable studentGroup) {
		StudentController.studentGroup = studentGroup;
	}

	public static class OyenteRegistrarAlumnos implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!studentGroup.isFull()) {
				do {
					String numeroControl = leer("Ingrese el numero de control");
					int position = studentGroup.getPosition(numeroControl);
					if (!studentGroup.exist(position)) {
						Student alumno = getStudentView(numeroControl);
						studentGroup.add(alumno);
						DaoUtility.guardarAlumno(alumno);
						mostrar("Alumno registrado con exito");
					} else {
						mostrar("El numero de control ya existe");
					}
				} while (!studentGroup.isFull() && continuar("Deseas registrar a otro alumno"));
			} else {
				mostrar("El grupo ya esta lleno");
			}
		}
	}

	public static class OyenteConsultarAlumnos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!studentGroup.isEmpty()) {
				do {
					String numeroControl = leer("Ingrese el numero de control");
					int position = studentGroup.getPosition(numeroControl);
					if (studentGroup.exist(position))
						mostrar(studentGroup.getItem(position).toString());
					else 
						mostrar("Este alumno no existe en el salon");
				} while (continuar("Deseas visualizar a otro alumno"));	
			} else 
				mostrar("El grupo esta vacio");
		}
	}


	public static class OyenteModificarAlumnos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!studentGroup.isEmpty()) {
				do {
					String numeroControl = leer("Ingrese el numero de control");
					int position = studentGroup.getPosition(numeroControl);
					if (studentGroup.exist(position)) {

						mostrar("Modificado con exito");
					} else 
						mostrar("Este alumno no esta en el salon");
				} while (continuar("Deseas modificar a otro alumno"));	
			} else 
				mostrar("El salon esta vacio");
		}
	}


	public static class OyenteEliminarAlumnos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!studentGroup.isEmpty()) {
				do {
					String numeroControl = leer("Ingrese el numero de control");
					int position = studentGroup.getPosition(numeroControl);
					if (studentGroup.exist(position)) {
						studentGroup.remove(position);
						mostrar("Alumno eliminado con exito");
					} else 
						mostrar("Este alumno no existe en el salon");
				} while (!studentGroup.isEmpty() && continuar("Deseas eliminar a otro alumno"));	
			} else 
				mostrar("El grupo esta vacio");
		}
	}

	public static class OyenteListarAlumnos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!studentGroup.isEmpty())
				mostrar(studentGroup.getList("Listado general de Alumnos"));
			else
				mostrar("El salon esta vacio");	
		}
	}

	public static class OyenteOrdenarAlumnos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!studentGroup.isEmpty()) {
				studentGroup.sort();
				mostrar("Ordenados con exito");
			} else
				mostrar("El salon esta vacio");
		}
	}
//no pude usarlo
	//	public static class OyenteCargarAlumnos implements ActionListener{
	//	public void actionPerformed(ActionEvent e) {
	//		Student[] students = getInputStudents("recursos/alumnos.txt");
	//			if (students != null )
	//				if (100 > students.length) {
	//					for (Student student : students)
	//						if (!studentGroup.exist(studentGroup.getPosition(student.getKey())))
	//							studentGroup.add(student);
	//					mostrar("Carga relaizada con exito");
	//			} else 
	//					mostrar("No hay capacidad");
	//			else
	//				mostrar("Error al hacer la carga de archivos");
	//		}
	//	}

}
