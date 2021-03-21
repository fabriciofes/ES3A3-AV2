package org.example.project.api.participacao;
import java.util.*;

public class Participacao {
	private int id;
	private int idFuncionario;
	private Date data_inicio;
	private Date data_termino;
	
	
	public Participacao(int id, int idFuncionario, Date data_inicio, Date data_termino) {
		super();
		this.id = id;
		this.idFuncionario = idFuncionario;
		this.data_inicio = data_inicio;
		this.data_termino = data_termino;
	}


	public int getId() {
		return id;
	}


	public int getIdFuncionario() {
		return idFuncionario;
	}


	public Date getData_inicio() {
		return data_inicio;
	}


	public Date getData_termino() {
		return data_termino;
	}
	
	
	
	
}
