package br.com.senac.pi4.dao;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import br.com.senac.pi4.model.HistoriaDTO;
import br.com.senac.pi4.model.UsuarioDTO;
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
			if(historia.getFoto() != null) {
				String base64 = historia.getFoto();
				byte[] fotoEmByte = Base64.getDecoder().decode(base64);
		
					psta.setBytes(3, fotoEmByte);
			} else {
				psta.setBytes(3,  null);
			}
						
//			}
//			psta.setBytes(3, null);

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
	
	public List<HistoriaDTO> selectAllHistoria(String usuarioId) throws Exception {
		// exemplo de select
		Connection conn = null;
		PreparedStatement psta = null;
		List<HistoriaDTO> listPg = new ArrayList<HistoriaDTO>();

		try {
			conn = Database.get().conn();
//			psta = conn.prepareStatement("select  u.foto as usuario_foto, u.nome as usuario_nome, h.id as id_historia, h.data as data_postagem, " + 
//					" h.texto as texto_postagem, h.foto as foto_postagem, count(distinct c.usuario) as total_comentarios, count( distinct cur.usuario) as total_curtidas" + 
//					" from Historia h left JOIN comentario c " + 
//					" on h.id = c.historico left join Curtida cur on h.id = cur.historico Inner Join Usuario u on u.id = h.usuario GROUP BY c.historico, cur.historico, h.id, h.data, h.texto, h.foto, u.foto, u.nome ORDER BY h.data DESC;");
			psta = conn.prepareStatement("select  u.foto as usuario_foto, u.nome as usuario_nome, u.id as usuario_id, h.id as id_historia, h.data as data_postagem, " + 
					"					 h.texto as texto_postagem, h.foto as foto_postagem, count( c.usuario) as total_comentarios, count( distinct cur.usuario) as total_curtidas " + 
					"					 from Historia h left JOIN comentario c " + 
					"					 on h.id = c.historico left join Curtida cur on h.id = cur.historico Inner Join Usuario u on u.id = h.usuario " + 
					"					 where u.id in (SELECT usuario1 FROM Amizade a WHERE a.usuario2 = ? and a.aprovada = 1) OR " + 
					"					u.id in (SELECT usuario2 FROM Amizade a WHERE a.usuario1 = ? and a.aprovada = 1) " + 
					"and u.id <> ?  GROUP BY c.historico, cur.historico, h.id, h.data, h.texto, h.foto, u.foto, u.id, u.nome ORDER BY h.data DESC;");
			
			psta.setString(1, usuarioId);
			psta.setString(2, usuarioId);
			psta.setString(3, usuarioId);
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				HistoriaDTO pg = new HistoriaDTO();
				pg.setId(rs.getLong("id_historia"));
				pg.setUsuario(new UsuarioDTO(rs.getString("usuario_nome"), rs.getLong("usuario_id")));
				pg.setFoto(rs.getString("foto_postagem"));
				pg.setData(rs.getDate("data_postagem"));
				pg.setTexto(rs.getString("texto_postagem"));
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
	
	public byte[] selectImage(String historiaId) throws Exception {
		// exemplo de select
		Connection conn = null;
		PreparedStatement psta = null;

		Integer pID = null;
		pID = Integer.parseInt(historiaId);
		byte[] fileBytes = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select * from Historia where id = ?");
			psta.setInt(1, pID);

			//
			ResultSet rs = psta.executeQuery();

			while (rs.next()) {
				fileBytes = rs.getBytes("foto");

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
		return fileBytes;
	}


	
}
