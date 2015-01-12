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
public class CorridasPerforaciones extends javax.swing.JFrame {

    /**
     * Creates new form CorridasPerforaciones
     */
    DefaultTableModel model;
    BDConexion bd = new BDConexion();
    Connection cn = bd.conexion();
    Statement sent;

    public CorridasPerforaciones() {
        initComponents();
        setLocationRelativeTo(null);
        limpiar();
        bloquear();
        cargarCorridasPerforaciones("");
        mostrarCorridasPerforaciones();

    }

    void cargarCorridasPerforaciones(String valor) {

        String[] titulos = {"Id", "Fecha", "Proyecto", "Zona", "Maquina", "Turno", "Sondaje", "ProfInic", "ProfFinal",
            "LongPerf", "LongRecup", "Recup", "Retorno", "Compacto", "SemiComp", "Fract", "MuyFract", "Vacios", "Area"};
        String[] Registros = new String[19];

        String sql = "SELECT * FROM ope_corridasPerf WHERE CONCAT(id, fecha, proyecto, zona, maquina, turno,sondaje,"
                + "profInicial, profFinal, longPerf, longRecup, recup, retorno, compacto, semiCompacto, fracturado,muyFracturado, vacios, area ) LIKE '%" + valor + "%'";
        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString("id");
                Registros[1] = rs.getString("fecha");
                Registros[2] = rs.getString("proyecto");
                Registros[3] = rs.getString("zona");
                Registros[4] = rs.getString("maquina");
                Registros[5] = rs.getString("turno");
                Registros[6] = rs.getString("sondaje");
                Registros[7] = rs.getString("profInicial");
                Registros[8] = rs.getString("profFinal");
                Registros[9] = rs.getString("longPerf");
                Registros[10] = rs.getString("longRecup");
                Registros[11] = rs.getString("recup");
                Registros[12] = rs.getString("retorno");
                Registros[13] = rs.getString("compacto");
                Registros[14] = rs.getString("semiCompacto");
                Registros[15] = rs.getString("fracturado");
                Registros[16] = rs.getString("muyFracturado");
                Registros[17] = rs.getString("vacios");
                Registros[18] = rs.getString("area");
                model.addRow(Registros);
            }
            t_datos.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(CorridasPerforaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrarCorridasPerforaciones() {

        String[] titulos = {"Id", "Fecha", "Proyecto", "Zona", "Maquina", "Turno", "Sondaje", "ProfInic", "ProfFinal",
            "LongPerf", "LongRecup", "Recup", "Retorno", "Compacto", "SemiComp", "Fract", "MuyFract", "Vacios", "Area"};
        String[] Registros = new String[19];

        String sql = "SELECT * FROM ope_corridasPerf";
        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Registros[0] = rs.getString("id");
                Registros[1] = rs.getString("fecha");
                Registros[2] = rs.getString("proyecto");
                Registros[3] = rs.getString("zona");
                Registros[4] = rs.getString("maquina");
                Registros[5] = rs.getString("turno");
                Registros[6] = rs.getString("sondaje");
                Registros[7] = rs.getString("profInicial");
                Registros[8] = rs.getString("profFinal");
                Registros[9] = rs.getString("longPerf");
                Registros[10] = rs.getString("longRecup");
                Registros[11] = rs.getString("recup");
                Registros[12] = rs.getString("retorno");
                Registros[13] = rs.getString("compacto");
                Registros[14] = rs.getString("semiCompacto");
                Registros[15] = rs.getString("fracturado");
                Registros[16] = rs.getString("muyFracturado");
                Registros[17] = rs.getString("vacios");
                Registros[18] = rs.getString("area");
                model.addRow(Registros);
            }
            t_datos.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(CorridasPerforaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void limpiar() {
        txtFecha.setText("");
        txtProyecto.setText("");
        txtZona.setText("");
        txtMaquina.setText("");
        txtTurno.setText("");
        txtSondaje.setText("");
        txtProfInicial.setText("");
        txtProfFinal.setText("");
        txtLongPerf.setText("");
        txtLongRecup.setText("");
        txtRecup.setText("");
        txtRetorno.setText("");
      txtCompacto.setText("");
        txtSemiComp.setText("");
        txtFracturado.setText("");
        txtMuyFract.setText("");
        txtVacios.setText("");
        txtArea.setText("");
    }

    void bloquear() {
        txtFecha.setEnabled(false);
        txtProyecto.setEnabled(false);
        txtZona.setEnabled(false);
        txtMaquina.setEnabled(false);
        txtTurno.setEnabled(false);
        txtSondaje.setEnabled(false);
        txtProfInicial.setEnabled(false);
        txtProfFinal.setEnabled(false);
        txtLongPerf.setEnabled(false);
        txtLongRecup.setEnabled(false);
        txtRecup.setEnabled(false);
        txtRetorno.setEnabled(false);
        txtCompacto.setEnabled(false);
        txtSemiComp.setEnabled(false);
        txtFracturado.setEnabled(false);
        txtMuyFract.setEnabled(false);
        txtVacios.setEnabled(false);
        txtArea.setEnabled(false);
    }

    void desbloquear() {
        txtFecha.setEnabled(true);
        txtProyecto.setEnabled(true);
        txtZona.setEnabled(true);
        txtMaquina.setEnabled(true);
        txtTurno.setEnabled(true);
        txtSondaje.setEnabled(true);
        txtProfInicial.setEnabled(true);
        txtProfFinal.setEnabled(true);
        txtLongPerf.setEnabled(true);
        txtLongRecup.setEnabled(true);
        txtRecup.setEnabled(true);
        txtRetorno.setEnabled(true);
        txtCompacto.setEnabled(true);
        txtSemiComp.setEnabled(true);
        txtFracturado.setEnabled(true);
        txtMuyFract.setEnabled(true);
        txtVacios.setEnabled(true);
        txtArea.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        txtZona = new javax.swing.JTextField();
        txtProyecto = new javax.swing.JTextField();
        txtMaquina = new javax.swing.JTextField();
        txtTurno = new javax.swing.JTextField();
        txtSondaje = new javax.swing.JTextField();
        txtProfInicial = new javax.swing.JTextField();
        txtProfFinal = new javax.swing.JTextField();
        txtLongPerf = new javax.swing.JTextField();
        txtLongRecup = new javax.swing.JTextField();
        txtRecup = new javax.swing.JTextField();
        txtRetorno = new javax.swing.JTextField();
        txtCompacto = new javax.swing.JTextField();
        txtSemiComp = new javax.swing.JTextField();
        txtFracturado = new javax.swing.JTextField();
        txtMuyFract = new javax.swing.JTextField();
        txtVacios = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel19.setText("Buscar :");

        jLabel18.setText("Corridas de Perforaciones");

        jLabel17.setText("Vacios");

        jLabel7.setText("Prof. Inicial");

        jLabel6.setText("Sondaje");

        jLabel9.setText("Long Perf");

        jLabel8.setText("Prof. Final");

        jLabel11.setText("% Recup.");

        jLabel10.setText("Long Recup.");

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

        btnMostrar.setText("Mostrar Combustibles");
        btnMostrar.setActionCommand("");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
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

        jLabel14.setText("Semi - Compacto");

        jLabel12.setText("% Retorno");

        jLabel13.setText("Compacto");

        jLabel2.setText("Proyecto");

        jLabel3.setText("Zona");

        jLabel4.setText("Maquina");

        jLabel1.setText("Fecha");

        jLabel5.setText("Turno");

        jLabel15.setText("Fracturado");

        jLabel16.setText("Muy Fracturado");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel20.setText("Area :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtProfFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtProfInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCompacto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRecup, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLongRecup, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLongPerf, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMuyFract, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSemiComp, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFracturado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtVacios, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                        .addComponent(jLabel20)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnMostrar))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(48, 48, 48)
                                                    .addComponent(btnModificar)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnEliminar))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtSondaje, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))))))))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel18)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSondaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtProfInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtProfFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtLongPerf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtLongRecup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtRecup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCompacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSemiComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFracturado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMuyFract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtVacios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(btnMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(113, 113, 113))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
        cargarCorridasPerforaciones(txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        // TODO add your handling code here:
        cargarCorridasPerforaciones(txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        mostrarCorridasPerforaciones();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            int fila = t_datos.getSelectedRow();
            try {
                desbloquear();
                String sql = "select * from ope_corridasPerf where id=" + t_datos.getValueAt(fila, 0);
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                txtFecha.setText(rs.getString("fecha"));
                txtProyecto.setText(rs.getString("proyecto"));
                txtZona.setText(rs.getString("zona"));
                txtMaquina.setText(rs.getString("maquina"));
                txtTurno.setText(rs.getString("turno"));
                txtSondaje.setText(rs.getString("sondaje"));
                txtProfInicial.setText(rs.getString("profInicial"));
                txtProfFinal.setText(rs.getString("profFinal"));
                txtLongPerf.setText(rs.getString("longPerf"));
                txtLongRecup.setText(rs.getString("longRecup"));
                txtRecup.setText(rs.getString("recup"));
                txtRetorno.setText(rs.getString("retorno"));
                txtCompacto.setText(rs.getString("compacto"));
                txtSemiComp.setText(rs.getString("semiCompacto"));
                txtFracturado.setText(rs.getString("fracturado"));
                txtMuyFract.setText(rs.getString("muyFracturado"));
                txtVacios.setText(rs.getString("vacios"));
                txtArea.setText(rs.getString("area"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
    
    }//GEN-LAST:event_t_datosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = t_datos.getSelectedRow();
            String sql = "delete from ope_corridasPerf where id=" + t_datos.getValueAt(fila, 0);
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n > 0) {
                mostrarCorridasPerforaciones();
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
            String sql = "Update ope_corridasPerf set fecha=?, proyecto=?, zona=?, maquina=?, turno=?, sondaje=?, "
                    + "profInicial=?, profFinal=?,longPerf=?, longRecup=?, recup=?, retorno=?, compacto=?, semiCompacto=?, "
                    + "fracturado=?, muyFracturado=?, vacios=?, area=?" + "where id=?";
            int fila = t_datos.getSelectedRow();
            String dao = (String) t_datos.getValueAt(fila, 0);
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, txtFecha.getText());
            ps.setString(2, txtProyecto.getText());
            ps.setString(3, txtZona.getText());
            ps.setString(4, txtMaquina.getText());
            ps.setString(5, txtTurno.getText());
            ps.setString(6, txtSondaje.getText());
            ps.setString(7, txtProfInicial.getText());
            ps.setString(8, txtProfFinal.getText());
            ps.setString(9, txtLongPerf.getText());
            ps.setString(10, txtLongRecup.getText());
            ps.setString(11, txtRecup.getText());
            ps.setString(12, txtRetorno.getText());
            ps.setString(13, txtCompacto.getText());
            ps.setString(14, txtSemiComp.getText());
            ps.setString(15, txtFracturado.getText());
            ps.setString(16, txtMuyFract.getText());
            ps.setString(17, txtVacios.getText());
            ps.setString(18, txtArea.getText());
            ps.setString(19, dao);

            int n = ps.executeUpdate();
            if (n > 0) {
                limpiar();
                mostrarCorridasPerforaciones();
                JOptionPane.showMessageDialog(null, "Datos Modificados");
                bloquear();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    
    }//GEN-LAST:event_btnModificarActionPerformed
    
        
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(CorridasPerforaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CorridasPerforaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CorridasPerforaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CorridasPerforaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CorridasPerforaciones().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCompacto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFracturado;
    private javax.swing.JTextField txtLongPerf;
    private javax.swing.JTextField txtLongRecup;
    private javax.swing.JTextField txtMaquina;
    private javax.swing.JTextField txtMuyFract;
    private javax.swing.JTextField txtProfFinal;
    private javax.swing.JTextField txtProfInicial;
    private javax.swing.JTextField txtProyecto;
    private javax.swing.JTextField txtRecup;
    private javax.swing.JTextField txtRetorno;
    private javax.swing.JTextField txtSemiComp;
    private javax.swing.JTextField txtSondaje;
    private javax.swing.JTextField txtTurno;
    private javax.swing.JTextField txtVacios;
    private javax.swing.JTextField txtZona;
    // End of variables declaration//GEN-END:variables
}
