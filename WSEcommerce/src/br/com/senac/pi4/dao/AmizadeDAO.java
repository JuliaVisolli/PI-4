package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.senac.pi4.model.AmizadeDTO;
import br.com.senac.pi4.services.Database;


public class AmizadeDAO {
	
	public AmizadeDTO solicitaAmizade(AmizadeDTO amizade) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("INSERT INTO Amizade"
					+  "(usuario1, usuario2, aprovada) VALUES"
					+  "(?,?,?)");
					
			psta.setLong(1, amizade.getUsuario1().getId());
			psta.setLong(2, amizade.getUsuario2().getId());
			psta.setBoolean(3, amizade.isAprovada());

			psta.executeUpdate();
			
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (psta != null)
				psta.close();
			if (conn != null)
				conn.close();
		}
		return null;
	}
	
	public void deleteAmizade(Long idUsuario1, Long idUsuario2, Boolean aprovada) throws Exception {
		String sql = "DELETE FROM Amizade WHERE usuario1 = ? usuario2 = ? and aprovada = 1";
		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement(sql);
			
			psta.setLong(1, idUsuario1);
			psta.setLong(2, idUsuario2);
			psta.setBoolean(3, aprovada);

			psta.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (psta != null)
				psta.close();
			if (conn != null)
				conn.close();
		}
	}
	
}
