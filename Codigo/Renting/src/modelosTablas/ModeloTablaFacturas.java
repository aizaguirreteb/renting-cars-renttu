package modelosTablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import modelos.Factura;

public class ModeloTablaFacturas extends AbstractTableModel  {
	
	private List<Factura> listaFacturas;
	private String[] titulosColumnas = {"ID","DNI","MATRICULA",
			"FECHA INICIO","KM RECORRIDOS","PRECIO POR DIA","CARGO RETRASO",
			"CARGO DEPOSITO", "DESCUENTO POR DIA", "TOTAL"};
	
	public ModeloTablaFacturas(List<Factura> listaFacturasAMostrar) {
		this.listaFacturas = listaFacturasAMostrar;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaFacturas.size();
	}

	@Override
	public Object getValueAt(int indiceFila, int indiceColumna) {
		Factura facturaObtenida = listaFacturas.get(indiceFila);
		
		switch(indiceColumna) {
			case 0: 
				return facturaObtenida.getIdContrato();
			case 1:
				return facturaObtenida.getDni();
			case 2:
				return facturaObtenida.getMatricula();
			case 3:
				//return facturaObtenida.getFechaInicio().toString();
			case 4:
				return facturaObtenida.getKmRecorridos();
			case 5:
				return facturaObtenida.getPrecioDia();
			case 6:
				return facturaObtenida.getCargoRetraso();
			case 7:
				return facturaObtenida.getCargoDeposito();
			case 8:
				return facturaObtenida.getDescuentoPorDia();
			case 9:
				return facturaObtenida.getTotal();
			default:
				return facturaObtenida.getDni();
		}
		
	}
	
	public List<Factura> getListaFacturas(){
		return listaFacturas;
	}
}
