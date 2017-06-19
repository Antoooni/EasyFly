package by.htp.dao;

import static by.htp.util.ConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import by.htp.bin.Direction;
import by.htp.bin.Flight;
import by.htp.bin.Plane;
import by.htp.util.SQLConnectionPool;

public class SelectedFlightDaoImpl implements SelectedFlightDao {
	

	@Override
	public Flight flight(int flightId) {
		Flight selectedFlight = null;
		Connection connection = null;


		try {
			try {
				SQLConnectionPool sqlConnection = new SQLConnectionPool();
				connection = sqlConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_SEARCH_SELECTED_FLIGHT);
				ps.setInt(1, flightId);
				ResultSet rs = ps.executeQuery(); // код для PreparedStatement
				
				Direction fromDirection = new Direction();
				Direction toDirection = new Direction();
				Plane plane = new Plane();
				
				if (rs.next()) {
					selectedFlight= new Flight();
					
					fromDirection.setDirectionCode(rs.getString(1));
					fromDirection.setDirectionName(rs.getString(2));
					selectedFlight.setFromDirection(fromDirection);
					
					selectedFlight.setDepartureDate(rs.getString(3));
					selectedFlight.setDepartureTime(rs.getString(4));
					
					toDirection.setDirectionCode(rs.getString(5));
					toDirection.setDirectionName(rs.getString(6));
					selectedFlight.setToDirection(toDirection);
					
					selectedFlight.setArrivalDate(rs.getString(7));
					selectedFlight.setArrivalTime(rs.getString(8));
					
					selectedFlight.setFlightId( rs.getInt(9));
					
					plane.setPlaneName(rs.getString(10));
					selectedFlight.setPlane(plane);



				}
			} catch (NamingException e) {
				e.printStackTrace();
			} finally {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectedFlight;
	}

}
