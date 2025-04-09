program CrearArchivoMaestro;

type
    producto = record
        codigo: integer;
        nombre: String;
        precio: real;
        stockActual: integer;
        stockMinimo: integer;
    end;

    arProductos = file of producto;

var
    archivo: arProductos;
    reg: producto;
    i: integer;
    codigoStr: string;

begin
    assign(archivo, 'ProductosMaestro.dat');
    rewrite(archivo);  // Crear y abrir el archivo para escritura

    // Crear registros de productos (5 productos de ejemplo)
    for i := 1 to 5 do
    begin
        reg.codigo := i;  // Código de producto (1, 2, 3, ...)
        Str(i, codigoStr);  // Convertimos el código de producto a cadena
        reg.nombre := 'Producto ' + codigoStr;  // Nombre del producto
        reg.precio := 100 + (i * 50);  // Precio de venta (ejemplo: 150, 200, 250, ...)
        reg.stockActual := 50 - (i * 5);  // Stock actual (disminuye con el código)
        reg.stockMinimo := 40;  // Stock mínimo (siempre 10 en este ejemplo)
        write(archivo, reg);  // Escribir el registro en el archivo
    end;

    close(archivo);  // Cerrar el archivo
end.
