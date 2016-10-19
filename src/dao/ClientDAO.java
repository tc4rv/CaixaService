package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import to.AccountTO;
import to.ClientTO;
import util.ConnectionFactory;

public class ClientDAO 
{
	public ClientTO loadClient(AccountTO accTO)
	{
		String sql = "SELECT Cliente.idCliente, Cliente.nome, Cliente.telefone FROM Cliente RIGHT JOIN Conta ON Conta.idConta = ? AND Cliente.idCliente = Conta.Cliente_idCliente;";
		ClientTO cltTO = null;
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql))
		{
			stm.setString(1, accTO.getAccount());
			try(ResultSet rs = stm.executeQuery())
			{
				rs.next();
				cltTO = new ClientTO();
				cltTO.setId(rs.getInt(1));
				cltTO.setName(rs.getString(2));
				cltTO.setAddress(null);
				cltTO.setPhone(rs.getString(3));
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
		
		return cltTO;
	}
}
