package org.example.project.api.projetos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.project.api.participacao.Participacao;
import org.example.project.api.participacao.PartipacaoResponse;

public class ProjetoResponse {

	public int id;
	public String titulo;
	public Date data_inicio;
	public Date data_final;
	public boolean ativo;
	public List<PartipacaoResponse> participacoes;
	
	public ProjetoResponse(int id, String titulo, Date data_inicio, Date data_final,boolean ativo, List<PartipacaoResponse> participacoes ) {
		this.id = id;
		this.titulo = titulo;
		this.data_inicio = data_inicio;
		this.data_final = data_final;
		this.ativo = ativo;
		this.participacoes = participacoes;
	}
	
	public ProjetoResponse(Projeto projeto) {
	
		this.id = projeto.getId();
		this.titulo = projeto.getTitulo();
		this.data_inicio =projeto.getData_inicio();
		this.data_final =projeto.getData_final();
		this.ativo = projeto.getAtivo();
		this.participacoes = projeto.getParticipacoes();
	}
	

}
