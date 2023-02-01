package com.capgemini.start.api.resource.impl;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.capgemini.start.api.dto.input.GeneroInputDTO;
import com.capgemini.start.api.dto.output.GeneroDTO;
import com.capgemini.start.api.mapper.GeneroMapper;
import com.capgemini.start.api.resource.GeneroResource;
import com.capgemini.start.domain.entity.Genero;
import com.capgemini.start.domain.service.GeneroService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/generos")
public class GeneroResourceImpl implements GeneroResource {

	private final GeneroService generoService;
	
	@Autowired
	private GeneroMapper mapper;
	
	@Override
	public ResponseEntity<GeneroDTO> findById(Long id) {
		Genero genero = this.generoService.findById(id);
		GeneroDTO dto = mapper.toDTO(genero);
		return ResponseEntity.ok(dto);
	}

	@Override
	public ResponseEntity<GeneroDTO> insert(@RequestBody @Valid GeneroInputDTO genero) {
		Genero entity = mapper.toEntity(genero);
		Genero createdEntity = this.generoService.insert(entity);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdEntity.getId())
				.toUri();
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.header(HttpHeaders.LOCATION, location.toString())
				.body(mapper.toDTO(createdEntity));
	}

	@Override
	public ResponseEntity<List<GeneroDTO>> findAll() {
		return ResponseEntity.ok(
				this.generoService.findAll()
				.stream()
				.map(genero -> mapper.toDTO(genero))
				.collect(Collectors.toList())
				);
	}

	@Override
	public ResponseEntity<GeneroDTO> update(Long id, @Valid GeneroInputDTO genero) {
		Genero toUpdate = this.generoService.findById(id);
		toUpdate.setDescricao(genero.getDescricao());
		
		Genero updated = this.generoService.update(toUpdate);
		
		return ResponseEntity.ok(mapper.toDTO(updated));
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		this.generoService.delete(id);
		return ResponseEntity.ok().build();
	}

}
