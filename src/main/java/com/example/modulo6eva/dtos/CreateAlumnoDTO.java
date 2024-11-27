package com.example.modulo6eva.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAlumnoDTO {
    private String rut;
    private String nombre;
    private String direccion;
}
