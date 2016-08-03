package com.amol.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amol.bean.Login;
import com.amol.dao.impl.LoginDaoImpl;
import com.amol.service.LoginService;
import com.amol.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginAction
 */


@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//LoginService loginService = null;

    /**
     * Default constructor. 
     */
    public LoginAction() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("test");
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		
		
		LoginDaoImpl ldi = new LoginDaoImpl();
		boolean check = ldi.login(login);
		//loginService = new LoginServiceImpl();
		//boolean check = loginService.login(login);
		
		if(check){
			
			request.getSession().setAttribute("username", username);

			response.sendRedirect("home.jsp");

			System.out.println("Login successfull.");
		}
		
		
     }

}
