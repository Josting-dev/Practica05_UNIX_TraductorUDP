package traductorUDP;

import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class servidorTranslate {

    public static void main(String[] args) throws UnknownHostException {

        //Translate packet = null;
        dataTR packet = null;
        final int port = 5001;

        try {
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] buffer = new byte[1000];

            System.out.println("Servidor a Escucha de Peticiones...");

            while (true) {
                //contruimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                //leemos una peticion del DatagramSocket
                socketUDP.receive(peticion);

                System.out.print("Datagrama recibido del host: "
                        + peticion.getAddress());
                System.out.println(" desde el puerto remoto: "
                        + peticion.getPort());

                String cad = new String(peticion.getData(), 0, peticion.getLength());
                String[] __split = cad.split("\\.");

                //ejecucion del hilo
                //packet = new Translate();
                packet = new dataTR();
                packet.setMsj(__split[0]);
                packet.setEn(__split[1]);
                packet.setEs(__split[2]);
                packet.start();

                try {
                    packet.join();

                    //System.out.println(packet.getEnvio());
                    //envio de la traducion
                    byte[] traduction = packet.getEnvio().getBytes();

                    //construimos el DatagramaPacket para enviar la respuesta
                    DatagramPacket respuesta = new DatagramPacket(traduction, traduction.length, peticion.getAddress(), peticion.getPort());
                    socketUDP.send(respuesta);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }

        } catch (SocketException e) {
            JOptionPane.showMessageDialog(null, "Socket: " + e.getMessage(), "Error Dialog", 0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IO: " + ex.getMessage(), "Error Dialog", 0);
        }
    }
}
