program Ejercicio4;

uses SysUtils;

const
    valorAlto = 32764;
    cantDetalles = 30;

type
    producto = record
        codigo: integer;
        nombre: String;
        descripcion: String;
        stockActual: integer;
        stockMinimo: integer;
        precio: real;
    end;

    ventas = record
        codigo: integer;
        cantidad: integer;
    end;

    archivo= file of producto;
    archivoDetalle = file of ventas;

    arrayDetalle = array [1..cantDetalles] of archivoDetalle;
    arrayVenta = array[1..cantDetalles] of ventas;

var
    master: archivo;
    arrDetalles: arrayDetalle;
    arrVentas: arrayVenta;
    i,minimo,total: integer;
    v: ventas;
    reg: producto;
    carga: Text;

    procedure leer(var d: archivoDetalle; var v: ventas);
    begin
        if not EOF(d)then
            read(d,v)
        else
            v.codigo:= valorAlto;
    end;

    procedure asignarArchivos(var a: arrayDetalle; var ven: arrayVenta);
    var
        s: string;
    begin
        for i := 1 to cantDetalles do
        begin
            Str(i, s);  // Convierte i a string
            assign(a[i], 'Detalle' + s + '.dat');
            reset(a[i]);
            leer(a[i],v);
            ven[i]:= v;
        end;
    end;

    procedure cerrarDetalles(var a: arrayDetalle);
    begin
        for i := 1 to cantDetalles do 
        begin
            close(a[i]);
        end;
    end;

    procedure buscarMinimo(ven: arrayVenta; var min:integer);
    begin
        min:= valorAlto;
        for i:= 1 to cantDetalles do
        begin
            if(ven[i].codigo < min)then
                min:= ven[i].codigo
        end;
    end;

    procedure acumularVentas(var d: arrayDetalle; var ven: arrayVenta; var total: integer; min: integer);
    begin
        for i:=1 to cantDetalles do
        begin
            while(ven[i].codigo=min)do
            begin
                total:= total + ven[i].cantidad;
                leer(d[i],v);
                ven[i]:= v;
            end;
        end;
    end;

begin
    assign(master, 'Productos.dat');
    reset(master);
    assign(carga,'StockDebajoDelMinimo.txt');
    rewrite(carga);
    asignarArchivos(arrDetalles,arrVentas); //asigno los archivos al vector de archivos y las ventas al vector de ventas
    buscarMinimo(arrVentas,minimo); //busco el codigo minimo ya que esta ordenado por codigo de producto de menor a mayor
    while(minimo <> valorAlto)do
    begin
        total:= 0;
        acumularVentas(arrDetalles,arrVentas,total,minimo); //acumula las ventas del mismo codigo
        read(master,reg);
        while(minimo <> reg.codigo)do
        begin
            read(master,reg)
        end;
        seek(master,filepos(master)-1);
        reg.stockActual:= reg.stockActual - total; //actualizo stock
        write(master,reg);  //guardo en master
        if(reg.stockActual < reg.stockMinimo)then //ACA VERIFICO SI TIENE MENOR STOCK QEU EL MINIMO Y SI ES ASI MANDO AL ARCHIVO DE TEXTO
        begin
        with reg do 
            writeln(carga,'Nombre: ', nombre, ' Descripcion: ', descripcion, ' Stock actual: ', stockActual, ' Precio: ', precio:0:2);
        end;

        buscarMinimo(arrVentas,minimo); //Ya habiendo leido todos los productos del codigo minimo anterior, vuelvo a buscar otro minimo
    end;
    close(master);
    close(carga);
    cerrarDetalles(arrDetalles);
end.
