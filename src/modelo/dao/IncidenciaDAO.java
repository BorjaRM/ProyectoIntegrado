package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.BD;
import modelo.vo.IncidenciaVO;

public class IncidenciaDAO {
	private BD bd;
	
	public IncidenciaDAO(BD bd){
		this.bd = bd;
	}
	public void insertaIncidencia(IncidenciaVO in){
		if(in != null){
			String sql = ("INSERT INTO incidencia (codigo,descripcion,estado,fecha,codigo_estancia) VALUES (?,?,?,?,?);");
			try {
				PreparedStatement consultaIn = this.bd.getConexion().prepareStatement(sql);
				consultaIn.setInt(1, in.getCodigo());	
				consultaIn.setString(2, in.getDescripcion());
				consultaIn.setBoolean(3, in.getEstado());
				consultaIn.setString(4, in.getFecha());
				consultaIn.setInt(5, in.getCod_estancia());
				
				consultaIn.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

		public ArrayList<IncidenciaVO> mostrarIncidencias(){
			ArrayList<String> incidencias = new ArrayList<String>();
			String nombre;
			
			String sql = ("SELECT nombre FROM incidencia;");
			try{
				Statement consulta = this.bd.getConexion().createStatement();
				ResultSet resultadoConsulta = consulta.executeQuery(sql);
				while(resultadoConsulta.next()){
					nombre=resultadoConsulta.getString(1);
					nombresHoteles.add(nombre);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} 		
			return nombresHoteles;
		}
		
	}
	
}
	public int getReferenciaHotel(int codigoEmpleado){
		int cod_hotel=0;
		String sql = ("SELECT lugar_trabajo FROM empleado WHERE codigo=?");
		try {
			PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
			consulta.setInt(1, codigoEmpleado);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next())
				cod_hotel = resultadoConsulta.getInt(1);
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return cod_hotel;
	}
}
