package com.scotiabank.microservicio.alumno.hexagonal.exception;

import com.scotiabank.microservicio.alumno.hexagonal.exception.errors.AlumnoNotFoundException;
import com.scotiabank.microservicio.alumno.hexagonal.exception.errors.IdExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(IdExistException.class)
    public ResponseEntity<Map<String, String>> handleIdExistException(IdExistException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("id", "El ID ya existe en la base de datos.");

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }


    @ExceptionHandler(AlumnoNotFoundException.class)
    public ResponseEntity<String> handleAlumnoNotFoundException(AlumnoNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("El alumno no fue encontrado en la base de datos.");
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(WebExchangeBindException ex) {
        Map<String, String> errores = new HashMap<>();

        ex.getFieldErrors().forEach(error -> {
            String campo = error.getField();
            String mensaje = error.getDefaultMessage();
            errores.put(campo, mensaje);
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errores);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocurrió un error inesperado: " + ex.getMessage());
    }

}
