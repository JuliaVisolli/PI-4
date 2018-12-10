package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.AmizadeDAO;
import br.com.senac.pi4.model.AmizadeDTO;

public class AmizadeServiceImpl {

	AmizadeDAO amizadeDAO = new AmizadeDAO();

	public void solicitaAmizade(AmizadeDTO amizade) throws Exception {
		 amizadeDAO.solicitaAmizade(amizade);
	}
	
	public void deleteAmizade(Long usuario1, Long usuario2) throws Exception {
		amizadeDAO.deleteAmizade(usuario1, usuario2);
	}
//	public void aceitarAmizade(UsuarioDTO  idUsuarioAtual, UsuarioDTO  idUsuarioSolicitou) throws Exception {
//		amizadeDAO.aceitarAmizade(idUsuarioAtual, idUsuarioSolicitou);
//	}
//	
//	public AmizadeDTO findAmizade(long idUsuarioAtual, long idUsuarioProcurado) throws Exception {
//		return amizadeDAO.findAmizade(idUsuarioAtual, idUsuarioProcurado);
//	}
//	
//	public void recusarAmizade(long idUsuarioAtual, long idUsuarioSolicitou) throws Exception {
//		amizadeDAO.recusarAmizade(idUsuarioAtual, idUsuarioSolicitou);
//	}
}
