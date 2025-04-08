package practica1;

public class Estudiante {
	
	private String nombre;
	private String apellido;
	private String comision;
	private String email;
	private String direccion;
	
	public Estudiante (String unNombre, String unApellido, String unaComision, String unEmail, String unaDireccion) {
		this.setApellido(unApellido);
		this.setComision(unaComision);
		this.setDireccion(unaDireccion);
		this.setEmail(unEmail);
		this.setNombre(unNombre);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos() {
		String aux;
		aux = "Nombre: " + this.getNombre() + ", Apellido: "+ this.getApellido()+ ", Comision: "+ this.getComision()+ ", Email: "+ this.getEmail()+ ", Direccion: "+ this.getDireccion();
		return(aux);
	}
}
