/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.vistas;

import com.guilleminio.emails.controladora.ModificarCuentaControladora;
import com.guilleminio.emails.utilidades.Utilidades;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Guille
 */
public class frmModificarCuenta extends javax.swing.JFrame implements IVentana {

    private JFileChooser jImgFileChooser;
    
    private byte[] imagenGuardar;
    private FileOutputStream streamOut;
    
    private Icon imagenPorDefecto;
    
    private int idUsuario;
    private boolean cambioImagen;
    
    private ModificarCuentaControladora controladora;
    /**
     * Creates new form frmModificarCuenta
     */
    public frmModificarCuenta( int aIdUsuario ) {
        initComponents();
        this.idUsuario = aIdUsuario;
        inicializarVentana();
    }

    private void cargarImagenUsuario( JLabel aLabel, String aImgPath ){
        
        ImageIcon img = new ImageIcon(aImgPath);
        
        if ( (aImgPath == null) || (img.getImageLoadStatus() == MediaTracker.ERRORED)){
            
            img = new ImageIcon("res\\imagenes_usuarios\\user_default.jpg");
        }
        Icon icon = new ImageIcon(img.getImage().getScaledInstance(aLabel.getPreferredSize().width, aLabel.getPreferredSize().width, Image.SCALE_DEFAULT));
        
        aLabel.setIcon(icon);
        
    }
    
     /*------------------------------------------------*/
    //             PROCESAMIENTO DE IMAGEN            //  
    private void cargarImagenDefault(){
        
        ImageIcon imagen_perfil = new ImageIcon("res\\imagenes_usuarios\\user_default.jpg");
        
        this.imagenPorDefecto = new ImageIcon(imagen_perfil.getImage().getScaledInstance(this.jLImagenUsuario.getPreferredSize().width, this.jLImagenUsuario.getPreferredSize().width, Image.SCALE_DEFAULT));
        this.jLImagenUsuario.setText("");
        this.jLImagenUsuario.setIcon(this.imagenPorDefecto);
    }
    
    private String generarImagenUsuario(){
        
        String urlPath = null;
        
        if ( this.jImgFileChooser != null ){
            
            File imagen = this.jImgFileChooser.getSelectedFile();
            
            try
            {
                BufferedImage originalImage = ImageIO.read(imagen);
            
                urlPath = Utilidades.DEFAULT_PATH_USER_PROFILE + this.idUsuario + Utilidades.DEFAULT_IMAGE_EXTENSION;
            
                ImageIO.write(originalImage, "jpg", new File(urlPath));
                return urlPath;
            } 
            catch (IOException e ) 
            {
                e.printStackTrace();
            }
           
       }
       
       return null;
    }
    
    //      FIN PROCESAMIENTO DE IMAGEN                //
    /*------------------------------------------------*/
    
