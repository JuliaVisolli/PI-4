package br.com.senac.pi4.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senac.pi4.model.HistoriaDTO;
import br.com.senac.pi4.services.HistoriaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"/historia"})
@Path("/historia")
public class HistoriaResource {
	
	HistoriaServiceImpl historiaServiceImpl = new HistoriaServiceImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = HistoriaDTO.class)
	        
	   })
	   @ApiOperation(value = "Associa uma historia a um usuário",
	           response = HistoriaDTO.class)
	public void historia(HistoriaDTO historia) {
		historiaServiceImpl.historia(historia);
	}

}
