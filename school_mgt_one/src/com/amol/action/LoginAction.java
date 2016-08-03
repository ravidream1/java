package com.amol.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAction
 */


/*
 * <servlet>
<servlet-name>loginAction</servlet-name> <!-- any name -->
<servlet-class>com.amol.action.LoginAction</servlet-class> <!-- class name -->
</servlet>

<servlet-mapping>
<servlet-name>loginAction</servlet-name> <!-- any name -->
<url-pattern>LoginAction</url-pattern><!--  method name -->
</servlet-mapping>


In place of above configuration on web.xml we can just write @WebServlet("/LoginAction")
*
*/



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	

	}

}
