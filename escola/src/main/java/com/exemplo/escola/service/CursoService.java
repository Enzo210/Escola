package com.exemplo.escola.service;



import com.exemplo.escola.model.Curso;
import com.exemplo.escola.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repo;

    public List<Curso> listarTodos() {
        return repo.findAll();
    }

    public Curso salvar(Curso curso) {
        return repo.save(curso);
    }

    public Optional<Curso> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
