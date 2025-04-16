program Ejercicio6;

uses SysUtils;

const
    valorAlto = 32764;
    cantDetalles = 10;  //se reciben 10 detalles.

type
    casosCovid = record
        codLocalidad: integer;
        codCepa: integer;
        cantCasosActivos: integer;
        cantCasosNuevos: integer;
        cantCasosRecuperados: integer;
        cantCasosFallecidos: integer;
    end;

    ministerioCovid = record
        codLocalidad: integer;
        nombreLocalidad: String;
        codCepa: integer;
        nombreCepa: String;
        cantCasosActivos: integer;
        cantCasosNuevos: integer;
        cantCasosRecuperados: integer;
        cantFallecidos: integer;
    end;

    detalle = file of casosCovid;
    maestro = file of ministerioCovid;

    arrayDetalle = array [1..cantDetalles] of detalle;
    arrayCasos = array [1..cantDetalles] of casosCovid;
var
    i,minimo,minimoCepa,indice: integer;
    master: maestro;
    arrDetalle: arrayDetalle;
    arrCasos: arrayCasos;
    cC: casosCovid;
    mC: ministerioCovid;

    procedure leer(var d: detalle; var c: casosCovid);
    begin
        if not EOF(d)then
            read(d,c)
        else
            c.codLocalidad:= valorAlto;
            c.codCepa:= valorAlto;
    end;

    procedure asignarArchivos(var a: arrayDetalle; var cas: arrayCasos);
    var
        aux: string;
    begin
        for i:= 1 to cantDetalles do
        begin
            Str(i, aux);  // Convierte i a string
            assign(a[i], 'Detalle' + aux + '.dat');
            reset(a[i]);
            leer(a[i],cC);
            cas[i]:= cC;
        end;
    end;

    procedure cerrarDetalles(var a: arrayDetalle);
    begin
        for i := 1 to cantDetalles do 
        begin
            close(a[i]);
        end;
    end;

    procedure buscarMinimo(a: arrayCasos; var min: integer; var minCepa: integer; var index: integer);
    begin
        min:= valorAlto;
        minCepa:= valorAlto;
        for i:= 1 to cantDetalles do
        begin
            if ((a[i].codLocalidad < min) or ((a[i].codLocalidad = min) and (a[i].codCepa < minCepa)) )then
            begin
                min:= a[i].codLocalidad;
                minCepa:= a[i].codCepa;
                index:= i;
            end;
        end;
    end;

    procedure modificarDato(var a: arrayCasos; var aD: arrayDetalle; j: integer; var mc: ministerioCovid);
    var
        reg: casosCovid;
    begin
        mc.cantFallecidos:= mc.cantFallecidos + a[j].cantCasosFallecidos;
        mc.cantCasosRecuperados:= mc.cantCasosRecuperados + a[j].cantCasosRecuperados;
        mc.cantCasosActivos:= a[j].cantCasosActivos;
        mc.cantCasosNuevos:= a[j].cantCasosNuevos;
        leer(aD[j],reg);
        a[j]:= reg;
    end;

    procedure imprimirMasDe50CasosActivos(reg : ministerioCovid);
    begin
        if(reg.cantCasosActivos > 50)then
        begin
            writeln('----Localidad con mas de 50 casos activos-----');
            writeln('Codigo Localidad: ', reg.codLocalidad);
            writeln('Nombre Localidad: ', reg.nombreLocalidad);
            writeln('Codigo Cepa: ', reg.codCepa);
            writeln('Nombre Cepa: ', reg.nombreCepa);
            writeln('Cantidad casos ACTIVOS: ', reg.cantCasosActivos);
            writeln('Cantidad casos NUEVOS: ', reg.cantCasosNuevos);
            writeln('Cantidad casos RECUPERADOS: ', reg.cantCasosRecuperados);
            writeln('Cantidad FALLECIDOS: ', reg.cantFallecidos); 
        end;
    end;

begin
    assign(master, 'CasosCovidPBA.dat');
    reset(master);
    asignarArchivos(arrDetalle,arrCasos); //asigno los archivos al vector de archivos y los casos al vector de casos
    buscarMinimo(arrCasos,minimo,minimoCepa,indice); //busco el codigo minimo ya que esta ordenado por codigo de producto de menor a mayor
    while(minimo <> valorAlto)do
    begin
        read(master,mC);
        while ((minimo <> mC.codLocalidad) or (minimoCepa <> mC.codCepa)) do
        begin
            imprimirMasDe50CasosActivos(mC);
            read(master, mC);
        end;
        seek(master, filepos(master)-1);
        modificarDato(arrCasos,arrDetalle,indice,mC);
        write(master, mC);
        buscarMinimo(arrCasos,minimo,minimoCepa,indice);
    end;
    while not EOF(master)do
    begin
        read(master,mC);
        imprimirMasDe50CasosActivos(mC);
    end;
    close(master);
    cerrarDetalles(arrDetalle);
end.
