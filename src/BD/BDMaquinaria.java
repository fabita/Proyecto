/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pro_min.BDConexion;

/**
 *
 * @author Usuario
 */
public class BDMaquinaria extends javax.swing.JFrame {

    /**
     * Creates new form BDMaquinaria
     */
    DefaultTableModel model;
    BDConexion bd = new BDConexion();
    Connection cn = bd.conexion();
    Statement sent;
    
    
    public BDMaquinaria() {
        initComponents();
    limpiar();
        bloquear();
        cargarMaquinaria("");
        mostrarMaquinaria();
    }

    void cargarMaquinaria(String valor){
        
        String []titulos={"id","Modelo","Num. Maquina","Marca","Fabricante","Año Fabricacion", "HP Motor", "RPM Motor","Capacidad PQ","Capacidad HQ","Capacidad NQ","Capacidad BQ","Montado Sobre", "Peso Maquina","Largo Maquina", "Ancho Maquina","Altura Maquina"};  
        String []Registros= new String[17];
        
        String sql="SELECT * FROM maquinaria WHERE CONCAT(id, modelo, num_maquina, marca, fabricante, año_fabricacion, hp_motor, rpm_motor, capacidad_pq, capacidad_hq, capacidad_nq, capacidad_bq, montado_sobre, peso_maquina, largo_maquina, ancho_maquina, altura_maquina) LIKE '%"+valor+"%'";
        model=new DefaultTableModel(null,titulos);
        
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next())
             {
                   Registros[0]= rs.getString("id");
                   Registros[1]= rs.getString("modelo");
                   Registros[2]= rs.getString("num_maquina");
                   Registros[3]= rs.getString("marca");
                   Registros[4]= rs.getString("fabricante");
                   Registros[5]= rs.getString("año_fabricacion");
                   Registros[6]= rs.getString("hp_motor");
                   Registros[7]= rs.getString("rpm_motor");
                   Registros[8]= rs.getString("capacidad_pq");
                   Registros[9]= rs.getString("capacidad_hq");
                   Registros[10]= rs.getString("capacidad_nq");
                   Registros[11]= rs.getString("capacidad_bq");
                   Registros[12]= rs.getString("montado_sobre");
                   Registros[13]= rs.getString("peso_maquina");
                   Registros[14]= rs.getString("largo_maquina");
                   Registros[15]= rs.getString("ancho_maquina");
                   Registros[16]= rs.getString("altura_maquina");
                   
                   model.addRow(Registros);
             } 
             t_datos.setModel(model);
        } catch (SQLException ex) {
             Logger.getLogger(BDMaquinaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void mostrarMaquinaria(){
        
        String []titulos={"id","Modelo","Num. Maquina","Marca","Fabricante","Año Fabricacion", "HP Motor", "RPM Motor","Capacidad PQ","Capacidad HQ","Capacidad NQ","Capacidad BQ","Montado Sobre", "Peso Maquina","Largo Maquina", "Ancho Maquina","Altura Maquina"};  
        String []Registros= new String[17];
        
        String sql="SELECT * FROM maquinaria";
        model=new DefaultTableModel(null,titulos);
        
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next())
             {
                   Registros[0]= rs.getString("id");
                   Registros[1]= rs.getString("modelo");
                   Registros[2]= rs.getString("num_maquina");
                   Registros[3]= rs.getString("marca");
                   Registros[4]= rs.getString("fabricante");
                   Registros[5]= rs.getString("año_fabricacion");
                   Registros[6]= rs.getString("hp_motor");
                   Registros[7]= rs.getString("rpm_motor");
                   Registros[8]= rs.getString("capacidad_pq");
                   Registros[9]= rs.getString("capacidad_hq");
                   Registros[10]= rs.getString("capacidad_nq");
                   Registros[11]= rs.getString("capacidad_bq");
                   Registros[12]= rs.getString("montado_sobre");
                   Registros[13]= rs.getString("peso_maquina");
                   Registros[14]= rs.getString("largo_maquina");
                   Registros[15]= rs.getString("ancho_maquina");
                   Registros[16]= rs.getString("altura_maquina");
                   model.addRow(Registros);
             } 
             t_datos.setModel(model);
        } catch (SQLException ex) {
             Logger.getLogger(BDMaquinaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void limpiar(){
    txtModelo.setText ("");
    txtNum_Maquina.setText ("");
    txtMarca.setText ("");
    txtFabricante.setText ("");
    cAñoFabri.setYear(2014);
    txtHp_Motor.setText ("");
    txtRpm_Motor.setText ("");
    txtCapacidadPq.setText ("");
    txtCapacidadHq.setText ("");
    txtCapacidadNq.setText ("");
    txtCapacidadBq.setText ("");
    txtMontado_Sobre.setText ("");
    txtPeso_Maquina.setText ("");
    txtLargo_Maquina.setText ("");
    txtAncho_Maquina.setText ("");
    txtAltura_Maquina.setText ("");
    }
    
    void bloquear(){    
    
    txtModelo.setEnabled(false);
    txtNum_Maquina.setEnabled(false);
    txtMarca.setEnabled(false);
    txtFabricante.setEnabled(false);
    cAñoFabri.setEnabled(false);
    txtHp_Motor.setEnabled(false);
    txtRpm_Motor.setEnabled(false);
    txtCapacidadPq.setEnabled(false);
    txtCapacidadHq.setEnabled(false);
    txtCapacidadNq.setEnabled(false);
    txtCapacidadBq.setEnabled(false);
    txtMontado_Sobre.setEnabled(false);
    txtPeso_Maquina.setEnabled(false);
    txtLargo_Maquina.setEnabled(false);
    txtAncho_Maquina.setEnabled(false);
    txtAltura_Maquina.setEnabled(false);
    
    btnNuevo.setEnabled(true);
    btnGuardar.setEnabled(false);
    
    }
    
    void desbloquear(){
        
    txtModelo.setEnabled(true);
    txtNum_Maquina.setEnabled(true);
    txtMarca.setEnabled(true);
    txtFabricante.setEnabled(true);
    cAñoFabri.setEnabled(true);
    txtHp_Motor.setEnabled(true);
    txtRpm_Motor.setEnabled(true);
    txtCapacidadPq.setEnabled(true);
    txtCapacidadHq.setEnabled(true);
    txtCapacidadNq.setEnabled(true);
    txtCapacidadBq.setEnabled(true);
    txtMontado_Sobre.setEnabled(true);
    txtPeso_Maquina.setEnabled(true);
    txtLargo_Maquina.setEnabled(true);
    txtAncho_Maquina.setEnabled(true);
    txtAltura_Maquina.setEnabled(true);
    
    btnNuevo.setEnabled(false);
    btnGuardar.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCapacidadHq = new javax.swing.JTextField();
        txtRpm_Motor = new javax.swing.JTextField();
        txtBusqueda = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNum_Maquina = new javax.swing.JTextField();
        txtPeso_Maquina = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtFabricante = new javax.swing.JTextField();
        txtLargo_Maquina = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHp_Motor = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtAltura_Maquina = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        txtAncho_Maquina = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtCapacidadBq = new javax.swing.JTextField();
        txtMontado_Sobre = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtCapacidadPq = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCapacidadNq = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cAñoFabri = new com.toedter.calendar.JYearChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel11.setText("Capacidad HQ :");

        jLabel10.setText("Capacidad NQ :");

        txtCapacidadHq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacidadHqActionPerformed(evt);
            }
        });

        txtRpm_Motor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRpm_MotorActionPerformed(evt);
            }
        });

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        btnMostrar.setText("Mostrar Aditivos");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jLabel5.setText("Marca :");

        txtNum_Maquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNum_MaquinaActionPerformed(evt);
            }
        });

        txtPeso_Maquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeso_MaquinaActionPerformed(evt);
            }
        });

        jLabel7.setText("Buscar :");

        jLabel13.setText("Peso de Maquina (TN)");

        txtFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFabricanteActionPerformed(evt);
            }
        });

        txtLargo_Maquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLargo_MaquinaActionPerformed(evt);
            }
        });

        jLabel8.setText("HP de Motor :");

        jLabel12.setText("Largo de Maquina (MT)");

        jLabel6.setText("Fabricante :");

        jLabel1.setText("Base de Datos Maquinaria");

        jLabel9.setText("RPM Motor");

        jLabel2.setText("Modelo :");

        txtHp_Motor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHp_MotorActionPerformed(evt);
            }
        });

        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        txtAltura_Maquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAltura_MaquinaActionPerformed(evt);
            }
        });

        jLabel4.setText("Año de Fabricacion :");

        jLabel18.setText("Altura de Maquina (MT)");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        t_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_datos.getTableHeader().setReorderingAllowed(false);
        t_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_datos);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtAncho_Maquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAncho_MaquinaActionPerformed(evt);
            }
        });

        jLabel17.setText("Ancho de Maquina (MT)");

        txtCapacidadBq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacidadBqActionPerformed(evt);
            }
        });

        txtMontado_Sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontado_SobreActionPerformed(evt);
            }
        });

        jLabel16.setText("Montado Sobre :");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel3.setText("Num Maquina :");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtCapacidadPq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacidadPqActionPerformed(evt);
            }
        });

        jLabel14.setText("Capacidad BQ :");

        txtCapacidadNq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacidadNqActionPerformed(evt);
            }
        });

        jLabel15.setText("Capacidad PQ :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addGap(48, 48, 48)
                                .addComponent(btnGuardar)
                                .addGap(43, 43, 43)
                                .addComponent(btnModificar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnEliminar))
                            .addComponent(btnMostrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 136, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCapacidadHq, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(txtCapacidadPq, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(txtCapacidadNq, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(txtNum_Maquina)
                                .addComponent(txtModelo)
                                .addComponent(txtMarca)
                                .addComponent(txtFabricante)
                                .addComponent(txtHp_Motor, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(txtRpm_Motor))
                            .addComponent(cAñoFabri, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPeso_Maquina, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLargo_Maquina, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAncho_Maquina, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAltura_Maquina, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCapacidadBq, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMontado_Sobre, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14)
                    .addComponent(txtCapacidadBq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNum_Maquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel17))
                            .addComponent(cAñoFabri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHp_Motor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRpm_Motor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCapacidadPq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCapacidadHq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCapacidadNq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtMontado_Sobre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPeso_Maquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLargo_Maquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAncho_Maquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAltura_Maquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrar)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCapacidadHqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacidadHqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacidadHqActionPerformed

    private void txtRpm_MotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRpm_MotorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRpm_MotorActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
        cargarMaquinaria(txtBusqueda.getText());

   }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        // TODO add your handling code here:
        cargarMaquinaria(txtBusqueda.getText());
   }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        mostrarMaquinaria();

   }//GEN-LAST:event_btnMostrarActionPerformed

    private void txtNum_MaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNum_MaquinaActionPerformed
        // TODO add your handling code here:
        txtNum_Maquina.transferFocus();
    }//GEN-LAST:event_txtNum_MaquinaActionPerformed

    private void txtPeso_MaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeso_MaquinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPeso_MaquinaActionPerformed

    private void txtFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFabricanteActionPerformed
        // TODO add your handling code here:
        txtFabricante.transferFocus();
    }//GEN-LAST:event_txtFabricanteActionPerformed

    private void txtLargo_MaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLargo_MaquinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLargo_MaquinaActionPerformed

    private void txtHp_MotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHp_MotorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHp_MotorActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
        txtModelo.transferFocus();
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
        txtMarca.transferFocus();
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtAltura_MaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAltura_MaquinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAltura_MaquinaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:

        if (evt.getButton() == 1) {
            int fila = t_datos.getSelectedRow();
            try {
                desbloquear();
                String sql = "select * from maquinaria where id=" + t_datos.getValueAt(fila, 0);
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                txtModelo.setText(rs.getString("modelo"));
                txtNum_Maquina.setText(rs.getString("num_maquina"));
                txtMarca.setText(rs.getString("marca"));
                txtFabricante.setText(rs.getString("fabricante"));
                cAñoFabri.setYear(rs.getInt("año_fabricacion"));
                txtHp_Motor.setText(rs.getString("hp_motor"));
                txtRpm_Motor.setText(rs.getString("rpm_motor"));
                txtCapacidadPq.setText(rs.getString("capacidad_pq"));
                txtCapacidadHq.setText(rs.getString("capacidad_hq"));
                txtCapacidadNq.setText(rs.getString("capacidad_nq"));
                txtCapacidadBq.setText(rs.getString("capacidad_bq"));
                txtMontado_Sobre.setText(rs.getString("montado_sobre"));
                txtPeso_Maquina.setText(rs.getString("peso_maquina"));
                txtLargo_Maquina.setText(rs.getString("largo_maquina"));
                txtAncho_Maquina.setText(rs.getString("ancho_maquina"));
                txtAltura_Maquina.setText(rs.getString("altura_maquina"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_t_datosMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try { 
              desbloquear(); 
              String sql = "Update maquinaria set modelo=?, num_maquina=?, marca=?, fabricante=?, año_fabricacion=?, hp_motor=?, rpm_motor=?, capacidad_pq=?, capacidad_hq=?, capacidad_nq=?, capacidad_bq=?, montado_sobre=?, peso_maquina=?, largo_maquina=?, ancho_maquina=?, altura_maquina=?" + "where id=?";
              int fila = t_datos.getSelectedRow(); 
              String dao = (String) t_datos.getValueAt(fila, 0); 
              PreparedStatement ps = cn.prepareStatement(sql); 
              ps.setString(1, txtModelo.getText());
              ps.setString(2, txtNum_Maquina.getText()); 
              ps.setString(3, txtMarca.getText()); 
              ps.setString(4, txtFabricante.getText());
              ps.setInt(5, cAñoFabri.getYear()); 
              ps.setString(6, txtHp_Motor.getText());
              ps.setString(7, txtRpm_Motor.getText());
              ps.setString(8, txtCapacidadPq.getText());
              ps.setString(9, txtCapacidadHq.getText());
              ps.setString(10, txtCapacidadNq.getText());
              ps.setString(11, txtCapacidadBq.getText());
              ps.setString(12, txtMontado_Sobre.getText());
              ps.setString(13, txtPeso_Maquina.getText());
              ps.setString(14, txtLargo_Maquina.getText());
              ps.setString(15, txtAncho_Maquina.getText());
              ps.setString(16, txtAltura_Maquina.getText());
                           
              ps.setString(17, dao);
         
              int n = ps.executeUpdate();
              if (n > 0) { 
                  limpiar();
                  mostrarMaquinaria(); 
                  JOptionPane.showMessageDialog(null, "Datos Modificados");
                  bloquear(); 
              }
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
          }

   }//GEN-LAST:event_btnModificarActionPerformed

    private void txtAncho_MaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAncho_MaquinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAncho_MaquinaActionPerformed

    private void txtCapacidadBqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacidadBqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacidadBqActionPerformed

    private void txtMontado_SobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontado_SobreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontado_SobreActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        desbloquear();
   }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try { 
              int fila = t_datos.getSelectedRow();
          
          String sql = "delete from maquinaria where id=" + t_datos.getValueAt(fila, 0); 
          sent = cn.createStatement(); int n = sent.executeUpdate(sql); 
          if (n > 0) {
              mostrarMaquinaria(); 
              JOptionPane.showMessageDialog(null, "Datos Eliminados"); 
          }
    } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }    

   }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

          String modelo, num_maquina, marca, fabricante, hp_motor, rpm_motor, capacidad_pq, capacidad_hq, capacidad_nq, capacidad_bq, montado_sobre, peso_maquina, largo_maquina, ancho_maquina, altura_maquina;
          int año_fabricacion;
          String sql = "";
          //producto = txtProducto.getText(); 
         
          modelo = txtModelo.getText();
          num_maquina = txtNum_Maquina.getText(); 
          marca = txtMarca.getText(); 
          fabricante = txtFabricante.getText();
          año_fabricacion = cAñoFabri.getYear();
          hp_motor = txtHp_Motor.getText();
          rpm_motor = txtRpm_Motor.getText();
          capacidad_pq = txtCapacidadPq.getText();
          capacidad_hq = txtCapacidadHq.getText();
          capacidad_nq = txtCapacidadNq.getText();
          capacidad_bq = txtCapacidadBq.getText();
          montado_sobre = txtMontado_Sobre.getText();
          peso_maquina = txtPeso_Maquina.getText();
          largo_maquina = txtLargo_Maquina.getText();
          ancho_maquina = txtAncho_Maquina.getText();
          altura_maquina = txtAltura_Maquina.getText();
          
          sql = "INSERT INTO maquinaria (modelo, num_maquina, marca, fabricante, año_fabricacion, hp_motor,rpm_motor, capacidad_pq, capacidad_hq, capacidad_nq, capacidad_bq, montado_sobre, peso_maquina, largo_maquina, ancho_maquina, altura_maquina) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
          try { 
              PreparedStatement pst = cn.prepareStatement(sql); 
              pst.setString(1, modelo);
              pst.setString(2, num_maquina); 
              pst.setString(3, marca);
              pst.setString(4, fabricante); 
              pst.setInt(5, año_fabricacion);
              pst.setString(6, hp_motor);
              pst.setString(7, rpm_motor);
              pst.setString(8, capacidad_pq);
              pst.setString(9, capacidad_hq);
              pst.setString(10, capacidad_nq);
              pst.setString(11, capacidad_bq);
              pst.setString(12, montado_sobre);
              pst.setString(13, peso_maquina);
              pst.setString(14, largo_maquina);
              pst.setString(15, ancho_maquina);
              pst.setString(16, altura_maquina);
              
              int n = pst.executeUpdate(); 
              if (n > 0) {
                  JOptionPane.showMessageDialog(null, "Registro Guardado con exito");
                  bloquear(); 
                  btnNuevo.setEnabled(true); 
                  btnGuardar.setEnabled(false);
                  cargarMaquinaria("");
                  limpiar();
         
          }
          } catch (SQLException ex) { System.out.print(ex.getMessage());
        }
}//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCapacidadPqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacidadPqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacidadPqActionPerformed

    private void txtCapacidadNqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacidadNqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacidadNqActionPerformed

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
            java.util.logging.Logger.getLogger(BDMaquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BDMaquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BDMaquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BDMaquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BDMaquinaria().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevo;
    private com.toedter.calendar.JYearChooser cAñoFabri;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField txtAltura_Maquina;
    private javax.swing.JTextField txtAncho_Maquina;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCapacidadBq;
    private javax.swing.JTextField txtCapacidadHq;
    private javax.swing.JTextField txtCapacidadNq;
    private javax.swing.JTextField txtCapacidadPq;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtHp_Motor;
    private javax.swing.JTextField txtLargo_Maquina;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMontado_Sobre;
    private javax.swing.JTextField txtNum_Maquina;
    private javax.swing.JTextField txtPeso_Maquina;
    private javax.swing.JTextField txtRpm_Motor;
    // End of variables declaration//GEN-END:variables
}
