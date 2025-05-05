package ejercicio7;

import ejercicio1.GeneralTree;
import java.util.*;

public class Caminos {
	private GeneralTree<Integer> arbol;
	
	 public Caminos(GeneralTree<Integer> arbol) {
	        this.arbol = arbol;
	 }
	
	 public List<Integer> caminoAHojaMasLejana() {
	        List<Integer> caminoActual = new ArrayList<>();
	        List<Integer> caminoMaximo = new ArrayList<>();
	        caminoAHojaMasLejanaRecursivo(arbol, caminoActual, caminoMaximo);
	        return caminoMaximo;
	 }
	 
	 private void caminoAHojaMasLejanaRecursivo(GeneralTree<Integer> nodo, List<Integer> caminoActual, List<Integer> caminoMaximo) {
	        caminoActual.add(nodo.getData());
	        if (nodo.isLeaf()) {
	            if (caminoActual.size() > caminoMaximo.size()) {
	                caminoMaximo.clear();
	                caminoMaximo.addAll(caminoActual);
	            }
	        } 
	        else {
	            for (GeneralTree<Integer> child : nodo.getChildren()) {
	                caminoAHojaMasLejanaRecursivo(child, caminoActual, caminoMaximo);
	            }
	        }
	        caminoActual.remove(caminoActual.size() - 1); //Cuando llegamos a una hoja y hay que volver para seguir probando sus hermanos descontamos ese ultimo dato agregado de caminoActual
	 }
}

