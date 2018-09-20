package dev.top.utils;

import org.springframework.core.convert.converter.Converter;

import dev.top.controller.view.CollegueView;
import dev.top.controller.view.DetailsCollegueView;
import dev.top.entities.Adresse;
import dev.top.entities.Collegue;
import dev.top.entities.CollegueSource;


public interface Converters {

	Converter<Collegue, CollegueView> COLLEGUE_TO_COLLEGUE_VIEW = source -> {
		CollegueView collegueWeb = new CollegueView();

		collegueWeb.setPseudo(source.getPseudo());
		collegueWeb.setScore(source.getScore());
		collegueWeb.setPhoto(source.getPhoto());

		return collegueWeb;
	};

	Converter<CollegueView, Collegue> COLLEGUE_VIEW_TO_COLLEGUE = source -> {
		Collegue collegue = new Collegue();

		collegue.setPseudo(source.getPseudo());
		collegue.setScore(source.getScore());
		collegue.setPhoto(source.getPhoto());

		return collegue;
	};


	Converter<CollegueSource, Collegue> COLLEGUE_SOURCE_TO_COLLEGUE = source -> {
		Collegue collegue = new Collegue();
		
		collegue.setEmail(source.getEmail());
		collegue.setNom(source.getNom());
		collegue.setPrenom(source.getPrenom());
		collegue.setPhoto(source.getPhoto());
		collegue.setMatricule(source.getMatricule());
		
		String adresseSource = source.getAdresse();
		String[] splitAdresseComplete = adresseSource.split(",");
		String[] splitAdresseNumAndLibelle = splitAdresseComplete[0].split(" ");
		
		Adresse adresse = new Adresse();
		
		adresse.setNumero(Integer.parseInt(splitAdresseNumAndLibelle[0]));
		adresse.setLibelle(splitAdresseNumAndLibelle[1] + " " + splitAdresseNumAndLibelle[2]);
		adresse.setVille(splitAdresseComplete[1].trim());
		adresse.setCodePostal(Integer.parseInt(splitAdresseComplete[2].trim()));
		
		collegue.setAdresse(adresse);
		
		return collegue;
	
	};



	Converter<Collegue, DetailsCollegueView> COLLEGUE_TO_DETAILS_COLLEGUE = source -> {

		DetailsCollegueView detailsCollegueView = new DetailsCollegueView();

		detailsCollegueView.setAdresse(source.getAdresse());
		detailsCollegueView.setEmail(source.getEmail());
		detailsCollegueView.setNom(source.getNom());
		detailsCollegueView.setPrenom(source.getPrenom());
		detailsCollegueView.setPseudo(source.getPseudo());
		detailsCollegueView.setScore(source.getScore());
		detailsCollegueView.setPhoto(source.getPhoto());

		return detailsCollegueView;

	};
}


