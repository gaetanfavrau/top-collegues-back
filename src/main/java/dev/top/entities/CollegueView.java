package dev.top.entities;

public class CollegueView {
	
	private String pseudo;
    private Integer score;
    private String image;
    

	public CollegueView(String pseudo, Integer score, String image) {
		this.pseudo = pseudo;
		this.score = score;
		this.image = image;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	


    
    

}
