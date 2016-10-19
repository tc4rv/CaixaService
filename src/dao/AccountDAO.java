package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import exception.AccountNotFoundException;
import to.AccountTO;
import to.StatementTO;
import util.Arquivo;
import util.ConnectionFactory;

public class AccountDAO
{
	public void updateBalance(AccountTO accTO)
	{
		String sql = "UPDATE Conta SET saldo = ? WHERE idConta = ?";
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql))
		{
			stm.setDouble(1, accTO.getBalance());
			stm.setString(2, accTO.getAccount());
			stm.execute();
		}
		catch(Exception exce)
		{
			exce.printStackTrace();
		}
	}
	
	public ArrayList<StatementTO> getStatement(AccountTO accTO)
	{
		String sql = "SELECT data, operacao, valor FROM log WHERE Conta_idConta = ?";
		ArrayList<StatementTO> statement = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql))
		{
			stm.setString(1, accTO.getAccount());
			try(ResultSet rs = stm.executeQuery())
			{
				while(rs.next())
				{
					StatementTO aux = new StatementTO();
					
					aux.setData(rs.getString(1));
					aux.setOperacao(rs.getString(2));
					aux.setValor(rs.getString(3));
					
					statement.add(aux);
				}
			}
			catch(Exception exce)
			{
				exce.printStackTrace();
			}
		}
		catch (Exception exce)
		{
			exce.printStackTrace();
		}
		
		return statement;
	}
	
	public AccountTO loadAccount(String acc, String ag) throws AccountNotFoundException
	{
		AccountTO accTO = Arquivo.getAcc(ag, acc);
		if(accTO == null) throw new AccountNotFoundException();
		
		String sql = "SELECT saldo FROM Conta WHERE idConta = ?";
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql))
		{
			stm.setString(1, accTO.getAccount());
			try(ResultSet rs = stm.executeQuery())
			{
				rs.next();
				accTO.setBalance(rs.getDouble(1));
			}
			catch(Exception exce)
			{
				exce.printStackTrace();
			}
		}
		catch(Exception exce)
		{
			exce.printStackTrace();
		}
		
		return accTO;
	}
}
