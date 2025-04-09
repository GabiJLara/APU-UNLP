program CrearArchivoOriginal;

type
    comision = record
        codigo: integer;
        nombre: String;
        monto: real;
    end;

    arComisiones = file of comision;

var
    archivo: arComisiones;
    reg: comision;
    i: integer;
    codigoStr: string;

begin
    assign(archivo, 'Comisiones.dat');
    rewrite(archivo);  // Crear y abrir el archivo para escritura
    // Crear registros de comisiones para 5 empleados de ejemplo
    for i := 1 to 5 do
    begin
        reg.codigo := i;  // Código de empleado
        // Convertir el código de empleado a cadena y concatenar al nombre
        Str(i, codigoStr);  // Convertimos el número a cadena
        reg.nombre := 'Empleado ' + codigoStr;  // Nombre del empleado
        reg.monto := 1000 + i * 500;  // Monto de la comisión (ejemplo: 1000, 1500, 2000, ...)
        write(archivo, reg);  // Escribir el registro en el archivo
    end;
    // Agregar algunos registros de empleados con el mismo código para que se vean las sumas
    reg.codigo := 5; reg.nombre := 'Empleado 1'; reg.monto := 1200; write(archivo, reg);
    reg.codigo := 5; reg.nombre := 'Empleado 2'; reg.monto := 1300; write(archivo, reg);
    reg.codigo := 6; reg.nombre := 'Empleado 2'; reg.monto := 1500; write(archivo, reg);
    reg.codigo := 6; reg.nombre := 'Empleado 3'; reg.monto := 1800; write(archivo, reg);
    close(archivo);  // Cerrar el archivo
end.
