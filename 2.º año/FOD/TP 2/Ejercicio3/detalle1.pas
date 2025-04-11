program CrearDetalle;

type
    agencia = record
        provincia: String[20];
        codigo: integer;
        cantAlfabetizados: integer;
        cantEncuestados: integer;
    end;

    archivoDetalle = file of agencia;

var
    f: archivoDetalle;
    r: agencia;
begin
    assign(f, 'Detalle.dat');
    rewrite(f);

    // Ordenado por provincia
    r.provincia := 'Buenos Aires'; r.codigo := 1; r.cantAlfabetizados := 120; r.cantEncuestados := 150;
    write(f, r);
    r.provincia := 'Cordoba'; r.codigo := 2; r.cantAlfabetizados := 80; r.cantEncuestados := 100;
    write(f, r);
    r.provincia := 'Cordoba'; r.codigo := 3; r.cantAlfabetizados := 50; r.cantEncuestados := 60; 
    write(f, r);
    r.provincia := 'Santa Fe'; r.codigo := 4; r.cantAlfabetizados := 90; r.cantEncuestados := 110; 
    write(f, r);

    close(f);
    writeln('Archivo detalle 1 creado.');
end.
