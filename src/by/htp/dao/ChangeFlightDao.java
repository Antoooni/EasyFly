package by.htp.dao;

import by.htp.bin.Flight;

public interface ChangeFlightDao {
	//public Flight changeFlightDepartureDate();
	public Flight cancelFlight(Flight flight);
	public void changeFlightData(Flight flight);
}
