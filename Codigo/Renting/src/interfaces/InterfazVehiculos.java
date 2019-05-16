package interfaces;

import java.util.List;

import modelos.Vehiculos;

public interface InterfazVehiculos {
	public interface Vista{
		public void mostrarVehiculos(List<Vehiculos> listaVehiculo);	

		public void mostrarVehiculossHistorial(List<Vehiculos> listaVehiculo);

		public void errorEnRegistroDeVehiculos();

		public void insercionCorrecta();

		public void dadoDeBajaCorrectamente();
	}
	public interface Controlador{
		public void obtenerVehiculossAlta();
		
		public void obtenerVehiculosBaja();
		
		public void obtenerVehiculosTotal();
		
		public void registrarVehiculos(Vehiculos vehiculoRegistrar);
		public void editarVehiculos(String matricula, Vehiculos vehiculoAEditar);
	}
}
