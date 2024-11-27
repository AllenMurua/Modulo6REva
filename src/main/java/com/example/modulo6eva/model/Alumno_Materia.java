package com.example.modulo6eva.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "alumno_materia")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno_Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Add a primary key

    @Column(name = "idMateria")
    private Long materia_id;

    @Column(name = "idAlumno")
    private Long alumno_id;

}