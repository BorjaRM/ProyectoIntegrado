package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.BD;
import modelo.dao.EstanciaDAO;
import modelo.vo.EstanciaVO;
import vista.IncidenciasView;
import vista.Marco;
import vista.NuevaIncidenciaView;

public class ControladorIncidencias extends Controlador{
	private IncidenciasView iv;
	private NuevaIncidenciaView niv;

	public ControladorIncidencias(){
		frame.estableceControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand().toLowerCase()){
			case "ver incidencias": preparaIncidenciasView(); break;
			case "nueva incidencia": preparaNuevaIncidenciaView(); break;
			case "incidencia resuelta": /* **************************************************************************** */ break;
			case "enviar": preparaInsertarIncidencia(); break;
			case "cancelar": cancelar(); break;
		}
	}
	
	private void preparaInsertarIncidencia() {
		if(niv.getTextArea().getText().isEmpty()){
			JOptionPane.showInputDialog("Rellena la descripcion");
		}else{
			
		}
	}

	public void preparaIncidenciasView(){
		frame.creaIncidenciasView(this);
		this.iv=frame.getIv();
		frame.muestraIncidenciasView();
		
		iv.rellenaComboBox();
	}

	public void preparaNuevaIncidenciaView(){
		frame.creaNuevaIncidenciaView(this);
		this.niv=frame.getNiv();
		frame.muestraNuevaIncidenciaView();
		EstanciaDAO modeloEstancia = new EstanciaDAO();
		ArrayList <EstanciaVO> Estancias = modeloEstancia.getEstanciasUsoComun(refHotel);
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
	
}