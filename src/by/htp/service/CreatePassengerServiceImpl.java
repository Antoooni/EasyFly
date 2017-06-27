package by.htp.service;

import by.htp.bin.Passenger;
import by.htp.dao.CreatePassengerDao;
import by.htp.dao.factory.DaoFactory;

public class CreatePassengerServiceImpl implements CreatePassengerService {
	private CreatePassengerDao buyTicketDao;
//	DaoFactory daoFactory = new DaoFactory();
	
	public CreatePassengerServiceImpl(){
		buyTicketDao= DaoFactory.getInstance().getCreatePassengerDao();
	}

	@Override
	public int passenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return buyTicketDao.passenger(passenger);
	}

}
