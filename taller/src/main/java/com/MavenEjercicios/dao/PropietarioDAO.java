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

    // 1. Listar todos los propietarios
    public List<Propietario> listar() {
        List<Propietario> lista = new ArrayList<>();
        String sql = "SELECT * FROM propietarios";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Propietario p = new Propietario();
                p.setIdPropietario(rs.getInt("id_propietario"));
                p.setNombre(rs.getString("nombre"));
                p.setTelefono(rs.getString("telefono"));
                p.setDireccion(rs.getString("direccion"));
                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // 2. Agregar propietario
    public boolean agregar(Propietario p) {
        String sql = "INSERT INTO propietarios(nombre, telefono, direccion) VALUES(?,?,?)";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getDireccion());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3. Obtener propietario por ID
    public Propietario listarPorId(int id) {
        Propietario p = null;
        String sql = "SELECT * FROM propietarios WHERE id_propietario = ?";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                p = new Propietario();
                p.setIdPropietario(rs.getInt("id_propietario"));
                p.setNombre(rs.getString("nombre"));
                p.setTelefono(rs.getString("telefono"));
                p.setDireccion(rs.getString("direccion"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    // 4. Editar propietario
    public boolean editar(Propietario p) {
        String sql = "UPDATE propietarios SET nombre=?, telefono=?, direccion=? WHERE id_propietario=?";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getDireccion());
            ps.setInt(4, p.getIdPropietario());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 5. Eliminar propietario
    public boolean eliminar(int id) {
        String sql = "DELETE FROM propietarios WHERE id_propietario = ?";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}