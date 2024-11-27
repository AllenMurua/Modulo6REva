package com.example.modulo6eva.repository;

import com.example.modulo6eva.dtos.MateriaDTO;
import com.example.modulo6eva.model.Alumno;
import com.example.modulo6eva.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    List<Alumno> findByNombreAlumno(String nombre);
//    List<Alumno> findByEdadBetween(int edadMinima, int edadMaxima);
//    List<Alumno> findAlumnoByNombreContainingIgnoreCaseAndEdadBetween(String nombre, int edadMinima, int edadMaxima);
    @Query("SELECT a FROM Alumno a WHERE a.nombreAlumno LIKE %:nombre%")
    List<Alumno> findByNombreContaining(@Param("nombre") String nombre);

    @Override
    @Query(value = "SELECT * FROM Alumno", nativeQuery = true)
    List<Alumno> findAll();

    @Query("SELECT DISTINCT a FROM Alumno a " +
            "JOIN a.materiaList m " +
            "WHERE m.id = :materiaId")
    List<Alumno> findAlumnosByMateria(@Param("materiaId") Long materiaId);

    @Query("SELECT a FROM Alumno a WHERE " +
            "LOWER(a.nombreAlumno) LIKE LOWER(CONCAT('%', :termino, '%')) OR " +
            "LOWER(a.rutAlumno) LIKE LOWER(CONCAT('%', :termino, '%'))")
    List<Alumno> findByNombreOrRut(@Param("termino") String termino);
}
