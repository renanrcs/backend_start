package com.capgemini.start.api.dto.output;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(name = "Genero", description = "Objeto de saida da entidade Genero")
@Data
public class GeneroDTO {
	
	private Integer id;
	private String descricao;
	private LocalDateTime dataInclusao;
	private LocalDateTime dataAlteracao;

}
