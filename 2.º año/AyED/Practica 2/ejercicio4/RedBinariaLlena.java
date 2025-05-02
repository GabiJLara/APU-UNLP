package ejercicio4;

import ejercicio1.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	public RedBinariaLlena(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public int retardoReenvio() {
		return retardoRecursivo(arbol,0);
	}
	
	private int retardoRecursivo(BinaryTree<Integer> nodo, int total ) {
		int izq = 0;
		int der = 0;
		if(nodo == null) {
			return 0;
		}
		total += nodo.getData();
		if (nodo.isLeaf()) {
			return total;
		}
		if(nodo.hasLeftChild()) {
			izq = retardoRecursivo(nodo.getLeftChild(),total);
		}
		if(nodo.hasRightChild()) {
			der = retardoRecursivo(nodo.getRightChild(), total);
		}
		return Math.max(izq, der);
	}
}
