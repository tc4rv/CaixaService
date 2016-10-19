package business;

import exception.DispenserEmptyException;
import exception.InsufficientFundsException;

public class Withdraw 
{
	public void withdraw(double value, Account acc) throws DispenserEmptyException, InsufficientFundsException
	{
		//Verificar o dispenser
		if(value > 0) value = -value;
		acc.updateBalance(value);
	}
}
