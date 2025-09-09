package ar.edu.unlp.info.oo1.Ejercicio8_Genealogia;

import java.time.LocalDate;

public class Mamifero {
	private String nombre;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero(String unNombre) {
		this.nombre = unNombre;
	}
	public Mamifero() {
		
	}
	
	public String getIdentificador() {
		return nombre;
	}
	
	public void setIdentificador (String unNombre) {
		this.nombre = unNombre;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String unaEspecie) {
		this.especie = unaEspecie;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate unaFechaNacimiento) {
		this.fechaNacimiento = unaFechaNacimiento;
	}
	
	public Mamifero getPadre() {
		return padre;
	}
	
	public void setPadre(Mamifero unPadre) {
		this.padre = unPadre;
	}
	
	public Mamifero getMadre() {
		return madre;
	}
	
	public void setMadre(Mamifero unaMadre) {
		this.madre = unaMadre;
	}
	
	public Mamifero getAbueloMaterno() {
		return (this.madre != null) ? this.madre.getPadre() : null;
	}
	
	public Mamifero getAbuelaMaterna() {
		return (this.madre != null) ? this.madre.getMadre() : null;
	}
	
	public Mamifero getAbueloPaterno() {
		return (this.padre != null) ? this.padre.getPadre() : null;
	}
	
	public Mamifero getAbuelaPaterna() {
		return (this.padre != null) ? this.padre.getMadre() : null;
	}
	
	public Boolean tieneComoAncestroA(Mamifero unMamifero) {
		if(unMamifero == null) {
			return false;
		}
		if(this.padre == unMamifero || this.madre == unMamifero) {
			return true;
		}
		else {
			if(this.padre != null && this.padre.tieneComoAncestroA(unMamifero)) {
				return true;
			}
			if(this.madre != null && this.madre.tieneComoAncestroA(unMamifero)){
				return true;
			}
		}
		return false;
	}
}
