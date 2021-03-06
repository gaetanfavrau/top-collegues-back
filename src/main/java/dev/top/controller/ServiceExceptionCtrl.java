package dev.top.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;

import dev.top.controller.view.ErrorCode;
import dev.top.controller.view.ErrorView;
import dev.top.exceptions.DoublonBDDException;
import dev.top.exceptions.MatriculeInvalideException;
import dev.top.exceptions.PseudoInvalideException;
import dev.top.exceptions.ServiceException;

@ControllerAdvice
public class ServiceExceptionCtrl {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> serviceException() {
	return ResponseEntity.badRequest().body(new ErrorView(ErrorCode.SERVICE, "Erreur côté service"));
    }

    @ExceptionHandler(PseudoInvalideException.class)
    public ResponseEntity<?> pseudoException() {
	return ResponseEntity.badRequest()
		.body(new ErrorView(ErrorCode.PSEUDO_INVALID, "Le pseudo n'a pas été trouvé en base de données"));
    }

    @ExceptionHandler(MatriculeInvalideException.class)
    public ResponseEntity<?> matriculeInvalideException() {
	return ResponseEntity.badRequest()
		.body(new ErrorView(ErrorCode.MATRICULE_INVALID, "Le matricule n'a pas été trouvé en base de données"));
    }

    @ExceptionHandler(DoublonBDDException.class)
    public ResponseEntity<?> doublonBDDException() {
	return ResponseEntity.badRequest()
		.body(new ErrorView(ErrorCode.DOUBLON_BDD, "Le collègue existe déjà dans la base de données"));
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<?> invalidFormatException() {
	return ResponseEntity.badRequest().body(new ErrorView(ErrorCode.JSON_PARSE,
		"Erreur dans la conversion Java <> JSON (vérifiez vos paramètres d'entrée)"));
    }

}
