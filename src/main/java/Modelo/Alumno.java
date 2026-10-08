package Modelo;

import java.time.LocalDate;

public class Alumno {
    private int id_alumno;
    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    private boolean activo;

    public Alumno() {}

    public Alumno(int dni, String apellido, String nombre, LocalDate fecha_nacimiento, boolean activo) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.activo = activo;
    }

    public Alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fechaNacimiento, boolean activo) {
        this.id_alumno = idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecha_nacimiento = fechaNacimiento;
        this.activo = activo;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Alumno: " 
                + "id_alumno: " + id_alumno 
                + " dni: " + dni 
                + " nombre: " + nombre 
                + " apellido: " + apellido 
                + " fecha_nacimiento: " + fecha_nacimiento 
                + " activo: " + activo;
    }
}
