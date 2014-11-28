/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pro_min.BDConexion;

/**
 *
 * @author FABIOLA
 */
public class Reporte {
    // fecha, turno, nroMaquina, proyecto, area, zona, nroSonsaje;
    
    DefaultTableModel model;
    BDConexion bd = new BDConexion();
    Connection cn = bd.conexion();

    private String fecha;
    private String proyecto;
    private String area;
    private String zona;
    private String maquina;
    private String turno;
    private String sondaje;
    private String accesorios;
    private String cantidad;

    public String getFecha() {
        return fecha;
    }

    public String getProyecto() {
        return proyecto;
    }

    public String getArea() {
        return area;
    }

    public String getZona() {
        return zona;
    }

    public String getMaquina() {
        return maquina;
    }

    public String getTurno() {
        return turno;
    }

    public String getSondaje() {
        return sondaje;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setSondaje(String sondaje) {
        this.sondaje = sondaje;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    public void reporte(){
        try{
            Statement st = cn.createStatement();
            System.out.println("insert into ope_accesorios values ('"
                    +fecha+"', '"+proyecto+"', '"+area+"', '"+zona+"', '"
                    +maquina+"', '"+turno+"', '"+sondaje+"' )");
            st.execute("insert into ope_accesorios values ('"
                    +fecha+"', '"+proyecto+"', '"+area+"', '"+zona+"', '"
                    +maquina+"', '"+turno+"', '"
                    
                    +sondaje+"' )");//+accesorios+"', '"+cantidad+"', '");
            JOptionPane.showMessageDialog(null, "Registro Guardado con exito");
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
            
    }
    
}
    
    