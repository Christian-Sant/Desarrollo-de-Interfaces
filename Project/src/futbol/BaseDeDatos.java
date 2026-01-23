package futbol;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase que maneja la conexión y operaciones sobre la base de datos de fútbol.
 * Permite agregar, actualizar y consultar equipos y jugadores.
 * Todas las operaciones se realizan sobre la base de datos MySQL "futbol".
 * 
 * @author Christian
 * @version 1.0
 * @since 2026-01-19
 */
public class BaseDeDatos {

    private static final String NOMBREBBDD = "futbol";
    public static String sentenciaCrear;

    // ------------------ Conexión ------------------

    /**
     * Obtiene la conexión a la base de datos.
     * 
     * @return Conexión a la base de datos MySQL.
     * @throws SQLException Si ocurre un error al conectarse.
     */
    private static Connection getConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/" + NOMBREBBDD + "?serverTimezone=UTC";
        String usuario = "root";
        String password = "";
        return DriverManager.getConnection(url, usuario, password);
    }

    // ------------------ Equipos ------------------

    /**
     * Ejecuta la sentencia SQL para añadir un equipo.
     */
    public static void aniadirEquipo() {
        try (Connection conexion = getConexion();
             Statement stmt = conexion.createStatement()) {
            stmt.executeUpdate(sentenciaCrear);
        } catch (SQLException e) {
            System.out.println("Error al añadir equipo: " + e.getMessage());
        }
    }

    /**
     * Obtiene los nombres de todos los equipos de la base de datos.
     * 
     * @return Lista de nombres de equipos.
     */
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

    /**
     * Elimina un equipo según su nombre.
     * 
     * @param nombreEquipo Nombre del equipo a eliminar.
     */
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

    /**
     * Obtiene la ciudad de un equipo dado su nombre.
     * 
     * @param nombreEquipo Nombre del equipo.
     * @return Ciudad del equipo.
     */
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

    /**
     * Obtiene el estadio de un equipo dado su nombre.
     * 
     * @param nombreEquipo Nombre del equipo.
     * @return Estadio del equipo.
     */
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

    /**
     * Actualiza los datos de un equipo.
     * 
     * @param nombreOriginal Nombre actual del equipo.
     * @param nuevoNombre Nuevo nombre del equipo.
     * @param ciudad Nueva ciudad del equipo.
     * @param estadio Nuevo estadio del equipo.
     */
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

    /**
     * Añade un jugador a un equipo específico.
     * 
     * @param nombre Nombre del jugador.
     * @param posicion Posición del jugador.
     * @param nombreEquipo Nombre del equipo al que pertenece.
     */
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

    /**
     * Obtiene el último ID registrado de jugador.
     * 
     * @return Último ID de jugador.
     */
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

    /**
     * Obtiene el ID de un equipo por su nombre.
     * 
     * @param nombreEquipo Nombre del equipo.
     * @return ID del equipo, o -1 si no se encuentra.
     */
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

    /**
     * Obtiene los nombres de los jugadores de un equipo.
     * 
     * @param nombreEquipo Nombre del equipo.
     * @return Lista de nombres de jugadores.
     */
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

    /**
     * Obtiene la posición de un jugador en un equipo.
     * 
     * @param nombreJugador Nombre del jugador.
     * @param nombreEquipo Nombre del equipo.
     * @return Posición del jugador.
     */
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

    /**
     * Actualiza los datos de un jugador en un equipo.
     * 
     * @param nombreOriginal Nombre actual del jugador.
     * @param nombreEquipo Nombre del equipo al que pertenece.
     * @param nuevoNombre Nuevo nombre del jugador.
     * @param posicion Nueva posición del jugador.
     */
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
