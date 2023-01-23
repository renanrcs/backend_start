package com.capgemini.start.api.dto.input;

import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;

@Schema(name = "TipoInput", description = "Objeto de entrada para inclusão e alteração da entidade Genero")
@Data
public class GeneroInputDTO {
	
	@NonNull
	@Length(max = 100)
	private String descricao;

}
