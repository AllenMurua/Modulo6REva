package com.example.modulo6eva.validation;

import com.example.modulo6eva.dtos.CreateAlumnoDTO;
import com.example.modulo6eva.dtos.UpdateAlumnoDTO;
import com.example.modulo6eva.exception.InvalidAlumnoDataException;
import com.example.modulo6eva.model.Alumno;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlumnoValidation {

    public void validateCreateAlumno(CreateAlumnoDTO createAlumnoDTO) {
        List<String> errors = new ArrayList<>();

        if (createAlumnoDTO.getNombre() == null || createAlumnoDTO.getNombre().isEmpty()) {
            errors.add("El nombre no puede estar vacio");

        };
        if (createAlumnoDTO.getDireccion() == null || createAlumnoDTO.getDireccion().isEmpty()) {
            errors.add("El direccion no puede estar vacio");

        }
        if (createAlumnoDTO.getRut() == null || createAlumnoDTO.getRut().isEmpty()) {
            errors.add("El rut no puede estar vacio");
        }
        if (!errors.isEmpty()) {
            throw new InvalidAlumnoDataException(String.valueOf(errors));
        }


    }
    public void validateUpdateAlumno(UpdateAlumnoDTO dto) {
        List<String> errors = new ArrayList<>();

        if (dto.getNombre() != null) {
            if (dto.getNombre().trim().isEmpty()) {
                errors.add("El nombre no puede estar vacío");
            } else if (dto.getNombre().length() > 30) {
                errors.add("El nombre no puede exceder los 30 caracteres");
            }
        }

        if (dto.getDireccion() != null) {
            if (dto.getDireccion().trim().isEmpty()) {
                errors.add("La direccion no puede estar vacía");
            } else if (dto.getDireccion().length() > 50) {
                errors.add("La direccion no puede exceder los 50 caracteres");
            }
        }

        if (dto.getRut() != null) {
            if (dto.getRut().trim().isEmpty()) {
                errors.add("El rut no puede estar vacío");
            } else if (dto.getRut().length() > 12) {
                errors.add("El rut no puede exceder los 12 caracteres");
            }
        }

        if (!errors.isEmpty()) {
            throw new InvalidAlumnoDataException(String.join(", ", errors));
        }
    }

}
