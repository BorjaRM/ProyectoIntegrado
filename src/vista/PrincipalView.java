package vista;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.BoxLayout;

import java.awt.CardLayout;

public class PrincipalView extends JFrame{

	private JPanel contentpane;
	private JPanel vistas;
	//Referencias a las vistas
	final static String VERCLIENTES = "vista clientes";
	final static String NUEVOCLIENTE = "vista nuevo cliente";
	//Vistas
	ClientesView cv;
	NuevoClienteView ncv;

	/**
	 * Create the frame.
	 */
	public PrincipalView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(new BoxLayout(contentpane, BoxLayout.Y_AXIS));
		
		//Menu superior aplicacion
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//Opciones menu
		JMenu inicio = new JMenu("Inicio");
		JMenu clientes = new JMenu("Clientes");
		JMenu empleados = new JMenu("Empleados");
		JMenu reservas = new JMenu("Reservas");
		JMenu estancias = new JMenu("Estancias");
		JMenu incidencias = new JMenu("Incidencias");
		JMenu salir = new JMenu("Salir");
		menuBar.add(inicio);
		menuBar.add(clientes);
		menuBar.add(empleados);
		menuBar.add(reservas);
		menuBar.add(estancias);
		menuBar.add(incidencias);
		menuBar.add(salir);
		
		//Este panel contiene todas las vistas que se iran intercambiando
		vistas = new JPanel();
		contentpane.add(vistas);
		
		//Creamos las vistas
		cv = new ClientesView();
		ncv = new NuevoClienteView();
		
		//Las añadimos al panel
		vistas.add(cv, VERCLIENTES);
		vistas.add(ncv, NUEVOCLIENTE);
		vistas.setLayout(new CardLayout(0, 0));
				
	}

}
