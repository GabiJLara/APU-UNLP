package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import practica1.Estudiante;

public class TestArrayList {
	
	public static boolean comprobar(Estudiante a, Estudiante b) {
		if (a.getNombre().equals(b.getNombre()) &&
        a.getApellido().equals(b.getApellido()) &&
        a.getComision().equals(b.getComision()) &&
        a.getEmail().equals(b.getEmail()) &&
        a.getDireccion().equals(b.getDireccion())) {
		return(true);}
		else {
			return(false);
		}
	}
  
	public static boolean esCapicua(ArrayList<Integer> lista) {
		if (lista.isEmpty()) { //Considero lista vacia como capicua
			return true;
		}
		int aux= lista.size()/2; //divido por 2 ya que es la cantidad de comparaciones que hago, indistitno si es par o impar la cantidad de elementos
		boolean respuesta=true; //seteo en true por que si viene una lista de 1 elemento es capicua por definicion
		for (int i=0; i < aux;i++) {
			if(!lista.get(i).equals(lista.get(lista.size() -1 - i))) {
				respuesta= false;
				break; //Salimos del loop por que ya sabemos que no cumple condicion
			}
		}
		return(respuesta);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Integer> lista = new ArrayList<>();
		for (int i = 1; i <= 10;i++) {
			lista.add(i);
		}
		System.out.println(lista);  //IMPRIME LISTA DE UNA
		for (Integer numero : lista) {   //IMPRIME ITERANDO
            System.out.println(numero);
        }
		LinkedList <Integer> lista2 = new LinkedList<>();
		for (int i = 1; i <= 10;i++) {
			lista2.add(i);
		}
		System.out.println(lista2); // IMPRIME LISTA DE UNA
		for (Integer numero : lista2) {  //IMPRIME ITERANDO
            System.out.println(numero);
        }
		int aux =1;
		// Otros metodos de iterar sobre las listas PUNTO 7C
		System.out.println("Otros metodos de iteracion sobre listas: ");
		System.out.println("Metodo: "+ aux);
		aux++;
		for (int i = 0; i < lista.size(); i++) {
		    System.out.println(lista.get(i));
		}
		System.out.println("Metodo: " + aux);
		Iterator<Integer> iterator = lista.iterator();
		while (iterator.hasNext()) {
		    System.out.println(iterator.next());
		}
		aux++;
		System.out.println("Metodo: " + aux);
		lista.forEach(numero -> System.out.println(numero));
		aux++;
		System.out.println("Metodo: " + aux);
		lista.stream().forEach(System.out::println);
		// PUNTO 7d.
		ArrayList <Estudiante> listaEstudiantes = new ArrayList<>();
		listaEstudiantes.add(new Estudiante("Gabriel","Lara","1","Hotmail.com","Calle 525"));
		listaEstudiantes.add(new Estudiante("Caca","Culo","Pedo","Pis","pipi"));
		listaEstudiantes.add(new Estudiante("1","1","1","1","1"));
		ArrayList <Estudiante> copiaListaEstudiantes = new ArrayList<>();
		copiaListaEstudiantes = listaEstudiantes; //AL HACER ESTO LAS DOS LISTAS APUNTAN A LA MISMA LISTA
		ArrayList<Estudiante> copiaListaEstudiantes2 = new ArrayList<>(); //ESTO SI ES UNA COPIA INDEPENDIENTE
		for (Estudiante e : listaEstudiantes) {
		    copiaListaEstudiantes2.add(new Estudiante(e.getNombre(), e.getApellido(), e.getComision(), e.getEmail(), e.getDireccion()));
		} 
		System.out.println("LISTA ORIGINAL");
		for (int i = 0; i < listaEstudiantes.size(); i++) {
		    System.out.println(listaEstudiantes.get(i).tusDatos());
		}
		System.out.println("LISTA COPIA MAL HECHA");
		for (int i = 0; i < copiaListaEstudiantes.size(); i++) {
		    System.out.println(copiaListaEstudiantes.get(i).tusDatos());
		}
		listaEstudiantes.get(2).setNombre("se modifico");
		
		
		System.out.println("LISTA ORIGINAL");
		for (int i = 0; i < listaEstudiantes.size(); i++) {
		    System.out.println(listaEstudiantes.get(i).tusDatos());
		}
		System.out.println("LISTA COPIA MAL HECHA");
		for (int i = 0; i < copiaListaEstudiantes.size(); i++) {
		    System.out.println(copiaListaEstudiantes.get(i).tusDatos());
		}
		System.out.println("LISTA COPIA BIEN HECHA");
		for (int i = 0; i < copiaListaEstudiantes2.size(); i++) {
		    System.out.println(copiaListaEstudiantes2.get(i).tusDatos());
		}
		
		// PUNTO 7e.
		Estudiante e = new Estudiante("Gabriel","Lara","1","Hotmail.com","Calle 525");
		boolean encontrado = false;
		for (Estudiante estudiante : listaEstudiantes) {
            if (comprobar(estudiante,e)) {
                encontrado = true;
                break; // Si es verdadero salimos del for por que ya se encontro
            }
        }
        if (encontrado) {
            System.out.println("El estudiante ya esta en la lista");
        } else {
            listaEstudiantes.add(e);
            System.out.println("Se agrego estudiante");
        }
        
        //PUNTO 7f.
        ArrayList<Integer> lista1Capicua = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        ArrayList<Integer> lista2Capicua = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(esCapicua(lista1Capicua)); // Debe retornar true
        System.out.println(esCapicua(lista2Capicua)); // Debe retornar false
	}
}
