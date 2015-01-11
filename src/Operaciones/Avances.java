/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pro_min.BDConexion;
/**
 *
 * @author Home
 */
public class Avances extends javax.swing.JFrame {

        /**
         * Creates new form Avances
        */
       DefaultTableModel model;
       BDConexion bd = new BDConexion();
       Connection cn = bd.conexion();
       Statement sent;
       
        public Avances() {
        initComponents();
        setLocationRelativeTo(null);
        limpiar();
        bloquear();
        cargarAvances("");
        mostrarAvances();
        }
    
    
        void cargarAvances(String valor){
        
            String []titulos={"Id", "Fecha", "Proyecto", "Zona", "Maquina", "Turno","Sondaje", "Diametro", "Perforista", 
                "Perf Broca", "Perf Tricono", "Avance Total", "Recuperacion", "Pre-Collar", "Profundidad","Casing", "H-Perf" ,"Estado"};  
            String []Registros= new String[18];
        
            String sql="SELECT * FROM ope_avances WHERE CONCAT(id, fecha, proyecto, zona, maquina, turno,sondaje,"
                    + "diametro, perforista, perfBroca, perfTricono, avanceTotal, recuperacion, preCollar, profundidad, casing, estado ) LIKE '%"+valor+"%'";
            model=new DefaultTableModel(null,titulos);

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    Registros[0]= rs.getString("id");
                    Registros[1]= rs.getString("fecha");
                    Registros[2]= rs.getString("proyecto");
                    Registros[3]= rs.getString("zona");
                    Registros[4]= rs.getString("maquina");
                    Registros[5]= rs.getString("turno");
                    Registros[6]= rs.getString("sondaje");
                    Registros[7]= rs.getString("diametro");
                    Registros[8]= rs.getString("perforista");
                    Registros[9]= rs.getString("perfBroca");
                    Registros[10]= rs.getString("perfTricono");
                    Registros[11]= rs.getString("avanceTotal");
                    Registros[12]= rs.getString("recuperacion");
                    Registros[13]= rs.getString("preCollar");
                    Registros[14]= rs.getString("profundidad");
                    Registros[15]= rs.getString("casing");
                    Registros[16]= rs.getString("hPerf");
                    Registros[17]= rs.getString("estado");
                    model.addRow(Registros);
                } 
                t_datos.setModel(model);
            } catch (SQLException ex) {
                Logger.getLogger(Avances.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    void mostrarAvances(){
        
        String []titulos={"Id", "Fecha", "Proyecto", "Zona", "Maquina", "Turno","Sondaje", "Diametro", "Perforista", 
                "Perf Broca", "Perf Tricono", "Avance Total", "Recuperacion", "Pre-Collar", "Profundidad","Casing", "H-Perf" ,"Estado"};  
        String []Registros= new String[18];
        
        String sql="SELECT * FROM ope_avances";
        model=new DefaultTableModel(null,titulos);
        
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next())
             {
                   Registros[0]= rs.getString("id");
                   Registros[1]= rs.getString("fecha");
                   Registros[2]= rs.getString("proyecto");
                   Registros[3]= rs.getString("zona");
                   Registros[4]= rs.getString("maquina");
                   Registros[5]= rs.getString("turno");
                   Registros[6]= rs.getString("sondaje");
                   Registros[7]= rs.getString("diametro");
                   Registros[8]= rs.getString("perforista");
                   Registros[9]= rs.getString("perfBroca");
                   Registros[10]= rs.getString("perfTricono");
                   Registros[11]= rs.getString("avanceTotal");
                   Registros[12]= rs.getString("recuperacion");
                   Registros[13]= rs.getString("preCollar");
                   Registros[14]= rs.getString("profundidad");
                   Registros[15]= rs.getString("casing");
                   Registros[16]= rs.getString("hPerf");
                   Registros[17]= rs.getString("estado");
                   
                   model.addRow(Registros);
             } 
             t_datos.setModel(model);
        } catch (SQLException ex) {
             Logger.getLogger(Avances.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        void limpiar(){
        txtFecha.setText ("");
        txtProyecto.setText ("");
        txtZona.setText ("");
        txtMaquina.setText ("");
        txtTurno.setText ("");
        txtSondaje.setText ("");
        txtDiametro.setText ("");
        txtPerforista.setText ("");
        txtPerf_Broca.setText ("");
        txtPerf_Tricono.setText ("");
        txtAvance_Total.setText ("");
        txtRecuperacion.setText ("");
        txtPre_Collar.setText ("");
        txtProfundidad.setText ("");
        txtCasing.setText ("");
        txtH_Perf.setText ("");
        txtEstado.setText ("");
        }

        void bloquear(){
        txtFecha.setEnabled(false);
        txtProyecto.setEnabled(false);
        txtZona.setEnabled(false);
        txtMaquina.setEnabled(false);
        txtTurno.setEnabled(false);
        txtSondaje.setEnabled(false);
        txtDiametro.setEnabled(false);
        txtPerforista.setEnabled(false);
        txtPerf_Broca.setEnabled(false);
        txtPerf_Tricono.setEnabled(false);
        txtAvance_Total.setEnabled(false);
        txtRecuperacion.setEnabled(false);
        txtPre_Collar.setEnabled(false);
        txtProfundidad.setEnabled(false);
        txtCasing.setEnabled(false);
        txtH_Perf.setEnabled(false);
        txtEstado.setEnabled(false);
        }

        void desbloquear(){
        txtFecha.setEnabled(true);
        txtProyecto.setEnabled(true);
        txtZona.setEnabled(true);
        txtMaquina.setEnabled(true);
        txtTurno.setEnabled(true);
        txtSondaje.setEnabled(true);
        txtDiametro.setEnabled(true);
        txtPerforista.setEnabled(true);
        txtPerf_Broca.setEnabled(true);
        txtPerf_Tricono.setEnabled(true);
        txtAvance_Total.setEnabled(true);
        txtRecuperacion.setEnabled(true);
        txtPre_Collar.setEnabled(true);
        txtProfundidad.setEnabled(true);
        txtCasing.setEnabled(true);
        txtH_Perf.setEnabled(true);
        txtEstado.setEnabled(true);
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtProyecto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtZona = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaquina = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTurno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSondaje = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDiametro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPerforista = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPerf_Broca = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPerf_Tricono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAvance_Total = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtRecuperacion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPre_Collar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtProfundidad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCasing = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtH_Perf = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtPerforista1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtPerforista2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtPerforista3 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtPerforista4 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtPerforista5 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtEstado1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtZona1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Fecha :");

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        txtProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProyectoActionPerformed(evt);
            }
        });

        jLabel2.setText("Proyecto :");

        txtZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZonaActionPerformed(evt);
            }
        });

        jLabel3.setText("Zona :");

        txtMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaquinaActionPerformed(evt);
            }
        });

        jLabel4.setText("Maquina :");

        txtTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTurnoActionPerformed(evt);
            }
        });

        jLabel5.setText("Turno :");

        txtSondaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSondajeActionPerformed(evt);
            }
        });

        jLabel6.setText("Sondaje :");

        txtDiametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiametroActionPerformed(evt);
            }
        });

        jLabel7.setText("Diametro :");

        txtPerforista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerforistaActionPerformed(evt);
            }
        });

        jLabel8.setText("Perforista :");

        txtPerf_Broca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerf_BrocaActionPerformed(evt);
            }
        });

        jLabel9.setText("Perforado con Broca : ");

        txtPerf_Tricono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerf_TriconoActionPerformed(evt);
            }
        });

        jLabel10.setText("Perforado con Tricono :");

        txtAvance_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvance_TotalActionPerformed(evt);
            }
        });

        jLabel11.setText("Avance Total :");

        txtRecuperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecuperacionActionPerformed(evt);
            }
        });

        jLabel12.setText("Recuperacion :");

        txtPre_Collar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPre_CollarActionPerformed(evt);
            }
        });

        jLabel13.setText("Pre - Collar :");

        txtProfundidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfundidadActionPerformed(evt);
            }
        });

        jLabel14.setText("Profundidad :");

        txtCasing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCasingActionPerformed(evt);
            }
        });

        jLabel15.setText("Casing :");

        txtH_Perf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtH_PerfActionPerformed(evt);
            }
        });

        jLabel16.setText("H. Perf.");

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        jLabel17.setText("Estado :");

        jLabel18.setText("Avances");

        jLabel19.setText("Buscar por fecha :");

        btnMostrar.setText("Mostrar Avances");
        btnMostrar.setActionCommand("");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
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

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel20.setText("Capataz :");

        txtPerforista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerforista1ActionPerformed(evt);
            }
        });

        jLabel21.setText("Ayudante 1 :");

        txtPerforista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerforista2ActionPerformed(evt);
            }
        });

        jLabel22.setText("Ayudante 2 :");

        txtPerforista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerforista3ActionPerformed(evt);
            }
        });

        jLabel23.setText("Residente :");

        txtPerforista4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerforista4ActionPerformed(evt);
            }
        });

        jLabel24.setText("Administrador :");

        txtPerforista5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerforista5ActionPerformed(evt);
            }
        });

        jLabel25.setText("Observaciones :");

        txtEstado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstado1ActionPerformed(evt);
            }
        });

        jLabel26.setText("Area :");

        txtZona1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZona1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel20)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnModificar)
                                        .addComponent(jLabel19))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnMostrar))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(146, 146, 146)
                                                    .addComponent(btnEliminar))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(247, 247, 247)
                                                    .addComponent(jLabel18)))
                                            .addGap(261, 261, 261))))
                                .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel8))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPerforista3)
                                    .addComponent(txtPerforista2)
                                    .addComponent(txtMaquina)
                                    .addComponent(txtFecha)
                                    .addComponent(txtProyecto)
                                    .addComponent(txtZona)
                                    .addComponent(txtTurno)
                                    .addComponent(txtSondaje)
                                    .addComponent(txtDiametro)
                                    .addComponent(txtPerforista)
                                    .addComponent(txtPerforista1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(jLabel23))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addComponent(jLabel9))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(122, 122, 122)
                                        .addComponent(txtZona1)))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel11))
                                        .addGap(75, 75, 75)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPerf_Tricono, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAvance_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPerf_Broca, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPerforista5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPerforista4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel17))
                                        .addGap(76, 76, 76)
                                        .addComponent(txtRecuperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(90, 90, 90)
                                            .addComponent(txtPre_Collar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(85, 85, 85)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtCasing, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtProfundidad, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtH_Perf, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel25)))))
                    .addComponent(jLabel6))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel18)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPerforista4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel23)
                                            .addComponent(txtPerforista5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel22))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPerf_Broca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(txtPerf_Tricono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtAvance_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtRecuperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(txtPre_Collar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtProfundidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCasing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtH_Perf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel13)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel14)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel16)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel17))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(txtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSondaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPerforista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPerforista1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPerforista2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPerforista3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel26))
                        .addComponent(txtZona1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(btnMostrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
         mostrarAvances();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
         try {
            int fila = t_datos.getSelectedRow();
            String sql = "delete from ope_avances where id=" + t_datos.getValueAt(fila, 0);
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n > 0) {
                mostrarAvances();
                JOptionPane.showMessageDialog(null, "Datos Eliminados");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
         try {
            desbloquear();
            String sql = "Update ope_avances set fecha=?, proyecto=?, zona=?, maquina=?, turno=?, sondaje=?, "
                    + "diametro=?, perforista=?,perfBroca=?, perfTricono=?, avanceTotal=?, recuperacion=?, preCollar=?, profundidad=?, "
                    + "casing=?, hPerf=?, estado=?" + "where id=?";
            int fila = t_datos.getSelectedRow();
            String dao = (String) t_datos.getValueAt(fila, 0);
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, txtFecha.getText());
            ps.setString(2, txtProyecto.getText());
            ps.setString(3, txtZona.getText());
            ps.setString(4, txtMaquina.getText());
            ps.setString(5, txtTurno.getText());
            ps.setString(6, txtSondaje.getText());
            ps.setString(7, txtDiametro.getText());
            ps.setString(8, txtPerforista.getText());
            ps.setString(9, txtPerf_Broca.getText());
            ps.setString(10, txtPerf_Tricono.getText());
            ps.setString(11, txtAvance_Total.getText());
            ps.setString(12, txtRecuperacion.getText());
            ps.setString(13, txtPre_Collar.getText());
            ps.setString(14, txtProfundidad.getText());
            ps.setString(15, txtCasing.getText());
            ps.setString(16, txtH_Perf.getText());
            ps.setString(17, txtEstado.getText());
            ps.setString(18, dao);

            int n = ps.executeUpdate();
            if (n > 0) {
                limpiar();
                mostrarAvances();
                JOptionPane.showMessageDialog(null, "Datos Modificados");
                bloquear();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
          if (evt.getButton() == 1) {
            int fila = t_datos.getSelectedRow();
            try {
                desbloquear();
                String sql = "select * from ope_avances where id=" + t_datos.getValueAt(fila, 0);
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                txtFecha.setText(rs.getString("fecha"));
                txtProyecto.setText(rs.getString("proyecto"));
                txtZona.setText(rs.getString("zona"));
                txtMaquina.setText(rs.getString("maquina"));
                txtTurno.setText(rs.getString("turno"));
                txtSondaje.setText(rs.getString("sondaje"));
                txtDiametro.setText(rs.getString("diametro"));
                txtPerforista.setText(rs.getString("perforista"));
                txtPerf_Broca.setText(rs.getString("perfBroca"));
                txtPerf_Tricono.setText(rs.getString("perfTricono"));
                txtAvance_Total.setText(rs.getString("avanceTotal"));
                txtRecuperacion.setText(rs.getString("recuperacion"));
                txtPre_Collar.setText(rs.getString("preCollar"));
                txtProfundidad.setText(rs.getString("profundidad"));
                txtCasing.setText(rs.getString("casing"));
                txtH_Perf.setText(rs.getString("hPerf"));
                txtEstado.setText(rs.getString("estado"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_t_datosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        // TODO add your handling code here:
         cargarAvances(txtBusqueda.getText());
   }//GEN-LAST:event_txtBusquedaKeyReleased

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
         cargarAvances(txtBusqueda.getText());
   }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
        txtFecha.transferFocus();
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProyectoActionPerformed
        // TODO add your handling code here:
        txtProyecto.transferFocus();
    }//GEN-LAST:event_txtProyectoActionPerformed

    private void txtZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZonaActionPerformed
        // TODO add your handling code here:
        txtZona.transferFocus();
    }//GEN-LAST:event_txtZonaActionPerformed

    private void txtMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaquinaActionPerformed
        // TODO add your handling code here:
        txtMaquina.transferFocus();
    }//GEN-LAST:event_txtMaquinaActionPerformed

    private void txtTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTurnoActionPerformed
        // TODO add your handling code here:
        txtTurno.transferFocus();
    }//GEN-LAST:event_txtTurnoActionPerformed

    private void txtSondajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSondajeActionPerformed
        // TODO add your handling code here:
        txtSondaje.transferFocus();
    }//GEN-LAST:event_txtSondajeActionPerformed

    private void txtDiametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiametroActionPerformed
        // TODO add your handling code here:
        txtDiametro.transferFocus();
    }//GEN-LAST:event_txtDiametroActionPerformed

    private void txtPerforistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerforistaActionPerformed
        // TODO add your handling code here:
        txtPerforista.transferFocus();
    }//GEN-LAST:event_txtPerforistaActionPerformed

    private void txtPerf_BrocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerf_BrocaActionPerformed
        // TODO add your handling code here:
        txtPerf_Broca.transferFocus();
    }//GEN-LAST:event_txtPerf_BrocaActionPerformed

    private void txtPerf_TriconoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerf_TriconoActionPerformed
        // TODO add your handling code here:
        txtPerf_Tricono.transferFocus();
    }//GEN-LAST:event_txtPerf_TriconoActionPerformed

    private void txtAvance_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvance_TotalActionPerformed
        // TODO add your handling code here:
        txtAvance_Total.transferFocus();
    }//GEN-LAST:event_txtAvance_TotalActionPerformed

    private void txtRecuperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecuperacionActionPerformed
        // TODO add your handling code here:
        txtRecuperacion.transferFocus();
    }//GEN-LAST:event_txtRecuperacionActionPerformed

    private void txtPre_CollarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPre_CollarActionPerformed
        // TODO add your handling code here:
        txtPre_Collar.transferFocus();
    }//GEN-LAST:event_txtPre_CollarActionPerformed

    private void txtProfundidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfundidadActionPerformed
        // TODO add your handling code here:
        txtProfundidad.transferFocus();
    }//GEN-LAST:event_txtProfundidadActionPerformed

    private void txtCasingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCasingActionPerformed
        // TODO add your handling code here:
        txtCasing.transferFocus();
    }//GEN-LAST:event_txtCasingActionPerformed

    private void txtH_PerfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtH_PerfActionPerformed
        // TODO add your handling code here:
        txtH_Perf.transferFocus();
    }//GEN-LAST:event_txtH_PerfActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
        txtEstado.transferFocus();
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtPerforista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerforista1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPerforista1ActionPerformed

    private void txtPerforista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerforista2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPerforista2ActionPerformed

    private void txtPerforista3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerforista3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPerforista3ActionPerformed

    private void txtPerforista4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerforista4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPerforista4ActionPerformed

    private void txtPerforista5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerforista5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPerforista5ActionPerformed

    private void txtEstado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstado1ActionPerformed

    private void txtZona1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZona1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtZona1ActionPerformed

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
            java.util.logging.Logger.getLogger(Avances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Avances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Avances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Avances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Avances().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField txtAvance_Total;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCasing;
    private javax.swing.JTextField txtDiametro;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtEstado1;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtH_Perf;
    private javax.swing.JTextField txtMaquina;
    private javax.swing.JTextField txtPerf_Broca;
    private javax.swing.JTextField txtPerf_Tricono;
    private javax.swing.JTextField txtPerforista;
    private javax.swing.JTextField txtPerforista1;
    private javax.swing.JTextField txtPerforista2;
    private javax.swing.JTextField txtPerforista3;
    private javax.swing.JTextField txtPerforista4;
    private javax.swing.JTextField txtPerforista5;
    private javax.swing.JTextField txtPre_Collar;
    private javax.swing.JTextField txtProfundidad;
    private javax.swing.JTextField txtProyecto;
    private javax.swing.JTextField txtRecuperacion;
    private javax.swing.JTextField txtSondaje;
    private javax.swing.JTextField txtTurno;
    private javax.swing.JTextField txtZona;
    private javax.swing.JTextField txtZona1;
    // End of variables declaration//GEN-END:variables
}
