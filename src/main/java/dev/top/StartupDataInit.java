package dev.top;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@Component
public class StartupDataInit {

    private CollegueRepo versionRepo;
    
    public StartupDataInit(CollegueRepo versionRepo) {
		super();
		this.versionRepo = versionRepo;
	}


    // méthode appellée dès le lancement de l'application
	@EventListener(ContextRefreshedEvent.class)
    public void init() {

        if(this.versionRepo.count() <= 0) {
            this.versionRepo.save(new Collegue("SpiderCochon", 666, "http://interactive.nydailynews.com/2016/05/simpsons-quiz/img/simp1.jpg"));
            this.versionRepo.save(new Collegue("SpiderCochon", 666, "http://interactive.nydailynews.com/2016/05/simpsons-quiz/img/simp1.jpg"));
            this.versionRepo.save(new Collegue("SpiderCochon", 666, "http://interactive.nydailynews.com/2016/05/simpsons-quiz/img/simp1.jpg"));
            this.versionRepo.save(new Collegue("SpiderCochon", 666, "http://interactive.nydailynews.com/2016/05/simpsons-quiz/img/simp1.jpg"));
            
        }

    }
}
