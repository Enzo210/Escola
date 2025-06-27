package com.exemplo.escola.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.escola.model.Aluno;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> { }
