package com.example.projetowebapi.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetowebapi.dto.CursoDto;
import com.example.projetowebapi.model.Curso;
import com.example.projetowebapi.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursosController {

	private CursoRepository cursoRepository;
	
	CursosController(CursoRepository cursosRepository){
		this.cursoRepository = cursosRepository;
	}
	
	@GetMapping
	public List<CursoDto> lista(String nomeCurso){
		if(nomeCurso == null) {
			List<Curso> cursos = cursoRepository.findAll();
			return CursoDto.converter(cursos);
		} else {
			List<Curso> cursos = cursoRepository.findByNomeCurso(nomeCurso);
			return CursoDto.converter(cursos);			
		}
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Curso form) {
		cursoRepository.save(form);
	}
	
	@DeleteMapping
	public void deletar(Long id) {
		cursoRepository.deleteById(id);
	}
}
