package lms.dao;

import java.sql.*;
import java.util.ArrayList;

import lms.models.BookModel;
import lms.models.CheckedOutBooks;
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
	
	public int deleteMember(int id) {
		String deleteMemberQuery= "delete from member where id="+id;
		Connection con;
		try {
			con = getConnection();
			Statement st=con.createStatement();
			int result=st.executeUpdate(deleteMemberQuery);
			st.close();
			con.close();
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public MemberModel getMemberDetails(int id) {
		String getMemberQuery="select * from member where id="+id;
		Connection con;
		try {
			con = getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(getMemberQuery);
			rs.next();
			
			MemberModel member=new MemberModel(id,rs.getString("name"),rs.getString("email"),null,rs.getInt("active_status"),rs.getLong("mobile_no"));
			
			st.close();
			con.close();
			return member;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<CheckedOutBooks> getCheckedOutBooks(int memberId){
		
		String Query="select * from borrow inner join book on borrow.book_isbn=book.isbn where borrow.return_date Is NULL and  member_id="+memberId;
		try {
			Connection con= getConnection();	
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(Query);
			ArrayList<CheckedOutBooks> bookList=new ArrayList<>();
			
			
			while(rs.next()) {
				int borrow_id=rs.getInt("id");
				String title=rs.getString("title");		
				long isbn=rs.getLong("isbn");				
				String authorName=rs.getString("author_name");				
				String issue_date=rs.getString("issue_date");
				String due_date=rs.getString("due_date");
			
				CheckedOutBooks book=new CheckedOutBooks(borrow_id,title,isbn,authorName,issue_date,due_date);
				bookList.add(book);				
				
			}
			return bookList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<CheckedOutBooks> getReturnedBooks(int memberId){
		
		String Query="select * from borrow inner join book on borrow.book_isbn=book.isbn where borrow.return_date Is NOT NULL and  member_id="+memberId;
		try {
			Connection con= getConnection();	
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(Query);
			ArrayList<CheckedOutBooks> bookList=new ArrayList<>();
			
			
			while(rs.next()) {
				int borrow_id=rs.getInt("id");
				String title=rs.getString("title");		
				long isbn=rs.getLong("isbn");				
				String authorName=rs.getString("author_name");				
				String issue_date=rs.getString("issue_date");
				String due_date=rs.getString("due_date");
				String return_date=rs.getString("return_date");
				CheckedOutBooks book=new CheckedOutBooks(borrow_id,title,isbn,authorName,issue_date,due_date);
				book.setReturn_date(return_date);
				bookList.add(book);				
				
			}
			return bookList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
}
