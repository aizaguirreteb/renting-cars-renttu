package auxiliar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import modelos.Estado;

public class Auxiliar {
	
	public static DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("YYYY/MM/dd");
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
	
	//METODO PARA COMPROBAR EL ESTADO DE CUALQUIER OBJETO: RESERVA, ALQUILER, VEHHICULO O CLIENTE
	//Devuelve true un objeto enum alta o baja dependiendo de la palabra con la que encaje desde la base de datos
	public static Estado comprobarEstado(String estado) {
		if(estado.toLowerCase().matches("alta")) {
			return Estado.alta;
		} else {
			return Estado.baja;
		}
	}
	
}
