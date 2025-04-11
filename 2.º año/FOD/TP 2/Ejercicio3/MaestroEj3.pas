program CrearMaestro;

type
    alfabetizados = record
        provincia: String[20];
        cantAlfabetizados: integer;
        totalEncuestados: integer;
    end;

    archivo = file of alfabetizados;

var
    f: archivo;
    r: alfabetizados;
begin
    assign(f, 'Alfabetizados.dat');
    rewrite(f);

    // Provincias ordenadas alfabéticamente
    r.provincia := 'Buenos Aires'; r.cantAlfabetizados := 0; r.totalEncuestados := 0; write(f, r);
    r.provincia := 'Cordoba'; r.cantAlfabetizados := 0; r.totalEncuestados := 0; write(f, r);
    r.provincia := 'Mendoza'; r.cantAlfabetizados := 0; r.totalEncuestados := 0; write(f, r);
    r.provincia := 'Santa Fe'; r.cantAlfabetizados := 0; r.totalEncuestados := 0; write(f, r);

    close(f);
    writeln('Archivo maestro creado.');
end.
