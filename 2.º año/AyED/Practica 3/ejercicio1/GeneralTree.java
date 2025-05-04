package ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		if(this.isLeaf()) {
			return 0;
		}
		int maxAltura = 0;
		for (GeneralTree<T> child : this.getChildren()) {
			maxAltura = Math.max(maxAltura, child.altura());
		}
		return maxAltura + 1;
	}
	
	public int nivel(T dato){
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int nivelActual = 0;
		GeneralTree<T> aux;
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				if(aux.getData().equals(dato)) {
					return nivelActual;
				}
				if(aux.hasChildren()) {
					for(GeneralTree<T> child: aux.getChildren()) {
						cola.enqueue(child);
					}
				}
			}
			else {
				if(!cola.isEmpty()) {
					nivelActual++;
					cola.enqueue(null);
				}
			}
		}
		return -1; // De no encontrarse nivel del dato = -1 (NO EXISTE)
	  }

	public int ancho(){
		if(this.isEmpty() || this == null) return 0;
		else {
			Queue <GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
			cola.enqueue(this);
			cola.enqueue(null);
			GeneralTree<T> aux;
			int maxAncho = Integer.MIN_VALUE;
			int anchoNivel = 0;
			while(!cola.isEmpty()) {
				aux = cola.dequeue();
				if(aux != null) {
					anchoNivel++;
					if(aux.hasChildren()) {
						for (GeneralTree<T> child : aux.getChildren()) {
							cola.enqueue(child);
						}
					}
				}
				else {
					maxAncho = Math.max(maxAncho, anchoNivel);
					if(!cola.isEmpty()) {
						cola.enqueue(null);
					}
				}
			}
			return maxAncho;
		}
	}
}
