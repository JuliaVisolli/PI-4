package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.HistoriaDAO;
import br.com.senac.pi4.model.HistoriaDTO;

public class HistoriaServiceImpl {
	
	HistoriaDAO historiaDAO = new HistoriaDAO();
	
	public void historia(HistoriaDTO historia) {
		try {
			historiaDAO.historia(historia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
