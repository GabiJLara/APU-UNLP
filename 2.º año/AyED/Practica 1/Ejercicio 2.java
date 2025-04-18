package practica1;

import java.util.Scanner;

public class Arreglo {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Por favor, ingresa un valor para N: ");
        int N = s.nextInt();
        int[] vector = devolverArreglo(N); // Llamada con un numero positivo
        for (int i : vector) {
            System.out.println(i);  
        }
        System.out.println("Por favor, ingresa un valor para N: ");
        N = s.nextInt();
        System.out.println("-----");
        int[] vector2 = devolverArreglo(-3); // Llamada con un numero negativo
        for (int i : vector2) {
            System.out.println(i);  
        }
	s.close();
    }
	public static int[] devolverArreglo(int N) {
		int[]arreglo;
		if (N >= 1) {
			arreglo = new int[]{ N,N*2,N*3,N*4,N*5};
		}else{
			int absN = Math.abs(N);
			arreglo= new int[] {absN*1,absN*2,absN*3,absN*4,absN*5};
		}
		return (arreglo);
		}
	}
