
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
}
