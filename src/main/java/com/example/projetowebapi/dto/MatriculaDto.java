package com.example.projetowebapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetowebapi.model.Matricula;

public class MatriculaDto {
	private Long id;

	public MatriculaDto(Matricula matricula) {
		this.id = matricula.getId();
	}
	
	public MatriculaDto() {
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		
	public static List<MatriculaDto> converter (List<Matricula> matriculas){
		return matriculas.stream().map(MatriculaDto::new).collect(Collectors.toList());
	}

	
}
