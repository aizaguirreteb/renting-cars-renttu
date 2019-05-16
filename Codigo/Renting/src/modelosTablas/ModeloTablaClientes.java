package modelosTablas;
import javax.swing.table.AbstractTableModel;
import modelos.Cliente;
import modelos.Factura;

import java.util.List;


public class ModeloTablaClientes extends AbstractTableModel {
	private List<Cliente> listaClientes;
	private String[] titulosColumnas = {"DNI","POBLACION","NOMBRE",
			"DIRECCION","CODIGO POSTAL","ESTADO","TELEFONO","CARNET DE CONDUCIR",
			"NUMERO DE TARJETA DE CREDITO"};
	
	
	public ModeloTablaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	@Override
	public String getColumnName(int columna) {
		// TODO Auto-generated method stub
		return titulosColumnas[columna];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titulosColumnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaClientes.size();
	}

	@Override
	public Object getValueAt(int indiceFila, int indiceColumna) {
		Cliente clienteObtenido = listaClientes.get(indiceFila);
		
		switch(indiceColumna) {
			case 0: 
				return clienteObtenido.getDni();			
				case 1:
				return clienteObtenido.getPoblacion();
			case 2:
				return clienteObtenido.getNombre();
			case 3:
				return clienteObtenido.getDireccion();
			case 4:
				return clienteObtenido.getCodPostal();
			case 5:
				return clienteObtenido.getEstado().toString();
			case 6:
				return clienteObtenido.getTlf();
			case 7:
				return clienteObtenido.getCarnetConducir();
			case 8:
				return clienteObtenido.getNumTarjCredito();
			
			default:
				return clienteObtenido.getDni();
		}
		
	}
	
	public List<Cliente> getListaCliente(){
		return listaClientes;
	}
	
}
