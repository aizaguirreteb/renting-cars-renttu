package control;
import dao.AdministradorDAO;
import interfaces.AccesoLogIn;
import modelos.Administrador;

public class ControladorAdministrador implements AccesoLogIn.Controlador {

	//Tiene a la vista y al DAO asociados como atributos
	AccesoLogIn.Vista vistaLogIn;
	AdministradorDAO administradorDAO;
	
	
	//Constructor que inicializa el DAO y recibe la ventana que necesita
	public ControladorAdministrador (AccesoLogIn.Vista ventanaLogIn) {
		this.vistaLogIn = ventanaLogIn;
		this.administradorDAO = new AdministradorDAO();
	}
	
	
	
	//Metodo para comprobar si el login ha sido correcto
	@Override
	public boolean validarLogIn(Administrador administradorIntroducido) {
		
		if(administradorIntroducido != null && administradorDAO.comprobarExistenciaUsuario(administradorIntroducido) == true) {
			String passwordCorrecta = administradorDAO.obtenerContraseniaPorUsuario(administradorIntroducido.getUsuario());
			//System.out.println(passwordCorrecta);
			return passwordCorrecta.matches(administradorIntroducido.getContrasenia());
		} else {
			return false;
		}
		
	}
	
}
