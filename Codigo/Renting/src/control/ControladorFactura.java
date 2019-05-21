package control;


import java.util.List;

import javax.swing.JDialog;

import dao.FacturaDAO;
import interfaces.InterfazFactura;
import modelos.Contrato;
import modelos.Factura;
import modelos.Vehiculos;

public class ControladorFactura implements InterfazFactura.Controlador {
	
	private InterfazFactura.Vista panelFactura;
	private FacturaDAO facturaDao;
	private JDialog dialogo;
	
	
	//Constructor para los dialogos de factura
	public ControladorFactura(JDialog dialogo) {
		this.dialogo = dialogo;
		this.facturaDao = new FacturaDAO();
	}
	
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

	@Override
	public Factura obtenerFacturaPorContrato(Contrato contrato) {
		
		return facturaDao.obtenerFacturaPorContrato(contrato);
	}



}
