package lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import lms.models.CheckedOutBooks;
import lms.models.Fine;

public class FineDao {
	public Connection getConnection() throws SQLException {
		try {
			String url = "jdbc:mysql://localhost:3306/lms";
			String uname = "root";
			String pass = "root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public int addFine(int borrowId, int scholarId) {
		String query = "insert into fine (amount,borrow_id,member_id) values(?,?,?)";
		int fineAmount = getFineAmount(borrowId);
		if (fineAmount > 0) {
			Connection con;
			try {
				con = getConnection();
				PreparedStatement st = con.prepareStatement(query);

				st.setInt(1, fineAmount);
				st.setInt(2, borrowId);
				st.setInt(3, scholarId);

				int result = st.executeUpdate();
				st.close();
				con.close();
				return result;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	public int removeFine(int scholarId) {
		String query = "update fine set is_paid=?,payment_date=? where member_id=?";
		try {

			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(query);
			LocalDate curDate = LocalDate.now();
			st.setInt(1, 1);
			st.setString(2, curDate.toString());
			st.setInt(3, scholarId);

			int result = st.executeUpdate();
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	private int getFineAmount(int borrowId) {
		String query = "select datediff(return_date,due_date) as date_difference from borrow where id=" + borrowId;
		try {
			int date_diff;
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				date_diff = rs.getInt("date_difference");
				if (date_diff > 0) {
					return date_diff * 5;
				} else {
					return 0;
				}
			} else {
				return 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Fine> getFineDetails(int memberId) {

		String Query = " select borrow.id as borrow_id,title,isbn,issue_date,due_date,return_date,amount from fine,borrow,book where fine.borrow_id=borrow.id and borrow.book_isbn=book.isbn and fine.is_paid=0 and fine.member_id="+ memberId;
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Query);
			ArrayList<Fine> fineList = new ArrayList<>();

			while (rs.next()) {
				int borrow_id = rs.getInt("borrow_id");
				String title = rs.getString("title");
				long isbn = rs.getLong("isbn");				
				String issue_date = rs.getString("issue_date");
				String due_date = rs.getString("due_date");
				String return_date = rs.getString("return_date");
				int amount = rs.getInt("amount");
				Fine fine = new Fine(borrow_id, title, isbn, issue_date, due_date,return_date,amount);
				fineList.add(fine);

			}
			return fineList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}

}
