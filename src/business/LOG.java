package business;

import java.text.SimpleDateFormat;
import java.util.Date;

import dao.LOGDAO;

public class LOG 
{
	private String agency;
	private String operaction;
	private double value;
	private String account;
	private int client;
	
	public void saveLog()
	{
		Date dt = new Date();
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		
		LOGDAO ldao = new LOGDAO();
		ldao.insert(currentTime, agency, operaction, value,  account, client);
	}
	
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public void setOperaction(String operaction) {
		this.operaction = operaction;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setClient(int client) {
		this.client = client;
	}
}
