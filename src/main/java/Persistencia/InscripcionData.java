package Persistencia;

import Modelo.Alumno;
import Modelo.Inscripcion;
import Modelo.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionData {
    private Connection con = null;

    public InscripcionData() {
        con = Conexion.getConexion();
    }
    
    public List<Materia> materiasNoInscriptas(int id) {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado = 1 AND id_materia NOT IN (SELECT id_materia FROM inscripcion WHERE id_alumno = ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Materia m = new Materia();
                    m.setId_materia(rs.getInt("id_materia"));
                    m.setNombre(rs.getString("nombre"));
                    m.setAnio(rs.getInt("anio"));
                    m.setEstado(rs.getBoolean("estado"));
                    materias.add(m);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, "Error al obtener materias no inscriptas", ex);
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + ex.getMessage());
        }
        return materias;
    }

    public void guardarInscripcion(Inscripcion i) {
        String sql = "INSERT INTO inscripcion(id_alumno, id_materia, nota, asistencia, cursa) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, i.getId_alumno().getId_alumno());
            ps.setInt(2, i.getId_materia().getId_materia());
            ps.setFloat(3, i.getNota());
            ps.setInt(4, i.getAsistencia());
            ps.setInt(5, i.getCursa());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    i.setId_cursada(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Inscripción registrada con éxito. ID: " + i.getId_cursada());
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar la inscripción: " + ex.getMessage());
        }
    }
    
    public boolean borrarInscripcion(int idCursada) {
        String sql = "DELETE FROM inscripcion WHERE id_cursada = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCursada);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, "Error al borrar inscripción", ex);
            JOptionPane.showMessageDialog(null, "Error al borrar la inscripción: " + ex.getMessage());
            return false;
        }
    }
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        List<Inscripcion> cursadas = new ArrayList<>();
        String sql = "SELECT i.id_cursada, i.nota, i.asistencia, i.cursa, "
                + "m.id_materia, m.nombre, m.anio, m.estado "
                + "FROM inscripcion i "
                + "JOIN materia m ON i.id_materia = m.id_materia "
                + "WHERE i.id_alumno = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlumno);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Inscripcion insc = new Inscripcion();
                    insc.setId_cursada(rs.getInt("id_cursada"));
                    insc.setNota(rs.getFloat("nota"));
                    insc.setAsistencia(rs.getInt("asistencia"));
                    insc.setCursa(rs.getInt("cursa"));

                    Materia m = new Materia();
                    m.setId_materia(rs.getInt("id_materia"));
                    m.setNombre(rs.getString("nombre"));
                    m.setAnio(rs.getInt("anio"));
                    m.setEstado(rs.getBoolean("estado"));

                    insc.setId_materia(m);

                    cursadas.add(insc);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + ex.getMessage());
        }
        return cursadas;
    }
    
    public void actualizarNota(int idCursada, double nota, int asistencia) {
        String sql = "UPDATE inscripcion SET nota = ?, asistencia = ? WHERE id_cursada = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, nota);
            ps.setInt(2, asistencia);
            ps.setInt(3, idCursada);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Nota y asistencia actualizadas con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la inscripción para actualizar.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, "Error al actualizar nota", ex);
            JOptionPane.showMessageDialog(null, "Error al actualizar la nota: " + ex.getMessage());
        }
    }
    
    public List<Alumno> obtenerAlumnosPorMateria(int idMateria) {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT a.id_alumno, a.dni, a.apellido, a.nombre, a.fecha_nacimiento, a.activo "
                + "FROM alumno a "
                + "JOIN inscripcion i ON a.id_alumno = i.id_alumno "
                + "WHERE i.id_materia = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idMateria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Alumno a = new Alumno();
                    a.setId_alumno(rs.getInt("id_alumno"));
                    a.setDni(rs.getInt("dni"));
                    a.setApellido(rs.getString("apellido"));
                    a.setNombre(rs.getString("nombre"));
                    a.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                    a.setActivo(rs.getBoolean("activo"));
                    alumnos.add(a);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener alumnos por materia: " + ex.getMessage());
        }
        return alumnos;
    }
}
