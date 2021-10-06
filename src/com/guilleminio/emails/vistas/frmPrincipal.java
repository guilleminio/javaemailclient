/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.vistas;

import com.guilleminio.emails.controladora.PrincipalControladora;
import com.guilleminio.emails.modelos.EmailEnvio;
import com.guilleminio.emails.modelos.EmailRecibido;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Guille
 */
public class frmPrincipal extends javax.swing.JFrame implements IVentana{

    private static final String VENTANA_RECIBIDOS = "RECIBIDOS";
    private static final String VENTANA_ENVIADOS = "ENVIADOS";
    private static final String VENTANA_BORRADORES ="BORRADORES";
    
    private static final int LISTADO_RECIBIDOS = 0;
    private static final int LISTADO_ENVIADOS = 1;
    private static final int LISTADO_BORRADORES = 2;
    
    private int listadoActual;
    private JScrollPane scrollEmails;
    
    private PrincipalControladora controladora;
    private int usuarioActual;
    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal( int aIdUsuario ) {
        initComponents();
        this.usuarioActual = aIdUsuario;
        inicializarVentana();
    }

    private void cambiarBotonesSegunSeccion( int aListadoActual ){
        
        switch ( aListadoActual ){
            case frmPrincipal.LISTADO_RECIBIDOS:
                this.jBtnRecibidos.setBackground(new Color(51,153,200));
                this.jBtnBorradores.setBackground(new Color(51,153,255));
                this.jBtnEnviados.setBackground(new Color(51,153,255));
                break;
            case frmPrincipal.LISTADO_ENVIADOS:
                this.jBtnRecibidos.setBackground(new Color(51,153,255));
                this.jBtnBorradores.setBackground(new Color(51,153,255));
                this.jBtnEnviados.setBackground(new Color(51,153,200));
                break;
            case frmPrincipal.LISTADO_BORRADORES:
                this.jBtnRecibidos.setBackground(new Color(51,153,255));
                this.jBtnBorradores.setBackground(new Color(51,153,200));
                this.jBtnEnviados.setBackground(new Color(51,153,255));
                break;
            default:
                this.jBtnRecibidos.setBackground(new Color(51,153,255));
                this.jBtnBorradores.setBackground(new Color(51,153,255));
                this.jBtnEnviados.setBackground(new Color(51,153,255));
                break;
        }
        
    }
    
    private void cargarImagenUsuario( JLabel aLabel, String aImgPath ){
        
        ImageIcon img = new ImageIcon(aImgPath);
        
        if ( (aImgPath == null) || (img.getImageLoadStatus() == MediaTracker.ERRORED)){
            
            img = new ImageIcon("res\\imagenes_usuarios\\user_default.jpg");
        }
        Icon icon = new ImageIcon(img.getImage().getScaledInstance(aLabel.getPreferredSize().width, aLabel.getPreferredSize().width, Image.SCALE_DEFAULT));
        
        aLabel.setIcon(icon);
        
    }
    
    private void configurarEncabezado(){
        
        this.cargarImagenUsuario(this.jLImagenUsuario, this.controladora.obtenerUsuarioActual().getImagenPathUsuario());
            
        String nombre = "¡Hola, " + this.controladora.obtenerUsuarioActual().getNombreUsuario() + "!";
        this.jLNombreUsuario.setText(nombre);
        
        this.jLTituloVentana.setText(frmPrincipal.VENTANA_RECIBIDOS);
    }
    
    private void configurarContenedor(){
        
        //Va a ser distinto de null cuando se actualiza el listado de emails.
        if ( this.scrollEmails != null){
            this.jPanelPrincipal.remove(this.scrollEmails);
            this.jPanelPrincipal.updateUI();
        }
        
        this.scrollEmails = new JScrollPane(this.jPanelEmails);
        this.scrollEmails.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollEmails.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.scrollEmails.setBounds(50, 30, 300, 50);
        this.scrollEmails.setPreferredSize(this.jPanelPrincipal.getPreferredSize());
        this.jPanelPrincipal.add(this.scrollEmails);
        
    }
    
    
    private void obtenerEmailsRecibidos(){
        
        this.controladora.establecerListadoEmailsRecibidos();
        generarListadoEmails(PrincipalControladora.LISTADO_RECIBIDOS);
    }
    
