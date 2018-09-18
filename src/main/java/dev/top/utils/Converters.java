package dev.top.utils;

import org.springframework.core.convert.converter.Converter;

import dev.top.entities.Collegue;
import dev.top.entities.CollegueView;


public class Converters {
	
	public static Converter<Collegue, CollegueView> converterCollegueToCollegueView = source -> {
		
		CollegueView collegueView = new CollegueView();
		
		collegueView.setPseudo(source.getPseudo());
		collegueView.setScore(source.getScore());
		collegueView.setPhoto(source.getPhoto());
		
		return collegueView;
	};
	
	public static Converter<CollegueView, Collegue> converterCollegueViewtoCollegue = source -> {
		
		Collegue collegue = new Collegue();
		
		collegue.setPseudo(source.getPseudo());
		collegue.setScore(source.getScore());
		collegue.setPhoto(source.getPhoto());
		
		return collegue;
	};

	
}
