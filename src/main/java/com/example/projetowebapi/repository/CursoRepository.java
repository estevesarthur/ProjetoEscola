package com.example.projetowebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetowebapi.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
	
	List<Curso> findByNomeCurso(String nomeCurso);

}
