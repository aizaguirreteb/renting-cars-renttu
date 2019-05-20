package interfaces;

import modelos.Administrador;

/*
 * Interfaz para estructurar la ventana y el controlador de la ventana principal de la aplicacion
 * desde la cual accedemos a la gestion de todas las secciones de la app
 */
public interface VentanaPrincipal {
	
	/*
	 * Interfaz para la formacion de la ventana
	 */
	public interface Vista{
		public void mostrarVentananuevoUsuario();
		public void mostrarVentanaActualizarUsuario();
	}
	
	
	/*
	 * interfaz para la estructura del controlador
	 */
	public interface Controlador{
		public void actualizarUsuario(String nombreUsuario, Administrador administradorNuevo);	
		public void nuevoUsuario(Administrador administrador);
	}

}
