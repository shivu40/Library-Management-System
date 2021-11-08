package lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.dao.MemberDao;
import lms.models.MemberModel;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registerServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password = request.getParameter("password");
		long mobile_no=Long.parseLong(request.getParameter("mobile_no"));
		
		
		
		MemberDao memberDao = new MemberDao();
		MemberModel member = new MemberModel(id, name, email, password, 1, mobile_no);
		int result = memberDao.addMember(member);
		if(result==0) {
			request.setAttribute("regMessage", "Registration Error! Please check data");
		}
		else {
			request.setAttribute("regMessage", "Registration successful Please Login now!");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		System.out.println(result);
	}

}
