package tp1.ejercicio7;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class EjercicioSucesion {
	
	
	public List<Integer> calcularSucecion(int n){
		List<Integer> lista = new ArrayList<>();
		calcularRecursivo(n,lista);
		return(lista);
	}
	
	private void calcularRecursivo(int n, List<Integer> L) {
		L.add(n);
		if( n == 1) {
			return;
		}
		if(n % 2 == 0) {
			calcularRecursivo(n / 2, L);
		}
		else {
			calcularRecursivo(n * 3 + 1, L);
		}
	}
	
	public static void invertirArrayList(ArrayList<Integer> lista) {
		ArrayList<Integer> aux = new ArrayList<>();
		for (int i = lista.size()-1; i >= 0; i--){
			aux.add(lista.get(i));
		}
		lista.clear();
		lista.addAll(aux);
	}
	
	public static void invertirArrayListRecursivo(ArrayList<Integer> lista) {
		if (lista.size()<=1) {
			return;
		}
		Integer primero = lista.remove(0);
		invertirArrayListRecursivo(lista);
		lista.add(primero);
	}
	
	public static int sumarLinkedList(LinkedList<Integer> lista) {
		return(recursionSuma(0,lista));
	}
	private static int recursionSuma(int n,LinkedList<Integer> lista ) {
		if (lista.isEmpty()){
			return(n);
		}
		n += lista.remove();
		return (recursionSuma(n,lista));
	}
	
	//ESTE METODO CREA UNA LISTA Y BORRA LAS OTRAS DOS
	public static ArrayList<Integer> combinarOrdenadoYBorrandoListas(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		ArrayList<Integer> respuesta = new ArrayList<>();
		boolean aux = true;
		if(lista1.isEmpty()) {
			respuesta= lista2;
			aux= false;
		}
		else if (lista2.isEmpty()) {
			respuesta = lista1;
			aux= false;
		}
		Integer a = lista1.remove(0);
		Integer b = lista2.remove(0);
		while (aux) { //SUPONGO ORDEN DE MENOR A MAYOR
			if (a >= b) {
				respuesta.add(b);
				if(lista2.size()!= 0) {
					b = lista2.remove(0);
				}
				else {
					aux = false;
				}
			}
			else {
				respuesta.add(a);
				if(lista1.size()!= 0) {
					a = lista1.remove(0);
				}
				else {
					aux= false;
				}
			}
		}
		if(lista1.size() !=0) {
			respuesta.addAll(lista1);
		}
		if(lista2.size() != 0) {
			respuesta.addAll(lista2);
		}
		lista1.clear();
		lista2.clear();
		return(respuesta);
	}
	
	//ESTE METODO CREA UNA LISTA SIN MODIFICAR LAS DOS ENTRANTES
	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		ArrayList<Integer> respuesta = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < lista1.size() && j< lista2.size()) {
			if(lista1.get(i) <= lista2.get(j)) {
				respuesta.add(lista1.get(i));
				i++;
			}
			else {
				respuesta.add(lista2.get(j));
				j++;
			}
		}
		while(i < lista1.size()) {
			respuesta.add(lista1.get(i));
			i++;
		}
		while(j < lista2.size()) {
			respuesta.add(lista2.get(j));
			j++;
		}
		
		return(respuesta);
	}
	
	public static void main(String[] args) {
		//ACA ARRANCA EL PUNTO G
        EjercicioSucesion prueba = new EjercicioSucesion();
        List<Integer> sucesion = prueba.calcularSucecion(6);
        System.out.println(sucesion); //Ejemplo: [6, 3, 10, 5, 16, 8, 4, 2, 1]
        
        //ACA ARRANCA EL PUNTO H
        ArrayList<Integer> lista = new ArrayList<>();  
        lista.add(1);
        lista.add(2);
        lista.add(3);
        System.out.println("Lista original: " + lista);
        invertirArrayListRecursivo(lista);
        System.out.println("Lista invertida: " + lista);
        
        //ACA ARRANCA PUNTO I
        LinkedList<Integer> linkedLista = new LinkedList<>();
        linkedLista.add(1);
        linkedLista.add(2);
        linkedLista.add(3);
        linkedLista.add(4);
        System.out.println("La suma de los numeros de la lista es: " + sumarLinkedList(linkedLista)); //Debe imprimir 10
        
        //ACA ARRANCA EL J
        ArrayList<Integer> listaOrdenada1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        ArrayList<Integer> listaOrdenada2 = new ArrayList<>(Arrays.asList(2, 4, 6, 8));
        ArrayList<Integer> resultado = combinarOrdenado(listaOrdenada1, listaOrdenada2);
        System.out.println(resultado); // Debería imprimir: [1, 2, 3, 4, 5, 6, 7, 8]
        
    }
}
