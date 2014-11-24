/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;
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
 * @author Usuario
 */
public class BDCombustibles extends javax.swing.JFrame {

    /**
     * Creates new form BDCombustibles
     */
        DefaultTableModel model;
        BDConexion bd = new BDConexion();
        Connection cn = bd.conexion();
        Statement sent;
        
        public BDCombustibles() {
            initComponents();
            setLocationRelativeTo(null);
            limpiar();
            bloquear();
            cargar("");
            mostrarCombustibles();
        }
        void cargar(String valor){
        
            String []titulos={"Id", "Codigo", "Tip. Combustible", "Proveedor", "Doc Ingreso", "Cantidad de Ingreso", "Hor./Kil. Ini", "Hor./Kil. Fin", "Consumo", "Observaciones"};  
            String []Registros= new String[10];
        
            String sql="SELECT * FROM combustibles WHERE CONCAT(id, codigo, tipCombustible, proveedor, docIngreso, cantidadIngreso,HorKilIni,HorKilFin,consumo,observaciones) LIKE '%"+valor+"%'";
            model=new DefaultTableModel(null,titulos);

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    Registros[0]= rs.getString("id");
                    Registros[1]= rs.getString("codigo");
                    Registros[2]= rs.getString("tipCombustible");
                    Registros[3]= rs.getString("proveedor");
                    Registros[4]= rs.getString("docIngreso");
                    Registros[5]= rs.getString("cantidadIngreso");
                    Registros[6]= rs.getString("HorKilIni");
                    Registros[7]= rs.getString("HorKilFin");
                    Registros[8]= rs.getString("consumo");
                    Registros[9]= rs.getString("observaciones");

                    model.addRow(Registros);
                } 
                t_datos.setModel(model);
            } catch (SQLException ex) {
                Logger.getLogger(BDCombustibles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    void mostrarCombustibles(){
        
        String []titulos={"Id", "Codigo", "Tip. Combustible", "Proveedor", "Doc Ingreso", "Cantidad de Ingreso", "Hor./Kil. Ini", "Hor./Kil. Fin", "Consumo", "Observaciones"};  
        String []Registros= new String[10];
        
        String sql="SELECT * FROM combustibles";
        model=new DefaultTableModel(null,titulos);
        
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next())
             {
                   Registros[0]= rs.getString("id");
                   Registros[1]= rs.getString("codigo");
                   Registros[2]= rs.getString("tipCombustible");
                   Registros[3]= rs.getString("proveedor");
                   Registros[4]= rs.getString("docIngreso");
                   Registros[5]= rs.getString("cantidadIngreso");
                   Registros[6]= rs.getString("HorKilIni");
                   Registros[7]= rs.getString("HorKilFin");
                   Registros[8]= rs.getString("consumo");
                   Registros[9]= rs.getString("observaciones");
                   
                   model.addRow(Registros);
             } 
             t_datos.setModel(model);
        } catch (SQLException ex) {
             Logger.getLogger(BDCombustibles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        void limpiar(){
        txtCodigo.setText ("");
        txtTipCombustible.setText ("");
        txtProveedor.setText ("");
        txtDocIngreso.setText ("");
        txtCantIngreso.setText ("");
        txtHorIni.setText ("");
        txtHorFin.setText ("");
        txtConsumo.setText ("");
        txtObservaciones.setText ("");
        
        }

        void bloquear(){
        txtCodigo.setEnabled(false);
        txtTipCombustible.setEnabled(false);
        txtProveedor.setEnabled(false);
        txtDocIngreso.setEnabled(false);
        txtCantIngreso.setEnabled(false);
        txtHorIni.setEnabled(false);
        txtHorFin.setEnabled(false);
        txtConsumo.setEnabled(false);
        txtObservaciones.setEnabled(false);


        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);

        }

        void desbloquear(){
        txtCodigo.setEnabled(true);
        txtTipCombustible.setEnabled(true);
        txtProveedor.setEnabled(true);
        txtDocIngreso.setEnabled(true);
        txtCantIngreso.setEnabled(true);
        txtHorIni.setEnabled(true);
        txtHorFin.setEnabled(true);
        txtConsumo.setEnabled(true);
        txtObservaciones.setEnabled(true);

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

        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        txtCantIngreso = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTipCombustible = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        txtDocIngreso = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtConsumo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHorFin = new javax.swing.JTextField();
        txtHorIni = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo Combustible");

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

        txtCantIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantIngresoActionPerformed(evt);
            }
        });

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProveedorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Base de Datos Combustibles");

        jLabel2.setText("Codigo");

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

        jLabel5.setText("Proveedor");

        txtTipCombustible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipCombustibleActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel4.setText("Cantidad de Ingreso");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtDocIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocIngresoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Doc. Ingreso");

        jLabel7.setText("Buscar :");

        txtConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsumoActionPerformed(evt);
            }
        });

        jLabel8.setText("Consumo");

        txtHorFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorFinActionPerformed(evt);
            }
        });

        txtHorIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorIniActionPerformed(evt);
            }
        });

        jLabel9.setText("Hor. / Kil. Fin.");

        jLabel10.setText("Hor. / Kil. Ini.");

        txtObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionesActionPerformed(evt);
            }
        });

        jLabel11.setText("Observaciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(184, 184, 184))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCancelar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNuevo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnGuardar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnMostrar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(btnModificar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEliminar))))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCodigo)
                                .addComponent(txtTipCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(56, 56, 56)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCantIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDocIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHorIni, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHorFin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTipCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDocIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtHorIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtHorFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        desbloquear();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        // TODO add your handling code here:
        
        String codigo, tipCombustible, proveedor, docIngreso, cantIngreso, HorIni, HorFin, consumo, observaciones;
        int dni;
        String sql = "";
        codigo = txtCodigo.getText();
        tipCombustible = txtTipCombustible.getText();
        proveedor = txtProveedor.getText();
        docIngreso = txtDocIngreso.getText();
        cantIngreso = txtCantIngreso.getText();
        HorIni = txtHorIni.getText();
        HorFin = txtHorFin.getText();
        consumo = txtConsumo.getText();
        observaciones = txtObservaciones.getText();
       
        sql = "INSERT INTO combustibles (codigo, tipCombustible, proveedor, docIngreso, cantidadIngreso,HorKilIni,HorKilFin,consumo,observaciones) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, codigo);
            pst.setString(2, tipCombustible);
            pst.setString(3, proveedor);
            pst.setString(4, docIngreso);
            pst.setString(5, cantIngreso);
            pst.setString(6, HorIni);
            pst.setString(7, HorFin);
            pst.setString(8, consumo);
            pst.setString(9, observaciones);
            
            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado con exito");
                bloquear();
                btnNuevo.setEnabled(true);
                btnGuardar.setEnabled(false);
                cargar("");
                limpiar();

            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
       if (evt.getButton() == 1) {
            int fila = t_datos.getSelectedRow();
            try {
                desbloquear();
                String sql = "select * from combustibles where id=" + t_datos.getValueAt(fila, 0);
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                txtCodigo.setText(rs.getString("codigo"));
                txtTipCombustible.setText(rs.getString("tipCombustible"));
                txtProveedor.setText(rs.getString("proveedor"));
                txtDocIngreso.setText(rs.getString("docIngreso"));
                txtCantIngreso.setText(rs.getString("cantidadIngreso"));
                txtHorIni.setText(rs.getString("HorKilIni"));
                txtHorFin.setText(rs.getString("HorKilFin"));
                txtConsumo.setText(rs.getString("consumo"));
                txtObservaciones.setText(rs.getString("observaciones"));                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_t_datosMouseClicked

    private void txtCantIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantIngresoActionPerformed
        // TODO add your handling code here:
        txtCantIngreso.transferFocus();
    }//GEN-LAST:event_txtCantIngresoActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
        txtCodigo.transferFocus();
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProveedorActionPerformed
        // TODO add your handling code here:
        txtProveedor.transferFocus();
    }//GEN-LAST:event_txtProveedorActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
        cargar(txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        // TODO add your handling code here:
        cargar(txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        mostrarCombustibles();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void txtTipCombustibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipCombustibleActionPerformed
        // TODO add your handling code here:
        txtTipCombustible.transferFocus();
    }//GEN-LAST:event_txtTipCombustibleActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = t_datos.getSelectedRow();
            String sql = "delete from combustibles where id=" + t_datos.getValueAt(fila, 0);
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n > 0) {
                mostrarCombustibles();
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
            String sql = "Update combustibles set codigo=?, tipCombustible=?, proveedor=?, docIngreso=?, cantidadIngreso=?, HorKilIni=?, HorKilFin=?, consumo=? ,observaciones=?" + "where id=?";
            int fila = t_datos.getSelectedRow();
            String dao = (String) t_datos.getValueAt(fila, 0);
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, txtCodigo.getText());
            ps.setString(2, txtTipCombustible.getText());
            ps.setString(3, txtProveedor.getText());
            ps.setString(4, txtDocIngreso.getText());
            ps.setString(5, txtCantIngreso.getText());
            ps.setString(6, txtHorIni.getText());
            ps.setString(7, txtHorFin.getText());
            ps.setString(8, txtConsumo.getText());
            ps.setString(9, txtObservaciones.getText());
            ps.setString(10, dao);

            int n = ps.executeUpdate();
            if (n > 0) {
                limpiar();
                mostrarCombustibles();
                JOptionPane.showMessageDialog(null, "Datos Modificados");
                bloquear();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtDocIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocIngresoActionPerformed
        // TODO add your handling code here:
        txtDocIngreso.transferFocus();
    }//GEN-LAST:event_txtDocIngresoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsumoActionPerformed

    private void txtHorFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorFinActionPerformed

    private void txtHorIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorIniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorIniActionPerformed

    private void txtObservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservacionesActionPerformed

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
            java.util.logging.Logger.getLogger(BDCombustibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BDCombustibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BDCombustibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BDCombustibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BDCombustibles().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCantIngreso;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtConsumo;
    private javax.swing.JTextField txtDocIngreso;
    private javax.swing.JTextField txtHorFin;
    private javax.swing.JTextField txtHorIni;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtTipCombustible;
    // End of variables declaration//GEN-END:variables
}
