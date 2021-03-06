package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import modelos.Administrador;

public class AdministradorDAO {

	private static Connection conexion;

	public AdministradorDAO () {
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


	//Metodo para insertar un nuevo usuario
	public boolean insertarNuevoUsuario(Administrador administrador){

		String insercionSQL = "Insert into administrador values (?,?);";
		int filasAfectadas = 0;
		try (PreparedStatement pStatement = conexion.prepareStatement(insercionSQL);){
			pStatement.setString(1, administrador.getUsuario());
			pStatement.setString(2, administrador.getContrasenia());

			filasAfectadas = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasAfectadas != 0;


	}


	//Metodo para cambiar la contrasenia de un usuario introducido
	public boolean actualizarContrasenia(String usuarioAactualizar, String nuevaContrasenia) {

		String actualizarSQL = "Update administrador set contrasenia=? where usuario=?;";
		int filasAfectadas = 0;
		try (PreparedStatement pStatement = conexion.prepareStatement(actualizarSQL);){
			pStatement.setString(1, nuevaContrasenia);
			pStatement.setString(2, usuarioAactualizar);

			filasAfectadas = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasAfectadas != 0;

	}

	//Metodo para borrar un usuario
	public boolean borrarUsuario(Administrador administrador) {

		String insercionSQL = "Delete from administrador where usuario=?;";
		int filasAfectadas = 0;
		try (PreparedStatement pStatement = conexion.prepareStatement(insercionSQL);){
			pStatement.setString(1, administrador.getUsuario());		
			filasAfectadas = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasAfectadas != 0;
	}

	//metodo que devuelve la contrasenia de un usuario introducido para compararla con la contrasenia
	// introducida y aceptar o no el login
	public String obtenerContraseniaPorUsuario(String usuario) {
		String sentenciaSQL = "Select CONTRASENIA from administrador where USUARIO=?;";
		String contraseniaObtenida = null;
		try (PreparedStatement pStatement = conexion.prepareStatement(sentenciaSQL);){
			pStatement.setString(1, usuario);	
			ResultSet rset = pStatement.executeQuery();
			while(rset.next()) {
				contraseniaObtenida = rset.getString("contrasenia");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contraseniaObtenida;
		 
	}

	//METODO QUE COMPRUEBA SI EXISTE EL USUARIO EN LA BASE DE DATOS
	public boolean comprobarExistenciaUsuario(Administrador administrador) {
		String sentenciaSQL = "Select * from administrador where usuario=?;";
		Administrador adminPrueba = null;
		try (PreparedStatement pStatement = conexion.prepareStatement(sentenciaSQL);){
			pStatement.setString(1, administrador.getUsuario());	
			ResultSet rset = pStatement.executeQuery();

			while(rset.next()) {
				adminPrueba = new Administrador(rset.getString("usuario"), rset.getString("contrasenia"));
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(adminPrueba != null) {
			return true;
		} else {
			return false;
		}
	}

}
