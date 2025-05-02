package ejercicio3;

import java.util.*;
import ejercicio1.BinaryTree;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public List<Integer> numerosParesInOrden() {
		List<Integer> lista = new LinkedList<Integer>();
		if(this.arbol == null || this.arbol.isEmpty());
		else {
			numerosParesInOrden(this.arbol, lista);
		}
		return lista;
	}
	private void numerosParesInOrden(BinaryTree<Integer> nodo, List<Integer> lista) {
		if (nodo.hasLeftChild()) {
			numerosParesInOrden(nodo.getLeftChild(),lista);
		}
		if(nodo.getData() % 2 == 0) {
			lista.add(nodo.getData());
		}
		if(nodo.hasRightChild()) {
			numerosParesInOrden(nodo.getRightChild(),lista);
		}
	}
	
	public List<Integer> numerosParesPostOrden() {
		List<Integer> lista = new LinkedList<Integer>();
		if(this.arbol == null || this.arbol.isEmpty());
		else {
			numerosParesPostOrden(this.arbol,lista);
		}
		return lista;
	}
	
	private void numerosParesPostOrden(BinaryTree<Integer> nodo, List<Integer> lista) {
		if(nodo.hasLeftChild()) {
			numerosParesPostOrden(nodo.getLeftChild(),lista);
		}
		if(nodo.hasRightChild()) {
			numerosParesPostOrden(nodo.getRightChild(),lista);
		}
		if(nodo.getData() % 2 == 0) {
			lista.add(nodo.getData());
		}
	}
}
