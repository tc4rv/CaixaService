package util;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Dispenser 
{
	private int bills10;
	private int bills20;
	private int bills50;

	public Dispenser() 
	{
		carregarNotas();
	}

	public void alterarNotas(int[] qtd) 
	{
		bills50 -= qtd[0];
		bills20 -= qtd[1];
		bills10 -= qtd[2];
	}

	// O m�todo abaixo realiza a leitura das notas dispon�veis no dispenser e as
	// traz para a mem�ria
	public void carregarNotas()
	{
		File dis = new File("dispenser.txt");

		try (Scanner leitura = new Scanner(dis);) 
		{
			bills10 = Integer.parseInt(leitura.nextLine().substring(8));
			bills20 = Integer.parseInt(leitura.nextLine().substring(8));
			bills50 = Integer.parseInt(leitura.nextLine().substring(8));
		} 
		catch (FileNotFoundException erro) 
		{
			javax.swing.JOptionPane.showMessageDialog(null, "Arquivo \"dispenser.txt\" n�o encontrado!");
		}
	}

	public void salvarNotas()
	{
		String bills = "notas10:" + bills10 + System.getProperty("line.separator") + 
					   "notas20:" + bills20 + System.getProperty("line.separator") + 
					   "notas50:" + bills50;

		File dis = new File("dispenser.txt");
		try 
		{
			FileWriter escrever = new FileWriter(dis);
			escrever.write(bills);
			escrever.close();
		} 
		catch (IOException erro)
		{
			erro.printStackTrace();
		}
	}
}
