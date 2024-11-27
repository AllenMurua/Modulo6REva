package com.example.modulo6eva.mapper;

import com.example.modulo6eva.dtos.MateriaDTO;
import com.example.modulo6eva.model.Materia;

public class MateriaMapper {

    public static MateriaDTO toDTO(Materia materia) {
        return new MateriaDTO(
                materia.getId(),
                materia.getNombre(),
                materia.getCodigo()
        );
    }

    public static Materia toEntity(MateriaDTO dto) {
        Materia materia = new Materia();
        materia.setId(dto.getId());
        materia.setNombre(dto.getNombre());
        materia.setCodigo(dto.getCodigo());
        return materia;
    }
}
