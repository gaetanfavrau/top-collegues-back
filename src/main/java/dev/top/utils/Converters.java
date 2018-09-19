package dev.top.utils;

import org.springframework.core.convert.converter.Converter;

import dev.top.controller.view.CollegueView;
import dev.top.controller.view.DetailsCollegueView;
import dev.top.entities.Collegue;


public interface Converters {

	Converter<Collegue, CollegueView> COLLEGUE_TO_COLLEGUE_VIEW = source -> {
		CollegueView collegueWeb = new CollegueView();

		collegueWeb.setPseudo(source.getPseudo());
		collegueWeb.setScore(source.getScore());
		collegueWeb.setPhoto(source.getPhoto());

		return collegueWeb;
	};

	Converter<CollegueView, Collegue> COLLEGUE_VIEW_TO_COLLEGUE = source -> {
		Collegue collRepo = new Collegue();

		collRepo.setPseudo(source.getPseudo());
		collRepo.setScore(source.getScore());
		collRepo.setPhoto(source.getPhoto());

		return collRepo;
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
