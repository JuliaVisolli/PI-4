import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.senac.pi4.services.Database;


public class Main {

	public static void main(String[] args) {
	
			
			
			Connection conn = null;
			PreparedStatement psta = null;
			
			Integer pID = null;
			pID = 1;				
			try {
				conn = Database.get().conn();		
				psta = conn.prepareStatement("select COUNT(*) as total from Comentario where historico = ?");
				psta.setInt(1, pID);
				
				
				//
				ResultSet rs = psta.executeQuery();
				
				while (rs.next()) {
					System.out.println(rs.getInt("total"));
					
				}
			}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

	}

}
