package com.upen.mvc.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import com.mysql.cj.jdbc.PreparedStatement;

@Service
public class LoginService {

	public boolean validateUser (String uname, String pass) {
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); // for Importing driver
			
			String sql = "select * from users where uname=? and pass =?";
			String username = "SCOTT";
			String password = "TIGER";
			String url = "jdbc:mysql://localhost:3306/scott?autoReconnect=true&useSSL=false";
			
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);			
			ResultSet rs = st.executeQuery();
			
			if (rs.next())
				return true;
			
		}
		catch (Exception ex){
			System.out.println(ex);
		}
		
		return false;
		
	}
}

