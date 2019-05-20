package control;

import java.util.List;

import dao.ContratoDAO;
import interfaces.InterfazContrato;
import interfaces.InterfazContrato.Vista;
import modelos.Cliente;
import modelos.Contrato;

public class ControladorContrato implements InterfazContrato.Controlador{

	private InterfazContrato.Vista vistaContrato;
	private ContratoDAO contratoDao;
	
	public ControladorContrato(Vista vistaContrato) {
		this.vistaContrato = vistaContrato;
		this.contratoDao = new ContratoDAO();
	}
	
	@Override
	public void obtenerListaContrato() {
		// TODO Auto-generated method stub
		List<Contrato> listaContrato = contratoDao. obtenerTodasLosContratos();
		vistaContrato.mostrarContrato(listaContrato);
		
	}

	@Override
	public void obtenerListaContratoAlta() {
		// TODO Auto-generated method stub
		List<Contrato> listaContratoAlta = contratoDao.obtenerTodasLosContratosEnAlta();
		vistaContrato.mostrarContrato(listaContratoAlta);
	}

	@Override
	public void obtenerListaContratoBaja() {
		// TODO Auto-generated method stub
		List<Contrato> listaContratoBaja = contratoDao.obtenerTodasLosContratosEnBaja();
		vistaContrato.mostrarContrato(listaContratoBaja);
	}

	@Override
	public void crearNuevoContrato(Contrato contratoNuevo) {
		// TODO Auto-generated method stub
		if(contratoNuevo != null ) {

			if(!contratoDao.insertarNuevoContrato(contratoNuevo)) {
				vistaContrato.errorAlRegistrarContrato();
			} else {
				vistaContrato.registroCorrecto();
				obtenerListaContrato();
			}
		}
		
	}

	@Override
	public void actualizarContrato(int id, Contrato contratoNuevo) {
		// TODO Auto-generated method stub
		if(contratoNuevo != null) {

			//Cuando se edita una reserva es para darla de baja, tanto si la han recogido como si no.
			//despues hay que volver a rellenar la tabla del panel de reservas para ver los cambios
			contratoDao.actualizarContrato(id, contratoNuevo);
			obtenerListaContratoAlta();		

		}
	}

	@Override
	public void buscarContrato(String dato) {
		// TODO Auto-generated method stub
		
	}

}
