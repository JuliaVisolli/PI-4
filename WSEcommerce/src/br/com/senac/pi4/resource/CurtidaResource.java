package br.com.senac.pi4.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senac.pi4.model.CurtidaDTO;
import br.com.senac.pi4.services.CurtidaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(tags = {"/curtida"})
@Path("/curtida")
public class CurtidaResource {
	
	CurtidaServiceImpl curtidaServiceImpl = new CurtidaServiceImpl();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = CurtidaDTO.class)
	        
	   })
	   @ApiOperation(value = "Associa uma curtida de um usuario a uma historia",
	           response = CurtidaDTO.class)
	public void curtida(CurtidaDTO curtida) throws Exception {
		curtidaServiceImpl.curtida(curtida);
	}

}
