package modelo.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.BD;
import modelo.vo.EmpleadoVO;

public class EmpleadoDAO {
	
	BD bd;
	ArrayList <EmpleadoVO> empleados;
	
	public EmpleadoDAO(){
		this.bd=bd;
	}
	
	public ArrayList <EmpleadoVO> rellenarYConseguirArrayEmpleados(){
		empleados = new ArrayList <EmpleadoVO>();
		try{
			Statement st = bd.getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Empleado;");
			while(rs.next()){
				String codigo=rs.getString("codigo");
				String nombre=rs.getString("nombre");
				String apellido1=rs.getString("apellido1");
				String apellido2=rs.getString("apellido2");
				String identificacion=rs.getString("identificacion");
				String telefono=rs.getString("telefono");
				String salario=rs.getString("salario");
				String seguridad_social=rs.getString("seguridad_social");
				String fecha_alta=rs.getString("fecha_alta");
				String lugar_trabajo=rs.getString("lugar_trabajo");
				EmpleadoVO em = new EmpleadoVO (codigo,nombre, apellido1,apellido2,identificacion,telefono,salario,
						seguridad_social, fecha_alta,lugar_trabajo);
				empleados.add(em);
			}
			bd.getConexion().close();
		}catch(Exception e){
			System.err.println("Error rellenando el array de empleados");
		}
			return empleados;
		}
	
	public void rellena 
		
	}
