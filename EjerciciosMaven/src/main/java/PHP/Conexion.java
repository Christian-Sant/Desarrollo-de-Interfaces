package PHP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
{
    private static Connection conn;
    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.JDBC");
            conn = DriverManager.getConnection("todo");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // devuelve la conexion 👍
        return conn;
    }
}