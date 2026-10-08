package Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Modelo.Alumno;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoData {
    private Connection con = null;

    public AlumnoData() {
        con = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno a) {
        String sql = "INSERT INTO alumno (dni, nombre, apellido, fecha_nacimiento, activo) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setDate(4, Date.valueOf(a.getFecha_nacimiento()));
            ps.setBoolean(5, a.isActivo());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                a.setId_alumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno guardado con éxito. ID: " + a.getId_alumno());
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener el ID del alumno.");
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, "Error al guardar alumno", ex);
            JOptionPane.showMessageDialog(null, "Error al insertar en la base de datos: " + ex.getMessage());
        }
    }
    
    public Alumno buscarAlumno(int id) {
        Alumno a = null;
        String sql = "SELECT * FROM alumno WHERE id_alumno = ?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) { 
                a = new Alumno();
                a.setId_alumno(rs.getInt("id_alumno"));
                a.setDni(rs.getInt("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún alumno con el ID: " + id);
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, "Error al buscar alumno por ID", ex);
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + ex.getMessage());
        }

        return a;
    }
    
    public void actualizarAlumno(Alumno a) {
        String sql = "UPDATE alumno SET dni = ?, nombre = ?, apellido = ?, fecha_nacimiento = ?, activo = ? WHERE id_alumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setDate(4, Date.valueOf(a.getFecha_nacimiento()));
            ps.setBoolean(5, a.isActivo());
            ps.setInt(6, a.getId_alumno());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe o no se pudo actualizar.");
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, "Error al actualizar alumno", ex);
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del alumno: " + ex.getMessage());
        }
    }
    
    public void bajaLogicaAlumno(int id) {
        String sql = "UPDATE alumno SET activo = 0 WHERE id_alumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno borrado/dado de baja exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el alumno a eliminar.");
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, "Error al borrar alumno", ex);
            JOptionPane.showMessageDialog(null, "Error al borrar el alumno: " + ex.getMessage());
        }
    }
    
    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE activo = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setId_alumno(rs.getInt("id_alumno"));
                a.setDni(rs.getInt("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));

                alumnos.add(a); 
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, "Error al listar alumnos", ex);
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de alumnos: " + ex.getMessage());
        }

        return alumnos;
    }
}