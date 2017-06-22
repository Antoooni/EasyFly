package by.htp.dao;

import static by.htp.util.ConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.mysql.jdbc.Statement;

import by.htp.bin.Ticket;
import by.htp.bin.TicketList;
import by.htp.bin.User;
import by.htp.util.SQLConnectionPool;

public class CreateTicketDaoImpl implements CreateTicketDao {
	Connection connection;

	@Override
	public int ticket(Ticket ticket) {
		PreparedStatement ps;
		int key = 0;
		try {
			try {
				SQLConnectionPool sqlConnection = new SQLConnectionPool();
				connection = sqlConnection.getConnection();
				if (!connection.isClosed()) {
					ps = connection.prepareStatement(SQL_STATEMENT_CREATE_TICKET, Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, ticket.getFlightId());
					ps.setInt(2, ticket.getPassengerId());
					ps.setString(3, convertAnswerToString(ticket.isPrimaryBoarding()));
					ps.setString(4, convertAnswerToString(ticket.isOnlineCheckIn()));
					ps.setDouble(5, ticket.getTotalAmount());
					ps.executeUpdate();

					ResultSet rs = ps.getGeneratedKeys();
					if (rs.next()) {
						// Retrieve the auto generated key(s).
						key = rs.getInt(1);
						System.out.println("id in sql " + key);
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

	@Override
	public int createTicketList(User user, int ticketId) {
		PreparedStatement ps;
		int key = 0;
		try {
			try {
				SQLConnectionPool sqlConnection = new SQLConnectionPool();
				connection = sqlConnection.getConnection();
				if (!connection.isClosed()) {
					ps = connection.prepareStatement(SQL_STATEMENT_CREATE_TICKET_LIST, Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, ticketId);
					ps.setInt(2, user.getUserId());
					ps.executeUpdate();

					ResultSet rs = ps.getGeneratedKeys();
					if (rs.next()) {
						// Retrieve the auto generated key(s).
						key = rs.getInt(1);
						System.out.println("id in sql " + key);
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

	@Override
	public void updateUser(int userId, TicketList ticketList) {
		PreparedStatement ps;
		try {
			try {
				SQLConnectionPool sqlConnection = new SQLConnectionPool();
				connection = sqlConnection.getConnection();
				if (!connection.isClosed()) {
					ps = connection.prepareStatement(SQL_STATEMENT_CREATE_TICKET_UPDATE_USER,
							Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, ticketList.getTicketListId());
					ps.setInt(2, userId);
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

	@Override
	public boolean ticketListExists(User user) {
		PreparedStatement ps;
		int flightListNumber = 0;
		try {
			try {
				SQLConnectionPool sqlConnection = new SQLConnectionPool();
				connection = sqlConnection.getConnection();
				if (!connection.isClosed()) {
					ps = connection.prepareStatement(SQL_STATEMENT_CREATE_TICKET_IF_TICKETLIST_EXISTS);
					ps.setInt(1, user.getUserId());
					ps.executeUpdate();
					ResultSet rs = ps.executeQuery();
					flightListNumber =rs.getInt(rs.getString(1));
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
		if (flightListNumber==0)
			return false;
		else
			return true;
	}


	@Override
	public int searchTicketList(User user) {
		PreparedStatement ps;
		int ticketListId = 0;
		try {
			try {
				SQLConnectionPool sqlConnection = new SQLConnectionPool();
				connection = sqlConnection.getConnection();
				if (!connection.isClosed()) {
					ps = connection.prepareStatement(SQL_STATEMENT_CREATE_TICKET_SEARCH_TICKET_LIST);
					ps.setInt(1, user.getUserId());
					ps.executeUpdate();
					ResultSet rs = ps.executeQuery();
					ticketListId =rs.getInt(rs.getInt(1));
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
		return ticketListId;
	}
	
	private String convertAnswerToString(boolean expresion) {
		if (expresion)
			return "Yes";
		else
			return "No";
	}
}
