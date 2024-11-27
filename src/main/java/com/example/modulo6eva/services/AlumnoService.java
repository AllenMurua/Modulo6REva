package com.example.modulo6eva.services;

import com.example.modulo6eva.dtos.AlumnoDTO;
import com.example.modulo6eva.dtos.CreateAlumnoDTO;
import com.example.modulo6eva.dtos.MateriaDTO;
import com.example.modulo6eva.dtos.UpdateAlumnoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlumnoService {

    AlumnoDTO createAlumno(CreateAlumnoDTO createDto);
    AlumnoDTO getAlumnoById(Long id);
    List<AlumnoDTO> getAllAlumnos();
    Page<AlumnoDTO> getAllAlumnosPaginated(Pageable pageable);
    AlumnoDTO updateAlumno(Long id, UpdateAlumnoDTO updateDto);
    void deleteAlumno(Long id);

    List<AlumnoDTO> findByNombre(String nombre);
    List<AlumnoDTO> findByRut(String rut);
}
