package com.MavenEjercicios.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.MavenEjercicios.config.Conexion;
import com.MavenEjercicios.model.Propietario;

public class PropietarioDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Listar todos los propietarios (para el <select>)
    public List<Propietario> listar() {
        List<Propietario> lista = new ArrayList<>();
        String sql = "SELECT * FROM propietarios";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Propietario p = new Propietario(
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getString("direccion")
                );
                p.setIdPropietario(rs.getInt("id_propietario"));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Insertar propietario
    public boolean agregar(Propietario p) {
        String sql = "INSERT INTO propietarios(nombre, telefono, direccion) VALUES (?,?,?)";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getTelefono());
            ps.setString(3, p.getDireccion());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar propietario
    public boolean eliminar(int id) {
        String sql = "DELETE FROM propietarios WHERE id_propietario = ?";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
