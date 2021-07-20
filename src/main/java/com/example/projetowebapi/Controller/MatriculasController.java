package com.example.projetowebapi.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetowebapi.dto.MatriculaDto;
import com.example.projetowebapi.model.Matricula;
import com.example.projetowebapi.repository.MatriculaRepository;

@RestController
@RequestMapping("/matriculas")
public class MatriculasController {
	
	private MatriculaRepository matriculaRepository;
	
	MatriculasController(MatriculaRepository matriculasRepository){
		this.matriculaRepository = matriculasRepository;
	}
	
	@GetMapping
	public List<MatriculaDto> lista(String nomeCurso){
		if(nomeCurso == null) {
			List<Matricula> matriculas = matriculaRepository.findAll();
			return MatriculaDto.converter(matriculas);
		} else {
			List<Matricula> matriculas = matriculaRepository.findByCursoNomeCurso(nomeCurso);
			return MatriculaDto.converter(matriculas);
			
		}
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Matricula form) {
		matriculaRepository.save(form);
	}
	
	@DeleteMapping
	public void deletar(Long id) {
		matriculaRepository.deleteById(id);
	}
}
