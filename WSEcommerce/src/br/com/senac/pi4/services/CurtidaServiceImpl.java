package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.CurtidaDAO;
import br.com.senac.pi4.model.CurtidaDTO;

public class CurtidaServiceImpl {

	CurtidaDAO curtidaDAO = new CurtidaDAO();

	public CurtidaDTO saveCurtida(CurtidaDTO curtida) throws Exception {
		return curtidaDAO.saveCurtida(curtida);
	}
	
	public void deleteCurtida(Long idUsuario, Long idHistoria) throws Exception {
		 curtidaDAO.deleteCurtida(idUsuario, idHistoria);
	}
	
	public Integer getCountAllCurtidasByIDHistoria(String idHistoria) throws Exception {
		return curtidaDAO.getCountAllCurtidasByIDHistoria(idHistoria);
	}

}
