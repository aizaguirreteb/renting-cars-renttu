package modelos;

import java.time.LocalDate;

/**
 * @author PC
 * @version 1.0
 */
public class Alquiler {
	
	private int id, contador, diasContratados;
	private LocalDate fechaInicio;
	private LocalDate fechaEntrega;
	private boolean devolucion, pago, depositoLleno;
	private float precioDia, kmHechos;
	private String dni, matricula;
	
	/**
	 * @param id
	 * @param contador
	 * @param diasContratados
	 * @param fechaInicio
	 * @param fechaEntrega
	 * @param devolucion
	 * @param pago
	 * @param depositoLleno
	 * @param precioDia
	 * @param kmHechos
	 * @param dni
	 * @param matricula
	 */
	public Alquiler(int id, int contador, int diasContratados, LocalDate fechaInicio, LocalDate fechaEntrega,
			boolean devolucion, boolean pago, boolean depositoLleno, float precioDia, float kmHechos, String dni,
			String matricula) {
		this.id = id;
		this.contador = contador;
		this.diasContratados = diasContratados;
		this.fechaInicio = fechaInicio;
		this.fechaEntrega = fechaEntrega;
		this.devolucion = devolucion;
		this.pago = pago;
		this.depositoLleno = depositoLleno;
		this.precioDia = precioDia;
		this.kmHechos = kmHechos;
		this.dni = dni;
		this.matricula = matricula;
	}

	public Alquiler() {}

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
	 * @return the contador
	 */
	public int getContador() {
		return contador;
	}

	/**
	 * @param contador the contador to set
	 */
	public void setContador(int contador) {
		this.contador = contador;
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
	 * @return the fechaEntrega
	 */
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the devolucion
	 */
	public boolean isDevolucion() {
		return devolucion;
	}

	/**
	 * @param devolucion the devolucion to set
	 */
	public void setDevolucion(boolean devolucion) {
		this.devolucion = devolucion;
	}

	/**
	 * @return the pago
	 */
	public boolean isPago() {
		return pago;
	}

	/**
	 * @param pago the pago to set
	 */
	public void setPago(boolean pago) {
		this.pago = pago;
	}

	/**
	 * @return the depositoLleno
	 */
	public boolean isDepositoLleno() {
		return depositoLleno;
	}

	/**
	 * @param depositoLleno the depositoLleno to set
	 */
	public void setDepositoLleno(boolean depositoLleno) {
		this.depositoLleno = depositoLleno;
	}

	/**
	 * @return the precioDia
	 */
	public float getPrecioDia() {
		return precioDia;
	}

	/**
	 * @param precioDia the precioDia to set
	 */
	public void setPrecioDia(float precioDia) {
		this.precioDia = precioDia;
	}

	/**
	 * @return the kmHechos
	 */
	public float getKmHechos() {
		return kmHechos;
	}

	/**
	 * @param kmHechos the kmHechos to set
	 */
	public void setKmHechos(float kmHechos) {
		this.kmHechos = kmHechos;
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
		Alquiler other = (Alquiler) obj;
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

	@Override
	public String toString() {
		return "Alquiler [id=" + id + ", contador=" + contador + ", diasContratados=" + diasContratados
				+ ", fechaInicio=" + fechaInicio + ", fechaEntrega=" + fechaEntrega + ", devolucion=" + devolucion
				+ ", pago=" + pago + ", depositoLleno=" + depositoLleno + ", precioDia=" + precioDia + ", kmHechos="
				+ kmHechos + ", dni=" + dni + ", matricula=" + matricula + "]";
	}	
	
}
