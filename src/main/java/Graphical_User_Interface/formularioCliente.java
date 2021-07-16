package Graphical_User_Interface;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import javax.swing.JOptionPane;

import traductorUDP.servidorTranslate;

public class formularioCliente extends javax.swing.JFrame {

    public String msjTextArea;
    public String msjRespuesta;
    public String en_to_es;
    public String es_to_en;

    public formularioCliente() {
        initComponents();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.jRadioButton1.setSelected(true);
        this.setTitle("UNAN TRANSLATE");

        this.jTextArea2.setEditable(false); // sino se inserta la info, es por esto.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenido al Asistente Traductor");
        jLabel1.setName("header"); // NOI18N

        jLabel2.setText("Texto a traducir:");
        jLabel2.setName("rotulo"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("inputText"); // NOI18N
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setName("outputText"); // NOI18N
        jScrollPane2.setViewportView(jTextArea2);

        jLabel3.setText("Traduccion:");
        jLabel3.setName("traduccion"); // NOI18N

        jRadioButton1.setText("EN_to_ES");
        jRadioButton1.setName("en_to_es"); // NOI18N
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        jRadioButton2.setText("ES_to_EN");
        jRadioButton2.setName("es_to_en"); // NOI18N
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        jButton1.setText("Traducir");
        jButton1.setName("translate"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jRadioButton1)
                        .addGap(28, 28, 28)
                        .addComponent(jRadioButton2)
                        .addGap(60, 60, 60)
                        .addComponent(jButton1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jButton1))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:

        //para clickear un solo jradiobutton.
        if (jRadioButton1.isSelected())
            jRadioButton2.setSelected(false);
        else if (!(jRadioButton1.isSelected() && jRadioButton2.isSelected()))
            jRadioButton1.setSelected(true);
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        // TODO add your handling code here:

        //para clickear un solo jradiobutton.
        if (jRadioButton2.isSelected())
            jRadioButton1.setSelected(false);
        else if (!(jRadioButton1.isSelected() && jRadioButton2.isSelected()))
            jRadioButton2.setSelected(true);
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        // TODO add your handling code here:

        if (!Character.isLetter(evt.getKeyChar())
                && !(evt.getKeyChar() == KeyEvent.VK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        this.msjTextArea = this.jTextArea1.getText();

        if (this.jRadioButton1.isSelected()) {
            this.en_to_es = "true";
            this.es_to_en = "false";
        } else if (this.jRadioButton2.isSelected()) {
            this.es_to_en = "true";
            this.en_to_es = "false";
        }

        //this.jTextArea2.setText(this.msjRespuesta);
        try {
            DatagramSocket socketUDP = new DatagramSocket();

            String cad = this.msjTextArea + "." + this.en_to_es + "." + this.es_to_en;

            //JOptionPane.showMessageDialog(null, cad);
            try {
                byte[] mensaje = cad.getBytes();
                InetAddress hostServer = InetAddress.getByName("localhost");
                final int port = 5001;

                DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServer, port);

                socketUDP.send(peticion);

            } catch (Exception host) {
                JOptionPane.showMessageDialog(null, "Servidor no encontrado: " + host.getMessage());
            }

            byte[] buffer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);

            socketUDP.receive(respuesta);

            this.msjRespuesta = new String(respuesta.getData(), 0, respuesta.getLength());

            this.jTextArea2.setText(this.msjRespuesta);

            //socketUDP.close();

        } catch (SocketException e) {
            JOptionPane.showMessageDialog(null, "Socket: " + e.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IO Exception: " + ex.getMessage());
        } catch (NullPointerException ei) {
            JOptionPane.showMessageDialog(null, "NullPointerException: " + ei.getMessage());
        } catch (Exception host) {
            JOptionPane.showMessageDialog(null, "Servidor no encontrado: " + host.getMessage(), "Error Debug", 0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formularioCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
