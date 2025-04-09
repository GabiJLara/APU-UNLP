program CrearArchivoDetalle;

type
    venta = record
        codigo: integer;
        cantidad: integer;
    end;

    arVentas = file of venta;

var
    archivo: arVentas;
    reg: venta;

begin
    assign(archivo, 'VentasDetalle.dat');
    rewrite(archivo);  // Crear y abrir el archivo para escritura

    // Crear registros de ventas (5 ventas de ejemplo)
    // Supongamos que las ventas son para productos 1, 2 y 3
    reg.codigo := 1; reg.cantidad := 5; write(archivo, reg);
    reg.codigo := 2; reg.cantidad := 10; write(archivo, reg);
    reg.codigo := 2; reg.cantidad := 3; write(archivo, reg);
    reg.codigo := 3; reg.cantidad := 7; write(archivo, reg);
    reg.codigo := 3; reg.cantidad := 2; write(archivo, reg);
    reg.codigo := 5; reg.cantidad := 4; write(archivo, reg);

    close(archivo);  // Cerrar el archivo
end.
