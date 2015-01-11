/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reporte;
import Clases.LlenarTablaAccesorios;
import Clases.LlenarTablaAditivos;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pro_min.BDConexion;
import Clases.Clase_CellEditor;
import Clases.Clase_CellRender;
import Clases.LlenarTablaAvances;
/**
 *
 * @author Usuario
 */
public class Report extends javax.swing.JFrame {

    /**
     * Creates new form Report
     */
    DefaultTableModel model;
    BDConexion bd = new BDConexion();
    Connection cn = bd.conexion();
    Statement st;
    LlenarTablaAccesorios llenarTablaAcces = new LlenarTablaAccesorios();
    LlenarTablaAditivos llenarTablaAditi = new LlenarTablaAditivos();
    LlenarTablaAvances llenarTablaAvan = new LlenarTablaAvances();
    DefaultTableModel modeloAcces = new DefaultTableModel();
    DefaultTableModel modeloAdit = new DefaultTableModel();
    DefaultTableModel modeloAvan = new DefaultTableModel();
    
    public Report() {
        initComponents();
        //llenar tabla accesorios
        tblAccessPerf.setModel(modeloAcces);
        modeloAcces.addColumn("Elegir");
        modeloAcces.addColumn("Accesorios de Perforacion");
        modeloAcces.addColumn("Cantidad");
        //se crea el JCheckBox en la columna indicada en getColum(cuenta desde 0)
        tblAccessPerf.getColumnModel().getColumn(0).setCellEditor( new Clase_CellEditor() );
        tblAccessPerf.getColumnModel().getColumn(0).setCellRenderer(new Clase_CellRender() );
        
        //llenar tabla aditivos
        tblAditivos1.setModel(modeloAdit);
        modeloAdit.addColumn("Elegir");
        modeloAdit.addColumn("Aditivos");
        modeloAdit.addColumn("Precio");
        modeloAdit.addColumn("Cantidad");
        //se crea el JCheckBox en la columna indicada en getColum(cuenta desde 0)
        tblAditivos1.getColumnModel().getColumn(0).setCellEditor( new Clase_CellEditor() );
        tblAditivos1.getColumnModel().getColumn(0).setCellRenderer(new Clase_CellRender() );
        
        //llenar tabla avances
        tblControlAvances.setModel(modeloAvan);
        modeloAvan.addColumn("Elegir");
        modeloAvan.addColumn("Aditivos");
        //modeloAdit.addColumn("Cantidad");
        //se crea el JCheckBox en la columna indicada en getColum(cuenta desde 0)
        tblControlAvances.getColumnModel().getColumn(0).setCellEditor( new Clase_CellEditor() );
        tblControlAvances.getColumnModel().getColumn(0).setCellRenderer(new Clase_CellRender() );
        
        // operaciones
        turno();
        nroMaquina();
        cliente();
        nomProyecto();
        area();
        zona();
        nroSondaje();
        //-- Personal de Turno --
        capataz();
        perforista();
        ayudante1();
        ayudante2();
        administrador();
        residente();
    }
    
    public void turno()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtTurno); 
                    
        Statement st = null;
        ResultSet rs = null;
        
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery("select tiempo from tiempo");
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("tiempo")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }
        
    }
//-------------------------------txtNroMaquina-------------------------------------
    public void nroMaquina()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtNroMaquina); 
                    
        Statement st = null;
        ResultSet rs = null;
        
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery("select num_maquina from maquinaria");
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("num_maquina")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }  
    }
    
    //-------------------------------txtCliente-------------------------------------
    public void cliente()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtCliente); 
                    
        Statement st = null;
        ResultSet rs = null;
        
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery("select nomCliente from cliente");
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("nomCliente")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }  
    }
    
        //-------------------------------txtNomProyec-------------------------------------
    public void nomProyecto()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtNomProyec); 
                    
        Statement st = null;
        ResultSet rs = null;
        
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery("select nomProyecto from proyectos");
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("nomProyecto")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }  
    }
    
    //-------------------------------txtArea-------------------------------------
    public void area()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtArea); 
                    
        Statement st = null;
        ResultSet rs = null;
        
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery("select areaPerforacion from proyectos");
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("areaPerforacion")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }  
    }
    
    //-------------------------------txtZona-------------------------------------
    public void zona()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtZona); 
                    
        Statement st = null;
        ResultSet rs = null;
        
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery("select zonaPerforacion from proyectos");
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("zonaPerforacion")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }  
    }
    
    //-------------------------------txtNroMaquina-------------------------------------
    public void nroSondaje()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtSondaje); 
                    
        Statement st = null;
        ResultSet rs = null;
        
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery("select codigoSondaje from sondajes");
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("codigoSondaje")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }  
    }
