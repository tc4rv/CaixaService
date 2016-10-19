package business;

import dao.ClientDAO;
import to.AccountTO;
import to.ClientTO;

public class Client 
{
	private String name;
	private String address;
	private String phone;
	
	private int id;
	
	public Client(AccountTO accTO)
	{
		ClientDAO cltDAO = new ClientDAO();
		ClientTO cltTO = cltDAO.loadClient(accTO);
		
		name = cltTO.getName();
		address = cltTO.getAddress();
		phone = cltTO.getPhone();
		id = cltTO.getId();
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}
	
	public int getId(){
		return id;
	}
}
