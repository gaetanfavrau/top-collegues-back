package dev.top.controller.view;

import dev.top.entities.Adresse;

public class DetailsCollegueView extends CollegueView {

    private String nom;
    private String prenom;
    private String email;
    private Adresse adresse;

    public DetailsCollegueView(String nom, String prenom, String email, Adresse adresse) {
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.adresse = adresse;
    }

    public DetailsCollegueView() {
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public String getPrenom() {
	return prenom;
    }

    public void setPrenom(String prenom) {
	this.prenom = prenom;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Adresse getAdresse() {
	return adresse;
    }

    public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
    }

}
