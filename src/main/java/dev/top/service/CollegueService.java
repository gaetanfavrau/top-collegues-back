package dev.top.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import dev.top.controller.view.AvisView;
import dev.top.controller.view.CollegueFormulaireView;
import dev.top.controller.view.CollegueView;
import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.entities.CollegueSource;
import dev.top.exceptions.DoublonBDDException;
import dev.top.exceptions.MatriculeInvalideException;
import dev.top.exceptions.PseudoInvalideException;
import dev.top.repository.CollegueRepo;
import dev.top.utils.Converters;

@Service
@Transactional
public class CollegueService {

    private CollegueRepo repository;

    public CollegueService(CollegueRepo repository) {
	this.repository = repository;
    }

    public void send(Collegue collegue) {

	this.repository.save(collegue);

    }

    public Collegue editScore(AvisView avisView, String pseudo) throws ServiceException, PseudoInvalideException {

	return this.repository.findByPseudo(pseudo).map(collegueTrouve -> {

	    if (Avis.AIMER.equals(avisView.getAction())) {
		collegueTrouve.setScore(collegueTrouve.getScore() + 10);
	    }

	    if (Avis.DETESTER.equals(avisView.getAction())) {
		collegueTrouve.setScore(collegueTrouve.getScore() - 5);
	    }

	    this.repository.save(collegueTrouve);

	    return collegueTrouve;
	}).orElseThrow(() -> new PseudoInvalideException());

    }

    public void delete(CollegueView deleteCollegueView) {
	// TODO Auto-generated method stub

    }

    public List<Collegue> findAllCollegue() {

	return this.repository.findAll();
    }

    public Collegue findCollegue(String pseudo) throws ServiceException, PseudoInvalideException {

	return this.repository.findByPseudo(pseudo).map(collegueTrouve -> {
	    return collegueTrouve;
	}).orElseThrow(() -> new PseudoInvalideException());
    }

    public Collegue findCollegueByMatriculeFromWebApi(CollegueFormulaireView collegueFormulaireView)
	    throws ServiceException, MatriculeInvalideException {

	RestTemplate restTemplate = new RestTemplate();
	CollegueSource[] list = restTemplate.getForObject(
		"http://collegues-api.cleverapps.io/collegues?matricule=" + collegueFormulaireView.getMatricule(),
		CollegueSource[].class);

	if (list.length == 1) {
	    if (this.repository.findByMatricule(collegueFormulaireView.getMatricule()) == null) {
		Collegue collegue = Converters.COLLEGUE_SOURCE_TO_COLLEGUE.convert(list[0]);
		if (collegueFormulaireView.getPhoto() != null) {
		    collegue.setPhoto(collegueFormulaireView.getPhoto());
		}
		collegue.setPseudo(collegueFormulaireView.getPseudo());
		collegue.setScore(0);
		return collegue;
	    } else {
		throw new DoublonBDDException();
	    }
	} else {
	    throw new MatriculeInvalideException();
	}

    }

}
