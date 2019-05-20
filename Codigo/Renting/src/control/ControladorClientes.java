package control;

import java.util.List;
import dao.ClienteDAO;
import interfaces.InterfazCliente;
import interfaces.InterfazCliente.Vista;
import modelos.Cliente;

public class ControladorClientes implements InterfazCliente.Controlador {
	//Tiene a la vista y al DAO asociados como atributos
	private InterfazCliente.Vista vistaCliente;
	private ClienteDAO clienteDao;

	//constructor que inicializa el ClienteDAO y recoge la vista de cliente
	public ControladorClientes(Vista vistaCliente) {
		this.vistaCliente = vistaCliente;
		this.clienteDao = new ClienteDAO();
	}

	@Override
	public void obtenerListaClientes() {
		List<Cliente> listaClientes = clienteDao.obtenerListaClientes();
		vistaCliente.mostrarClientes(listaClientes);

	}

	@Override
	public void obtenerListaClientesAlta() {
		List<Cliente> listaClientesAlta = clienteDao.obtenerListaClientesAlta();
		vistaCliente.mostrarClientes(listaClientesAlta);
	}

	@Override
	public void obtenerListaClientesBaja() {
		List<Cliente> listaClientesBaja = clienteDao.obtenerListaClientesBaja();
		vistaCliente.mostrarClientesBaja(listaClientesBaja);

	}

	@Override
	public void crearNuevoCliente(Cliente clienteNuevo) {
		if(clienteNuevo != null ) {

			if(!clienteDao.crearCliente(clienteNuevo)) {
				vistaCliente.errorAlRegistrarCliente();
			} else {
				vistaCliente.registroCorrecto();
				obtenerListaClientes();
			}
		}
	}

	@Override
	public void actualizarCliente(String dni , Cliente clienteEdit) {
		if(clienteEdit != null) {

			//Cuando se edita una reserva es para darla de baja, tanto si la han recogido como si no.
			//despues hay que volver a rellenar la tabla del panel de reservas para ver los cambios
			clienteDao.actualizarCliente(clienteEdit);
			obtenerListaClientesAlta();		

		}
	}

	@Override
	public void buscarCliente(String dato) {
		// TODO Auto-generated method stub
		
	}




}
