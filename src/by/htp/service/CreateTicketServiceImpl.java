package by.htp.service;

import by.htp.bin.Ticket;
import by.htp.bin.TicketList;
import by.htp.bin.User;
import by.htp.dao.CreateTicketDao;
import by.htp.dao.factory.DaoFactory;

public class CreateTicketServiceImpl implements CreateTicketService {
	private CreateTicketDao createTicketDao;
//	DaoFactory daoFactory = new DaoFactory();
	
	public CreateTicketServiceImpl(){
		createTicketDao=DaoFactory.getInstance().getCreateTicketDao();
	}

	@Override
	public int ticket(Ticket ticket) {
		return createTicketDao.ticket(ticket);
	}

	@Override
	public int createTicketList(User user, int ticketId) {
		// TODO Auto-generated method stub
		return createTicketDao.createTicketList(user, ticketId);
	}

	@Override
	public void updateUser(int userId, TicketList ticketList) {
		createTicketDao.updateUser(userId, ticketList);
		
	}

	@Override
	public boolean ticketListExists(User user) {
		// TODO Auto-generated method stub
		return createTicketDao.ticketListExists(user);
	}

	@Override
	public int searchTicketList(User user) {
		// TODO Auto-generated method stub
		return createTicketDao.searchTicketList(user);
	}

}
