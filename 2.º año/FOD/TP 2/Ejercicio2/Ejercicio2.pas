program Ejercicio2;

const valorAlto = 32764;

type
    producto = record
        codigo: integer;
        nombre: String;
        precio: real;
        stockActual: integer;
        stockMinimo: integer;
    end;

    venta = record
        codigo: integer;
        cantidad: integer;
    end;

    archivo = file of producto;
    archivoDetalle = file of venta;

var
    carga: Text;
    maestro: archivo;
    detalle: archivoDetalle;
    cod,cantTotal: integer;
    reg: producto; 
    aux: venta;
    cargado: boolean;

    procedure leer(var arch: archivo; var dato: producto);
    begin
        if not EOF(arch)then
            read(arch,dato)
        else
            dato.codigo := valorAlto
    end;

    procedure imprimirProducto(p: producto);
    begin
        writeln('Codigo: ', p.codigo);
        writeln('Nombre: ', p.nombre);
        writeln('Precio: ', p.precio:0:2);
        writeln('Stock actual: ', p.stockActual);
        writeln('Stock minimo: ', p.stockMinimo);
    end;

    procedure imprimirArchivo(var arch: archivo);
    begin
        while not EOF(arch)do
        begin
            read(arch,reg);
            imprimirProducto(reg);
        end
    end;

    procedure ultimoElemento();
    begin
        cod := aux.codigo;
        read(maestro, reg);  
        while (cod <> reg.codigo)do 
        begin
            read(maestro,reg)
        end;
        seek(maestro, filepos(maestro)-1); 
        reg.stockActual:= reg.stockActual - aux.cantidad; 
        write(maestro, reg); 
    end;

begin
    assign(maestro, 'ProductosMaestro.dat');
    reset(maestro);
    // IMPRIMO PARA VER QUE ANDA BIEN
    writeln('------ARCHIVO MAESTRO ANTES DEL DETALLE------');
    imprimirArchivo(maestro);
    reset(maestro);
    assign(detalle, 'VentasDetalle.dat');
    reset(detalle);
    read(detalle, aux);
    while not EOF(detalle) do //RECORREMOS EL DETALLE 
    begin
        cod:= aux.codigo;
        cantTotal:= 0;
        while((not EOF(detalle)) and (aux.codigo = cod))do // VAMOS ACUMULANDO LA CANTIDAD DE PRODUCTOS VENDIDOS DEL MISMO CODIGO
        begin
            cantTotal:= cantTotal + aux.cantidad;
            read(detalle,aux);
        end;
        read(maestro, reg);  //SALGO POR QUE YA LEI TODAS LAS VENTAS DEL MISMO PRODUCTO DEL DETALLE
        while (cod <> reg.codigo)do  //RECORRO EL MAESTRO HASTA ENCONTRAR EL CODIGO DEL DETALLE (SE SABE QUE EXISTE)
        begin
            read(maestro,reg)
        end;
        seek(maestro, filepos(maestro)-1); // UNA VEZ ENCONTRADO VOLVEMOS UNA POS ATRAS
        reg.stockActual:= reg.stockActual - cantTotal; // MODIFICAMOS STOCK
        write(maestro, reg);   //SOBRE ESCRIBIMOS EL PRODUCTO CON EL DATO MODIFICADO
    end;

    ultimoElemento(); //SE HACE AFUERA EL ULTIMO ELEMENTO POR QUE SOY UN BOLUDO(?) Efectivamente si me falto hacer en lectura asignar cod = maxInt;
    close(detalle);
    close(maestro);
    // Esta parte es para imprimir nada mas y saber si se modifico bien
    assign(maestro, 'ProductosMaestro.dat');
    reset(maestro);
    writeln('------ARCHIVO MAESTRO DESPUES DEL DETALLE------');
    imprimirArchivo(maestro);
    // LISTAR EN ARCHIVO "stock_minimo.txt"

    cargado:= false;
    reset(maestro);
    assign(carga, 'stock_minimo.txt');
    Rewrite(carga);
    while not EOF(maestro) do 
    begin
        read(maestro, reg);
        if(reg.stockActual < reg.stockMinimo)then
        begin
        cargado:= true;
        with reg do 
            writeln(carga, ' Codigo: ', codigo, ' Nombre: ', nombre, ' Precio: ', precio:0:2, ' Stock actual: ', stockActual, ' Stock Minimo: ', stockMinimo);
        end;
    end;
    close(carga);
    if(cargado)then
        writeln('"stock_minimo.txt" creado correctamente')
    else
        writeln('"stock_minimo.txt" SE CREO VACIO');
    close(maestro);
end.
