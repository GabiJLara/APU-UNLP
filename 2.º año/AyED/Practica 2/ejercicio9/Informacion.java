package ejercicio9;

public class Informacion {
	private int suma;
	private int diferencia;
	
	public Informacion(int unaSuma, int unaDif) {
		this.setSuma(unaSuma);
		this.setDiferencia(unaDif);
	}
	
	public int getSuma() {
		return suma;
	}
	private void setSuma(int suma) {
		this.suma = suma;
	}
	public int getDiferencia() {
		return diferencia;
	}
	private void setDiferencia(int diferencia) {
		this.diferencia = diferencia;
	}
	
}
