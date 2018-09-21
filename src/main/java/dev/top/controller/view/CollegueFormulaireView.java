package dev.top.controller.view;

public class CollegueFormulaireView {

    private String matricule;
    private String pseudo;
    private String photo;

    @Override
    public String toString() {
	return "CollegueFormulaireView [matricule=" + matricule + ", pseudo=" + pseudo + ", photo=" + photo + "]";
    }

    public CollegueFormulaireView() {

    }

    public CollegueFormulaireView(String matricule, String pseudo, String photo) {
	this.matricule = matricule;
	this.pseudo = pseudo;
	this.photo = photo;
    }

    public String getMatricule() {
	return matricule;
    }

    public void setMatricule(String matricule) {
	this.matricule = matricule;
    }

    public String getPseudo() {
	return pseudo;
    }

    public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
    }

    public String getPhoto() {
	return photo;
    }

    public void setPhoto(String photo) {
	this.photo = photo;
    }

}
