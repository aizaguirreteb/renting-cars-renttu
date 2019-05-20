package interfaces;

import java.util.List;

import modelos.Factura;
import modelos.Reserva;


public interface InterfazFactura {
	
	
	public interface Vista {
		
		//Metodo para mostrar las facturas cerradas, de contratos ya terminados
		public void mostrarFacturas(List<Factura> listaReservas);			
		
		//JOptionPane de error cuando uno o varios datos de la factura no se rellenan o no son correctos
		public void errorEnRegistroDeFactura();
	}
	
	public interface Controlador {
		
		public void obtenerFacturas();
		
		
		//Metodo para dar de baja por recogida o no recogida una reserva, pasandole la reserva que se ha pinchado de la tabla
		//Hay que cambiar el metodo del dao que actualiza las reservas
		public void editarFactura(String idFactura, Factura facturaARegistrar);
		
		//metodo para buscar contratos
		public void buscarFactura(String dato);
	}

}
