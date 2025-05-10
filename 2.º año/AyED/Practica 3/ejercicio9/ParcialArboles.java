package ejercicio9;


import java.util.List;

import ejercicio1.GeneralTree;

public class ParcialArboles {
	GeneralTree<Integer> arbol;
	
	public ParcialArboles(GeneralTree<Integer> a){
		this.arbol = a;
	}
	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		if(arbol == null || arbol.isEmpty()) return false;
		return esDeSeleccionPostOrden(arbol);
	}
	
	private static boolean esDeSeleccionPostOrden(GeneralTree<Integer> nodo) {
		int min = Integer.MAX_VALUE;
		List <GeneralTree<Integer>> children = nodo.getChildren();
		if (children.isEmpty()) {
	        return true;
	    }
		for (GeneralTree<Integer> child : children) {
			if (!esDeSeleccionPostOrden(child)) {
	            return false;
	        }
	        min = Math.min(min, child.getData());
		}
		return (nodo.getData() == min);
	}
}
