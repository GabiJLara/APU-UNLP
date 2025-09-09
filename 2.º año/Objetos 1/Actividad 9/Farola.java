package ar.edu.unlp.info.oo1.Ejercicio9_RedDeAlumbrado;

import java.util.List;
import java.util.ArrayList;

public class Farola {
	private Boolean luz;
	private List<Farola> vecinas;
	
	public Farola () { //Crear una farola. Debe inicializarla como apagada
		this.luz = false;
		this.vecinas = new ArrayList<>();
	}
	/*
	* Crea la relación de vecinos entre las farolas.
	* La relación de vecinos entre las farolas es recíproca,
	* es decir el receptor del mensaje será vecino de otraFarola,
	* al igual que otraFarola también se convertirá en vecina del receptor del mensaje.
	*/
	public void pairWithNeighbor( Farola otraFarola ) {
		if(otraFarola != null && !this.vecinas.contains(otraFarola)) {
			this.vecinas.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}

	public List<Farola> getNeighbors (){ //Retorna sus farolas vecinas.
		return this.vecinas;
	}

	public void turnOn() { //Si la farola no está encendida, la enciende y propaga la acción.
		if(!this.luz) {
			this.luz = true;
			vecinas.forEach(f -> f.turnOn());
		}
	}

	public void turnOff() { //Si la farola no está apagada, la apaga y propaga la acción.
		if(this.luz) {
			this.luz = false;
			vecinas.forEach(f -> f.turnOff());

		}
	}
	
	public boolean isOn() { // Retorna true si la farola está encendida.
		return this.luz;
	}
	
	public boolean isOff() { //Retorna true si la farola esta apagada
		return !this.luz;
	}
}
