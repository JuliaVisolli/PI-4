package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.pi4.model.HistoriaDTO;
import br.com.senac.pi4.services.Database;

public class HistoriaDAO {

	public HistoriaDTO saveHistoria(HistoriaDTO historia) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("INSERT INTO Historia" + "(usuario, texto, foto) VALUES" + "(?,?,?)");

			psta.setLong(1, historia.getUsuario().getId());
			psta.setString(2, historia.getTexto());
			psta.setBytes(3, historia.getFoto());
			
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
		return historia;
	}
	
	public List<HistoriaDTO> selectAllHistoria() throws Exception {
		// exemplo de select
		Connection conn = null;
		PreparedStatement psta = null;
		List<HistoriaDTO> listPg = new ArrayList<HistoriaDTO>();

		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select * from Historia h INNER JOIN comentario c on h.id = c.historico INNER JOIN curtida cur on h.id = cur.historico order by h.data DESC ");

			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				HistoriaDTO pg = new HistoriaDTO();
				pg.setId(rs.getLong("id"));
//				pg.getUsuario().setId(rs.getLong("usuario"));
				pg.setTexto(rs.getString("texto"));
				pg.setFoto(rs.getBytes("foto"));
				pg.setData(rs.getDate("data"));

				listPg.add(pg);
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
		return listPg;
	}


}