//-------------------------------txtCapataz-------------------------------------   
    public void capataz()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtCapataz); 
                    
        Statement st = null;
        ResultSet rs = null;
        String sql="select concat(nombres,' ',apellidos) as x from personal";
       
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("x")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }
    }
    
    //-------------------------------txtPerforista-------------------------------------   
    public void perforista()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtPerforista); 
                    
        Statement st = null;
        ResultSet rs = null;
        String sql="select concat(nombres,' ',apellidos) as x from personal";
       
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("x")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }
    }
    
    //-------------------------------txtAyudante1-------------------------------------   
    public void ayudante1()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtAyudante1); 
                    
        Statement st = null;
        ResultSet rs = null;
        String sql="select concat(nombres,' ',apellidos) as x from personal";
       
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("x")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }
    }
    
    //-------------------------------txtAyudante2-------------------------------------   
    public void ayudante2()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtAyudante2); 
                    
        Statement st = null;
        ResultSet rs = null;
        String sql="select concat(nombres,' ',apellidos) as x from personal";
       
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("x")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }
    }
    
    //-------------------------------txtAdministrador-------------------------------------   
    public void administrador()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtAdministrador); 
                    
        Statement st = null;
        ResultSet rs = null;
        String sql="select concat(nombres,' ',apellidos) as x from personal";
       
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("x")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }
    }
    
    //-------------------------------txtResidente-------------------------------------   
    public void residente()
    {
        TextAutoCompleter textAutocompleter = new TextAutoCompleter(txtResidente); 
                    
        Statement st = null;
        ResultSet rs = null;
        String sql="select concat(nombres,' ',apellidos) as x from personal";
       
        try{
            st = (Statement)cn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()){
                textAutocompleter.addItem((rs.getString("x")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtAdministrador = new javax.swing.JTextField();
        txtResidente = new javax.swing.JTextField();
        txtAyudante2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCapataz = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtAyudante1 = new javax.swing.JTextField();
        txtPerforista = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtObservaciones = new java.awt.TextArea();
        jLabel20 = new javax.swing.JLabel();
        txtTurno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtProfProgramada = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtConstante = new javax.swing.JTextField();
        txtNroMaquina = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtNomProyec = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        txtSondaje = new javax.swing.JTextField();
        txtInclinacion = new javax.swing.JTextField();
        txtAzimut = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtZona = new javax.swing.JTextField();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblControlAvances = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDistriTiempo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTotal1 = new javax.swing.JTextField();
        txtTotal2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        tblAditivos = new javax.swing.JScrollPane();
        tblAditivos1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAccessPerf = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblControlAccessDiamantados = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblEnsanTricono = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblInfoTricono = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblInstaCasing = new javax.swing.JTable();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblPerfTipRoca = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTotalt1 = new javax.swing.JTextField();
        txtTotalt2 = new javax.swing.JTextField();
        txtTotalt3 = new javax.swing.JTextField();
        txtGuardar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(927, 1000));

        jLabel17.setText("Personal de Turno");

        jLabel16.setText("Administrador");

        jLabel22.setText("Residente");

        jLabel18.setText("Ayudante 1");

        jLabel15.setText("Perforista");

        jLabel19.setText("Ayudante 2");

        jLabel21.setText("Capataz:");

        jLabel20.setText("Observaciones");

        jLabel14.setText("N° Sondaje");

        jLabel13.setText("Inclinacion");

        jLabel12.setText("Azimut");

        jLabel11.setText("Area de Perforacion");

        jLabel10.setText("Nro de Maquina");

        jLabel7.setText("Constante");

        jLabel9.setText("Cliente");

        jLabel8.setText("Proyecto");

        jLabel6.setText("Prof. Programada");

        jLabel5.setText("Turno");

        jLabel4.setText("Fecha");

        jLabel3.setText("REPORTE DE PERFORACION DIAMANTINA");

        jLabel23.setText("Zona de Perforacion");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblControlAvances.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Profundidad al inicio del turno", null, "mt"},
                {"2", "Profundidad al final del turno", null, "mt"},
                {"3", "Sobrante al final del turno", null, "mt"},
                {"4", "Longitud de tuberia al final del turno", null, "mt"},
                {"5", "Metros perforados", null, "mt"},
                {"6", "Muestra recuperada", null, "mt"},
                {"7", "Nro de corridas", null, "mt"},
                {"8", "Linea", null, null},
                {"9", "Horometro de maquina al inicio de turno", null, "hrs"},
                {"10", "Horometro de maquina al final de turno", null, "hrs"},
                {"11", "Consumo de petroleo en el turno", null, "gls"},
                {"12", "Consumo de agua en el turno", null, "gls"}
            },
            new String [] {
                "Nro", "Control de Avances", "", ""
            }
        ));
        jScrollPane2.setViewportView(tblControlAvances);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Control de Avances", jPanel4);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblDistriTiempo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Perforado con broca", null, null},
                {"2", "Perforado con tricono", null, null},
                {"3", "Inspeccion de equipo - charla", null, null},
                {"4", "Mantenimiento diario", null, null},
                {"5", "Traslado de maquina y accesorios", null, null},
                {"6", "Instalacion de maquina y accesorios", null, null},
                {"7", "Desinstalacion de maquina y accesorios", null, null},
                {"8", "Instalacion y retiro de casing en cambio de linea", null, null},
                {"9", "Esperando repuestos", null, null},
                {"10", "Reparacion de maquina", null, null},
                {"11", "Reperforando (derrumbe)", null, null},
                {"12", "Acondiconamiento de pozo", null, null},
                {"13", "Sacado y bajado de tuberia", null, null},
                {"14", "Medicion de inclinacion", null, null},
                {"15", "Tormenta electrico", null, null},
                {"16", "Cementado, fraguado, perforando cemento", null, null},
                {"17", "Demora por cliente (Stand by)", null, null},
                {"18", "Recuperacion de tuberia (rescate)", null, null},
                {"19", "Refrigerio", null, null}
            },
            new String [] {
                "Nro", "Distribucion de Tiempo", "Hrs Cobr", "Hrs No Cobr"
            }
        ));
        jScrollPane3.setViewportView(tblDistriTiempo);

        jLabel1.setText("TOTAL");

        txtTotal1.setText("0");

        txtTotal2.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60)
                        .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(txtTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jTabbedPane8.addTab("Distribucion de Tiempo", jPanel5);

        tblAditivos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tblAditivos.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblAditivos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAditivos.setViewportView(tblAditivos1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(tblAditivos, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(413, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(tblAditivos, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Aditivos", jPanel6);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblAccessPerf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblAccessPerf);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Accesorios de Perforacion", jPanel2);

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblControlAccessDiamantados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Broca", null, null, null, null, null, null, null},
                {"2", "R. Shell", null, null, null, null, null, null, null},
                {"3", "Zapata (casing sho)", null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Producto", "DIAM", "Marca", "Serie", "Codigo", "Desde", "Hasta", "Acumulado"
            }
        ));
        jScrollPane5.setViewportView(tblControlAccessDiamantados);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Control de Accesorios Diamantados", jPanel3);

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblEnsanTricono.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null}
            },
            new String [] {
                "Diam", "Desde", "Hasta", "Acumulado"
            }
        ));
        jScrollPane6.setViewportView(tblEnsanTricono);

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblInfoTricono.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null}
            },
            new String [] {
                "Diam", "Nro", "Marca", "Observacion"
            }
        ));
        jScrollPane7.setViewportView(tblInfoTricono);

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblInstaCasing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null}
            },
            new String [] {
                "Diam", "Desde", "Hasta", "Acumulado"
            }
        ));
        jScrollPane8.setViewportView(tblInstaCasing);

        jXLabel1.setText("Informacion de Tricono");

        jXLabel2.setText("Ensanchado con Tricono");

        jXLabel3.setText("Instalacion de Casing");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                    .addComponent(jScrollPane8))
                .addContainerGap(227, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(226, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(293, Short.MAX_VALUE)))
        );

        jTabbedPane8.addTab("Infor - Ensanchado -Instalacion", jPanel7);

        tblPerfTipRoca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(2), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(3), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(4), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(5), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(6), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(7), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(8), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(9), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(10), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(11), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(12), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(13), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(14), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(15), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(16), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(17), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(18), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(19), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(20), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(21), null, null, null, null, null, null, null, null, null, null, null},
                { new Integer(22), null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "DESDE", "HASTA", "PERFOR.", "RECUPER.", "% RECUP MUESTRA", "% RECUP. FLUIDO", "COMPACTO", "SEMI-COMPACTO", "FRACTURADO", "MUY FRACTURADO", "VACIOS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblPerfTipRoca);

        jLabel2.setText("Total Testigo");

        txtTotalt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalt3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                .addGap(7, 7, 7))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtTotalt1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalt2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTotalt3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Perforacion - Tipo Roca", jPanel8);

        txtGuardar.setText("Guardar");
        txtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(287, 287, 287))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel18))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtAyudante1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtGuardar))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtPerforista, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtCapataz, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel20))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(jLabel17))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel22)
                                                    .addComponent(jLabel19)
                                                    .addComponent(jLabel16))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtAyudante2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtResidente, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(56, 56, 56)
                                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtConstante, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtProfProgramada, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomProyec, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNroMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel23)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInclinacion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAzimut, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSondaje, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(txtNroMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel9))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProfProgramada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtConstante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(txtNomProyec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSondaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtInclinacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAzimut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtCapataz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtPerforista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAyudante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAyudante2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txtGuardar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtResidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalt3ActionPerformed

    public void opeAccesorios(){
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ope_accesorios(fecha, proyecto, area, zona, maquina, turno, sondaje) VALUES (?,?,?,?,?,?,?)");
            pst.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime()));
            pst.setString(2, txtNomProyec.getText());
            pst.setString(3, txtArea.getText());
            pst.setString(4, txtZona.getText());
            pst.setString(5, txtNroMaquina.getText());
            pst.setString(6, txtTurno.getText());
            pst.setString(7, txtSondaje.getText());
            pst.executeUpdate();
            //buscarpedido("");
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public void opeAvances(){
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ope_avances(fecha, proyecto, area, zona, maquina, turno, sondaje, perforista) VALUES (?,?,?,?,?,?,?,?)");
            pst.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime()));
            pst.setString(2, txtNomProyec.getText());
            pst.setString(3, txtArea.getText());
            pst.setString(4, txtZona.getText());
            pst.setString(5, txtNroMaquina.getText());
            pst.setString(6, txtTurno.getText());
            pst.setString(7, txtSondaje.getText());
            pst.setString(8, txtPerforista.getText());
            pst.executeUpdate();
            //buscarpedido("");
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public void opeConsumoAgua(){
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ope_consumoagua(fecha, proyecto, area, zona, maquina, turno, sondaje) VALUES (?,?,?,?,?,?,?)");
            pst.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime()));
            pst.setString(2, txtNomProyec.getText());
            pst.setString(3, txtArea.getText());
            pst.setString(4, txtZona.getText());
            pst.setString(5, txtNroMaquina.getText());
            pst.setString(6, txtTurno.getText());
            pst.setString(7, txtSondaje.getText());
            pst.executeUpdate();
            //buscarpedido("");
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void opeCorrPerf(){
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ope_corridasperf(fecha, proyecto, area, zona, maquina, turno, sondaje) VALUES (?,?,?,?,?,?,?)");
            pst.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime()));
            pst.setString(2, txtNomProyec.getText());
            pst.setString(3, txtArea.getText());
            pst.setString(4, txtZona.getText());
            pst.setString(5, txtNroMaquina.getText());            
            pst.setString(6, txtTurno.getText());
            pst.setString(7, txtSondaje.getText());
            pst.executeUpdate();
            //buscarpedido("");
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void opeHerramientas(){
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ope_herramientas(fecha, proyecto, turno, sondaje, perforista) VALUES (?,?,?,?,?)");
            pst.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime()));
            pst.setString(2, txtNomProyec.getText());
            pst.setString(3, txtTurno.getText());
            pst.setString(4, txtSondaje.getText());
            pst.setString(5, txtPerforista.getText());
            pst.executeUpdate();
            //buscarpedido("");
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void opeValorizaciones(){
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ope_herramientas(maquina,sondaje) VALUES (?,?)");
            //pst.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime()));
            pst.setString(1, txtNroMaquina.getText());
            pst.setString(2, txtSondaje.getText());
            pst.executeUpdate();
            //buscarpedido("");
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void opeTiempos(){
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ope_tiempos(fecha, proyecto, area, zona, turno, sondaje) VALUES (?,?,?,?,?,?)");
            pst.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime()));
            pst.setString(2, txtNomProyec.getText());
            pst.setString(3, txtArea.getText());
            pst.setString(4, txtZona.getText());
            pst.setString(5, txtTurno.getText());
            pst.setString(6, txtSondaje.getText());
            pst.executeUpdate();
            //buscarpedido("");
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void opeFluidos(){
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ope_fluidos(fecha, proyecto, area, zona, turno, sondaje) VALUES (?,?,?,?,?,?)");
            pst.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime()));
            pst.setString(2, txtNomProyec.getText());
            pst.setString(3, txtArea.getText());
            pst.setString(4, txtZona.getText());
            pst.setString(5, txtTurno.getText());
            pst.setString(6, txtSondaje.getText());
            pst.executeUpdate();
            //buscarpedido("");
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void opeCombustibles(){
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO ope_combustibles(fecha) VALUES (?)");
            pst.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime()));
            /*pst.setString(2, txtNomProyec.getText());
            pst.setString(3, txtArea.getText());
            pst.setString(4, txtZona.getText());
            pst.setString(5, txtNroMaquina.getText());
            pst.setString(6, txtTurno.getText());
            pst.setString(7, txtSondaje.getText());*/
            pst.executeUpdate();
            //buscarpedido("");
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
    
    private void txtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuardarActionPerformed
        // TODO add your handling code here:
          
        try {
            PreparedStatement pst = cn.prepareStatement("");
            opeAccesorios();
            opeCombustibles();
            opeFluidos();
            opeTiempos();
            opeHerramientas();
            opeCorrPerf();
            opeConsumoAgua();
            opeAvances();
            opeValorizaciones();
            JOptionPane.showMessageDialog(null, "Registro Guardado con exito");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_txtGuardarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        llenarTablaAcces.llenar_tabla_Accesorios(3, 1, modeloAcces, tblAccessPerf);
        llenarTablaAditi.llenar_tabla_Aditivos(4, 1, modeloAdit, tblAditivos1);
        //llenarTablaAvan.llenar_tabla_Avances(3, SOMEBITS, model, tblAditivos1);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Report().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane8;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private javax.swing.JTable tblAccessPerf;
    private javax.swing.JScrollPane tblAditivos;
    private javax.swing.JTable tblAditivos1;
    private javax.swing.JTable tblControlAccessDiamantados;
    private javax.swing.JTable tblControlAvances;
    private javax.swing.JTable tblDistriTiempo;
    private javax.swing.JTable tblEnsanTricono;
    private javax.swing.JTable tblInfoTricono;
    private javax.swing.JTable tblInstaCasing;
    private javax.swing.JTable tblPerfTipRoca;
    private javax.swing.JTextField txtAdministrador;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtAyudante1;
    private javax.swing.JTextField txtAyudante2;
    private javax.swing.JTextField txtAzimut;
    private javax.swing.JTextField txtCapataz;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtConstante;
    private javax.swing.JButton txtGuardar;
    private javax.swing.JTextField txtInclinacion;
    private javax.swing.JTextField txtNomProyec;
    private javax.swing.JTextField txtNroMaquina;
    private java.awt.TextArea txtObservaciones;
    private javax.swing.JTextField txtPerforista;
    private javax.swing.JTextField txtProfProgramada;
    private javax.swing.JTextField txtResidente;
    private javax.swing.JTextField txtSondaje;
    private javax.swing.JTextField txtTotal1;
    private javax.swing.JTextField txtTotal2;
    private javax.swing.JTextField txtTotalt1;
    private javax.swing.JTextField txtTotalt2;
    private javax.swing.JTextField txtTotalt3;
    private javax.swing.JTextField txtTurno;
    private javax.swing.JTextField txtZona;
    // End of variables declaration//GEN-END:variables
}
