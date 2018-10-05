package br.com.senac.pi4.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senac.pi4.model.Comentario;
import br.com.senac.pi4.services.ComentarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(tags = {"/comentario"})
@Path("/comentario")
public class ComentarioResource {
	
	ComentarioServiceImpl comentarioService = new ComentarioServiceImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = Comentario.class)
	        
	   })
	   @ApiOperation(value = "Associa um comentario de um usuario a uma historia",
	           response = Comentario.class)
	public void comentario(Comentario comentario) {
		comentarioService.comentario(comentario);
	}

}