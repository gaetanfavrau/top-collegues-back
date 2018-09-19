package dev.top.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.top.controller.view.AvisView;
import dev.top.controller.view.CollegueView;
import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.exceptions.PseudoInvalideException;
import dev.top.repository.CollegueRepo;

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

}
