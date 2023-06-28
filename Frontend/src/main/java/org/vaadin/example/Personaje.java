package org.vaadin.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class Personaje
{
    @JsonProperty
    private String name;
    @JsonProperty
    private String description;

    public Personaje(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Personaje() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String MostrarJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
