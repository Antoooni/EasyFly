package by.htp.util;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;
 
public class SQLConnectionPool {
	
	private InitialContext initContext;
	private DataSource ds;
	
	public Connection getConnection() throws SQLException, NamingException	{
		
		initContext= new InitialContext();
		ds = (DataSource) initContext.lookup("java:comp/env/jdbc/EasyFlyWebProject");
//		Connection conn = ds.getConnection();
		return ds.getConnection();
	}
 
}
