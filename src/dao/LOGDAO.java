package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.ConnectionFactory;

public class LOGDAO 
{
	public void insert(String data, String agencia, String ope, double valor, String conta, int cliente)
	{  
		String sql = "INSERT INTO log (data, agencia, operacao, valor, Conta_idConta, Conta_Cliente_idCliente) values (?, ?, ?, ?, ?, ?)";
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql))
		{
			stm.setString(1, data);
			stm.setString(2, agencia);
			stm.setString(3, ope);
			stm.setDouble(4, valor);
			stm.setString(5, conta);
			stm.setInt(6, cliente);
			stm.execute();
		}
		catch(Exception exce)
		{
			exce.printStackTrace();
		}
	}
}
