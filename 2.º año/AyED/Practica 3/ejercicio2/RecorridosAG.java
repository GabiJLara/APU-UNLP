package ejercicio2;

import java.util.*;
import ejercicio1.GeneralTree;
import ejercicio1.Queue;

public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){
		List<Integer>lista = new ArrayList<Integer>();
		if(a == null || a.isEmpty())return lista;
		else {
			PreOrden(a,n,lista);
			return lista;
		}
	}
	
	private void PreOrden(GeneralTree <Integer> nodo,Integer num, List <Integer> lista) {
		int aux = nodo.getData();
		if(aux > num && aux % 2 != 0) {
			lista.add(aux);
		}
		List<GeneralTree<Integer>> children = nodo.getChildren();
		for (GeneralTree<Integer> child : children) {
			PreOrden(child, num, lista);
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> lista = new ArrayList<Integer>();
		if(a== null || a.isEmpty())return lista;
		else {
			InOrden(a,n,lista);
			return lista;
		}
	}
	
	private void InOrden(GeneralTree <Integer> nodo,Integer num, List <Integer> lista) {
		List<GeneralTree<Integer>> children = (LinkedList<GeneralTree<Integer>>) nodo.getChildren();
		if(!children.isEmpty()) {
			InOrden(children.getFirst(),num,lista);
			children.removeFirst();
		}
		int aux= nodo.getData();
		if(aux > num && aux % 2 != 0) {
			lista.add(aux);
		}
		for (GeneralTree<Integer> child : children) {
			InOrden(child,num,lista);
		}
		
	}

	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> lista = new ArrayList<Integer>();
		if(a == null || a.isEmpty())return lista;
		else {
			PostOrden(a,n,lista);
			return lista;
		}
	}
	
	private void PostOrden(GeneralTree <Integer> nodo,Integer num, List <Integer> lista) {
		List <GeneralTree<Integer>> children = nodo.getChildren();
		for (GeneralTree<Integer> child : children) {
			PostOrden(child,num,lista);
		}
		int aux= nodo.getData();
		if(aux > num && aux % 2 != 0) {
			lista.add(aux);
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
		List<Integer> lista = new ArrayList<Integer>();
		if(a == null || a.isEmpty())return lista;
		else {
			PorNiveles(a,n,lista);
			return lista;
		}
	}
	
	private void PorNiveles(GeneralTree <Integer> nodo,Integer num, List <Integer> lista) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(nodo);
		cola.enqueue(null);
		GeneralTree<Integer> nAux = new GeneralTree<Integer>();
		while (!cola.isEmpty()) {
			nAux= cola.dequeue();
			if(nAux != null) {
				int aux = nAux.getData();
				if(aux > num && aux % 2 != 0) {
					lista.add(aux);
				}
				if(nAux.hasChildren()) {
					for (GeneralTree<Integer> child : nAux.getChildren()) {
						cola.enqueue(child);
					}
				}
			}
			else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);   
				}
			}
		}
	}

}
