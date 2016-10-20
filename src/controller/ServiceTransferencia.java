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
import exception.InsufficientFundsException;
import to.AccountTO;
import util.JsonFacade;

/**
 * Servlet implementation class ServiceTransferencia
 */
@WebServlet("/api/v1/transferencia")
public class ServiceTransferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceTransferencia() {
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
		StringBuilder json = JsonFacade.toJson(request);
		AccountTO accTO = JsonFacade.jsonToAccountTO(json.toString());
		double value = JsonFacade.getOfJson(json.toString(), "value");
		String s = "";
		PrintWriter out = response.getWriter();
		try {
			Account.currentAccount().transfer(accTO, value);
			s = "{ value: " + Account.currentAccount().getBalance() + " }";
		} catch (AccountNotFoundException | InsufficientFundsException e) {
			s = JsonFacade.errorToJSon(e);
		}
		
		out.println(s);
	}

}
