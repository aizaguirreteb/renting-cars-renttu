package modelos;

import java.time.LocalDate;

public class Vehiculos {
	private String matricula;
	private Categoria categoria;
	private String marca;
	private String modelo;
	private Combustible combustible;
	private int numPuertas;
	private int potencia;
	private LocalDate anio;
	private int TaraMax;
	private Estado estado;
	private boolean revision ;
	private int KmParciales;
	private int plazas;
	private int KmTotales;
	private double PrecioDia;
	
	public Vehiculos(String matricula, Categoria categoria, String marca,String modelo, Combustible combustible,int numPuertas,
			int potencia, LocalDate anio, int taraMax, Estado estado, boolean revision, int kmParciales, int plazas,
			int kmTotales, double precioDia) {
		
		this.matricula = matricula;
		this.categoria = categoria;
		this.marca = marca;
		this.modelo = modelo;
		this.combustible = combustible;
		this.numPuertas = numPuertas;
		this.potencia = potencia;
		this.anio = anio;
		TaraMax = taraMax;
		this.estado = estado;
		this.revision = revision;
		KmParciales = kmParciales;
		this.plazas = plazas;
		KmTotales = kmTotales;
		PrecioDia = precioDia;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Combustible getCombustible() {
		return combustible;
	}
	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}
	public int getNumPuertas() {
		return numPuertas;
	}
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public LocalDate getAnio() {
		return anio;
	}
	public void setAnio(LocalDate anio) {
		this.anio = anio;
	}
	public int getTaraMax() {
		return TaraMax;
	}
	public void setTaraMax(int taraMax) {
		TaraMax = taraMax;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public boolean getRevision() {
		return revision;
	}
	public void setRevision(boolean revision) {
		this.revision = revision;
	}
	public int getKmParciales() {
		return KmParciales;
	}
	public void setKmParciales(int kmParciales) {
		KmParciales = kmParciales;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	public int getKmTotales() {
		return KmTotales;
	}
	public void setKmTotales(int kmTotales) {
		KmTotales = kmTotales;
	}
	public double getPrecioDia() {
		return PrecioDia;
	}
	public void setPrecioDia(double precioDia) {
		PrecioDia = precioDia;
	}
	@Override
	public String toString() {
		return "Vehiculos [matricula=" + matricula + ", categoria=" + categoria + ", marca=" + marca + ", combustible="
				+ combustible + ", numPuertas=" + numPuertas + ", potencia=" + potencia + ", anio=" + anio
				+ ", TaraMax=" + TaraMax + ", estado=" + estado + ", revision=" + revision + ", KmParciales="
				+ KmParciales + ", plazas=" + plazas + ", KmTotales=" + KmTotales + ", PrecioDia=" + PrecioDia + "]";
	}
	
	
}