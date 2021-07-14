package traductorUDP;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;

import com.google.api.services.translate.Translate.Translations;
//import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;
import java.util.Arrays;

import com.google.cloud.translate.Translation;

/**
 *
 * @author jost-ale
 */
public class Translate extends Thread {

    private String msj;
    private String envio;
    private String en;
    private String es;

    @Override
    public void run() {
        try {
            this.setEnvio(this.amazonAWSTranslate(this.getMsj(), this.getEn(), this.getEs()));
        } catch (IOException ex) {
            Logger.getLogger(Translate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*public Translate(String mensaje, String en, String es){
        this.setMsj(mensaje);
        this.setEn(en);
        this.setEs(es);
    }*/
    
    public Translate() {

    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public String getMsj() {
        return this.msj;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getEn() {
        return this.en;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getEs() {
        return this.es;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public String getEnvio() {
        return this.envio;
    }

    public String translator(String text, String langTo, String langFrom) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbyDCQ0aY60Pd2d3qJZ6_-rXguVK78v7cerao6YrPS4in-ipWw0/exec"
                + "?q=" + URLEncoder.encode(text, "UTF-8")
                + "&target=" + langTo
                + "&source=" + langFrom;

        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //con.setRequestProperty("User-Agent", "Mozilla/78.11");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public String amazonAWSTranslate(String text, String en, String es) throws IOException {

        this.refreshCredentials();
        String REGION = "us-east-1";

        AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();

        AmazonTranslate translate = AmazonTranslateClient.builder()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds.getCredentials()))
                .withRegion(REGION)
                .build();

        TranslateTextRequest request = new TranslateTextRequest()
                .withText(text)
                .withSourceLanguageCode(en)
                .withTargetLanguageCode(es);

        TranslateTextResult result = translate.translateText(request);

        return result.getTranslatedText();
    }

    private void refreshCredentials() throws IOException {
        // Refresh credentials using a background thread, automatically every minute. This will log an error if IMDS is down during
        // a refresh, but your service calls will continue using the cached credentials until the credentials are refreshed
        // again one minute later.

        InstanceProfileCredentialsProvider credentials
                = InstanceProfileCredentialsProvider.createAsyncRefreshingProvider(true);

        AmazonS3Client.builder()
                .withCredentials(credentials)
                .build();

        // This is new: When you are done with the credentials provider, you must close it to release the background thread.
        credentials.close();
    }

    /*private void translateCredentials() {
        try {
            // See comments on 
            //   https://developers.google.com/resources/api-libraries/documentation/translate/v2/Java/latest/
            // on options to set
            Translate t = new Translate.Builder(
                    com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport(),
                     com.google.api.client.json.gson.GsonFactory.getDefaultInstance(), null)
                    //Need to update this to your App-Name
                    .setApplicationName("Stackoverflow-Example")
                    .build();
            Translate.Translations.List list = t.new Translations().list(
                    Arrays.asList(
                            //Pass in list of strings to be translated
                            "Hello World",
                            "How to use Google Translate from Java"),
                    //Target language   
                    "ES");
            //Set your API-Key from https://console.developers.google.com/
            list.setKey("AIzaSyBu_k5cYL2cB4ywZQBeIvstMWfd7QoaOhU");
            TranslationsListResponse response = list.execute();
            for (TranslationsResource tr : response.getTranslations()) {
                System.out.println(tr.getTranslatedText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
