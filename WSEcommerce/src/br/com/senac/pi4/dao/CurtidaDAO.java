package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.Curtida;
import br.com.senac.pi4.services.Database;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public class CurtidaDAO {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = Curtida.class)
	        
	   })
	   @ApiOperation(value = "Associa uma curtida de um usuario a uma historia",
	           response = Curtida.class)
	@Path("/curtida")
	public Response curtida(Curtida curtida) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("INSERT INTO Curtida"
					+  "(usuario, historico) VALUES"
					+  "(?,?)");
					
			psta.setLong(1, curtida.getUsuario().getId());
			psta.setLong(2, curtida.getHistoria().getId());
			
			psta.executeUpdate();
			
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (psta != null)
				psta.close();
			if (conn != null)
				conn.close();
		}
		return Response.ok().build();
	}

}
