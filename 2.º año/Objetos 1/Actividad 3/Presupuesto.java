package ar.edu.unlp.info.oo1.Ejercicio3_Presupuesto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto extends Object {
	private LocalDate fecha;
	private String cliente;
	private List<Item> listaDeItems;
	
	public Presupuesto (String unCliente) {
		this.fecha = LocalDate.now();
		this.cliente = unCliente;
		this.listaDeItems = new ArrayList<Item>();
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void agregarItem(Item unItem) {
		this.listaDeItems.add(unItem);
	}
	
	public double calcularTotal() {
		return (listaDeItems.stream().mapToDouble(item -> item.costo()).sum());
	}
}
