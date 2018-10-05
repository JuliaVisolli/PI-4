package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.Comentario;
import br.com.senac.pi4.services.Database;

public class ComentarioDAO {
	
	public Response comentario(Comentario comentario) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("INSERT INTO Comentario"
					+  "(id, usuario, historico, texto) VALUES"
					+  "(?,?,?,?)");
			psta.setLong(1, comentario.getId());		
			psta.setLong(2, comentario.getUsuario().getId());
			psta.setLong(3, comentario.getHistoria().getId());
			psta.setString(4, comentario.getTexto());
	
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
