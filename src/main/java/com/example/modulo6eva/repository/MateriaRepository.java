package com.example.modulo6eva.repository;

import com.example.modulo6eva.dtos.AlumnoDTO;
import com.example.modulo6eva.dtos.MateriaDTO;
import com.example.modulo6eva.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

    @Query(value = "SELECT * from materia", nativeQuery = true)
    List<Materia> findAll();

    @Query(value = "SELECT m.id,m.nombre, m.codigo " +
            "FROM alumno a " +
            "JOIN alumno_materia am ON a.id = am.alumno_id " +
            "JOIN materia m ON am.materia_id = m.id " +
            "WHERE a.id = :id", nativeQuery = true)
    List<MateriaDTO> findByUsuarioAsDTO(@Param("id") Long id);

    Optional<Materia> findByNombre(String nombre);

}
