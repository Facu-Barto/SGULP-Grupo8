package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Modelo.Materia;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MateriaData {
    private Connection con = null;

    public MateriaData() {
        con = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre, anio, estado) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setId_materia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia añadida con éxito. ID: " + materia.getId_materia());
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia: " + ex.getMessage());
        }
    }
    public Materia buscarMateria(int id) {
    Materia m = null;
    String sql = "SELECT * FROM materia WHERE id_materia = ?";

    PreparedStatement ps;
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {  
            m = new Materia();
            
            m.setId_materia(rs.getInt("id_materia")); 
            m.setNombre(rs.getString("nombre"));
            m.setAnio(rs.getInt("anio")); 
            m.setEstado(rs.getBoolean("estado"));
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna materia con el ID: " + id);
        }
        ps.close();

    } catch (SQLException ex) {
        Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, "Error al buscar materia por ID", ex);
        JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + ex.getMessage());
    }

    return m;
}
}