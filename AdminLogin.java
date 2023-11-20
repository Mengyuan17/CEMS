package com.example.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.utils.DaoFactory;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		request.setCharacterEncoding("utf-8");
		// 获取用户名和密码
		String username = request.getParameter("ad_id");
		String password = request.getParameter("ad_username");
		if (username.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
     	 	session.setAttribute("login", password);
			response.sendRedirect("admin/manage_teacher.jsp");
		} else
			response.sendRedirect("index.jsp");
		/*if (!username.equals("") && !password.equals("")) {
			
			String login = DaoFactory.getTeacherDaoInstance().login(username, password);
			System.out.println(login);
			if (login.equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("login", login);
				response.sendRedirect("admin/admin_main.jsp");
			} else
				response.sendRedirect("index.jsp");
		} else
			response.sendRedirect("index.jsp");
			*/
	}

}
