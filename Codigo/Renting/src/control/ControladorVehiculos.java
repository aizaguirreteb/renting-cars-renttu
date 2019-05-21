package control;

import java.util.List;

import javax.swing.plaf.PanelUI;

import dao.VehiculosDAO;
import interfaces.InterfazVehiculos;
import interfaces.InterfazVehiculos.Vista;
import modelos.Vehiculos;

public class ControladorVehiculos implements InterfazVehiculos.Controlador {
	private InterfazVehiculos.Vista panelVehiculo;
	private VehiculosDAO vehiculosDAO;
	public ControladorVehiculos(Vista panelVehiculo) {
		this.panelVehiculo = panelVehiculo;
		this.vehiculosDAO = new VehiculosDAO();
	}
	@Override
	public void obtenerVehiculossAlta() {
		List<Vehiculos> listaVehiculos = vehiculosDAO.obtenerVehiculosActivos();
		panelVehiculo.mostrarVehiculos(listaVehiculos);
	}
	@Override
	public void obtenerVehiculosBaja() {
		// TODO Auto-generated method stub
		List<Vehiculos> listaVehiculos = vehiculosDAO.obtenerVehiculosBaja();
		panelVehiculo.mostrarVehiculossHistorial(listaVehiculos);
	}
	
	@Override
	public void obtenerVehiculosTotal() {
		// TODO Auto-generated method stub
		List<Vehiculos> listaVehiculos = vehiculosDAO.obtenerTodosLosVehiculos();
		panelVehiculo.mostrarVehiculos(listaVehiculos);
	}
	@Override
	public void registrarVehiculos(Vehiculos vehiculoRegistrar) {
		if(vehiculoRegistrar != null){
			if(!vehiculosDAO.insertarVehiculos(vehiculoRegistrar)) {
				panelVehiculo.errorEnRegistroDeVehiculos();
			}else {
				panelVehiculo.insercionCorrecta();
				obtenerVehiculossAlta();
			}
				
		}
	}
	@Override
	public void editarVehiculos(String matricula, Vehiculos vehiculoAEditar) {
		// TODO Auto-generated method stub
		if(vehiculoAEditar != null) {
			vehiculosDAO.actualizarEstadoYKmvehiculo(matricula, vehiculoAEditar);
			obtenerVehiculossAlta();
		}
	}
	@Override
	public void buscarVehiculos(String dato) {
		// TODO Auto-generated method stub
		List<Vehiculos> listaEncontrados = vehiculosDAO.buscarVehiculos(dato);
		panelVehiculo.mostrarVehiculos(listaEncontrados);
		
	}
	
	

}
