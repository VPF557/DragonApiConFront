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
/*
    @GetMapping("/registro")
    public ArrayList<Parametro> listaObjeto1()
    {
        //Leemos el reason e introducimos los elementos en un arraylist
        ArrayList<Parametro> listaPeticiones = reader.LeerFicheroPeticiones("Peticiones.json");
        //Mostramos los elementos leidos
        return listaPeticiones;
    }
*/
    @PostMapping("/peticion")
    public void mandarElemento(@RequestBody Parametro objeto1)
    {
        //Hecho
        ArrayList<Personaje> listaPersonaje = reader.LeerFicheroPersonajes("Personajes.json");
        ArrayList<Parametro> listaPeticiones = reader.LeerFicheroPeticiones("Peticiones.json");
        ArrayList<Fusion> listaFusion = reader.LeerFicheroFusion("Fusiones.json");

        if(objeto1.getParameter1().equals("type"))
        {
            Fusion fusion = new Fusion();
            fusion = data.obtenerFusion(objeto1);
            listaFusion.add(fusion);
            writter.escribirJsonFusion(listaFusion);

        }
        else
        {
            Personaje personaje = new Personaje();
            personaje = data.obtenerPersonaje(objeto1);
            listaPersonaje.add(personaje);
            writter.escribirJsonPersonaje(listaPersonaje);

        }

        listaPeticiones.add(objeto1);
        writter.escribirJsonPeticiones(listaPeticiones);
    }

}
