package lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lms.models.MemberModel;



public class MemberDao {
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

	public int addMember(MemberModel member) {
		String insertMemberQuery="insert into member values(?,?,?,?,?,?)";
		Connection con;
		try {
			con = getConnection();
			PreparedStatement st=con.prepareStatement(insertMemberQuery);
			
			st.setInt(1,member.getId());			
			st.setString(2,member.getName());			
			st.setString(3, member.getEmail());
			st.setString(4,member.getPassword());
			st.setInt(5, member.getActive_status());
			st.setLong(6, member.getMobile_no());
			int result=st.executeUpdate();
			st.close();
			con.close();
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
