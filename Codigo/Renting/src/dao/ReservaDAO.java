package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import auxiliar.Auxiliar;
import modelos.Reserva;
import conexion.Conexion;

public class ReservaDAO {

	private static Connection conexion;

	public ReservaDAO() {
		try {
			conexion = Conexion.getConexion();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//Metodo que devuelve una lista con todos los registros de la tabla reserva
	public List<Reserva> obtenerTodasLasReservas(){
		List<Reserva> listaReservas = new ArrayList<>();

		String consulta = "Select * from reserva;";
		try (Statement statement = conexion.createStatement();ResultSet rs = statement.executeQuery(consulta)){
			while(rs.next()) {
				listaReservas.add(new Reserva(rs.getString("dniCliente"), rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), Auxiliar.formatearHora(rs.getString("horaReserva")),
						Auxiliar.comprobarRecogida(rs.getString("recogida")), Auxiliar.comprobarEstado(rs.getString("estado"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaReservas;
	}

	//Metodo que devuelve las reservas activas, que tienen estado de 'alta', es decir, que no han sido anuladas o canceladas
	public List<Reserva> obtenerReservasActivas(){

		List<Reserva> listaReservasActivas = new ArrayList<>();
		String consulta = "Select * from reserva where estado='alta';";
		try (Statement statement = conexion.createStatement();ResultSet rs = statement.executeQuery(consulta)){
			while(rs.next()) {
				listaReservasActivas.add(new Reserva(rs.getString("dniCliente"), rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), Auxiliar.formatearHora(rs.getString("horaReserva")),
						Auxiliar.comprobarRecogida(rs.getString("recogida")), Auxiliar.comprobarEstado(rs.getString("estado"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaReservasActivas;
	}


	//Metodo que devuelve las reservas activas, que tienen estado de 'baja', es decir, que han sido anuladas o canceladas
	public List<Reserva> obtenerReservasCanceladas(){

		List<Reserva> listaReservasCanceladas = new ArrayList<>();
		String consulta = "Select * from reserva where estado='baja';";
		try (Statement statement = conexion.createStatement();ResultSet rs = statement.executeQuery(consulta)){
			while(rs.next()) {
				listaReservasCanceladas.add(new Reserva(rs.getString("dniCliente"), rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), Auxiliar.formatearHora(rs.getString("horaReserva")),
						Auxiliar.comprobarRecogida(rs.getString("recogida")), Auxiliar.comprobarEstado(rs.getString("estado"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaReservasCanceladas;
	}


	//Metodo que devuelve reservas activas buscando por dni
	public List<Reserva> obtenerReservasActivasPorDni(String dniABuscar){

		List<Reserva> listaReservasActivasPorDni = new ArrayList<>();
		String consulta = "Select * from reserva where estado='alta' and dniCliente like %?%;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setString(1, dniABuscar);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				listaReservasActivasPorDni.add(new Reserva(rs.getString("dniCliente"), rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), Auxiliar.formatearHora(rs.getString("horaReserva")),
						Auxiliar.comprobarRecogida(rs.getString("recogida")), Auxiliar.comprobarEstado(rs.getString("estado"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaReservasActivasPorDni;
	}

	//Metodo que devuelve reservas canceladas buscando por dni
	public List<Reserva> obtenerReservasCanceladasPorDni(String dniABuscar){

		List<Reserva> listaReservasCanceladasPorDni = new ArrayList<>();
		String consulta = "Select * from reserva where estado='baja' and dniCliente like %?%;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setString(1, dniABuscar);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				listaReservasCanceladasPorDni.add(new Reserva(rs.getString("dniCliente"), rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), Auxiliar.formatearHora(rs.getString("horaReserva")),
						Auxiliar.comprobarRecogida(rs.getString("recogida")), Auxiliar.comprobarEstado(rs.getString("estado"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaReservasCanceladasPorDni;
	}


	//Metodo que devuelve reservas activas buscando por matricula
	public List<Reserva> obtenerReservasActivasPorMatricula(String matricula){

		List<Reserva> listaReservasActivasPorMatricula = new ArrayList<>();
		String consulta = "Select * from reserva where estado='alta' and matricula like %?%;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setString(1, matricula);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				listaReservasActivasPorMatricula.add(new Reserva(rs.getString("dniCliente"), rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), Auxiliar.formatearHora(rs.getString("horaReserva")),
						Auxiliar.comprobarRecogida(rs.getString("recogida")), Auxiliar.comprobarEstado(rs.getString("estado"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaReservasActivasPorMatricula;
	}

	//Metodo que devuelve reservas canceladas buscando por matricula
	public List<Reserva> obtenerReservasCanceladasPorMatricula(String matricula){

		List<Reserva> listaReservasACanceladasPorMatricula = new ArrayList<>();
		String consulta = "Select * from reserva where estado='baja' and matricula like %?%;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setString(1, matricula);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				listaReservasACanceladasPorMatricula.add(new Reserva(rs.getString("dniCliente"), rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), Auxiliar.formatearHora(rs.getString("horaReserva")),
						Auxiliar.comprobarRecogida(rs.getString("recogida")), Auxiliar.comprobarEstado(rs.getString("estado"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaReservasACanceladasPorMatricula;
	}
	
	public List<Reserva> obtenerTodasReservasPorMatricula(String matricula){

		List<Reserva> listaTodasReservasPorMatricula = new ArrayList<>();
		String consulta = "Select * from reserva where matricula like %?%;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setString(1, matricula);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				listaTodasReservasPorMatricula.add(new Reserva(rs.getString("dniCliente"), rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), Auxiliar.formatearHora(rs.getString("horaReserva")),
						Auxiliar.comprobarRecogida(rs.getString("recogida")), Auxiliar.comprobarEstado(rs.getString("estado"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaTodasReservasPorMatricula;
	}
	
	public List<Reserva> obtenerTodasReservasPorDni(String dniABuscar){

		List<Reserva> listaTodasReservasPorDni = new ArrayList<>();
		String consulta = "Select * from reserva where dniCliente like %?%;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setString(1, dniABuscar);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				listaTodasReservasPorDni.add(new Reserva(rs.getString("dniCliente"), rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), Auxiliar.formatearHora(rs.getString("horaReserva")),
						Auxiliar.comprobarRecogida(rs.getString("recogida")), Auxiliar.comprobarEstado(rs.getString("estado"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaTodasReservasPorDni;
	}
	
	public List<Reserva> obtenerTodasReservasPorFecha(String fechaAbuscar){

		List<Reserva> listaTodasReservasPorFecha = new ArrayList<>();
		String consulta = "Select * from reserva where fechaInicio=?;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setString(1, fechaAbuscar);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				listaTodasReservasPorFecha.add(new Reserva(rs.getString("dniCliente"), rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), Auxiliar.formatearHora(rs.getString("horaReserva")),
						Auxiliar.comprobarRecogida(rs.getString("recogida")), Auxiliar.comprobarEstado(rs.getString("estado"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaTodasReservasPorFecha;
	}
	
	//Metodo para insertar una nueva reserva
	public boolean insertarNuevaReserva(Reserva nuevaReserva) {
		String insercionSQL = "Insert into reserva values (?,?,?,?,?,?,?);";
		int filasAfectadas = 0;
		try (PreparedStatement pStatement = conexion.prepareStatement(insercionSQL);){
			pStatement.setString(1, nuevaReserva.getDniCliente());
			pStatement.setString(2, nuevaReserva.getMatricula());
			pStatement.setString(3, nuevaReserva.getFechaInicio().toString());
			pStatement.setInt(4, nuevaReserva.getDiasContratados());
			pStatement.setString(5, nuevaReserva.getHoraReserva().toString());
			pStatement.setBoolean(6, nuevaReserva.isRecogida());
			pStatement.setString(7, nuevaReserva.getEstado().toString());
			filasAfectadas = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasAfectadas != 0;
	}
	
	//Metodo para actualizar una reserva
	//Solo se pueden actualizar los campos recogida y estado.
	//En el caso de que se recoja el coche, el estado pasa a baja
	//Mientras dure el tiempo de la reserva si no se ha recogido el coche el estado será de alta
	//Si nunca se llega a recoger el coche y pasa el tiempo de la reserva, pasa el estado también a baja.
	public boolean actualizarEstadoReservaPorDni(String recogida, String estado, Reserva reservaAeditar) {
		String updateSQL = "Update reserva set recogida=?, estado=? where dniCliente=? and matricula=? and fechaInicio=?;";
		
		int filasAfectadas = 0;
		try (PreparedStatement pStatement = conexion.prepareStatement(updateSQL);){
			pStatement.setString(1, recogida);
			
			pStatement.setString(2, Auxiliar.comprobarEstado(estado).toString());
			pStatement.setString(3, reservaAeditar.getDniCliente());
			pStatement.setString(4, reservaAeditar.getMatricula());
			pStatement.setString(5, reservaAeditar.getFechaInicio().toString());
			
			filasAfectadas = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasAfectadas != 0;
	}
	
	public List<Reserva> buscarReserva(String string){
		List<Reserva> listaReservas = new ArrayList<>();
		
		if(string.toUpperCase().matches("[0-9]{8}[A-Z]"))
			listaReservas = obtenerTodasReservasPorDni(string);
		if(string.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
			listaReservas = obtenerTodasReservasPorFecha(string);
		else if (string.toUpperCase().matches("[0-9]{4}-[A-Z]{3}"))
			listaReservas = obtenerTodasReservasPorMatricula(string);		
			
		return listaReservas;
		
	}
}

