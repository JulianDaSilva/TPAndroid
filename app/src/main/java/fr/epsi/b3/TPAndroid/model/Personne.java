package fr.epsi.b3.TPAndroid.model;

import java.io.Serializable;

public class Personne implements Serializable {

    private String firstname;
    private String nom;
    private String email;

    public Personne(String nom, String firstname, String email) {
        this.nom = nom;
        this.firstname = firstname;
        this.email = email;
    }

    public String getNom() {

        return nom;
    }

    public String getFirstname() {

        return firstname;
    }

    public String getEmail() {

        return email;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public void setFirstname(String firstname) {

        this.firstname = firstname;
    }

    public void setEmail(String email) {

        this.email = email;
    }

}
