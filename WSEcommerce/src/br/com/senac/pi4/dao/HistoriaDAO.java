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
			psta = conn.prepareStatement("select  h.id as id_historia, h.data as data_postagem, " + 
					" h.texto as texto_postagem, h.foto as foto_postagem, count(distinct c.usuario) as total_comentarios, count( distinct cur.usuario) as total_curtidas" + 
					" from Historia h left JOIN comentario c " + 
					" on h.id = c.historico left join Curtida cur on h.id = cur.historico GROUP BY c.historico, cur.historico, h.id, h.data, h.texto, h.foto ORDER BY h.data DESC;");

			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				HistoriaDTO pg = new HistoriaDTO();
				pg.setId(rs.getLong("id_historia"));
				pg.setData(rs.getDate("data_postagem"));
				pg.setTexto(rs.getString("texto_postagem"));
				pg.setFoto(rs.getBytes("foto_postagem"));
				pg.setTotalComentarios(rs.getInt("total_comentarios"));
				pg.setTotalCurtidas(rs.getInt("total_curtidas"));
				
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
