package interfaces;
import java.util.List;

import modelos.Reserva;

public interface InterfazReserva {
	
	public interface Vista{
		
		//Metodo para añadir las reservas a la tabla correspondiente para la tabla del panel de Reservas
		public void mostrarReservas(List<Reserva> listaReservas);	
		
		public void mostrarReservasHistorial(List<Reserva> listaReservas);
		
		//JOptionPane de error cuando uno o varios datos de la reserva no se encuentran en la base de datos
		public void errorEnRegistroDeReserva();
		
		public void insercionCorrecta();
		
		public void dadoDeBajaCorrectamente();
	}
	
	public interface Controlador{
		
		//Metodo para obtener las reservas con el DAO
		public void obtenerReservasAlta();
		
		public void obtenerReservasBaja();
		
		public void obtenerReservasTotal();
		
		//Metodo para insertar una nueva reserva con el DAO
		public void registrarReserva(Reserva reservaARegistrar);
		
		//Metodo para dar de baja por recogida o no recogida una reserva, pasandole la reserva que se ha pinchado de la tabla
		//Hay que cambiar el metodo del dao que actualiza las reservas
		public void editarReserva(String estado, String recogida, Reserva reservaAEditar);
	}

}
