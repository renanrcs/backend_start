package com.capgemini.start.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.start.domain.entity.Genero;

//@Repository //Why compiler say it's not necessary @REPOSITORY?
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

	boolean existsByDescricaoIgnoreCase(String descricao);
//	who or where implements these methods?
	boolean existsByIdNotAndDescricaoIgnoreCase(Integer id, String descricao);

}
