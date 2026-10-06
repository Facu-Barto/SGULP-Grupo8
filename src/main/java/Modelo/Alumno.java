package Modelo;

import java.time.LocalDate;

public class Alumno {
    private int dni;
    private String nombre;
    private LocalDate fechaNac;
    private boolean activo;

    public Alumno(int dni, String nombre, LocalDate fechaNac, boolean activo) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    public Alumno() {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Alumno{" + "dni=" + dni + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", activo=" + activo + '}';
    }
}
