package to;

public class AccountTO
{
	private String agency;
	private String account;
	private String password;
	private String codAccess;
	private double saldo;
	
	private boolean blocked;

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCodAccess() {
		return codAccess;
	}

	public void setCodAccess(String codAccess) {
		this.codAccess = codAccess;
	}

	public double getBalance() {
		return saldo;
	}

	public void setBalance(double saldo) {
		this.saldo = saldo;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
}
