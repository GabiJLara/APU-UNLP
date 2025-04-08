package tp1.ejercicio8;

import java.util.LinkedList;

public class DoubleEndedQueue <T> extends Queue <T> {
	LinkedList <T> lista;
	
	public void enqueueFirst(T dato) {
		lista.addFirst(dato);
	}
}
