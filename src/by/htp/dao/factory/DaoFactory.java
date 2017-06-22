package by.htp.dao.factory;

import by.htp.dao.CreatePassengerDao;
import by.htp.dao.CreatePassengerDaoImpl;
import by.htp.dao.CreateTicketDao;
import by.htp.dao.CreateTicketDaoImpl;
import by.htp.dao.DirectionCodeDao;
import by.htp.dao.DirectionCodeDaoImpl;
import by.htp.dao.FlightDirectionDao;
import by.htp.dao.FlightDirectionDaoImpl;
import by.htp.dao.FlightListDao;
import by.htp.dao.FlightListDaoImpl;
import by.htp.dao.SelectedFlightDao;
import by.htp.dao.SelectedFlightDaoImpl;
import by.htp.dao.UserAuthorizationDao;
import by.htp.dao.UserAuthorizationDaoImpl;
import by.htp.dao.UserCreateDao;
import by.htp.dao.UserCreateDaoImpl;

public class DaoFactory {

	public DaoFactory() {

	}

	private static class DaoFactoryHolder {
		private final static DaoFactory instance = new DaoFactory();
	}

	public static DaoFactory getInstance() {
		return DaoFactoryHolder.instance;
	}

	public UserAuthorizationDao getUserAuthorizationDao() {
		return new UserAuthorizationDaoImpl();
	}
	public FlightDirectionDao getFlightDirectionDao(){
		return new FlightDirectionDaoImpl();
	}
	public FlightListDao getFlightListDao(){
		return new FlightListDaoImpl();
	}
	
	public DirectionCodeDao getDirectionCodeDao(){
		return new DirectionCodeDaoImpl();
	}
	public UserCreateDao getUserCreateDao(){
		return new UserCreateDaoImpl();
	}
	public SelectedFlightDao getSelectedFlightDao(){
		return new SelectedFlightDaoImpl();
	}
	public CreatePassengerDao getCreatePassengerDao(){
		return new CreatePassengerDaoImpl();
	}
	public CreateTicketDao getCreateTicketDao(){
		return new CreateTicketDaoImpl();
	}
}
