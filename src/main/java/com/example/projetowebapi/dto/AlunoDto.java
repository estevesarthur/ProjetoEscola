package com.example.projetowebapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetowebapi.model.Aluno;

public class AlunoDto {
	private Long id;
	private String nome;
	
	public AlunoDto(Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
	}
	
	public AlunoDto() {
		
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
	
	public static List<AlunoDto> converter (List<Aluno> alunos){
		return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
	}
}
