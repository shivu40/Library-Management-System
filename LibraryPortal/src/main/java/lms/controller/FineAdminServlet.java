package lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.dao.FineDao;
import lms.dao.MemberDao;
import lms.models.CheckedOutBooks;
import lms.models.Fine;
import lms.models.MemberModel;

/**
 * Servlet implementation class FineAdminServlet
 */
@WebServlet("/FineAdmin")
public class FineAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FineAdminServlet() {
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
			listFine(scholarId,request,response);
		}
		else if(type.equals("removeFine")){
			FineDao fineDao=new FineDao();
			int result=fineDao.removeFine(scholarId);
			if(result>0) {
				request.setAttribute("fineMessage", "fine removal successfull");				
			}
			else {
				request.setAttribute("fineMessage", "error in removing the fine");	
			}
			listFine(scholarId,request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private static void listFine(int scholarId,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao =new MemberDao();
		MemberModel member=memberDao.getMemberDetails(scholarId);
		request.setAttribute("member", member);
		FineDao fineDao=new FineDao();
		ArrayList<Fine> fineList=fineDao.getFineDetails(scholarId);	
		request.setAttribute("bookList", fineList);
		request.getRequestDispatcher("FineAdminView.jsp").forward(request, response);
	}
}
