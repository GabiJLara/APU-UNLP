program Ejercicio7;

const
    valorAlto = 32764;

type
    alumnos = record
        codAlumno: integer;
        apellido: String;
        nombre: String;
        cantCursadasAprobadas: integer;
        cantFinalesAprobados: integer;
    end;

    cursadas = record
        codAlumno: integer;
        codMateria: integer;
        anio: integer;  // PONGO INTEGER (ES INDISTINTO NO SE USA)
        resultado: boolean; // TRUE = APROBADO ---- FALSE = DESAPROBADO
    end;

    examenes = record
        codAlumno: integer;
        codMateria: integer;
        fecha: integer;  // PONGO INTEGER (ES INDISTINTO NO SE USA)
        nota: real;
    end;

    maestro = file of alumnos;
    detalle1 = file of cursadas;
    detalle2 = file of examenes;

var
    aux,cantMaterias,cantExamenes: integer;
    cur: cursadas;
    exam: examenes;
    alum: alumnos;
    master: maestro;
    detail1: detalle1;
    detail2: detalle2;

    procedure leerD1(var d1: detalle1; var c: cursadas);
    begin
        if not EOF(d1)then
            read(d1,c)
        else
            c.codAlumno:= valorAlto;
            c.codMateria:= valorAlto;
    end;

    procedure leerD2(var d2: detalle2; var e: examenes);
    begin
        if not EOF(d2)then
            read(d2,e)
        else
            e.codAlumno:= valorAlto;
            e.codMateria:= valorAlto;
    end;

    procedure procesarCursadas();
    begin
        while(cur.codAlumno = aux)do
        begin
            if(cur.resultado)then
                cantMaterias:= cantMaterias + 1;
            leerD1(detail1,cur);
        end;
    end;

    procedure procesarExamenes();
    begin
        while(exam.codAlumno = aux)do
        begin
            if(exam.nota >= 4)then
                cantExamenes:= cantExamenes + 1;
            leerD2(detail2, exam);
        end;
    end;

begin
    assign(master, 'AlumnosFdI.dat');
    reset(master);
    assign(detail1, 'Cursadas.dat');
    reset(detail1);
    assign(detail2, 'Examenes.dat');
    reset(detail2);
    leerD1(detail1, cur);
    leerD2(detail2, exam);
    while((cur.codAlumno <> valorAlto) or (exam.codAlumno <> valorAlto)) do
    begin
        cantMaterias:= 0;
        cantExamenes:= 0;
        if(cur.codAlumno = exam.codAlumno)then
        begin
            aux:= cur.codAlumno;
            procesarCursadas();
            procesarExamenes();
        end
        else if(cur.codAlumno < exam.codAlumno)then
        begin
            aux:= cur.codAlumno;
            procesarCursadas();
        end
        else if(cur.codAlumno > exam.codAlumno) then
        begin
            aux:= exam.codAlumno;
            procesarExamenes();
        end;
        read(master, alum);
        while(aux <> alum.codAlumno)do
        begin
            read(master, alum);
        end;
        alum.cantCursadasAprobadas:= alum.cantCursadasAprobadas + cantMaterias;
        alum.cantFinalesAprobados:= alum.cantFinalesAprobados + cantExamenes;
        seek(master, filepos(master)-1);
        write(master,alum);
    end;
    close(master);
    close(detail1);
    close(detail2);
end.

