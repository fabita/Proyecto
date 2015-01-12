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
public class Combustible extends javax.swing.JFrame {

    /**
     * Creates new form Combustible
     */
    
        DefaultTableModel model;
        BDConexion bd = new BDConexion();
        Connection cn = bd.conexion();
        Statement sent;
       
        public Combustible() {
        initComponents();
        setLocationRelativeTo(null);
        
        limpiar();
        bloquear();
        cargarCombustible("");
        mostrarCombustible();
        }
    
    
        void cargarCombustible(String valor){
        
            String []titulos={"Id", "Fecha", "Tipo Equipo", "Codigo", "Tip Combustible", "Proveedor","Doc Ingreso", "Cantidad Ingreso", "Hor Kil Ini", "Hor Kil Fin","Consumo", "Observaciones", "Area"};  
            String []Registros= new String[13];
        
            String sql="SELECT * FROM ope_combustibles WHERE CONCAT(id, fecha, tipoEquipo, codigo, tipCombustible, proveedor,docIngreso,cantidadIngreso, HorKilIni, HorKilFin, consumo, observaciones, area) LIKE '%"+valor+"%'";
            model=new DefaultTableModel(null,titulos);

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    Registros[0]= rs.getString("id");
                    Registros[1]= rs.getString("fecha");
                    Registros[2]= rs.getString("tipoEquipo");
                    Registros[3]= rs.getString("codigo");
                    Registros[4]= rs.getString("tipCombustible");
                    Registros[5]= rs.getString("proveedor");
                    Registros[6]= rs.getString("docIngreso");
                    Registros[7]= rs.getString("cantidadIngreso");
                    Registros[8]= rs.getString("HorKilIni");
                    Registros[9]= rs.getString("HorKilFin");
                    Registros[10]= rs.getString("consumo");
                    Registros[11]= rs.getString("observaciones");
                    Registros[12]= rs.getString("area");

                    model.addRow(Registros);
                } 
                t_datos.setModel(model);
            } catch (SQLException ex) {
                Logger.getLogger(Combustible.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    void mostrarCombustible(){
        
            String []titulos={"Id", "Fecha", "Tipo Equipo", "Codigo", "Tip Combustible", "Proveedor","Doc Ingreso", "Cantidad Ingreso", "Hor Kil Ini", "Hor Kil Fin","Consumo", "Observaciones","Area"};  
            String []Registros= new String[13];
        
            String sql="SELECT * FROM ope_combustibles";
            model=new DefaultTableModel(null,titulos);

            try {
                 Statement st = cn.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 while(rs.next())
                 {
                   Registros[0]= rs.getString("id");
                   Registros[1]= rs.getString("fecha");
                   Registros[2]= rs.getString("tipoEquipo");
                   Registros[3]= rs.getString("codigo");
                   Registros[4]= rs.getString("tipCombustible");
                   Registros[5]= rs.getString("proveedor");
                   Registros[6]= rs.getString("docIngreso");
                   Registros[7]= rs.getString("cantidadIngreso");
                   Registros[8]= rs.getString("HorKilIni");
                   Registros[9]= rs.getString("HorKilFin");
                   Registros[10]= rs.getString("consumo");
                   Registros[11]= rs.getString("observaciones");
                   Registros[12]= rs.getString("area");
                  
                   model.addRow(Registros);
             } 
             t_datos.setModel(model);
        } catch (SQLException ex) {
             Logger.getLogger(Combustible.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        void limpiar(){
        txtFecha.setText ("");
        txtTipo_Equipo.setText ("");
        txtCodigo.setText ("");
        txtTipo_Comb.setText ("");
        txtProveedor.setText ("");
        txtDoc_Ing.setText ("");
        txtCant_Ing.setText ("");
        txtHor_Kil_Ini.setText ("");
        txtHor_Kil_Fin.setText ("");
        txtConsumo.setText ("");
        txtObservacion.setText ("");
        txtArea.setText ("");
        }
        void bloquear(){
        txtFecha.setEnabled(false);
        txtTipo_Equipo.setEnabled(false);
        txtCodigo.setEnabled(false);
        txtTipo_Comb.setEnabled(false);
        txtProveedor.setEnabled(false);
        txtDoc_Ing.setEnabled(false);
        txtCant_Ing.setEnabled(false);
        txtHor_Kil_Ini.setEnabled(false);
        txtHor_Kil_Fin.setEnabled(false);
        txtConsumo.setEnabled(false);
        txtObservacion.setEnabled(false);
        txtArea.setEnabled(false);
        }
        void desbloquear(){
        txtFecha.setEnabled(true);
        txtTipo_Equipo.setEnabled(true);
        txtCodigo.setEnabled(true);
        txtTipo_Comb.setEnabled(true);
        txtProveedor.setEnabled(true);
        txtDoc_Ing.setEnabled(true);
        txtCant_Ing.setEnabled(true);
        txtHor_Kil_Ini.setEnabled(true);
        txtHor_Kil_Fin.setEnabled(true);
        txtConsumo.setEnabled(true);
        txtObservacion.setEnabled(true);
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

        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHor_Kil_Ini = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        txtDoc_Ing = new javax.swing.JTextField();
        txtHor_Kil_Fin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCant_Ing = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        txtTipo_Equipo = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtConsumo = new javax.swing.JTextField();
        txtTipo_Comb = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        Area = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo Combustible");

        txtHor_Kil_Ini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHor_Kil_IniActionPerformed(evt);
            }
        });

        jLabel7.setText("Cantidad Ingreso");

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

        txtDoc_Ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoc_IngActionPerformed(evt);
            }
        });

        txtHor_Kil_Fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHor_Kil_FinActionPerformed(evt);
            }
        });

        jLabel8.setText("Hor. / Kil. Ini.");

        jLabel6.setText("Doc. Ingreso");

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

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo Equipo");

        txtCant_Ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCant_IngActionPerformed(evt);
            }
        });

        jLabel18.setText("Combustible");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtTipo_Equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipo_EquipoActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar Combustibles");
        btnMostrar.setActionCommand("");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jLabel9.setText("Hor. / Kil. Fin.");

        txtProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProveedorActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha");

        txtConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsumoActionPerformed(evt);
            }
        });

        txtTipo_Comb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipo_CombActionPerformed(evt);
            }
        });

        jLabel10.setText("Consumo");

        jLabel5.setText("Proveedor");

        jLabel3.setText("Codigo");

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

        jLabel11.setText("Observacion");

        txtObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionActionPerformed(evt);
            }
        });

        Area.setText("Area");

        txtArea.setName(""); // NOI18N
        txtArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTipo_Comb))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(31, 31, 31)
                                .addComponent(txtHor_Kil_Ini, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCant_Ing))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(txtTipo_Equipo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(41, 41, 41)
                                .addComponent(txtProveedor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(31, 31, 31)
                                .addComponent(txtDoc_Ing)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(Area))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtHor_Kil_Fin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addComponent(btnModificar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel18)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel18)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHor_Kil_Fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Area)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txtTipo_Equipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTipo_Comb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDoc_Ing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCant_Ing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtHor_Kil_Ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(btnMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
         cargarCombustible(txtBusqueda.getText());
   }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        // TODO add your handling code here:
         cargarCombustible(txtBusqueda.getText());
   }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
         try {
            int fila = t_datos.getSelectedRow();
            String sql = "delete from ope_combustibles where id=" + t_datos.getValueAt(fila, 0);
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n > 0) {
                mostrarCombustible();
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
            String sql = "Update ope_combustibles set fecha=?, tipoEquipo=?, codigo=?, tipCombustible=?, proveedor=?, docIngreso=?, "
                    + "cantidadIngreso=?, HorKilIni=?,HorKilFin=?, consumo=?, observaciones=?,area=?" + "where id=?";
            
            int fila = t_datos.getSelectedRow();
            String dao = (String) t_datos.getValueAt(fila, 0);
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ps.setString(1, txtFecha.getText());
            ps.setString(2, txtTipo_Equipo.getText());
            ps.setString(3, txtCodigo.getText());
            ps.setString(4, txtTipo_Comb.getText());
            ps.setString(5, txtProveedor.getText());
            ps.setString(6, txtDoc_Ing.getText());
            ps.setString(7, txtCant_Ing.getText());
            ps.setString(8, txtHor_Kil_Ini.getText());
            ps.setString(9, txtHor_Kil_Fin.getText());
            ps.setString(10, txtConsumo.getText());
            ps.setString(11, txtObservacion.getText());
            ps.setString(12, txtArea.getText());
            ps.setString(13, dao);

            int n = ps.executeUpdate();
            if (n > 0) {
                limpiar();
                mostrarCombustible();
                JOptionPane.showMessageDialog(null, "Datos Modificados");
                bloquear();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

   }//GEN-LAST:event_btnModificarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
         mostrarCombustible();
   }//GEN-LAST:event_btnMostrarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
         if (evt.getButton() == 1) {
            int fila = t_datos.getSelectedRow();
            try {
                desbloquear();
                String sql = "select * from ope_combustibles where id=" + t_datos.getValueAt(fila, 0);
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                txtFecha.setText(rs.getString("fecha"));
                txtTipo_Equipo.setText(rs.getString("tipoEquipo"));
                txtCodigo.setText(rs.getString("codigo"));
                txtTipo_Comb.setText(rs.getString("tipCombustible"));
                txtProveedor.setText(rs.getString("proveedor"));
                txtDoc_Ing.setText(rs.getString("docIngreso"));
                txtCant_Ing.setText(rs.getString("cantidadIngreso"));
                txtHor_Kil_Ini.setText(rs.getString("HorKilIni"));
                txtHor_Kil_Fin.setText(rs.getString("HorKilFin"));
                txtConsumo.setText(rs.getString("consumo"));
                txtObservacion.setText(rs.getString("observaciones"));
                 txtArea.setText(rs.getString("area"));
                           
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
   }//GEN-LAST:event_t_datosMouseClicked

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
         txtFecha.transferFocus();
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtTipo_EquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipo_EquipoActionPerformed
        // TODO add your handling code here:
         txtTipo_Equipo.transferFocus();
    }//GEN-LAST:event_txtTipo_EquipoActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
         txtCodigo.transferFocus();
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtTipo_CombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipo_CombActionPerformed
        // TODO add your handling code here:
         txtTipo_Comb.transferFocus();
    }//GEN-LAST:event_txtTipo_CombActionPerformed

    private void txtProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProveedorActionPerformed
        // TODO add your handling code here:
         txtProveedor.transferFocus();
    }//GEN-LAST:event_txtProveedorActionPerformed

    private void txtDoc_IngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoc_IngActionPerformed
        // TODO add your handling code here:
         txtDoc_Ing.transferFocus();
    }//GEN-LAST:event_txtDoc_IngActionPerformed

    private void txtCant_IngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCant_IngActionPerformed
        // TODO add your handling code here:
         txtCant_Ing.transferFocus();
    }//GEN-LAST:event_txtCant_IngActionPerformed

    private void txtHor_Kil_IniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHor_Kil_IniActionPerformed
        // TODO add your handling code here:
         txtHor_Kil_Ini.transferFocus();
    }//GEN-LAST:event_txtHor_Kil_IniActionPerformed

    private void txtHor_Kil_FinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHor_Kil_FinActionPerformed
        // TODO add your handling code here:
         txtHor_Kil_Fin.transferFocus();
    }//GEN-LAST:event_txtHor_Kil_FinActionPerformed

    private void txtConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsumoActionPerformed
        // TODO add your handling code here:
         txtConsumo.transferFocus();
    }//GEN-LAST:event_txtConsumoActionPerformed

    private void txtObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacionActionPerformed
        // TODO add your handling code here:
         txtObservacion.transferFocus();
    }//GEN-LAST:event_txtObservacionActionPerformed

    private void txtAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaActionPerformed
        // TODO add your handling code here:
         txtArea.transferFocus();
    }//GEN-LAST:event_txtAreaActionPerformed

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
            java.util.logging.Logger.getLogger(Combustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Combustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Combustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Combustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Combustible().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Area;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCant_Ing;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtConsumo;
    private javax.swing.JTextField txtDoc_Ing;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHor_Kil_Fin;
    private javax.swing.JTextField txtHor_Kil_Ini;
    private javax.swing.JTextField txtObservacion;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtTipo_Comb;
    private javax.swing.JTextField txtTipo_Equipo;
    // End of variables declaration//GEN-END:variables
}
