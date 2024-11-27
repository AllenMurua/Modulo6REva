package com.example.modulo6eva.services;

import com.example.modulo6eva.dtos.MateriaDTO;
import com.example.modulo6eva.mapper.MateriaMapper;
import com.example.modulo6eva.model.Materia;
import com.example.modulo6eva.repository.MateriaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MateriaServicioImpl implements MateriaServicio {

    private final MateriaRepository materiaRepository;
//    private final MateriaMapper materiaMapper;

    @Override
    public Materia obtenerMateria(String nombre) {
        return materiaRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada: " + nombre));
    }

    @Override
    public List<Materia> obtenerMaterias() {
        return materiaRepository.findAll();
    }

    @Override
    public List<MateriaDTO> getMateriaAlumnos(Long idAlumno) {
        if (idAlumno == null) {
            throw new IllegalArgumentException("El ID del alumno no puede ser nulo.");
        }

        // Devuelve directamente  los objetos MateriaDTO proporcionados por el repositorio
        return materiaRepository.findByUsuarioAsDTO(idAlumno);
    }


}
