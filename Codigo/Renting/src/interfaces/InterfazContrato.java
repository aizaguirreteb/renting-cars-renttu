package interfaces;

import java.util.List;
import modelos.Contrato;

public interface InterfazContrato {

	public interface Vista{

		public void mostrarContrato(List<Contrato> listaContratos);
		public void mostrarContratosBaja(List<Contrato> listaContratosBaja);
		public void errorAlRegistrarContrato(); 				
		public void registroCorrecto(); 				
		public void contratoDadoDeBajaCorrectamente();
	
	}

	public interface Controlador{

		public void obtenerListaContrato();
		public void obtenerListaContratoAlta();
		public void obtenerListaContratoBaja();
		public void crearNuevoContrato(Contrato contratoNuevo);
		public void actualizarContrato(Contrato contratoAeditar , Contrato contratoNuevo);
		
		//metodo para buscar contratos
		public void buscarContrato(String dato);
		
	}
	
}
