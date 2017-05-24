package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.BD;
import modelo.dao.EstanciaDAO;
import modelo.dao.IncidenciaDAO;
import modelo.vo.EstanciaVO;
import modelo.vo.IncidenciaVO;
import vista.IncidenciasView;
import vista.Marco;
import vista.NuevaIncidenciaView;

public class ControladorIncidencias extends Controlador implements ListSelectionListener{
	private IncidenciasView iv;
	private NuevaIncidenciaView niv;
	private IncidenciaDAO consultas;
	
	public ControladorIncidencias(){
		frame.estableceControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand().toLowerCase()){
			case "ver incidencias": preparaIncidenciasView(); break;
			case "nueva incidencia": preparaNuevaIncidenciaView(); break;
			case "incidencia resuelta": preparaIncidenciaResuelta(); break;
			case "enviar": preparaInsertarIncidencia(); break;
			case "cancelar":
				cancelar(); break;
		}
	}
	private void preparaIncidenciaResuelta(){
		
	}
	
	private void preparaInsertarIncidencia() {
		if(niv.getTextArea().getText().isEmpty()){
			JOptionPane.showInputDialog("Rellena la descripcion");
		}else{
		IncidenciaVO incidencia = frame.getNiv().enviarDatosIncidencia();
		consultas.insertaIncidencia(incidencia);
		}
	}

	public void preparaIncidenciasView(){
		frame.creaIncidenciasView(this);
		this.iv=frame.getIv();
		frame.muestraIncidenciasView();
		frame.getIv().rellenaTablaIncidencias(consultas.getIncidenciaActivas(refHotel));
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