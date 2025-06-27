package com.exemplo.escola.service;

import com.exemplo.escola.model.Aluno;
import com.exemplo.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

public Aluno buscarPorId(Long id) {
    return alunoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + id));
}
public Optional<Aluno> buscarPorIdUm(Long id) {
    return alunoRepository.findById(id);
}

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }


}