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
import java.util.Date;

/**
 *
 * @author Usuario
 */

public class BDHerramientas extends javax.swing.JFrame {

    /**
     * Creates new form BDHerramientas
     */
    DefaultTableModel model;
    BDConexion bd = new BDConexion();
    Connection cn = bd.conexion();
    Statement sent;
    
    public BDHerramientas() {
        initComponents();
         setLocationRelativeTo(null);
        
        limpiar();
        bloquear();
        cargar("");
        mostrarHerramientas();
    }
    
    void cargar(String valor){
        
        String []titulos={"ID", "Fecha Ing","Gr Ingreso","Descripcion","Diametro","Numero","Tipo","Matriz",
            "Marca","Precio","Estado Llegada","Fecha Nac","Lugar Nac","Lugar Res","Direccion,","Telef Fijo",
            "Celular","Correo","Telef Emerg","Pers Cont","Relac Cont"};  
        
        String []Registros= new String[21];
        
        String sql="SELECT * FROM herramientas WHERE CONCAT(id, fecha_ingreso, gr_ingreso, descripcion, diametro, numero, "
                + "tipo, matriz, marca, precio, estado_llegada, fecha_nacimiento,"
                + "dpto_nacimiento,dpto_residencia, direccion, tel_fijo, celular, email, tel_emergencia, persona_contact,"
                + "relacion_contact) LIKE '%"+valor+"%'";
        
        model=new DefaultTableModel(null,titulos);
        
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next())
             {
                   Registros[0]= rs.getString("id");
                   Registros[1]= rs.getString("fecha_ingreso");
                   Registros[2]= rs.getString("gr_ingreso");
                   Registros[3]= rs.getString("descripcion");
                   Registros[4]= rs.getString("diametro");
                   Registros[5]= rs.getString("numero");
                   Registros[6]= rs.getString("tipo");
                   Registros[7]= rs.getString("matriz");
                   Registros[8]= rs.getString("marca");
                   Registros[9]= rs.getString("precio");
                   Registros[10]= rs.getString("estado_llegada");
                   Registros[11]= rs.getString("fecha_nacimiento");
                   Registros[12]= rs.getString("dpto_nacimiento");
                   Registros[13]= rs.getString("dpto_residencia");
                   Registros[14]= rs.getString("direccion");
                   Registros[15]= rs.getString("tel_fijo");
                   Registros[16]= rs.getString("celular");
                   Registros[17]= rs.getString("email");
                   Registros[18]= rs.getString("tel_emergencia");
                   Registros[19]= rs.getString("persona_contact");
                   Registros[20]= rs.getString("relacion_contact");
             
                  
                   
                   model.addRow(Registros);
             } 
             t_datos.setModel(model);
        } catch (SQLException ex) {
             Logger.getLogger(BDHerramientas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        void mostrarHerramientas(){

            String []titulos={"ID", "Fecha Ing","Gr Ingreso","Descripcion","Diametro","Numero","Tipo","Matriz",
            "Marca","Precio","Estado Llegada","Fecha Nac","Lugar Nac","Lugar Res","Direccion,","Telef Fijo",
            "Celular","Correo","Telef Emerg","Pers Cont","Relac Cont"};   
            
            String []Registros= new String[21];

            String sql="SELECT * FROM herramientas";
            model=new DefaultTableModel(null,titulos);

            try {
                 Statement st = cn.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 while(rs.next())
                 {
                   Registros[0]= rs.getString("id");
                   Registros[1]= rs.getString("fecha_ingreso");
                   Registros[2]= rs.getString("gr_ingreso");
                   Registros[3]= rs.getString("descripcion");
                   Registros[4]= rs.getString("diametro");
                   Registros[5]= rs.getString("numero");
                   Registros[6]= rs.getString("tipo");
                   Registros[7]= rs.getString("matriz");
                   Registros[8]= rs.getString("marca");
                   Registros[9]= rs.getString("precio");
                   Registros[10]= rs.getString("estado_llegada");
                   Registros[11]= rs.getString("fecha_nacimiento");
                   Registros[12]= rs.getString("dpto_nacimiento");
                   Registros[13]= rs.getString("dpto_residencia");
                   Registros[14]= rs.getString("direccion");
                   Registros[15]= rs.getString("tel_fijo");
                   Registros[16]= rs.getString("celular");
                   Registros[17]= rs.getString("email");
                   Registros[18]= rs.getString("tel_emergencia");
                   Registros[19]= rs.getString("persona_contact");
                   Registros[20]= rs.getString("relacion_contact");
                       
                       model.addRow(Registros);
                 } 
                 t_datos.setModel(model);
            } catch (SQLException ex) {
                 Logger.getLogger(BDHerramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        void limpiar(){
        //cFechaIngreso.setDate("");
            txtGr_Ing.setText ("");
            txtDescripcion.setText ("");
            txtDiametro.setText ("");
            txtNumero.setText ("");
            txtTipo.setText ("");
            txtMatriz.setText ("");
            txtMarca.setText ("");
            txtPrecio.setText ("");
            txtEstado_Llegada.setText ("");

            txtFechaNac.setText ("");
            //txtDptorNac.setText ("");
            //txtDptoRes.setText ("");
            txtDireccion.setText ("");
            /*txtTelefono.setText ("");
            txtCelular.setText ("");
            txtCorreo.setText ("");
            txtTelefEmerg.setText ("");
            txtPersCont.setText ("");
            txtRelacCont.setText ("");*/
        }

        void bloquear(){
            //cFechaIngreso.setDate(false);
            txtGr_Ing.setEnabled(false);
            txtDescripcion.setEnabled(false);
            txtDiametro.setEnabled(false);
            txtNumero.setEnabled(false);

            txtTipo.setEnabled(false);
            txtMatriz.setEnabled(false);
            txtMarca.setEnabled(false);
            txtPrecio.setEnabled(false);
            txtEstado_Llegada.setEnabled(false);

            txtFechaNac.setEnabled(false);
            /*cmbDptoNac.setEnabled(false);
            cmbDptoRes.setEnabled(false);
            txtDireccion.setEnabled(false);
            txtTelefono.setEnabled(false);

            txtCelular.setEnabled(false);
            txtCorreo.setEnabled(false);
            txtTelefEmerg.setEnabled(false);
            txtPersCont.setEnabled(false);
            txtRelacCont.setEnabled(false);*/

            btnNuevo.setEnabled(true);
            btnGuardar.setEnabled(false);

        }

        void desbloquear(){

            //cFechaIngreso.setDate(true);
            txtGr_Ing.setEnabled(true);
            txtDescripcion.setEnabled(true);
            txtDiametro.setEnabled(true);
            txtNumero.setEnabled(true);

            txtTipo.setEnabled(true);
            txtMatriz.setEnabled(true);
            txtMarca.setEnabled(true);
            txtPrecio.setEnabled(true);
            txtEstado_Llegada.setEnabled(true);

            txtFechaNac.setEnabled(true);
            /*cmbDptoNac.setEnabled(true);
            cmbDptoRes.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtTelefono.setEnabled(true);

            txtCelular.setEnabled(true);
            txtCorreo.setEnabled(true);
            txtTelefEmerg.setEnabled(true);
            txtPersCont.setEnabled(true);
            txtRelacCont.setEnabled(true);*/

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

        jLabel15 = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        txtGr_Ing = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        txtMatriz = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDiametro = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtMarca = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtEstado_Llegada = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        cFechaIngreso = new com.toedter.calendar.JDateChooser();
        txtFechaNac1 = new javax.swing.JTextField();
        cFechaRetorno = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel15.setText("Marca :");

        txtFechaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacActionPerformed(evt);
            }
        });

        jLabel16.setText("Fecha Retorno");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtGr_Ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGr_IngActionPerformed(evt);
            }
        });

        jLabel5.setText("Descripcion :");

        btnMostrar.setText("Mostrar Herramientas");
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

        txtMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatrizActionPerformed(evt);
            }
        });

        jLabel9.setText("Matriz :");

        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo :");

        jLabel6.setText("Diametro :");

        jLabel7.setText("Buscar :");

        txtDiametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiametroActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Numero :");

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

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel3.setText("G. R. Ingreso :");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        jLabel14.setText("Condicion de Retorno");

        txtEstado_Llegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstado_LlegadaActionPerformed(evt);
            }
        });

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel10.setText("Estado de Llegada :");

        jLabel11.setText("Precio Dolares :");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jLabel12.setText("Tipo de Desgaste");

        jLabel13.setText("G. R. Retorno");

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        jLabel1.setText("Base de Datos Herramientas");

        jLabel2.setText("Fecha Ingreso :");

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        txtFechaNac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNac1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(txtEstado_Llegada, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(txtMatriz))
                            .addComponent(cFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtGr_Ing)
                                .addComponent(txtDescripcion)
                                .addComponent(txtDiametro)
                                .addComponent(txtNumero)
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFechaNac)
                            .addComponent(txtDireccion)
                            .addComponent(txtFechaNac1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cFechaRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(130, 130, 130))
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
                    .addComponent(btnMostrar))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel14)
                        .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGr_Ing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstado_Llegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(cFechaRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(txtFechaNac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacActionPerformed
        // TODO add your handling code here:
         txtFechaNac.transferFocus();
    }//GEN-LAST:event_txtFechaNacActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = t_datos.getSelectedRow();
            String sql = "delete from herramientas where id=" + t_datos.getValueAt(fila, 0);
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

    private void txtGr_IngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGr_IngActionPerformed
        // TODO add your handling code here:
        txtGr_Ing.transferFocus();
    }//GEN-LAST:event_txtGr_IngActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        mostrarHerramientas();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
        cargar(txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        // TODO add your handling code here:
        cargar(txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void txtMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatrizActionPerformed
        // TODO add your handling code here:
         txtMatriz.transferFocus();
    }//GEN-LAST:event_txtMatrizActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
         txtTipo.transferFocus();
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtDiametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiametroActionPerformed
        // TODO add your handling code here:
        txtDiametro.transferFocus();
    }//GEN-LAST:event_txtDiametroActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        /*try {
            desbloquear();
            String sql = "Update herramientas set fecha_ingreso=?, gr_ingreso=?, descripcion=?, diametro=?, "
                    + "numero=?,tipo=?, matriz=?, marca=?, "
                    + "precio=?, estado_llegada=?, fecha_nacimiento=?,dpto_nacimiento=?,dpto_residencia=?,direccion=?,"
                    + "tel_fijo=?,celular=?,email=?,tel_emergencia=?,persona_contact=?,relacion_contact=?"+ "where id=?";
            
          
            int fila = t_datos.getSelectedRow();
            String dao = (String) t_datos.getValueAt(fila, 0);
            PreparedStatement ps = cn.prepareStatement(sql);
                        
            ps.setString(1, txtFecha_Ing.getText());
            ps.setString(2, txtGr_Ing.getText());
            ps.setString(3, txtDescripcion.getText());
            ps.setString(4, txtDiametro.getText());
            ps.setString(5, txtNumero.getText());
            ps.setString(6, txtTipo.getText());
            ps.setString(7, txtMatriz.getText());
            ps.setString(8, txtMarca.getText());
            ps.setString(9,  txtPrecio.getText());
            ps.setString(10, txtEstado_Llegada.getText());
             
            ps.setString(11, txtFechaNac.getText());
            ps.setString(12, cmbDptoNac.getSelectedItem().toString());
            ps.setString(13, cmbDptoRes.getSelectedItem().toString());
            ps.setString(14, txtDireccion.getText());
            ps.setString(15, txtTelefono.getText());
            ps.setString(16, txtCelular.getText());
            ps.setString(17, txtCorreo.getText());
            ps.setString(18, txtTelefEmerg.getText());
            ps.setString(19, txtPersCont.getText());
            ps.setString(20, txtRelacCont.getText());
            ps.setString(21, dao);

            int n = ps.executeUpdate();
            if (n > 0) {
                limpiar();
                mostrarHerramientas();
                JOptionPane.showMessageDialog(null, "Datos Modificados");
                bloquear();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }*/
    }//GEN-LAST:event_btnModificarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
         /*if (evt.getButton() == 1) {
            int fila = t_datos.getSelectedRow();
            try {
                desbloquear();
                String sql = "select * from herramientas where id=" + t_datos.getValueAt(fila, 0);
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                
                txtFecha_Ing.setText(rs.getString("fecha_ingreso"));
                txtGr_Ing.setText(rs.getString("gr_ingreso"));
                txtDescripcion.setText(rs.getString("descripcion"));
                txtDiametro.setText(rs.getString("diametro"));
                txtNumero.setText(rs.getString("numero"));
                txtTipo.setText(rs.getString("tipo"));
                txtMatriz.setText(rs.getString("matriz"));
                txtMarca.setText(rs.getString("marca"));
                txtPrecio.setText(rs.getString("precio"));
                txtEstado_Llegada.setText(rs.getString("estado_llegada"));
                
                txtFechaNac.setText(rs.getString("fecha_nacimiento"));
                cmbDptoNac.setSelectedItem(rs.getString("dpto_nacimiento"));
                cmbDptoRes.setSelectedItem(rs.getString("dpto_residencia"));
                txtDireccion.setText(rs.getString("direccion"));
                txtTelefono.setText(rs.getString("tel_fijo"));
                
                txtCelular.setText(rs.getString("celular"));
                txtCorreo.setText(rs.getString("email"));
                txtTelefEmerg.setText(rs.getString("tel_emergencia"));
                txtPersCont.setText(rs.getString("persona_contact"));
                txtRelacCont.setText(rs.getString("relacion_contact"));

           
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }*/
    }//GEN-LAST:event_t_datosMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        desbloquear();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

       
        /*String  fecha_ingreso, gr_ingreso, descripcion, diametro, tipo, matriz, 
                marca, precio, estado_llegada,fecha_nacimiento,dpto_nacimiento,
                dpto_residencia, direccion, email,persona_contact,relacion_contact;
        
        int numero, tel_fijo, celular,tel_emergencia;
        
        String sql = "";
        fecha_ingreso = cFechaIngreso.getDate().toString();
        gr_ingreso = txtGr_Ing.getText();
        descripcion = txtDescripcion.getText();
        diametro = txtDiametro.getText();
        numero = (Integer.parseInt( txtNumero.getText()));
        tipo = txtTipo.getText();
        matriz = txtMatriz.getText();
        marca = txtMarca.getText();
        precio = txtPrecio.getText();
        estado_llegada = txtEstado_Llegada.getText();
        
        fecha_nacimiento = txtFechaNac.getText();
        dpto_nacimiento = cmbDptoNac.getSelectedItem().toString();
        dpto_residencia = cmbDptoRes.getSelectedItem().toString();
        direccion = txtDireccion.getText();
        tel_fijo = (Integer.parseInt(txtTelefono.getText()));
        celular = (Integer.parseInt(txtCelular.getText()));
        email = txtCorreo.getText();
        tel_emergencia = (Integer.parseInt(txtTelefEmerg.getText()));
        persona_contact = txtPersCont.getText();
        relacion_contact = txtRelacCont.getText();
        


        sql = "INSERT INTO herramientas ( fecha_ingreso, gr_ingreso, descripcion, diametro, numero,"
                + "tipo, matriz, marca, precio, estado_llegada, fecha_nacimiento,"
                + "dpto_nacimiento,dpto_residencia, direccion, tel_fijo, celular, email, tel_emergencia, persona_contact,"
                + "relacion_contact) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fecha_ingreso);
            pst.setString(2, gr_ingreso);
            pst.setString(3, descripcion);
            pst.setString(4, diametro);
            pst.setInt(5, numero);
            pst.setString(6, tipo);
            pst.setString(7, matriz);
            pst.setString(8, marca);
            pst.setString(9, precio);
            pst.setString(10, estado_llegada);
            
            pst.setString(11, fecha_nacimiento);
            pst.setString(12, dpto_nacimiento);
            pst.setString(13, dpto_residencia);
            pst.setString(14, direccion);
            pst.setInt(15, tel_fijo);
            pst.setInt(16, celular);
            pst.setString(17, email);
            pst.setInt(18, tel_emergencia);
            pst.setString(19, persona_contact);
            pst.setString(20, relacion_contact);

            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado con exito");
                bloquear();
                btnNuevo.setEnabled(true);
                btnGuardar.setEnabled(false);
                cargar("");

            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }*/
                       
   }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
         txtMarca.transferFocus();
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtEstado_LlegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstado_LlegadaActionPerformed
        // TODO add your handling code here:
         txtEstado_Llegada.transferFocus();
    }//GEN-LAST:event_txtEstado_LlegadaActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
         txtPrecio.transferFocus();
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
         txtDireccion.transferFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
        txtDescripcion.transferFocus();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
        txtNumero.transferFocus();
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void txtFechaNac1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNac1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNac1ActionPerformed

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
            java.util.logging.Logger.getLogger(BDHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BDHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BDHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BDHerramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BDHerramientas().setVisible(true);
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
    private com.toedter.calendar.JDateChooser cFechaIngreso;
    private com.toedter.calendar.JDateChooser cFechaRetorno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDiametro;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEstado_Llegada;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtFechaNac1;
    private javax.swing.JTextField txtGr_Ing;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatriz;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
