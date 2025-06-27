package com.exemplo.escola.controller;

import com.exemplo.escola.model.Curso;
import com.exemplo.escola.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaginaCursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/cursos")
    public String formCurso() {
        return "cursos";
    }

    @PostMapping("/cursos")
    public String salvarCurso(Curso curso) {
        cursoService.salvar(curso);
        return "redirect:/cursos";
    }
}
