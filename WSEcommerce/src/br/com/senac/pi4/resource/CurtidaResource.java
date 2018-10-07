package br.com.senac.pi4.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.ComentarioDTO;
import br.com.senac.pi4.model.CurtidaDTO;
import br.com.senac.pi4.services.CurtidaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "/curtida" })
@Path("/curtida")
public class CurtidaResource {

	CurtidaServiceImpl curtidaServiceImpl = new CurtidaServiceImpl();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Service executed without errors", response = CurtidaDTO.class)

	})
	@ApiOperation(value = "Associa uma curtida de um usuario a uma historia", response = CurtidaDTO.class)
	public Response saveCurtida(CurtidaDTO curtida) throws Exception {
		try {
			curtida = curtidaServiceImpl.saveCurtida(curtida);
		} catch (

		Exception e) {
			return Response.status(500).entity(null).build();
		}
		if (curtida == null)
			return Response.status(404).entity("Curtida nao foi inserido").build();

		return Response.status(200).entity(curtida).header("Access-Control-Allow-Origin", "*")
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
	   @ApiOperation(value = "seleciona todos as curtidas de um historico de um usuario especifico",
	           response = ComentarioDTO.class)
	public Response getCountAllComentariosByIDHistoria(@PathParam("param") String idHistoria) {

		Integer totalCurtidas = null;

		try {
			totalCurtidas = curtidaServiceImpl.getCountAllCurtidasByIDHistoria(idHistoria);
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		if (totalCurtidas == null)
			return Response.status(404).entity(null).build();

		return Response.status(200).entity(totalCurtidas).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();

	}

}
