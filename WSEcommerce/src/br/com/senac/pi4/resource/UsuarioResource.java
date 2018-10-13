package br.com.senac.pi4.resource;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.UsuarioDTO;
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
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Salva um usuario na base de dados",
	           response = UsuarioDTO.class)
	public Response saveUsuario(UsuarioDTO usuario) {
		try {
			usuario = usuarioServiceImpl.saveUsuario(usuario);
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		if (usuario == null)
			return Response.status(404).entity("Usuario nao encontrado").build();

		return Response.status(200).entity(usuario).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Retorna todos os usuarios disponiveis na base de dados",
	           response = UsuarioDTO.class)
	public List<UsuarioDTO> selectAllUsuario() {
		try {
			return usuarioServiceImpl.selectAllUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Retorna um usuario da base de dados de acordo com o parametro id passado",
	           response = UsuarioDTO.class)
	public Response selectUsuario(@PathParam("param") String usuarioId) {

		UsuarioDTO listPg = null;

		try {
			listPg = usuarioServiceImpl.selectUsuario(usuarioId);
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
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Faz o login do usurio na aplicacao",
	           response = UsuarioDTO.class)
	public Response login(UsuarioDTO usuarioDTO) {

		try {
			usuarioDTO = usuarioServiceImpl.login(usuarioDTO);
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		if (usuarioDTO == null)
			return Response.status(200).entity("Usuario nao encontrado").build();

		return Response.status(200).entity(usuarioDTO).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	@GET
	@Path("/image/{param}")
	@Produces("image/jpg")
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Retorna uma imagem relacionada a um usuario",
	           response = UsuarioDTO.class)
	public Response selectImage(@PathParam("param") String usuarioId) {


		byte[] image = null;

		try {
			image = usuarioServiceImpl.selectImage(usuarioId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.ok(new ByteArrayInputStream(image)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();

	}

	@GET
	@Path("/amigo/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Retorna todos os amigos disponiveis na base de dados",
	           response = UsuarioDTO.class)
	public List<UsuarioDTO> buscaAmigo(@PathParam("param") String idUsuario) {
		try {
			return usuarioServiceImpl.buscaAmigo(idUsuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/perfil/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Retorna todas as informacoes pertinentes ao perfil de um usuario especifico, como nome, historias, foto, texto, etc",
	           response = UsuarioDTO.class)
	public List<UsuarioDTO> perfilUsuario(@PathParam("param") String idUsuario) {
		try {
			return usuarioServiceImpl.perfilUsuario(idUsuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
