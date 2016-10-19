package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import to.AccountTO;

public class Arquivo 
{
	private static List<String[]> accs;
	
	private static void loadDatas()
	{
		accs = new ArrayList<String[]>();
		
		String path = Arquivo.class.getClassLoader().getResource("").getPath();
		String fullPath = "";
		try {
			fullPath = URLDecoder.decode(path, "UTF-8");
			String pathArr[] = fullPath.split("/WEB-INF/classes/");
			fullPath = pathArr[0];
		} catch (Exception e) {
			e.printStackTrace();
		}
		File arquivo = new File(fullPath + "//acesso.txt");
		
		try(Scanner scan = new Scanner(arquivo);)
		{
			while(scan.hasNext())
			{
				String line = scan.nextLine();
				String[] acc = line.split(":");
				accs.add(acc);
			}
			
			accs.sort(new Comparator<String[]>() 
			{
				@Override
				public int compare(String[] o1, String[] o2)
				{
					if(o1[0].equals(o2[0]))
						return o1[1].compareTo(o2[1]);
					return o1[0].compareTo(o2[0]);
				}
			});
		}
		catch(FileNotFoundException e){ e.printStackTrace(); }
		catch(NoSuchElementException e)	{System.err.println("Arquivo no formato errado.");}
		catch(IllegalStateException e) {System.err.println("Erro ao ler do arquivo.");}
	}
	
	public static AccountTO getAcc(String ag, String acc)
	{
		if(accs == null) loadDatas();
		ListIterator<String[]> iAccs = accs.listIterator();
		while(iAccs.hasNext())
		{
			String[] account = iAccs.next();
			if(account[0].equals(ag))
			{
				if(account[1].equals(acc))
				{
					AccountTO accTO = new AccountTO();
					accTO.setAgency(account[0]);
					accTO.setAccount(account[1]);
					accTO.setPassword(account[2]);
					accTO.setCodAccess(account[3]);
					accTO.setBlocked(account[4].equals("T"));
					
					return accTO;
				}
			}
		}
		
		return null;
	}
}