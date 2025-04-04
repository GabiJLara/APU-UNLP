package practica1;

public class Metodos {
	
	public static void main(String[] args) {
        // Ejemplo de prueba
        numerosFor(10, 2);  
        System.out.println("-----");
        numerosFor(2, 10); 
        System.out.println("-----");
        numerosWhile(10,2);
        System.out.println("-----");
        numerosWhile(2,10);
        System.out.println("-----");
        numerosRecursivo(2,10);
        System.out.println("-----");
        numerosRecursivo(10,2);
        System.out.println("-----");
    }

	public static void numerosFor(int A, int B) {
		if (A > B) {
			for (int i = B; i <= A; i++) {
				System.out.println(i);
			}
		} else {
			if (A < B) {
				for (int i = A; i <= B; i++) {
					System.out.println(i);
				}
			}else {
				System.out.println("AMBOS NUMEROS SON IGUALES");
			}
		}
	}
	
	public static void numerosWhile(int A, int B) {
		if (A > B) {
			while (B <= A) {
				System.out.println(B);
				B++;
			}
		} else {
			if (A < B) {
				while(A <= B) {
					System.out.println(A);
					A++;
				}
			}else {
				System.out.println("AMBOS NUMEROS SON IGUALES");
			}
		}
	}
	
	public static void numerosRecursivo(int A, int B) {
		if (A <= B) {
			System.out.println(A);
			if(A < B) {
				numerosRecursivo(A + 1,B);
			}
		} else {
			System.out.println(B);
			if(A >B) {
				numerosRecursivo(A,B+1);
			}
		}
	}
	
}
