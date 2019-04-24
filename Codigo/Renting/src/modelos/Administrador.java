package modelos;

/*
 * Clase Administrador que genera objetos con usuario y contrasenia para 
 * controlar el acceso de los usuarios a la aplicación
 */

public class Administrador {
	private String usuario;
	private String contrasenia;
	
	public Administrador(String usuario, String contrasenia) {		
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	
	//Constructor por defecto
	public Administrador () {}

	
	//Getters y Setters
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	//toString
	@Override
	public String toString() {
		return "Administrador [usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}
	
	
}
