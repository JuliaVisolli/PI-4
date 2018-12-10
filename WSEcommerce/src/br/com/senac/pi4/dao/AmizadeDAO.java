package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senac.pi4.exception.AmizadeDaoException;
import br.com.senac.pi4.exception.AmizadeJaSolicitadaException;
import br.com.senac.pi4.exception.AmizadeNaoSolicitadaException;
import br.com.senac.pi4.exception.DaoException;
import br.com.senac.pi4.exception.JaSaoAmigosException;
import br.com.senac.pi4.exception.UsuarioNaoEncontradoException;
import br.com.senac.pi4.model.AmizadeDTO;
import br.com.senac.pi4.services.Database;


public class AmizadeDAO {
	
	public AmizadeDTO solicitaAmizade(AmizadeDTO amizade) throws Exception {

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
		return null;
	}
	
	public void deleteAmizade(Long idUsuario1, Long idUsuario2) throws Exception {
		String sql = "DELETE FROM Amizade WHERE usuario1 = ? usuario2 = ? and aprovada = 1";
		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement(sql);
			
			psta.setLong(1, idUsuario1);
			psta.setLong(2, idUsuario2);
			
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
	
//	public void solicitarAmizade(long idUsuarioAtual, long idUsuarioSolicitado) throws JaSaoAmigosException, AmizadeJaSolicitadaException, DaoException, Exception {
//        
//	       
//        String sql = "INSERT INTO Amizade (usuario1, usuario2, aprovada) VALUES (?,?,?)";
//        
//        AmizadeDTO jaEhAmigo = null;
//        jaEhAmigo = findAmizade(idUsuarioSolicitado, idUsuarioAtual);
//       
//        if(jaEhAmigo != null) {
//        	if(jaEhAmigo.isAprovada()){
//                throw new JaSaoAmigosException();
//            }
//            if(jaEhAmigo.isAprovada() == false){
//                throw new AmizadeJaSolicitadaException();
//            }
//        }
//        
//        try(Connection conn = Database.get().conn(); 
//            PreparedStatement stmt = conn.prepareStatement(sql)){
//        
//        stmt.setLong(1, idUsuarioSolicitado);
//        stmt.setLong(2, idUsuarioAtual);
//        stmt.setBoolean(3, false);            
//        stmt.executeUpdate();
//        
//    }  catch(SQLException ex){
//        throw new DaoException();
//    }
//        
//    }
//
//	
// public void aceitarAmizade(long idUsuarioAtual, long idUsuarioSolicitou) throws JaSaoAmigosException, AmizadeNaoSolicitadaException, DaoException, Exception {
//        String sql = "update Amizade set aprovada = 1 where usuario1 = ? and usuario2 = ?";
//        
//        AmizadeDTO procuraAmizade = findAmizade(idUsuarioSolicitou,idUsuarioAtual);
//        
//        if(procuraAmizade == null){
//            throw new AmizadeNaoSolicitadaException();
//        }
//        if(procuraAmizade.isAprovada()){
//            throw new JaSaoAmigosException();
//        }
//        if(procuraAmizade.getUsuario1() != idUsuarioSolicitou){
//            throw new AmizadeNaoSolicitadaException();
//
//        }
//
//        try(Connection conn = Database.get().conn(); 
//                PreparedStatement stmt = conn.prepareStatement(sql)){
//            
//            stmt.setLong(1, idUsuarioSolicitou);
//            stmt.setLong(2, idUsuarioAtual);
//            stmt.executeUpdate();
//            
//        }  catch(SQLException ex){
//            throw new DaoException();
//        }
//    }
//	
//	public AmizadeDTO findAmizade(long idUsuarioAtual, long idUsuarioProcurado) throws DaoException, Exception {
//		AmizadeDTO encontrado = null;
//        
//        String sql = "select a.usuario1 as user1, a.usuario2 as user2, a.aprovada as aprov from amizade a where usuario1 = ? and usuario2 = ? or usuario1 = ? and usuario2 = ?";
//        
//        try(Connection conn = Database.get().conn();
//        		PreparedStatement stmt = conn.prepareStatement(sql)){
//            
//            stmt.setLong(1, idUsuarioAtual);
//            stmt.setLong(2, idUsuarioProcurado);
//            stmt.setLong(3, idUsuarioProcurado);
//            stmt.setLong(4, idUsuarioAtual);
//
//            try(ResultSet rs = stmt.executeQuery()){
//                if(rs.next()){
//                    Long usuario1 = rs.getLong("user1");
//                    Long usuario2 = rs.getLong("user2");
//                    boolean aprovada = rs.getBoolean("aprov");
//                    encontrado = new AmizadeDTO(usuario1, usuario2, aprovada);
//                }
//            }
//            
//        } catch(SQLException ex){
//            throw new AmizadeDaoException();
//        }
//        
//        return encontrado;
//    }
//	
//	public void recusarAmizade(long idUsuarioAtual, long idUsuarioSolicitou) throws JaSaoAmigosException, AmizadeNaoSolicitadaException, DaoException, Exception {
//        
//	    
//		String sql = "DELETE FROM Amizade WHERE usuario2 = ? and usuario1 = ?";
//                
//                AmizadeDTO procuraAmizade = findAmizade(idUsuarioSolicitou, idUsuarioAtual);
//                
//                if(procuraAmizade == null){
//                    throw new AmizadeNaoSolicitadaException();
//                }
//                if(procuraAmizade.isAprovada()){
//                    throw new JaSaoAmigosException();
//                }
//                
//                if(procuraAmizade.getUsuario1() != idUsuarioSolicitou){
//                    throw new AmizadeNaoSolicitadaException();
//
//                }
//                try(Connection conn = Database.get().conn(); 
//                PreparedStatement stmt = conn.prepareStatement(sql)){
//                	
//                    stmt.setLong(1, idUsuarioAtual);
//                    stmt.setLong(2, idUsuarioSolicitou);
//                    stmt.executeUpdate();
//
//                }  catch(SQLException ex){
//                    throw new DaoException();
//                }
//
//	}
	
}
