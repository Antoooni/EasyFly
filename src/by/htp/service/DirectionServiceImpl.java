package by.htp.service;

import java.util.List;

import by.htp.bin.FlightDirection;
import by.htp.dao.FlightDirectionDao;
import by.htp.dao.factory.DaoFactory;

public class DirectionServiceImpl implements DirectionService {
	private FlightDirectionDao daoDirection;
//	DaoFactory daoFactory = new DaoFactory() ;
	
	public DirectionServiceImpl(){
		daoDirection = DaoFactory.getInstance().getFlightDirectionDao();
	}

	@Override
	public List<FlightDirection> listDirections() {
		List<FlightDirection> directions = daoDirection.flightDirection();
		return directions;
	}

}
