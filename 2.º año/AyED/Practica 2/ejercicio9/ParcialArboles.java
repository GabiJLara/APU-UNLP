package ejercicio9;

import ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Informacion> arbol;     //NO SE USA PREGUNTAR SI ES NECESARIO
	
	public ParcialArboles(BinaryTree<Informacion> a) {
		this.arbol = a;
	}
	
	public BinaryTree<Informacion> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<Informacion> resul = new BinaryTree<Informacion>();
		if(arbol == null || arbol.isEmpty()) return resul;
		else {
			sumaAndDifProfundidad(arbol,resul, 0);
			return resul;
		}
	}
	
	private void sumaAndDifProfundidad(BinaryTree<Integer> nodo, BinaryTree<Informacion> resul, int num) {
		if(nodo.getData() != null) {
			int act = nodo.getData();
			Informacion aux = new Informacion(num + act,act - num);
			resul.setData(aux);
			if (nodo.hasLeftChild()) {
				resul.addLeftChild(new BinaryTree<Informacion>());
				sumaAndDifProfundidad(nodo.getLeftChild(),resul.getLeftChild(),aux.getSuma());
			}
			if(nodo.hasRightChild()) {
				resul.addRightChild(new BinaryTree<Informacion>());
				sumaAndDifProfundidad(nodo.getRightChild(),resul.getRightChild(),aux.getSuma());
			}
		}

	}
}
