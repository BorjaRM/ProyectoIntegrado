package controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.dao.EstanciaDAO;
import modelo.dao.HabitacionDAO;
import modelo.vo.EstanciaVO;
import modelo.vo.HabitacionVO;
import modelo.vo.TipoEstancia;
import modelo.vo.TipoHabitacion;
import vista.EstanciasView;
import vista.ModificarEstanciaView;
import vista.NuevaEstanciaView;

public class ControladorEstancias extends Controlador implements ListSelectionListener{
	private EstanciasView esv;
	private NuevaEstanciaView nesv;
	private ModificarEstanciaView mesv;
	private HabitacionDAO consultasHabitacion;
	private EstanciaDAO consultasEstancia;
	private TipoEstancia tipoEstanciaSeleccionada;
	private EstanciaVO estanciaSeleccionada;

	public ControladorEstancias(){
		Controlador.frame.estableceControlador(this);
		consultasHabitacion = new HabitacionDAO();
		consultasEstancia = new EstanciaDAO();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand().toLowerCase()){
			case "ver estancias": preparaEstanciasView(); break;
			case "nueva estancia": preparaNuevaEstanciaView(); break;
			case "modificar estancia": preparaModificarEstanciaView(); break;
			case "eliminar estancia": eliminarEstancia(); break;
			case "nueva zona comun": insertarZonaComun(); break;
			case "nueva habitacion": insertarHabitacion(); break;
			case "modificar": modificarEstancia(); break;
			case "cancelar": cancelar(); break;
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
		preparaEstanciasView();
	}
	
	public void insertarZonaComun(){
		EstanciaVO estancia = frame.getNesv().enviarDatosUsoComun();
		estancia.setCod_hotel(refHotel);
		consultasEstancia.insertEstancia(estancia);
		preparaEstanciasView();
	}
	
	public void preparaModificarEstanciaView(){
		frame.creaModificaEstanciaView(this);
		this.mesv=frame.getMesv();
		removePreviousData();
		disableFields();
		rellenaDatosParaEditar();
		frame.muestraModificaEstancia();
	}
	
	public void removePreviousData(){
		mesv.getTxt_Nombre().setText("");
		mesv.getDesplegable_tipo().setSelectedIndex(0);
		mesv.getSpinner_plazas().setValue(0);
		mesv.getSpinner_precio().setValue(0);
		mesv.getText_descripcion().setText("");
		mesv.getTxt_nombre_uso().setText("");
	}
	
	public void disableFields(){
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
			mesv.getTxt_Nombre().setText(this.estanciaSeleccionada.getNombre());
			//EL DESPLEGABLE NO SE RELLENA, COMPROBAR TIPOS STRING - ENUM
			//mesv.getDesplegable_tipo().setSelectedItem(this.estanciaSeleccionada.getTipo());
			mesv.getSpinner_plazas().setValue(((HabitacionVO) this.estanciaSeleccionada).getPlazas());
			mesv.getSpinner_precio().setValue(((HabitacionVO) this.estanciaSeleccionada).getPrecio());
			mesv.getText_descripcion().setText(((HabitacionVO) this.estanciaSeleccionada).getDescripcion());			
		}else if(tipoEstanciaSeleccionada == TipoEstancia.USO_COMUN){
			mesv.getTxt_nombre_uso().setText(this.estanciaSeleccionada.getNombre());
		}
	}
	
	public void modificarEstancia(){
		if(tipoEstanciaSeleccionada == TipoEstancia.HABITACION){
			HabitacionVO h = (HabitacionVO) estanciaSeleccionada;
			h.setNombre(mesv.getTxt_Nombre().getText());
			h.setClasificacion(mesv.getDesplegable_tipo().getSelectedItem().toString());
			h.setPlazas((Integer) mesv.getSpinner_plazas().getValue());
			h.setPrecio((Integer) mesv.getSpinner_precio().getValue());
			h.setDescripcion(mesv.getText_descripcion().getText());
			consultasEstancia.updateEstancia(estanciaSeleccionada);
			consultasHabitacion.updateHabitacion(estanciaSeleccionada);
		}else if(tipoEstanciaSeleccionada == TipoEstancia.USO_COMUN){
			estanciaSeleccionada.setNombre(mesv.getTxt_nombre_uso().getText());
			consultasEstancia.updateEstancia(estanciaSeleccionada);
		}
		preparaEstanciasView();
	}
	
	public void eliminarEstancia(){
		if(this.estanciaSeleccionada != null){
			int eleccion = JOptionPane.showConfirmDialog(null, "Confirma que deseas eliminar esta estancia", "Borrar registro", JOptionPane.YES_NO_OPTION);
			if(eleccion == JOptionPane.YES_OPTION) {
				if(tipoEstanciaSeleccionada == TipoEstancia.HABITACION){
					JOptionPane.showMessageDialog(null, estanciaSeleccionada.getNombre()+" eliminada");
					consultasEstancia.eliminarEstancia(this.estanciaSeleccionada);
				}else if(tipoEstanciaSeleccionada == TipoEstancia.USO_COMUN){
					JOptionPane.showMessageDialog(null, estanciaSeleccionada.getNombre()+" eliminada");
					consultasEstancia.eliminarEstancia(this.estanciaSeleccionada);
				}
				preparaEstanciasView();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha eliminado ningun registro");
			}
		}else{
			JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
		}
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
			int filaSeleccionada;
			
			//Ha seleccionado una habitacion
			if(refTablaHabitacion == refTablaSeleccionada){
				this.tipoEstanciaSeleccionada = TipoEstancia.HABITACION;
				filaSeleccionada = esv.getTabla_habitaciones().getSelectedRow();
				if(filaSeleccionada > -1){
					ArrayList<HabitacionVO> habs = consultasHabitacion.getHabitaciones(refHotel);
					this.estanciaSeleccionada = habs.get(esv.getTabla_habitaciones().convertRowIndexToModel(filaSeleccionada));
				}else
					this.estanciaSeleccionada = null;
			//Ha seleccionado una estancia de uso comun
			}else if(refTablaUsoComun == refTablaSeleccionada){
				this.tipoEstanciaSeleccionada = TipoEstancia.USO_COMUN;
				filaSeleccionada = esv.getTabla_estancias().getSelectedRow();
				if(filaSeleccionada > -1){
					ArrayList<EstanciaVO> estancias = consultasEstancia.getEstanciasUsoComun(refHotel);
					this.estanciaSeleccionada = estancias.get(esv.getTabla_estancias().convertRowIndexToModel(filaSeleccionada));
				}else
					this.estanciaSeleccionada = null;
			}
		}
	}	

}