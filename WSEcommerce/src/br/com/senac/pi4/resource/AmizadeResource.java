package br.com.senac.pi4.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senac.pi4.model.AmizadeDTO;
import br.com.senac.pi4.services.AmizadeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"/amizade"})
@Path("/amizade")
public class AmizadeResource {
	
	AmizadeServiceImpl amizadeServicImpl = new AmizadeServiceImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = AmizadeDTO.class)
	        
	   })
	   @ApiOperation(value = "Associa um usuario a outro usuario gerando o vinculo de amizade",
	           response = AmizadeDTO.class)
	public void amizade(AmizadeDTO amizade) throws Exception {
		amizadeServicImpl.amizade(amizade);
	}
	

}
