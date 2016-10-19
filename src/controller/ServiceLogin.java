package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Account;
import exception.AccountNotFoundException;
import exception.PasswordWrongException;
import to.AccountTO;
import util.JsonFacade;

/**
 * Servlet implementation class ServiceLogin
 */
@WebServlet("/api/v1/login")
public class ServiceLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceLogin() {
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
		StringBuilder accJSON = JsonFacade.toJson(request);
		AccountTO accTO = JsonFacade.jsonToAccountTO(accJSON.toString());
		String s = "";
		PrintWriter out = response.getWriter();
		try {
			Account.newAccount(accTO);
			s = "{ name: " + Account.currentAccount().getClient().getName() + " }";
		} catch (AccountNotFoundException | PasswordWrongException e) {
			s = JsonFacade.errorToJSon(e);
		}
		
		out.println(s);
	}

}
