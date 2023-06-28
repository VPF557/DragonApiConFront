package DragonApi.example.DragonApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {

    LeerJson reader = new LeerJson();
    DataHanding data = new DataHanding();
    EscribirJson writter = new EscribirJson();

    @GetMapping("/registro")
    public ArrayList<Parametro> listaObjeto1()
    {
        //Leemos el reason e introducimos los elementos en un arraylist
        ArrayList<Parametro> listaPeticiones = reader.LeerFicheroPeticiones("Peticiones.json");
        //Mostramos los elementos leidos
        return listaPeticiones;
    }

    @PostMapping("/peticion")
    public void mandarElemento(@RequestBody Parametro objeto1)
    {
        //Hecho
        ArrayList<Pokemon> listaPokemons = reader.LeerFicheroPokemons("Pokemons.json");
        ArrayList<Parametro> listaPeticiones = reader.LeerFicheroPeticiones("Peticiones.json");
        ArrayList<Tipo> listaTipo = reader.LeerFicheroTipos("Tipos.json");

        if(objeto1.getParameter1().equals("type"))
        {
            Tipo tipo = new Tipo();
            tipo = data.obtenerTipo(objeto1);
            listaTipo.add(tipo);
            writter.escribirJsonTipo(listaTipo);

        }
        else
        {
            Pokemon pokemon = new Pokemon();
            pokemon = data.obtenerPokemon(objeto1);
            listaPokemons.add(pokemon);
            writter.escribirJsonPokemon(listaPokemons);

        }

        listaPeticiones.add(objeto1);

        writter.escribirJsonPeticiones(listaPeticiones);
    }

}
