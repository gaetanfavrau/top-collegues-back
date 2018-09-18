package dev.top.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.top.entities.Avis;
import dev.top.entities.AvisView;
import dev.top.entities.Collegue;
import dev.top.entities.CollegueView;
import dev.top.repository.CollegueRepo;
import dev.top.utils.Converters;

@Service
@Transactional
public class CollegueService {
	
	private CollegueRepo repository;
	public CollegueService(CollegueRepo repository) {
		this.repository = repository;
	}
	

	public void send(CollegueView collegueView) {
		
		this.repository.save(Converters.converterCollegueViewtoCollegue.convert(collegueView));

	}

	public CollegueView editScore(AvisView avisView, String pseudo) {

		
		Collegue collegue = this.repository.findByPseudo(pseudo);
		
		if (avisView.getAction().equals(Avis.AIMER)) {
	
			Integer score = collegue.getScore() + 10;
			collegue.setScore(score);
		}
		
		if (avisView.getAction().equals(Avis.DETESTER)){
			
			Integer score = collegue.getScore() - 5;
			collegue.setScore(score);
		}
		
		this.repository.save(collegue);
		
		return Converters.converterCollegueToCollegueView.convert(collegue);		
		
		
	}

	public void delete(CollegueView deleteCollegueView) {
		// TODO Auto-generated method stub
		
	}


	public List<CollegueView> findAllCollegue() {
		
		return this.repository.findAll().stream().map(Converters.converterCollegueToCollegueView::convert).collect(Collectors.toList());
	}

}
