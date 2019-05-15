package auxiliar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import modelos.Categoria;
import modelos.Combustible;
import modelos.Estado;

public class Auxiliar {
	
	public static DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	
	//METODOS PARA FORMATEAR FECHAS Y HORAS
	//				    |
	//    				|
	//					v
	public static LocalDate formatearFecha (String fechaAFormatear) {
		return LocalDate.parse(fechaAFormatear, formatterFecha);
	}
	
	public static LocalTime formatearHora(String horaAFormatear) {
		return LocalTime.parse(horaAFormatear, formatterHora);
	}
	
	
	
	
	//METODO PARA COMPROBAR LA RECOGIDA DEL COCHE RESERVADO
	//Devuelve true si en la base de datos la tenemos como SI
	public static boolean comprobarRecogida(String recogida) {
		return recogida.toLowerCase().matches("si");
	}
	
	//METODO PARA LEER EL BOOLEANO DE LA RECOGIDA E INSERTAR EN LA BASE DE DATOS LO QUE CORRESPONDE
	public static String leerRecogida (boolean recogida) {
		if(recogida) {
			return "SI";
		}
		return "NO";
	}
	
	//METODO PARA COMPROBAR EL ESTADO DE CUALQUIER OBJETO: RESERVA, ALQUILER, VEHHICULO O CLIENTE
	//Devuelve true un objeto enum alta o baja dependiendo de la palabra con la que encaje desde la base de datos
	public static Estado comprobarEstado(String estado) {
		if(estado.toLowerCase().matches("alta")) {
			return Estado.alta;
		} else {
			return Estado.baja;
		}
	}
	
	public static Combustible tipoCombustible(String combustible) {
		if(combustible.toLowerCase().matches("diesel")) {
			return Combustible.diesel;
		}if(combustible.toLowerCase().matches("gasolina")) {
			return Combustible.gasolina;
		}if(combustible.toLowerCase().matches("electrico")) {
			return Combustible.electrico;
		}else 
			return Combustible.hibrido;
		
	}
	
		
		public static Categoria  tipoCategoria(String categoria) {
			if(categoria.toLowerCase().matches("transporte")) {
				return Categoria.Transporte;
			} else 
				return Categoria.Turismo;
			
		}
	
}