package Modelo;

public class Materia {
    private int idMateria;
    private String nombreMateria;
    private boolean estado;

    public Materia(int idMateria, String nombreMateria, boolean estado) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.estado = estado;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
