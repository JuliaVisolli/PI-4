import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.senac.pi4.model.ComentarioDTO;
import br.com.senac.pi4.services.Database;


public class Main {

	public static void main(String[] args) {
	
			
			
			Connection conn = null;
			PreparedStatement psta = null;
			ComentarioDTO pg = null;
			Integer pID = null;
			pID = 1;				
			try {
				conn = Database.get().conn();		
				psta = conn.prepareStatement("select distinct c.historico, c.texto, c.data from Comentario c INNER JOIN Historia h on c.historico = h.id where c.historico = ? order by c.data ASC");
				psta.setInt(1, pID);
				
				
				//
				ResultSet rs = psta.executeQuery();
				
				while (rs.next()) {
					pg = new ComentarioDTO();
//					pg.setHistoria(new HistoriaDTO(rs.getLong("historico"), rs.getString("texto"), rs.getDate("data")));
					pg.setTexto(rs.getString("texto"));
					pg.setData(rs.getDate("data"));
					System.out.println(pg.getHistoria().getId());
					System.out.println(pg.getHistoria().getTexto());
					System.out.println(pg.getHistoria().getData());
					
				}
			}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

	}

}
