package vista;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import controlador.ControladorClientes;
import controlador.ControladorEmpleados;
import controlador.ControladorEstancias;
import controlador.ControladorIncidencias;
import controlador.ControladorUsuarios;
import controlador.ControladorReservas;

import java.awt.CardLayout;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.JMenuItem;

public class Marco extends JFrame{
	private static ResourceBundle bundle;
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
	final static String MODIFICAR_ESTANCIA = "vista modificar estancia";
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
	private ModificarEstanciaView mesv;
	private IncidenciasView iv;
	private NuevaIncidenciaView niv;
	//Botones barra superior
	private JMenu inicio,clientes,empleados,reservas,estancias,incidencias;
	private JMenuItem item_verClientes,item_nuevoCliente,item_verEmpleados,item_nuevoEmpleado,item_nuevaReserva;
	private JMenuItem item_verReservas,item_verEstancias,item_nuevaEstancia,item_verIncidencias,item_nuevaIncidencia;
	
	/**
	 * Create the frame.
	 * @param controlador 
	 */
	public Marco(ResourceBundle bundle) {
		Marco.bundle=bundle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		//Este panel contiene todas las vistas que se iran intercambiando
		vistas = new JPanel();
		vistas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(vistas);
		//Menu superior aplicacion
		JMenuBar barraSuperior = new JMenuBar();
		setJMenuBar(barraSuperior);
		//Opciones menu
		inicio = new JMenu(bundle.getString("jMenuInicio"));
		clientes = new JMenu(bundle.getString("jMenuClientes"));
		empleados = new JMenu(bundle.getString("jMenuEmpleados"));
		reservas = new JMenu(bundle.getString("jMenuReservas"));
		estancias = new JMenu(bundle.getString("jMenuEstancias"));
		incidencias = new JMenu(bundle.getString("jMenuIncidencias"));
		
		barraSuperior.add(inicio);
		barraSuperior.add(clientes);
		item_verClientes = new JMenuItem(bundle.getString("jMenuClientesVer"));
		item_verClientes.setActionCommand("Ver clientes");
		clientes.add(item_verClientes);
		item_nuevoCliente = new JMenuItem(bundle.getString("jMenuClientesNew"));
		item_nuevoCliente.setActionCommand("Nuevo cliente");
		clientes.add(item_nuevoCliente);
		
		barraSuperior.add(empleados);
		item_verEmpleados = new JMenuItem(bundle.getString("jMenuEmpleadosVer"));
		item_verEmpleados.setActionCommand("Ver empleados");
		empleados.add(item_verEmpleados);
		item_nuevoEmpleado = new JMenuItem(bundle.getString("jMenuEmpleadosNew"));
		item_nuevoEmpleado.setActionCommand("Nuevo empleado");
		empleados.add(item_nuevoEmpleado);
		
		barraSuperior.add(reservas);
		item_verReservas = new JMenuItem(bundle.getString("jMenuReservasVer"));
		item_verReservas.setActionCommand("Ver reservas");
		reservas.add(item_verReservas);
		item_nuevaReserva = new JMenuItem(bundle.getString("jMenuReservasNew"));
		item_nuevaReserva.setActionCommand("Nueva reserva");
		reservas.add(item_nuevaReserva);
		
		barraSuperior.add(estancias);
		item_verEstancias = new JMenuItem(bundle.getString("jMenuEstanciasVer"));
		item_verEstancias.setActionCommand("Ver estancias");
		estancias.add(item_verEstancias);
		item_nuevaEstancia = new JMenuItem(bundle.getString("jMenuEstanciasNew"));
		item_nuevaEstancia.setActionCommand("Nueva estancia");
		estancias.add(item_nuevaEstancia);
		
		barraSuperior.add(incidencias);
		item_verIncidencias = new JMenuItem(bundle.getString("jMenuIncidenciasVer"));
		item_verIncidencias.setActionCommand("Ver incidencias");					//************Cambiar lo de Issue por ticket**************
		incidencias.add(item_verIncidencias);
		item_nuevaIncidencia = new JMenuItem(bundle.getString("jMenuIncidenciasNew"));
		item_nuevaIncidencia.setActionCommand("Nueva incidencia");
		incidencias.add(item_nuevaIncidencia);
		
		barraSuperior.add(Box.createHorizontalGlue());
								
		//Creamos el cardLayout
		cl = new CardLayout(0, 0);
		vistas.setLayout(cl);				
	}
	
