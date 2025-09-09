  Gerente alan = new Gerente("Alan Turing");
	double aportesDeAlan = alan.aportes()
  // Devuelve 2.850 (Este metodo solo utiliza el metodo implementado en la clase Gerente)

  Gerente alan = new Gerente("Alan Turing");
  double sueldoBasicoDeAlan = alan.sueldoBasico();
  // Devuelve 67.850 (El metodo sueldoBasico no esta implementado en Gerente, asi que hace lo que esta implementado en Empleado Jerarquico, este llama 
  // a montoBasico (DEL GERENTE POR QUE ESTA IMPLEMENTADO) +  a aportes (TAMBIEN DEL GERENTE) + bonoPorCategoria (DE EMPLEADO JERARQUICO))
