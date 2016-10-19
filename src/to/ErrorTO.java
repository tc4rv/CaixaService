package to;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorTO 
{
	private String data;
	private String title;
	private String description;
	
	public ErrorTO(String title, String description)
	{
		Date dt = new Date();
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		data = sdf.format(dt);
		
		this.description = description;
		this.title = title;
	}
	
	public String getData()
	{
		return data;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String toString()
	{
		return title + "\n" + "Data: " + data + "Descrição: " + description;
	}
}
