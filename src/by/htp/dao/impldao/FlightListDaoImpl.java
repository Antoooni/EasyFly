package by.htp.dao.impldao;

import static by.htp.util.ConstantValue.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.NamingException;

import by.htp.bin.Direction;
import by.htp.bin.Flight;
import by.htp.dao.FlightListDao;
import by.htp.util.SQLConnectionPool;

public class FlightListDaoImpl implements FlightListDao {
	Connection connection;

	@Override
	public List<Flight> flightList(String fromSQL, String toSQL, String departureDateSQL, String arrivalDateSQL) {
		 ResourceBundle bundle = ResourceBundle.getBundle("config");
		 String dbUrl=bundle.getString("db.url");
		 String dbUser =bundle.getString("db.login");
		 String dbPass=bundle.getString("db.pass");
		 System.out.println(dbUrl+" "+" "+dbUser+" "+ dbPass);
		 String dbName =bundle.getString("db.driver.name");

		List<Flight> flightList = new ArrayList<Flight>();
		try {
			try {
				 Class.forName(dbName);
				 connection=DriverManager.getConnection(dbUrl, dbUser, dbPass);
//				SQLConnectionPool sqlConnection = new SQLConnectionPool();
				//connection = sqlConnection.getConnection();
				if (!connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_SEARCH_FLIGHT);
//					 fromSQL ="MSQ";
//					 toSQL ="DME";
//					 departureDateSQL= "2017-06-19";
//					 arrivalDateSQL= "2017-06-20";
					
					ps.setString(1, fromSQL);
					ps.setString(2, toSQL);
					ps.setString(3, departureDateSQL);
					ps.setString(4, arrivalDateSQL);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) { // цикл для всех записей из БД
						Direction fromDirection = new Direction();
						Direction fromDirectionCode = new Direction();
						Direction toDirection = new Direction();

						// String fromDirectionString = rs.getString(1);
						// Direction d = new Direction();
						// d.setDirectionCode(fromDirectionString);
						fromDirection.setDirectionCode(rs.getString(1));
						fromDirection.setCity(rs.getString(2));

						String departureDate = rs.getString(3);
						String departureTime = rs.getString(4);

						toDirection.setDirectionCode(rs.getString(5));
						toDirection.setCity(rs.getString(6));

						String arrivalDate = rs.getString(7);
						String arrivalTime = rs.getString(8);
						int flightId = rs.getInt(9);
						// int id = Integer.valueOf(rs.getString(1));
						// String brand = rs.getString(2);
						// double price =Double.valueOf(rs.getString(3));
						// Category category=
						// Category.valueOf(rs.getString(5).toUpperCase());
						flightList.add(new Flight(fromDirectionCode, fromDirection, departureDate, departureTime, toDirection, arrivalDate, arrivalTime, flightId) );
//						System.out.println("Flight #: " + " From " + fromDirection.getDirectionCode() + ", "
//								+ fromDirection.getCity() + " Departure " + departureDate + " at " + departureTime
//								+ "-    TO " + toDirection.getDirectionCode() + ", " + toDirection.getCity()
//								+ " Arriaval " + arrivalDate + " at " + arrivalTime);

					}
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightList;
	}

}
