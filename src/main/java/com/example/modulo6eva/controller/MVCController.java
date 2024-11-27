package com.example.modulo6eva.controller;

import com.example.modulo6eva.model.User;
import com.example.modulo6eva.services.UsuarioServicio;
import org.springframework.ui.Model;
import com.example.modulo6eva.dtos.AlumnoDTO;
import com.example.modulo6eva.dtos.MateriaDTO;
import com.example.modulo6eva.model.Alumno;
import com.example.modulo6eva.model.Materia;
import com.example.modulo6eva.services.AlumnoService;
import com.example.modulo6eva.services.MateriaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/InicioSession")
@RequiredArgsConstructor
public class MVCController {


    private final MateriaServicio materiaServicio;
    private final AlumnoService alumnoService;
    private final UsuarioServicio usuarioServicio;

    @GetMapping
    public String showLoginPage() {
        return "InicioSession";
    }


    @PostMapping("/validate")
    public String validateLogin(@RequestParam String rut,
                                @RequestParam String password,
                                Model model) {
        try {
            User user = usuarioServicio.validateUser(rut, password);

            // Fetch associated student data more safely
            List<AlumnoDTO> alumnos = alumnoService.findByRut(rut);
            if (alumnos.isEmpty()) {
                throw new RuntimeException("No student found for this user");
            }

            AlumnoDTO alumno = alumnos.get(0);
            List<MateriaDTO> materiasAlumno = materiaServicio.getMateriaAlumnos(alumno.getId());

            // Use session or security context to store user information
            model.addAttribute("alumno", alumno);
            model.addAttribute("materiasAlumno", materiasAlumno);

            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("error", "Credenciales inválidas. Por favor, intente nuevamente.");
            return "InicioSession";
        }
    }

    // Rest of the methods remain the same

    @GetMapping("/materias")
    public String showMaterias(@RequestParam(required = false) Long alumnoId, Model model) {
        if (alumnoId != null) {
            AlumnoDTO alumno = alumnoService.getAlumnoById(alumnoId);
            List<MateriaDTO> materiasAlumno = materiaServicio.getMateriaAlumnos(alumnoId);

            model.addAttribute("alumno", alumno);
            model.addAttribute("materiasAlumno", materiasAlumno);
        }
        return "home";
    }

    @GetMapping("/materia/{nombre}")
    public String viewMateriaDetails(@PathVariable String nombre, Model model) {
        Materia materia = materiaServicio.obtenerMateria(nombre);
        model.addAttribute("materia", materia);
        return "materia-details";
    }

    @ExceptionHandler(Exception.class)
    public String handleError(Exception ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "InicioSession";
    }
}