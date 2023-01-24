package com.capgemini.start.api.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.capgemini.start.api.dto.output.GeneroDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Genero", description = "Genero de filmes")
public interface GeneroResource {
	
	@Operation(summary = "Consultar un genero por id")
	@GetMapping(value = "/{id}")
	ResponseEntity<GeneroDTO> findById(@PathVariable Integer id);
	
	@Operation(summary = "Insere um genero")
	@PostMapping()
	ResponseEntity<GeneroDTO> insert(@RequestBody @Valid GeneroDTO genero);
	
	@Operation(summary = "Lista todos os generos")
	@GetMapping()
	ResponseEntity<List<GeneroDTO>> findAll();
	
	@Operation(summary = "Atualiza um genero")
	@PutMapping(value = "/{id}")
	ResponseEntity<GeneroDTO> update(@PathVariable Integer id, @RequestBody @Valid GeneroDTO genero);
	
	@Operation(summary = "Exclui um genero pelo id")
	@DeleteMapping(value = "/{id}")
	ResponseEntity<Void> delete(@PathVariable Integer id);
	
}

