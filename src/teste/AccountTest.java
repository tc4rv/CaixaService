package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import business.Account;
import exception.AccountNotFoundException;
import exception.PasswordWrongException;

public class AccountTest
{	
	@Test (expected = AccountNotFoundException.class)
	public void testAccountNotFound()
	{
		try
		{
			Account acc = Account.newAccount("12", "12", "12");
		}
		catch(AccountNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(PasswordWrongException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test (expected = PasswordWrongException.class)
	public void testPasswordWrong()
	{
		try
		{
			Account acc = Account.newAccount("13", "2016", "12");
		}
		catch(PasswordWrongException e)
		{
			e.printStackTrace();
		}
		catch(AccountNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAccount()
	{
		Account acc = null;
		
		try
		{
			acc = Account.newAccount("13", "2016", "1994");
		}
		catch(AccountNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(PasswordWrongException e)
		{
			e.printStackTrace();
		}
		
		assertEquals("Compara Agency", acc.getAgency(), "13");
		assertEquals("Compara Account", acc.getAccount(), "2016");
		assertEquals("Compara Balance", acc.getBalance(), 100.0d, 0.001d);
	}
}
