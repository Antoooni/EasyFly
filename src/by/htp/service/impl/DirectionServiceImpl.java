package by.htp.service.impl;

import java.util.List;

import by.htp.bin.FlightDirection;
import by.htp.dao.FlightDirectionDao;
import by.htp.dao.factory.DaoFactory;
import by.htp.service.DirectionService;

public class DirectionServiceImpl implements DirectionService {
	private FlightDirectionDao daoDirection;
	DaoFactory daoFactory = new DaoFactory() ;
	
	public DirectionServiceImpl(){
		daoDirection = daoFactory.getFlightDirectionDao();
	}

	@Override
	public List<FlightDirection> listDirections() {
		List<FlightDirection> directions = daoDirection.flightDirection();
		return directions;
	}

}
