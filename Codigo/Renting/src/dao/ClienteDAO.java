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

import conexion.Conexion;
import modelos.Cliente;
import modelos.Estado;

public class ClienteDAO {

	private static Connection conexion = null;

	public ClienteDAO () {
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

	//Devuelve una lista con todos los cliente que se encuentran en la base de datos 
	public  List<Cliente> obtenerListaClientes(){
		List<Cliente> listaClientes = new ArrayList<>();
		String sql = "SELECT * FROM CLIENTES";
		try (Statement statement =  conexion.createStatement();) {

			ResultSet rsSet = statement.executeQuery(sql);

			while(rsSet.next()) {
				if (rsSet.getString(6).equals(Estado.alta.toString()
						)) {
					listaClientes.add(new Cliente(rsSet.getString("DNI"),rsSet.getString("POBLACION"),
							rsSet.getString("NOMBRE"),rsSet.getString("DIRECCION"),rsSet.getString("COD_POSTAL"),
							Estado.alta,rsSet.getInt("TELEFONO"),rsSet.getString("CARNET_CONDUCIR"),
							rsSet.getString("NUM_TARJ_CREDITO")));
				}else {
					listaClientes.add(new Cliente(rsSet.getString("DNI"),rsSet.getString("POBLACION"),
							rsSet.getString("NOMBRE"),rsSet.getString("DIRECCION"),rsSet.getString("COD_POSTAL"),
							Estado.baja,rsSet.getInt("TELEFONO"),rsSet.getString("CARNET_CONDUCIR"),
							rsSet.getString("NUM_TARJ_CREDITO")));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return listaClientes;
	}

	public List<Cliente> obtenerListaClientesAlta (){
		List<Cliente> listaClientesAlta = new ArrayList<>();
		String sql = "SELECT * FROM CLIENTES WHERE ESTADO='alta'" ;
		try (PreparedStatement psStatement = conexion.prepareStatement(sql);){
			ResultSet rsSet = psStatement.executeQuery();
			while (rsSet.next()) {
				if (rsSet.getString(6).equals(Estado.alta.toString()
						)) {
					listaClientesAlta.add(new Cliente(rsSet.getString("DNI"),rsSet.getString("POBLACION"),
							rsSet.getString("NOMBRE"),rsSet.getString("DIRECCION"),rsSet.getString("COD_POSTAL"),
							Estado.alta,rsSet.getInt("TELEFONO"),rsSet.getString("CARNET_CONDUCIR"),
							rsSet.getString("NUM_TARJ_CREDITO")));
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return listaClientesAlta;
	}
	
	public List<Cliente> obtenerListaClientesBaja (){
		List<Cliente> listaClientesBaja = new ArrayList<>();
		String sql = "SELECT * FROM CLIENTES WHERE ESTADO='baja'" ;
		try (PreparedStatement psStatement = conexion.prepareStatement(sql);){
			ResultSet rsSet = psStatement.executeQuery();
			while (rsSet.next()) {
				if (!rsSet.getString(6).equals(Estado.alta.toString())) {
					listaClientesBaja.add(new Cliente(rsSet.getString("DNI"),rsSet.getString("POBLACION"),
							rsSet.getString("NOMBRE"),rsSet.getString("DIRECCION"),rsSet.getString("COD_POSTAL"),
							Estado.baja,rsSet.getInt("TELEFONO"),rsSet.getString("CARNET_CONDUCIR"),
							rsSet.getString("NUM_TARJ_CREDITO")));
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return listaClientesBaja;
	}
	
	
	public Cliente obtenerClientePorDniAlta (String dni){
		List<Cliente> listaClientesAlta = obtenerListaClientesAlta();
		for (Cliente cliente : listaClientesAlta) {
			if (dni.equals(cliente.getDni())) {
				return cliente;
			}
		}
		
		return null;
	}
	public Cliente obtenerClientePorDniBaja (String dni){
		List<Cliente> listaClientesBaja = obtenerListaClientesBaja();
		for (Cliente cliente : listaClientesBaja) {
			if (dni.equals(cliente.getDni())) {
				return cliente;
			}
		}
		
		return null;
	}
	
	public Cliente obtenerClientePorNombreAlta(String nombre) {
		List<Cliente> listaClientesAlta = obtenerListaClientesAlta();
		for (Cliente cliente : listaClientesAlta) {
			if (nombre.toLowerCase().equals(cliente.getNombre().toLowerCase())) {
				return cliente;
			}
		}
		return null;
	}
	
	public Cliente obtenerClientePorNombreBaja(String nombre) {
		List<Cliente> listaClientesBaja = obtenerListaClientesBaja();
		for (Cliente cliente : listaClientesBaja) {
			if (nombre.toLowerCase().equals(cliente.getNombre().toLowerCase())) {
				return cliente;
			}
		}
		return null;
	}
	
	
	public boolean actualizarCliente(Cliente cliente) {
		String sql = "UPDATE CLIENTES SET ?,?,?,?,?,?,?,?,? WHERE DNI=?";
		int rows = 0 ;
		try (PreparedStatement psStatement = conexion.prepareStatement(sql);) {
			psStatement.setString(1,cliente.getDni());
			psStatement.setString(2,cliente.getPoblacion());
			psStatement.setString(3,cliente.getNombre());
			psStatement.setString(4,cliente.getDireccion());
			psStatement.setString(5,cliente.getCodPostal());
			psStatement.setString(6,cliente.getEstado().toString());
			psStatement.setInt(7,cliente.getTlf());
			psStatement.setString(8,cliente.getCarnetConducir());
			psStatement.setString(9,cliente.getNumTarjCredito());
			psStatement.setString(10,cliente.getDni());
			
			rows = psStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows != 0;
	}
	
	
	public  boolean crearCliente(Cliente cliente) {
		//Va a ser el comando a usar en la base de datos
		String sql = "INSERT INTO CLIENTES VALUES (?,?,?,?,?,?,?,?,?)";
		//Variable que va a guardar el número de filas actualizadas
		int rows = 0;
		try (PreparedStatement ps =  conexion.prepareStatement(sql);) {
			//Introduce los valores del cliente a sus respectivas filas 
			ps.setString(1,cliente.getDni());
			ps.setString(2,cliente.getPoblacion());
			ps.setString(3,cliente.getNombre());
			ps.setString(4,cliente.getDireccion());
			ps.setString(5,cliente.getCodPostal());
			ps.setString(6,cliente.getEstado().toString());
			ps.setInt(7,cliente.getTlf());
			ps.setString(8,cliente.getCarnetConducir());
			ps.setString(9,cliente.getNumTarjCredito());

			rows = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows != 0;

	}





}
