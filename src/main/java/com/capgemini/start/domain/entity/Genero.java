package com.capgemini.start.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //usar apenas que esta com Include
@Entity(name = "tb_genero")
public class Genero {
	
	@EqualsAndHashCode.Include //especifica que para o hash
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genero", nullable = false)
	private Integer id;
	
	@Column(name = "ds_genero", nullable = false, length = 100)
	private String descricao;
	
	@Column(name = "dt_inclusao", nullable = false)
	private Date dataInclusao;
	
	@Column(name = "dt_alteracao")
	private Date dataAlteracao;

}
