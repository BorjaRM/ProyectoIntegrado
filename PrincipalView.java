package vista;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrincipal;

import javax.swing.BoxLayout;

import java.awt.CardLayout;

public class PrincipalView extends JFrame{

	private JPanel contentpane;
	private JPanel vistas;
	CardLayout cl;
	//Referencias a las vistas
	final static String PRINCIPAL_ADMIN = "vista principal admin";
	final static String PRINCIPAL_EMPLEADO = "vista principal empleado";
	final static String NUEVOHOTEL = "vista nuevo hotel";

	final static String VERCLIENTES = "vista clientes";
	final static String NUEVOCLIENTE = "vista nuevo cliente";
	//Vistas
	PrincipalAdminView pav;
	PrincipalEmpleadoView pev;
	HotelView hv;

	ClientesView cv;
	NuevoClienteView ncv;
	
	//Botones barra superior
	private JMenu inicio;
	private JMenu clientes;
	private JMenu empleados;
	private JMenu reservas;
	private JMenu estancias;
	private JMenu incidencias;
	private JMenu salir;
	private JMenuItem salir2;
	

	/**
	 * Create the frame.
	 * @param esAdministrador 
	 */
	public PrincipalView(boolean esAdministrador) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(new BoxLayout(contentpane, BoxLayout.Y_AXIS));

		//Menu superior aplicacion
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//Opciones menu
		inicio = new JMenu("Inicio");
		clientes = new JMenu("Clientes");
		empleados = new JMenu("Empleados");
		reservas = new JMenu("Reservas");
		estancias = new JMenu("Estancias");
		incidencias = new JMenu("Incidencias");
		salir = new JMenu("Salir");
		salir2 = new JMenuItem("Salir2");
		salir.setActionCommand("Salir");
		menuBar.add(inicio);
		menuBar.add(clientes);
		menuBar.add(empleados);
		menuBar.add(reservas);
		menuBar.add(estancias);
		menuBar.add(incidencias);
		menuBar.add(salir);
		menuBar.add(salir2);
		
		//Este panel contiene todas las vistas que se iran intercambiando
		vistas = new JPanel();
		contentpane.add(vistas);
		
		//Creamos las vistas
		pav = new PrincipalAdminView();
		pev = new PrincipalEmpleadoView();
		hv = new HotelView();

		cv = new ClientesView();
		ncv = new NuevoClienteView();
		
		
		//Creamos el cardLayout
		cl = new CardLayout(0, 0);
		vistas.setLayout(cl);
		
		//Las añadimos al panel
		vistas.add(pav,PRINCIPAL_ADMIN);
		vistas.add(pev,PRINCIPAL_EMPLEADO);
		vistas.add(hv,NUEVOHOTEL);

		vistas.add(cv, VERCLIENTES);
		vistas.add(ncv, NUEVOCLIENTE);
		
		if(!esAdministrador){
			empleados.setVisible(false);
			cl.show(vistas,PRINCIPAL_EMPLEADO);
		}
	}
	
	public void estableceControlador(ControladorPrincipal controlador) {
		/*this.inicio.addMenuListener(controlador);
		this.clientes.addMenuListener(controlador);
		this.empleados.addMenuListener(controlador);
		this.reservas.addMenuListener(controlador);
		this.estancias.addMenuListener(controlador);
		this.incidencias.addMenuListener(controlador);
		this.salir.addMenuListener(controlador);*/
		this.salir.addActionListener(controlador);
		this.salir.addMenuListener(controlador);
		this.salir2.addActionListener(controlador);

	}
	

}
