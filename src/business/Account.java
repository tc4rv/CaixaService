package business;

import java.util.ArrayList;

import dao.AccountDAO;
import exception.AccountNotFoundException;
import exception.DispenserEmptyException;
import exception.InsufficientFundsException;
import exception.PasswordWrongException;
import to.AccountTO;
import to.StatementTO;

public class Account 
{
	private String agency;
	private String account;
	private String password;
	private String codAccess;
	private double balance;
	
	private boolean blocked;
	private Client client;
	
	private static Account acc;
	
	private Account(String ag, String acco, String pass, String codAcc, boolean block)
	{
		agency = ag;
		account = acco;
		password = pass;
		codAccess = codAcc;
		blocked = block;
		
		AccountTO accTO = new AccountTO();
		accTO.setAccount(acco);
		
		client = new Client(accTO);
	}

	public void updateBalance(double value) throws InsufficientFundsException
	{
		if(value > 0)
			balance += value;
		else if(balance + value >= 0)
			balance += value;
		else
			throw new InsufficientFundsException();
		
		AccountTO accTO = new AccountTO();
		accTO.setAccount(account);
		accTO.setBalance(balance);
		
		AccountDAO accDAO = new AccountDAO();
		accDAO.updateBalance(accTO);
		
		LOG log = new LOG();
		log.setAccount(account);
		log.setAgency(agency);
		log.setClient(client.getId());
		log.setOperaction("0");
		log.setValue(value);
		log.saveLog();
	}
	
	public void withdraw(double value) throws InsufficientFundsException, DispenserEmptyException
	{
		Withdraw wd = new Withdraw();
		wd.withdraw(value, this);
	}
	
	public ArrayList<StatementTO> getBankStatement()
	{
		AccountDAO accDAO = new AccountDAO();
		AccountTO accTO = new AccountTO();
		
		accTO.setAccount(account);
		
		LOG log = new LOG();
		log.setAccount(account);
		log.setAgency(agency);
		log.setClient(client.getId());
		log.setOperaction("1");
		log.setValue(0);
		log.saveLog();
		
		return accDAO.getStatement(accTO);
	}
	
	public Client getClient()
	{
		return client;
	}
	
	public static Account currentAccount()
	{
		return acc;
	}
	
	public static Account newAccount(String ag, String acco, String pass) throws AccountNotFoundException,
																				 PasswordWrongException
	{
		AccountDAO accDAO = new AccountDAO();
		AccountTO accTO = accDAO.loadAccount(acco, ag);
		if(accTO == null) throw new AccountNotFoundException();
		if(!pass.equals(accTO.getPassword())) throw new PasswordWrongException();
		
		acc = new Account(accTO.getAgency(),
						  accTO.getAccount(), 
						  accTO.getPassword(), 
						  accTO.getCodAccess(), 
						  accTO.isBlocked());
		acc.setBalance(accTO.getBalance());
		return acc;
	}
	
	public static Account newAccount(AccountTO accTO)  throws AccountNotFoundException,
															  PasswordWrongException
	{
		return Account.newAccount(accTO.getAgency(),
								  accTO.getAccount(),
								  accTO.getPassword());
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void setBalance(double bala)
	{
		balance = bala;
	}
	
	public String getAccount()
	{
		return account;
	}
	
	public String getAgency()
	{
		return agency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((agency == null) ? 0 : agency.hashCode());
		result = prime * result + (blocked ? 1231 : 1237);
		result = prime * result + ((codAccess == null) ? 0 : codAccess.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (agency == null) {
			if (other.agency != null)
				return false;
		} else if (!agency.equals(other.agency))
			return false;
		if (blocked != other.blocked)
			return false;
		if (codAccess == null) {
			if (other.codAccess != null)
				return false;
		} else if (!codAccess.equals(other.codAccess))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
}
