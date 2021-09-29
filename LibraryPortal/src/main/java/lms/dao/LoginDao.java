package lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
	public Connection getConnection() throws SQLException {
		try {
			String url="jdbc:mysql://localhost:3306/lms";
			String uname="root";
			String pass="root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pass);
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public boolean isMemberValid(int id, String pass) {
		String query="select password from member where id="+id;
		try {
			
			Connection con=getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				if(pass.equals(rs.getString("password"))) {
					return true;
				}
			}
			else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isStaffValid(String uname, String pass) {
		String query="select password from staff_details where username=?";
try {
			
			Connection con=getConnection();
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, uname);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				if(pass.equals(rs.getString("password"))) {
					return true;
				}
			}
			else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
