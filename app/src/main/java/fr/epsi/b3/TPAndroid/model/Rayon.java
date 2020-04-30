package fr.epsi.b3.TPAndroid.model;

import org.json.JSONObject;

import java.io.Serializable;

public class Rayon implements Serializable {

    private Integer idCategorie;
    private String titre;
    private String lien;

    public Rayon(JSONObject jsonObject) {
        idCategorie = Integer.parseInt(jsonObject.optString("idCategorie",""));
        titre = jsonObject.optString("titre","");
        lien = jsonObject.optString("lien","");
    }

    public Integer getidCategorie() {
        return idCategorie;
    }

    public void setidCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getTitle() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Override
    public String toString() {
        return this.titre;
    }
}
