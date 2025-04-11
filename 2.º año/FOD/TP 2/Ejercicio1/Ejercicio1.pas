program Ejercicio1;

const valorAlto = 32764;

type
    comision = record
        codigo: integer;
        nombre: String;
        monto: real;
    end;

    arComisiones = file of comision;

var
    reg,aux: comision;
    archivo,original: arComisiones;
    mTotal: real;

    procedure leer(var archivo: arComisiones; var dato: comision);
    begin
        if not EOF(archivo)then
            read(archivo,dato)
        else
            dato.codigo := valorAlto
    end;

    procedure imprimirComision(c: comision);
    begin
        writeln('Codigo: ', c.codigo);
        writeln('Nombre: ',  c.nombre);
        writeln('Monto: ', c.monto:0:2);
    end;

    procedure imprimirArchivo(var archivo: arComisiones);
    begin
        while not EOF(archivo)do
        begin
            read(archivo,reg);
            imprimirComision(reg);
        end
    end;

    procedure compactar(var original: arComisiones);
    begin
        assign(archivo,'Compacto');
        rewrite(archivo);
        leer(original,reg);
        while not EOF(original) do
        begin
            mTotal:= 0;
            aux:= reg;
            while(aux.codigo = reg.codigo)do
            begin
                mTotal:= mTotal + reg.monto;
                leer(original,reg);
            end;
            aux.monto:= mTotal;
            write(archivo,aux);
        end;
        close(archivo);
    end;

begin
    assign(original,'Comisiones.dat');
    reset(original);
    writeln('-----LEEMOS ARCHIVO ORIGINAL-----');
    imprimirArchivo(original);
    reset(original);
    compactar(original);
    close(original);
    assign(archivo,'Compacto');
    reset(archivo);
    writeln('-----LEEMOS ARCHIVO MODIFICADO-----');
    imprimirArchivo(archivo);
    close(archivo);
end.
