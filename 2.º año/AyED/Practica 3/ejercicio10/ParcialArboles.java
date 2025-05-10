package ejercicio10;

import java.util.*;
import ejercicio1.GeneralTree;

public class ParcialArboles {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> listaMax = new ArrayList<Integer>();
		List<Integer> listaActual = new ArrayList<Integer>();
		int[] sumaMax = new int[]{-1};
		if(arbol == null || arbol.isEmpty())return listaMax;
		resolverRec(arbol, listaActual, listaMax, 0, 0, sumaMax);
		return listaMax;
	}
	
	public static void resolverRec (GeneralTree<Integer> nodo, List<Integer> listaMax, List<Integer>listaActual, int nivel, int sumaActual, int[] sumaMax) {
		if(nodo.getData() == 1) {
			listaActual.add(nodo.getData());
			sumaActual+= (nodo.getData() * nivel);
		}
        if (nodo.isLeaf()) {
            if (sumaActual > sumaMax[0]) {
                listaMax.clear();
                listaMax.addAll(listaActual);
                sumaMax[0] = sumaActual;
            }
        } 
        else {
            for (GeneralTree<Integer> child : nodo.getChildren()) {
            	resolverRec(child, listaActual, listaMax, nivel + 1,sumaActual,sumaMax);
            }
        }
        if(nodo.getData() != 0)
        	listaActual.remove(listaActual.size()-1);
	}
}
