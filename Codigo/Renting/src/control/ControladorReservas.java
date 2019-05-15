package control;

import java.util.List;

import dao.ReservaDAO;
import interfaces.InterfazReserva;
import interfaces.InterfazReserva.Controlador;
import modelos.Reserva;

public class ControladorReservas implements Controlador {
	
	private InterfazReserva.Vista panelReserva;
	private ReservaDAO reservaDao;
	
	//Constructor
	public ControladorReservas(InterfazReserva.Vista panel) {
		this.panelReserva = panel;
		this.reservaDao = new ReservaDAO();
	}

	@Override
	public void obtenerReservasAlta() {
		List<Reserva> listaReservas = reservaDao.obtenerReservasActivas();
		panelReserva.mostrarReservas(listaReservas);
	}
	
	@Override
	public void obtenerReservasBaja() {
		List<Reserva> listaReservas = reservaDao.obtenerReservasCanceladas();
		panelReserva.mostrarReservasHistorial(listaReservas);		
	}

	@Override
	public void obtenerReservasTotal() {
		List<Reserva> listaReservas = reservaDao.obtenerTodasLasReservas();
		panelReserva.mostrarReservas(listaReservas);	
	}

	@Override
	public void registrarReserva(Reserva reservaARegistrar) {
		if(reservaARegistrar != null ) {
			
			if(!reservaDao.insertarNuevaReserva(reservaARegistrar)) {
				panelReserva.errorEnRegistroDeReserva();
			} else {
				panelReserva.insercionCorrecta();
				obtenerReservasAlta();
			}
		}

	}

	@Override
	public void editarReserva(String estado, String recogida, Reserva reservaAEditar) {
		if(reservaAEditar != null) {
			
			//Cuando se edita una reserva es para darla de baja, tanto si la han recogido como si no.
			//despues hay que volver a rellenar la tabla del panel de reservas para ver los cambios
			reservaDao.actualizarEstadoReservaPorDni(recogida, estado, reservaAEditar);
			obtenerReservasAlta();		
			
		}

	}

	

}
