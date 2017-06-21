package by.htp.service;

import by.htp.bin.Ticket;
import by.htp.bin.User;

public interface CreateTicketService {
	public int ticket(Ticket ticket);
	public int ticketList(User user, int ticketId);

}
