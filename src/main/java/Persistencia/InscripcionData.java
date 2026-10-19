package Persistencia;

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
    public List MateriasNoInscriptas(int dni)
    {
       List materias = new ArrayList<Materia>(); 
       String sql = "SELECT * FROM materia\n" +"WHERE estado = 1\n"+"AND id_materia NOT IN (SELECT id_materia FROM inscripcion WHERE id_alumno = ?)"; 
       try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1,dni);
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
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, i.getId_alumno().getId_alumno());
            ps.setInt(2, i.getId_materia().getId_materia());
            ps.setFloat(3, i.getNota());
            ps.setInt(4, i.getAsistencia());
            ps.setInt(5, i.getCursa());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                i.setId_cursada(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción registrada con éxito. ID: " + i.getId_cursada());
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar la inscripción: " + ex.getMessage());
        }
    }
   
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
    List<Inscripcion> cursadas = new ArrayList<>();
    String sql = "SELECT i.id_cursada, i.nota, i.asistencia, i.cursa, " +
                 "m.id_materia, m.nombre, m.anio, m.estado " +
                 "FROM inscripcion i " +
                 "JOIN materia m ON i.id_materia = m.id_materia " +
                 "WHERE i.id_alumno = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAlumno);
        ResultSet rs = ps.executeQuery();
        
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
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + ex.getMessage());
    }
    return cursadas;
}
}