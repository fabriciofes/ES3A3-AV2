package org.example.project.api.participacao;

import jakarta.ws.rs.Path;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;


@Path("participacao")
public class ParticipacaoResource {
	
	private static ParticipacaoRepository participacaoRepository =  new ParticipacaoRepository();
	@POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	public Response create(ParticipacaoRequest request) {
		
 Participacao participacao = new Participacao(request.id, request.idFuncionario, request.data_inicio, request.data_termino);
		 
		 participacaoRepository.save(participacao);
		 
		 return Response.status(Response.Status.CREATED).entity(new PartipacaoResponse(participacao.getId(),
				 participacao.getIdFuncionario(),participacao.getData_inicio(), participacao.getData_termino()))
		 .build();
	}
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response index() {
		 
		/* List<UserResponse> userResponses = new ArrayList<>();
		 for(User user: userRepository.getAll()) {
			 userResponses.add(new UserResponse(user));
			 
		 }*/
		 List<PartipacaoResponse>participacaoResponses = participacaoRepository.getAll().stream()
				 .map(PartipacaoResponse:: new).collect(Collectors.toList());
		
		 
		 
		return Response.status(Status.OK).entity(participacaoResponses).build();
		 
		 
	 }
	
	

}
