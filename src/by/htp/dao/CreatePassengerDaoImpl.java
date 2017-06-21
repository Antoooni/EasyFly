package by.htp.dao;

import static by.htp.util.ConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.mysql.jdbc.Statement;

import by.htp.bin.Passenger;
import by.htp.bin.Ticket;
import by.htp.util.SQLConnectionPool;

public class CreatePassengerDaoImpl implements CreatePassengerDao {
	Connection connection;

	@Override
	public int passenger (Passenger passenger) {
		PreparedStatement ps;
		int key = 0;
		try {
			try {
				SQLConnectionPool sqlConnection = new SQLConnectionPool();
				connection = sqlConnection.getConnection();
				if (!connection.isClosed()) {
					ps = connection.prepareStatement(SQL_STATEMENT_CREATE_PASSANGER, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, passenger.getName());
					ps.setString(2, passenger.getSurname());
					ps.setString(3, passenger.getMiddleName());
					ps.setString(4, passenger.getDateOfBirth());
					ps.setInt(5, passenger.getAge());
					ps.setString(6, passenger.getSex());
					ps.setString(7, passenger.getPassportId());
					ps.setDate(8, passenger.getPassportExpirty());
					ps.setString(9, passenger.getBaggage().toString());
					ps.executeUpdate();
					
					ResultSet rs = ps.getGeneratedKeys();
					if ( rs.next() ) {
					    // Retrieve the auto generated key(s).
					    key = rs.getInt(1);
					    System.out.println("id in sql "+ key);
					}
					
					// ps.executeUpdate();
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
		
		return key;
	}

}
