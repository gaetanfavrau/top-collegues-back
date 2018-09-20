package dev.top.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import dev.top.controller.view.AvisView;
import dev.top.controller.view.CollegueFormulaireView;
import dev.top.controller.view.CollegueView;
import dev.top.controller.view.DetailsCollegueView;
import dev.top.entities.Collegue;
import dev.top.service.CollegueService;
import dev.top.utils.Converters;

@CrossOrigin // discussion entre deux ports/machines/protocoles différents (ici 4200 <->
	     // 8080) => cas particulier du Js
@RestController()  // @Controller + @ResponseBody
@RequestMapping("/collegues")
public class CollegueCtrl {

    private CollegueService service;

    public CollegueCtrl(CollegueService service) {
    	this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CollegueView>> listerCollegues() {

    	return ResponseEntity.ok(this.service.findAllCollegue().stream().map(col -> Converters.COLLEGUE_TO_COLLEGUE_VIEW.convert(col)).collect(Collectors.toList()));

    }
    
    @GetMapping("/{pseudo}")
    public ResponseEntity<DetailsCollegueView> afficherCollegue(@PathVariable("pseudo") String pseudo) {

    	return ResponseEntity.ok(Converters.COLLEGUE_TO_DETAILS_COLLEGUE.convert(this.service.findCollegue(pseudo)));

    }
    
    

    @PostMapping("/nouveau")
    public ResponseEntity<?> creerCollegue(@RequestBody CollegueFormulaireView collegueFormulaireView) {
    	
       	this.service.send( this.service.findCollegueByMatriculeFromWebApi(collegueFormulaireView.getMatricule()) );
    	
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    

    @PatchMapping("/{pseudo}")
    public ResponseEntity<CollegueView> editeScoreCollegue(@RequestBody AvisView avisView,
	    @PathVariable("pseudo") String pseudo) {

		
    	Collegue collegueModifie = this.service.editScore(avisView, pseudo);

		return ResponseEntity.ok(Converters.COLLEGUE_TO_COLLEGUE_VIEW.convert(collegueModifie));

    }

}
