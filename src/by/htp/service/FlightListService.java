package by.htp.service;

import java.util.List;

import by.htp.bin.Flight;
import by.htp.service.exception.ServiceNoSuchFlightsException;

public interface FlightListService   {
	List <Flight> flightList(String fromSQL, String toSQL, String departureDateSQL, String arrivalDateSQL) throws ServiceNoSuchFlightsException;

}
