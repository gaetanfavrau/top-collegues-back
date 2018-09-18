package dev.top.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.AvisView;
import dev.top.entities.CollegueView;
import dev.top.service.CollegueService;

@CrossOrigin //discussion entre deux ports/machines/protocoles différents (ici 4200 <-> 8080) => cas particulier du Js
@RestController()
@RequestMapping("/collegues")
public class CollegueCtrl {

    
    
    private CollegueService service;
	public CollegueCtrl(CollegueService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<CollegueView>> listerCollegues() {

		return ResponseEntity.ok(service.findAllCollegue());

	}

	@PostMapping
	public ResponseEntity<?> creerCollegue(@RequestBody CollegueView collegueView) {
		
		this.service.send(collegueView);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PatchMapping("/{pseudo}")
	public ResponseEntity<?> editeScoreCollegue(@RequestBody AvisView avisView, @PathVariable("pseudo") String pseudo) {
		
		this.service.editScore(avisView, pseudo);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}

}


