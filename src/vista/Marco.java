package vista;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrincipal;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class Marco extends JFrame{

	private JPanel vistas;
	private CardLayout cl;
	//Referencias a las vistas
	final static String PRINCIPAL_ADMIN = "vista principal admin";
	final static String PRINCIPAL_EMPLEADO = "vista principal empleado";
	final static String NUEVO_HOTEL = "vista nuevo hotel";
	final static String VER_CLIENTES = "vista clientes";
	final static String NUEVO_CLIENTE = "vista nuevo cliente";
	final static String MODIFICAR_CLIENTE = "vista modificar cliente";
	final static String VER_EMPLEADOS = "vista empleados";
	final static String NUEVO_EMPLEADO = "vista nuevo empleado";
	final static String MODIFICAR_EMPLEADO = "vista modificar empleado";
	final static String VER_RESERVAS = "vista reservas";
	final static String NUEVA_RESERVA = "vista nueva reserva";
	final static String VER_ESTANCIAS = "vista estancias";
	final static String NUEVA_ESTANCIA = "vista nueva estancia";
	final static String VER_INCIDENCIAS = "vista incidencias";
	final static String NUEVA_INCIDENCIA = "vista nueva incidencia";
	//Vistas
	private PrincipalAdminView pav;
	private PrincipalEmpleadoView pev;
	private NuevoHotelView hv;
	private ClientesView cv;
	private NuevoClienteView ncv;
	private ModificarClienteView mcv;
	private EmpleadosView ev;
	private NuevoEmpleadoView nev;
	private ModificarEmpleadoView mev;
	private ReservasView rv;
	private NuevaReservaView nrv;
	private EstanciasView esv;
	private NuevaEstanciaView nesv;
	private IncidenciasView iv;
	private NuevaIncidenciaView niv;
	//Botones barra superior
	private JMenu inicio,clientes,empleados,reservas,estancias,incidencias;
	private Component horizontalGlue;
	private JMenuItem item_verClientes;
	private JMenuItem item_nuevoCliente;
	private JMenuItem item_verEmpleados;
	private JMenuItem item_nuevoEmpleado;
	private JMenuItem item_nuevaReserva;
	private JMenuItem item_verReservas;
	private JMenuItem item_verEstancias;
	private JMenuItem item_nuevaEstancia;
	private JMenuItem item_verIncidencias;
	private JMenuItem item_nuevaIncidencia;
	
	/**
	 * Create the frame.
	 * @param esAdministrador 
	 */
	public Marco() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		//Este panel contiene todas las vistas que se iran intercambiando
		vistas = new JPanel();
		vistas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(vistas);
		//Menu superior aplicacion
		JMenuBar barraSuperior = new JMenuBar();
		setJMenuBar(barraSuperior);
		//Opciones menu
		inicio = new JMenu("Inicio");
		clientes = new JMenu("Clientes");
		empleados = new JMenu("Empleados");
		reservas = new JMenu("Reservas");
		estancias = new JMenu("Estancias");
		incidencias = new JMenu("Incidencias");
		
		barraSuperior.add(inicio);
		barraSuperior.add(clientes);
		
		item_verClientes = new JMenuItem("Ver clientes");
		clientes.add(item_verClientes);
		
		item_nuevoCliente = new JMenuItem("Nuevo cliente");
		clientes.add(item_nuevoCliente);
		barraSuperior.add(empleados);
		
		item_verEmpleados = new JMenuItem("Ver Empleados");
		empleados.add(item_verEmpleados);
		
		item_nuevoEmpleado = new JMenuItem("Nuevo Empleado");
		empleados.add(item_nuevoEmpleado);
		barraSuperior.add(reservas);
		
		item_verReservas = new JMenuItem("Ver Reservas");
		reservas.add(item_verReservas);
		
		item_nuevaReserva = new JMenuItem("Nueva Reserva");
		reservas.add(item_nuevaReserva);
		barraSuperior.add(estancias);
		
		item_verEstancias = new JMenuItem("Ver Estancias");
		estancias.add(item_verEstancias);
		
		item_nuevaEstancia = new JMenuItem("Nueva Estancia");
		estancias.add(item_nuevaEstancia);
		barraSuperior.add(incidencias);
		
		item_verIncidencias = new JMenuItem("Ver Incidencias");
		incidencias.add(item_verIncidencias);
		
		item_nuevaIncidencia = new JMenuItem("Nueva Incidencia");
		incidencias.add(item_nuevaIncidencia);
		barraSuperior.add(Box.createHorizontalGlue());
					
		//Creamos las vistas
		cv = new ClientesView();
		ncv = new NuevoClienteView();
		mcv = new ModificarClienteView();
		ev = new EmpleadosView();
		nev = new NuevoEmpleadoView();
		mev = new ModificarEmpleadoView();
		rv = new ReservasView();
		nrv = new NuevaReservaView();
		esv = new EstanciasView();
		nesv = new NuevaEstanciaView();
		iv = new IncidenciasView();
		niv = new NuevaIncidenciaView();
			
		//Creamos el cardLayout
		cl = new CardLayout(0, 0);
		vistas.setLayout(cl);
			
		//Las añadimos al panel
		vistas.add(cv,VER_CLIENTES);
		vistas.add(ncv,NUEVO_CLIENTE);
		vistas.add(mcv,MODIFICAR_CLIENTE);
		vistas.add(ev,VER_EMPLEADOS);
		vistas.add(nev,NUEVO_EMPLEADO);
		vistas.add(mev,MODIFICAR_EMPLEADO);
		vistas.add(rv,VER_RESERVAS);
		vistas.add(nrv,NUEVA_RESERVA);
		vistas.add(esv,VER_ESTANCIAS);
		vistas.add(nesv,NUEVA_ESTANCIA);
		vistas.add(iv,VER_INCIDENCIAS);
		vistas.add(niv,NUEVA_INCIDENCIA);
				
	}
	
	public void creaVistaPrincipal(){
		if(pav == null){
			pav = new PrincipalAdminView();
			vistas.add(pav,PRINCIPAL_ADMIN);
		}
		if(pev == null){
			pev = new PrincipalEmpleadoView();
			vistas.add(pev,PRINCIPAL_EMPLEADO);
		}
	}
	
	public void muestraVistaPrincipal(boolean esAdministrador){
		if(esAdministrador){
			cl.show(vistas,PRINCIPAL_ADMIN);
		}else{
			empleados.setVisible(false);
			cl.show(vistas,PRINCIPAL_EMPLEADO);
		}
	}
	
	public void creaVistaHotel(){
		if(hv == null){
			hv = new NuevoHotelView();
			vistas.add(hv,NUEVO_HOTEL);
		}
		cl.show(vistas,NUEVO_HOTEL);
	}
	
	public void creaVistaClientes(){
		cl.show(vistas,VER_CLIENTES);
	}
	
	public void cancelar(){
		System.out.println("No esta programado");
	}
	
	public void estableceControlador(ControladorPrincipal controlador){
		this.inicio.addActionListener(controlador);
	}
	
	public PrincipalAdminView getPav() {
		return pav;
	}

	public PrincipalEmpleadoView getPev() {
		return pev;
	}

	public NuevoHotelView getHv() {
		return hv;
	}

	public ClientesView getCv() {
		return cv;
	}

	public NuevoClienteView getNcv() {
		return ncv;
	}

	public ModificarClienteView getMcv() {
		return mcv;
	}

	public EmpleadosView getEv() {
		return ev;
	}

	public NuevoEmpleadoView getNev() {
		return nev;
	}

	public ModificarEmpleadoView getMev() {
		return mev;
	}

	public ReservasView getRv() {
		return rv;
	}

	public NuevaReservaView getNrv() {
		return nrv;
	}

	public EstanciasView getEsv() {
		return esv;
	}

	public NuevaEstanciaView getNesv() {
		return nesv;
	}

	public IncidenciasView getIv() {
		return iv;
	}

	public NuevaIncidenciaView getNiv() {
		return niv;
	}
	
	
}
