package fttec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Fttec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("oi");
		
		String dburl = "jdbc:mysql//localhost//ftt";
		
		String user = "scott";
		String pwd = "tiger";
		
		try {
			
			Connection connection = DriverManager.getConnection(dburl, user, pwd);
			
			String query = "selecy count(1) qtd from ftt.people;";
			
			Statement st = connection.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			rs.next();
			
			System.out.println("QTD: " + rs.getString("QTD"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
