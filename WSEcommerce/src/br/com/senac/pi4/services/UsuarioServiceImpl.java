package br.com.senac.pi4.services;

import java.util.List;

import br.com.senac.pi4.dao.UsuarioDAO;
import br.com.senac.pi4.model.UsuarioDTO;

public class UsuarioServiceImpl {

	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public void save(UsuarioDTO usuario) throws Exception {
		usuarioDAO.save(usuario);
	}

	public List<UsuarioDTO> listUsuario() throws Exception {
		return usuarioDAO.selectAllUsuario();
	}

	public UsuarioDTO usuario(String usuarioId) throws Exception {
		return usuarioDAO.selectUsuario(usuarioId);
	}

	public UsuarioDTO login(UsuarioDTO usuarioDTO) throws Exception {
		return usuarioDAO.login(usuarioDTO);
	}

}
