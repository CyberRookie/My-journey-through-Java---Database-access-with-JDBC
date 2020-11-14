package com.generic.user.login.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import net.javaguides.usermanagement.model.JSPFormBean;
import com.generic.user.login.model.LoginBean;
import com.generic.user.login.dao.LoginDAO;

/**
 * @email Ramesh Fadatare
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDao;

	public void init() {
		loginDao = new LoginDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	loginDao.selectAllUsers();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
	//	JSPFormBean jspFormBean = new JSPFormBean();
	//	jspFormBean.setUserName(userName);
	//	jspFormBean.setPassword(password);

	//
		try {
			
			if (loginDao.validate(loginBean)) {
	            //HttpSession session = request.getSession();
	            // session.setAttribute("username",username);
	            response.sendRedirect("loginSuccess.jsp");
	        } else {
	            HttpSession session = request.getSession();
	            //session.setAttribute("user", username);
	            response.sendRedirect("login.jsp");
	        }
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	}
}
