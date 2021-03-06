/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.vistas;

import com.guilleminio.emails.controladora.EmailControladora;
import com.guilleminio.emails.utilidades.Utilidades;
import javax.swing.JOptionPane;

/**
 *
 * @author Guille
 */
public class frmEmail extends javax.swing.JDialog implements IVentana{

    public static final int VENTANA_NUEVO_EMAIL    = 0;
    public static final int VENTANA_EMAIL_RECIBIDO = 1;
    public static final int VENTANA_EMAIL_ENVIADO  = 2;
    public static final int VENTANA_EMAIL_BORRADOR = 3;
    public static final int VENTANA_EMAIL_RESPUESTA = 4;
    
    private int tipoVentana;
    private int idEmail;
    private int idUsuario;
    private int idContacto;
    
    private IEmailListener emailListener;
    private EmailControladora controladora;
    /**
     * Creates new form frmEmail
     */
    public frmEmail( int aTipoVentana, int aIdUsuario, int aIdEmail, int aIdContacto, IEmailListener aEmailListener ) {
        initComponents();
        this.tipoVentana = aTipoVentana;
        this.idEmail = aIdEmail;
        this.idUsuario = aIdUsuario;
        this.idContacto = aIdContacto;
        this.emailListener = aEmailListener;
        inicializarVentana();
    }

    private void cerrarVentana(){
        if ( this.emailListener != null)
            this.emailListener.actualizarListados();
        this.setVisible(false);
        this.dispose();
    }
    
    private void prepararVentanaEmailRecibido(){
        
        if (!this.controladora.obtenerEmailActual().isLeidoEmailRecibido())
            this.controladora.actualizarEstadoEmailRecibido();
        
        this.jLDestinatario.setText("De:");
        this.jTextDestinatario.setText(this.controladora.obtenerEmailActual().getOrigenEmailRecibido());
        this.jTextAsunto.setText(this.controladora.obtenerEmailActual().getAsuntoEmail());
        this.jTextContenido.setText(this.controladora.obtenerEmailActual().getContenidoEmail());
    }
    
    private void prepararVentanaEmailEnviado(){
        this.jLDestinatario.setText("Para:");
        this.jTextDestinatario.setText(this.controladora.obtenerEmailActual().getDestinoEmailEnvio());
        this.jTextAsunto.setText(this.controladora.obtenerEmailActual().getAsuntoEmail());
        this.jTextContenido.setText(this.controladora.obtenerEmailActual().getContenidoEmail());
    
        if ( this.controladora.establecerEmailOrigenRespuesta(this.idEmail)){
            
            this.jTextContenido.append("\r\n\r\n");
            this.jTextContenido.append("---------------Mensaje Original----------------\r\n");
            this.jTextContenido.append("De: " + this.controladora.obtenerEmailOrigenRespueta().getOrigenEmailRecibido() + "\r\n");
            this.jTextContenido.append("Asunto: " + this.controladora.obtenerEmailOrigenRespueta().getAsuntoEmail() + "\r\n");
            this.jTextContenido.append("Fecha: " + this.controladora.obtenerEmailOrigenRespueta().getFechaLlegadaEmailRecibido() + "\r\n");
            this.jTextContenido.append("\r\n");
            this.jTextContenido.append(this.controladora.obtenerEmailOrigenRespueta().getContenidoEmail());
            
        }
    }
    
    private void prepararVentanaEmailBorrador(){
        this.jLDestinatario.setText("Para:");
        this.jTextDestinatario.setText(this.controladora.obtenerEmailActual().getDestinoEmailEnvio());
        this.jTextAsunto.setText(this.controladora.obtenerEmailActual().getAsuntoEmail());
        this.jTextContenido.setText(this.controladora.obtenerEmailActual().getContenidoEmail());
    }
    
