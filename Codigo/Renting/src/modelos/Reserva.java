package modelos;


import java.time.LocalDate;
import java.time.LocalTime;

/*
 * Clase Reserva que genera objetos de tipo Reserva de vehículo por un cliente
 */
public class Reserva {
	
	private String dniCliente;
	private String matricula;
	private LocalDate fechaInicio;
	private int diasContratados;
	private LocalTime horaReserva; 
	private boolean recogida;
	private Estado estado;
	
	
	public Reserva(String dniCliente, String matricula, LocalDate fechaInicio, int diasContratados, LocalTime horaReserva,
			boolean recogida, Estado estado) {
		
		this.dniCliente = dniCliente;
		this.matricula = matricula;
		this.fechaInicio = fechaInicio;
		this.diasContratados = diasContratados;
		this.horaReserva = horaReserva;
		this.recogida = recogida;
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Reserva [dniCliente=" + dniCliente + ", matricula=" + matricula + ", fechaInicio=" + fechaInicio
				+ ", diasContratados=" + diasContratados + ", horaReserva=" + horaReserva + ", recogida=" + recogida
				+ ", estado=" + estado +"]";
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
	public LocalTime getHoraReserva() {
		return horaReserva;
	}
	public void setHoraReserva(LocalTime horaReserva) {
		this.horaReserva = horaReserva;
	}
	public boolean isRecogida() {
		return recogida;
	}
	public void setRecogida(boolean recogida) {
		this.recogida = recogida;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
}
