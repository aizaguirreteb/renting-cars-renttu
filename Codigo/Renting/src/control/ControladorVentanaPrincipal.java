package control;

import dao.AdministradorDAO;
import interfaces.VentanaPrincipal;
import modelos.Administrador;

public class ControladorVentanaPrincipal implements VentanaPrincipal.Controlador{
	AdministradorDAO adminDao;
	private VentanaPrincipal.Vista ventanaPrincipal;
	
	public ControladorVentanaPrincipal(VentanaPrincipal.Vista ventanaPrincipal) {
		this.adminDao = new AdministradorDAO();
		this.ventanaPrincipal = ventanaPrincipal;
	}

	@Override
	public void actualizarUsuario(String nombreUsuario, Administrador administradorNuevo) {
		// TODO Auto-generated method stub
		if(administradorNuevo != null) {
			if(!adminDao.actualizarContrasenia(nombreUsuario, administradorNuevo.getContrasenia())) {
				ventanaPrincipal.errorNuevoUsuario();
			} else {
				ventanaPrincipal.insercionCorrecta();
			}
		}
		
	}

	@Override
	public void nuevoUsuario(Administrador administrador) {
		if(administrador != null) {
			if(!adminDao.insertarNuevoUsuario(administrador)) {
				ventanaPrincipal.errorNuevoUsuario();
			} else {
				ventanaPrincipal.insercionCorrecta();
			}
		}
		
	}

}
