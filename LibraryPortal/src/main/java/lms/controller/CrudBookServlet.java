package lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.dao.BookDao;
import lms.dao.SearchBookDao;
import lms.models.BookDetails;

/**
 * Servlet implementation class CrudBookServlet
 */
@WebServlet("/CrudBook")
public class CrudBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrudBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		if (type.equals("search")) {
			String parameter = request.getParameter("searchParameter");
			SearchBookDao bookDao = new SearchBookDao();
			ArrayList<BookDetails> searchBookResult = bookDao.searchByParam(parameter);
			request.setAttribute("BookResult", searchBookResult);
			request.getRequestDispatcher("allBooks.jsp").forward(request, response);
		}
		if (type.equals("all")) {

			SearchBookDao bookDao = new SearchBookDao();
			ArrayList<BookDetails> searchBookResult = bookDao.getAllBooks();
			request.setAttribute("BookResult", searchBookResult);
			request.getRequestDispatcher("allBooks.jsp").forward(request, response);
		}
		if (type.equals("delete")) {		
			long isbn = Long.parseLong(request.getParameter("isbn"));
			BookDao bd=new BookDao();
			int result=bd.deleteBook(isbn);
			if(result>0) {
				request.setAttribute("deleteBookMessage", "Book Deleted Successfully");
			}else {
				request.setAttribute("deleteBookMessage", "Error in deleting book");
			}
			SearchBookDao bookDao = new SearchBookDao();
			ArrayList<BookDetails> searchBookResult = bookDao.getAllBooks();
			request.setAttribute("BookResult", searchBookResult);
			request.getRequestDispatcher("allBooks.jsp").forward(request, response);
		}
		if(type.equals("updateRequest")) {
			long isbn = Long.parseLong(request.getParameter("isbn"));
			SearchBookDao bookDao = new SearchBookDao();
			BookDetails toBeUpdated=bookDao.searchByIsbn(isbn);
			request.setAttribute("toBeUpdated", toBeUpdated);
			request.getRequestDispatcher("updateBook.jsp").forward(request, response);
		}
		if(type.equals("update")) {
			
			long isbn =Long.parseLong(request.getParameter("isbn"));
			String title=request.getParameter("title");
			int copies_owned=Integer.parseInt(request.getParameter("copies_owned"));
			int edition=Integer.parseInt(request.getParameter("edition"));
			String publisher_name=request.getParameter("publisher_name");
			int price=Integer.parseInt(request.getParameter("price"));
			int shelf_no=Integer.parseInt(request.getParameter("shelf_no"));
			String author_name=request.getParameter("author_name");
			String category=request.getParameter("category");
			BookDetails bookDetails=new BookDetails(isbn,title,copies_owned,edition,publisher_name,price,shelf_no,author_name,category);
			BookDao bookDao=new BookDao();
			int result=bookDao.updateBook(bookDetails,isbn);
			if(result>0) {
				request.setAttribute("updateBookMessage", "Book Updated Sucessfully!");			
			}
			else {
				request.setAttribute("updateBookMessage", "Error!");
			}
			System.out.println(result);
			SearchBookDao searchbookDao = new SearchBookDao();
		
			ArrayList<BookDetails> searchBookResult = searchbookDao.getAllBooks();
			request.setAttribute("BookResult", searchBookResult);
			request.getRequestDispatcher("allBooks.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
