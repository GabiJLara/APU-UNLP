program Ejercicio3;

const valorAlto = 'ZZZ';

type
    alfabetizados = record
        provincia: String[20];
        cantAlfabetizados: integer;
        totalEncuestados: integer;
    end;

    agencia = record
        provincia: String[20];
        codigo: integer;
        cantAlfabetizados: integer;
        cantEncuestados: integer;
    end;

    archivo = file of alfabetizados;
    archivoDetalle = file of agencia;

var
    master: archivo;
    detalle,detalle2: archivoDetalle;
    det,det2: agencia;
    mas: alfabetizados;
    alfTotal,encTotal: integer;
    aux: string;

    procedure leer(var d : archivoDetalle; var reg: agencia);
    begin
        if not EOF(d) then
            read(d, reg)
        else
            reg.provincia:= valorAlto;
    end;

    procedure recorrerDetalle1();
    begin
        while(det.provincia <> mas.provincia)do
        begin
            read(master, mas)
        end;
        aux:= det.provincia;
        while(aux = det.provincia) do
        begin
            alfTotal:= alfTotal + det.cantAlfabetizados;
            encTotal:= encTotal + det.cantEncuestados;
            leer(detalle, det);
        end;
    end;

    procedure recorrerDetalle2();
    begin
        while(det2.provincia <> mas.provincia)do
        begin
            read(master, mas)
        end;
        aux:= det2.provincia;
        while(aux = det2.provincia) do
        begin
            alfTotal:= alfTotal + det2.cantAlfabetizados;
            encTotal:= encTotal + det2.cantEncuestados;
            leer(detalle2, det2);
        end;
    end;

    procedure recorrerAmbosDetalles();
    begin
        while(det.provincia <> mas.provincia) do
        begin
            read(master, mas);
        end;
        aux := det.provincia;
        while((aux = det.provincia) and (aux = det2.provincia))do
        begin
            alfTotal:= alfTotal + det.cantAlfabetizados + det2.cantAlfabetizados;
            encTotal:= encTotal + det.cantEncuestados + det2.cantEncuestados;
            leer(detalle, det);
            leer(detalle2, det2);
        end;
        while(aux = det.provincia) do
        begin
            alfTotal:= alfTotal + det.cantAlfabetizados;
            encTotal:= encTotal + det.cantEncuestados;
            leer(detalle, det);
        end;
        while(aux = det2.provincia) do
        begin
            alfTotal:= alfTotal + det2.cantAlfabetizados;
            encTotal:= encTotal + det2.cantEncuestados;
            leer(detalle2, det2);
        end;
    end;

    procedure imprimirAlfabetizados(a: alfabetizados);
    begin
        writeln('Provincia: ', a.provincia); 
        writeln(', Cantodad de alfabetizados: ', a.cantAlfabetizados);
        writeln(', Total de encuestados: ', a.totalEncuestados);
        writeln('------ ------ ------');
    end;

    procedure imprimirMaestro();
    var
        f: archivo;
        r: alfabetizados;
    begin
        assign(f, 'Alfabetizados.dat');
        reset(f);
        writeln;
        writeln('📄 Contenido del archivo maestro:');
        writeln('-------------------------------------------');
        while not EOF(f) do
        begin
            read(f, r);
            imprimirAlfabetizados(r);
        end;
        close(f);
    end;

begin
    assign(master, 'Alfabetizados.dat');
    reset(master);
    assign(detalle, 'Detalle.dat');
    reset(detalle);
    assign(detalle2, 'Detalle2.dat');
    reset(detalle2);
    leer(detalle, det);
    leer(detalle2, det2);
    while (det.provincia <> valorAlto) or (det2.provincia <> valorAlto) do
    begin
        alfTotal:= 0;
        encTotal:= 0;
        read(master,mas);   
        if(det.provincia < det2.provincia)then   //detalle primero
        begin
            recorrerDetalle1();
        end
        else if(det.provincia > det2.provincia)then   ///detalle segundo
        begin
            recorrerDetalle2();
        end
        else if(det.provincia = det2.provincia) then  //doble detalle
        begin
            recorrerAmbosDetalles();
        end;
        seek(master, filepos(master)-1);
        mas.cantAlfabetizados:= alfTotal;
        mas.totalEncuestados:= encTotal;
        write(master, mas);
    end;
    close(master);
    close(detalle);
    close(detalle2);
    imprimirMaestro();
end.    
