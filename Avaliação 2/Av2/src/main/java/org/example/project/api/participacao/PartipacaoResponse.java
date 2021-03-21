package org.example.project.api.participacao;

import java.util.Date;

public class PartipacaoResponse {
	public int id;
	public int idFuncionario;
	public Date data_inicio;
	public Date data_termino;
	public PartipacaoResponse(int id, int idFuncionario, Date data_inicio, Date data_termino) {
		this.id = id;
		this.idFuncionario = idFuncionario;
		this.data_inicio = data_inicio;
		this.data_termino = data_termino;
	}
	
	public PartipacaoResponse(Participacao participacao) {
		this.id = participacao.getId();
		this.idFuncionario = participacao.getIdFuncionario();
		this.data_inicio = participacao.getData_inicio();
		this.data_termino = participacao.getData_termino();
	}
	

}
