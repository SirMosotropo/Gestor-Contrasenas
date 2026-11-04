package gui;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Este fichero no hace nada de momento, no  hay llamadas en GUI.java
// Clase provisional para la gestión de la base de datos SQLite de la aplicación Javault.
 
public class GestorBD {

    // Cadena de conexión JDBC para SQLite (creará el archivo 'javault.db' automáticamente)
    private static final String DB_URL = "jdbc:sqlite:javault.db";

    /**
     * Establece la conexión con el archivo de base de datos SQLite.
     */
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    /**
     * Crea la tabla principal 'contrasenas' si no existe en la base de datos.
     */
    public static void inicializarBD() {
        String sql = "CREATE TABLE IF NOT EXISTS contrasenas ("
                   + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + " servicio TEXT NOT NULL,"
                   + " usuario TEXT NOT NULL,"
                   + " password TEXT NOT NULL,"
                   + " tipo TEXT"
                   + ");";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Base de datos SQLite inicializada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }

    /**
     * Inserta un nuevo registro de contraseña en la base de datos.
     */
    public static boolean insertarContrasena(String servicio, String usuario, String password, String tipo) {
        String sql = "INSERT INTO contrasenas(servicio, usuario, password, tipo) VALUES(?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, servicio);
            pstmt.setString(2, usuario);
            pstmt.setString(3, password);
            pstmt.setString(4, tipo);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar contraseña: " + e.getMessage());
            return false;
        }
    }

    /**
     * Recupera todos los registros almacenados para cargarlos en la tabla JTable de la bóveda.
     */
    public static List<Object[]> obtenerContrasenas() {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT servicio, usuario, password, tipo FROM contrasenas";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Object[] fila = new Object[]{
                    rs.getString("servicio"),
                    rs.getString("usuario"),
                    rs.getString("password"),
                    rs.getString("tipo")
                };
                lista.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la base de datos: " + e.getMessage());
        }
        return lista;
    }

    /**
     * Elimina una contraseña específica por servicio y usuario.
     */
    public static boolean eliminarContrasena(String servicio, String usuario) {
        String sql = "DELETE FROM contrasenas WHERE servicio = ? AND usuario = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, servicio);
            pstmt.setString(2, usuario);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar la contraseña: " + e.getMessage());
            return false;
        }
    }
}