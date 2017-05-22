package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
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
import modelo.vo.TipoEstancia;
import modelo.vo.TipoHabitacion;
import vista.EstanciasView;
import vista.Marco;
import vista.ModificarEstanciaView;
import vista.NuevaEstanciaView;

public class ControladorEstancias extends Controlador implements ListSelectionListener{
	private EstanciasView esv;
	private NuevaEstanciaView nesv;
	private ModificarEstanciaView mesv;
	private HabitacionDAO consultasHabitacion;
	private EstanciaDAO consultasEstancia;
	private TipoEstancia tipoEstanciaSeleccionada;
	private HabitacionVO habitacionSeleccionada;
	private EstanciaVO estanciaSeleccionada;

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
		removeData();
		bloqueaCampos();
		rellenaDatosParaEditar();
		frame.muestraModificaEstancia();
	}
	
	public void removeData(){
		mesv.getTxt_Nombre().setText("");
		mesv.getDesplegable_tipo().setSelectedIndex(0);
		mesv.getSpinner_plazas().setValue(0);
		mesv.getSpinner_precio().setValue(0);
		mesv.getText_descripcion().setText("");
		mesv.getTxt_nombre_uso().setText("");
	}
	
	public void bloqueaCampos(){
		if(tipoEstanciaSeleccionada == TipoEstancia.USO_COMUN){
			mesv.getTxt_Nombre().setEnabled(false);
			mesv.getDesplegable_tipo().setEnabled(false);
			mesv.getSpinner_plazas().setEnabled(false);
			mesv.getSpinner_precio().setEnabled(false);
			mesv.getText_descripcion().setEnabled(false);	
			mesv.getTxt_nombre_uso().setEnabled(true);
		}else if(tipoEstanciaSeleccionada == TipoEstancia.HABITACION){
			mesv.getTxt_Nombre().setEnabled(true);
			mesv.getDesplegable_tipo().setEnabled(true);
			mesv.getSpinner_plazas().setEnabled(true);
			mesv.getSpinner_precio().setEnabled(true);
			mesv.getText_descripcion().setEnabled(true);
			mesv.getTxt_nombre_uso().setEnabled(false);
		}
	}	
	
	public void rellenaDatosParaEditar(){
		if(tipoEstanciaSeleccionada == TipoEstancia.HABITACION){
			mesv.getTxt_Nombre().setText(this.habitacionSeleccionada.getNombre());
			//EL DESPLEGABLE NO SE RELLENA, COMPROBAR TIPOS STRING - ENUM
			//mesv.getDesplegable_tipo().setSelectedItem(this.habitacionSeleccionada.getClasificacion());
			mesv.getSpinner_plazas().setValue(this.habitacionSeleccionada.getPlazas());
			mesv.getSpinner_precio().setValue(this.habitacionSeleccionada.getPrecio());
			mesv.getText_descripcion().setText(this.habitacionSeleccionada.getDescripcion());			
		}else if(tipoEstanciaSeleccionada == TipoEstancia.USO_COMUN){
			mesv.getTxt_nombre_uso().setText(this.estanciaSeleccionada.getNombre());
		}
	}
	
	public void eliminarEstancia(){
		esv.getTabla_habitaciones().clearSelection();
	}
	
	public void cancelar(){
		if(esv == null)
			frame.muestraPrincipalAdminView();		
		else
			frame.muestraEstanciasView();
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!e.getValueIsAdjusting()){	
			DefaultListSelectionModel dlsm = (DefaultListSelectionModel) e.getSource();
			int refTablaSeleccionada = dlsm.hashCode();
			int refTablaHabitacion = esv.getTabla_habitaciones().getSelectionModel().hashCode();
			int refTablaUsoComun = esv.getTabla_estancias().getSelectionModel().hashCode();
			int seleccion;
			
			if(refTablaHabitacion == refTablaSeleccionada){
				this.tipoEstanciaSeleccionada = TipoEstancia.HABITACION;
				seleccion = esv.getTabla_habitaciones().getSelectedRow();
				System.out.println(seleccion);
				if(seleccion > -1){
					this.estanciaSeleccionada = null;
					ArrayList<HabitacionVO> habs = consultasHabitacion.getHabitaciones(refHotel);
					this.habitacionSeleccionada = habs.get(esv.getTabla_habitaciones().convertRowIndexToModel(seleccion));
					System.out.println("Fila: "+seleccion+" "+habitacionSeleccionada.getNombre());
				}else
					this.habitacionSeleccionada = null;
			}else if(refTablaUsoComun == refTablaSeleccionada){
				this.tipoEstanciaSeleccionada = TipoEstancia.USO_COMUN;
				seleccion = esv.getTabla_estancias().getSelectedRow();
				System.out.println(seleccion);
				if(seleccion > -1){
					this.habitacionSeleccionada = null;
					ArrayList<EstanciaVO> estancias = consultasEstancia.getEstanciasUsoComun(refHotel);
					this.estanciaSeleccionada = estancias.get(esv.getTabla_estancias().convertRowIndexToModel(seleccion));
					System.out.println("Fila: "+seleccion+" "+estanciaSeleccionada.getNombre());
				}else
					this.estanciaSeleccionada = null;
			}
		}
	}	

}