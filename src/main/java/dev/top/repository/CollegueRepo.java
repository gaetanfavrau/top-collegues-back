package dev.top.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.top.entities.Collegue;

public interface CollegueRepo extends JpaRepository<Collegue, Integer> {

    Optional<Collegue> findByPseudo(String pseudo);

    Collegue findByMatricule(String matricule);

}
