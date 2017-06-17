package by.htp.bin;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 5699222310780018128L;
	private String userName;
	private String userSurname;
	private String userEmail;
	private int ticketId;
	private LogonData logonData;

	public User() {

	}

	public User(String userName, String userSurname, String userEmail, int ticketId) {
		super();
		this.userName = userName;
		this.userSurname = userSurname;
		this.userEmail = userEmail;
		this.ticketId = ticketId;
	}

	public User(String userName, String userSurname, String userEmail, int ticketId, LogonData logonData) {
		super();
		this.userName = userName;
		this.userSurname = userSurname;
		this.userEmail = userEmail;
		this.ticketId = ticketId;
		this.logonData = logonData;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public LogonData getLogonData() {
		return logonData;
	}

	public void setLogonData(LogonData logonData) {
		this.logonData = logonData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logonData == null) ? 0 : logonData.hashCode());
		result = prime * result + ticketId;
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userSurname == null) ? 0 : userSurname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (logonData == null) {
			if (other.logonData != null)
				return false;
		} else if (!logonData.equals(other.logonData))
			return false;
		if (ticketId != other.ticketId)
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userSurname == null) {
			if (other.userSurname != null)
				return false;
		} else if (!userSurname.equals(other.userSurname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userSurname=" + userSurname + ", userEmail=" + userEmail
				+ ", ticketId=" + ticketId + ", logonData=" + logonData + "]";
	}

}
