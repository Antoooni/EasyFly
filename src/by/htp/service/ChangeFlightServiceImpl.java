package by.htp.service;

import by.htp.bin.Flight;
import by.htp.dao.ChangeFlightDao;
import by.htp.dao.factory.DaoFactory;

public class ChangeFlightServiceImpl implements ChangeFlightService {
	private ChangeFlightDao cancelFlight;
	
	public ChangeFlightServiceImpl(){
		cancelFlight= DaoFactory.getInstance().getChangeFlightDao();
	}

	@Override
	public Flight cancelFlight(Flight flight) {
		// TODO Auto-generated method stub
		return cancelFlight.cancelFlight(flight);
	}

	@Override
	public void chancheFlightData(Flight flight) {
		cancelFlight.changeFlightData(flight);
		
	}


	

}
