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
import modelos.Reserva;
import modelos.Vehiculos;

public class VehiculosDAO {
	private static Connection conexion;
	public VehiculosDAO()  {
		try {
			conexion  = Conexion.getConexion();
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
	
	
	public List<Vehiculos> obtenerTodosLosVehiculos(){
		List<Vehiculos> listaVehiculos = new ArrayList<>();
		String sql = "SELECT * FROM VEHICULOS;";
		
		 try (Statement statement = conexion.createStatement();ResultSet rs1 = statement.executeQuery(sql)){
			while(rs1.next()) {
				listaVehiculos.add(new Vehiculos(rs1.getString("MATRICULA"),Auxiliar.tipoCategoria(rs1.getString("CATEGORIA")),rs1.getString("MARCA"),rs1.getString("MODELO")
						,Auxiliar.tipoCombustible(rs1.getString("COMBUSTIBLE")),rs1.getInt("NUM_PUERTAS"),rs1.getInt("POTENCIA"),rs1.getString("ANYO")
						,rs1.getInt("TARA_MAX"),Auxiliar.comprobarEstado(rs1.getString("ESTADO")),rs1.getBoolean("REVISION"),rs1.getInt("KM_PARCIALES")
						,rs1.getInt("PLAZAS"),rs1.getInt("KM_TOTALES"),rs1.getDouble("PRECIO_DIA")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return listaVehiculos;
	}
	
	
	public List<Vehiculos> obtenerVehiculosActivos(){
		List<Vehiculos> listaVehiculosActivos = new ArrayList<>();
		String sql = "SELECT * FROM VEHICULOS WHERE ESTADO='ALTA';";
		
		 try (Statement statement = conexion.createStatement();ResultSet rs1 = statement.executeQuery(sql)){
			while(rs1.next()) {
				listaVehiculosActivos.add(new Vehiculos(rs1.getString("MATRICULA"),Auxiliar.tipoCategoria(rs1.getString("CATEGORIA")),rs1.getString("MARCA"),rs1.getString("MODELO")
						,Auxiliar.tipoCombustible(rs1.getString("COMBUSTIBLE")),rs1.getInt("NUM_PUERTAS"),rs1.getInt("POTENCIA"),rs1.getString("ANYO")
						,rs1.getInt("TARA_MAX"),Auxiliar.comprobarEstado(rs1.getString("ESTADO")),rs1.getBoolean("REVISION"),rs1.getInt("KM_PARCIALES")
						,rs1.getInt("PLAZAS"),rs1.getInt("KM_TOTALES"),rs1.getDouble("PRECIO_DIA")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return listaVehiculosActivos;
	}
	
	public List<Vehiculos> obtenerVehiculosBaja(){
		List<Vehiculos> listaVehiculosBaja = new ArrayList<>();
		String sql = "SELECT * FROM VEHICULOS WHERE ESTADO='BAJA';";
		
		 try (Statement statement = conexion.createStatement();ResultSet rs1 = statement.executeQuery(sql)){
			 
				while(rs1.next()) {
					listaVehiculosBaja.add(new Vehiculos(rs1.getString("MATRICULA"),Auxiliar.tipoCategoria(rs1.getString("CATEGORIA")),rs1.getString("MARCA"),rs1.getString("MODELO")
							,Auxiliar.tipoCombustible(rs1.getString("COMBUSTIBLE")),rs1.getInt("NUM_PUERTAS"),rs1.getInt("POTENCIA"),rs1.getString("ANYO")
							,rs1.getInt("TARA_MAX"),Auxiliar.comprobarEstado(rs1.getString("ESTADO")),rs1.getBoolean("REVISION"),rs1.getInt("KM_PARCIALES")
							,rs1.getInt("PLAZAS"),rs1.getInt("KM_TOTALES"),rs1.getDouble("PRECIO_DIA")));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return listaVehiculosBaja;
	}
	
	public List<Vehiculos> obtenerVehiculosActivosyMatricula(String buscarMatricula){
		List<Vehiculos> listaVehiculosAM = new ArrayList<>();
		String sql = "SELECT * FROM VEHICULOS WHERE ESTADO='ALTA' AND MATRICULA=?;";
		
		 try (PreparedStatement psstatement = conexion.prepareStatement(sql);){
			 psstatement.setString(1, buscarMatricula);
			 ResultSet rs1 = psstatement.executeQuery();
				while(rs1.next()) {
					listaVehiculosAM.add(new Vehiculos(rs1.getString("MATRICULA"),Auxiliar.tipoCategoria(rs1.getString("CATEGORIA")),rs1.getString("MARCA"),rs1.getString("MODELO")
							,Auxiliar.tipoCombustible(rs1.getString("COMBUSTIBLE")),rs1.getInt("NUM_PUERTAS"),rs1.getInt("POTENCIA"),rs1.getString("ANYO")
							,rs1.getInt("TARA_MAX"),Auxiliar.comprobarEstado(rs1.getString("ESTADO")),rs1.getBoolean("REVISION"),rs1.getInt("KM_PARCIALES")
							,rs1.getInt("PLAZAS"),rs1.getInt("KM_TOTALES"),rs1.getDouble("PRECIO_DIA")));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return listaVehiculosAM;
	}
	
	
	public List<Vehiculos> obtenerVehiculosBajayMatricula(String buscarMatricula){
		List<Vehiculos> listaVehiculosBM = new ArrayList<>();
		String sql = "SELECT * FROM VEHICULOS WHERE ESTADO='BAJA' AND MATRICULA LIKE %?%;";
		
		 try (PreparedStatement psstatement = conexion.prepareStatement(sql);){
			 psstatement.setString(1, buscarMatricula);
			 ResultSet rs1 = psstatement.executeQuery();
				while(rs1.next()) {
					listaVehiculosBM.add(new Vehiculos(rs1.getString("MATRICULA"),Auxiliar.tipoCategoria(rs1.getString("CATEGORIA")),rs1.getString("MARCA"),rs1.getString("MODELO")
							,Auxiliar.tipoCombustible(rs1.getString("COMBUSTIBLE")),rs1.getInt("NUM_PUERTAS"),rs1.getInt("POTENCIA"),rs1.getString("ANYO")
							,rs1.getInt("TARA_MAX"),Auxiliar.comprobarEstado(rs1.getString("ESTADO")),rs1.getBoolean("REVISION"),rs1.getInt("KM_PARCIALES")
							,rs1.getInt("PLAZAS"),rs1.getInt("KM_TOTALES"),rs1.getDouble("PRECIO_DIA")));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return listaVehiculosBM;
	}
	
	
	
	
	
	
	
	
	public List<Vehiculos> obtenerVehiculoPorCombustible(String buscarCombustible){
		List<Vehiculos> listaVehiculosAC = new ArrayList<>();
		String sql = "SELECT * FROM VEHICULOS WHERE ESTADO='ALTA' AND COMBUSTIBLE LIKE %?%;";
		
		 try (PreparedStatement psstatement = conexion.prepareStatement(sql);){
			 psstatement.setString(1, buscarCombustible);
			 ResultSet rs1 = psstatement.executeQuery();
				while(rs1.next()) {
					listaVehiculosAC.add(new Vehiculos(rs1.getString("MATRICULA"),Auxiliar.tipoCategoria(rs1.getString("CATEGORIA")),rs1.getString("MARCA"),rs1.getString("MODELO")
							,Auxiliar.tipoCombustible(rs1.getString("COMBUSTIBLE")),rs1.getInt("NUM_PUERTAS"),rs1.getInt("POTENCIA"),rs1.getString("ANYO")
							,rs1.getInt("TARA_MAX"),Auxiliar.comprobarEstado(rs1.getString("ESTADO")),rs1.getBoolean("REVISION"),rs1.getInt("KM_PARCIALES")
							,rs1.getInt("PLAZAS"),rs1.getInt("KM_TOTALES"),rs1.getDouble("PRECIO_DIA")));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return listaVehiculosAC;		
	}
		 
		 
		 
		 
		 
			public List<Vehiculos> obtenerVehiculosBajaCombustible(String buscarCombustible){
				List<Vehiculos> listaVehiculosBC = new ArrayList<>();
				String sql = "SELECT * FROM VEHICULOS WHERE ESTADO='BAJA' AND COMBUSTIBLE LIKE %?%;";
				
				 try (PreparedStatement psstatement = conexion.prepareStatement(sql);){
					 psstatement.setString(1, buscarCombustible);
					 ResultSet rs1 = psstatement.executeQuery();
						while(rs1.next()) {
							listaVehiculosBC.add(new Vehiculos(rs1.getString("MATRICULA"),Auxiliar.tipoCategoria(rs1.getString("CATEGORIA")),rs1.getString("MARCA"),rs1.getString("MODELO")
									,Auxiliar.tipoCombustible(rs1.getString("COMBUSTIBLE")),rs1.getInt("NUM_PUERTAS"),rs1.getInt("POTENCIA"),rs1.getString("ANYO")
									,rs1.getInt("TARA_MAX"),Auxiliar.comprobarEstado(rs1.getString("ESTADO")),rs1.getBoolean("REVISION"),rs1.getInt("KM_PARCIALES")
									,rs1.getInt("PLAZAS"),rs1.getInt("KM_TOTALES"),rs1.getDouble("PRECIO_DIA")));
						}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				 return listaVehiculosBC;
			}
			
	public List<Vehiculos> buscarVehiculos(String string){
		
		List<Vehiculos> listaVehiculos = new ArrayList<>();
		
		String sql1 = "SELECT * FROM VEHICULOS WHERE MATRICULA LIKE ?;";
		String sql2 = "SELECT * FROM VEHICULOS WHERE MARCA LIKE ?;";
		String sql3 = "SELECT * FROM VEHICULOS WHERE MODELO LIKE ?;";
		
		try (PreparedStatement psstatement1 = conexion.prepareStatement(sql1);
				PreparedStatement psstatement2 = conexion.prepareStatement(sql2);
				PreparedStatement psstatement3 = conexion.prepareStatement(sql3);){
			psstatement1.setString(1, "%"+string+"%");
			ResultSet rs1 = psstatement1.executeQuery();
			while(rs1.next()) {
				listaVehiculos.add(new Vehiculos(rs1.getString("MATRICULA"),Auxiliar.tipoCategoria(rs1.getString("CATEGORIA")),rs1.getString("MARCA"),rs1.getString("MODELO")
						,Auxiliar.tipoCombustible(rs1.getString("COMBUSTIBLE")),rs1.getInt("NUM_PUERTAS"),rs1.getInt("POTENCIA"),rs1.getString("ANYO")
						,rs1.getInt("TARA_MAX"),Auxiliar.comprobarEstado(rs1.getString("ESTADO")),rs1.getBoolean("REVISION"),rs1.getInt("KM_PARCIALES")
						,rs1.getInt("PLAZAS"),rs1.getInt("KM_TOTALES"),rs1.getDouble("PRECIO_DIA")));
			}
			
			psstatement2.setString(1, "%"+string+"%");
			ResultSet rs2 = psstatement2.executeQuery();
			while(rs2.next()) {
				listaVehiculos.add(new Vehiculos(rs2.getString("MATRICULA"),Auxiliar.tipoCategoria(rs2.getString("CATEGORIA")),rs2.getString("MARCA"),rs2.getString("MODELO")
						,Auxiliar.tipoCombustible(rs2.getString("COMBUSTIBLE")),rs2.getInt("NUM_PUERTAS"),rs2.getInt("POTENCIA"),rs2.getString("ANYO")
						,rs2.getInt("TARA_MAX"),Auxiliar.comprobarEstado(rs2.getString("ESTADO")),rs2.getBoolean("REVISION"),rs2.getInt("KM_PARCIALES")
						,rs2.getInt("PLAZAS"),rs2.getInt("KM_TOTALES"),rs2.getDouble("PRECIO_DIA")));
			}
			
			psstatement3.setString(1, "%"+string+"%");
			ResultSet rs3 = psstatement3.executeQuery();
			while(rs3.next()) {
				listaVehiculos.add(new Vehiculos(rs3.getString("MATRICULA"),Auxiliar.tipoCategoria(rs3.getString("CATEGORIA")),rs3.getString("MARCA"),rs3.getString("MODELO")
						,Auxiliar.tipoCombustible(rs3.getString("COMBUSTIBLE")),rs3.getInt("NUM_PUERTAS"),rs3.getInt("POTENCIA"),rs3.getString("ANYO")
						,rs3.getInt("TARA_MAX"),Auxiliar.comprobarEstado(rs3.getString("ESTADO")),rs3.getBoolean("REVISION"),rs3.getInt("KM_PARCIALES")
						,rs3.getInt("PLAZAS"),rs3.getInt("KM_TOTALES"),rs3.getDouble("PRECIO_DIA")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaVehiculos;
		
	}

			public boolean actualizarEstadoYKmvehiculo(String matricula, Vehiculos nuevoVehiculo) {
				String updateSQL = "UPDATE VEHICULOS SET  MATRICULA=?,CATEGORIA=?,MARCA=?,MODELO=?,COMBUSTIBLE=?,NUM_PUERTAS=?," +
			"POTENCIA=?,ANYO=?,TARA_MAX=?,REVISION=?,KM_PARCIALES=?,PLAZAS=?,KM_TOTALES=?,PRECIO_DIA=?,ESTADO=?" +
						" WHERE MATRICULA=?;";
				
				int filasAfectadas = 0;
				try (PreparedStatement pStatement = conexion.prepareStatement(updateSQL);){
					pStatement.setString(1, nuevoVehiculo.getMatricula());
					pStatement.setString(2, nuevoVehiculo.getCategoria().toString());
					pStatement.setString(3, nuevoVehiculo.getMarca());
					pStatement.setString(4, nuevoVehiculo.getModelo());
					pStatement.setString(5, nuevoVehiculo.getCombustible().toString());
					pStatement.setInt(6, nuevoVehiculo.getNumPuertas());
					pStatement.setInt(7, nuevoVehiculo.getPotencia());
					pStatement.setString(8, nuevoVehiculo.getAnio().toString());
					pStatement.setInt(9, nuevoVehiculo.getTaraMax());					
					pStatement.setString(10, Auxiliar.leerRecogida(nuevoVehiculo.getRevision()));
					pStatement.setInt(11, nuevoVehiculo.getKmParciales());
					pStatement.setInt(12, nuevoVehiculo.getPlazas());
					pStatement.setInt(13, nuevoVehiculo.getKmTotales());
					pStatement.setDouble(14, nuevoVehiculo.getPrecioDia());
					pStatement.setString(15, nuevoVehiculo.getEstado().toString());
					pStatement.setString(16, matricula);
					filasAfectadas = pStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return filasAfectadas != 0;
			}
		


			
			
			public boolean insertarVehiculos(Vehiculos nuevoVehiculo) {
				String insercionSQL = "Insert into vehiculos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
				int filasAfectadas = 0;
				try (PreparedStatement pStatement = conexion.prepareStatement(insercionSQL);){
					pStatement.setString(1, nuevoVehiculo.getMatricula());
					pStatement.setString(2, nuevoVehiculo.getCategoria().toString());
					pStatement.setString(3, nuevoVehiculo.getMarca());
					pStatement.setString(4, nuevoVehiculo.getModelo());
					pStatement.setString(5, nuevoVehiculo.getCombustible().toString());
					pStatement.setInt(6, nuevoVehiculo.getNumPuertas());
					pStatement.setInt(7, nuevoVehiculo.getPotencia());
					pStatement.setString(8, nuevoVehiculo.getAnio().toString());
					pStatement.setInt(9, nuevoVehiculo.getTaraMax());
					pStatement.setString(10, Auxiliar.leerRecogida(nuevoVehiculo.getRevision()));										
					pStatement.setInt(11, nuevoVehiculo.getKmParciales());
					pStatement.setInt(12, nuevoVehiculo.getPlazas());
					pStatement.setInt(13, nuevoVehiculo.getKmTotales());
					pStatement.setDouble(14, nuevoVehiculo.getPrecioDia());
					pStatement.setString(15, nuevoVehiculo.getEstado().toString());
					filasAfectadas = pStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return filasAfectadas != 0;
			}
			








}















