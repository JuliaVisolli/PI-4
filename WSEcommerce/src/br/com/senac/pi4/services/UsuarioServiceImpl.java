package br.com.senac.pi4.services;

import java.util.List;

import br.com.senac.pi4.dao.UsuarioDAO;
import br.com.senac.pi4.model.UsuarioDTO;

public class UsuarioServiceImpl {	
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public void save(UsuarioDTO usuario) {
		try {
			usuarioDAO.save(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<UsuarioDTO> listUsuario(){
		try {
			return usuarioDAO.selectAllUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public UsuarioDTO usuario(String usuarioId) {
		try {
			return usuarioDAO.selectUsuario(usuarioId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
