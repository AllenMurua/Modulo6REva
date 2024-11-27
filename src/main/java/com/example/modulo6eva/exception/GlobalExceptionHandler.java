package com.example.modulo6eva.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {


    private final View error;

    public GlobalExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorResponse> handleAlumnoNotFoundException(AlumnoNotFoundException alumnoNotFoundException) {
        List<String> errors = new ArrayList<>();
        errors.add(alumnoNotFoundException.getMessage());
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                "Alumno no Encontrado",
                errors
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InvalidAlumnoDataException.class)
    public ResponseEntity<ErrorResponse>handleInvalidAlumnoDataException(InvalidAlumnoDataException ex) {
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                "Alumno no Encontrado",
                errors
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
