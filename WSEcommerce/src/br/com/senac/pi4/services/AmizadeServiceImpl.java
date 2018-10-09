package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.AmizadeDAO;
import br.com.senac.pi4.model.AmizadeDTO;

public class AmizadeServiceImpl {

	AmizadeDAO amizadeDAO = new AmizadeDAO();

	public AmizadeDTO solicitaAmizade(AmizadeDTO amizade) throws Exception {
		return amizadeDAO.solicitaAmizade(amizade);
	}

}
