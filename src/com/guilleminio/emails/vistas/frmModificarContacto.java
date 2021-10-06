/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.vistas;

import com.guilleminio.emails.controladora.ModificarContactoControladora;
import com.guilleminio.emails.utilidades.Utilidades;
import javax.swing.JOptionPane;


/**
 *
 * @author Guille
 */
public class frmModificarContacto extends javax.swing.JFrame implements IVentana {

    public static final int VENTANA_MODIFICAR = 0;
    public static final int VENTANA_AGREGAR = 1;
    
    private int tipoVentana;
    private int idContacto;
    
    private int idUsuario;
    
    private ModificarContactoControladora controladora;
    
    /**
     * Creates new form frmModificarContacto
     */
    public frmModificarContacto( int aTipo, int aIdUsuario, int aIdContacto ) {
        initComponents();
        
        this.tipoVentana = aTipo;
        this.idUsuario = aIdUsuario;
        this.idContacto = aIdContacto;
        
        inicializarVentana();
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
        jBtnCerrar = new javax.swing.JButton();
        jLTituloVentana = new javax.swing.JLabel();
        jPanelSection = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jLErrorNombre = new javax.swing.JLabel();
        jLErrorApellido = new javax.swing.JLabel();
        jLErrorEmail = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanelFooterLeft = new javax.swing.JPanel();
        jBtnEliminar = new javax.swing.JButton();
        jPanelFooterRight = new javax.swing.JPanel();
        jBtnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setName("frmModificarContacto"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanelHeader.setBackground(new java.awt.Color(51, 153, 255));
        jPanelHeader.setMaximumSize(new java.awt.Dimension(600, 50));
        jPanelHeader.setMinimumSize(new java.awt.Dimension(600, 50));
        jPanelHeader.setPreferredSize(new java.awt.Dimension(600, 50));

        jBtnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/cerrar_celeste_30.jpg"))); // NOI18N
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

        jLTituloVentana.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLTituloVentana.setForeground(new java.awt.Color(255, 255, 255));
        jLTituloVentana.setText("TITULO VENTANA");

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(jLTituloVentana)
                .addGap(154, 154, 154)
                .addComponent(jBtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLTituloVentana)
                    .addComponent(jBtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelHeader);

        jPanelSection.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSection.setMaximumSize(new java.awt.Dimension(600, 300));
        jPanelSection.setMinimumSize(new java.awt.Dimension(600, 300));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jTextNombre.setBackground(new java.awt.Color(255, 255, 255));
        jTextNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextNombre.setMaximumSize(new java.awt.Dimension(340, 30));
        jTextNombre.setMinimumSize(new java.awt.Dimension(340, 30));
        jTextNombre.setPreferredSize(new java.awt.Dimension(340, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Apellido:");

        jTextApellido.setBackground(new java.awt.Color(255, 255, 255));
        jTextApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextApellido.setMaximumSize(new java.awt.Dimension(340, 30));
        jTextApellido.setMinimumSize(new java.awt.Dimension(340, 30));
        jTextApellido.setPreferredSize(new java.awt.Dimension(340, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Email:");

        jTextEmail.setBackground(new java.awt.Color(255, 255, 255));
        jTextEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextEmail.setMaximumSize(new java.awt.Dimension(340, 30));
        jTextEmail.setMinimumSize(new java.awt.Dimension(340, 30));
        jTextEmail.setPreferredSize(new java.awt.Dimension(340, 30));

        jLErrorNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLErrorNombre.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorNombre.setText("Tenés que indicar el nombre");

        jLErrorApellido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLErrorApellido.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorApellido.setText("Tenés que indicar el apellido");

        jLErrorEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLErrorEmail.setForeground(new java.awt.Color(255, 0, 0));
        jLErrorEmail.setText("Tenés que indicar el email");

        javax.swing.GroupLayout jPanelSectionLayout = new javax.swing.GroupLayout(jPanelSection);
        jPanelSection.setLayout(jPanelSectionLayout);
        jPanelSectionLayout.setHorizontalGroup(
            jPanelSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSectionLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanelSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSectionLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLErrorNombre))
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelSectionLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLErrorApellido))
                    .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelSectionLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLErrorEmail))
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanelSectionLayout.setVerticalGroup(
            jPanelSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSectionLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLErrorNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLErrorApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLErrorEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSection);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 50));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanelFooterLeft.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFooterLeft.setMaximumSize(new java.awt.Dimension(300, 50));
        jPanelFooterLeft.setMinimumSize(new java.awt.Dimension(300, 50));
        jPanelFooterLeft.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanelFooterLeft.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        jBtnEliminar.setBackground(new java.awt.Color(51, 153, 255));
        jBtnEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEliminar.setText("ELIMINAR");
        jBtnEliminar.setBorderPainted(false);
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });
        jPanelFooterLeft.add(jBtnEliminar);

        jPanel1.add(jPanelFooterLeft);

        jPanelFooterRight.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFooterRight.setMaximumSize(new java.awt.Dimension(280, 50));
        jPanelFooterRight.setMinimumSize(new java.awt.Dimension(280, 50));
        jPanelFooterRight.setPreferredSize(new java.awt.Dimension(280, 50));
        jPanelFooterRight.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 5));

        jBtnAceptar.setBackground(new java.awt.Color(51, 153, 255));
        jBtnAceptar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBtnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAceptar.setText("ACEPTAR");
        jBtnAceptar.setBorderPainted(false);
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });
        jPanelFooterRight.add(jBtnAceptar);

        jPanel1.add(jPanelFooterRight);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        // TODO add your handling code here:
        
        if ( formularioCompleto() ){    
        
            String nombre = this.jTextNombre.getText();
            String apellido = this.jTextApellido.getText();
            String email = this.jTextEmail.getText();
            
            int opcion = -1;
            if ( this.tipoVentana == frmModificarContacto.VENTANA_AGREGAR){
                if ( this.controladora.agregarContacto(nombre, apellido, email))
                    opcion = JOptionPane.showConfirmDialog(this, "Contacto agregado exitosamente!","", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                  
            }else{
                if ( this.controladora.actualizarContacto(nombre, apellido, email))
                    opcion = JOptionPane.showConfirmDialog(this, "Contacto modificado exitosamente!","", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);     
            }
            
            if ( opcion == JOptionPane.YES_OPTION)
                abrirVentana();
              
        }
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(this, "¿Salir sin guardar cambios?","",JOptionPane.YES_NO_OPTION);
        
        if ( opcion == JOptionPane.YES_OPTION )
            abrirVentana();
    }//GEN-LAST:event_jBtnCerrarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro querés eliminar a " + this.controladora.obtenerContacto().getNombreContacto() + "?","",JOptionPane.YES_NO_OPTION);
        
        if ( opcion == JOptionPane.YES_OPTION){
            
            if ( this.controladora.eliminarContacto()){
                opcion = JOptionPane.showConfirmDialog(this, "Contacto eliminado","",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                
                if ( opcion == JOptionPane.YES_OPTION ){
                    abrirVentana();
                }
            }
            
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(frmModificarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmModificarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmModificarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmModificarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmModificarContacto(0,0,0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JLabel jLErrorApellido;
    private javax.swing.JLabel jLErrorEmail;
    private javax.swing.JLabel jLErrorNombre;
    private javax.swing.JLabel jLTituloVentana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFooterLeft;
    private javax.swing.JPanel jPanelFooterRight;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelSection;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void inicializarVentana() {
        this.setLocationRelativeTo(this);
        limpiarErrores();
        
        this.controladora = new ModificarContactoControladora();
        this.controladora.establecerUsuario(this.idUsuario);
        
        switch ( this.tipoVentana ){
            case frmModificarContacto.VENTANA_AGREGAR: 
                this.jLTituloVentana.setText("NUEVO CONTACTO");
                this.jBtnAceptar.setText("AGREGAR");
                this.jBtnEliminar.setVisible(false);
                break;
            case frmModificarContacto.VENTANA_MODIFICAR:
                this.controladora.establecerContacto(this.idContacto);
                this.jTextNombre.setText(this.controladora.obtenerContacto().getNombreContacto());
                this.jTextApellido.setText(this.controladora.obtenerContacto().getApellidoContacto());
                this.jTextEmail.setText(this.controladora.obtenerContacto().getEmailContacto());
                this.jLTituloVentana.setText("MODIFICAR CONTACTO");
                this.jBtnAceptar.setText("MODIFICAR");
                break;
        }
    }

    @Override
    public boolean formularioCompleto() {
     
        limpiarErrores();
        
        if ( this.jTextNombre.getText().equals("")){
            this.jLErrorNombre.setVisible(true);
            return false;
        }
        
        if ( this.jTextApellido.getText().equals("")){
            this.jLErrorApellido.setVisible(true);
            return false;
        }
        
        if ( this.jTextEmail.getText().equals("")){
            this.jLErrorEmail.setVisible(true);
            this.jLErrorEmail.setText("Tenés que indicar un email");
            return false;
        }
        
        if ( !Utilidades.validarFormatoEmail(this.jTextEmail.getText())){
            this.jLErrorEmail.setVisible(true);
            this.jLErrorEmail.setText("El formato de email es incorrecto");
            return false;
        }
        return true;
    }

    @Override
    public void abrirVentana() {
        frmContactos vContactos = new frmContactos(this.idUsuario);
        this.setVisible(false);
        vContactos.setVisible(true);
        this.dispose();
    }

    @Override
    public void limpiarErrores() {
    
        this.jLErrorNombre.setVisible(false);
        this.jLErrorApellido.setVisible(false);
        this.jLErrorEmail.setVisible(false);
    }
}