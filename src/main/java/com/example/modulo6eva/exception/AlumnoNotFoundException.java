package com.example.modulo6eva.exception;

public class AlumnoNotFoundException extends RuntimeException {
    public AlumnoNotFoundException(Long id) {

        super("Alumno " + id + " not found");

    }

}
