package com.example.projetowebapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Modulo {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricaoModulo;
	
	@ManyToOne
	@JoinColumn(name ="curso_id", nullable = false)
	private Curso curso;
	
	@OneToMany (mappedBy = "modulo")
	private List<Disciplina> disciplinas;
	
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
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((descricaoModulo == null) ? 0 : descricaoModulo.hashCode());
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modulo other = (Modulo) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (descricaoModulo == null) {
			if (other.descricaoModulo != null)
				return false;
		} else if (!descricaoModulo.equals(other.descricaoModulo))
			return false;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
