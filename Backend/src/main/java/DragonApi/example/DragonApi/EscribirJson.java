package DragonApi.example.DragonApi;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscribirJson {
    static void escribirJsonPersonaje(ArrayList<Personaje> listaPokemon)
    {

        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("Personajes.json")) {
            gson.toJson(listaPokemon, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void escribirJsonPeticiones(ArrayList<Parametro> listaPokemon)
    {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("Peticiones.json")) {
            gson.toJson(listaPokemon, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void escribirJsonFusion(ArrayList<Fusion> listaTipo)
    {

        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("Fusiones.json")) {
            gson.toJson(listaTipo, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
