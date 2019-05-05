package interfaces;

import modelos.Administrador;

/*
 * La clase AccesoLogIn es una interfaz para asegurarnos que los metodos concretos que son
 * necesarios para la vista del LogIn y su correspondiente controlador se implmentan
 */
public interface AccesoLogIn {
	
	/*
	 * En la interfaz de la vista(ventana de log in) debe haber los siguientes metodos
	 */	
	public interface Vista{
		
		//Metodo que devuelve un JOptionPane de error al introducir el usuario y password	

		public void errorAutenticacion();
		//Metodo para el proceso de desarrollo que devuelve un JOptionPane si es correcto
		public void mostrarCorrecto();
	}
	
	public interface Controlador{
		public boolean validarLogIn(Administrador administradorIntroducido);
	}

}
