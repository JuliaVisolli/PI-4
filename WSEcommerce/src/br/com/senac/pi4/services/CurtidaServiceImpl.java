package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.CurtidaDAO;
import br.com.senac.pi4.model.CurtidaDTO;

public class CurtidaServiceImpl {

	CurtidaDAO curtidaDAO = new CurtidaDAO();

	public void curtida(CurtidaDTO curtida) throws Exception {

		curtidaDAO.curtida(curtida);

	}

}
