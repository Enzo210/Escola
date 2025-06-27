package com.exemplo.escola.controller;

import com.exemplo.escola.model.Aluno;
import com.exemplo.escola.service.AlunoService;
import com.exemplo.escola.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaginaAlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    @GetMapping("/alunos")
    public String formAluno(Model model) {
        model.addAttribute("alunos", alunoService.listarTodos());
        model.addAttribute("cursos", cursoService.listarTodos());
        return "alunos";
    }

    @PostMapping("/alunos")
    public String salvarAluno(Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/alunos/editar/{id}")
    public String editarAluno(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id);
        model.addAttribute("aluno", aluno);
        model.addAttribute("cursos", cursoService.listarTodos());
        return "editarAluno";
    }

    @PostMapping("/alunos/atualizar")
    public String atualizarAluno(@ModelAttribute Aluno aluno) {
        alunoService.salvar(aluno); // Mesmo método de salvar
        return "redirect:/alunos";
    }

    @GetMapping("/alunos/deletar/{id}")
    public String deletarAluno(@PathVariable Long id) {
        alunoService.deletar(id);
        return "redirect:/alunos";
    }

    @PutMapping("/api/alunos/{id}")
public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
    Aluno aluno = alunoService.buscarPorId(id);
    aluno.setNome(alunoAtualizado.getNome());
    aluno.setEmail(alunoAtualizado.getEmail());
    aluno.setMatricula(alunoAtualizado.getMatricula());
    aluno.setCurso(alunoAtualizado.getCurso());
    return alunoService.salvar(aluno);
}
}