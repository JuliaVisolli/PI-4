package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.AmizadeDTO;
import br.com.senac.pi4.services.Database;


public class AmizadeDAO {
	
	public Response amizade(AmizadeDTO amizade) throws Exception {

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
		return Response.ok().build();
	}
	

}
