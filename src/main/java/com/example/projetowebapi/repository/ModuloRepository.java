package com.example.projetowebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetowebapi.model.Modulo;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {
	
	List<Modulo> findByDescricaoModulo(String descricaoModulo);
}
