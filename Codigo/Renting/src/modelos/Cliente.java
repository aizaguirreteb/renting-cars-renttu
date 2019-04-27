package modelos;

public class Cliente {
	
	private String dni;
	private String poblacion;
	private String nombre;
	private String direccion;
	private String codPostal;
	private Estado estado;
	private int tlf;
	private String carnetConducir;
	private int numTarjCredito;
	
	
	
	
	public Cliente(String dni, String poblacion, String nombre, String direccion, String codPostal, Estado estado,
			int tlf, String carnetConducir, int numTarjCredito) {
		super();
		this.dni = dni;
		this.poblacion = poblacion;
		this.nombre = nombre;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.estado = estado;
		this.tlf = tlf;
		this.carnetConducir = carnetConducir;
		this.numTarjCredito = numTarjCredito;
	}




	public String getDni() {
		return dni;
	}




	public void setDni(String dni) {
		this.dni = dni;
	}




	public String getPoblacion() {
		return poblacion;
	}




	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public String getCodPostal() {
		return codPostal;
	}




	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}




	public Estado getEstado() {
		return estado;
	}




	public void setEstado(Estado estado) {
		this.estado = estado;
	}




	public int getTlf() {
		return tlf;
	}




	public void setTlf(int tlf) {
		this.tlf = tlf;
	}




	public String getCarnetConducir() {
		return carnetConducir;
	}




	public void setCarnetConducir(String carnetConducir) {
		this.carnetConducir = carnetConducir;
	}




	public int getNumTarjCredito() {
		return numTarjCredito;
	}




	public void setNumTarjCredito(int numTarjCredito) {
		this.numTarjCredito = numTarjCredito;
	}




	@Override
	public String toString() {
		return "El cliente " + nombre + " con dni " + dni + " en la poblacion de " + poblacion + " con codigo postal " + codPostal
				+ " con la direccion " + direccion + " dado de " + estado + " con el teléfono " + tlf + " cuyo carnet de conducir es: " + carnetConducir;
	}
	
	
	
}
