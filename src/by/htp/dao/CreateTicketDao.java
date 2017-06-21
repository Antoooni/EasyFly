package by.htp.dao;

import by.htp.bin.Ticket;
import by.htp.bin.User;

public interface CreateTicketDao {
	public int ticket(Ticket ticket);
	public int ticketList(User user, int ticketId);

}
