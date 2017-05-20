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
		switch(e.getActionCommand()){
			case "Ver Incidencias": preparaIncidenciasView(); break;
			case "Nueva Incidencia": preparaNuevaIncidenciaView(); break;
			case "Incidencia Resuelta": /* **************************************************************************** */ break;
			case "Enviar": preparaInsertarIncidencia(); break;
			case "Cancelar": cancelar(); break;
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
		EstanciaDAO modeloEstancia = new EstanciaDAO(modelo);
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