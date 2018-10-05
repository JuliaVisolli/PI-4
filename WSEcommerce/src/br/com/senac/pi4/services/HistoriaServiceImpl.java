package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.HistoriaDAO;
import br.com.senac.pi4.model.Historia;

public class HistoriaServiceImpl {
	
	HistoriaDAO historiaDAO = new HistoriaDAO();
	
	public void historia(Historia historia) {
		try {
			historiaDAO.historia(historia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
