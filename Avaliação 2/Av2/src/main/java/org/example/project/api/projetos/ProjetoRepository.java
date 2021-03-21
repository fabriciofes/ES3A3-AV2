package org.example.project.api.projetos;


import java.util.ArrayList;
import java.util.List;



public class ProjetoRepository {
	private List<Projeto> projetos = new ArrayList<>();
	
	public Projeto save(Projeto projeto) {
		projetos.add(projeto);
		return projeto;
	}
	
	public List<Projeto> getAll(){
		return projetos;
	}
	public Projeto getById(int id) {
		// TODO Auto-generated method stub
		return projetos.stream().filter(projeto -> projeto.getId()== id).findAny().orElse(null);}
	
	
	public Projeto update(Projeto projeto) {
		
		Projeto projetoFound = getById(projeto.getId());
		projetos.set(projetos.indexOf(projetoFound), projeto);
		return projeto;
	}
	
	public void delete (Projeto projeto) {
		projetos.remove(projeto);
	}
	

}
