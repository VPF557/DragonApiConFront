package org.vaadin.example;

import com.google.gson.Gson;
import com.googlecode.gentyref.TypeToken;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class DataService {
    private static final String urlPrefix = "http://localhost:8081/registro";

    public static ArrayList<Parametro> getProductos(ArrayList<Parametro> listaTweets) throws URISyntaxException {

        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(urlPrefix)).GET().build();
        Gson gson = new Gson();
        String resultado = null;
        HttpResponse<String> respuesta = null;

        try {
            respuesta = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
            resultado = respuesta.body();
            listaTweets = gson.fromJson(resultado, new TypeToken<ArrayList<Parametro>>(){}.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return listaTweets;
    }


    public static ArrayList<Parametro> aniadirDatosLista(Parametro productoNuevo, ArrayList<Parametro> listaTweets){
        Gson g = new Gson();
        String urlPrefix = "http://localhost:8081/peticion";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String datospasar = productoNuevo.toString();
        StringEntity entidad = null;
        try {
            entidad = new StringEntity(datospasar);
            HttpPost requestpuesta = new HttpPost(urlPrefix);
            requestpuesta.setHeader("Content-Type", "application/json");
            requestpuesta.setHeader("Accept", "application/json");
            requestpuesta.setEntity(entidad);
            CloseableHttpResponse response = null;
            response = httpClient.execute(requestpuesta);
            String respuestaActual = new BasicResponseHandler().handleResponse(response);
            listaTweets = g.fromJson(respuestaActual, new TypeToken<ArrayList<Parametro>>(){}.getType());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (HttpResponseException e) {
            throw new RuntimeException(e);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listaTweets;
    }
/*
    public static ArrayList<Criptomoneda> eliminarTweet(Criptomoneda productoNuevo, ArrayList<Criptomoneda> listaTweets){
        Gson g = new Gson();
        String urlPrefix = "http://localhost:8081/CriptoB?id=" + productoNuevo.getId();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String datospasar = productoNuevo.mostrarJson();
        StringEntity entidad = null;
        try {
            entidad = new StringEntity(datospasar);
            HttpDelete requestpuesta = new HttpDelete(urlPrefix);
            requestpuesta.setHeader("Content-Type", "application/json");
            requestpuesta.setHeader("Accept", "application/json");
            CloseableHttpResponse response = null;
            response = httpClient.execute(requestpuesta);
            String respuestaActual = new BasicResponseHandler().handleResponse(response);
            listaTweets = g.fromJson(respuestaActual, new TypeToken<ArrayList<Criptomoneda>>(){}.getType());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (HttpResponseException e) {
            throw new RuntimeException(e);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listaTweets;
    }
*/
}
