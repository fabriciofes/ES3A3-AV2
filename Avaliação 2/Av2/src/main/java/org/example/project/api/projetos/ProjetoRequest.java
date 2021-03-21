package org.example.project.api.projetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.project.api.participacao.Participacao;

import jakarta.validation.constraints.*;


public class ProjetoRequest {
	@NotNull
	@NotBlank 
	@Size(min = 3, max = 100)
	public String titulo;
	@NotNull
	@FutureOrPresent
	public  Date data_inicio;
	@Future
	public Date data_final;
	public boolean ativo;
	
	
}
