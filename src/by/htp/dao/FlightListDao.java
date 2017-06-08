package by.htp.dao;

import java.util.List;

import by.htp.bin.Flight;

public interface FlightListDao {
	List<Flight> flightList(String fromSQL, String toSQL, String departureDateSQL, String arrivalDateSQL);

}
