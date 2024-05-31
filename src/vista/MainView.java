package vista;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfaces.Operable;
import modelo.Container;

import static controlador.PrestamosController.*;
import static controlador.StudentController.*;
import static controlador.TeacherController.*;
import static controlador.BookController.*;
import static controlador.DirectivosController.*;

public class MainView extends JFrame {
	
	//Menus (JMenu): Cada JMenu representa un menu desplegable dentro de la barra de menu
    // Declaración de una barra de menu (JMenuBar) y varios menus (JMenu).
    private JMenuBar barra;
    private JMenu MenuLibros;
    private JMenu MenuAlumnos;
    private JMenu MenuDocentes;
    private JMenu MenuDirectivos;
    private JMenu MenuPrestamos;
    
  
    //JMenuItem es una opción dentro de un menu.
    // Declaracion de elementos de menú (JMenuItem) para las opciones relacionadas con libros.
    private JMenuItem opRegistrarLibros;
    private JMenuItem opConsultarLibros;
    private JMenuItem opEliminarLibros;
    private JMenuItem opModificarLibros;
    private JMenuItem opListarLibros;
    private JMenuItem opOrdenarLibros;
    private JMenuItem opCargarLibros;

    // Declaración de elementos de menu (JMenuItem) para las opciones relacionadas con alumnos.
    private JMenuItem opRegistrarAlumnos;
    private JMenuItem opConsultarAlumnos;
    private JMenuItem opEliminarAlumnos;
    private JMenuItem opModificarAlumnos;
    private JMenuItem opListarAlumnos;
    private JMenuItem opOrdenarAlumnos;
    private JMenuItem opCargarAlumnos;

    // Declaracion de elementos de menu (JMenuItem) para las opciones relacionadas con docentes.
    private JMenuItem opRegistrarDocentes;
    private JMenuItem opConsultarDocentes;
    private JMenuItem opEliminarDocentes;
    private JMenuItem opModificarDocentes;
    private JMenuItem opListarDocentes;
    private JMenuItem opOrdenarDocentes;
    private JMenuItem opCargarDocentes;

    // Declaracion de elementos de menu (JMenuItem) para las opciones relacionadas con directivos.
    private JMenuItem opRegistrarDirectivos;
    private JMenuItem opConsultarDirectivos;
    private JMenuItem opEliminarDirectivos;
    private JMenuItem opModificarDirectivos;
    private JMenuItem opListarDirectivos;
    private JMenuItem opOrdenarDirectivos;
    private JMenuItem opCargarDirectivos;

  

    
    // Declaracion de elementos de menu (JMenuItem) para las opciones relacionadas con préstamos de libros.
    private JMenuItem opPrestarLibros;
    private JMenuItem opDevolucionLibros;
    private JMenuItem opRenovacionLibros;

    // Declaracion de variables del tipo Operable para gestionar diferentes grupos.
    private Operable studentGroup;
    private Operable teacherGroup;
    private Operable bookGroup;
    private Operable jefesGroup;
    private Operable prestamos;
    
    
    
    public MainView() {
        // Inicializacion de los grupos de contenedores para estudiantes, docentes, libros y directivos
        studentGroup = new Container(1, 50);
        teacherGroup = new Container(2, 50);
        bookGroup = new Container(3, 100);
        jefesGroup = new Container(4, 50);
        prestamos = new Container (5,100);

        // Llamada a metodos para inicializar datos en cada grupo
        initDataStudent(studentGroup);
        initDataTeacher(teacherGroup);
        initDataBook(bookGroup);
        initDataDirectivos(jefesGroup);
        initDataPrestamos(prestamos);

        // Configuracion de la ventana principal
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cerrar la aplicacion al cerrar la ventana
        setExtendedState(MAXIMIZED_BOTH); // Maximizar la ventana
        setBounds(150, 100, 800, 600); // Establecer posicion y tamano de la ventana
        setTitle("LIBRERIA"); // Establecer el titulo de la ventana
        setFont(new Font("", 0, 8)); // Establecer la fuente de la ventana

        // Llamada a metodos para agregar la barra de menu y establecer propiedades adicionales
        addMenuBar();
        propiedades();

        // Hacer visible la ventana
        setVisible(true);
    }
    
