package com.example.modulo6eva.controller;

import com.example.modulo6eva.dtos.AlumnoDTO;
import com.example.modulo6eva.dtos.CreateAlumnoDTO;
import com.example.modulo6eva.dtos.UpdateAlumnoDTO;
import com.example.modulo6eva.model.Alumno;
import com.example.modulo6eva.services.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;



    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> findAll() {
        List<AlumnoDTO> alumnoDTOs = alumnoService.getAllAlumnos();
        return new ResponseEntity<>(alumnoDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlumnoDTO> createAlumno(@RequestBody CreateAlumnoDTO createAlumnoDTO) {
        AlumnoDTO alumnoDTO = alumnoService.createAlumno(createAlumnoDTO);
        return new ResponseEntity<>(alumnoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> getAlumnoById(@PathVariable Long id) {
        AlumnoDTO alumnoDTO = alumnoService.getAlumnoById(id);
        return ResponseEntity.ok(alumnoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> updateAlumno(@PathVariable Long id, @RequestBody UpdateAlumnoDTO updateDto) {
        AlumnoDTO updatedAlumno = alumnoService.updateAlumno(id, updateDto);
        return ResponseEntity.ok(updatedAlumno);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<AlumnoDTO>> getAllAlumnosPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        Page<AlumnoDTO> alumnosPage = alumnoService.getAllAlumnosPaginated(pageRequest);
        return ResponseEntity.ok(alumnosPage);
    }
}
