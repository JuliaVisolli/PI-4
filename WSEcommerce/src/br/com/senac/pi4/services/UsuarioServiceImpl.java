package br.com.senac.pi4.services;

import java.util.List;

import br.com.senac.pi4.dao.UsuarioDAO;
import br.com.senac.pi4.model.UsuarioDTO;

public class UsuarioServiceImpl {

	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public UsuarioDTO saveUsuario(UsuarioDTO usuario) throws Exception {
		return usuarioDAO.saveUsuario(usuario);
	}

	public UsuarioDTO selectUsuario(String usuarioId) throws Exception {
		return usuarioDAO.selectUsuario(usuarioId);
	}

	public List<UsuarioDTO> selectAllUsuario() throws Exception {
		return usuarioDAO.selectAllUsuario();
	}

	public UsuarioDTO login(UsuarioDTO usuarioDTO) throws Exception {
		return usuarioDAO.login(usuarioDTO);
	}
	
	public byte[] selectImage(String usuarioId) throws Exception {
		return usuarioDAO.selectImage(usuarioId);
	}
	
	public List<UsuarioDTO> buscaAmigo(String usuarioId) throws Exception {
		return usuarioDAO.buscaAmigo(usuarioId);
	}
	
	public List<UsuarioDTO> perfilUsuario(String idUsuario) throws Exception {
		return usuarioDAO.perfilUsuario(idUsuario);
	}
	
	public Integer getCountAllAmigosByUserID(String idUsuario) throws Exception {
		return usuarioDAO.getCountAllAmigosByUserID(idUsuario);
	}
	
	public Integer getCountAllFotoByUserID(String idUsuario) throws Exception {
		return usuarioDAO.getCountAllFotoByUserID(idUsuario);
	}
	

}
