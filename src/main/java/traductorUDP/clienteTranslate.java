package traductorUDP;

import Graphical_User_Interface.formularioCliente;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class clienteTranslate {

    public static void main(String[] args) {
        formularioCliente cliente = new formularioCliente();
        cliente.setVisible(true);

        String cad;

        try {
            DatagramSocket socketUDP = new DatagramSocket();

            cad = cliente.msjTextArea + "." + cliente.en_to_es + "." + cliente.es_to_en;

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

            cliente.msjRespuesta = respuesta.getData().toString();

            socketUDP.close();

        } catch (SocketException e) {
            JOptionPane.showMessageDialog(null, "Socket: " + e.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IO Exception: " + ex.getMessage());
        } catch (NullPointerException ei) {
            JOptionPane.showMessageDialog(null, "NullPointerException: " + ei.getMessage());
        } catch (Exception host) {
            JOptionPane.showMessageDialog(null, "Servidor no encontrado: " + host.getMessage(), "Error Debug", 0);
        }

        /*invokeLater(new Runnable() {
            @Override
            public void run() {
                cliente.setVisible(true);
                 si hay problemas con el manejo de la informacion
                   sera porque todo el codigo del cliente debe de ir dentro
                   del metodo run() no? recordar eso.
            }
        });*/
    }
}
