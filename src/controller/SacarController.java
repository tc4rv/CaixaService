package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Account;
import to.InformationTO;

/**
 * Servlet implementation class SacarController
 */
@WebServlet("/SacarController.do")
public class SacarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SacarController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String value = request.getParameter("valor");
		Double sacar = 0.0;
		RequestDispatcher view = null;
		InformationTO info = null;
		
		if(value == "")
			sacar = Double.parseDouble(request.getParameter("escolha"));
		else
			sacar = Double.parseDouble(value);
		
		try
		{
			Account.currentAccount().withdraw(sacar);
		}
		catch(Exception e)
		{
			info = new InformationTO();
			info.setMensagem("Saldo insuficiente.");
		}
		
		if(info == null)
		{
			info = new InformationTO();
			info.setMensagem("Saque realizado com sucesso!");
		}
		
		request.setAttribute("Info", info);
		
		view = request.getRequestDispatcher("menu.jsp");
		view.forward(request, response);
	}

}
