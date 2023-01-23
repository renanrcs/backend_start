package com.capgemini.start.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.start.domain.entity.Genero;

//@Repository //PQ compilador diz que não é necessario @REPOSITORY?
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

}
