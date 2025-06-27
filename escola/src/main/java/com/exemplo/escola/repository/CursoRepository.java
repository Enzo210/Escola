package com.exemplo.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.escola.model.Curso;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> { }
