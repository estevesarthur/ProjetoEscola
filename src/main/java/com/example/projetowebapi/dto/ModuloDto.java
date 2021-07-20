package com.example.projetowebapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetowebapi.model.Modulo;

public class ModuloDto {
	private Long id;
	private String descricaoModulo;
	
	public ModuloDto(Modulo modulo) {
		this.id = modulo.getId();
		this.descricaoModulo = modulo.getDescricaoModulo();
	}
	
	public ModuloDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoModulo() {
		return descricaoModulo;
	}

	public void setDescricaoModulo(String descricaoModulo) {
		this.descricaoModulo = descricaoModulo;
	}
		
	public static List<ModuloDto> converter (List<Modulo> modulos){
		return modulos.stream().map(ModuloDto::new).collect(Collectors.toList());
	}
}
