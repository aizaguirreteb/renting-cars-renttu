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
		
		 try (Statement statement = conexion.createStatement();ResultSet rs = statement.executeQuery(sql)){
			while(rs.next()) {
				listaVehiculos.add(new Vehiculos(rs.getString("matricula"),Auxiliar.tipoCategoria(rs.getString("categoria")),rs.getString("marca"),rs.getString("modelo")
						,Auxiliar.tipoCombustible(rs.getString("combustible")),rs.getInt("num_puertas"),rs.getInt("potencia"),Auxiliar.formatearFechaVehiculos(rs.getString("anyo"))
						,rs.getInt("Tara_Max"),Auxiliar.comprobarEstado(rs.getString("estado")),rs.getBoolean("revision"),rs.getInt("Km_Parciales")
						,rs.getInt("plazas"),rs.getInt("Km_Totales"),rs.getDouble("Precio_Dia")));
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
		
		 try (Statement statement = conexion.createStatement();ResultSet rs = statement.executeQuery(sql)){
			while(rs.next()) {
				listaVehiculosActivos.add(new Vehiculos(rs.getString("matricula"),Auxiliar.tipoCategoria(rs.getString("categoria")),rs.getString("marca"),rs.getString("modelo")
						,Auxiliar.tipoCombustible(rs.getString("combustible")),rs.getInt("num_puertas"),rs.getInt("potencia"),Auxiliar.formatearFechaVehiculos(rs.getString("anyo"))
						,rs.getInt("Tara_Max"),Auxiliar.comprobarEstado(rs.getString("estado")),rs.getBoolean("revision"),rs.getInt("Km_Parciales")
						,rs.getInt("plazas"),rs.getInt("Km_Totales"),rs.getDouble("Precio_Dia")));
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
		
		 try (Statement statement = conexion.createStatement();ResultSet rs = statement.executeQuery(sql)){
			while(rs.next()) {
				listaVehiculosBaja.add(new Vehiculos(rs.getString("matricula"),Auxiliar.tipoCategoria(rs.getString("categoria")),rs.getString("marca"),rs.getString("modelo")
						,Auxiliar.tipoCombustible(rs.getString("combustible")),rs.getInt("num_puertas"),rs.getInt("potencia"),Auxiliar.formatearFechaVehiculos(rs.getString("anyo"))
						,rs.getInt("Tara_Max"),Auxiliar.comprobarEstado(rs.getString("estado")),rs.getBoolean("revision"),rs.getInt("Km_Parciales")
						,rs.getInt("plazas"),rs.getInt("Km_Totales"),rs.getDouble("Precio_Dia")));
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
			 ResultSet rs = psstatement.executeQuery();
			while(rs.next()) {
				listaVehiculosAM.add(new Vehiculos(rs.getString("matricula"),Auxiliar.tipoCategoria(rs.getString("categoria")),rs.getString("marca"),rs.getString("modelo")
						,Auxiliar.tipoCombustible(rs.getString("combustible")),rs.getInt("num_puertas"),rs.getInt("potencia"),Auxiliar.formatearFechaVehiculos(rs.getString("anyo"))
						,rs.getInt("Tara_Max"),Auxiliar.comprobarEstado(rs.getString("estado")),rs.getBoolean("revision"),rs.getInt("Km_Parciales")
						,rs.getInt("plazas"),rs.getInt("Km_Totales"),rs.getDouble("Precio_Dia")));
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
			 ResultSet rs = psstatement.executeQuery();
			while(rs.next()) {
				listaVehiculosBM.add(new Vehiculos(rs.getString("matricula"),Auxiliar.tipoCategoria(rs.getString("categoria")),rs.getString("marca"),rs.getString("modelo")
						,Auxiliar.tipoCombustible(rs.getString("combustible")),rs.getInt("num_puertas"),rs.getInt("potencia"),Auxiliar.formatearFechaVehiculos(rs.getString("anyo"))
						,rs.getInt("Tara_Max"),Auxiliar.comprobarEstado(rs.getString("estado")),rs.getBoolean("revision"),rs.getInt("Km_Parciales")
						,rs.getInt("plazas"),rs.getInt("Km_Totales"),rs.getDouble("Precio_Dia")));
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
			 ResultSet rs = psstatement.executeQuery();
			while(rs.next()) {
				listaVehiculosAC.add(new Vehiculos(rs.getString("matricula"),Auxiliar.tipoCategoria(rs.getString("categoria")),rs.getString("marca"),rs.getString("modelo")
						,Auxiliar.tipoCombustible(rs.getString("combustible")),rs.getInt("num_puertas"),rs.getInt("potencia"),Auxiliar.formatearFechaVehiculos(rs.getString("anyo"))
						,rs.getInt("Tara_Max"),Auxiliar.comprobarEstado(rs.getString("estado")),rs.getBoolean("revision"),rs.getInt("Km_Parciales")
						,rs.getInt("plazas"),rs.getInt("Km_Totales"),rs.getDouble("Precio_Dia")));
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
					 ResultSet rs = psstatement.executeQuery();
					while(rs.next()) {
						listaVehiculosBC.add(new Vehiculos(rs.getString("matricula"),Auxiliar.tipoCategoria(rs.getString("categoria")),rs.getString("marca"),rs.getString("modelo")
								,Auxiliar.tipoCombustible(rs.getString("combustible")),rs.getInt("num_puertas"),rs.getInt("potencia"),Auxiliar.formatearFechaVehiculos(rs.getString("anyo"))
								,rs.getInt("Tara_Max"),Auxiliar.comprobarEstado(rs.getString("estado")),rs.getBoolean("revision"),rs.getInt("Km_Parciales")
								,rs.getInt("plazas"),rs.getInt("Km_Totales"),rs.getDouble("Precio_Dia")));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				 return listaVehiculosBC;
			}


			public boolean actualizarEstadoYKmvehiculo(String matricula, Vehiculos nuevoVehiculo) {
				String updateSQL = "UPDATE VEHICULOS SET  MATRICULA=?,CATEGORIA=?,MARCA=?,MODELO=?,COMBUSTIBLE=?,NUM_PUERTAS=?," +
			"POTENCIA=?,ANYO=?,TARA_MAX=?,REVISION=?,KM_PARCIALES=?,PLAZAS=?,KM_TOTALES=?,PRECIO_DIA=?,ESTADO=?" +
						"WWHERE MATRICULA=?;";
				
				int filasAfectadas = 0;
				try (PreparedStatement pStatement = conexion.prepareStatement(updateSQL);){
					pStatement.setString(1, nuevoVehiculo.getMatricula());
					pStatement.setString(2, nuevoVehiculo.getCategoria().toString());
					pStatement.setString(3, nuevoVehiculo.getMarca());
					pStatement.setString(4, nuevoVehiculo.getModelo());
					pStatement.setString(4, nuevoVehiculo.getCombustible().toString());
					pStatement.setInt(5, nuevoVehiculo.getNumPuertas());
					pStatement.setInt(6, nuevoVehiculo.getPotencia());
					pStatement.setString(7, nuevoVehiculo.getAnio().toString());
					pStatement.setInt(8, nuevoVehiculo.getTaraMax());					
					pStatement.setString(9, Auxiliar.leerRecogida(nuevoVehiculo.getRevision()));
					pStatement.setInt(10, nuevoVehiculo.getKmParciales());
					pStatement.setInt(11, nuevoVehiculo.getPlazas());
					pStatement.setInt(12, nuevoVehiculo.getKmTotales());
					pStatement.setDouble(13, nuevoVehiculo.getPrecioDia());
					pStatement.setString(14, nuevoVehiculo.getEstado().toString());
					filasAfectadas = pStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return filasAfectadas != 0;
			}
		


			
			
			public boolean insertarVehiculos(Vehiculos nuevoVehiculo) {
				String insercionSQL = "Insert into reserva values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
				int filasAfectadas = 0;
				try (PreparedStatement pStatement = conexion.prepareStatement(insercionSQL);){
					pStatement.setString(1, nuevoVehiculo.getMatricula());
					pStatement.setString(2, nuevoVehiculo.getCategoria().toString());
					pStatement.setString(3, nuevoVehiculo.getMarca());
					pStatement.setString(4, nuevoVehiculo.getCombustible().toString());
					pStatement.setInt(5, nuevoVehiculo.getNumPuertas());
					pStatement.setInt(6, nuevoVehiculo.getPotencia());
					pStatement.setString(7, nuevoVehiculo.getAnio().toString());
					pStatement.setInt(8, nuevoVehiculo.getTaraMax());
					pStatement.setString(9, nuevoVehiculo.getEstado().toString());
					pStatement.setBoolean(10, nuevoVehiculo.getRevision());
					pStatement.setInt(11, nuevoVehiculo.getKmParciales());
					pStatement.setInt(12, nuevoVehiculo.getPlazas());
					pStatement.setInt(13, nuevoVehiculo.getKmTotales());
					pStatement.setDouble(14, nuevoVehiculo.getPrecioDia());
					filasAfectadas = pStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return filasAfectadas != 0;
			}
			








}















