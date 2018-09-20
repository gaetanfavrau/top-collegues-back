package dev.top;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dev.top.entities.Collegue;
import dev.top.entities.CollegueSource;
import dev.top.repository.CollegueRepo;
import dev.top.utils.Converters;

@Component
public class StartupDataInit {

    private CollegueRepo collegueRepo;
    
    public StartupDataInit(CollegueRepo collegueRepo) {
		super();
		this.collegueRepo = collegueRepo;
	}


    // méthode appellée dès le lancement de l'application
	@EventListener(ContextRefreshedEvent.class)
    public void init() {
		
		//this.collegueRepo.save
		
		RestTemplate restTemplate = new RestTemplate();
		CollegueSource[] list = restTemplate.getForObject("http://collegues-api.cleverapps.io/collegues", CollegueSource[].class);
		
		for(int i=0; i<4; i++) {
			
			Collegue collegue = Converters.COLLEGUE_SOURCE_TO_COLLEGUE.convert(list[i]);
			collegue.setPseudo("Yolo_0" + (i+1));
			collegue.setScore(i*i+6);
			
			this.collegueRepo.save(collegue);
			
		}

        

    }
}
