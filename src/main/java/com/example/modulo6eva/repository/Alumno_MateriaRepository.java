package com.example.modulo6eva.repository;

import com.example.modulo6eva.model.Alumno_Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Alumno_MateriaRepository extends JpaRepository<Alumno_Materia, Long> {
    // Add custom methods if needed
}