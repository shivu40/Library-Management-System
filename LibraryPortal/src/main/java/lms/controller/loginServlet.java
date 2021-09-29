package lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.dao.LoginDao;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		String type=request.getParameter("type");
		LoginDao loginDao=new LoginDao();
		if(type.equals("member")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String pass=request.getParameter("pass");
			boolean result=loginDao.isMemberValid(id, pass);
			if(result==true) {
				response.getWriter().println("valid member");
			}
			else {
				response.getWriter().println("invalid member");
			}
		}
		else if(type.equals("staff")) {
			String uname=request.getParameter("uname");
			String pass=request.getParameter("pass");
					boolean result=loginDao.isStaffValid(uname, pass);
			if(result==true) {
				response.getWriter().println("valid staff");
			}
			else {
				response.getWriter().println("invalid staff");
			}
		}
	}

}
