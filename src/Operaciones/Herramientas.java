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
public class Herramientas extends javax.swing.JFrame {

    /**
     * Creates new form Herramientas
     */
       DefaultTableModel model;
       BDConexion bd = new BDConexion();
       Connection cn = bd.conexion();
       Statement sent;
       
       public Herramientas() {
        initComponents();
        setLocationRelativeTo(null);
        limpiar();
        bloquear();
        cargarHerramientas("");
        mostrarHerramientas();
        }
    
    
        void cargarHerramientas(String valor){
        
            String []titulos={"Id", "Fecha", "Proyecto", "Zona", "Maquina", "Turno", "Sondaje", "Descripcion", "Diam", 
                "NumBroca_Tricono", "Tipo", "Serie", "Marca", "De", "Hasta","Avance","AcumBroca", "Estado Broca" ,"Perforista"};  
            String []Registros= new String[19];
        
            String sql="SELECT * FROM ope_herramientas WHERE CONCAT(id, fecha, proyecto, zona, maquina, turno,sondaje,"
                    + "descripcion, diam, numBroca_Tricono, tipo, serie, marca, de, hasta, avance, estadoBroca, perforista) LIKE '%"+valor+"%'";
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
                    Registros[7]= rs.getString("descripcion");
                    Registros[8]= rs.getString("diam");
                    Registros[9]= rs.getString("numBroca_Tricono");
                    Registros[10]= rs.getString("tipo");
                    Registros[11]= rs.getString("serie");
                    Registros[12]= rs.getString("marca");
                    Registros[13]= rs.getString("de");
                    Registros[14]= rs.getString("hasta");
                    Registros[15]= rs.getString("avance");
                    Registros[16]= rs.getString("acumBroca");
                    Registros[17]= rs.getString("estadoBroca");
                    Registros[18]= rs.getString("perforista");
                    model.addRow(Registros);
                } 
                t_datos.setModel(model);
            } catch (SQLException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    void mostrarHerramientas(){
        
            String []titulos={"Id", "Fecha", "Proyecto", "Zona", "Maquina", "Turno", "Sondaje", "Descripcion", "Diam", 
                "NumBroca_Tricono", "Tipo", "Serie", "Marca", "De", "Hasta","Avance","AcumBroca", "Estado Broca" ,"Perforista"};  
            String []Registros= new String[19];
        
            String sql="SELECT * FROM ope_herramientas";
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
                   Registros[7]= rs.getString("descripcion");
                   Registros[8]= rs.getString("diam");
                   Registros[9]= rs.getString("numBroca_Tricono");
                   Registros[10]= rs.getString("tipo");
                   Registros[11]= rs.getString("serie");
                   Registros[12]= rs.getString("marca");
                   Registros[13]= rs.getString("de");
                   Registros[14]= rs.getString("hasta");
                   Registros[15]= rs.getString("avance");
                   Registros[16]= rs.getString("acumBroca");
                   Registros[17]= rs.getString("estadoBroca");
                   Registros[18]= rs.getString("perforista");
                   model.addRow(Registros);
             } 
             t_datos.setModel(model);
        } catch (SQLException ex) {
             Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        void limpiar(){
        txtFecha.setText ("");
        txtProyecto.setText ("");
        txtZona.setText ("");
        txtMaquina.setText ("");
        txtTurno.setText ("");
        txtSondaje.setText ("");
        txtDescripcion.setText ("");
        txtDiam.setText ("");
        txtNumBroca_Tric.setText ("");
        txtTipo.setText ("");
        txtSerie.setText ("");
        txtMarca.setText ("");
        txtDe.setText ("");
        txtHasta.setText ("");
        txtAvance.setText ("");
        txtAcum_Broca.setText ("");
        txtEstado_Broca.setText ("");
        txtPerforista.setText ("");
        }

        void bloquear(){
        txtFecha.setEnabled(false);
        txtProyecto.setEnabled(false);
        txtZona.setEnabled(false);
        txtMaquina.setEnabled(false);
        txtTurno.setEnabled(false);
        txtSondaje.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtDiam.setEnabled(false);
        txtNumBroca_Tric.setEnabled(false);
        txtTipo.setEnabled(false);
        txtSerie.setEnabled(false);
        txtMarca.setEnabled(false);
        txtDe.setEnabled(false);
        txtHasta.setEnabled(false);
        txtAvance.setEnabled(false);
        txtAcum_Broca.setEnabled(false);
        txtEstado_Broca.setEnabled(false);
        txtPerforista.setEnabled(false);
        }

        void desbloquear(){
        txtFecha.setEnabled(true);
        txtProyecto.setEnabled(true);
        txtZona.setEnabled(true);
        txtMaquina.setEnabled(true);
        txtTurno.setEnabled(true);
        txtSondaje.setEnabled(true);
        txtDescripcion.setEnabled(true);
        txtDiam.setEnabled(true);
        txtNumBroca_Tric.setEnabled(true);
        txtTipo.setEnabled(true);
        txtSerie.setEnabled(true);
        txtMarca.setEnabled(true);
        txtDe.setEnabled(true);
        txtHasta.setEnabled(true);
        txtAvance.setEnabled(true);
        txtAcum_Broca.setEnabled(true);
        txtEstado_Broca.setEnabled(true);
        txtPerforista.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtMaquina = new javax.swing.JTextField();
        txtTurno = new javax.swing.JTextField();
        txtZona = new javax.swing.JTextField();
        txtProyecto = new javax.swing.JTextField();
        txtSondaje = new javax.swing.JTextField();
        txtDiam = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtDe = new javax.swing.JTextField();
        txtHasta = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        txtAvance = new javax.swing.JTextField();
        txtEstado_Broca = new javax.swing.JTextField();
        txtAcum_Broca = new javax.swing.JTextField();
        txtNumBroca_Tric = new javax.swing.JTextField();
        txtPerforista = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtPerforista1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("Maquina");

        jLabel13.setText("Hasta");

        jLabel7.setText("Descripcion");

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

        jLabel14.setText("Avance");

        jLabel12.setText("De");

        jLabel8.setText("Diam");

        jLabel6.setText("Sondaje");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Proyecto");

        jLabel18.setText("Herramientas");

        jLabel15.setText("Acum. Broca");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar Herramientas");
        btnMostrar.setActionCommand("");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jLabel11.setText("Marca");

        jLabel9.setText("Tipo");

        jLabel1.setText("Fecha");

        jLabel10.setText("Serie");

        jLabel16.setText("Estado Broca");

        jLabel5.setText("Turno");

        jLabel3.setText("Zona");

        jLabel17.setText("Perforista");

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

        jLabel19.setText("Buscar :");

        jLabel20.setText("Num Broca / Tricono");

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });

        jLabel21.setText("Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMostrar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(103, 103, 103))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel20)
                                                .addComponent(btnModificar))
                                            .addGap(36, 36, 36))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtDiam, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel16))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtSondaje, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtNumBroca_Tric, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(44, 44, 44)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel17)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel11))
                                                    .addGap(13, 13, 13))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel15)))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(41, 41, 41)
                                                    .addComponent(btnEliminar))
                                                .addComponent(txtAvance, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtEstado_Broca)
                                                    .addComponent(txtAcum_Broca, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                                .addComponent(txtPerforista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel18)))
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(366, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addGap(13, 13, 13)
                    .addComponent(txtPerforista1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(114, 114, 114)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSondaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado_Broca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtAcum_Broca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNumBroca_Tric, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(35, 35, 35)
                        .addComponent(btnModificar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPerforista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(27, 27, 27)
                        .addComponent(btnEliminar)))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(btnMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(299, 299, 299)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPerforista1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21))
                    .addContainerGap(307, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
         cargarHerramientas(txtBusqueda.getText());
   }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        // TODO add your handling code here:
         cargarHerramientas(txtBusqueda.getText());
   }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = t_datos.getSelectedRow();
            String sql = "delete from ope_herramientas where id=" + t_datos.getValueAt(fila, 0);
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n > 0) {
                mostrarHerramientas();
                JOptionPane.showMessageDialog(null, "Datos Eliminados");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
   }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
          try {
            desbloquear();
            String sql = "Update ope_herramientas set fecha=?, proyecto=?, zona=?, maquina=?, turno=?, sondaje=?, "
                    + "descripcion=?, diam=?,numBroca_Tricono=?, tipo=?, serie=?, marca=?, de=?, hasta=?, "
                    + "avance=?, acumBroca=?, estadoBroca=?, perforista=?" + "where id=?";
            
            int fila = t_datos.getSelectedRow();
            String dao = (String) t_datos.getValueAt(fila, 0);
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ps.setString(1, txtFecha.getText());
            ps.setString(2, txtProyecto.getText());
            ps.setString(3, txtZona.getText());
            ps.setString(4, txtMaquina.getText());
            ps.setString(5, txtTurno.getText());
            ps.setString(6, txtSondaje.getText());
            ps.setString(7, txtDescripcion.getText());
            ps.setString(8, txtDiam.getText());
            ps.setString(9, txtNumBroca_Tric.getText());
            ps.setString(10, txtTipo.getText());
            ps.setString(11, txtSerie.getText());
            ps.setString(12, txtMarca.getText());
            ps.setString(13, txtDe.getText());
            ps.setString(14, txtHasta.getText());
            ps.setString(15, txtAvance.getText());
            ps.setString(16, txtAcum_Broca.getText());
            ps.setString(17, txtEstado_Broca.getText());
            ps.setString(18, txtPerforista.getText());
            ps.setString(19, dao);

            int n = ps.executeUpdate();
            if (n > 0) {
                limpiar();
                mostrarHerramientas();
                JOptionPane.showMessageDialog(null, "Datos Modificados");
                bloquear();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
   }//GEN-LAST:event_btnModificarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
         mostrarHerramientas();
   }//GEN-LAST:event_btnMostrarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            int fila = t_datos.getSelectedRow();
            try {
                desbloquear();
                String sql = "select * from ope_herramientas where id=" + t_datos.getValueAt(fila, 0);
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                txtFecha.setText(rs.getString("fecha"));
                txtProyecto.setText(rs.getString("proyecto"));
                txtZona.setText(rs.getString("zona"));
                txtMaquina.setText(rs.getString("maquina"));
                txtTurno.setText(rs.getString("turno"));
                txtSondaje.setText(rs.getString("sondaje"));
                txtDescripcion.setText(rs.getString("descripcion"));
                txtDiam.setText(rs.getString("diam"));
                txtNumBroca_Tric.setText(rs.getString("numBroca_Tricono"));
                txtTipo.setText(rs.getString("tipo"));
                txtSerie.setText(rs.getString("serie"));
                txtMarca.setText(rs.getString("marca"));
                txtDe.setText(rs.getString("de"));
                txtHasta.setText(rs.getString("hasta"));
                txtAvance.setText(rs.getString("avance"));
                txtAcum_Broca.setText(rs.getString("acumBroca"));
                txtEstado_Broca.setText(rs.getString("estadoBroca"));
                txtPerforista.setText(rs.getString("perforista"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
   }//GEN-LAST:event_t_datosMouseClicked

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

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
            java.util.logging.Logger.getLogger(Herramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Herramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Herramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Herramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Herramientas().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField txtAcum_Broca;
    private javax.swing.JTextField txtAvance;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtDe;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDiam;
    private javax.swing.JTextField txtEstado_Broca;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHasta;
    private javax.swing.JTextField txtMaquina;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNumBroca_Tric;
    private javax.swing.JTextField txtPerforista;
    private javax.swing.JTextField txtPerforista1;
    private javax.swing.JTextField txtProyecto;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtSondaje;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTurno;
    private javax.swing.JTextField txtZona;
    // End of variables declaration//GEN-END:variables
}
