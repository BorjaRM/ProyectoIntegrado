package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import modelo.BD;
import modelo.dao.EstanciaDAO;
import modelo.dao.HabitacionDAO;
import modelo.vo.EstanciaVO;
import modelo.vo.HabitacionVO;
import vista.EstanciasView;
import vista.Marco;
import vista.ModificarEstanciaView;
import vista.NuevaEstanciaView;

public class ControladorEstancias extends Controlador{
	private EstanciasView esv;
	private NuevaEstanciaView nesv;
	private ModificarEstanciaView mesv;
	private HabitacionDAO consultasHabitacion;
	private EstanciaDAO consultasEstancia;

	public ControladorEstancias(){
		Controlador.frame.estableceControlador(this);
		consultasHabitacion = new HabitacionDAO(Controlador.modelo);
		consultasEstancia = new EstanciaDAO(Controlador.modelo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Ver Estancias": preparaEstanciasView(); break;
			case "Nueva Estancia": preparaNuevaEstanciaView(); break;
			case "Modificar Estancia": preparaModificarEstanciaView(); break;
			case "Eliminar Estancia": eliminarEstancia(); break;
			case "Nueva zona comun": insertarZonaComun(); break;
			case "Nueva habitacion": insertarHabitacion(); break;
			case "Modificar": /* **************************************************************************** */ break;
			case "Cancelar": cancelar(); break;
		}
	}
	
	public void preparaEstanciasView(){
		frame.creaEstanciasView(this);
		this.esv=frame.getEsv();
		if(!esAdministrador){
			esv.ocultaBotonNuevaEstancia();
			esv.ocultaBotonModificarEstancia();
			esv.ocultaBotonEliminarEstancia();
		}
		frame.getEsv().rellenaTablahabitaciones(consultasHabitacion.getHabitaciones(refHotel));
		frame.getEsv().rellenaTablaEstancias(consultasEstancia.getEstanciasUsoComun(refHotel));
		frame.muestraEstanciasView();
	}
	
	public void preparaNuevaEstanciaView(){
		frame.creaNuevaEstanciaView(this);
		this.nesv=frame.getNesv();
		frame.muestraNuevaEstanciaView();
	}
	
	public void insertarHabitacion(){
		HabitacionVO habitacion = frame.getNesv().enviarDatosHabitacion();
		habitacion.setCod_hotel(refHotel);
		consultasEstancia.insertEstancia(habitacion);
		consultasHabitacion.insertHabitacion(habitacion);
	}
	
	public void insertarZonaComun(){
		EstanciaVO estancia = frame.getNesv().enviarDatosUsoComun();
		estancia.setCod_hotel(refHotel);
		consultasEstancia.insertEstancia(estancia);
	}
	
	public void preparaModificarEstanciaView(){
		frame.creaModificaEstanciaView(this);
		this.mesv=frame.getMesv();
		frame.muestraModificaEstancia();
	}
	
	public void modificarEstancia(){
		System.out.println("quieres modificar");
	}
	
	public void eliminarEstancia(){
		System.out.println("quieres borrar");
		System.out.println(esv.getTabla_habitaciones().getSelectedRow());
	}
	
	public void cancelar(){
		if(esv == null)
			frame.muestraPrincipalAdminView();		
		else
			frame.muestraEstanciasView();
	}
}