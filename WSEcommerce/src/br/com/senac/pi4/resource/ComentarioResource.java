package br.com.senac.pi4.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.ComentarioDTO;
import br.com.senac.pi4.services.ComentarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(tags = {"/comentario"})
@Path("/comentario")
public class ComentarioResource {
	
	ComentarioServiceImpl comentarioServiceImpl = new ComentarioServiceImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = ComentarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Associa um comentario de um usuario a uma historia",
	           response = ComentarioDTO.class)
	public Response saveComentario(ComentarioDTO comentario) {
		try {
			comentario = comentarioServiceImpl.saveComentario(comentario);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (comentario == null)
			return Response.status(404).entity("Comentario nao foi inserido").build();
		
		return Response.status(200).entity(comentario).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	@GET
	@Path("/historia/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = ComentarioDTO.class)
	        
	   })
	   @ApiOperation(value = "seleciona todos os comentarios de um historico de um usuario especifico",
	           response = ComentarioDTO.class)
	public Response getAllComentariosByIdHistoria(@PathParam("param") String idHistoria) {

		List<ComentarioDTO> listPg = null;

		try {
			listPg = comentarioServiceImpl.getAllComentariosByIdHistoria(idHistoria);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (listPg == null)
			return Response.status(404).entity(null).build();

		return Response.status(200).entity(listPg).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();

	}
	
	@GET
	@Path("/count/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = ComentarioDTO.class)
	        
	   })
	   @ApiOperation(value = "seleciona todos os comentarios de um historico de um usuario especifico",
	           response = ComentarioDTO.class)
	public Response getCountAllComentariosByIDHistoria(@PathParam("param") String idHistoria) {

		Integer totalComentarios = null;

		try {
			totalComentarios = comentarioServiceImpl.getCountAllComentariosByIDHistoria(idHistoria);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (totalComentarios == null)
			return Response.status(404).entity(null).build();

		return Response.status(200).entity(totalComentarios).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();

	}
	
	@DELETE
	@Path("/{idUsuario}/{idHistoria}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = ComentarioDTO.class)
	        
	   })
	   @ApiOperation(value = "remove um comentario de um historico de um usuario especifico",
	           response = ComentarioDTO.class)
	public Response deleteComentario(@PathParam("idUsuario") Long idUsuario, Long idHistoria) {


		try {
			 comentarioServiceImpl.deleteComentrio(idUsuario, idHistoria);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (idUsuario == null || idHistoria == null)
			return Response.status(404).entity(null).build();

		return Response.status(200).build();

	}

}
