package org.example.project.api.projetos;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;


@Path("projeto")
public class ProjetoResource {
	private  static ProjetoRepository projetoRepository = new ProjetoRepository();
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 //criando usuario 
	 
	public Response create(ProjetoRequest request) {
		 
		 Projeto projeto = new Projeto(request.titulo, request.data_inicio, request.data_final, request.ativo);
		 Date atual = new Date(System.currentTimeMillis());
		 projetoRepository.save(projeto);
		 if(request.data_inicio.before(atual)) {
			 return Response.status(Status.NOT_FOUND).build();
			 
		 }else if(request.data_inicio.after(request.data_final)){
			 
			 return Response.status(Status.NOT_FOUND).build();
		 }else if(request.data_final.before(request.data_inicio)) {
			 
			 return Response.status(Status.NOT_FOUND).build();
		 }
		 
		 return Response.status(Response.Status.CREATED).entity(new ProjetoResponse(projeto.getId(),projeto.getTitulo(),projeto.getData_inicio(),projeto.getData_final(),projeto.getAtivo(), projeto.getParticipacoes()))
		 .build();
	
	
	 }
	 
	 
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response index() {
		 
		/* List<UserResponse> userResponses = new ArrayList<>();
		 for(User user: userRepository.getAll()) {
			 userResponses.add(new UserResponse(user));
			 
		 }*/
		 List<ProjetoResponse> projetoResponses = projetoRepository.getAll().stream()
				 .map(ProjetoResponse:: new).collect(Collectors.toList());
		
		 
		 
		return Response.status(Status.OK).entity(projetoResponses).build();
		 
		 
	 }
	 @GET
	 @Path("{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response show(@PathParam("id") int id) {
		 Projeto projeto = projetoRepository.getById(id);
		 
		 if(projeto == null) {
			 return Response.status(Status.NOT_FOUND).build();
		 }
		 
		return Response.status(Status.OK).entity(new ProjetoResponse(projeto)).build();
		 
		 
	 }
	 
	 @PUT
	 @Path("{id}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response update(@PathParam("id") int id, ProjetoRequest request) {
		
		Projeto projeto = projetoRepository.getById(id);
		 if(projeto == null) {
			 return Response.status(Status.NOT_FOUND).build();
		 }
		 Projeto newprojeto=   new Projeto(request.titulo, request.data_inicio, request.data_final, request.ativo);
		projetoRepository.update(newprojeto);
		 return Response.status(Status.OK).entity(newprojeto).build();
		 
		 	 
 
	 }
	 
	 @DELETE
	 @Path("{id}") 
	 public Response delete(@PathParam("id") int id) {
		 
		Projeto projeto = projetoRepository.getById(id);
		 if(projeto == null) {
			 return Response.status(Status.NOT_FOUND).build();
		 
		 
		 }
		projetoRepository.delete(projeto);
		 return Response.status(Status.NO_CONTENT).build();
	
		 
	 }
	 
}
