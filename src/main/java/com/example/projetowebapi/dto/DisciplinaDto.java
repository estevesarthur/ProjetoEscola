package com.example.projetowebapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetowebapi.model.Disciplina;

public class DisciplinaDto {
	private Long id;
	private String nome;
	private String descricao;
	
	public DisciplinaDto(Disciplina disciplina) {
		this.id = disciplina.getId();
		this.nome = disciplina.getNome();
		this.descricao = disciplina.getDescricao();
	}
	
	public DisciplinaDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static List	<DisciplinaDto> converter (List<Disciplina> disciplinas){
		return disciplinas.stream().map(DisciplinaDto::new).collect(Collectors.toList());
	}

	

}
