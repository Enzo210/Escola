CREATE DATABASE cadastro_alunos;

USE cadastro_alunos;

CREATE TABLE curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    carga_horaria INT NOT NULL
);

CREATE TABLE aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    matricula VARCHAR(20) NOT NULL UNIQUE,
    curso_id BIGINT,
    FOREIGN KEY (curso_id) REFERENCES curso(id)
);
select * from aluno;
select * from curso;