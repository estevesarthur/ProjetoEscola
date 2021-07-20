package com.example.projetowebapi.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetowebapi.dto.ModuloDto;
import com.example.projetowebapi.model.Modulo;
import com.example.projetowebapi.repository.ModuloRepository;

@RestController
@RequestMapping("/modulos")
public class ModulosController {
	
	private ModuloRepository moduloRepository;
	
	ModulosController(ModuloRepository modulosRepository) {
		// TODO Auto-generated constructor stub
		this.moduloRepository = modulosRepository;
	}
	
	@GetMapping
	public List<ModuloDto> lista(String descricaoModulo){
		if(descricaoModulo == null) {
			List<Modulo> modulos = moduloRepository.findAll();
			return ModuloDto.converter(modulos);
		} else {
			List<Modulo> modulos = moduloRepository.findByDescricaoModulo(descricaoModulo);
			return ModuloDto.converter(modulos);
		}
	}
	@PostMapping
	public void cadastrar(@RequestBody Modulo form) {
		moduloRepository.save(form);
	}
	
	@DeleteMapping
	public void deletar(Long id) {
		moduloRepository.deleteById(id);
	}
}
