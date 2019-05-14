package modelos;

/**
 * @author José Luis Gómez López
 *
 */
public class Factura {

//	BASE DE DATOS:
//	ID_CONTRATO INT NOT NULL,
//	DNI VARCHAR(10) NOT NULL,
//	MATRICULA VARCHAR(10) NOT NULL,
//	FECHA_INICIO_CONTRATO VARCHAR(10) NOT NULL,
//	KM_RECORRIDOS INT DEFAULT 0,
//	PRECIO_DIA DOUBLE NOT NULL,
//	CARGO_RETRASO INT DEFAULT 0,
//	CARGO_DEPOSITO INT DEFAULT 0,
//	DESCUENTO_DIA DOUBLE DEFAULT 0,
//	TOTAL DOUBLE DEFAULT 0,
	
	private int idContrato, kmRecorridos = 0, cargoRetraso = 0, cargoDeposito = 0;
	private String dni, matricula;
	private float precioDia, descuentoPorDia = 0.5f, total = 0;
	
	/**
	 * @param idContrato
	 * @param dni
	 * @param matricula
	 * @param precioDia
	 */
	public Factura(int idContrato, String dni, String matricula, float precioDia) {
		this.idContrato = idContrato;
		this.dni = dni;
		this.matricula = matricula;
		this.precioDia = precioDia;
	}

	/**
	 * @param idContrato
	 * @param kmRecorridos
	 * @param cargoRetraso
	 * @param cargoDeposito
	 * @param dni
	 * @param matricula
	 * @param precioDia
	 * @param descuentoPorDia
	 * @param total
	 */
	public Factura(int idContrato, int kmRecorridos, int cargoRetraso, int cargoDeposito, String dni, String matricula,
			float precioDia, float descuentoPorDia, float total) {
		this.idContrato = idContrato;
		this.kmRecorridos = kmRecorridos;
		this.cargoRetraso = cargoRetraso;
		this.cargoDeposito = cargoDeposito;
		this.dni = dni;
		this.matricula = matricula;
		this.precioDia = precioDia;
		this.descuentoPorDia = descuentoPorDia;
		this.total = total;
	}



	/**
	 * @return the idContrato
	 */
	public int getIdContrato() {
		return idContrato;
	}

	/**
	 * @param idContrato the idContrato to set
	 */
	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	/**
	 * @return the kmRecorridos
	 */
	public int getKmRecorridos() {
		return kmRecorridos;
	}

	/**
	 * @param kmRecorridos the kmRecorridos to set
	 */
	public void setKmRecorridos(int kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	/**
	 * @return the cargoRetraso
	 */
	public int getCargoRetraso() {
		return cargoRetraso;
	}

	/**
	 * @param cargoRetraso the cargoRetraso to set
	 */
	public void setCargoRetraso(int cargoRetraso) {
		this.cargoRetraso = cargoRetraso;
	}

	/**
	 * @return the cargoDeposito
	 */
	public int getCargoDeposito() {
		return cargoDeposito;
	}

	/**
	 * @param cargoDeposito the cargoDeposito to set
	 */
	public void setCargoDeposito(int cargoDeposito) {
		this.cargoDeposito = cargoDeposito;
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
	 * @return the descuentoPorDia
	 */
	public float getDescuentoPorDia() {
		return descuentoPorDia;
	}

	/**
	 * @param descuentoPorDia the descuentoPorDia to set
	 */
	public void setDescuentoPorDia(float descuentoPorDia) {
		this.descuentoPorDia = descuentoPorDia;
	}

	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idContrato;
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
		Factura other = (Factura) obj;
		if (idContrato != other.idContrato)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Factura [idContrato=%s, kmRecorridos=%s, cargoRetraso=%s, cargoDeposito=%s, dni=%s, matricula=%s, precioDia=%s, descuentoPorDia=%s, total=%s]",
				idContrato, kmRecorridos, cargoRetraso, cargoDeposito, dni, matricula, precioDia, descuentoPorDia,
				total);
	}	
	
}
