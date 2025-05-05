package ejercicio6;

import ejercicio1.GeneralTree;

public class RedDeAguaPotable {
	private GeneralTree<Character> redDeAgua;
	
	public double minimoCaudal(double caudal) {
		return minimoCaudalRecursivo(caudal, this.redDeAgua);
	}
	
	private double minimoCaudalRecursivo(double caudal, GeneralTree<Character> nodo) {
		if(nodo.isLeaf()) return caudal;
		double min = Double.MAX_VALUE;
		int cantHijos = nodo.getChildren().size();
		caudal = caudal / cantHijos;
		for(GeneralTree<Character> child : nodo.getChildren()) {
			min = Math.min(min, minimoCaudalRecursivo(caudal,child));
		}
		return min;
	}
}
