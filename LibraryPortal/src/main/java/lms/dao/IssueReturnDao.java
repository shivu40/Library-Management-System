package lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import lms.models.Borrow;

public class IssueReturnDao {
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
	
	public int issueBook(int memberId,long isbn) {
		Borrow borrow= new Borrow();
		LocalDate curDate= LocalDate.now();
		borrow.setDue_date(curDate.plusDays(10).toString());
		borrow.setIssue_date(curDate.toString());
		borrow.setBook_isbn(isbn);
		borrow.setMember_id(memberId);
		String issueBookQuery="insert into borrow (due_date,issue_date,book_isbn,member_id) values(?,?,?,?)";
		String updateCountQuery="update book set copies_owned =copies_owned-1 where isbn="+isbn;
		int result=0;
		Connection con=null;
		try {
			con = getConnection();
			PreparedStatement issueBook=con.prepareStatement(issueBookQuery);
			Statement updateCount=con.createStatement();
			con.setAutoCommit(false);
			issueBook.setString(1, borrow.getDue_date());
			issueBook.setString(2, borrow.getIssue_date());
			issueBook.setLong(3, borrow.getBook_isbn());
			issueBook.setInt(4, borrow.getMember_id());
			
			issueBook.executeUpdate();
			result=updateCount.executeUpdate(updateCountQuery);
		
			con.commit();
			System.out.println("Book occured issued successfully");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
				System.out.println("Error Transaction Rolled Back Successfully");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int returnBook(int borrowId, int scholarId) {
		String updateCountQuery="update book set copies_owned =copies_owned+1 where isbn=?";
		String returnBookQuery="update borrow set return_date=? where id=?";
		String getIsbnQuery="select book_isbn from borrow where id=?";
		Connection con=null;
		int result=0;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			PreparedStatement getIsbn=con.prepareStatement(getIsbnQuery);
			PreparedStatement returnBook=con.prepareStatement(returnBookQuery);
			PreparedStatement updateCount=con.prepareStatement(updateCountQuery);
			getIsbn.setInt(1, borrowId);
			
			ResultSet rs=getIsbn.executeQuery();
			long isbn=0l;
			rs.next();
			isbn=rs.getLong("book_isbn");
				 
			
			LocalDate curDate= LocalDate.now();
			returnBook.setString(1, curDate.toString());
			returnBook.setInt(2, borrowId);
			returnBook.executeUpdate();
			
			updateCount.setLong(1, isbn);
			result=updateCount.executeUpdate();
			
			
			con.commit();
			
			FineDao fd=new FineDao();
			fd.addFine(borrowId, scholarId);
			System.out.println("Book Return successfully");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
				System.out.println("Error occured Transaction Rolled Back Successfully");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return result;
	}
}