	public void creaPrincipalAdminView(Controlador c1, ControladorUsuarios c2){
		if(pav == null){
			pav = new PrincipalAdminView(bundle);
			pav.estableceControlador(c1);
			pav.estableceControlador(c2);
			vistas.add(pav,PRINCIPAL_ADMIN);
		}
	}
	
	public void muestraPrincipalAdminView(){
		cl.show(vistas,PRINCIPAL_ADMIN);
	}
	
	public void creaPrincipalEmpleadoView(){
		if(pev == null){
			pev = new PrincipalEmpleadoView();
			vistas.add(pev,PRINCIPAL_EMPLEADO);
		}
	}
	
	public void muestraPrincipalEmpleadoView(){
		empleados.setVisible(false);
		item_nuevaEstancia.setVisible(false);
		cl.show(vistas,PRINCIPAL_EMPLEADO);
	}
	
	public void creaHotelView(ControladorUsuarios controlador){
		if(hv == null){
			hv = new NuevoHotelView(bundle);
			hv.estableceControlador(controlador);
			vistas.add(hv,NUEVO_HOTEL);
		}
	}
	
	public void muestraHotelView(){
		cl.show(vistas,NUEVO_HOTEL);
	}
	
	public void creaClientesView(ControladorClientes controlador){
		if(cv == null){
			cv = new ClientesView(bundle);
			cv.estableceControlador(controlador);
			vistas.add(cv,VER_CLIENTES);
		}
	}
	
	public void muestraClientesView(){
		cl.show(vistas,VER_CLIENTES);
	}
	
	public void creaNuevoClienteView(ControladorClientes controlador){
		if(ncv == null){
			ncv = new NuevoClienteView(bundle);
			ncv.estableceControlador(controlador);
			vistas.add(ncv,NUEVO_CLIENTE);
		}
	}
	
	public void muestraNuevoClientesView(){
		cl.show(vistas,NUEVO_CLIENTE);
	}
	
	public void creaModificarClienteView(ControladorClientes controlador){
		if(mcv == null){
			mcv = new ModificarClienteView(bundle);
			mcv.estableceControlador(controlador);
			vistas.add(mcv,MODIFICAR_CLIENTE);
		}
	}
	
	public void muestraModificarClienteView(){
		cl.show(vistas,MODIFICAR_CLIENTE);
	}
	
	public void creaEmpleadosView(ControladorEmpleados controlador){
		if(ev == null){
			ev = new EmpleadosView();
			ev.estableceControlador(controlador);
			vistas.add(ev,VER_EMPLEADOS);
		}
	}
	
	public void muestraEmpleadosView(){
		cl.show(vistas, VER_EMPLEADOS);
	}
	
	public void creaNuevoEmpleadoView(ControladorEmpleados controlador){
		if(nev == null){
			nev = new NuevoEmpleadoView();
			nev.estableceControlador(controlador);
			vistas.add(nev,NUEVO_EMPLEADO);
		}
	}
	
	public void muestraNuevoEmpleadoView(){
		cl.show(vistas, NUEVO_EMPLEADO);
	}
	
	public void creaModificarEmpeladoView(ControladorEmpleados controlador){
		if(mev == null){
			mev = new ModificarEmpleadoView();
			mev.estableceControlador(controlador);
			vistas.add(mev,MODIFICAR_EMPLEADO);
		}
	}
	
	public void muestraModificarEmpleadoView(){
		cl.show(vistas, MODIFICAR_EMPLEADO);
	}
	
	public void creaReservasView(ControladorReservas controlador){
		if(rv == null){
			rv = new ReservasView();
			rv.estableceControlador(controlador);
			vistas.add(rv,VER_RESERVAS);
		}
	}
	
