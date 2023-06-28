package DragonApi.example.DragonApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class Personaje
{
    @JsonProperty
    private String name;
    @JsonProperty
    private String origin;
    @JsonProperty
    private String species;

    public Personaje() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String MostrarJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
