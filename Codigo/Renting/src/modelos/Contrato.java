package modelos;

import java.time.LocalDate;

/**
 * @author José Luis Gómez López
 * @version 1.0
 */
public class Contrato {
	
	private int id, renovaciones, diasContratados;
	private LocalDate fechaInicio;
	private String dni, matricula;
	private Estado estado;
	
	/**
	 * @param id
	 * @param renovaciones
	 * @param diasContratados
	 * @param fechaInicio
	 * @param dni
	 * @param matricula
	 */
	public Contrato(int id, String dni, String matricula, LocalDate fechaInicio, int diasContratados, int renovaciones,   
			Estado estado) {
		this.id = id;
		this.renovaciones = renovaciones;
		this.diasContratados = diasContratados;
		this.fechaInicio = fechaInicio;
		this.dni = dni;
		this.matricula = matricula;
	}

	public Contrato() {}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the renovaciones
	 */
	public int getRenovaciones() {
		return renovaciones;
	}

	/**
	 * @param contador the renovaciones to set
	 */
	public void setRenovaciones(int contador) {
		this.renovaciones = contador;
	}

	/**
	 * @return the diasContratados
	 */
	public int getDiasContratados() {
		return diasContratados;
	}

	/**
	 * @param diasContratados the diasContratados to set
	 */
	public void setDiasContratados(int diasContratados) {
		this.diasContratados = diasContratados;
	}

	/**
	 * @return the fechaInicio
	 */
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrato other = (Contrato) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return String.format(
				"Contrato [id=%s, renovaciones=%s, diasContratados=%s, fechaInicio=%s, dni=%s, matricula=%s, estado=%s]",
				id, renovaciones, diasContratados, fechaInicio, dni, matricula, estado);
	}
	
}
