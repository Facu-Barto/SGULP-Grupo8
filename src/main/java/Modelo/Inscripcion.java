package Modelo;

public class Inscripcion {

    private int id_cursada;
    private Alumno id_alumno;
    private Materia id_materia;
    private float nota;
    private int asistencia;
    private int cursa;

    public Inscripcion() {}

    public Inscripcion(Alumno id_alumno, Materia id_materia, float nota, int asistencia, int cursa) {
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
        this.nota = nota;
        this.asistencia = asistencia;
        this.cursa = cursa;
    }

    public Inscripcion(int idCursada, Alumno alumno, Materia materia, float nota, int asistencia, int cursa) {
        this.id_cursada = idCursada;
        this.id_alumno = alumno;
        this.id_materia = materia;
        this.nota = nota;
        this.asistencia = asistencia;
        this.cursa = cursa;
    }

    public int getId_cursada() {
        return id_cursada;
    }

    public void setId_cursada(int id_cursada) {
        this.id_cursada = id_cursada;
    }

    public Alumno getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Alumno id_alumno) {
        this.id_alumno = id_alumno;
    }

    public Materia getId_materia() {
        return id_materia;
    }

    public void setId_materia(Materia id_materia) {
        this.id_materia = id_materia;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public int getCursa() {
        return cursa;
    }

    public void setCursa(int cursa) {
        this.cursa = cursa;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id_cursada=" + id_cursada + ", id_alumno=" + id_alumno + ", id_materia=" + id_materia + ", nota=" + nota + ", asistencia=" + asistencia + ", cursa=" + cursa + '}';
    }
}
