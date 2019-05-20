package auxiliar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import modelos.Categoria;
import modelos.Combustible;
import modelos.Estado;

public class Auxiliar {
	
	//Arrays para los combobox
		public static String[] arrayEstado = {"alta", "baja"};
		
		//Clientes
		public static String[] arrayCarnet = {"B","B+E","C1"};
		
		//Vehiculos
		public static String[] arrayNumPuertas = {"3","5","6"};
		public static String[] arrayAnios = {"2009","2010","2011","2012","2013","2014","2015",
				"2016", "2017", "2018", "2019", "2020", "2021", "2022","2023", "2024","2025"};
		public static String[] arrayCombustible = {"diesel","gasolina","hibrido","electrico"};
		public static String[] arrayTipoVehiculo = {"Transporte", "Turismo"};
		public static String[] arrayRevisionRecogida = {"SI","NO"};
		public static String[] arrayPlazas = {"2","4","5","7","8"};
		
		public static DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		public static DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		public static DateTimeFormatter formatterVehiculos = DateTimeFormatter.ofPattern("yyyy");
		
		//Reserva & Contrato
		public static String[] arrayYear = {"2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
		public static String[] arrayMes = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		public static String[] arrayDia = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20",
				"21","22","23","24","25","26","27","28","29","30","31"};
		public static String[] arrayDiasContratados = {"1","2","3","4","5"};
		public static String[] arrayRenovaciones = {"0","1","2","3"};
		
		//metodo para leer el dato del combo box 
		public static int leerComboBox (String dato, String[] arrayCorrespondiente) {
			for (int i = 0; i < arrayCorrespondiente.length; i++) {
				if(arrayCorrespondiente[i].equals(dato)) {
					return i;
				}
			}
			return 0;
		}
	
	
	
	
	//METODOS PARA FORMATEAR FECHAS Y HORAS
	//				    |
	//    				|
	//					v
	public static LocalDate formatearFecha (String fechaAFormatear) {
		return LocalDate.parse(fechaAFormatear, formatterFecha);
	}
	
	public static LocalDate formatearFechaVehiculos (String fechaAFormatear) {
		return LocalDate.parse(fechaAFormatear, formatterVehiculos);
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