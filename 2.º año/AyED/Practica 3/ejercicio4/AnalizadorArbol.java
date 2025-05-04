package ejercicio4;

import ejercicio1.GeneralTree;
import ejercicio1.Queue;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		if(arbol.isEmpty() || arbol == null) return 0;
		return maximoPromedio(arbol);
		
	}
	
	private double maximoPromedio(GeneralTree<AreaEmpresa>arbol) {
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		GeneralTree<AreaEmpresa> aux;
		double maxProm = Double.MIN_VALUE;
		double actProm = 0;
		int cant = 0;
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				actProm = actProm + aux.getData().getTardanza();
				cant++;
				if(aux.hasChildren()) {
					for(GeneralTree<AreaEmpresa> child : aux.getChildren()) {
						cola.enqueue(child);
					}
				}
			}
			else {
				actProm = (double)actProm / cant;
				if(maxProm < actProm) {
					maxProm = actProm;
				}
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					actProm= 0;
					cant = 0;
				}
			}
		}
		return maxProm;
	}
}
