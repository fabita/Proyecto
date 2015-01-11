/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pro_min.BDConexion;

/**
 *
 * @author FABIOLA
 */
public class LlenarTablaAccesorios {
    // fecha, turno, nroMaquina, proyecto, area, zona, nroSonsaje;
    
    DefaultTableModel model;
    BDConexion bd = new BDConexion();
    Connection cn = bd.conexion();

     public void llenar_tabla_Accesorios(int numCol,int columBoolean,DefaultTableModel modelo, JTable tabla){
        try{String query="select descripcion, precio from accesorios";
            ResultSet rs;
            rs = bd.ejecutarSQLSelect(query);
            //cantidad de columnas=2 contando la columna checkbox
            Object[] filas = new Object[numCol];
            while(rs.next()){
//                filas[0]=rs.getString(1);
                for(int i=1;i<=numCol;i++)
                {/*Lavariable columBoolean indica
                 * el número de columna que tendrá los checkbox
                 * es decir la booleana
                 */
                    //si i es igual a la columna checkbox
                    if(i==columBoolean){
                        //por defecto saldrán sin seleccionar, es decir como FALSE
                        filas[columBoolean-1]=Boolean.FALSE;
                    }else{
                        //si no rellenará la tabla con los datos normalmente
                        filas[i-1]=rs.getObject(i-1);
                    }
                }
                //añade las filas
                modelo.addRow(filas);
            }tabla.updateUI();//actualiza
            rs.close();
        }catch(SQLException | HeadlessException e)
        {System.err.println(e);}
    }
}
