package by.htp.dao;

import by.htp.bin.Ticket;
import by.htp.bin.TicketList;
import by.htp.bin.User;

public interface CreateTicketDao {
	public int ticket(Ticket ticket);
	public int searchTicketList(User user);
	public boolean ticketListExists(User user);
	public int createTicketList(User user, int ticketId);
	public void updateUser(int userId, TicketList ticketList);

}
