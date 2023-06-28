package DragonApi.example.DragonApi;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class DataHanding {

    private final static String url = "https://dragonballapi-backend.vercel.app/%s/information/%s";
    //Peticiones 
    public Personaje obtenerPersonaje(Parametro params)
    {

        Personaje personaje = null;

        String peopleUrl = String.format(url, params.getParameter1(), params.getParameter2());

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(peopleUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonData = response.body();

            Gson gson = new Gson();
            personaje = gson.fromJson(jsonData, Personaje.class);

        } catch (URISyntaxException e) {
            System.out.println("Error al crear la request: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return personaje;
    }

    public Fusion obtenerFusion(Parametro params)
    {

        Fusion fusion = null;

        String peopleUrl = String.format(url, params.getParameter1(), params.getParameter2());

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(peopleUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonData = response.body();

            Gson gson = new Gson();
            fusion = gson.fromJson(jsonData, Fusion.class);

        } catch (URISyntaxException e) {
            System.out.println("Error al crear la request: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return fusion;
    }

    public ArrayList<Parametro> buscarObjeto(String param2, String ruta) {
        //En esta funcion se añaden los nuevos elementos enviados desde el front a un ArrayList para posteriormente actualizar la BBDD
        LeerJson reader = new LeerJson();
        ArrayList<Parametro> listaAux = reader.LeerFicheroPeticiones(ruta);
        for (int i = 0; i < listaAux.size(); i++) {
            if (listaAux.get(i).getParameter2().equals(param2)) {
                listaAux.remove(i);
            }
        }
        return listaAux;
    }

}
