package ejercicio7;

import ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles (BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public boolean isLeftTree (int num) {
		if (this.arbol == null) return false;
		BinaryTree<Integer> nodo = buscarNum(this.arbol, num);
		if (nodo == null) return false;
		int izq = -1; int der = -1;
		if(nodo.hasLeftChild()) {
			izq = contarHijosUnicos(nodo.getLeftChild());
		}
		if(nodo.hasRightChild()) {
			der = contarHijosUnicos(nodo.getRightChild());
		}
		return(izq > der);
	}
	
	private BinaryTree<Integer> buscarNum(BinaryTree<Integer> nodo, int num){
		if(nodo == null || nodo.getData() == num) return nodo;
		else {
			BinaryTree<Integer> nodoAux = null;
			
			if(nodo.hasLeftChild()) {
				nodoAux = buscarNum(nodo.getLeftChild(),num);
			}
			if (nodoAux != null) return nodoAux;
			if(nodo.hasRightChild()) {
				nodoAux = buscarNum(nodo.getRightChild(),num);
			}
			return nodoAux;
		}
	}
	
	private int contarHijosUnicos(BinaryTree<Integer> a) {
		if(a.isLeaf()) return 0;
		if(a.hasLeftChild() && a.hasRightChild()) 
			return contarHijosUnicos(a.getLeftChild()) + contarHijosUnicos(a.getRightChild());
		else if(a.hasLeftChild()) 
			return contarHijosUnicos(a.getLeftChild()) + 1;
		else {
			return contarHijosUnicos(a.getRightChild()) + 1;
		}
	}
}
