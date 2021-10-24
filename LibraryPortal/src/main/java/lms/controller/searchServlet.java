package lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.dao.IssueReturnDao;
import lms.dao.SearchBookDao;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/search")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String parameter=request.getParameter("searchParameter");
//		SearchBookDao bookDao=new SearchBookDao();
//		
//		System.out.println(bookDao.searchByIsbn(Long.parseLong(parameter)));
		
		//Testing issue book functionality
//		IssueReturnDao ird=new IssueReturnDao();
//		ird.issueBook(202120008, 9780712676090l);
		
		//Testing return book functionality
		IssueReturnDao ird=new IssueReturnDao();
		ird.returnBook(1);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
