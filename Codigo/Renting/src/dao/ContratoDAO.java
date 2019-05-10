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
	
	public List<Contrato> obtenerContratosPorDNI(String dni){
		List<Contrato> listaContratos = new ArrayList<>();

		String consulta = "SELECT * FROM CONTRATO WHERE dniCliente = ?;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setString(1, dni);
			ResultSet rs = pStatement.executeQuery();
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
	
	public List<Contrato> obtenerContratosPorMatricula(String matricula){
		List<Contrato> listaContratos = new ArrayList<>();

		String consulta = "SELECT * FROM CONTRATO WHERE matricula = ?;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setString(1, matricula);
			ResultSet rs = pStatement.executeQuery();
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
	
	public List<Contrato> obtenerContratosPorFechaInicio(String fechaInicio){
		List<Contrato> listaContratos = new ArrayList<>();

		String consulta = "SELECT * FROM CONTRATO WHERE fechaInicio = ?;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setString(1, fechaInicio.toString());
			ResultSet rs = pStatement.executeQuery();
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
	
	public List<Contrato> buscarContrato(String string) {
		
		List<Contrato> listaContratos = new ArrayList<>();
		
		if (string.toUpperCase().matches("[0-9]{8}[A-Z]"))
			listaContratos = obtenerContratosPorDNI(string);
		else if (string.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
			listaContratos = obtenerContratosPorFechaInicio(string);
		else if (string.toUpperCase().matches("[0-9]{4}-[A-Z]{3}"))
			listaContratos = obtenerContratosPorMatricula(string);		
			
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
}
