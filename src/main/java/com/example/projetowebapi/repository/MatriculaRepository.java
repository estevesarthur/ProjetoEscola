package com.example.projetowebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetowebapi.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
	
	List<Matricula> findByCursoNomeCurso(String nomeCurso);
}
