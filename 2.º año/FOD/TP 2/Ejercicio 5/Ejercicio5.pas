program Ejercicio5;

uses SysUtils;

const
    valorAlto =32764;
    cantDetalles = 5;

type
    sesiones = record
        cod_usuario: integer;
        fecha: integer;
        tiempo_sesion: integer;
    end;

    sesionesMaster = record
        cod_usuario: integer;
        fecha: integer;
        tiempo_total_de_sesiones_abiertas: integer;
    end;

    detalle = file of sesiones;
    maestro = file of sesionesMaster;

    arrayDetalle = array [1..cantDetalles] of detalle;
    arraySesiones = array[1..cantDetalles] of sesiones;

var
    i,minimo,minimoFecha,total: integer;
    master: maestro;
    arrDetalle: arrayDetalle;
    arrSesiones: arraySesiones;
    s: sesiones;
    sM: sesionesMaster;

    procedure leer(var d: detalle; var s: sesiones);
    begin
        if not EOF(d)then
            read(d,s)
        else
            s.cod_usuario:= valorAlto;
            s.fecha:= valorAlto;
    end;

    procedure asignarArchivos(var a: arrayDetalle; var ses: arraySesiones);
    var
        t: string;
    begin
        for i:= 1 to cantDetalles do
        begin
            Str(i, t);  // Convierte i a string
            assign(a[i], 'Detalle' + t + '.dat');
            reset(a[i]);
            leer(a[i],s);
            ses[i]:= s;
        end;
    end;

    procedure cerrarDetalles(var a: arrayDetalle);
    begin
        for i := 1 to cantDetalles do 
        begin
            close(a[i]);
        end;
    end;

    procedure buscarMinimo(a: arraySesiones; var min: integer; var minFecha: integer);
    begin
        min:= valorAlto;
        minFecha:= valorAlto;
        for i:= 1 to cantDetalles do
        begin
            if((a[i].cod_usuario < min) and (a[i].fecha < minFecha))then
            begin
                min:= a[i].cod_usuario;
                minFecha:= a[i].fecha;
            end;
        end;
    end;

    procedure acumularTiempo(var a: arrayDetalle; var ses: arraySesiones; var total: integer; min: integer; minF: integer);
    begin
        for i:=1 to cantDetalles do
        begin
            while((ses[i].cod_usuario = min) and (ses[i].fecha = minF))do
            begin
                total:= total + ses[i].tiempo_sesion;
                leer(a[i],s);
                ses[i]:= s;
            end;
        end;
    end;

    procedure cargarSesionMaster(var m: sesionesMaster);
    begin
        m.cod_usuario:= minimo;
        m.fecha:= minimoFecha;
        m.tiempo_total_de_sesiones_abiertas:= total;
    end;

begin
    assign(master, 'RedLan.dat'); //Para crearse en la ubicacion "/var/log." Hay que crear ambas carpetas y poner la ruta entera, pascal no crea carpetas solo archivos.
    rewrite(master);
    asignarArchivos(arrDetalle,arrSesiones); //asigno los archivos al vector de archivos y las sesiones al vector de sesiones
    buscarMinimo(arrSesiones,minimo,minimoFecha); //busco el codigo minimo con fecha minima ya que esta ordenado por codigo de producto de menor a mayor
    while(minimo <> valorAlto)do
    begin
        total:= 0;
        acumularTiempo(arrDetalle,arrSesiones,total,minimo,minimoFecha);
        cargarSesionMaster(sM);
        write(master,sM);
        buscarMinimo(arrSesiones,minimo,minimoFecha);
    end;
    close(master);
    cerrarDetalles(arrDetalle);
end.
