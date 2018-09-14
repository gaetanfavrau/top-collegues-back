package dev.top.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@RestController()
@RequestMapping("/collegues")
public class CollegueCtrl {

    
    private CollegueRepo collegueRepo;
    

    public CollegueCtrl(CollegueRepo collegueRepo) {
		this.collegueRepo = collegueRepo;
	}

	
	
	@GetMapping
	public ResponseEntity<List<Collegue>> listerCollegues() {

		return ResponseEntity.ok(collegueRepo.findAll());

	}

	@PostMapping
	public ResponseEntity<?> creerCollegue(@RequestBody Collegue collegue) {

		this.collegueRepo.save(collegue);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}


