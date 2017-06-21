package by.htp.dao;

import static by.htp.util.ConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import by.htp.bin.User;
import by.htp.dao.UserAuthorizationDao;
import by.htp.util.SQLConnectionPool;

public class UserAuthorizationDaoImpl implements UserAuthorizationDao {

	@Override
	public User getUserData(String login, String password) {
		User user = new User();
		Connection connection = null;

		// ResourceBundle bundle = ResourceBundle.getBundle("config");
		// String dbUrl = bundle.getString("db.url");
		// String dbUser = bundle.getString("db.login");
		// String dbPass = bundle.getString("db.pass");
		// System.out.println(dbUrl + " " + " " + dbUser + " " + dbPass);
		// String dbName = bundle.getString("db.driver.name");

		try {
			try {
				// Class.forName(dbName);
				// connection = DriverManager.getConnection(dbUrl, dbUser,
				// dbPass);
				SQLConnectionPool sqlConnection = new SQLConnectionPool();
				connection = sqlConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_USER_NAME);
				ps.setString(1, login); // код для PreparedStatement
				ps.setString(2, password); // код для PreparedStatement
				ResultSet rs = ps.executeQuery(); // код для PreparedStatement
				if (rs.next()) {
					user.setUserName(rs.getString(1));
					user.setUserSurname(rs.getString(2));
					user.setRole(rs.getString(3));
					System.out.println("User name from database: " + user.getUserName()+" "+user.getUserSurname()+" "+ user.getRole());

				}
			} catch (NamingException e) {
				e.printStackTrace();
			} finally {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

}
