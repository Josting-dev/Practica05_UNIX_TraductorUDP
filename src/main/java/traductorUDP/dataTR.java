package traductorUDP;

import java.io.*;
import javax.swing.JOptionPane;

public class dataTR extends Thread {

    public int tipo; //0: ING_to_ESP, 1: ESP_to_ING
    private String palabra; //palabra a traducir
    private String envio;
    private String en;
    private String es;

    public dataTR() {

    }

    public void run() {

        this.setEnvio(this.translatorChafa());
    }

    public void setMsj(String mensaje) {
        this.palabra = mensaje;
    }

    public String getMsj() {
        return this.palabra;
    }

    private void setEnvio(String translate) {
        this.envio = translate;
    }

    public String getEnvio() {
        return this.envio;
    }

    public void setEn(String en) {
        this.en = en;
    }

    private String getEn() {
        return this.en;
    }

    public void setEs(String es) {
        this.es = es;
    }

    private String getEs() {
        return this.es;
    }

    private String translatorChafa() {
        String traduccion = null;
        String[] cad = null;
        String cadenaFinal = null;
        String path__English = "/home/jost-ale/NetBeansProjects/Practica05_SISDIS_22june2021/src/main/java/translationsDataBase/traducciones.txt";
        File fichero = new File(path__English);
        FileReader archivo;
        BufferedReader cadena;

        try {

            if (fichero.exists()) {
                archivo = new FileReader(path__English);
                cadena = new BufferedReader(archivo);

                while ((traduccion = cadena.readLine()) != null) {
                    cad = traduccion.split("\\-");
                    if (this.en.equals("true") && cad[0].compareTo(this.palabra) == 0) {
                        cadenaFinal = cad[1];
                        break;
                    } else if (this.es.equals("true") && cad[1].compareTo(this.palabra) == 0) {
                        cadenaFinal = cad[0];
                        break;
                    }
                }

                JOptionPane.showMessageDialog(null, "SELECCIONA LA TRADUCION VALIDA");
                cadenaFinal = "SELECCIONA LA TRADUCION VALIDA";

                /*
                  solo quiero ver si estar retornando la primera linea
                  para ver si sobre escribe el jTextArea2
                 */
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE EL ARCHIVO ESPECIFICADO");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException: " + ex.getMessage(), "IOException", 0);
        }

        return cadenaFinal;
    }

}
