package br.com.senac.pi4.services;

import java.util.List;

import br.com.senac.pi4.dao.HistoriaDAO;
import br.com.senac.pi4.model.HistoriaDTO;

public class HistoriaServiceImpl {

	HistoriaDAO historiaDAO = new HistoriaDAO();

	public HistoriaDTO saveHistoria(HistoriaDTO historia) throws Exception {
		return historiaDAO.saveHistoria(historia);
	}
	
	public List<HistoriaDTO> selectAllHistoria(String usuarioId) throws Exception {
		return historiaDAO.selectAllHistoria(usuarioId);
	}
	
	public byte[] selectImage(String historiaId) throws Exception {
		return historiaDAO.selectImage(historiaId);
	}
	

}
