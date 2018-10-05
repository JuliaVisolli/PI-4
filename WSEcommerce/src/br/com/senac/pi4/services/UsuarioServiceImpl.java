package br.com.senac.pi4.services;

import java.util.List;

import br.com.senac.pi4.dao.UsuarioDAO;
import br.com.senac.pi4.model.Usuario;

public class UsuarioServiceImpl {	
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public void save(Usuario usuario) {
		try {
			usuarioDAO.save(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Usuario> listUsuario(){
		try {
			return usuarioDAO.selectAllUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Usuario usuario(String usuarioId) {
		try {
			return usuarioDAO.selectUsuario(usuarioId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
