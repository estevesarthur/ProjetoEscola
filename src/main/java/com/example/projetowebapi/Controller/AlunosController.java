package com.example.projetowebapi.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetowebapi.dto.AlunoDto;
import com.example.projetowebapi.model.Aluno;
import com.example.projetowebapi.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
	
	private AlunoRepository alunoRepository;
	
	AlunosController(AlunoRepository alunosRepository){
		this.alunoRepository = alunosRepository;
	}
	
	@GetMapping
	public List<AlunoDto> lista(String nomeAluno){
		if (nomeAluno == null) {
			List<Aluno> alunos = alunoRepository.findAll();
			return AlunoDto.converter(alunos);
		} else {
			List<Aluno> alunos = alunoRepository.findByNome(nomeAluno);
			return AlunoDto.converter(alunos);
		}
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Aluno form) {
		alunoRepository.save(form);
	}
	
	@DeleteMapping
	public void deletar(@RequestParam Long id) {
		alunoRepository.deleteById(id);
	}
}
