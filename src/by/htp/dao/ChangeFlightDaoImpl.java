package by.htp.dao;

import static by.htp.util.ConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.mysql.jdbc.Statement;

import by.htp.bin.Flight;
import by.htp.util.SQLConnectionPool;

public class ChangeFlightDaoImpl implements ChangeFlightDao {
	Connection connection;

	@Override
	public Flight cancelFlight(Flight flight) {
//		Flight chanchedFlight = new Flight();
		PreparedStatement ps;
		try {
			try {
				SQLConnectionPool sqlConnection = new SQLConnectionPool();
				connection = sqlConnection.getConnection();
				if (!connection.isClosed()) {
					ps = connection.prepareStatement(SQL_STATEMENT_CANCEL_FLIGHT);
					ps.setInt(1, flight.getFlightId());
					ps.executeUpdate();
				}

			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void changeFlightData(Flight flight) {
		PreparedStatement ps;
		try {
			try {
				SQLConnectionPool sqlConnection = new SQLConnectionPool();
				connection = sqlConnection.getConnection();
				if (!connection.isClosed()) {
					ps = connection.prepareStatement(SQL_STATEMENT_CHANGE_FLIGHT_DATA);
					ps.setString(1, flight.getDepartureDate());
					ps.setString(2, flight.getDepartureTime());
					ps.setString(3, flight.getArrivalDate());
					ps.setString(4, flight.getArrivalTime());
					ps.setInt(5, flight.getFlightId());
					ps.executeUpdate();
				}

			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
