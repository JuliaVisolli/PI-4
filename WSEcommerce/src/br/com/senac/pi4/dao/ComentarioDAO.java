package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senac.pi4.model.ComentarioDTO;
import br.com.senac.pi4.model.UsuarioDTO;
import br.com.senac.pi4.services.Database;

public class ComentarioDAO {

	public ComentarioDTO saveComentario(ComentarioDTO comentario) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement(
					"INSERT INTO Comentario" + "(id, usuario, historico, texto) VALUES" + "(?,?,?,?)");
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
		return comentario;
	}

	public ComentarioDTO getAllComentariosOfHistoria(String idHistoria) throws Exception {
		Connection conn = null;
		PreparedStatement psta = null;
		
		ComentarioDTO pg = null;
		Integer pID = null;
		pID = Integer.parseInt(idHistoria);
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select distinct c.historico, c.texto, c.data from Comentario c INNER JOIN Historia h on" + 
					"c.historico = h.id where c.historico = ? order by c.data ASC");
			
			psta.setInt(1, pID);

			ResultSet rs = psta.executeQuery();

			while (rs.next()) {
				pg = new ComentarioDTO();
				pg.setTexto(rs.getString("texto"));
				pg.setData(rs.getDate("data"));

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
		
		return pg;
	}
	
	public Integer getCountAllComentariosByIDHistoria(String idHistoria) throws Exception {
		Connection conn = null;
		PreparedStatement psta = null;
		
		Integer pID = null;
		Integer total = 0;
		pID = Integer.parseInt(idHistoria);
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select COUNT(*) as total from Comentario where historico = ?");
			
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
