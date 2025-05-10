package ejercicio11;

import ejercicio1.GeneralTree;
import ejercicio1.Queue;

public class ParcialArboles {
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		if(arbol==null || arbol.isEmpty())return false;
		return resolverPorNiveles(arbol,0);
	}
	
	public static boolean resolverPorNiveles(GeneralTree<Integer> nodo , int cantAnterior) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(nodo);
		cola.enqueue(null);
		GeneralTree<Integer> nAux;
		int cantNodos= 0;
		while(!cola.isEmpty()) {
			nAux = cola.dequeue();
			if(nAux != null) {
				cantNodos++;
				if(nAux.hasChildren()) {
					for (GeneralTree<Integer>child: nAux.getChildren()) {
						cola.enqueue(child);
					}
				}
			}
			else {
				if(!cola.isEmpty()) {
					if(cantNodos != cantAnterior + 1) {
						return false;
					}
					cola.enqueue(null);
					cantAnterior= cantNodos;
					cantNodos = 0;
				}
			}
		}
		return true;
	}
}
