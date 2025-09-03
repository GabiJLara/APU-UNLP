package ar.edu.unlp.info.oo1.Ejercicio3_Presupuesto;

public class Item extends Object {
	@SuppressWarnings("unused")
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public Item (String unDetalle, int unaCantidad, double unCostoUnitario) {
			this.detalle = unDetalle;
			this.cantidad = unaCantidad;
			this.costoUnitario = unCostoUnitario;
	}
	
	public double getCostoUnitario() {
		return costoUnitario;
	}
	
	public double costo() {
		return (this.getCostoUnitario() * this.cantidad);
	}
}
