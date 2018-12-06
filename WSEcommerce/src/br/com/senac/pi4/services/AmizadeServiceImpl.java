package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.AmizadeDAO;
import br.com.senac.pi4.model.AmizadeDTO;

public class AmizadeServiceImpl {

	AmizadeDAO amizadeDAO = new AmizadeDAO();

	public void solicitarAmizade(long idUsuarioAtual, long idUsuarioSolicitado) throws Exception {
		 amizadeDAO.solicitarAmizade(idUsuarioAtual, idUsuarioSolicitado);
	}
	
	public void aceitarAmizade(long idUsuarioAtual, long idUsuarioSolicitou) throws Exception {
		amizadeDAO.aceitarAmizade(idUsuarioAtual, idUsuarioSolicitou);
	}
	
	public AmizadeDTO findAmizade(long idUsuarioAtual, long idUsuarioProcurado) throws Exception {
		return amizadeDAO.findAmizade(idUsuarioAtual, idUsuarioProcurado);
	}
	
	public void recusarAmizade(long idUsuarioAtual, long idUsuarioSolicitou) throws Exception {
		amizadeDAO.recusarAmizade(idUsuarioAtual, idUsuarioSolicitou);
	}
}