    private boolean formularioContraseniaCompleto(){
        
        limpiarErrores();
        
        if ( this.jPassTextContrasenia.getPassword().length == 0){
            this.jLbErrorContraseniaActual.setText("Tenés que indicar una contrasenia");
            this.jLbErrorContraseniaActual.setVisible(true);
            return false;
        }
        
        if ( !String.valueOf(this.jPassTextContrasenia.getPassword()).equals(this.controladora.obtenerUsuario().getContraseniaUsuario())){
            this.jLbErrorContraseniaActual.setText("La cotraseña ingresada es incorrecta");
            this.jLbErrorContraseniaActual.setVisible(true);
            return false;
        }
        
        if ( this.jPassTextContraseniaNueva.getPassword().length == 0){
            this.jLbErrorContraseniaNueva.setVisible(true);
            return false;
        }
        
        if ( this.jPassTextConfirmarContrasenia.getPassword().length == 0){
            this.jLbErrorConfirmarContrasenia.setText("Tenés que confirmar la contraseña");
            this.jLbErrorConfirmarContrasenia.setVisible(true);
            return false;
        }
        
        if ( !String.valueOf(this.jPassTextContraseniaNueva.getPassword()).equals(String.valueOf(this.jPassTextConfirmarContrasenia.getPassword()))){
            this.jLbErrorConfirmarContrasenia.setText("Las contraseñas no coinciden");
            this.jLbErrorConfirmarContrasenia.setVisible(true);
            return false;
        }
        
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBtnCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLImagenUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextApellido = new javax.swing.JTextField();
        jBtnCambiarImagen = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPassTextContrasenia = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jLbErrorContraseniaActual = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPassTextContraseniaNueva = new javax.swing.JPasswordField();
        jPanel8 = new javax.swing.JPanel();
        jLbErrorContraseniaNueva = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPassTextConfirmarContrasenia = new javax.swing.JPasswordField();
        jPanel11 = new javax.swing.JPanel();
        jLbErrorConfirmarContrasenia = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jBtnCambiarContrasenia = new javax.swing.JButton();
        jLbErrorNombre = new javax.swing.JLabel();
        jLbErrorApellido = new javax.swing.JLabel();
        jLabelFechaAlta = new javax.swing.JLabel();
        jPanelFooter = new javax.swing.JPanel();
        jBtnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 830));
        setName("frmModificarCuenta"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 830));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanelHeader.setBackground(new java.awt.Color(51, 153, 255));
        jPanelHeader.setMaximumSize(new java.awt.Dimension(800, 80));
        jPanelHeader.setMinimumSize(new java.awt.Dimension(800, 80));
        jPanelHeader.setPreferredSize(new java.awt.Dimension(800, 80));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MODIFICAR CUENTA");

        jBtnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/cerrar_celeste_30.jpg"))); // NOI18N
        jBtnCerrar.setBorderPainted(false);
        jBtnCerrar.setContentAreaFilled(false);
        jBtnCerrar.setMaximumSize(new java.awt.Dimension(30, 30));
        jBtnCerrar.setMinimumSize(new java.awt.Dimension(30, 30));
        jBtnCerrar.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnCerrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/cerrar_celeste_30_presionado.jpg"))); // NOI18N
        jBtnCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/cerrar_celeste_30_presionado.jpg"))); // NOI18N
        jBtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(169, 169, 169)
                .addComponent(jBtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanelHeader);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 670));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 670));

        jLImagenUsuario.setText("jLabel3");
        jLImagenUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLImagenUsuario.setMaximumSize(new java.awt.Dimension(230, 230));
        jLImagenUsuario.setMinimumSize(new java.awt.Dimension(230, 230));
        jLImagenUsuario.setPreferredSize(new java.awt.Dimension(230, 230));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Nombre:");

        jTextNombre.setBackground(new java.awt.Color(255, 255, 255));
        jTextNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextNombre.setMaximumSize(new java.awt.Dimension(450, 30));
        jTextNombre.setMinimumSize(new java.awt.Dimension(450, 30));
        jTextNombre.setPreferredSize(new java.awt.Dimension(450, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Apellido:");

        jTextApellido.setBackground(new java.awt.Color(255, 255, 255));
        jTextApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextApellido.setMaximumSize(new java.awt.Dimension(450, 30));
        jTextApellido.setMinimumSize(new java.awt.Dimension(450, 30));
        jTextApellido.setPreferredSize(new java.awt.Dimension(450, 30));

        jBtnCambiarImagen.setBackground(new java.awt.Color(51, 153, 255));
        jBtnCambiarImagen.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBtnCambiarImagen.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCambiarImagen.setText("CAMBIAR");
        jBtnCambiarImagen.setBorderPainted(false);
        jBtnCambiarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCambiarImagenActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambiar contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(620, 305));
        jPanel2.setMinimumSize(new java.awt.Dimension(620, 305));
        jPanel2.setPreferredSize(new java.awt.Dimension(620, 305));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(570, 40));
        jPanel3.setMinimumSize(new java.awt.Dimension(570, 40));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(240, 40));
        jPanel4.setMinimumSize(new java.awt.Dimension(240, 40));
        jPanel4.setPreferredSize(new java.awt.Dimension(240, 40));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Contraseña actual:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel3.add(jPanel4);

        jPassTextContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        jPassTextContrasenia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPassTextContrasenia.setMaximumSize(new java.awt.Dimension(290, 30));
        jPassTextContrasenia.setMinimumSize(new java.awt.Dimension(290, 30));
        jPassTextContrasenia.setPreferredSize(new java.awt.Dimension(290, 30));
        jPanel3.add(jPassTextContrasenia);

        jPanel2.add(jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(570, 30));
        jPanel5.setMinimumSize(new java.awt.Dimension(570, 30));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 80, 5));

        jLbErrorContraseniaActual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbErrorContraseniaActual.setForeground(new java.awt.Color(255, 0, 0));
        jLbErrorContraseniaActual.setText("Tenés que indicar una contraseña");
        jPanel5.add(jLbErrorContraseniaActual);

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(570, 40));
        jPanel6.setMinimumSize(new java.awt.Dimension(570, 40));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMaximumSize(new java.awt.Dimension(240, 40));
        jPanel7.setMinimumSize(new java.awt.Dimension(240, 40));
        jPanel7.setPreferredSize(new java.awt.Dimension(240, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Nueva contraseña:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(34, 34, 34))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel6.add(jPanel7);

        jPassTextContraseniaNueva.setBackground(new java.awt.Color(255, 255, 255));
        jPassTextContraseniaNueva.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPassTextContraseniaNueva.setMaximumSize(new java.awt.Dimension(290, 30));
        jPassTextContraseniaNueva.setMinimumSize(new java.awt.Dimension(290, 30));
        jPassTextContraseniaNueva.setPreferredSize(new java.awt.Dimension(290, 30));
        jPanel6.add(jPassTextContraseniaNueva);

        jPanel2.add(jPanel6);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMaximumSize(new java.awt.Dimension(570, 30));
        jPanel8.setMinimumSize(new java.awt.Dimension(570, 30));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 80, 5));

        jLbErrorContraseniaNueva.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbErrorContraseniaNueva.setForeground(new java.awt.Color(255, 0, 0));
        jLbErrorContraseniaNueva.setText("Tenés que indicar una contraseña");
        jPanel8.add(jLbErrorContraseniaNueva);

        jPanel2.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMaximumSize(new java.awt.Dimension(570, 40));
        jPanel9.setMinimumSize(new java.awt.Dimension(570, 40));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(240, 40));
        jPanel10.setMinimumSize(new java.awt.Dimension(240, 40));
        jPanel10.setPreferredSize(new java.awt.Dimension(240, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Confirmar contraseña:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel10);

        jPassTextConfirmarContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        jPassTextConfirmarContrasenia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPassTextConfirmarContrasenia.setMaximumSize(new java.awt.Dimension(290, 30));
        jPassTextConfirmarContrasenia.setMinimumSize(new java.awt.Dimension(290, 30));
        jPassTextConfirmarContrasenia.setPreferredSize(new java.awt.Dimension(290, 30));
        jPanel9.add(jPassTextConfirmarContrasenia);

        jPanel2.add(jPanel9);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setMaximumSize(new java.awt.Dimension(570, 30));
        jPanel11.setMinimumSize(new java.awt.Dimension(570, 30));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 80, 5));

        jLbErrorConfirmarContrasenia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbErrorConfirmarContrasenia.setForeground(new java.awt.Color(255, 0, 0));
        jLbErrorConfirmarContrasenia.setText("Tenés que confirmar la contraseña");
        jPanel11.add(jLbErrorConfirmarContrasenia);

        jPanel2.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(570, 80));
        jPanel12.setMinimumSize(new java.awt.Dimension(570, 80));

        jBtnCambiarContrasenia.setBackground(new java.awt.Color(51, 153, 255));
        jBtnCambiarContrasenia.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBtnCambiarContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCambiarContrasenia.setText("CAMBIAR");
        jBtnCambiarContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCambiarContraseniaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(jBtnCambiarContrasenia)
                .addGap(35, 35, 35))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jBtnCambiarContrasenia)
                .addGap(19, 19, 19))
        );

        jPanel2.add(jPanel12);

        jLbErrorNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbErrorNombre.setForeground(new java.awt.Color(255, 0, 0));
        jLbErrorNombre.setText("Tenés que indicar un nombre");

        jLbErrorApellido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbErrorApellido.setForeground(new java.awt.Color(255, 0, 0));
        jLbErrorApellido.setText("Tenés que indicar un apellido");

        jLabelFechaAlta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelFechaAlta.setText("Miembro desde:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnCambiarImagen)
                            .addComponent(jLImagenUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLbErrorNombre))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLbErrorApellido))
                            .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFechaAlta))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLImagenUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLbErrorNombre))
                        .addGap(18, 18, 18)
                        .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLbErrorApellido))
                        .addGap(18, 18, 18)
                        .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelFechaAlta)))
                .addGap(18, 18, 18)
                .addComponent(jBtnCambiarImagen)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        jPanelFooter.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFooter.setMaximumSize(new java.awt.Dimension(800, 80));
        jPanelFooter.setMinimumSize(new java.awt.Dimension(800, 80));
        jPanelFooter.setPreferredSize(new java.awt.Dimension(186, 80));
        jPanelFooter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jBtnConfirmar.setBackground(new java.awt.Color(51, 153, 255));
        jBtnConfirmar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jBtnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnConfirmar.setText("CONFIRMAR");
        jBtnConfirmar.setBorderPainted(false);
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });
        jPanelFooter.add(jBtnConfirmar);

        getContentPane().add(jPanelFooter);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCambiarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCambiarImagenActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("JPG","jpg");
        
        jImgFileChooser = new JFileChooser("res\\imagenes_usuarios\\para_agregar");
        jImgFileChooser.setDialogTitle("Elige una imagen");
        jImgFileChooser.setFileFilter(imageFilter);
        
        if ( jImgFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
        
                File archivoImagen = jImgFileChooser.getSelectedFile();

            try{

                ImageIcon icon = new ImageIcon(archivoImagen.toString());
                System.out.println(archivoImagen.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(this.jLImagenUsuario.getPreferredSize().width, this.jLImagenUsuario.getPreferredSize().height, Image.SCALE_DEFAULT));

                this.jLImagenUsuario.setIcon( icono );

                this.cambioImagen = true;
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);     
            }
        }
    }//GEN-LAST:event_jBtnCambiarImagenActionPerformed

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(this,"¿Seguro no querés modificar tu cuenta?","",JOptionPane.YES_NO_OPTION);
        
        if ( opcion ==  JOptionPane.YES_OPTION ){
            frmPrincipal vPrincipal = new frmPrincipal(this.controladora.obtenerUsuario().getIdUsuario());
            this.setVisible(false);
            vPrincipal.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jBtnCerrarActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        if ( this.formularioCompleto()){
        
            String nombre;
            String apellido;
            String imagenPerfil;
            
            if ( this.cambioImagen )
                imagenPerfil = generarImagenUsuario();
            else
                imagenPerfil = this.controladora.obtenerUsuario().getImagenPathUsuario();
            
            nombre = this.jTextNombre.getText();
            apellido = this.jTextApellido.getText();
           
            if ( this.controladora.actualizarUsuario(nombre, apellido, imagenPerfil) ){
                int opcion = JOptionPane.showConfirmDialog(this, "Cambios realizados exitosamente!","",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            
                if ( opcion == JOptionPane.YES_OPTION ){
                    
                    abrirVentana();
                }
            }
            
        }
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCambiarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCambiarContraseniaActionPerformed
        // TODO add your handling code here:
        if ( formularioContraseniaCompleto()){
            
           
            if ( this.controladora.actualizarContrasenia( String.valueOf(this.jPassTextContraseniaNueva.getPassword())) )
                JOptionPane.showConfirmDialog(this, "Cambios realizados exitosamente!","",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            
            
        }
    }//GEN-LAST:event_jBtnCambiarContraseniaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmModificarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmModificarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmModificarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmModificarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmModificarCuenta(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCambiarContrasenia;
    private javax.swing.JButton jBtnCambiarImagen;
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JLabel jLImagenUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelFechaAlta;
    private javax.swing.JLabel jLbErrorApellido;
    private javax.swing.JLabel jLbErrorConfirmarContrasenia;
    private javax.swing.JLabel jLbErrorContraseniaActual;
    private javax.swing.JLabel jLbErrorContraseniaNueva;
    private javax.swing.JLabel jLbErrorNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPasswordField jPassTextConfirmarContrasenia;
    private javax.swing.JPasswordField jPassTextContrasenia;
    private javax.swing.JPasswordField jPassTextContraseniaNueva;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void inicializarVentana() {
        this.setLocationRelativeTo(this);
        
        limpiarErrores();
        
        this.controladora = new ModificarCuentaControladora();
        this.controladora.buscarUsuario(this.idUsuario);
        
        this.jTextNombre.setText(this.controladora.obtenerUsuario().getNombreUsuario());
        this.jTextApellido.setText(this.controladora.obtenerUsuario().getApellidoUsuario());
    
        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(this.controladora.obtenerUsuario().getFechaAltaUsuario());
        
        this.jLabelFechaAlta.setText( "Miembre desde: " + fecha );
        
        this.cambioImagen = false;
        this.cargarImagenUsuario(this.jLImagenUsuario, this.controladora.obtenerUsuario().getImagenPathUsuario());
         
    }

    @Override
    public boolean formularioCompleto() {
    
        limpiarErrores();
        
        if ( this.jTextNombre.getText().equals("")){
            this.jLbErrorNombre.setVisible(true);
            return false;
        }
        
        if ( this.jTextApellido.getText().equals("")){
            this.jLbErrorApellido.setVisible(true);
            return false;
        }
       
        return true;
    }

    @Override
    public void abrirVentana() {
        frmPrincipal vPrincipal = new frmPrincipal(this.controladora.obtenerUsuario().getIdUsuario());
        this.setVisible(false);
        vPrincipal.setVisible(true);
        this.dispose();
    }

    @Override
    public void limpiarErrores() {
        
        this.jLbErrorNombre.setVisible(false);
        this.jLbErrorApellido.setVisible(false);
        this.jLbErrorContraseniaActual.setVisible(false);
        this.jLbErrorContraseniaNueva.setVisible(false);
        this.jLbErrorConfirmarContrasenia.setVisible(false);
        
    }
}
