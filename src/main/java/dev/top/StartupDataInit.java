package dev.top;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.repository.CollegueRepo;

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

        if(this.collegueRepo.count() <= 0) {
            this.collegueRepo.save(new Collegue("SpiderCochon01", 666, "https://static.comicvine.com/uploads/square_medium/11/114183/5147870-homer_simpson_2006.png"));
            this.collegueRepo.save(new Collegue("SpiderCochon02", 666, "https://static.comicvine.com/uploads/square_medium/11/114183/5147870-homer_simpson_2006.png"));
            this.collegueRepo.save(new Collegue("SpiderCochon03", 666, "https://static.comicvine.com/uploads/square_medium/11/114183/5147870-homer_simpson_2006.png"));
            this.collegueRepo.save(new Collegue("SpiderCochon04", 666, "https://static.comicvine.com/uploads/square_medium/11/114183/5147870-homer_simpson_2006.png"));
            
        }

    }
}
