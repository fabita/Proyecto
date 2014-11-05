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
public class BD_Personal extends javax.swing.JFrame {

    /**
     * Creates new form BD_Personal
     */
    DefaultTableModel model;
    BDConexion bd = new BDConexion();
    Connection cn = bd.conexion();
    Statement sent;
    
    public BD_Personal() {
        initComponents();
      
        
        setLocationRelativeTo(null);
        
        limpiar();
        bloquear();
        cargar("");
        mostrarPersonal();
    }
    
    void cargar(String valor){
        
        String []titulos={"ID", "Cod Emp","DNI","Nombres","Apellidos","Cargo Proy","Brevete","Fotocheck",
            "Venc Fot","IPSS","Tipo Sangre","Fecha Nac","Lugar Nac","Lugar Res","Direccion,","Telef Fijo",
            "Celular","Correo","Telef Emerg","Pers Cont","Relac Cont"};  
        
        String []Registros= new String[21];
        
        String sql="SELECT * FROM personal WHERE CONCAT(id, codigo_empresa, DNI, nombres, apellidos, Cargo_Proyecto, "
                + "brevete, fotocheck_minero, vencimiento_fotocheck, IPSS, tip_Sangre, fecha_nacimiento,"
                + "dpto_nacimiento,dpto_residencia, direccion, tel_fijo, celular, email, tel_emergencia, persona_contact,"
                + "relacion_contact) LIKE '%"+valor+"%'";
        model=new DefaultTableModel(null,titulos);
        
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next())
             {
                   Registros[0]= rs.getString("id");
                   Registros[1]= rs.getString("codigo_empresa");
                   Registros[2]= rs.getString("DNI");
                   Registros[3]= rs.getString("nombres");
                   Registros[4]= rs.getString("apellidos");
                   Registros[5]= rs.getString("Cargo_Proyecto");
                   Registros[6]= rs.getString("brevete");
                   Registros[7]= rs.getString("fotocheck_minero");
                   Registros[8]= rs.getString("vencimiento_fotocheck");
                   Registros[9]= rs.getString("IPSS");
                   Registros[10]= rs.getString("tip_Sangre");
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
             Logger.getLogger(BD_Personal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        void mostrarPersonal(){

            String []titulos={"ID", "Cod Emp","DNI","Nombres","Apellidos","Cargo Proy","Brevete","Fotocheck",
            "Venc Fot","IPSS","Tipo Sangre","Fecha Nac","Lugar Nac","Lugar Res","Direccion,","Telef Fijo",
            "Celular","Correo","Telef Emerg","Pers Cont","Relac Cont"};  
            
            String []Registros= new String[21];

            String sql="SELECT * FROM personal";
            model=new DefaultTableModel(null,titulos);

            try {
                 Statement st = cn.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 while(rs.next())
                 {
                   Registros[0]= rs.getString("id");
                   Registros[1]= rs.getString("codigo_empresa");
                   Registros[2]= rs.getString("DNI");
                   Registros[3]= rs.getString("nombres");
                   Registros[4]= rs.getString("apellidos");
                   Registros[5]= rs.getString("Cargo_Proyecto");
                   Registros[6]= rs.getString("brevete");
                   Registros[7]= rs.getString("fotocheck_minero");
                   Registros[8]= rs.getString("vencimiento_fotocheck");
                   Registros[9]= rs.getString("IPSS");
                   Registros[10]= rs.getString("tip_Sangre");
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
                 Logger.getLogger(BD_Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        void limpiar(){
        txtCodEmp.setText ("");
        txtDni.setText ("");
        txtNombres.setText ("");
        txtApellidos.setText ("");
        txtCargoProy.setText ("");
        txtBrevete.setText ("");
        txtFotocheck.setText ("");
        txtVencFotoch.setText ("");
        txtIpss.setText ("");
        //cmbTipoSangre.setText ("");
       
        txtFechaNac.setText ("");
        //txtDptorNac.setText ("");
        //txtDptoRes.setText ("");
        txtDireccion.setText ("");
        txtTelefono.setText ("");
        txtCelular.setText ("");
        txtCorreo.setText ("");
        txtTelefEmerg.setText ("");
        txtPersCont.setText ("");
        txtRelacCont.setText ("");
        }

        void bloquear(){
        txtCodEmp.setEnabled(false);
        txtDni.setEnabled(false);
        txtNombres.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtCargoProy.setEnabled(false);
        
        txtBrevete.setEnabled(false);
        txtFotocheck.setEnabled(false);
        txtVencFotoch.setEnabled(false);
        txtIpss.setEnabled(false);
        cmbTipoSangre.setEnabled(false);
        
        txtFechaNac.setEnabled(false);
        cmbDptoNac.setEnabled(false);
        cmbDptoRes.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        
        txtCelular.setEnabled(false);
        txtCorreo.setEnabled(false);
        txtTelefEmerg.setEnabled(false);
        txtPersCont.setEnabled(false);
        txtRelacCont.setEnabled(false);

        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);

        }

        void desbloquear(){
        txtCodEmp.setEnabled(true);
        txtDni.setEnabled(true);
        txtNombres.setEnabled(true);
        txtApellidos.setEnabled(true);
        txtCargoProy.setEnabled(true);
        
        txtBrevete.setEnabled(true);
        txtFotocheck.setEnabled(true);
        txtVencFotoch.setEnabled(true);
        txtIpss.setEnabled(true);
        cmbTipoSangre.setEnabled(true);
        
        txtFechaNac.setEnabled(true);
        cmbDptoNac.setEnabled(true);
        cmbDptoRes.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        
        txtCelular.setEnabled(true);
        txtCorreo.setEnabled(true);
        txtTelefEmerg.setEnabled(true);
        txtPersCont.setEnabled(true);
        txtRelacCont.setEnabled(true);

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
        txtCargoProy = new javax.swing.JTextField();
        txtCodEmp = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        txtApellidos = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBrevete = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFotocheck = new javax.swing.JTextField();
        txtIpss = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtVencFotoch = new javax.swing.JTextField();
        txtFechaNac = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTelefEmerg = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtPersCont = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtRelacCont = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cmbTipoSangre = new javax.swing.JComboBox();
        cmbDptoNac = new javax.swing.JComboBox();
        cmbDptoRes = new javax.swing.JComboBox();

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

        jLabel3.setText("DNI :");

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

        txtCargoProy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoProyActionPerformed(evt);
            }
        });

        txtCodEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodEmpActionPerformed(evt);
            }
        });

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        jLabel1.setText("Base de Datos Personal");

