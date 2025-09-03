package ar.edu.unlp.info.oo1.balanzaElectronica;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public Producto(String unaDescripcion, double unPeso, double unPrecioPorKilo) {
		this.peso = unPeso;
		this.descripcion = unaDescripcion;
		this.precioPorKilo = unPrecioPorKilo;
	}
	
	public double getPrecio() {
		return (precioPorKilo * peso);
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getPrecioPorKilo() {
		return precioPorKilo;
	}
	
	public void setPrecioPorKilo(double unPrecioPorKilo) {
		this.precioPorKilo = unPrecioPorKilo;
	}
	
}
