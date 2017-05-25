package modelo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.BD;

public class RutinasAlmacenadas {
	private BD bd;
	CallableStatement cs;
	
	public RutinasAlmacenadas(){
		this.bd=BD.getSingleDBInstance();
	}

	// Mismo metodo que getTotalClientes pero la consulta se realiza en el servidor de BD
	public int rutinaAlmacenadaTotalClientes(int refHotel) {
		int total = 0;
		try {
			cs = bd.getConexion().prepareCall("{CALL getTotalClientes(1)}");
			cs.setInt(1, refHotel);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getInt("total_clientes");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	// Mismo metodo que getTotalHabitaciones pero la consulta se realiza en el servidor de BD
	public int rutinaAlmacenadaTotalHabitaciones(int refHotel) {
		int total = 0;
		try {
			cs = bd.getConexion().prepareCall("{CALL getTotalHabitaciones(1)}");
			cs.setInt(1, refHotel);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getInt("total_habitaciones");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	// Mismo metodo que getTotalIncidencias pero la consulta se realiza en el servidor de BD
	public ArrayList<String> rutinaAlmacenadaIncidencias(int refHotel) {
		ArrayList<String> incidencias = new ArrayList<String>();
		String incidencia;
		try {
			cs = bd.getConexion().prepareCall("{CALL getIncidenciasActivas(1)}");
			cs.setInt(1, refHotel);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				incidencia = rs.getString("incidencia");
				incidencias.add(incidencia);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return incidencias;
	}

	// Mismo metodo que getIncidenciaActivas pero la consulta se realiza en el servidor de BD
	public int rutinaAlmacenadaTotalIncidencias(int refHotel) {
		int total = 0;
		try {
			cs = bd.getConexion().prepareCall("{CALL getTotalIncidencias(1)}");
			cs.setInt(1, refHotel);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getInt("total_incidencias");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	// Mismo metodo que getTotalEmpleados pero la consulta se realiza en el servidor de BD
	public int rutinaAlmacenadaTotalEmpleados(int refHotel) {
		int total = 0;
		try {
			cs = bd.getConexion().prepareCall("{CALL getTotalEmpleados(1)}");
			cs.setInt(1, refHotel);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getInt("total_empleados");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	// Mismo metodo que getTotalReservasHoy pero la consulta se realiza en el servidor de BD
	public int rutinaAlmacenadaTotalReservasHoy(int refHotel) {
		int total = 0;
		try {
			cs = bd.getConexion().prepareCall("{CALL getTotalReservasHoy(1)}");
			cs.setInt(1, refHotel);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getInt("total_reservas");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	
}
