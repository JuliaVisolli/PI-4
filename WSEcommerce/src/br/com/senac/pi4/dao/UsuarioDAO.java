package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.senac.pi4.model.HistoriaDTO;
import br.com.senac.pi4.model.UsuarioDTO;
import br.com.senac.pi4.services.Database;

public class UsuarioDAO {

	public UsuarioDTO saveUsuario(UsuarioDTO usuario) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select COUNT(*) as total from Usuario u where u.email = ?");
			psta.setString(1, usuario.getEmail());

			ResultSet rs = psta.executeQuery();

			while (rs.next()) {
				Integer totalEmail = rs.getInt("total");
				if (totalEmail > 0) {
					System.out.println("E-mail já existe. Cadastre outro e-mail");
					return null;
				} else if (usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty()) {
					System.out.println("E-mail e senha são obrigatórios.");
					return null;
				}
			}

			psta = conn.prepareStatement("INSERT INTO Usuario" + "(nome, senha, email,foto) VALUES" + "(?,?,?,?)");

			psta.setString(1, usuario.getNome());
			psta.setString(2, usuario.getSenha());
			psta.setString(3, usuario.getEmail());
			psta.setBytes(4, usuario.getFoto());

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
		return usuario;
	}

	public UsuarioDTO selectUsuario(String usuarioId) throws Exception {
		// exemplo de select
		Connection conn = null;
		PreparedStatement psta = null;

		UsuarioDTO pg = null;
		Integer pID = null;
		pID = Integer.parseInt(usuarioId);
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select * from Usuario where id = ?");
			psta.setInt(1, pID);

			ResultSet rs = psta.executeQuery();

			while (rs.next()) {
				pg = new UsuarioDTO();
				pg.setNome(rs.getString("nome"));
				pg.setSenha(rs.getString("senha"));
				pg.setId(rs.getLong("id"));
				pg.setEmail(rs.getString("email"));
				pg.setFoto(rs.getBytes("foto"));

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

	public List<UsuarioDTO> selectAllUsuario() throws Exception {
		// exemplo de select
		Connection conn = null;
		PreparedStatement psta = null;
		List<UsuarioDTO> listPg = new ArrayList<UsuarioDTO>();

		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select * from Usuario");

			ResultSet rs = psta.executeQuery();

			while (rs.next()) {
				UsuarioDTO pg = new UsuarioDTO();
				pg.setNome(rs.getString("nome"));
				pg.setSenha(rs.getString("senha"));
				pg.setId(rs.getLong("id"));
				pg.setEmail(rs.getString("email"));
				pg.setFoto(rs.getBytes("foto"));

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

	public UsuarioDTO login(UsuarioDTO usuarioDTO) throws Exception {

		String email = null;
		String senha = null;
		final Iterator<UsuarioDTO> usuarioIterator = selectAllUsuario().iterator();

		while (usuarioIterator.hasNext()) {
			UsuarioDTO usuarioDTOs = usuarioIterator.next();
			email = usuarioDTOs.getEmail();
			senha = usuarioDTOs.getSenha();

			if (usuarioDTO.getEmail().equalsIgnoreCase(email) && usuarioDTO.getSenha().equalsIgnoreCase(senha)) {
				return usuarioDTOs;
			}

		}
		return null;

	}

	public byte[] selectImage(String usuarioId) throws Exception {
		// exemplo de select
		Connection conn = null;
		PreparedStatement psta = null;

		Integer pID = null;
		pID = Integer.parseInt(usuarioId);
		byte[] fileBytes = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select * from Usuario where id = ?");
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

	public List<UsuarioDTO> buscaAmigo(String idUsuario) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;

		List<UsuarioDTO> listUsers = new ArrayList<UsuarioDTO>();
		UsuarioDTO pg = null;
		Integer pID = null;
		pID = Integer.parseInt(idUsuario);
		try {
			conn = Database.get().conn();

			psta = conn.prepareStatement("select  u.id, u.nome, u.email, u.foto " + "from Usuario u " + "where "
					+ "	u.id = (SELECT usuario1 " + "		FROM Amizade a " + "		WHERE a.usuario2 = ? and a.aprovada = 1)" + "	OR "
					+ "	u.id = (SELECT usuario2" + "		FROM Amizade a" + "		WHERE a.usuario1 = ? and a.aprovada = 1)");

			psta.setInt(1, pID);
			psta.setInt(2, pID);

			ResultSet rs = psta.executeQuery();

			while (rs.next()) {
				pg = new UsuarioDTO();
				pg.setNome(rs.getString("nome"));
				pg.setId(rs.getLong("id"));
				pg.setEmail(rs.getString("email"));
				pg.setFoto(rs.getBytes("foto"));

				listUsers.add(pg);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (psta != null)
				psta.close();
			if (conn != null)
				conn.close();
		}
		return listUsers;

	}

	public List<UsuarioDTO> perfilUsuario(String idUsuario) throws Exception {
		// exemplo de select
		Connection conn = null;
		PreparedStatement psta = null;
		Integer pID = null;
		pID = Integer.parseInt(idUsuario);
		List<UsuarioDTO> listPg = new ArrayList<UsuarioDTO>();

		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select h.id as id_historia, h.data as data_postagem, "
					+ "h.texto as texto_postagem, h.foto as foto_postagem, count(distinct c.usuario) as total_comentarios, "
					+ "count( distinct cur.usuario) as total_curtidas, u.id as id_usuario, u.nome as nome_usuario, u.foto as foto_usuario "
					+ "from Usuario u left join Historia h on h.usuario = u.id left JOIN comentario c "
					+ "on h.id = c.historico left join Curtida cur on h.id = cur.historico where h.usuario = ? "
					+ "GROUP BY u.id, u.nome, u.foto, c.historico, cur.historico, h.id, h.data, h.texto, h.foto ORDER BY h.data DESC;");

			psta.setInt(1, pID);

			ResultSet rs = psta.executeQuery();

			while (rs.next()) {
				UsuarioDTO pg = new UsuarioDTO();
				pg.setId(rs.getLong("id_usuario"));
				pg.setNome(rs.getString("nome_usuario"));
				pg.setFoto(rs.getBytes("foto_usuario"));
				pg.setHistoria(new HistoriaDTO(rs.getLong("id_historia"), rs.getString("texto_postagem"),
						rs.getDate("data_postagem"), rs.getInt("total_comentarios"), rs.getInt("total_curtidas")));

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