        jLabel2.setText("Codigo Empresa :");

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

        btnMostrar.setText("Mostrar Datos Personal");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombres :");

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel4.setText("Cargo en Proyecto :");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Apellidos :");

        jLabel7.setText("Buscar :");

        jLabel8.setText("Brevete :");

        txtBrevete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBreveteActionPerformed(evt);
            }
        });

        jLabel9.setText("Fotockeck :");

        txtFotocheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFotocheckActionPerformed(evt);
            }
        });

        txtIpss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIpssActionPerformed(evt);
            }
        });

        jLabel10.setText("Tipo de Sangre :");

        jLabel11.setText("IPSS :");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jLabel12.setText("Direccion :");

        jLabel13.setText("Lugar de Residencia :");

        jLabel14.setText("Fecha de Nacimiento :");

        txtVencFotoch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVencFotochActionPerformed(evt);
            }
        });

        txtFechaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacActionPerformed(evt);
            }
        });

        jLabel15.setText("Vencimiento Fotocheck :");

        jLabel16.setText("Lugar de Nacimiento :");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        jLabel17.setText("Telefono Fijo :");

        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        jLabel18.setText("Celular :");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        jLabel19.setText("Correo Electronico :");

        txtTelefEmerg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefEmergActionPerformed(evt);
            }
        });

        jLabel20.setText("Telef. Emergencia");

        txtPersCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersContActionPerformed(evt);
            }
        });

        jLabel21.setText("Persona Contact.");

        txtRelacCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRelacContActionPerformed(evt);
            }
        });

        jLabel22.setText("Relacion Contact.");

        cmbTipoSangre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A+", "A- ", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        cmbDptoNac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Amazonas", "Ancash", "Apurimac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huanuco", "Ica", "Junin", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre De Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martin", "Tacna", "Tumbes", "Ucayali" }));

        cmbDptoRes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Amazonas", "Ancash", "Apurimac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huanuco", "Ica", "Junin", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre De Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martin", "Tacna", "Tumbes", "Ucayali" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                        .addComponent(btnMostrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnNuevo)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIpss, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addComponent(txtVencFotoch, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addComponent(cmbTipoSangre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtFotocheck)
                                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(93, 93, 93)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel16)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel17)
                                                    .addComponent(jLabel18)
                                                    .addComponent(jLabel19)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel20)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel22)
                                                            .addComponent(jLabel21))
                                                        .addComponent(btnModificar))))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDni)
                                        .addComponent(txtCodEmp)
                                        .addComponent(txtNombres)
                                        .addComponent(txtApellidos)
                                        .addComponent(txtCargoProy)
                                        .addComponent(txtBrevete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(btnEliminar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addComponent(cmbDptoNac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbDptoRes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtDireccion)
                                            .addComponent(txtTelefono)
                                            .addComponent(txtCelular)
                                            .addComponent(txtCorreo)
                                            .addComponent(txtTelefEmerg)
                                            .addComponent(txtPersCont)
                                            .addComponent(txtRelacCont)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jLabel1)))))
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCargoProy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel17))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBrevete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFotocheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVencFotoch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIpss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(cmbTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cmbDptoNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cmbDptoRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefEmerg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPersCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRelacCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo)
                        .addComponent(btnModificar)
                        .addComponent(btnEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnMostrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        //ConexionBD con = new ConexionBD();
        //Connection cn = con.Conexion();
        
        String  nombres, apellidos, Cargo_Proyecto, brevete, fotocheck_minero, 
                vencimiento_fotocheck, IPSS, tip_Sangre,fecha_nacimiento,dpto_nacimiento,
                dpto_residencia, direccion, email,persona_contact,relacion_contact;
        
        int codigo_empresa, DNI,tel_fijo, celular,tel_emergencia;
        
        String sql = "";
        codigo_empresa = (Integer.parseInt(txtCodEmp.getText()));
        DNI = (Integer.parseInt(txtDni.getText()));
        nombres = txtNombres.getText();
        apellidos = txtApellidos.getText();
        Cargo_Proyecto = txtCargoProy.getText();
        brevete = txtBrevete.getText();
        fotocheck_minero = txtFotocheck.getText();
        vencimiento_fotocheck = txtVencFotoch.getText();
        IPSS = txtIpss.getText();
        tip_Sangre = cmbTipoSangre.getSelectedItem().toString();
        
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
        


        sql = "INSERT INTO personal ( codigo_empresa, DNI, nombres, apellidos, Cargo_Proyecto,"
                + "brevete, fotocheck_minero, vencimiento_fotocheck, IPSS, tip_Sangre, fecha_nacimiento,"
                + "dpto_nacimiento,dpto_residencia, direccion, tel_fijo, celular, email, tel_emergencia, persona_contact,"
                + "relacion_contact) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, codigo_empresa);
            pst.setInt(2, DNI);
            pst.setString(3, nombres);
            pst.setString(4, apellidos);
            pst.setString(5, Cargo_Proyecto);
            pst.setString(6, brevete);
            pst.setString(7, fotocheck_minero);
            pst.setString(8, vencimiento_fotocheck);
            pst.setString(9, IPSS);
            pst.setString(10, tip_Sangre);
            
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
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            int fila = t_datos.getSelectedRow();
            try {
                desbloquear();
                String sql = "select * from personal where id=" + t_datos.getValueAt(fila, 0);
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                
                txtCodEmp.setText(rs.getString("codigo_empresa"));
                txtDni.setText(rs.getString("DNI"));
                txtNombres.setText(rs.getString("nombres"));
                txtApellidos.setText(rs.getString("apellidos"));
                txtCargoProy.setText(rs.getString("Cargo_Proyecto"));
                txtBrevete.setText(rs.getString("brevete"));
                txtFotocheck.setText(rs.getString("fotocheck_minero"));
                txtVencFotoch.setText(rs.getString("vencimiento_fotocheck"));
                txtIpss.setText(rs.getString("IPSS"));
                cmbTipoSangre.setSelectedItem(rs.getString("tip_Sangre"));
                
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
        }
    }//GEN-LAST:event_t_datosMouseClicked

    private void txtCargoProyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoProyActionPerformed
        // TODO add your handling code here:
        txtCargoProy.transferFocus();
    }//GEN-LAST:event_txtCargoProyActionPerformed

    private void txtCodEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodEmpActionPerformed
        // TODO add your handling code here:
        txtCodEmp.transferFocus();
    }//GEN-LAST:event_txtCodEmpActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
        txtNombres.transferFocus();
    }//GEN-LAST:event_txtNombresActionPerformed

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
        mostrarPersonal();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
        txtDni.transferFocus();
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = t_datos.getSelectedRow();
            String sql = "delete from personal where id=" + t_datos.getValueAt(fila, 0);
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n > 0) {
                mostrarPersonal();
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
            String sql = "Update personal set codigo_empresa=?, DNI=?, nombres=?, apellidos=?, "
                    + "Cargo_Proyecto=?,brevete=?, fotocheck_minero=?, vencimiento_fotocheck=?, "
                    + "IPSS=?, tip_Sangre=?, fecha_nacimiento=?,dpto_nacimiento=?,dpto_residencia=?,direccion=?,"
                    + "tel_fijo=?,celular=?,email=?,tel_emergencia=?,persona_contact=?,relacion_contact=?"+ "where id=?";
            
          
            int fila = t_datos.getSelectedRow();
            String dao = (String) t_datos.getValueAt(fila, 0);
            PreparedStatement ps = cn.prepareStatement(sql);
                        
            ps.setString(1, txtCodEmp.getText());
            ps.setString(2, txtDni.getText());
            ps.setString(3, txtNombres.getText());
            ps.setString(4, txtApellidos.getText());
            ps.setString(5, txtCargoProy.getText());
            ps.setString(6, txtBrevete.getText());
            ps.setString(7, txtFotocheck.getText());
            ps.setString(8, txtVencFotoch.getText());
            ps.setString(9, txtIpss.getText());
            ps.setString(10, cmbTipoSangre.getSelectedItem().toString());
             
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
                mostrarPersonal();
                JOptionPane.showMessageDialog(null, "Datos Modificados");
                bloquear();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
        txtApellidos.transferFocus();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBreveteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBreveteActionPerformed
        // TODO add your handling code here:
        txtBrevete.transferFocus();
    }//GEN-LAST:event_txtBreveteActionPerformed

    private void txtFotocheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFotocheckActionPerformed
        // TODO add your handling code here:
        txtFotocheck.transferFocus();
    }//GEN-LAST:event_txtFotocheckActionPerformed

    private void txtIpssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIpssActionPerformed
        // TODO add your handling code here:
        txtIpss.transferFocus();
    }//GEN-LAST:event_txtIpssActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        txtDireccion.transferFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtVencFotochActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVencFotochActionPerformed
        // TODO add your handling code here:
        txtVencFotoch.transferFocus();
    }//GEN-LAST:event_txtVencFotochActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        txtTelefono.transferFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
        txtCelular.transferFocus();
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
        txtCorreo.transferFocus();
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtTelefEmergActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefEmergActionPerformed
        // TODO add your handling code here:
        txtTelefEmerg.transferFocus();
    }//GEN-LAST:event_txtTelefEmergActionPerformed

    private void txtPersContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersContActionPerformed
        // TODO add your handling code here:
        txtPersCont.transferFocus();
    }//GEN-LAST:event_txtPersContActionPerformed

    private void txtRelacContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRelacContActionPerformed
        // TODO add your handling code here:
        txtRelacCont.transferFocus();
    }//GEN-LAST:event_txtRelacContActionPerformed

    private void txtFechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacActionPerformed
        // TODO add your handling code here:
        txtFechaNac.transferFocus();
    }//GEN-LAST:event_txtFechaNacActionPerformed

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
            java.util.logging.Logger.getLogger(BD_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BD_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BD_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BD_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BD_Personal().setVisible(true);
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
    private javax.swing.JComboBox cmbDptoNac;
    private javax.swing.JComboBox cmbDptoRes;
    private javax.swing.JComboBox cmbTipoSangre;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBrevete;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCargoProy;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodEmp;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtFotocheck;
    private javax.swing.JTextField txtIpss;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPersCont;
    private javax.swing.JTextField txtRelacCont;
    private javax.swing.JTextField txtTelefEmerg;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtVencFotoch;
    // End of variables declaration//GEN-END:variables
}
