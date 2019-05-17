package modelosTablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import modelos.Contrato;

public class ModeloTablaContrato extends AbstractTableModel {

	private List<Contrato> listaContrato;
	private String[] titulosColumnas = {"ID","DNI","MATRICULA",
			"FECHA DE INICIO","DIAS CONTRATADOS","RENOVACIONES","ESTADO"};
	
	
	public ModeloTablaContrato(List<Contrato> listaContrato) {
		this.listaContrato = listaContrato;
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
		return listaContrato.size();
	}

	@Override
	public Object getValueAt(int indiceFila, int indiceColumna) {
		// TODO Auto-generated method stub
		Contrato contratoObtenido = listaContrato.get(indiceFila);
		
		switch(indiceColumna) {
			case 0: 
				return contratoObtenido.getId();			
			case 1:
				return contratoObtenido.getDni();
			case 2:
				return contratoObtenido.getMatricula();
			case 3:
				return contratoObtenido.getFechaInicio();
			case 4:
				return contratoObtenido.getDiasContratados();
			case 5:
				return contratoObtenido.getRenovaciones();
			case 6:
				return contratoObtenido.getEstado().toString();
			default:
				return contratoObtenido.getId();
		}
	}
	
	public List<Contrato> getListaContrato(){
		return listaContrato;
	}

}
