package by.htp.service;

import by.htp.bin.Flight;
import by.htp.dao.SelectedFlightDao;
import by.htp.dao.factory.DaoFactory;

public class SelectedFlightServiceImpl implements SelectedFlightService {
	private SelectedFlightDao selectedFlightDao;
	DaoFactory daoFactory = new DaoFactory();

	public SelectedFlightServiceImpl() {
		selectedFlightDao = daoFactory.getSelectedFlightDao();
	}

	@Override
	public Flight flight(int flightId) {
		Flight selectedFlight = selectedFlightDao.flight(flightId);
		return selectedFlight;
	}

}
