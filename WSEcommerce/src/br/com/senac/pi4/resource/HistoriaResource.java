package br.com.senac.pi4.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.HistoriaDTO;
import br.com.senac.pi4.model.UsuarioDTO;
import br.com.senac.pi4.services.HistoriaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "/historia" })
@Path("/historia")
public class HistoriaResource {

	HistoriaServiceImpl historiaServiceImpl = new HistoriaServiceImpl();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Service executed without errors", response = HistoriaDTO.class)

	})
	@ApiOperation(value = "Associa uma historia a um usuario", response = HistoriaDTO.class)
	public Response saveHistoria(HistoriaDTO historia) {
		try {
			historia = historiaServiceImpl.saveHistoria(historia);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (historia == null)
			return Response.status(404).entity("Historia nao foi inserida").build();

		return Response.status(200).entity(historia).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();

	}

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Service executed without errors", response = HistoriaDTO.class)

	})
	@ApiOperation(value = "Retorna todas historias disponiveis na base de dados", response = UsuarioDTO.class)
	public Response selectAllHistorias(@PathParam("param") String usuarioId) {
		List<HistoriaDTO> historiaDTOs = new ArrayList<>();
		try {
			historiaDTOs = historiaServiceImpl.selectAllHistoria(usuarioId);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (historiaDTOs == null)
			return Response.status(404).entity("Historia nao foi inserida").build();

		return Response.status(200).entity(historiaDTOs).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}

}
