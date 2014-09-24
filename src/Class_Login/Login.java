/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Login;

import javax.swing.JOptionPane;
import pro_min.Principal;
import javax.swing.JOptionPane;
import pro_min.Principal;
import pro_min.BDConexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    void acceder(String usuario, String pass)
    {
        //String cap="";
       String sql="SELECT * FROM login WHERE usuario='"+usuario+"' && password='"+pass+"'";
        
       try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.last();
            //recuperamos el numero de registros del Resulset
            int encontrado=rs.getRow();
            
            if ("".equals(txtusuario.getText()) || "".equals(txtcontra.getPassword()))
            {
                JOptionPane.showMessageDialog(null, "Rellene Todos los Campos", "Campos Vacios",
                    JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
            if(encontrado==1) // si nos devuelve un registro significa que la autenticacion es correcta y mostramos el formulario
            {
                 JOptionPane.showMessageDialog(null, "Bienvenido\n"
                    + "Has ingresado satisfactoriamente al sistema", "Ingreso Exitoso!",
                    JOptionPane.INFORMATION_MESSAGE);
                 
                Principal prin = new Principal();
                prin.setVisible(true);
                dispose();
              
            }
            else
            {
                 JOptionPane.showMessageDialog(null, "Ingreso de Datos Incorrectos",
                 "Usuario ó Contraseña Incorrecta",javax.swing.JOptionPane.ERROR_MESSAGE);
                 txtusuario.setText("");
                 txtcontra.setText("");
                 
            }
               //cerramos la conexion
               rs.close();
               st.close();
            }
       }
           catch (Exception e)
            {
            e.printStackTrace();
            }
            
            
       
       
        }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        txtcontra = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar2.jpg"))); // NOI18N
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIconTextGap(-3);
        btnCancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar3.jpg"))); // NOI18N
        btnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar1.jpg"))); // NOI18N
        btnCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 60, 60));
        btnCancelar.getAccessibleContext().setAccessibleName("btnIngresar");

        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login2.jpg"))); // NOI18N
        btnIngresar.setBorder(null);
        btnIngresar.setBorderPainted(false);
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngresar.setIconTextGap(-3);
        btnIngresar.setName("btnIngresar"); // NOI18N
        btnIngresar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login1.jpg"))); // NOI18N
        btnIngresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login3.jpg"))); // NOI18N
        btnIngresar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 80, 60));
        getContentPane().add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ángel-de-tristeza-negro-31000.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        /*this.hide();
        Principal prin = new Principal();
        prin.show();*/
        
    String usu=txtusuario.getText();
    String pas=new String(txtcontra.getPassword());
    acceder(usu, pas);
    
    
    
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this,"Desea salir?","Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (i == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
        txtusuario.requestFocus();
    }//GEN-LAST:event_txtusuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
    BDConexion cc = new BDConexion();
    Connection cn = cc.conexion();
}
