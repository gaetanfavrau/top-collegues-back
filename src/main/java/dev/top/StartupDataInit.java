package dev.top;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Adresse;
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
            this.collegueRepo.save(new Collegue(
            			"SpiderCochon01",
            			"Simpson",
            			"Homer",
            			"aaa@aaa.aaa",
            			new Adresse(33, "rue de canal+", 33333, "Springfield"),
            			700,
            			"https://static.comicvine.com/uploads/square_medium/11/114183/5147870-homer_simpson_2006.png"
            		));
            this.collegueRepo.save(new Collegue(
        			"SpiderCochon02",
        			"Simpson",
        			"Marge",
        			"bbb@bbb.bbb",
        			new Adresse(33, "rue de canal+", 33333, "Springfield"),
        			600,
        			"https://static.comicvine.com/uploads/square_medium/11/114183/5147870-homer_simpson_2006.png"
        		));
            this.collegueRepo.save(new Collegue(
        			"SpiderCochon03",
        			"Simpson",
        			"Bart",
        			"ccc@ccc.ccc",
        			new Adresse(33, "rue de canal+", 33333, "Springfield"),
        			500,
        			"https://static.comicvine.com/uploads/square_medium/11/114183/5147870-homer_simpson_2006.png"
        		));
            this.collegueRepo.save(new Collegue(
        			"SpiderCochon04",
        			"Simpson",
        			"Lizza",
        			"ddd@ddd.ddd",
        			new Adresse(33, "rue de canal+", 33333, "Springfield"),
        			400,
        			"https://static.comicvine.com/uploads/square_medium/11/114183/5147870-homer_simpson_2006.png"
        		));
            
            
        }

    }
}
