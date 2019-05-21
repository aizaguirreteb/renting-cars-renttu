package control;

import java.util.List;

import dao.ReservaDAO;
import interfaces.InterfazReserva;
import interfaces.InterfazReserva.Controlador;
import modelos.Reserva;
import modelos.Vehiculos;

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
	public void editarReserva(Reserva reservaAEditar, Reserva nuevaReserva) {
		if(nuevaReserva != null) {
			
			//Cuando se edita una reserva es para darla de baja, tanto si la han recogido como si no.
			//despues hay que volver a rellenar la tabla del panel de reservas para ver los cambios
			reservaDao.actualizarEstadoReservaPorDni(reservaAEditar, nuevaReserva);
			obtenerReservasAlta();		
			
		}

	}

	@Override
	public void buscarReserva(String dato) {
		// TODO Auto-generated method stub
		List<Reserva> listaEncontrados = reservaDao.buscarReserva(dato);
		panelReserva.mostrarReservas(listaEncontrados);
	}

	

}
