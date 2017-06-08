package by.htp.dao;

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

import by.htp.bin.FlightDirection;
import by.htp.util.SQLConnectionPool;

public class FlightDirectionDaoImpl implements FlightDirectionDao {

	@Override
	public List<FlightDirection> flightDirection() {
		 ResourceBundle bundle = ResourceBundle.getBundle("config");
		 String dbUrl=bundle.getString("db.url");
		 String dbUser =bundle.getString("db.login");
		 String dbPass=bundle.getString("db.pass");
		 System.out.println(dbUrl+" "+" "+dbUser+" "+ dbPass);
		 String dbName =bundle.getString("db.driver.name");
		//
		List<FlightDirection> flightDirection = new ArrayList<FlightDirection>();
		Connection connection = null;
		String cityDirection = null;

		try {
			try {
				 Class.forName(dbName);
				 connection =DriverManager.getConnection(dbUrl, dbUser, dbPass);
				//SQLConnectionPool sqlConnection = new SQLConnectionPool();
				//connection = sqlConnection.getConnection();
				if (!connection.isClosed()) {
					PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_ALL_DIRECTIONS);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						cityDirection = rs.getString(1);

						flightDirection.add(new FlightDirection(cityDirection) {

							private static final long serialVersionUID = -1930855792331760955L;
						});
						System.out.println("City: " + cityDirection);

					}
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flightDirection;
	}

}
