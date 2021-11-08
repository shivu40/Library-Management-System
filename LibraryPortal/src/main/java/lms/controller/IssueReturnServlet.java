package lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.dao.IssueReturnDao;
import lms.dao.MemberDao;
import lms.models.CheckedOutBooks;
import lms.models.MemberModel;

/**
 * Servlet implementation class IssueReturnServlet
 */
@WebServlet("/IssueReturn")
public class IssueReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("type");
		int scholarId=Integer.parseInt(request.getParameter("scholarId"));
		if(type.equals("search")) {
			listBook(scholarId,request,response);
		}
		else if(type.equals("issue")) {
			if(getIssueCount(scholarId)==3) {
				request.setAttribute("issueMessage", "More than 3 books can not be issued.");
				listBook(scholarId,request,response);
			}else {
				long isbn=Long.parseLong(request.getParameter("isbn"));
				IssueReturnDao ird=new IssueReturnDao();
				int result=ird.issueBook(scholarId, isbn);
				if(result>0) {
					System.out.println(result);
					request.setAttribute("issueMessage", "Book Issued successfully");
				}else {
					System.out.println(result);
					request.setAttribute("issueMessage", "Some error occured");
				}
				listBook(scholarId,request,response);
			}
			
		}
		else if(type.equals("return")) {
			int borrow_id=Integer.parseInt(request.getParameter("borrow_id"));
			IssueReturnDao ird=new IssueReturnDao();
			int result=ird.returnBook(borrow_id,scholarId);
			if(result>0) {
				System.out.println(result);
				request.setAttribute("returnMessage", "Book returned successfully");
			}
			else {
				System.out.println(result);
				request.setAttribute("returnMessage", "Some error occured");
			}
			listBook(scholarId,request,response);
		}
	}
	
	private static void listBook(int scholarId,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao =new MemberDao();
		MemberModel member=memberDao.getMemberDetails(scholarId);
		request.setAttribute("member", member);
		ArrayList<CheckedOutBooks> bookList=memberDao.getCheckedOutBooks(scholarId);	
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("issueReturn.jsp").forward(request, response);
	}
	
	private static int getIssueCount(int scholarId) {
		MemberDao memberDao =new MemberDao();
		ArrayList<CheckedOutBooks> bookList=memberDao.getCheckedOutBooks(scholarId);
		return bookList.size();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
