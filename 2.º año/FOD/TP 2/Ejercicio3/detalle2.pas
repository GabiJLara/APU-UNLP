program CrearDetalle2;

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
    assign(f, 'Detalle2.dat');
    rewrite(f);

    // Ordenado por provincia
    r.provincia := 'Buenos Aires'; r.codigo := 5; r.cantAlfabetizados := 100; r.cantEncuestados := 130; write(f, r);
    r.provincia := 'Mendoza'; r.codigo := 6; r.cantAlfabetizados := 70; r.cantEncuestados := 80; write(f, r);
    r.provincia := 'Santa Fe'; r.codigo := 7; r.cantAlfabetizados := 60; r.cantEncuestados := 90; write(f, r);

    close(f);
    writeln('Archivo detalle 2 creado.');
end.
