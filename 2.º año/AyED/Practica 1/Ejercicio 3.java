package practica1;

public class Test {

	public static void main(String[] args) {
		
		Estudiante[]arrEstudiante = new Estudiante[2];
		arrEstudiante[0] = new Estudiante();
		arrEstudiante[1] = new Estudiante();
		arrEstudiante[0].setApellido("Lara");
		arrEstudiante[0].setNombre("Gabriel");
		arrEstudiante[0].setComision("1");
		arrEstudiante[0].setDireccion("Calle 525");
		arrEstudiante[0].setEmail("hotmail.com");
		arrEstudiante[1].setApellido("Pedo");
		arrEstudiante[1].setNombre("Caca");
		arrEstudiante[1].setComision("Culo");
		arrEstudiante[1].setDireccion("Pis");
		arrEstudiante[1].setEmail("Gmail.com");
		Profesor[]arrProfesor = new Profesor[3];
		arrProfesor[0] = new Profesor();
		arrProfesor[1] = new Profesor();
		arrProfesor[2] = new Profesor();
		arrProfesor[0].setApellido("Primero");
		arrProfesor[0].setNombre("Primero");
		arrProfesor[0].setCatedra("Primero");
		arrProfesor[0].setEmail("Primero");
		arrProfesor[0].setFacultad("Primero");
		arrProfesor[1].setApellido("Segundo");
		arrProfesor[1].setNombre("Segundo");
		arrProfesor[1].setCatedra("Segundo");
		arrProfesor[1].setEmail("Segundo");
		arrProfesor[1].setFacultad("Segundo");
		arrProfesor[2].setApellido("Tercero");
		arrProfesor[2].setNombre("Tercero");
		arrProfesor[2].setCatedra("Tercero");
		arrProfesor[2].setEmail("Tercero");
		arrProfesor[2].setFacultad("Tercero");
		System.out.println("ESTUDIANTES: ");
		
		for (int i=0;i<2;i++) {	
			System.out.println(arrEstudiante[i].tusDatos());
		}
		System.out.println("PROFESORES: ");
		for (int i=0; i < 3 ;i++) {
			System.out.println(arrProfesor[i].tusDatos());
		}
	}

}
