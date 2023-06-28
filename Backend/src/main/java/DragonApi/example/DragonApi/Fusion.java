package DragonApi.example.DragonApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class Fusion
{
    @JsonProperty
    private String name;
    @JsonProperty
    private String method_used;
    @JsonProperty
    private String species;

    public Fusion() {
    }

    public Fusion(String name, String method_used, String species) {
        this.name = name;
        this.method_used = method_used;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod_used() {
        return method_used;
    }

    public void setMethod_used(String method_used) {
        this.method_used = method_used;
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
