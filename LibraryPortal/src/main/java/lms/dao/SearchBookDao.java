package lms.dao;
import java.sql.*;
import java.util.ArrayList;

import lms.models.BookDetails;
import lms.models.BookModel;
public class SearchBookDao {
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
	
	
	
	public ArrayList<BookModel> searchByParam(String param) {
		String searchQuery="select * from book where title like '%"+param+"%'" + "or author_name like '%"+param+"%'"+"or category like '%"+param+"%'";
		try {
			Connection con= getConnection();
//			PreparedStatement stmt=con.prepareStatement(searchQuery);  
//			stmt.setString(1, param);
//			stmt.setString(2, param);
//			stmt.setString(3, param);
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(searchQuery);
			ArrayList<BookModel> bookList=new ArrayList<>();
			
			
			while(rs.next()) {
				String title=rs.getString("title");		
				int edition=rs.getInt("edition");
				int shelfNo=rs.getInt("shelf_no");
				String authorName=rs.getString("author_name");				
				String category=rs.getString("category");
				int copies_owned=rs.getInt("copies_owned");
				String status;
				if(copies_owned>0)
					 status="Available";
				else
					 status="Not Available";
				BookModel book=new BookModel(title,edition,shelfNo,authorName,category,status);
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
	
	public ArrayList<BookDetails> getBookDetails(String param) {
		String searchQuery="select * from book where title like '%"+param+"%'" + "or author_name like '%"+param+"%'"+"or category like '%"+param+"%'";
		try {
			Connection con= getConnection();
//			PreparedStatement stmt=con.prepareStatement(searchQuery);  
//			stmt.setString(1, param);
//			stmt.setString(2, param);
//			stmt.setString(3, param);
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(searchQuery);
			ArrayList<BookDetails> bookList=new ArrayList<>();
			
			
			while(rs.next()) {
				long isbn=rs.getLong("isbn");
				String title=rs.getString("title");	
				int copies_owned=rs.getInt("copies_owned");
				int edition=rs.getInt("edition");
				String publisher_name=rs.getString("publisher_name");
				int price=rs.getInt("price");
				int shelf_no=rs.getInt("shelf_no");
				String author_name=rs.getString("author_name");				
				String category=rs.getString("category");
				
				
				BookDetails book=new BookDetails(isbn,title,copies_owned,edition,publisher_name,price,shelf_no,author_name,category);
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
	
	public BookDetails searchByIsbn(long bookId) {
		String searchQuery="select * from book where isbn="+bookId;
		try {
			Connection con= getConnection();
//			PreparedStatement stmt=con.prepareStatement(searchQuery);  
//			stmt.setString(1, param);
//			stmt.setString(2, param);
//			stmt.setString(3, param);
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(searchQuery);
			
			
			BookDetails book=null;
			while(rs.next()) {
				long isbn=rs.getLong("isbn");
				String title=rs.getString("title");	
				int copies_owned=rs.getInt("copies_owned");
				int edition=rs.getInt("edition");
				String publisher_name=rs.getString("publisher_name");
				int price=rs.getInt("price");
				int shelf_no=rs.getInt("shelf_no");
				String author_name=rs.getString("author_name");				
				String category=rs.getString("category");
				
				
				book=new BookDetails(isbn,title,copies_owned,edition,publisher_name,price,shelf_no,author_name,category);
						
				
			}
			return book;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
	
	
}
