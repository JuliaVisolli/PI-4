package br.com.senac.pi4.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.AmizadeDTO;
import br.com.senac.pi4.services.AmizadeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "/amizade" })
@Path("/amizade")
public class AmizadeResource {

	AmizadeServiceImpl amizadeServicImpl = new AmizadeServiceImpl();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response solicitarAmizade(AmizadeDTO amizade) throws Exception {
		try {
			amizadeServicImpl.solicitaAmizade(amizade);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (amizade == null)
			return Response.status(404).entity("Solicitacao nao foi aceita").build();

		return Response.status(200).entity(amizade).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}

	@DELETE
	@Path("/{usuario1}/{usuario2}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = AmizadeDTO.class)
	        
	   })
	   @ApiOperation(value = "Remove uma amizade",
	           response = AmizadeDTO.class)
	public Response recusarAmizade(@PathParam("usuario1") Long usuario1, @PathParam("usuario2") Long usuario2) {

		try {
			amizadeServicImpl.deleteAmizade(usuario1, usuario2);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (usuario1 < 1)
			return Response.status(404).entity("Removido com sucesso").build();

		return Response.status(200).entity(usuario1).build();

	}
//	
//	@PUT
//	@Path("/{idUsuario1}/{idUsuario2}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Service executed without errors", response = AmizadeDTO.class)
//
//	})
//	@ApiOperation(value = "Associa um usuario a outro usuario gerando o vinculo de amizade", response = AmizadeDTO.class)
//	public Response aceitarAmizade(@PathParam("idUsuario1")long idUsuarioAtual, @PathParam("idUsuario2")long idUsuarioSolicitou) throws Exception {
//		try {
//			amizadeServicImpl.aceitarAmizade(idUsuarioAtual, idUsuarioSolicitou);
//		} catch (Exception e) {
//			return Response.status(500).entity(e.getMessage()).build();
//		}
//		if (idUsuarioAtual < 1)
//			return Response.status(404).entity("Amizade nao foi aceita").build();
//
//		return Response.status(200).header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//				.header("Access-Control-Allow-Credentials", "true")
//				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
//	}
//	
//	@GET
//	@Path("/{idUsuario1}/{idUsuario2}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Service executed without errors", response = AmizadeDTO.class)
//
//	})
//	@ApiOperation(value = "Procura amizade", response = AmizadeDTO.class)
//	public Response findAmizade(@PathParam("idUsuario1")long idUsuarioAtual, @PathParam("idUsuario2")long idUsuarioProcurado) throws Exception {
//		AmizadeDTO amizadeDTO = null;
//		try {
//			amizadeDTO = amizadeServicImpl.findAmizade(idUsuarioAtual, idUsuarioProcurado);
//		} catch (Exception e) {
//			return Response.status(500).entity(e.getMessage()).build();
//		}
//		if (amizadeDTO == null)
//			return Response.status(404).entity(amizadeDTO).build();
//
//		return Response.status(200).entity(amizadeDTO).header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//				.header("Access-Control-Allow-Credentials", "true")
//				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
//	}
}
