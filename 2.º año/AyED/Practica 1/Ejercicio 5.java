package practica1;

public class Ejercicio5 {
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static double prom;
	
	public static double[] metodo1(int[] vector) {
		double[] aux = new double[3];
		int max = -1;
		int min = 999999;
		double prom = 0.0;
		int total = 0;
		for (int i = 0; i < vector.length;i++) {
			total+= vector[i];
			if(vector[i] > max) {
				max = vector[i];
			}
			if(vector[i]< min) {
				min = vector[i];
			}
		}
		prom = (double)total/vector.length;
		aux[0]= max;
		aux[1] = min;
		aux[2] = prom;
		return(aux);
	}
	
	public static double[] metodo2(int a, int b, int c, int d, int e, int f){
			double[] aux = new double[3];
			int max = -1;
			int min = 999999;
			double prom = 0.0;
			int total = 0;
			int[] vector = {a, b, c, d, e, f};
			for (int i = 0; i < vector.length;i++) {
				total+= vector[i];
				if(vector[i] > max) {
					max = vector[i];
				}
				if(vector[i]< min) {
					min = vector[i];
				}
			}
			prom = (double)total/vector.length;
			aux[0]= max;
			aux[1] = min;
			aux[2] = prom;
			return(aux);
	}
	
	public static void metodo3() { //NO USAR (ES CON VARIABLES GLOBALES)
		int [] vector = {1,2,3,4,5};
		double total = 0.0;
		for (int i = 0; i < vector.length;i++) {
			total+= vector[i];
			if(vector[i] > max) {
				max = vector[i];
			}
			if(vector[i]< min) {
				min = vector[i];
			}
		}
		prom = total/vector.length;
	}
}
