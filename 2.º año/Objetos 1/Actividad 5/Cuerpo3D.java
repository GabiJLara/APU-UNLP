package ar.edu.unlp.info.oo1.Ejercicio5_FigurasYCuerpos;

public class Cuerpo3D {
	private double altura;
	private Figura caraBasal;
	
	public void setAltura(double unaAltura) {
		this.altura = unaAltura;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setCaraBasal(Figura unaCara) {
		this.caraBasal = unaCara;
	}
	
	public double getVolumen() {
		return(caraBasal.getArea() * this.getAltura());
	}
	
	public double getSuperficieExterior() {
		return (2 * caraBasal.getArea() + caraBasal.getPerimetro() * this.getAltura());
	}
}
