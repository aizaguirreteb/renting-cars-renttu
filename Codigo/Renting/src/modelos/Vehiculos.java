package modelos;

import java.time.LocalDate;

public class Vehiculos {
	private String matricula;
	private Categoria categoria;
	private String marca;
	private Combustible combustible;
	private String numPuertas;
	private int potencia;
	private LocalDate anio;
	private int TaraMax;
	private String estado;
	private Revision revision ;
	private int KmParciales;
	private String plazas;
	private int KmTotales;
	private double PrecioDia;
	public Vehiculos(String matricula, Categoria categoria, String marca, Combustible combustible, String numPuertas,
			int potencia, LocalDate anio, int taraMax, String estado, Revision revision, int kmParciales, String plazas,
			int kmTotales, double precioDia) {
		super();
		this.matricula = matricula;
		this.categoria = categoria;
		this.marca = marca;
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
	public String getNumPuertas() {
		return numPuertas;
	}
	public void setNumPuertas(String numPuertas) {
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Revision getRevision() {
		return revision;
	}
	public void setRevision(Revision revision) {
		this.revision = revision;
	}
	public int getKmParciales() {
		return KmParciales;
	}
	public void setKmParciales(int kmParciales) {
		KmParciales = kmParciales;
	}
	public String getPlazas() {
		return plazas;
	}
	public void setPlazas(String plazas) {
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
