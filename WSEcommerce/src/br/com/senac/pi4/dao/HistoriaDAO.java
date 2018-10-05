package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.Historia;
import br.com.senac.pi4.services.Database;

public class HistoriaDAO {
	
	
	public Response historia(Historia historia) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("INSERT INTO Historia"
					+  "(usuario, texto) VALUES"
					+  "(?,?)");
			
			psta.setLong(1, historia.getUsuario().getId());
			psta.setString(2, historia.getTexto());

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
