package DragonApi.example.DragonApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class Fusion
{
    @JsonProperty
    private String name;
    @JsonProperty
    private String url_scrap;

    public Fusion() {
    }

    public Fusion(String name, String url_scrap, String species) {
        this.name = name;
        this.url_scrap = url_scrap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod_used() {
        return url_scrap;
    }

    public void setUrl_scrap(String url_scrap) {
        this.url_scrap = url_scrap;
    }

    public String MostrarJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
