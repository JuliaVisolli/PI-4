package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.AmizadeDAO;
import br.com.senac.pi4.model.Amizade;

public class AmizadeServiceImpl {

	AmizadeDAO amizadeDAO = new AmizadeDAO();

	public void amizade(Amizade amizade) {
		try {
			amizadeDAO.amizade(amizade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
