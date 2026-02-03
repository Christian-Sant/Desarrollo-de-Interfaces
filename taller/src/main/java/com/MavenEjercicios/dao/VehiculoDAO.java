package com.MavenEjercicios.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.MavenEjercicios.config.Conexion;
import com.MavenEjercicios.model.Vehiculo;

public class VehiculoDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // 1. Listar con información del Propietario (JOIN)
    public List<Vehiculo> listarTodoInfoCompleta() {
        List<Vehiculo> lista = new ArrayList<>();
        String sql = "SELECT v.*, p.nombre FROM vehiculos v JOIN propietarios p ON v.id_propietario = p.id_propietario";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vehiculo v = new Vehiculo();
                v.setIdVehiculo(rs.getInt("id_vehiculo"));
                v.setMatricula(rs.getString("matricula"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setAnio(rs.getInt("anio"));
                v.setIdPropietario(rs.getInt("id_propietario"));
                v.setNombre(rs.getString("nombre")); // Dato del JOIN
                lista.add(v);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }

    // 2. Insertar Vehículo
    public boolean agregar(Vehiculo v) {
        String sql = "INSERT INTO vehiculos(matricula, marca, modelo, anio, id_propietario) VALUES(?,?,?,?,?)";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getMatricula());
            ps.setString(2, v.getMarca());
            ps.setString(3, v.getModelo());
            ps.setInt(4, v.getAnio());
            ps.setInt(5, v.getIdPropietario());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    // 3. Consulta Específica: 5 más antiguos
    public List<Vehiculo> get5MasAntiguos() {
        List<Vehiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM vehiculos ORDER BY anio ASC LIMIT 5";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Vehiculo v = new Vehiculo();
                v.setIdVehiculo(rs.getInt("id_vehiculo"));
                v.setMatricula(rs.getString("matricula"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setAnio(rs.getInt("anio"));
                v.setIdPropietario(rs.getInt("id_propietario"));
                lista.add(v);
            }
        } catch(Exception e) { e.printStackTrace(); }
        return lista;
    }

    // 4. Total de vehículos
    public int getTotalVehiculos() {
        String sql = "SELECT COUNT(*) FROM vehiculos";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) return rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }

    // 5. Editar vehículo
    public boolean editar(Vehiculo v) {
        String sql = "UPDATE vehiculos SET matricula=?, marca=?, modelo=?, anio=?, id_propietario=? WHERE id_vehiculo=?";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getMatricula());
            ps.setString(2, v.getMarca());
            ps.setString(3, v.getModelo());
            ps.setInt(4, v.getAnio());
            ps.setInt(5, v.getIdPropietario());
            ps.setInt(6, v.getIdVehiculo());
            return ps.executeUpdate() > 0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }

    // 6. Eliminar vehículo
    public boolean eliminar(int id) {
        String sql = "DELETE FROM vehiculos WHERE id_vehiculo=?";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch(Exception e) { e.printStackTrace(); return false; }
    }

    // 7. Listar vehículo por ID
    public Vehiculo listarPorId(int id) {
        Vehiculo v = null;
        String sql = "SELECT * FROM vehiculos WHERE id_vehiculo=?";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                v = new Vehiculo();
                v.setIdVehiculo(rs.getInt("id_vehiculo"));
                v.setMatricula(rs.getString("matricula"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setAnio(rs.getInt("anio"));
                v.setIdPropietario(rs.getInt("id_propietario"));
            }
        } catch(Exception e) { e.printStackTrace(); }
        return v;
    }
}