    private void propiedades() {
        // Array de menus principales
        JMenu[] menus = {
            MenuLibros, MenuAlumnos, MenuDocentes, MenuDirectivos, MenuPrestamos
        };
        
        // Establecer fuente para cada menu principal
        for (JMenu menu : menus) {
            menu.setFont(new Font("", 0, 11));
        }

        // Array de elementos del menu de Libros
        JMenuItem[] librosItems = {
            opRegistrarLibros, opConsultarLibros, opEliminarLibros, opModificarLibros,
            opListarLibros, opOrdenarLibros, opCargarLibros
        };
        
        // Array de elementos del menu de Alumnos
        JMenuItem[] alumnosItems = {
            opRegistrarAlumnos, opConsultarAlumnos, opEliminarAlumnos, opModificarAlumnos,
            opListarAlumnos, opOrdenarAlumnos, opCargarAlumnos
        };
        
        // Array de elementos del menu de Docentes
        JMenuItem[] docentesItems = {
            opRegistrarDocentes, opConsultarDocentes, opEliminarDocentes, opModificarDocentes,
            opListarDocentes, opOrdenarDocentes, opCargarDocentes
        };
        
        // Array de elementos del menu de Directivos
        JMenuItem[] directivosItems = {
            opRegistrarDirectivos, opConsultarDirectivos, opEliminarDirectivos, opModificarDirectivos,
            opListarDirectivos, opOrdenarDirectivos, opCargarDirectivos
        };
        
        // Array de elementos del menu de Prestamos
        JMenuItem[] prestamosItems = {
        		opPrestarLibros, opDevolucionLibros, opRenovacionLibros
        };

        // Array de todos los arrays de elementos de menu
        JMenuItem[][] allMenuItems = {
            librosItems, alumnosItems, docentesItems, directivosItems, prestamosItems
        };

        // Establecer fuente para cada grupo de elementos de menu
        for (JMenuItem[] menuItems : allMenuItems) {
            for (JMenuItem item : menuItems) {
                item.setFont(new Font("", 0, 11));
            }
        }

       
        opModificarDirectivos.setFont(new Font("", 0, 11));
    }
    
   
  
    
    private void addMenuBar() {
        // Crear una nueva barra de menu
        barra = new JMenuBar();
        
        // Llamar a métodos para inicializar cada menu
        doMenuBooks();
        doMenuAlumnos();
        doMenuDocentes();
        doMenuDirectivos();
        doMenuPrestamos();
        
        // Agregar los menus a la barra de menu
        barra.add(MenuLibros);
        barra.add(MenuAlumnos);
        barra.add(MenuDocentes);
        barra.add(MenuDirectivos);
        barra.add(MenuPrestamos);
       
        // Establece la barra de menu en el JFrame
        setJMenuBar(barra);
    }
    private void doMenuBooks() {
        // Crear una nueva barra de menu 
        barra = new JMenuBar();
        
        // Crear el menu Gestion de libros
        MenuLibros = new JMenu("Gestion de libros");
        
        // Crear elementos del menu
        opRegistrarLibros = new JMenuItem("Registrar");
        opConsultarLibros = new JMenuItem("Consultar");
        opEliminarLibros = new JMenuItem("Eliminar");
        opModificarLibros = new JMenuItem("Modificar");
        opListarLibros = new JMenuItem("Listado");
        opOrdenarLibros = new JMenuItem("Ordenar");
        opCargarLibros = new JMenuItem("Cargar");
        
        // Agregar oyentes de acciones a cada elemento del menu
        opRegistrarLibros.addActionListener(new OyenteRegistrarLibros());
        opConsultarLibros.addActionListener(new OyenteConsultarLibros());
        opEliminarLibros.addActionListener(new OyenteEliminarLibros());
        opModificarLibros.addActionListener(new OyenteModificarLibros());
        opListarLibros.addActionListener(new OyenteListarLibros());
        opOrdenarLibros.addActionListener(new OyenteOrdenarLibros());
      

        // Agregar los elementos al menu Gestion de libros
        MenuLibros.add(opRegistrarLibros);
        MenuLibros.add(opConsultarLibros);
        MenuLibros.add(opEliminarLibros);
        MenuLibros.add(opModificarLibros);
        MenuLibros.add(opListarLibros);
        MenuLibros.add(opOrdenarLibros);
        MenuLibros.add(opCargarLibros);
        
        // Agregar el menu Gestion de libros a la barra de menu
        barra.add(MenuLibros);
        
        // Establecer la barra de menu en el JFrame
        setJMenuBar(barra);
    }


    private void doMenuAlumnos() {
        // Crear una nueva barra de menu 
        barra = new JMenuBar();
        
        // Crear el menu Gestion de alumnos
        MenuAlumnos = new JMenu("Gestion de alumnos");
        
        // Crear elementos del menu
        opRegistrarAlumnos = new JMenuItem("Registrar");
        opConsultarAlumnos = new JMenuItem("Consultar");
        opEliminarAlumnos = new JMenuItem("Eliminar");
        opModificarAlumnos = new JMenuItem("Modificar");
        opListarAlumnos = new JMenuItem("Listado");
        opOrdenarAlumnos = new JMenuItem("Ordenar");
        opCargarAlumnos = new JMenuItem("Cargar");
      
        // Agregar oyentes de acciones a cada elemento del menu
        opRegistrarAlumnos.addActionListener(new OyenteRegistrarAlumnos());
        opConsultarAlumnos.addActionListener(new OyenteConsultarAlumnos());
        opEliminarAlumnos.addActionListener(new OyenteEliminarAlumnos());
        opModificarAlumnos.addActionListener(new OyenteModificarAlumnos());
        opListarAlumnos.addActionListener(new OyenteListarAlumnos());
        opOrdenarAlumnos.addActionListener(new OyenteOrdenarAlumnos());
      

        // Agregar los elementos al menu Gestion de alumnos
        MenuAlumnos.add(opRegistrarAlumnos);
        MenuAlumnos.add(opConsultarAlumnos);
        MenuAlumnos.add(opEliminarAlumnos);
        MenuAlumnos.add(opModificarAlumnos);
        MenuAlumnos.add(opListarAlumnos);
        MenuAlumnos.add(opOrdenarAlumnos);
        MenuAlumnos.add(opCargarAlumnos);
        
        // Agregar el menu Gestión de alumnos a la barra de menu
        barra.add(MenuAlumnos);
        
        // Establecer la barra de menu en el JFrame
        setJMenuBar(barra);
    }

