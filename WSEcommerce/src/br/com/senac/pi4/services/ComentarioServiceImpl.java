package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.ComentarioDAO;
import br.com.senac.pi4.model.ComentarioDTO;


public class ComentarioServiceImpl {
	
	ComentarioDAO comentarioDAO = new ComentarioDAO();
	
	public ComentarioDTO saveComentario(ComentarioDTO comentario) throws Exception {
		return comentarioDAO.saveComentario(comentario);
	}
	
	public ComentarioDTO getAllComentariosOfHistoria(String idHistoria) throws Exception {
		return comentarioDAO.getAllComentariosOfHistoria(idHistoria);
	}
	
	public Integer getCountAllComentariosByIDHistoria(String idHistoria) throws Exception {
		return comentarioDAO.getCountAllComentariosByIDHistoria(idHistoria);
	}
}
