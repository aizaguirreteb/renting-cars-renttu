package modelosTablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import auxiliar.Auxiliar;
import modelos.Vehiculos;

public class ModeloTablasVehiculos extends AbstractTableModel{
	private List<Vehiculos> vehiculos ;
	private String[] titulosColumnas = {"MATRICULA","CATEGORIA","MARCA","COMBUSTIBLE",
			"NUMERO PUERTAS","POTENCIA","AÑO","TARA MAXIMA","ESTADO","REVISION",
			"KM PARCIALES","PLAZAS","KM TOTALES","PRECIO DIA"};
	public ModeloTablasVehiculos(List<Vehiculos> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public String getColumnName(int column) {

		return titulosColumnas[column];
	}

	@Override
	public int getColumnCount() {
		//Numero de campos que tiene cada registro
		return titulosColumnas.length;
	}

	@Override
	public int getRowCount() {
		//el numero de filas es igual  numero de objetos resera que tiene que pintar la tabla
		return vehiculos.size();
	}

	@Override
	public Object getValueAt(int indiceFila, int indiceColumna) {
		Vehiculos vehiculoObtenido = vehiculos.get(indiceFila);

		switch(indiceColumna) {
		case 0: 
			return vehiculoObtenido.getMatricula();
		case 1:
			return vehiculoObtenido.getCategoria().toString();
		case 2:
			return vehiculoObtenido.getMarca();
		case 3:
			return vehiculoObtenido.getCombustible().toString();
		case 4:
			return vehiculoObtenido.getNumPuertas();
		case 5:
			return vehiculoObtenido.getPotencia();
		case 6:
			return vehiculoObtenido.getTaraMax();
		case 7:
			return vehiculoObtenido.getEstado().toString();
		case 8:
			return Auxiliar.leerRecogida(vehiculoObtenido.getRevision());
		case 9:
			return vehiculoObtenido.getKmParciales();
		case 10:
			return vehiculoObtenido.getPlazas();
		case 11:
			return vehiculoObtenido.getKmTotales();
		case 12:
			return vehiculoObtenido.getPrecioDia();
		
		default:
			return vehiculoObtenido.getMatricula();
		}

	}

	public List<Vehiculos> getListaVehiculos(){
		return vehiculos;
	}




}
