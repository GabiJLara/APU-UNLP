package tp1.ejercicio8;

import java.util.ArrayList;

public class CircularQueue <T> extends Queue <T> {
	ArrayList <T> lista;
	
	public T shift () {
		if (lista.isEmpty()) {
			throw new IllegalStateException("La cola está vacía, no se puede hacer shift");
		}
		else {
			T elemento = lista.remove(0);
			lista.add(elemento);
			return(elemento);
		}
	}
}
