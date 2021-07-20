package com.example.projetowebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetowebapi.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
	
	List<Disciplina> findByNome(String nome);
}
