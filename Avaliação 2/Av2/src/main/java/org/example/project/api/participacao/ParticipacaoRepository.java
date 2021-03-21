package org.example.project.api.participacao;


import java.util.ArrayList;
import java.util.List;



public class ParticipacaoRepository {
	
private List<Participacao> participacoes = new ArrayList<>();
	
	public Participacao save(Participacao participacao) {
		participacoes.add(participacao);
		return participacao;}
	
	public List<Participacao> getAll(){
		
		return participacoes;}
	
//para buscar por id 
	public Participacao getById(int id) {
		// TODO Auto-generated method stub
		return participacoes.stream().filter(participacao -> participacao.getId() == id	).findAny().orElse(null);}
	

}
