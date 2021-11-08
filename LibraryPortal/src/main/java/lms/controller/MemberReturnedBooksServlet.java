package lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.dao.MemberDao;
import lms.models.CheckedOutBooks;

/**
 * Servlet implementation class MemberReturnedBooksServlet
 */
@WebServlet("/MemberReturnedBooks")
public class MemberReturnedBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberReturnedBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int scholarId= (int) request.getSession().getAttribute("userId");
		MemberDao memberDao =new MemberDao();	
		ArrayList<CheckedOutBooks> bookList=memberDao.getReturnedBooks(scholarId);	
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("MemberReturnedBooks.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
