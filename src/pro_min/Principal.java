/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pro_min;

import BD.*;
import Class_Login.*;
import ControlAvance.*;
import Reporte.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmnuModificar = new javax.swing.JMenuItem();
        jmnuSalir = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuReport = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmnuReport = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jmnuAditivos = new javax.swing.JMenuItem();
        jmnuPersonal = new javax.swing.JMenuItem();
        jmnuMaquinaria = new javax.swing.JMenuItem();
        jmuHerramientas = new javax.swing.JMenuItem();
        jmnuSondajes = new javax.swing.JMenuItem();
        jmnuCombustibles = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jmnuAvances = new javax.swing.JMenuItem();
        jmnuCDA = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/luna.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(680, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(379, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        jScrollPane1.setViewportView(jPanel1);

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/archivo2.png"))); // NOI18N
        jMenu1.setToolTipText("Archivo");
        jMenu1.add(jSeparator2);

        jmnuModificar.setText("Modificar - Crear Nuevo Usuario");
        jmnuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuModificarActionPerformed(evt);
            }
        });
        jMenu1.add(jmnuModificar);
        jmnuModificar.getAccessibleContext().setAccessibleName("jmnuModificar");

        jmnuSalir.setLabel("Salir");
        jmnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jmnuSalir);
        jmnuSalir.getAccessibleContext().setAccessibleName("jmnuSalir");

        jMenu1.add(jSeparator4);

        jMenuBar1.add(jMenu1);
        jMenu1.getAccessibleContext().setAccessibleName("mnuArchivo");

        mnuReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reporte.png"))); // NOI18N
        mnuReport.setToolTipText("Reporte");
        mnuReport.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuReport.add(jSeparator1);

        jmnuReport.setText("Reporte");
        jmnuReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuReportActionPerformed(evt);
            }
        });
        mnuReport.add(jmnuReport);
        mnuReport.add(jSeparator3);

        jMenuBar1.add(mnuReport);
        mnuReport.getAccessibleContext().setAccessibleName("mnuReporte");

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/baseDatos2.png"))); // NOI18N
        jMenu2.setToolTipText("Base de Datos");
        jMenu2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/baseDatos1.png"))); // NOI18N
        jMenu2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/baseDatos3.png"))); // NOI18N
        jMenu2.add(jSeparator5);

        jmnuAditivos.setText("BD Aditivos");
        jmnuAditivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuAditivosActionPerformed(evt);
            }
        });
        jMenu2.add(jmnuAditivos);

        jmnuPersonal.setText("BD Personal");
        jmnuPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuPersonalActionPerformed(evt);
            }
        });
        jMenu2.add(jmnuPersonal);

        jmnuMaquinaria.setText("BD Maquinaria");
        jmnuMaquinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuMaquinariaActionPerformed(evt);
            }
        });
        jMenu2.add(jmnuMaquinaria);

        jmuHerramientas.setText("BD Herramientas");
        jmuHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmuHerramientasActionPerformed(evt);
            }
        });
        jMenu2.add(jmuHerramientas);

        jmnuSondajes.setText("BD Sondajes");
        jmnuSondajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuSondajesActionPerformed(evt);
            }
        });
        jMenu2.add(jmnuSondajes);

        jmnuCombustibles.setText("BD Combustibles");
        jmnuCombustibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuCombustiblesActionPerformed(evt);
            }
        });
        jMenu2.add(jmnuCombustibles);
        jMenu2.add(jSeparator6);

        jMenuBar1.add(jMenu2);
        jMenu2.getAccessibleContext().setAccessibleName("mnuBD");

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ControlAvances.png"))); // NOI18N
        jMenu3.setToolTipText("Control de Avances");
        jMenu3.add(jSeparator7);

        jmnuAvances.setText("Avances");
        jmnuAvances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuAvancesActionPerformed(evt);
            }
        });
        jMenu3.add(jmnuAvances);

        jmnuCDA.setText("CDA");
        jmnuCDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuCDAActionPerformed(evt);
            }
        });
        jMenu3.add(jmnuCDA);
        jMenu3.add(jSeparator8);

        jMenuBar1.add(jMenu3);
        jMenu3.getAccessibleContext().setAccessibleName("mnuAvancesControl");

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuSalirActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jmnuSalirActionPerformed

    private void jmnuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuModificarActionPerformed
        // TODO add your handling code here:
        ModificarUser modi = new ModificarUser();
        modi.show();
        
    }//GEN-LAST:event_jmnuModificarActionPerformed

    private void jmnuReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuReportActionPerformed
        // TODO add your handling code here:
        Report report = new Report();
        report.show();
    }//GEN-LAST:event_jmnuReportActionPerformed

    private void jmnuAvancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuAvancesActionPerformed
        // TODO add your handling code here:
        Avances avances = new Avances();
        avances.show();
    }//GEN-LAST:event_jmnuAvancesActionPerformed

    private void jmnuCDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuCDAActionPerformed
        // TODO add your handling code here:
        CDA cda = new CDA();
        cda.show();
    }//GEN-LAST:event_jmnuCDAActionPerformed

    private void jmnuAditivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuAditivosActionPerformed
        // TODO add your handling code here:
        BD_Aditivos aditivos = new BD_Aditivos();
        aditivos.show();        
    }//GEN-LAST:event_jmnuAditivosActionPerformed

    private void jmnuPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuPersonalActionPerformed
        // TODO add your handling code here:
        BD_Personal personal = new BD_Personal();
        personal.show();
    }//GEN-LAST:event_jmnuPersonalActionPerformed

    private void jmnuMaquinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuMaquinariaActionPerformed
        // TODO add your handling code here:
        BD_Maquinaria maquinaria = new BD_Maquinaria();
        maquinaria.show();
    }//GEN-LAST:event_jmnuMaquinariaActionPerformed

    private void jmuHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmuHerramientasActionPerformed
        // TODO add your handling code here:
        BD_Herramientas herramientas = new BD_Herramientas();
        herramientas.show();
    }//GEN-LAST:event_jmuHerramientasActionPerformed

    private void jmnuSondajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuSondajesActionPerformed
        // TODO add your handling code here:
        BD_Sondajes sondajes = new BD_Sondajes();
        sondajes.show();
    }//GEN-LAST:event_jmnuSondajesActionPerformed

    private void jmnuCombustiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuCombustiblesActionPerformed
        // TODO add your handling code here:
        BD_Combustibles combustibles = new BD_Combustibles();
        combustibles.show();
    }//GEN-LAST:event_jmnuCombustiblesActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JMenuItem jmnuAditivos;
    private javax.swing.JMenuItem jmnuAvances;
    private javax.swing.JMenuItem jmnuCDA;
    private javax.swing.JMenuItem jmnuCombustibles;
    private javax.swing.JMenuItem jmnuMaquinaria;
    private javax.swing.JMenuItem jmnuModificar;
    private javax.swing.JMenuItem jmnuPersonal;
    private javax.swing.JMenuItem jmnuReport;
    private javax.swing.JMenuItem jmnuSalir;
    private javax.swing.JMenuItem jmnuSondajes;
    private javax.swing.JMenuItem jmuHerramientas;
    private javax.swing.JMenu mnuReport;
    // End of variables declaration//GEN-END:variables
}
