package dev.top.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	private Integer numero;
	private String libelle;
	private Integer codePostal;
	private String ville;
	
	public Adresse(Integer numero, String libelle, Integer codePostal, String ville) {
		this.numero = numero;
		this.libelle = libelle;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	

	public Adresse() {
	}



	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	
	

}
