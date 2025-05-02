package ejercicio5;

import ejercicio1.BinaryTree;
import ejercicio1.Queue;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> a){
		this.arbol = a;
	}
	
	public int sumaElementosProfundidad (int p) {
		if(p < 0) {
			return 0;
		}
		int suma = 0;
		int nivelActual = 0;
		BinaryTree<Integer> nodo;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(this.arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			nodo = cola.dequeue();
			if(nodo != null) {
				if(nivelActual == p) {
					suma += nodo.getData();
				}
				else {
					if(nodo.hasLeftChild()) {
						cola.enqueue(nodo.getLeftChild());
					}
					if(nodo.hasRightChild()) {
						cola.enqueue(nodo.getRightChild());
					}
				}
			}
			else
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					nivelActual++;
				}
		}
		return suma;
	}
}
