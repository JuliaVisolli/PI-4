package br.com.senac.pi4.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.Usuario;
import br.com.senac.pi4.services.UsuarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"/usuario"})
@Path("/usuario")
public class UsuarioResource {
	
	UsuarioServiceImpl usuarioServiceImpl = new UsuarioServiceImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = Usuario.class)
	        
	   })
	   @ApiOperation(value = "Salva um usuario na base de dados",
	           response = Usuario.class)
	public void save(Usuario usuario) {
		usuarioServiceImpl.save(usuario);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = Usuario.class)
	        
	   })
	   @ApiOperation(value = "Retorna todos os usuários",
	           response = Usuario.class)
	public List<Usuario> list() {
		return usuarioServiceImpl.listUsuario();
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getUsuario() {
//
//		List<Usuario> listPg = null;
//
//		try {
//			listPg = usuarioServiceImpl.listUsuario();
//		} catch (Exception e) {
//			return Response.status(500).entity(null).build();
//		}
//		if (listPg == null)
//			return Response.status(404).entity(null).build();
//
//		return Response.status(200).entity(listPg).header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//				.header("Access-Control-Allow-Credentials", "true")
//				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
//
//	}
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response usuario(@PathParam("param") String usuarioId) {

		Usuario listPg = null;

		try {
			listPg = usuarioServiceImpl.usuario(usuarioId);
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		if (listPg == null)
			return Response.status(404).entity(null).build();

		return Response.status(200).entity(listPg).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();

	}

}
