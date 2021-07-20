package com.example.projetowebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetowebapi.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	List<Aluno> findByNome(String nomeAluno);
	
}
