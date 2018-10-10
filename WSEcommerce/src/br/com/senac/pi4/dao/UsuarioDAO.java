package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.senac.pi4.model.UsuarioDTO;
import br.com.senac.pi4.services.Database;

public class UsuarioDAO {
	
	public UsuarioDTO saveUsuario(UsuarioDTO usuario) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			
			String email = null;
			final Iterator<UsuarioDTO> usuarioIterator = selectAllUsuario().iterator();
			
			while(usuarioIterator.hasNext()) {
				UsuarioDTO usuarioDTOs = usuarioIterator.next();
				email = usuarioDTOs.getEmail();
				if(usuario.getEmail().equalsIgnoreCase(email)) {
					System.out.println("E-mail já existe. Cadastre outro e-mail");
					return null;
				}else if (usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty()) {
					System.out.println("E-mail e senha são obrigatórios.");
					return null;
				}
			}
			
			conn = Database.get().conn();
			psta = conn.prepareStatement("INSERT INTO Usuario"
					+  "(nome, senha, email,foto) VALUES"
					+  "(?,?,?,?)");
			
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
		
		while(usuarioIterator.hasNext()) {
			UsuarioDTO usuarioDTOs = usuarioIterator.next();
			email = usuarioDTOs.getEmail();
			senha = usuarioDTOs.getSenha();
			
			if(usuarioDTO.getEmail().equalsIgnoreCase(email) && usuarioDTO.getSenha().equalsIgnoreCase(senha)) {
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
	
	public UsuarioDTO buscaAmigo() {
		
		return null;
	}
}