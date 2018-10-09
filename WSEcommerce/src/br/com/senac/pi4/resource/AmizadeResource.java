package br.com.senac.pi4.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Service executed without errors", response = AmizadeDTO.class)

	})
	@ApiOperation(value = "Associa um usuario a outro usuario gerando o vinculo de amizade", response = AmizadeDTO.class)
	public Response solicitaAmizade(AmizadeDTO amizade) throws Exception {
		try {
			amizadeServicImpl.solicitaAmizade(amizade);
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		if (amizade == null)
			return Response.status(404).entity("Comentario nao foi inserido").build();

		return Response.status(200).entity(amizade).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}

}