    private void doMenuDocentes() {
        barra = new JMenuBar();
        MenuDocentes = new JMenu("Gestion de Docentes");
        opRegistrarDocentes = new JMenuItem("Registrar");
        opConsultarDocentes = new JMenuItem("Consultar");
        opEliminarDocentes = new JMenuItem("Eliminar");
        opModificarDocentes = new JMenuItem("Modificar");
        opListarDocentes = new JMenuItem("Listado");
        opOrdenarDocentes = new JMenuItem("Ordenar");
        opCargarDocentes = new JMenuItem("Cargar");
        
        opRegistrarDocentes.addActionListener(new OyenteRegistrarDocentes());
        opConsultarDocentes.addActionListener(new OyenteConsultarDocentes());
        opEliminarDocentes.addActionListener(new OyenteEliminarDocentes());
        opModificarDocentes.addActionListener(new OyenteModificarDocentes());
        opListarDocentes.addActionListener(new OyenteListarDocentes());
        opOrdenarDocentes.addActionListener(new OyenteOrdenarDocentes());
       

        MenuDocentes.add(opRegistrarDocentes);
        MenuDocentes.add(opConsultarDocentes);
        MenuDocentes.add(opEliminarDocentes);
        MenuDocentes.add(opModificarDocentes);
        MenuDocentes.add(opListarDocentes);
        MenuDocentes.add(opOrdenarDocentes);
        MenuDocentes.add(opCargarDocentes);
        barra.add(MenuDocentes);
        setJMenuBar(barra);
    }

    private void doMenuDirectivos() {
        barra = new JMenuBar();
        MenuDirectivos = new JMenu("Gestion de Directivos");
        opRegistrarDirectivos = new JMenuItem("Registrar");
        opConsultarDirectivos = new JMenuItem("Consultar");
        opEliminarDirectivos = new JMenuItem("Eliminar");
        opModificarDirectivos = new JMenuItem("Modificar");
        opListarDirectivos = new JMenuItem("Listado");
        opOrdenarDirectivos = new JMenuItem("Ordenar");
        opCargarDirectivos = new JMenuItem("Cargar");
        
        opRegistrarDirectivos.addActionListener(new OyenteRegistrarDirectivos());
        opConsultarDirectivos.addActionListener(new OyenteConsultarDirectivos());
        opEliminarDirectivos.addActionListener(new OyenteEliminarDirectivos());
        opModificarDirectivos.addActionListener(new OyenteModificarDirectivos());
        opListarDirectivos.addActionListener(new OyenteListarDirectivos());
        opOrdenarDirectivos.addActionListener(new OyenteOrdenarDirectivos());
 

        MenuDirectivos.add(opRegistrarDirectivos);
        MenuDirectivos.add(opConsultarDirectivos);
        MenuDirectivos.add(opEliminarDirectivos);
        MenuDirectivos.add(opModificarDirectivos);
        MenuDirectivos.add(opListarDirectivos);
        MenuDirectivos.add(opOrdenarDirectivos);
        MenuDirectivos.add(opCargarDirectivos);
        barra.add(MenuDirectivos);
        setJMenuBar(barra);
    }
    
   
    private void doMenuPrestamos() {
    	barra = new JMenuBar();
    	MenuPrestamos = new JMenu("Prestamos");
    	opPrestarLibros = new JMenuItem("Prestar libro");
    	opDevolucionLibros = new JMenuItem("Devolucion libro");
    	opRenovacionLibros = new JMenuItem("Renovacion libro");
    	
    	opPrestarLibros.addActionListener(new OyenteRegistrarPrestamos());
    	opPrestarLibros.addActionListener(new OyenteRegistrarPrestamos());
    	opDevolucionLibros.addActionListener(new OyenteDevolverPrestamos());
    	opRenovacionLibros.addActionListener(new OyenteRenovarPrestamos());

    	MenuPrestamos.add(opPrestarLibros);
    	MenuPrestamos.add(opDevolucionLibros);
    	MenuPrestamos.add(opRenovacionLibros);
    	barra.add(MenuPrestamos);
    	setJMenuBar(barra);
    }
  
    
    
    
	
}