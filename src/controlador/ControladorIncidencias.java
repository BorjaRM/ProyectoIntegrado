package controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.dao.IncidenciaDAO;
import modelo.vo.EstanciaVO;
import modelo.vo.IncidenciaVO;
import vista.IncidenciasView;
import vista.NuevaIncidenciaView;

public class ControladorIncidencias extends Controlador implements ListSelectionListener{
	private IncidenciasView iv;
	private NuevaIncidenciaView niv;
	private IncidenciaDAO consultas;
	
	public ControladorIncidencias(){
		frame.estableceControlador(this);
		consultas=new IncidenciaDAO();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand().toLowerCase()){
			case "ver incidencias": preparaIncidenciasView(); break;
			case "nueva incidencia": preparaNuevaIncidenciaView(); break;
			case "incidencia resuelta": preparaIncidenciaResuelta();
										preparaIncidenciasView();
										break;
			case "enviar": preparaInsertarIncidencia();
							preparaIncidenciasView();
							break;
			case "cancelar":
				cancelar(); break;
		}
	}
	
	private void preparaIncidenciaResuelta(){
		int posicionSeleccionada = iv.getTable().getSelectedRow();
		if(posicionSeleccionada != -1){
			consultas.modificaEstadoIncidencia(posicionSeleccionada,refHotel);
		}else{
			JOptionPane.showMessageDialog(null, "Error, selecciona la incidencia");
		}
	}
	
	private void preparaInsertarIncidencia() {
		if(niv.getTextArea().getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Rellena la descripcion");
		}else{
		
		EstanciaVO estancia = (EstanciaVO) niv.getComboBox().getSelectedItem();
		int codigoEstancia = estancia.getId();
		String descripcion = niv.getTextArea().getText();
		String estado = "activa";
		String fecha = consultas.getFechayHora();
		IncidenciaVO incidencia = new IncidenciaVO(0,descripcion,estado,fecha,codigoEstancia);
			
		consultas.insertaIncidencia(incidencia);
		}
	}

	public void preparaIncidenciasView(){
		frame.creaIncidenciasView(this);
		this.iv=frame.getIv();
		frame.muestraIncidenciasView();
		iv.rellenaTablaIncidencias(consultas.getTablaIncidencias(refHotel),consultas.getEstancias(refHotel));

	}
	

	public void preparaNuevaIncidenciaView(){
		frame.creaNuevaIncidenciaView(this);
		this.niv=frame.getNiv();
		frame.muestraNuevaIncidenciaView();
		ArrayList <EstanciaVO> Estancias = consultas.getEstancias(refHotel);
		niv.rellenaComboBox(Estancias);
		
	}
	
	public void cancelar(){
		if(iv == null){
			if(esAdministrador)
				frame.muestraPrincipalAdminView();		
			else
				frame.muestraPrincipalEmpleadoView();
		}else
			frame.muestraIncidenciasView();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub

	}
	
}