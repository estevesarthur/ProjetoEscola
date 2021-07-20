package com.example.projetowebapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetowebapi.model.Curso;

public class CursoDto {
	private Long id;
	private String nomeCurso;
	
	public CursoDto(Curso curso) {
		this.id = curso.getId();
		this.nomeCurso = curso.getNomeCurso();
	}
	
	public CursoDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public static List<CursoDto> converter (List<Curso> cursos){
		return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
	}

}
