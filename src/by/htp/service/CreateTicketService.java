package by.htp.service;

import by.htp.bin.Ticket;
import by.htp.bin.TicketList;
import by.htp.bin.User;

public interface CreateTicketService {
	public int ticket(Ticket ticket);
	public int createTicketList(User user, int ticketId);
	public void updateUser(int userId, TicketList ticketList);
	public boolean ticketListExists(User user);
	public int searchTicketList(User user);

}
