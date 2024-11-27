package com.example.modulo6eva.services;

import com.example.modulo6eva.dtos.AlumnoDTO;
import com.example.modulo6eva.dtos.CreateAlumnoDTO;
import com.example.modulo6eva.dtos.MateriaDTO;
import com.example.modulo6eva.dtos.UpdateAlumnoDTO;
import com.example.modulo6eva.exception.AlumnoNotFoundException;
import com.example.modulo6eva.mapper.AlumnoMapper;
import com.example.modulo6eva.model.Alumno;
import com.example.modulo6eva.repository.AlumnoRepository;
import com.example.modulo6eva.validation.AlumnoValidation;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AlumnoServiceImpl implements AlumnoService{

    private final AlumnoRepository alumnoRepository;
    private final AlumnoValidation alumnoValidation;

    @Override
    @Transactional
    public AlumnoDTO createAlumno(CreateAlumnoDTO createDto) {
        alumnoValidation.validateCreateAlumno(createDto);

        Alumno alumno = AlumnoMapper.CreatetoEntity(createDto);
        alumno = alumnoRepository.save(alumno);
        return AlumnoMapper.toDto(alumno);
    }

    @Override
    @Transactional()
    public AlumnoDTO getAlumnoById(Long id) {
        return alumnoRepository.findById(id)
                .map(AlumnoMapper::toDto)
                .orElseThrow(() -> new AlumnoNotFoundException(id));
    }
    @Override
    public List<AlumnoDTO> findByNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        return alumnoRepository.findByNombreAlumno(nombre)
                .stream()
                .map(AlumnoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlumnoDTO> findByRut(String rut) {

        return alumnoRepository.findByNombreOrRut(rut)
                .stream().map(AlumnoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlumnoDTO> getAllAlumnos() {
        // Fetch the list of Alumno entities, map them to DTOs, and return
        return alumnoRepository.findAll().stream()
                .map(alumno -> new AlumnoDTO(alumno.getId(), alumno.getRutAlumno(), alumno.getNombreAlumno(), alumno.getDireccion(), alumno.getUser() != null ? alumno.getUser().getId() : null))
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlumnoDTO> getAllAlumnosPaginated(Pageable pageable) {
        return alumnoRepository.findAll((org.springframework.data.domain.Pageable) pageable)
                .map(AlumnoMapper::toDto);
    }

    @Override
    public AlumnoDTO updateAlumno(Long id, UpdateAlumnoDTO updateDto) {
        // Validate the update DTO
        alumnoValidation.validateUpdateAlumno(updateDto);

        // Find the existing alumno
        Alumno existingAlumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new AlumnoNotFoundException(id));

        // Update the existing alumno's fields
        existingAlumno.setNombreAlumno(updateDto.getNombre());
        existingAlumno.setRutAlumno(updateDto.getRut());
        existingAlumno.setDireccion(updateDto.getDireccion());

        // Save the updated alumno
        Alumno updatedAlumno = alumnoRepository.save(existingAlumno);

        // Convert and return the updated alumno as DTO
        return AlumnoMapper.toDto(updatedAlumno);
    }

    @Override
    public void deleteAlumno(Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new AlumnoNotFoundException(id);
        }
        alumnoRepository.deleteById(id);
    }



}
