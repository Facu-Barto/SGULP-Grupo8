package Modelo;

public class Inscripcion {
    private int idCursada;
    Materia materia;
    Alumno alumno;
    private float nota;
    private float asist;
    private int anio;

    public Inscripcion(int idCursada, Materia materia, Alumno alumno, float nota, float asist, int anio) {
        this.idCursada = idCursada;
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
        this.asist = asist;
        this.anio = anio;
    }
}
