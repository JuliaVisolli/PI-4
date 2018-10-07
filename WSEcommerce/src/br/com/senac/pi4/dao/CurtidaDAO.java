package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senac.pi4.model.CurtidaDTO;
import br.com.senac.pi4.services.Database;

public class CurtidaDAO {

	public CurtidaDTO saveCurtida(CurtidaDTO curtida) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("INSERT INTO Curtida" + "(usuario, historico) VALUES" + "(?,?)");

			psta.setLong(1, curtida.getUsuario().getId());
			psta.setLong(2, curtida.getHistoria().getId());

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
		return curtida;
	}

	public void delete(Long id) throws Exception {
		String sql = "DELETE FROM Curtida WHERE usuario = ?";
		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement(sql);
			
			psta.setLong(1, id);

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
	
	public Integer getCountAllCurtidasByIDHistoria(String idHistoria) throws Exception {
		Connection conn = null;
		PreparedStatement psta = null;
		
		Integer pID = null;
		Integer total = 0;
		pID = Integer.parseInt(idHistoria);
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select COUNT(*) as total from Curtida where historico = ?");
			
			psta.setInt(1, pID);

			ResultSet rs = psta.executeQuery();

			while (rs.next()) {
				
				total = rs.getInt("total");

			}

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
		
		return total;
	}
}
