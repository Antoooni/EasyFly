package by.htp.service;

import by.htp.bin.Ticket;
import by.htp.bin.User;
import by.htp.dao.CreateTicketDao;
import by.htp.dao.factory.DaoFactory;

public class CreateTicketServiceImpl implements CreateTicketService {
	private CreateTicketDao createTicketDao;
	DaoFactory daoFactory = new DaoFactory();
	
	public CreateTicketServiceImpl(){
		createTicketDao=daoFactory.getCreateTicketDao();
	}

	@Override
	public int ticket(Ticket ticket) {
		// TODO Auto-generated method stub
		return createTicketDao.ticket(ticket);
	}

	@Override
	public int ticketList(User user, int ticketId) {
		// TODO Auto-generated method stub
		return createTicketDao.ticketList(user, ticketId);
	}

}
