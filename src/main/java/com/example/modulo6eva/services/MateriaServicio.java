package com.example.modulo6eva.services;

import com.example.modulo6eva.dtos.MateriaDTO;
import com.example.modulo6eva.model.Materia;

import java.util.List;

public interface MateriaServicio {
    Materia obtenerMateria(String nombre);
    List<Materia> obtenerMaterias();
    List<MateriaDTO> getMateriaAlumnos(Long idAlumno);
}
