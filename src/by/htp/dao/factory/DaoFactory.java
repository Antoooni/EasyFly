package by.htp.dao.factory;

import by.htp.dao.DirectionCodeDao;
import by.htp.dao.DirectionCodeDaoImpl;
import by.htp.dao.FlightDirectionDao;
import by.htp.dao.FlightDirectionDaoImpl;
import by.htp.dao.FlightListDao;
import by.htp.dao.FlightListDaoImpl;
import by.htp.dao.UserAuthorizationDao;
import by.htp.dao.UserAuthorizationDaoImpl;

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
}
