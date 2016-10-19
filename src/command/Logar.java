package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Account;

public class Logar implements Command
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String agency = request.getParameter("agency");
		String acc = request.getParameter("account");
		String pass = request.getParameter("pass");
		Account account = null;
		RequestDispatcher view = null;
		
		try
		{
			account = Account.newAccount(agency, acc, pass);
		}
		catch(Exception e)
		{
			view = request.getRequestDispatcher("contaNaoEncontrada.html");
		}
		
		if(account != null)
		{
			view = request.getRequestDispatcher("menu.jsp");
		}
		
		view.forward(request, response);
	}

}
