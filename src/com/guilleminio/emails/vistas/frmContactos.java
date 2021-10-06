/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.vistas;

import com.guilleminio.emails.controladora.ContactosControladora;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Guille
 */
public class frmContactos extends javax.swing.JFrame {

    private ContactosControladora controladora;
    
    private int idUsuario;
    
    /**
     * Creates new form frmContactos
     */
    public frmContactos( int aIdUsuario ) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.idUsuario = aIdUsuario;
        this.controladora = new ContactosControladora();
        if ( this.controladora.establecerContactos(this.idUsuario)){
            inicializarListadoContactos();
            this.jLSinContactos.setVisible(false);
        }
    }
    
    private void inicializarListadoContactos(){
        
        int totalContactos = this.controladora.obtenerTotalContactos();
           
        if ( totalContactos > 0 ){
            
           JPanel[] jPanelContacto = new JPanel[totalContactos];
           int altura = 0;
           
           for ( int i = 0; i< totalContactos; i++){
            
                
                jPanelContacto[i] = new JPanel();
                jPanelContacto[i].setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
                jPanelContacto[i].setBackground(Color.WHITE);
                jPanelContacto[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); 
                
                //---------------LA FOTO DEL CONTACTO
                JLabel jLabelPicture = new JLabel();
                jLabelPicture.setPreferredSize(new Dimension(150,170));
                jLabelPicture.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); 
                jLabelPicture.setText(String.valueOf(this.controladora.obtenerContacto(i).getNombreContacto().charAt(0)));
                jLabelPicture.setForeground(Color.WHITE);
                jLabelPicture.setBackground(Color.GRAY);
                jLabelPicture.setOpaque(true);
                jLabelPicture.setFont(new java.awt.Font("Tahoma", 0, 36));
                jLabelPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabelPicture.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                jPanelContacto[i].add(jLabelPicture);
            
                //---------------LOS DATOS DEL CONTACTO
                JPanel jPanelDatos = new JPanel();
                jPanelDatos.setLayout(new GridLayout(4,0,10,0));
                jPanelDatos.setOpaque(true);
                jPanelDatos.setBackground(Color.WHITE);
                jPanelDatos.setPreferredSize(new Dimension(this.getContentPane().getWidth()-250,180));
                jPanelDatos.setLocation(jLabelPicture.getWidth() + 10, jLabelPicture.getHeight());
            
                    //---Nombre
                    JLabel jLabelName = new JLabel();
                    jLabelName.setMinimumSize(new Dimension(jPanelDatos.getPreferredSize().width-10,jLabelName.getMinimumSize().height));
                    jLabelName.setText(this.controladora.obtenerContacto(i).getNombreContacto());
                    jLabelName.setFont(new java.awt.Font("Tahoma", 0, 18));
                    jPanelDatos.add(jLabelName);
            
                    //---Apellido
                    JLabel jLabelLastName = new JLabel();
                    jLabelLastName.setText(this.controladora.obtenerContacto(i).getApellidoContacto());
                    jLabelLastName.setFont(new java.awt.Font("Tahoma", 0, 18));
                    jPanelDatos.add(jLabelLastName);
            
                    //---Email
                    JLabel jLabelEmail = new JLabel();
                    jLabelEmail.setText(this.controladora.obtenerContacto(i).getEmailContacto());
                    jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 18));
                    jPanelDatos.add(jLabelEmail);
                
                    //----BOTONES
                    JPanel panelBotones = new JPanel();
                    panelBotones.setLayout(new FlowLayout(FlowLayout.TRAILING,10,13));
                    panelBotones.setBackground(Color.WHITE);
                
                        JButton btnEdit = new JButton();
                        btnEdit.setText("EDITAR");
                        btnEdit.setBackground(new Color(51,153,255));
                        btnEdit.setForeground(new Color(255,255,255));
                
                        JButton btnEnviarEmail = new JButton();
                        btnEnviarEmail.setText("ENVIAR EMAIL");
                        btnEnviarEmail.setBackground(new Color(51,153,255));
                        btnEnviarEmail.setForeground(new Color(255,255,255));
                
                        
                        final int idContacto = this.controladora.obtenerContacto(i).getIdContacto();
                        btnEdit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                               //ABRIR VENANA MODIFICAR CONTACTO
                               modificarContacto(idContacto);
                            }
                        });
                    
                        btnEnviarEmail.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                            //ABRIR VENTANA EMAIL
                              abrirVentanaEmail(idContacto);
                            }
                        });
               
                    panelBotones.add(btnEnviarEmail);
                    panelBotones.add(btnEdit);
                
                
                    jPanelDatos.add(panelBotones);
                
                    jPanelContacto[i].add(jPanelDatos);
            
                altura+=jPanelContacto[i].getPreferredSize().height+18;
                this.jPanelListadoContactos.add(jPanelContacto[i],BorderLayout.CENTER);
                
            }
     
            this.jPanelListadoContactos.setPreferredSize(new Dimension(this.jPanelListadoContactos.getMaximumSize().width,altura));
        }    
    }

    private void modificarContacto( int aIdContacto ){
        frmModificarContacto vModificarContacto = new frmModificarContacto(frmModificarContacto.VENTANA_MODIFICAR,idUsuario,aIdContacto);
        this.setVisible(false);
        vModificarContacto.setVisible(true);
        this.dispose();
    }
    
    private void abrirVentanaEmail(int aIdContacto){
        frmEmail vEmail = new frmEmail(frmEmail.VENTANA_NUEVO_EMAIL,this.idUsuario,-1,aIdContacto,null);
        vEmail.setVisible(true);
        
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBtnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelListadoContactos = new javax.swing.JPanel();
        jLSinContactos = new javax.swing.JLabel();
        jPanelFooter = new javax.swing.JPanel();
        jBtnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 590));
        setName("frmContactos"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelHeader.setBackground(new java.awt.Color(51, 153, 255));
        jPanelHeader.setMaximumSize(new java.awt.Dimension(800, 50));
        jPanelHeader.setMinimumSize(new java.awt.Dimension(800, 50));
        jPanelHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jPanel3.setMaximumSize(new java.awt.Dimension(750, 50));
        jPanel3.setMinimumSize(new java.awt.Dimension(750, 50));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(750, 50));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONTACTOS");
        jPanel3.add(jLabel1);

        jPanelHeader.add(jPanel3);

        jBtnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/cerrar_celeste_30.jpg"))); // NOI18N
        jBtnCerrar.setMaximumSize(new java.awt.Dimension(30, 30));
        jBtnCerrar.setMinimumSize(new java.awt.Dimension(30, 30));
        jBtnCerrar.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/cerrar_celeste_30_presionado.jpg"))); // NOI18N
        jBtnCerrar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/cerrar_celeste_30_presionado.jpg"))); // NOI18N
        jBtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCerrarActionPerformed(evt);
            }
        });
        jPanelHeader.add(jBtnCerrar);

        getContentPane().add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(800, 480));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(800, 480));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 480));

        jPanelListadoContactos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelListadoContactos.setMaximumSize(new java.awt.Dimension(800, 480));
        jPanelListadoContactos.setMinimumSize(new java.awt.Dimension(800, 480));
        jPanelListadoContactos.setPreferredSize(new java.awt.Dimension(800, 0));
        jPanelListadoContactos.setLayout(new javax.swing.BoxLayout(jPanelListadoContactos, javax.swing.BoxLayout.Y_AXIS));

        jLSinContactos.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLSinContactos.setForeground(new java.awt.Color(102, 102, 102));
        jLSinContactos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLSinContactos.setText("Al parecer, no tenés contactos...");
        jLSinContactos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLSinContactos.setMaximumSize(new java.awt.Dimension(800, 480));
        jLSinContactos.setMinimumSize(new java.awt.Dimension(800, 480));
        jLSinContactos.setPreferredSize(new java.awt.Dimension(800, 480));
        jPanelListadoContactos.add(jLSinContactos);

        jScrollPane1.setViewportView(jPanelListadoContactos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jPanelFooter.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFooter.setMaximumSize(new java.awt.Dimension(800, 60));
        jPanelFooter.setMinimumSize(new java.awt.Dimension(800, 60));
        jPanelFooter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jBtnAgregar.setBackground(new java.awt.Color(51, 153, 255));
        jBtnAgregar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jBtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAgregar.setText("NUEVO CONTACTO");
        jBtnAgregar.setBorderPainted(false);
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });
        jPanelFooter.add(jBtnAgregar);

        getContentPane().add(jPanelFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 800, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        // TODO add your handling code here:
        //ABRIR VENTANA CONTACTO
        frmModificarContacto vModificarContacto = new frmModificarContacto(frmModificarContacto.VENTANA_AGREGAR,this.idUsuario,-1);
        this.setVisible(false);
        vModificarContacto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnAgregarActionPerformed

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed
        // TODO add your handling code here:
        frmPrincipal vPrincipal = new frmPrincipal(this.idUsuario);
        this.setVisible(false);
        vPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(frmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmContactos(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JLabel jLSinContactos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelListadoContactos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
