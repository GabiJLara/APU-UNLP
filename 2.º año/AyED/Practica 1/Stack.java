package tp1.ejercicio8;

import java.util.ArrayList;

public class Stack <T>{
	ArrayList <T> lista;
	
	public Stack() {
		lista = new ArrayList<T>();
	}
	
	public void push(T dato) {
		lista.add(lista.size(),dato);
	}
	
	public T pop () {
		if (!isEmpty()) {
			return(lista.remove(lista.size()-1));
        	}
		else {
			throw new IllegalStateException("La pila está vacía");
		}
	}
	
	public T top() {
		if(!isEmpty()) {
			return(lista.get(lista.size()-1));
		}
		else {
			throw new IllegalStateException("La pila está vacía");
		}
	}
	
	public int size() {
		return(lista.size());
	}
	
	public boolean isEmpty() {
		return(lista.size()==0);
	}
	
	public String toString() {
		StringBuilder str =  new StringBuilder ("[");
		for(T d: lista) {
			str.append(d).append(", ");
		}
		if (str.length() > 1) {
            str.setLength(str.length() - 2); // Elimina la última coma y espacio
        }
        str.append("]");
        return (str.toString());
	}
}
