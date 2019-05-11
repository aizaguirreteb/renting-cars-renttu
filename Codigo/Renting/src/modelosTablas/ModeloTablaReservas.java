package modelosTablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import auxiliar.Auxiliar;
import modelos.Reserva;

@SuppressWarnings("serial")
public class ModeloTablaReservas extends AbstractTableModel {
	
	private List<Reserva> listaReservas;
	private String[] titulosColumnas = {"DNI","MATRICULA","FECHA","NUMERO DE DIAS","HORA DE RESERVA","RECOGIDA","ESTADO"};

	public ModeloTablaReservas(List<Reserva> listaReservasAMostrar) {
		this.listaReservas = listaReservasAMostrar;
	}
	
	@Override
	public String getColumnName(int column) {
		
		return titulosColumnas[column];
	}
	
	@Override
	public int getColumnCount() {
		//Numero de campos que tiene cada registro
		return 7;
	}

	@Override
	public int getRowCount() {
		//el numero de filas es igual al numero de objetos resera que tiene que pintar la tabla
		//obtenidos de la lista de reservas
		return listaReservas.size();
	}

	@Override
	public Object getValueAt(int indiceFila, int indiceColumna) {
		Reserva reservaObtenida = listaReservas.get(indiceFila);
		
		switch(indiceColumna) {
			case 0: 
				return reservaObtenida.getDniCliente();
			case 1:
				return reservaObtenida.getMatricula();
			case 2:
				return reservaObtenida.getFechaInicio().toString();
			case 3:
				return reservaObtenida.getDiasContratados();
			case 4:
				return reservaObtenida.getHoraReserva();
			case 5:
				return Auxiliar.leerRecogida(reservaObtenida.isRecogida());
			case 6:
				return reservaObtenida.getEstado();
			default:
				return reservaObtenida.getDniCliente();
		}
		
	}
	
	public List<Reserva> getListaReservas(){
		return listaReservas;
	}

}
