package ar.edu.unlp.info.oo1.Ejercicio5_FigurasYCuerpos;

public class Cuadrado extends Figura {
	private double lado;
	
	public void setLado(double unLado) {
		this.lado = unLado;
	}
	
	public double getLado() {
		return lado;
	}
	
	public double getPerimetro() {
		return (this.getLado() * 4);
	}
	
	public double getArea() {
		return (this.getLado() * this.getLado());
	}
}
