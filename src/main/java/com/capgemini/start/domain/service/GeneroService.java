package com.capgemini.start.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.capgemini.start.domain.entity.Genero;
import com.capgemini.start.domain.repository.GeneroRepository;
import com.capgemini.start.domain.service.exceptions.ObjectAlreadyExistsException;
import com.capgemini.start.domain.service.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //build constructor with arguments
@Service
public class GeneroService extends AbstractService<Genero, Long> {
	
	private final GeneroRepository generoRepository;

	@Override
	protected JpaRepository<Genero, Long> getRepository() {
		return this.generoRepository;
	}
	
	@Override
	public Genero findById(Long id) {
		return generoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	@Override
	public Genero insert(Genero genero) {
//		defensive programming
		if(this.generoRepository.existsByDescricaoIgnoreCase(genero.getDescricao())) {
			throw new ObjectAlreadyExistsException("\"Já existe um genero com esta descrição.\"");
		}
		genero.setDataInclusao(new Date());
		return this.generoRepository.save(genero);
	}
	
	@Override
	public Genero update(Genero genero) {
		if(this.generoRepository.existsByIdNotAndDescricaoIgnoreCase(genero.getId(), genero.getDescricao())) {
			throw new ObjectAlreadyExistsException("Já existe outro genero com esta descrição.");
		}
		genero.setDataAlteracao(new Date());
		return generoRepository.save(genero);
	}
	
//	@Override
//	public void delete(Integer id) {
//		generoRepository.deleteById(id);
//	}
	
	@Override
	public List<Genero> findAll() {
		return generoRepository.findAll();
	}

}
