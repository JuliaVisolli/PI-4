package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.ComentarioDAO;
import br.com.senac.pi4.model.ComentarioDTO;


public class ComentarioServiceImpl {
	
	ComentarioDAO comentarioDAO = new ComentarioDAO();
	
	public void comentario(ComentarioDTO comentario) {
		try {
			comentarioDAO.comentario(comentario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
