package com.example.projetowebapi.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetowebapi.dto.DisciplinaDto;
import com.example.projetowebapi.model.Disciplina;
import com.example.projetowebapi.repository.DisciplinaRepository;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinasController {
	
	private DisciplinaRepository disciplinaRepository;
	
	DisciplinasController(DisciplinaRepository disciplinasRepository){
		this.disciplinaRepository = disciplinasRepository;
	}
	
	@GetMapping
	public List<DisciplinaDto> lista(String nome){
		if(nome == null) {
			List<Disciplina> disciplinas = disciplinaRepository.findAll();
			return DisciplinaDto.converter(disciplinas);
		} else {
			List<Disciplina> disciplinas = disciplinaRepository.findByNome(nome);
			return DisciplinaDto.converter(disciplinas);
 		}
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Disciplina form) {
		disciplinaRepository.save(form);
	}
	
	@DeleteMapping
	public void deletar(Long id) {
		disciplinaRepository.deleteById(id);
	}
}
