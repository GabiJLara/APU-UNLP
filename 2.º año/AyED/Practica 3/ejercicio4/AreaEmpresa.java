package ejercicio4;

public class AreaEmpresa {
	private String identificacion;
	private int tardanza;
	
	public AreaEmpresa( String unaIdentificacion, int unaTardanza) {
		this.setIdentificacion(unaIdentificacion);
		this.setTardanza(unaTardanza);
	}
	
	public String getIdentificacion() {
		return identificacion;
	}

	private void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public int getTardanza() {
		return tardanza;
	}

	private void setTardanza(int tardanza) {
		this.tardanza = tardanza;
	}
}
