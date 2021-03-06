package interfaces;
import java.util.List;

import modelos.Cliente;
import modelos.Reserva;



public interface InterfazCliente {

	public interface Vista{
		//Métodos para añadir los clientes a la tabla correspondiente del panel Clientes 
		public void mostrarClientes(List<Cliente> listaClientes);
//		public void mostrarClientesAlta(List<Cliente> listaClientesAlta);
		public void mostrarClientesBaja(List<Cliente> listaClientesBaja);
		//public void mostrarClientePorDniAlta(Cliente clienteDniAlta);
		//public void mostrarClientePorDniBaja(Cliente clienteDniBaja);
		//public void mostrarClientePorNombreAlta(Cliente clienteNombreAlta);
		//En esta parte podemos obtener notificaciones de JOptionPane las cuales 
		//indicarán si son correctas o no
		public void errorAlRegistrarCliente(); 				
		public void registroCorrecto(); 				
		public void clienteDadoDeBajaCorrectamente();
	
	}

	public interface Controlador{
		//Son los métodos que se usan para obtener los objetos ClienteDAO
		public void obtenerListaClientes();
		public void obtenerListaClientesAlta();
		public void obtenerListaClientesBaja();
//		public void obtenerClienteDniAlta();
//		public void obtenerClienteDniBaja();
//		public void obtenerClienteNombreAlta();
//		public void obtenerClienteNombreBaja(); 

		//Sirve para crear un nuevo objeto ClienteDAO
		public void crearNuevoCliente(Cliente clienteNuevo);
		//Sirve para actualizar un cliente de la lista 
		public void actualizarCliente(String dni , Cliente clienteNuevo);
		
		//metodo para buscar clientes
		public void buscarCliente(String dato);
		
		
	}
	
	

}

