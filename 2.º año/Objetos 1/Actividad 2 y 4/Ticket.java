package ar.edu.unlp.info.oo1.balanzaElectronica;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
	private LocalDate fecha;
	private List<Producto> listaDeProductos;
	
	public Ticket (List<Producto> unaListaDeProductos) {
		this.fecha = LocalDate.now();
		this.listaDeProductos = unaListaDeProductos.stream()
				.map(p -> new Producto(p.getDescripcion(), p.getPeso(), p.getPrecioPorKilo()))
			    .toList();
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public int getCantidadDeProductos() {
		return (this.listaDeProductos.size());
	}
	
	public double getPesoTotal() {
		return (this.listaDeProductos.stream().mapToDouble(producto -> producto.getPeso()).sum());
	}
	
	public double getPrecioTotal() {
		return (this.listaDeProductos.stream().mapToDouble(producto -> producto.getPrecio()).sum());
	}
	public double impuesto() {
		return (this.getPrecioTotal() * 0.21);
	}
	
	public List<Producto> getProductos(){
		return listaDeProductos;
	}
	
}
