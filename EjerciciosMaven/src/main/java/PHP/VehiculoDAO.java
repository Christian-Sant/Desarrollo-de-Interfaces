package PHP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class VehiculoDAO {
    private Connection conn;
    private PreparedStatement st;
    private ResultSet res;
    
    public boolean InsertarVehiculo(Vehiculo v)
    {
        String sql = "INSERT INTO Vehiculos (marca, matricula, modelo, anio)VALUES (?,?,?,?);";
        
        try
        {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, v.getMarca());
            st.setString(2, v.getMatricula());
            st.setString(3, v.getModelo());
            st.setInt(4, v.getAnio());
            return st.execute();
        }
        catch (Exception e)
        {
            
        }
		return false;
    }
    
    public List<Vehiculo> ListarTodosLosVehiculos()
    {
        List<Vehiculo> lista = new ArrayList<Vehiculo>();
        String sql = "SELECT * FROM Vehiculo v Inner Join Propietario p ON v.id_propietario = p.id_propietario";
        
        try
        {
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            res = st.executeQuery();
            while(res.next()) {
            	Vehiculo v = new Vehiculo();
            	v.setIdVehiculo(res.getInt("id_vehiculo"));
            	v.setMatricula(res.getString("matricula"));
            }
        }
        catch (Exception e)
        {
            
        }
    }
}