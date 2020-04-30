package fr.epsi.b3.TPAndroid.model;

import org.json.JSONObject;

import java.io.Serializable;

public class Produit implements Serializable {

    private String libelle;
    private String description;

    public Produit(JSONObject jsonObject) {
        this.libelle = jsonObject.optString("libelle","");
        this.description = jsonObject.optString("description","");
    }

    public String getName() {

        return libelle;
    }

    public void setName(String name) {

        this.libelle = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.libelle;
    }
}