	public void muestraReservasView(){
		cl.show(vistas, VER_RESERVAS);
	}
	
	public void creaNuevaReservaView(ControladorReservas controlador){
		if(nrv == null){
			nrv = new NuevaReservaView();
			nrv.estableceControlador(controlador);
			vistas.add(nrv,NUEVA_RESERVA);
		}
	}
	
	public void muestraNuevaReservaView(){
		cl.show(vistas, NUEVA_RESERVA);
	}
	
	public void creaIncidenciasView(ControladorIncidencias controlador){
		if(iv == null){
			iv = new IncidenciasView();
			iv.estableceControlador(controlador);
			vistas.add(iv,VER_INCIDENCIAS);
		}
	}
	
	public void muestraIncidenciasView(){
		cl.show(vistas, VER_INCIDENCIAS);
	}
	
	public void creaNuevaIncidenciaView(ControladorIncidencias controlador){
		if(niv == null){
			niv = new NuevaIncidenciaView();
			niv.estableceControlador(controlador);
			vistas.add(niv,NUEVA_INCIDENCIA);
		}

	}
	
	public void muestraNuevaIncidenciaView(){
		cl.show(vistas, NUEVA_INCIDENCIA);
	}
	
	public void creaEstanciasView(ControladorEstancias controlador){
		if(esv == null){
			esv = new EstanciasView();
			esv.estableceControlador(controlador);
			vistas.add(esv,VER_ESTANCIAS);
		}
	}
	
	public void muestraEstanciasView(){
		cl.show(vistas, VER_ESTANCIAS);

	}
	
	public void creaNuevaEstanciaView(ControladorEstancias controlador){
		if(nesv == null){
			nesv = new NuevaEstanciaView();
			nesv.estableceControlador(controlador);
			vistas.add(nesv,NUEVA_ESTANCIA);
		}

	}
	
	public void muestraNuevaEstanciaView(){
		cl.show(vistas, NUEVA_ESTANCIA);
	}
	
	public void creaModificaEstanciaView(ControladorEstancias controlador){
		if(mesv == null){
			mesv = new ModificarEstanciaView();
			mesv.estableceControlador(controlador);
			vistas.add(mesv,MODIFICAR_ESTANCIA);
		}
	}
	
	public void muestraModificaEstancia(){
		cl.show(vistas, MODIFICAR_ESTANCIA);
	}
	
	public void estableceControlador(ControladorUsuarios controlador){
		this.inicio.addMouseListener(controlador);		
	}
	
	public void estableceControlador(ControladorClientes controlador){
		this.item_verClientes.addActionListener(controlador);
		this.item_nuevoCliente.addActionListener(controlador);
	}
	
	public void estableceControlador(ControladorEmpleados controlador){
		this.item_verEmpleados.addActionListener(controlador);
		this.item_nuevoEmpleado.addActionListener(controlador);
	}
	
	public void estableceControlador(ControladorReservas controlador){
		this.item_nuevaReserva.addActionListener(controlador);
		this.item_verReservas.addActionListener(controlador);
	}
	
	public void estableceControlador(ControladorEstancias controlador){
		this.item_verEstancias.addActionListener(controlador);
		this.item_nuevaEstancia.addActionListener(controlador);
	}
	
	public void estableceControlador(ControladorIncidencias controlador){
		this.item_verIncidencias.addActionListener(controlador);
		this.item_nuevaIncidencia.addActionListener(controlador);
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

	public IncidenciasView getIv() {
		return iv;
	}

	public NuevaIncidenciaView getNiv() {
		return niv;
	}

	public EstanciasView getEsv() {
		return esv;
	}

	public NuevaEstanciaView getNesv() {
		return nesv;
	}

	public ModificarEstanciaView getMesv() {
		return mesv;
	}

	public PrincipalAdminView getPav() {
		return pav;
	}

	public NuevoHotelView getHv() {
		return hv;
	}

	public PrincipalEmpleadoView getPev() {
		return pev;
	}	
	
}
