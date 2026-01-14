package futbol;

import java.sql.*;
import java.util.ArrayList;

public class BaseDeDatos {

    private static final String NOMBREBBDD = "futbol";
    public static String sentenciaCrear;

    // ------------------ Conexión ------------------
    private static Connection getConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/" + NOMBREBBDD + "?serverTimezone=UTC";
        String usuario = "root";
        String password = "";
        return DriverManager.getConnection(url, usuario, password);
    }

    // ------------------ Equipos ------------------

    public static void aniadirEquipo() {
        try (Connection conexion = getConexion();
             Statement stmt = conexion.createStatement()) {
            stmt.executeUpdate(sentenciaCrear);
        } catch (SQLException e) {
            System.out.println("Error al añadir equipo: " + e.getMessage());
        }
    }

    public static ArrayList<String> obtenerNombresEquipos() {
        ArrayList<String> equipos = new ArrayList<>();
        String sql = "SELECT nombre FROM Equipos";
        try (Connection conexion = getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                equipos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer equipos: " + e.getMessage());
        }
        return equipos;
    }

    public static void eliminarEquipoPorNombre(String nombreEquipo) {
        String sql = "DELETE FROM Equipos WHERE nombre = ?";
        try (Connection conexion = getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombreEquipo);
            ps.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Error al eliminar equipo: " + e.getMessage());
        }
    }

    public static String obtenerCiudadEquipo(String nombreEquipo) {
        String ciudad = "";
        String sql = "SELECT ciudad FROM Equipos WHERE nombre = ?";
        try (Connection conexion = getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombreEquipo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) ciudad = rs.getString("ciudad");
        } catch (SQLException e) {
            System.out.println("Error obtener ciudad: " + e.getMessage());
        }
        return ciudad;
    }

    public static String obtenerEstadioEquipo(String nombreEquipo) {
        String estadio = "";
        String sql = "SELECT estadio FROM Equipos WHERE nombre = ?";
        try (Connection conexion = getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombreEquipo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) estadio = rs.getString("estadio");
        } catch (SQLException e) {
            System.out.println("Error obtener estadio: " + e.getMessage());
        }
        return estadio;
    }

    public static void actualizarEquipo(String nombreOriginal, String nuevoNombre, String ciudad, String estadio) {
        String sql = "UPDATE Equipos SET nombre = ?, ciudad = ?, estadio = ? WHERE nombre = ?";
        try (Connection conexion = getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nuevoNombre);
            ps.setString(2, ciudad);
            ps.setString(3, estadio);
            ps.setString(4, nombreOriginal);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizar equipo: " + e.getMessage());
        }
    }

    // ------------------ Jugadores ------------------

    public static void aniadirJugador(String nombre, String posicion, String nombreEquipo) {
        int id = obtenerUltimoIDJugador() + 1;
        int idEquipo = obtenerIdEquipoPorNombre(nombreEquipo);
        if (idEquipo == -1) {
            System.out.println("Error: equipo no encontrado");
            return;
        }

        String sql = "INSERT INTO Jugadores (id, nombre, posicion, equipo_id) VALUES (?, ?, ?, ?)";
        try (Connection conexion = getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, posicion);
            ps.setInt(4, idEquipo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al añadir jugador: " + e.getMessage());
        }
    }

    private static int obtenerUltimoIDJugador() {
        int id = 0;
        String sql = "SELECT MAX(id) AS maxId FROM Jugadores";
        try (Connection conexion = getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) id = rs.getInt("maxId");
        } catch (SQLException e) {
            System.out.println("Error obtener último ID jugador: " + e.getMessage());
        }
        return id;
    }

    public static int obtenerIdEquipoPorNombre(String nombreEquipo) {
        int id = -1;
        String sql = "SELECT id FROM Equipos WHERE nombre = ?";
        try (Connection conexion = getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombreEquipo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) id = rs.getInt("id");
        } catch (SQLException e) {
            System.out.println("Error obtener ID del equipo: " + e.getMessage());
        }
        return id;
    }

    public static ArrayList<String> obtenerJugadoresPorEquipo(String nombreEquipo) {
        ArrayList<String> jugadores = new ArrayList<>();
        int idEquipo = obtenerIdEquipoPorNombre(nombreEquipo);
        if (idEquipo == -1) return jugadores;

        String sql = "SELECT nombre FROM Jugadores WHERE equipo_id = ?";
        try (Connection conexion = getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) jugadores.add(rs.getString("nombre"));
        } catch (SQLException e) {
            System.out.println("Error obtener jugadores: " + e.getMessage());
        }
        return jugadores;
    }

    public static String obtenerPosicionJugador(String nombreJugador, String nombreEquipo) {
        String posicion = "";
        int idEquipo = obtenerIdEquipoPorNombre(nombreEquipo);
        if (idEquipo == -1) return posicion;

        String sql = "SELECT posicion FROM Jugadores WHERE nombre = ? AND equipo_id = ?";
        try (Connection conexion = getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombreJugador);
            ps.setInt(2, idEquipo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) posicion = rs.getString("posicion");
        } catch (SQLException e) {
            System.out.println("Error obtener posición jugador: " + e.getMessage());
        }
        return posicion;
    }

    public static void actualizarJugador(String nombreOriginal, String nombreEquipo, String nuevoNombre, String posicion) {
        int idEquipo = obtenerIdEquipoPorNombre(nombreEquipo);
        if (idEquipo == -1) return;

        String sql = "UPDATE Jugadores SET nombre = ?, posicion = ? WHERE nombre = ? AND equipo_id = ?";
        try (Connection conexion = getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nuevoNombre);
            ps.setString(2, posicion);
            ps.setString(3, nombreOriginal);
            ps.setInt(4, idEquipo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizar jugador: " + e.getMessage());
        }
    }
}
