package ejercicio6;

import ejercicio1.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public BinaryTree<Integer> Suma(){
		if(this.arbol == null) {
			return null;
		}
		else if(!this.arbol.hasLeftChild() && !this.arbol.hasRightChild()) {
			return this.arbol;
		}
		BinaryTree<Integer> nuevoArbol = new BinaryTree<Integer>(0);
		SumarPostOrden(this.arbol,nuevoArbol);
		return nuevoArbol;
	}
	
	private int SumarPostOrden(BinaryTree<Integer> nodo, BinaryTree<Integer> nodoNuevo) {
		int izq = 0;
		int der = 0;
		if(nodo.hasLeftChild()) {
			BinaryTree<Integer> nodoIzq = new BinaryTree<Integer>(0);
			izq = SumarPostOrden(nodo.getLeftChild(),nodoIzq);
			nodoNuevo.addLeftChild(nodoIzq);
		}
		if(nodo.hasRightChild()) {
			BinaryTree<Integer> nodoDer = new BinaryTree<Integer>(0);
			der = SumarPostOrden(nodo.getRightChild(),nodoDer);
			nodoNuevo.addRightChild(nodoDer);
		}
		int sumaTotal = izq + der;
		nodoNuevo.setData(sumaTotal);
		return nodo.getData() + sumaTotal;
	}
}
