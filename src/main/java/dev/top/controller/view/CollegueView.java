package dev.top.controller.view;

public class CollegueView {

    private String pseudo;
    private Integer score;
    private String photo;

    public CollegueView(String pseudo, Integer score, String photo) {
	this.pseudo = pseudo;
	this.score = score;
	this.photo = photo;
    }

    public CollegueView() {
    }

    public String getPseudo() {
	return pseudo;
    }

    public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
    }

    public Integer getScore() {
	return score;
    }

    public void setScore(Integer score) {
	this.score = score;
    }

    public String getPhoto() {
	return photo;
    }

    public void setPhoto(String photo) {
	this.photo = photo;
    }

}
