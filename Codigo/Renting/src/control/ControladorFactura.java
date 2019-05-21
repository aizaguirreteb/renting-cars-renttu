package control;


import java.util.List;

import dao.FacturaDAO;
import interfaces.InterfazFactura;
import modelos.Factura;
import modelos.Vehiculos;

public class ControladorFactura implements InterfazFactura.Controlador {
	
	private InterfazFactura.Vista panelFactura;
	private FacturaDAO facturaDao;
	
	//Constructor
	public ControladorFactura(InterfazFactura.Vista panel) {
		this.panelFactura = panel;
		this.facturaDao = new FacturaDAO();
	}


	@Override
	public void obtenerFacturas() {
		List<Factura> listaFacturas = facturaDao.obtenerTodasLosContratos();
		panelFactura.mostrarFacturas(listaFacturas);
		
	}

	@Override
	public void editarFactura(String idFactura, Factura facturaARegistrar) {
		if(facturaARegistrar != null) {
			//facturaDao.actualizarFactura();
			obtenerFacturas();
		}
		
	}


	@Override
	public void buscarFactura(String dato) {
		// TODO Auto-generated method stub
		List<Factura> listaEncontrados = facturaDao.buscarContrato(dato);
		panelFactura.mostrarFacturas(listaEncontrados);
	}



}
