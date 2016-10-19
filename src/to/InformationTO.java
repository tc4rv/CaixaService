package to;

import java.util.Date;
import java.text.SimpleDateFormat;

public class InformationTO
{
	private String mensagem;
	private String hora;
	
	public InformationTO()
	{
		Date dt = new Date();
		SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		
		hora = sdt.format(dt);
	}
	
	public String getMensagem()
	{
		return mensagem;
	}
	
	public void setMensagem(String mensagem)
	{
		this.mensagem = mensagem;
	}
	
	public String getHora()
	{
		return hora;
	}
	
	public void setHora(String hora)
	{
		this.hora = hora;
	}
}
