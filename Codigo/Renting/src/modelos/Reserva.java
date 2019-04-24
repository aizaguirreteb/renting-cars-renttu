package modelos;

import java.time.Clock;
import java.time.LocalDate;

/*
 * Clase Reserva que genera objetos de tipo Reserva de vehículo por un cliente
 */
public class Reserva {
	
	private String dniCliente;
	private String matricula;
	private LocalDate fechaInicio;
	private int diasContratados;
	private Clock horaReserva; //De tipo Clock para controlar la hora de la reserva y medir las dos horas de plazo para la recogida
	private boolean recogida;
	
	public Reserva(String dniCliente, String matricula, LocalDate fechaInicio, int diasContratados, Clock horaReserva,
			boolean recogida) {
		super();
		this.dniCliente = dniCliente;
		this.matricula = matricula;
		this.fechaInicio = fechaInicio;
		this.diasContratados = diasContratados;
		this.horaReserva = horaReserva;
		this.recogida = recogida;
	}
	
	@Override
	public String toString() {
		return "Reserva [dniCliente=" + dniCliente + ", matricula=" + matricula + ", fechaInicio=" + fechaInicio
				+ ", diasContratados=" + diasContratados + ", horaReserva=" + horaReserva + ", recogida=" + recogida
				+ "]";
	}

	//Constructor por defecto
	public Reserva() {}
	
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public int getDiasContratados() {
		return diasContratados;
	}
	public void setDiasContratados(int diasContratados) {
		this.diasContratados = diasContratados;
	}
	public Clock getHoraReserva() {
		return horaReserva;
	}
	public void setHoraReserva(Clock horaReserva) {
		this.horaReserva = horaReserva;
	}
	public boolean isRecogida() {
		return recogida;
	}
	public void setRecogida(boolean recogida) {
		this.recogida = recogida;
	}
	
	
	
}
