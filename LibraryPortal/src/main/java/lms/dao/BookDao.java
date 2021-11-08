package lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import lms.models.BookDetails;

public class BookDao {
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
	
	public int addBook(BookDetails bookDetails) {
		String insertBookQuery="insert into book values(?,?,?,?,?,?,?,?,?)";
		Connection con;
		try {
			con = getConnection();
			PreparedStatement st=con.prepareStatement(insertBookQuery);
			st.setLong(1, bookDetails.getIsbn());
			st.setString(2, bookDetails.getTitle());
			st.setInt(3, bookDetails.getCopies_owned());
			st.setInt(4,bookDetails.getEdition());
			st.setString(5,bookDetails.getPublisher_name());
			st.setInt(6, bookDetails.getPrice());
			st.setInt(7, bookDetails.getShelf_no());
			st.setString(8, bookDetails.getAuthor_name());
			st.setString(9,bookDetails.getCategory());
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
	
	public int updateBook(BookDetails bookDetails,long isbn) {
		String updateBookQuery="update book set title=?,copies_owned=?,edition=?,publisher_name=?,price=?,shelf_no=?,author_name=?,category=? where isbn=?";
		Connection con;
		try {
			con = getConnection();
			PreparedStatement st=con.prepareStatement(updateBookQuery);
			
			st.setString(1, bookDetails.getTitle());
			st.setInt(2, bookDetails.getCopies_owned());
			st.setInt(3,bookDetails.getEdition());
			st.setString(4,bookDetails.getPublisher_name());
			st.setInt(5, bookDetails.getPrice());
			st.setInt(6, bookDetails.getShelf_no());
			st.setString(7, bookDetails.getAuthor_name());
			st.setString(8,bookDetails.getCategory());
			st.setLong(9, isbn);
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
	
	public int deleteBook(long isbn) {
		String deleteBookQuery= "delete from book where isbn="+isbn;
		Connection con;
		try {
			con = getConnection();
			Statement st=con.createStatement();
			int result=st.executeUpdate(deleteBookQuery);
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
