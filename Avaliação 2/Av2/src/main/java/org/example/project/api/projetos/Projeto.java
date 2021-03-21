package org.example.project.api.projetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.project.api.participacao.PartipacaoResponse;

public class Projeto {
	private int id;
	private String titulo;
	private  Date data_inicio =  new Date();
	private Date data_final;
	private static int countId = 0;
	private boolean ativo;
	private List<PartipacaoResponse> participacoes;
	

	public Projeto(String titulo, Date data_inicio, Date data_final, boolean ativo) {
		this.id = countId++;
		this.titulo = titulo;
		this.data_inicio = new Date();
		this.data_final = data_final;
		this.ativo = ativo;
		this.participacoes = participacoes;
	}
	
	
	public Projeto(int id, String titulo, Date data_inicio, Date data_final,  boolean ativo, List<PartipacaoResponse> participacoes) {
		this.id = id;
		this.titulo = titulo;
		this.data_inicio = data_inicio;
		this.data_final = data_final;
		this.ativo = ativo;
		this.participacoes = participacoes;
	}


	public int getId() {
		return id;
	}
	public boolean getAtivo() {
		return ativo;
	}


	public String getTitulo() {
		return titulo;
	}
	public Date getData_inicio() {
		return data_inicio;
	}
	public Date getData_final() {
		return data_final;
	}
	public static int getCountId() {
		return countId;
	}


	public List<PartipacaoResponse> getParticipacoes() {
		return participacoes;
	}
	
	

}
