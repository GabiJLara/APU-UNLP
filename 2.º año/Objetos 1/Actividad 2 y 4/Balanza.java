package ar.edu.unlp.info.oo1.balanzaElectronica;

import java.util.List;
import java.util.ArrayList;

public class Balanza {
	private List<Producto> listaDeProductos = new ArrayList<Producto>();
	
	public List<Producto> getProductos(){
		return listaDeProductos;
	}
	
	public int getCantidadDeProductos() {
		return (this.listaDeProductos.size());
	}
	
	public double getPrecioTotal() {
		return (this.listaDeProductos.stream().mapToDouble(producto -> producto.getPrecio()).sum());
	}
	
	public double getPesoTotal() {
		return (this.listaDeProductos.stream().mapToDouble(producto -> producto.getPeso()).sum());
	}
	
	public void ponerEnCero() {
		this.listaDeProductos.clear();
	}
	
	public void agregarProducto (Producto unProducto) {
		this.listaDeProductos.add(unProducto);
	}
	
	public	Ticket emitirTicket() {
		return(new Ticket(this.listaDeProductos));
	}
	
}
