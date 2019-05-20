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
import conexion.Conexion;
import modelos.Contrato;

public class ContratoDAO {

	private static Connection conexion;

	public ContratoDAO() {
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
	
	public List<Contrato> obtenerTodasLosContratos(){
		List<Contrato> listaContratos = new ArrayList<>();

		String consulta = "SELECT * FROM CONTRATO;";
		try (Statement statement = conexion.createStatement();ResultSet rs = statement.executeQuery(consulta)){
			while(rs.next()) {
				listaContratos.add(new Contrato(rs.getInt("id"), rs.getString("dniCliente"),
						rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), rs.getInt("numRenovaciones"),
						Auxiliar.comprobarEstado(rs.getString("estadoContrato"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaContratos;
	}
	
	public List<Contrato> obtenerTodasLosContratosEnAlta(){
		List<Contrato> listaContratos = new ArrayList<>();

		String consulta = "SELECT * FROM CONTRATO WHERE estadoContrato = 'alta';";
		try (Statement statement = conexion.createStatement();ResultSet rs = statement.executeQuery(consulta)){
			while(rs.next()) {
				listaContratos.add(new Contrato(rs.getInt("id"), rs.getString("dniCliente"),
						rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), rs.getInt("numRenovaciones"),
						Auxiliar.comprobarEstado(rs.getString("estadoContrato"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaContratos;
	}
	
	public List<Contrato> obtenerTodasLosContratosEnBaja(){
		List<Contrato> listaContratos = new ArrayList<>();

		String consulta = "SELECT * FROM CONTRATO WHERE estadoContrato = 'baja';";
		try (Statement statement = conexion.createStatement();ResultSet rs = statement.executeQuery(consulta)){
			while(rs.next()) {
				listaContratos.add(new Contrato(rs.getInt("id"), rs.getString("dniCliente"),
						rs.getString("matricula"),
						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
						rs.getInt("diasContratados"), rs.getInt("numRenovaciones"),
						Auxiliar.comprobarEstado(rs.getString("estadoContrato"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaContratos;
	}
	
//	public List<Contrato> obtenerContratosPorDNI(String dni){
//		List<Contrato> listaContratos = new ArrayList<>();
//
//		String consulta = "SELECT * FROM CONTRATO WHERE dniCliente = ?;";
//		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
//			pStatement.setString(1, dni);
//			ResultSet rs = pStatement.executeQuery();
//			while(rs.next()) {
//				listaContratos.add(new Contrato(rs.getInt("id"), rs.getString("dniCliente"),
//						rs.getString("matricula"),
//						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
//						rs.getInt("diasContratados"), rs.getInt("numRenovaciones"),
//						Auxiliar.comprobarEstado(rs.getString("estadoContrato"))));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return listaContratos;
//	}
	
//	public List<Contrato> obtenerContratosPorMatricula(String matricula){
//		List<Contrato> listaContratos = new ArrayList<>();
//
//		String consulta = "SELECT * FROM CONTRATO WHERE matricula = ?;";
//		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
//			pStatement.setString(1, matricula);
//			ResultSet rs = pStatement.executeQuery();
//			while(rs.next()) {
//				listaContratos.add(new Contrato(rs.getInt("id"), rs.getString("dniCliente"),
//						rs.getString("matricula"),
//						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
//						rs.getInt("diasContratados"), rs.getInt("numRenovaciones"),
//						Auxiliar.comprobarEstado(rs.getString("estadoContrato"))));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return listaContratos;
//	}
	
//	public List<Contrato> obtenerContratosPorFechaInicio(String fechaInicio){
//		List<Contrato> listaContratos = new ArrayList<>();
//
//		String consulta = "SELECT * FROM CONTRATO WHERE fechaInicio = ?;";
//		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
//			pStatement.setString(1, fechaInicio);
//			ResultSet rs = pStatement.executeQuery();
//			while(rs.next()) {
//				listaContratos.add(new Contrato(rs.getInt("id"), rs.getString("dniCliente"),
//						rs.getString("matricula"),
//						Auxiliar.formatearFecha(rs.getString("fechaInicio")),
//						rs.getInt("diasContratados"), rs.getInt("numRenovaciones"),
//						Auxiliar.comprobarEstado(rs.getString("estadoContrato"))));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return listaContratos;
//	}
	
//	public List<Contrato> buscarContrato(String string) {
//		
//		List<Contrato> listaContratos = new ArrayList<>();
//		
//		if (string.toUpperCase().matches("[0-9]{8}[A-Z]"))
//			listaContratos = obtenerContratosPorDNI(string);
//		else if (string.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
//			listaContratos = obtenerContratosPorFechaInicio(string);
//		else if (string.toUpperCase().matches("[0-9]{4}-[A-Z]{3}"))
//			listaContratos = obtenerContratosPorMatricula(string);		
//			
//		return listaContratos;
//		
//	}
	
	public List<Contrato> buscarContrato(String string) {
		
	List<Contrato> listaContratos = new ArrayList<>();

	String consulta1 = "SELECT * FROM CONTRATO WHERE dniCliente like '%?%';";
	String consulta2 = "SELECT * FROM CONTRATO WHERE matricula like '%?%';";
	String consulta3 = "SELECT * FROM CONTRATO WHERE fechaInicio like '%?%';";
	try (PreparedStatement pStatement1 = conexion.prepareStatement(consulta1);
			PreparedStatement pStatement2 = conexion.prepareStatement(consulta2);
			PreparedStatement pStatement3 = conexion.prepareStatement(consulta3);){
		pStatement1.setString(1, string);
		ResultSet rs1 = pStatement1.executeQuery();
		while(rs1.next()) {
			listaContratos.add(new Contrato(rs1.getInt("id"), rs1.getString("dniCliente"),
					rs1.getString("matricula"),
					Auxiliar.formatearFecha(rs1.getString("fechaInicio")),
					rs1.getInt("diasContratados"), rs1.getInt("numRenovaciones"),
					Auxiliar.comprobarEstado(rs1.getString("estadoContrato"))));
		}
		
		pStatement2.setString(1, string);
		ResultSet rs2 = pStatement2.executeQuery();
		while(rs2.next()) {
			listaContratos.add(new Contrato(rs2.getInt("id"), rs2.getString("dniCliente"),
					rs2.getString("matricula"),
					Auxiliar.formatearFecha(rs2.getString("fechaInicio")),
					rs2.getInt("diasContratados"), rs2.getInt("numRenovaciones"),
					Auxiliar.comprobarEstado(rs2.getString("estadoContrato"))));
		}
		
		pStatement3.setString(1, string);
		ResultSet rs3 = pStatement3.executeQuery();
		while(rs3.next()) {
			listaContratos.add(new Contrato(rs3.getInt("id"), rs3.getString("dniCliente"),
					rs3.getString("matricula"),
					Auxiliar.formatearFecha(rs3.getString("fechaInicio")),
					rs3.getInt("diasContratados"), rs3.getInt("numRenovaciones"),
					Auxiliar.comprobarEstado(rs3.getString("estadoContrato"))));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return listaContratos;
		
}
	
	public boolean insertarNuevoContrato(Contrato nuevoContrato) {
		String insercionSQL = "INSERT INTO CONTRATO VALUES (?,?,?,?,?,?);";
		int filasAfectadas = 0;
		try (PreparedStatement pStatement = conexion.prepareStatement(insercionSQL);){
			pStatement.setString(1, nuevoContrato.getDni());
			pStatement.setString(2, nuevoContrato.getMatricula());
			pStatement.setString(3, nuevoContrato.getFechaInicio().toString());
			pStatement.setInt(4, nuevoContrato.getDiasContratados());
			pStatement.setInt(5, nuevoContrato.getRenovaciones());
			pStatement.setString(6, nuevoContrato.getEstado().toString());
			filasAfectadas = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasAfectadas != 0;
	}
	
	public boolean renovarContrato(Contrato contrato) {
		String updateSQL = "UPDATE CONTRATO SET diasContratados=?, numRenovaciones=? WHERE id=?;";
		
		int filasAfectadas = 0;
		try (PreparedStatement pStatement = conexion.prepareStatement(updateSQL);){
			pStatement.setInt(1, contrato.getDiasContratados() * 2);
			pStatement.setInt(2, contrato.getRenovaciones() - 1);
			pStatement.setInt(3, contrato.getId());
			filasAfectadas = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasAfectadas != 0;
	}
	
	public boolean actualizarContrato(int id, Contrato contrato) {
		String updateSQL = "UPDATE CONTRATO SET id = ?, dniCliente = ?, matricula = ?, fechaInicio  = ?, diasContratados=?, numRenovaciones=?, estadoContrato = ?, WHERE id=?;";
		
		int filasAfectadas = 0;
		try (PreparedStatement pStatement = conexion.prepareStatement(updateSQL);){
			pStatement.setInt(1, contrato.getId());
			pStatement.setString(2, contrato.getDni());
			pStatement.setString(3, contrato.getMatricula());
			pStatement.setString(4, contrato.getFechaInicio().toString());
			pStatement.setInt(5, contrato.getDiasContratados());
			pStatement.setInt(6, contrato.getRenovaciones());
			pStatement.setString(7, contrato.getEstado().toString());
			pStatement.setInt(8, id);
			filasAfectadas = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasAfectadas != 0;
	}
}
