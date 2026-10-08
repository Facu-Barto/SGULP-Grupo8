package Persistencia;

import Modelo.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class InscripcionData {
    private Connection con = null;

    public InscripcionData() {
        con = Conexion.getConexion();
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
}