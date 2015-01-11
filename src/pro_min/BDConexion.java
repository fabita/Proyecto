
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pro_min;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Usuario
 */
public class BDConexion {

    Connection conect = null;
  
    public Connection conexion()
    {
      try {
           //Cargamos el Driver MySQL
           Class.forName("com.mysql.jdbc.Driver");
           conect = DriverManager.getConnection("jdbc:mysql://localhost/bdproject1","root","root");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
     
    }
    
    /**
    *
    *Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
    *@param sql Cadena que contiene la instrucción SQL a ejecutar
    *@return estado regresa el estado de la ejecución, true(éxito) o false(error)
    *
    */
    public boolean ejecutarSQL(String sql)
    {
       try {
           PreparedStatement sentencia = conect.prepareStatement(sql);
          sentencia.execute(sql);
          return true;
       } catch (SQLException ex) {
            return false;
       }
    }

    /**
    *
    *Método utilizado para realizar la instrucción SELECT
    *@param sql Cadena que contiene la instrucción SQL a ejecutar
    *@return resultado regresa los registros generados por la consulta
    *
    */
    public ResultSet ejecutarSQLSelect(String sql)
    {
       ResultSet resultado;
       try {
          PreparedStatement sentencia = conect.prepareStatement(sql);
          resultado = sentencia.executeQuery();
          return resultado;
       } catch (SQLException ex) {
          System.err.println("Error "+ex);
          return null;
       }
    }
}
