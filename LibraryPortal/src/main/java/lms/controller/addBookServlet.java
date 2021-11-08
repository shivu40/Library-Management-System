package lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.dao.BookDao;
import lms.models.BookDetails;

/**
 * Servlet implementation class addBookServlet
 */
@WebServlet("/addBook")
public class addBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long isbn =Long.parseLong(request.getParameter("isbn"));
		String title=request.getParameter("title");
		int copies_owned=Integer.parseInt(request.getParameter("copies_owned"));
		int edition=Integer.parseInt(request.getParameter("edition"));
		String publisher_name=request.getParameter("publisher_name");
		int price=Integer.parseInt(request.getParameter("price"));
		int shelf_no=Integer.parseInt(request.getParameter("shelf_no"));
		String author_name=request.getParameter("author_name");
		String category=request.getParameter("category");
		
//		BookDetails bookDetails=new BookDetails(9789332549449l,"C Programming by Dennis Ritchie",3,2,"Pearson",416,3,"Dennis Ritchie","Programming");
		BookDetails bookDetails=new BookDetails(isbn,title,copies_owned,edition,publisher_name,price,shelf_no,author_name,category);
		BookDao bookDao=new BookDao();
		int result=bookDao.addBook(bookDetails);
		if(result>0) {
			request.setAttribute("addBookMessage", "Book added Sucessfully!");			
		}
		else {
			request.setAttribute("addBookMessage", "Error!");
		}
		System.out.println(result);
		request.getRequestDispatcher("addBook.jsp").forward(request, response);
			
	}

}
