package ar.edu.unlp.info.oo1.Ejercicio5_FigurasYCuerpos;

public class Circulo extends Figura {
	private double radio;  //Solo hace falta conocer el radio, mediante el podemos sacar todas las demas caracteristicas del circulo.
	
	public double getDiametro() {
		return (this.getRadio() * 2);
	}
	
	public double getRadio() {
		return radio;
	}
	
	public void setRadio(double unRadio) {
		this.radio = unRadio;
	}
	
	public double getPerimetro() {
		return (this.getRadio() * 2 * Math.PI);
	}
	
	public double getArea() {
		return (this.getRadio()*this.getRadio() * Math.PI);
	}
	
}
