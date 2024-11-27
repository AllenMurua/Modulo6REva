package com.example.modulo6eva.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO {
    private Long id;
    private String nombre;
    private String rut;
    private String direccion;
    private Long id_usuario;
}
