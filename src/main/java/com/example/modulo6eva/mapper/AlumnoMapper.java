package com.example.modulo6eva.mapper;

import com.example.modulo6eva.dtos.AlumnoDTO;
import com.example.modulo6eva.dtos.CreateAlumnoDTO;
import com.example.modulo6eva.dtos.UpdateAlumnoDTO;
import com.example.modulo6eva.model.Alumno;
import com.example.modulo6eva.model.User;


public class AlumnoMapper {

    public static AlumnoDTO  toDto(Alumno alumno) {
        return new AlumnoDTO(
                alumno.getId(),
                alumno.getNombreAlumno(),
                alumno.getDireccion(),
                alumno.getRutAlumno(),
                alumno.getUser().getId()
        );
    }

    public static Alumno CreatetoEntity(CreateAlumnoDTO createAlumnoDTO) {
        Alumno alumno= new Alumno();
        alumno.setNombreAlumno(createAlumnoDTO.getNombre());
        alumno.setRutAlumno(createAlumnoDTO.getRut());
        alumno.setDireccion(createAlumnoDTO.getDireccion());
        alumno.setUser(new User());

        return alumno;
    }
    public static Alumno UpdatetoEntity(UpdateAlumnoDTO updateAlumnoDTO) {
        Alumno alumno= new Alumno();
        alumno.setNombreAlumno(updateAlumnoDTO.getNombre());
        alumno.setRutAlumno(updateAlumnoDTO.getRut());
        alumno.setDireccion(updateAlumnoDTO.getDireccion());
        alumno.setUser(new User());

        return alumno;
    }
}