    private void obtenerEmailsEnviados(){
        
        this.controladora.establecerListadoEmailsEnviados();
        generarListadoEmails(PrincipalControladora.LISTADO_ENVIADOS);
    }
  
    private void obtenerEmailsBorradores(){
        
       this.controladora.establecerListadoEmailsBorradores();
       generarListadoEmails(PrincipalControladora.LISTADO_BORRADORES);
    }
    
    
    private void generarListadoEmails( int aTipoListado ){
        
        this.jPanelEmails.removeAll();
        this.jPanelEmails.updateUI();
       
        int totalEmails = this.controladora.obtenerListadoEmails( aTipoListado ).size();
        
        if ( totalEmails > 0 ){
            
            final JPanel panelEmails[] = new JPanel[315];
            
            configurarContenedor();
            
            for ( int i = 0; i < totalEmails; i++){

                this.controladora.establecerEmailActual(i);
                
                //ITEM EMAIL 
                panelEmails[i] = new JPanel();
                panelEmails[i].setLayout(new FlowLayout(FlowLayout.LEADING,2,5));
                panelEmails[i].setBackground(new Color(204,204,204));
                panelEmails[i].setMinimumSize(new Dimension(1000,50));
                panelEmails[i].setMaximumSize(new Dimension(1000,50));
                panelEmails[i].setPreferredSize(new Dimension(1000,50));
                panelEmails[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); 

                      
                if ( (this.controladora.obtenerEmailActual().getTipoEmail().equals(EmailRecibido.class.getSimpleName())) && (!this.controladora.obtenerEmailActual().isLeidoEmailRecibido())){
                    panelEmails[i].setBackground(Color.WHITE);
                }
                
                    /*------------------------- PANEL DIRECCIÓN DE EMAIL ---------------------------*/
                        JPanel panelDireccionEmail = new JPanel();
                        panelDireccionEmail.setMinimumSize(new Dimension(250,40));
                        panelDireccionEmail.setMaximumSize(new Dimension(250,40));
                        panelDireccionEmail.setPreferredSize(new Dimension(250,40));
                        panelDireccionEmail.setOpaque(false);    

                            JLabel lbDireccionEmail = new JLabel();
                            lbDireccionEmail.setMinimumSize(new Dimension(250,panelDireccionEmail.getPreferredSize().height));
                            lbDireccionEmail.setMaximumSize(new Dimension(250,panelDireccionEmail.getPreferredSize().height));
                            lbDireccionEmail.setOpaque(false);
                            lbDireccionEmail.setFont(new java.awt.Font("Tahoma", 0, 18));
                               
                            
                        panelDireccionEmail.add(lbDireccionEmail);
                        panelEmails[i].add(panelDireccionEmail);
                    /*-----------------------------------------------------------------------------*/

                    /*--------------------------------- PANEL ASUNTO -------------------------------*/
                        JPanel panelAsunto = new JPanel();
                        panelAsunto.setPreferredSize(new Dimension(600,40));
                        panelAsunto.setOpaque(false);

                            JLabel lbAsunto = new JLabel();
                            lbAsunto.setMinimumSize(new Dimension(600,panelAsunto.getPreferredSize().height));
                            lbAsunto.setText(this.controladora.obtenerEmailActual().getAsuntoEmail());
                            lbAsunto.setFont(new java.awt.Font("Tahoma", 0, 18));
                            lbAsunto.setOpaque(false);

                        panelAsunto.add(lbAsunto);
                        panelEmails[i].add(panelAsunto);

                    /*----------------------------------------------------------------------*/

                    /*------------------------------- PANEL FECHA --------------------------*/
                        JPanel panelFecha = new JPanel();
                        panelFecha.setPreferredSize(new Dimension(120,40));
                        panelFecha.setBackground(Color.WHITE);    
                        panelFecha.setOpaque(false);

                            JLabel lbFecha = new JLabel();
                            lbFecha.setMinimumSize(new Dimension(120,panelFecha.getPreferredSize().height));
                            lbFecha.setMaximumSize(new Dimension(120,panelFecha.getPreferredSize().height));
                            lbFecha.setFont(new java.awt.Font("Tahoma", 0, 18));
                            lbFecha.setOpaque(false);

                        panelFecha.add(lbFecha);
                        panelEmails[i].add(panelFecha);

                    /*---------------------------------------------------------------------*/

                //COMPLETO FECHA Y DIRECCIÓN SEGÚN CORRESPONDA
                String fecha;
                Date fechaEmail = new Date();

                if ( this.controladora.obtenerEmailActual() instanceof EmailRecibido){
                    lbDireccionEmail.setText(this.controladora.obtenerEmailActual().getOrigenEmailRecibido());
                    fechaEmail = this.controladora.obtenerEmailActual().getFechaLlegadaEmailRecibido();

                }else{
                    lbDireccionEmail.setText(this.controladora.obtenerEmailActual().getDestinoEmailEnvio());

                    if ( this.controladora.obtenerEmailActual().getEstadoEmail().equals(EmailEnvio.ESTADO_EMAIL_BORRADOR))
                        fechaEmail = this.controladora.obtenerEmailActual().getFechaCreacionEmailEnvio();
                    else
                        fechaEmail = this.controladora.obtenerEmailActual().getFechaEnvioEmailEnvio();
                }


                if( fechaEmail != null )
                     fecha = new SimpleDateFormat("dd-MM-yyyy").format(fechaEmail);
                else
                     fecha = "";

                lbFecha.setText(fecha);

                final int index = i;
                panelEmails[i].addMouseListener(new MouseListener() {
                     @Override
                     public void mouseClicked(MouseEvent e) {

                        frmEmail vEmail;
                        controladora.establecerEmailActual(index);
                        if ( controladora.obtenerEmailActual() instanceof EmailRecibido ){
                            vEmail = new frmEmail(frmEmail.VENTANA_EMAIL_RECIBIDO,controladora.obtenerUsuarioActual().getIdUsuario(), controladora.obtenerEmailActual().getIdEmail(), -1,new IEmailListener() {
                                @Override
                                public void actualizarListados() {
                                    obtenerEmailsRecibidos();
                                }
                            });
                        }else
                                if (controladora.obtenerEmailActual().getEstadoEmail().equals(EmailEnvio.ESTADO_EMAIL_ENVIADO)){
                                    vEmail = new frmEmail(frmEmail.VENTANA_EMAIL_ENVIADO,controladora.obtenerUsuarioActual().getIdUsuario(),controladora.obtenerEmailActual().getIdEmail(), -1,new IEmailListener() {
                                        @Override
                                        public void actualizarListados() {
                                            obtenerEmailsEnviados();
                                        }
                                    });
                                }else
                                    vEmail = new frmEmail(frmEmail.VENTANA_EMAIL_BORRADOR,controladora.obtenerUsuarioActual().getIdUsuario(),controladora.obtenerEmailActual().getIdEmail(), -1,new IEmailListener() {
                                            @Override
                                            public void actualizarListados() {
                                                obtenerEmailsBorradores();
                                            }
                        });

                       
                        vEmail.setVisible(true);
                     
                     }

                     @Override
                     public void mousePressed(MouseEvent e) {

                     }

                     @Override
                     public void mouseReleased(MouseEvent e) {

                     }

                     @Override
                     public void mouseEntered(MouseEvent e) {

                        panelEmails[index].setCursor(new Cursor(Cursor.HAND_CURSOR)); 
                        panelEmails[index].setBackground(Color.GRAY);
                     }

                     @Override
                     public void mouseExited(MouseEvent e) {
                        panelEmails[index].setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
                        
                        controladora.establecerEmailActual(index);
                        if ( (controladora.obtenerEmailActual() instanceof EmailRecibido) && (!controladora.obtenerEmailActual().isLeidoEmailRecibido()) )
                           panelEmails[index].setBackground(Color.WHITE);
                        else
                                panelEmails[index].setBackground(new Color(204,204,204));
                        
                     }

                });

                this.jPanelEmails.add(panelEmails[i]);
         
            }
            
            
        }else{
             this.jLbSinEmails.setVisible(true);
             this.jPanelEmails.add(this.jLbSinEmails);
        }
        
        this.jPanelEmails.revalidate();
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
        jHeaderLeft = new javax.swing.JPanel();
        jLImagenUsuario = new javax.swing.JLabel();
        jLNombreUsuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLTituloVentana = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBtnModificarCuenta = new javax.swing.JButton();
        jBtnCerrar = new javax.swing.JButton();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jBtnNuevo = new javax.swing.JButton();
        jBtnRecibidos = new javax.swing.JButton();
        jBtnEnviados = new javax.swing.JButton();
        jBtnBorradores = new javax.swing.JButton();
        jBtnContactos = new javax.swing.JButton();
        jPanelEmails = new javax.swing.JPanel();
        jLbSinEmails = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 840));
        setName("frmPrincipal"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanelHeader.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHeader.setMaximumSize(new java.awt.Dimension(1200, 80));
        jPanelHeader.setMinimumSize(new java.awt.Dimension(1200, 80));
        jPanelHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jHeaderLeft.setBackground(new java.awt.Color(255, 255, 255));
        jHeaderLeft.setMaximumSize(new java.awt.Dimension(400, 80));
        jHeaderLeft.setMinimumSize(new java.awt.Dimension(400, 80));
        jHeaderLeft.setPreferredSize(new java.awt.Dimension(400, 80));
        jHeaderLeft.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLImagenUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLImagenUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLImagenUsuario.setMaximumSize(new java.awt.Dimension(80, 80));
        jLImagenUsuario.setMinimumSize(new java.awt.Dimension(80, 80));
        jLImagenUsuario.setOpaque(true);
        jLImagenUsuario.setPreferredSize(new java.awt.Dimension(80, 80));
        jHeaderLeft.add(jLImagenUsuario);

        jLNombreUsuario.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLNombreUsuario.setText("¡HOLA, USUARIO!");
        jHeaderLeft.add(jLNombreUsuario);

        jPanelHeader.add(jHeaderLeft);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 80));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 80));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 80));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jLTituloVentana.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLTituloVentana.setText("VENTANA");
        jPanel1.add(jLTituloVentana);

        jPanelHeader.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(285, 80));
        jPanel2.setMinimumSize(new java.awt.Dimension(285, 80));
        jPanel2.setPreferredSize(new java.awt.Dimension(285, 80));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 20));

        jBtnModificarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/config.jpg"))); // NOI18N
        jBtnModificarCuenta.setMaximumSize(new java.awt.Dimension(30, 30));
        jBtnModificarCuenta.setMinimumSize(new java.awt.Dimension(30, 30));
        jBtnModificarCuenta.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnModificarCuenta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/config_presionado.jpg"))); // NOI18N
        jBtnModificarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarCuentaActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnModificarCuenta);

        jBtnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/cerrar_30.jpg"))); // NOI18N
        jBtnCerrar.setMaximumSize(new java.awt.Dimension(30, 30));
        jBtnCerrar.setMinimumSize(new java.awt.Dimension(30, 30));
        jBtnCerrar.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnCerrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guilleminio/emails/recursos/cerrar_30_presionado.jpg"))); // NOI18N
        jBtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCerrar);

        jPanelHeader.add(jPanel2);

        getContentPane().add(jPanelHeader);

        jPanelPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        jPanelPrincipal.setMaximumSize(new java.awt.Dimension(1200, 760));
        jPanelPrincipal.setMinimumSize(new java.awt.Dimension(1200, 760));
        jPanelPrincipal.setLayout(new javax.swing.BoxLayout(jPanelPrincipal, javax.swing.BoxLayout.LINE_AXIS));

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setMaximumSize(new java.awt.Dimension(200, 760));
        jPanelMenu.setMinimumSize(new java.awt.Dimension(200, 760));
        jPanelMenu.setPreferredSize(new java.awt.Dimension(200, 760));
        jPanelMenu.setLayout(new javax.swing.BoxLayout(jPanelMenu, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(200, 500));
        jPanel3.setMinimumSize(new java.awt.Dimension(200, 500));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 500));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jBtnNuevo.setBackground(new java.awt.Color(51, 153, 255));
        jBtnNuevo.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jBtnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        jBtnNuevo.setText("NUEVO");
        jBtnNuevo.setMargin(new java.awt.Insets(10, 14, 10, 14));
        jBtnNuevo.setMaximumSize(new java.awt.Dimension(200, 50));
        jBtnNuevo.setMinimumSize(new java.awt.Dimension(200, 50));
        jBtnNuevo.setPreferredSize(new java.awt.Dimension(200, 50));
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnNuevo);

        jBtnRecibidos.setBackground(new java.awt.Color(51, 153, 255));
        jBtnRecibidos.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jBtnRecibidos.setForeground(new java.awt.Color(255, 255, 255));
        jBtnRecibidos.setText("RECIBIDOS");
        jBtnRecibidos.setMaximumSize(new java.awt.Dimension(200, 50));
        jBtnRecibidos.setMinimumSize(new java.awt.Dimension(200, 50));
        jBtnRecibidos.setPreferredSize(new java.awt.Dimension(200, 50));
        jBtnRecibidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRecibidosActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnRecibidos);

        jBtnEnviados.setBackground(new java.awt.Color(51, 153, 255));
        jBtnEnviados.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jBtnEnviados.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEnviados.setText("ENVIADOS");
        jBtnEnviados.setMaximumSize(new java.awt.Dimension(200, 50));
        jBtnEnviados.setMinimumSize(new java.awt.Dimension(200, 50));
        jBtnEnviados.setPreferredSize(new java.awt.Dimension(200, 50));
        jBtnEnviados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEnviadosActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnEnviados);

        jBtnBorradores.setBackground(new java.awt.Color(51, 153, 255));
        jBtnBorradores.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jBtnBorradores.setForeground(new java.awt.Color(255, 255, 255));
        jBtnBorradores.setText("BORRADORES");
        jBtnBorradores.setMaximumSize(new java.awt.Dimension(200, 50));
        jBtnBorradores.setMinimumSize(new java.awt.Dimension(200, 50));
        jBtnBorradores.setPreferredSize(new java.awt.Dimension(200, 50));
        jBtnBorradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBorradoresActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnBorradores);

        jBtnContactos.setBackground(new java.awt.Color(51, 153, 255));
        jBtnContactos.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jBtnContactos.setForeground(new java.awt.Color(255, 255, 255));
        jBtnContactos.setText("CONTACTOS");
        jBtnContactos.setMaximumSize(new java.awt.Dimension(200, 50));
        jBtnContactos.setMinimumSize(new java.awt.Dimension(200, 50));
        jBtnContactos.setPreferredSize(new java.awt.Dimension(200, 50));
        jBtnContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnContactosActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnContactos);

        jPanelMenu.add(jPanel3);

        jPanelPrincipal.add(jPanelMenu);

        jPanelEmails.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEmails.setMaximumSize(new java.awt.Dimension(1000, 760));
        jPanelEmails.setMinimumSize(new java.awt.Dimension(1000, 760));
        jPanelEmails.setLayout(new javax.swing.BoxLayout(jPanelEmails, javax.swing.BoxLayout.Y_AXIS));

        jLbSinEmails.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLbSinEmails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbSinEmails.setText("Al parecer, no tenés correos...");
        jLbSinEmails.setMaximumSize(new java.awt.Dimension(1000, 760));
        jLbSinEmails.setMinimumSize(new java.awt.Dimension(1000, 760));
        jLbSinEmails.setOpaque(true);
        jLbSinEmails.setPreferredSize(new java.awt.Dimension(1000, 760));
        jPanelEmails.add(jLbSinEmails);

        jPanelPrincipal.add(jPanelEmails);

        getContentPane().add(jPanelPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro querés cerrar sesión?","",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
        
        if ( opcion == JOptionPane.YES_OPTION){
            frmIniciarSesion vIniciarSesion = new frmIniciarSesion();
            this.setVisible(false);
            vIniciarSesion.setVisible(true);
            this.dispose();
        }
     
    }//GEN-LAST:event_jBtnCerrarActionPerformed

    private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
        // TODO add your handling code here:
        
        frmEmail vEmail = new frmEmail(frmEmail.VENTANA_NUEVO_EMAIL,this.usuarioActual,-1, -1,new IEmailListener() {
            @Override
            public void actualizarListados() {
                switch (listadoActual){
                    case frmPrincipal.LISTADO_RECIBIDOS:
                        obtenerEmailsRecibidos();
                        break;
                    case frmPrincipal.LISTADO_ENVIADOS:
                        obtenerEmailsEnviados();
                        break;
                    case frmPrincipal.LISTADO_BORRADORES:
                        obtenerEmailsBorradores();
                        break;
                }
               
            }
        });
        
        vEmail.setVisible(true);
      
    }//GEN-LAST:event_jBtnNuevoActionPerformed

    private void jBtnRecibidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRecibidosActionPerformed
        // TODO add your handling code here:
        this.listadoActual = frmPrincipal.LISTADO_RECIBIDOS;
        this.jLTituloVentana.setText(frmPrincipal.VENTANA_RECIBIDOS);
        this.obtenerEmailsRecibidos();
        cambiarBotonesSegunSeccion(frmPrincipal.LISTADO_RECIBIDOS);
      
    }//GEN-LAST:event_jBtnRecibidosActionPerformed

    private void jBtnEnviadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEnviadosActionPerformed
        // TODO add your handling code here:
        this.listadoActual = frmPrincipal.LISTADO_ENVIADOS;
        this.jLTituloVentana.setText(frmPrincipal.VENTANA_ENVIADOS);
        this.obtenerEmailsEnviados();
        cambiarBotonesSegunSeccion(frmPrincipal.LISTADO_ENVIADOS);
    }//GEN-LAST:event_jBtnEnviadosActionPerformed

    private void jBtnBorradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBorradoresActionPerformed
        // TODO add your handling code here:
        this.listadoActual = frmPrincipal.LISTADO_BORRADORES;
        this.jLTituloVentana.setText(frmPrincipal.VENTANA_BORRADORES);
        this.obtenerEmailsBorradores();
        cambiarBotonesSegunSeccion(frmPrincipal.LISTADO_BORRADORES);
    }//GEN-LAST:event_jBtnBorradoresActionPerformed

    private void jBtnModificarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarCuentaActionPerformed
        // TODO add your handling code here:
        frmModificarCuenta vModificarCuenta = new frmModificarCuenta(this.usuarioActual);
        this.setVisible(false);
        vModificarCuenta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnModificarCuentaActionPerformed

    private void jBtnContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnContactosActionPerformed
        // TODO add your handling code here:
        frmContactos vContactos = new frmContactos(this.usuarioActual);
        this.setVisible(false);
        vContactos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnContactosActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBorradores;
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JButton jBtnContactos;
    private javax.swing.JButton jBtnEnviados;
    private javax.swing.JButton jBtnModificarCuenta;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jBtnRecibidos;
    private javax.swing.JPanel jHeaderLeft;
    private javax.swing.JLabel jLImagenUsuario;
    private javax.swing.JLabel jLNombreUsuario;
    private javax.swing.JLabel jLTituloVentana;
    private javax.swing.JLabel jLbSinEmails;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelEmails;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void inicializarVentana() {
        this.setLocationRelativeTo(this);
        this.listadoActual = frmPrincipal.LISTADO_RECIBIDOS;
        this.controladora = new PrincipalControladora();
        this.controladora.obtenerUsuario(this.usuarioActual);
        this.controladora.establecerListadoEmailsRecibidos();
        configurarEncabezado();
        obtenerEmailsRecibidos();
        cambiarBotonesSegunSeccion(frmPrincipal.LISTADO_RECIBIDOS);
    }

    @Override
    public boolean formularioCompleto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void abrirVentana() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpiarErrores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