    private void prepararVentanaRespuesta(){
        this.jTextDestinatario.setText(this.controladora.obtenerEmailActual().getOrigenEmailRecibido());
        this.jTextAsunto.setText("(RE:)" + this.controladora.obtenerEmailActual().getAsuntoEmail());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanelHeader = new javax.swing.JPanel();
        jPanelTituloVentana = new javax.swing.JPanel();
        jTituloVentana = new javax.swing.JLabel();
        jBtnCerrar = new javax.swing.JButton();
        jPanelEmailDatos = new javax.swing.JPanel();
        jLDestinatario = new javax.swing.JLabel();
        jTextDestinatario = new javax.swing.JTextField();
        jLAsunto = new javax.swing.JLabel();
        jTextAsunto = new javax.swing.JTextField();
        jPanelContenido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextContenido = new javax.swing.JTextArea();
        jPanelFooter = new javax.swing.JPanel();
        jPanelFooterLeft = new javax.swing.JPanel();
        jBtnEliminar = new javax.swing.JButton();
        jPanelFooterRight = new javax.swing.JPanel();
        jBtnEnviar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 590));
        setName("frmEmail"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanelHeader.setBackground(new java.awt.Color(51, 153, 255));
        jPanelHeader.setMaximumSize(new java.awt.Dimension(800, 30));
        jPanelHeader.setMinimumSize(new java.awt.Dimension(800, 30));
        jPanelHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jPanelTituloVentana.setBackground(new java.awt.Color(51, 153, 255));
        jPanelTituloVentana.setMaximumSize(new java.awt.Dimension(770, 30));
        jPanelTituloVentana.setMinimumSize(new java.awt.Dimension(770, 30));
        jPanelTituloVentana.setPreferredSize(new java.awt.Dimension(770, 30));

        jTituloVentana.setForeground(new java.awt.Color(255, 255, 255));
        jTituloVentana.setText("TITULO VENTANA");
        jPanelTituloVentana.add(jTituloVentana);

        jPanelHeader.add(jPanelTituloVentana);

        jBtnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/cerrar_celeste_30.jpg"))); // NOI18N
        jBtnCerrar.setBorderPainted(false);
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
        jPanelHeader.add(jBtnCerrar);

        getContentPane().add(jPanelHeader);

        jPanelEmailDatos.setBackground(new java.awt.Color(51, 170, 255));
        jPanelEmailDatos.setMaximumSize(new java.awt.Dimension(800, 100));
        jPanelEmailDatos.setMinimumSize(new java.awt.Dimension(800, 100));

        jLDestinatario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLDestinatario.setForeground(new java.awt.Color(255, 255, 255));
        jLDestinatario.setText("Para:");

        jTextDestinatario.setBackground(new java.awt.Color(255, 255, 255));
        jTextDestinatario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextDestinatario.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextDestinatario.setMaximumSize(new java.awt.Dimension(703, 30));
        jTextDestinatario.setMinimumSize(new java.awt.Dimension(703, 30));
        jTextDestinatario.setPreferredSize(new java.awt.Dimension(703, 30));

        jLAsunto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLAsunto.setForeground(new java.awt.Color(255, 255, 255));
        jLAsunto.setText("Asunto:");

        jTextAsunto.setBackground(new java.awt.Color(255, 255, 255));
        jTextAsunto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextAsunto.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextAsunto.setMaximumSize(new java.awt.Dimension(680, 30));
        jTextAsunto.setMinimumSize(new java.awt.Dimension(680, 30));
        jTextAsunto.setPreferredSize(new java.awt.Dimension(680, 30));

        javax.swing.GroupLayout jPanelEmailDatosLayout = new javax.swing.GroupLayout(jPanelEmailDatos);
        jPanelEmailDatos.setLayout(jPanelEmailDatosLayout);
        jPanelEmailDatosLayout.setHorizontalGroup(
            jPanelEmailDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmailDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmailDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmailDatosLayout.createSequentialGroup()
                        .addComponent(jLDestinatario)
                        .addGap(18, 18, 18)
                        .addComponent(jTextDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEmailDatosLayout.createSequentialGroup()
                        .addComponent(jLAsunto)
                        .addGap(18, 18, 18)
                        .addComponent(jTextAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanelEmailDatosLayout.setVerticalGroup(
            jPanelEmailDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmailDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmailDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDestinatario)
                    .addComponent(jTextDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEmailDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAsunto)
                    .addComponent(jTextAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelEmailDatos);

        jPanelContenido.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido.setMaximumSize(new java.awt.Dimension(800, 400));
        jPanelContenido.setMinimumSize(new java.awt.Dimension(800, 400));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(800, 400));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(800, 400));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 400));

        jTextContenido.setBackground(new java.awt.Color(255, 255, 255));
        jTextContenido.setColumns(20);
        jTextContenido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextContenido.setLineWrap(true);
        jTextContenido.setRows(5);
        jTextContenido.setWrapStyleWord(true);
        jTextContenido.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(jTextContenido);

        javax.swing.GroupLayout jPanelContenidoLayout = new javax.swing.GroupLayout(jPanelContenido);
        jPanelContenido.setLayout(jPanelContenidoLayout);
        jPanelContenidoLayout.setHorizontalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelContenidoLayout.setVerticalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelContenido);

        jPanelFooter.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFooter.setMaximumSize(new java.awt.Dimension(800, 60));
        jPanelFooter.setMinimumSize(new java.awt.Dimension(800, 60));
        jPanelFooter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jPanelFooterLeft.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFooterLeft.setMaximumSize(new java.awt.Dimension(400, 60));
        jPanelFooterLeft.setMinimumSize(new java.awt.Dimension(400, 60));
        jPanelFooterLeft.setPreferredSize(new java.awt.Dimension(400, 60));
        jPanelFooterLeft.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jBtnEliminar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/icono_papelera.jpg"))); // NOI18N
        jBtnEliminar.setBorderPainted(false);
        jBtnEliminar.setContentAreaFilled(false);
        jBtnEliminar.setMaximumSize(new java.awt.Dimension(48, 48));
        jBtnEliminar.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtnEliminar.setPreferredSize(new java.awt.Dimension(48, 48));
        jBtnEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/icono_papelera_presionado.jpg"))); // NOI18N
        jBtnEliminar.setRolloverEnabled(true);
        jBtnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/icono_papelera_presionado.jpg"))); // NOI18N
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });
        jPanelFooterLeft.add(jBtnEliminar);

        jPanelFooter.add(jPanelFooterLeft);

        jPanelFooterRight.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFooterRight.setMaximumSize(new java.awt.Dimension(400, 60));
        jPanelFooterRight.setMinimumSize(new java.awt.Dimension(400, 60));
        jPanelFooterRight.setPreferredSize(new java.awt.Dimension(400, 60));
        jPanelFooterRight.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jBtnEnviar.setBackground(new java.awt.Color(51, 153, 255));
        jBtnEnviar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jBtnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEnviar.setText("ENVIAR");
        jBtnEnviar.setBorderPainted(false);
        jBtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEnviarActionPerformed(evt);
            }
        });
        jPanelFooterRight.add(jBtnEnviar);

        jPanelFooter.add(jPanelFooterRight);

        getContentPane().add(jPanelFooter);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que querés eliminar el email?", "Atención", JOptionPane.WARNING_MESSAGE);
        
        if ( opcion == JOptionPane.YES_OPTION){
            this.controladora.eliminarEmail();
            cerrarVentana();
        }
        
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed
        // TODO add your handling code here:
        if ( (this.tipoVentana == frmEmail.VENTANA_NUEVO_EMAIL) || (this.tipoVentana == frmEmail.VENTANA_EMAIL_BORRADOR)){
        
            String destino = this.jTextDestinatario.getText();
            String asunto = this.jTextAsunto.getText();
            String contenido = this.jTextContenido.getText();
        
            if ( this.controladora.actualizarEmailBorrador(asunto, destino, contenido))
                cerrarVentana();
            else
                JOptionPane.showMessageDialog(this, "Problemas al actualizar borrador");
        }else
            cerrarVentana();
    }//GEN-LAST:event_jBtnCerrarActionPerformed

    private void jBtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEnviarActionPerformed
        // TODO add your handling code here:
        
        if ( this.tipoVentana != frmEmail.VENTANA_EMAIL_RECIBIDO){
            if ( formularioCompleto()){
                String asunto = this.jTextAsunto.getText();
                String contenido = this.jTextContenido.getText();
                String destinatario = this.jTextDestinatario.getText();
          
                if ( this.controladora.enviarEmail(asunto,destinatario, contenido)){
               
                    int opcion = JOptionPane.showConfirmDialog(this, "Mensaje enviado con éxito!","",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            
                    if ( opcion == JOptionPane.YES_OPTION )
                        cerrarVentana();
                
                }
            }
        }else{
            frmEmail vEmail = new frmEmail(frmEmail.VENTANA_EMAIL_RESPUESTA, this.idUsuario, this.idEmail, this.idContacto,this.emailListener);
            this.setVisible(false);
            vEmail.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_jBtnEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(frmEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEmail(0,0,0,0,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnEnviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLAsunto;
    private javax.swing.JLabel jLDestinatario;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelEmailDatos;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanelFooterLeft;
    private javax.swing.JPanel jPanelFooterRight;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelTituloVentana;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextAsunto;
    private javax.swing.JTextArea jTextContenido;
    private javax.swing.JTextField jTextDestinatario;
    private javax.swing.JLabel jTituloVentana;
    // End of variables declaration//GEN-END:variables

    @Override
    public void inicializarVentana() {
        this.setLocationRelativeTo(this);
        this.setModal(true);
        this.controladora = new EmailControladora();
        this.controladora.obtenerUsuario(idUsuario);
        
        switch (this.tipoVentana){
            case frmEmail.VENTANA_NUEVO_EMAIL:
                
                this.jTituloVentana.setText("NUEVO EMAIL");
                if ( this.idContacto != -1){
                    if ( this.controladora.buscarContacto(this.idContacto)){
                        this.jTextDestinatario.setText(this.controladora.obtenerContacto().getEmailContacto());
                        this.controladora.crearEmailBorrador(this.jTextDestinatario.getText());
                    }
                }else
                     this.controladora.crearEmailBorrador();
                break;
            case frmEmail.VENTANA_EMAIL_RECIBIDO:
                this.jTituloVentana.setText("");
                this.jTextAsunto.setEnabled(false);
                this.jTextDestinatario.setEnabled(false);
                this.jTextContenido.setEnabled(false);
                this.jBtnEnviar.setText("RESPONDER");
                this.controladora.obtenerEmail(this.idEmail);
                prepararVentanaEmailRecibido();
                break;
            case frmEmail.VENTANA_EMAIL_BORRADOR:
                this.jTituloVentana.setText("BORRADOR");
                this.controladora.obtenerEmail(this.idEmail);
                prepararVentanaEmailBorrador();
                break;
            case frmEmail.VENTANA_EMAIL_ENVIADO:
                this.jTituloVentana.setText("");
                this.jTextAsunto.setEnabled(false);
                this.jTextDestinatario.setEnabled(false);
                this.jTextContenido.setEnabled(false);
                this.jBtnEnviar.setVisible(false);
                this.controladora.obtenerEmail(this.idEmail);
                prepararVentanaEmailEnviado();
                break;
            case frmEmail.VENTANA_EMAIL_RESPUESTA:
                this.jTituloVentana.setText("");
                this.controladora.obtenerEmail(this.idEmail);
                prepararVentanaRespuesta();
                break;
        }
    }

    @Override
    public boolean formularioCompleto() {
        
        String emailDestino = this.jTextDestinatario.getText();
        
        if ( emailDestino.equals("")){
            JOptionPane.showMessageDialog(this, "Debes indicar un destinatario.");
            return false;
        }
       
        if ( !Utilidades.validarFormatoEmail(emailDestino)){
            JOptionPane.showMessageDialog(this, "El formato de email indicado en el destino no es válido");
            return false;
        }
        
        if ( this.jTextAsunto.getText().equals("")){
            if ( JOptionPane.showConfirmDialog(this,"El asunto no está especificado. ¿Continuamos?","",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                this.jTextAsunto.setText("SIN ASUNTO");
            }else
                return false;
        }
        
        if ( this.jTextContenido.getText().equals("")){
            if ( JOptionPane.showConfirmDialog(this,"No has agregado contenido al mensaje. ¿Continuamos?","",JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
                return false;
        }
        
        return true;
    
    }

    @Override
    public void abrirVentana() {
       
    }

    @Override
    public void limpiarErrores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
