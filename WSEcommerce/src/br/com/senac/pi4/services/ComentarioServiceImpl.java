package br.com.senac.pi4.services;

import java.util.List;

import br.com.senac.pi4.dao.ComentarioDAO;
import br.com.senac.pi4.model.ComentarioDTO;

public class ComentarioServiceImpl {

	ComentarioDAO comentarioDAO = new ComentarioDAO();

	public ComentarioDTO saveComentario(ComentarioDTO comentario) throws Exception {
		return comentarioDAO.saveComentario(comentario);
	}

	public List<ComentarioDTO> getAllComentariosByIdHistoria(String idHistoria) throws Exception {
		return comentarioDAO.getAllComentariosByIdHistoria(idHistoria);
	}

	public Integer getCountAllComentariosByIDHistoria(String idHistoria) throws Exception {
		return comentarioDAO.getCountAllComentariosByIDHistoria(idHistoria);
	}

	public void deleteComentrio(Long idUsuario, Long idHistoria) throws Exception {
		comentarioDAO.deleteComentario(idUsuario, idHistoria);
	}
}
