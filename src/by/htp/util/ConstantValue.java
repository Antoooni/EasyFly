package by.htp.util;

public class ConstantValue {
	ConstantValue() {
	}

	public static final String VALUE_OF_A_REQUEST_PARAMETER = "action";

	public static final String ACTION_AUTHORISE = "login";
	public static final String ACTION_LOGOUT = "logout";
	public static final String ACTION_GO_HOME = "go_home";
	public static final String ACTION_SEARCH= "go_search";

	public static final String REQUEST_PARAM_LOGIN = "login";
	public static final String REQUEST_PARAM_PASSWORD = "pass";
	public static final String REQUEST_PARAM_USER_NAME = "user_name";
	public static final String REQUEST_PARAM_LIST_DIRECTION = "list_directions";
	public static final String REQUEST_PARAM_FLIGHTS_LIST = "list_flights";
	
	//request parameters from main search
	public static final String REQUEST_PARAM_DIRECTION_FROM ="direction_from";
	public static final String REQUEST_PARAM_DIRECTION_TO ="direction_to";
	public static final String REQUEST_PARAM_DEPARTURE_DATE ="departure_date";
	public static final String REQUEST_PARAM_ARRIVAL_DATE ="arrival_date";
	
	

	public static final String REQUEST_PARAM_ERROR_MSG = "errog_msg";
	public static final String PAGE_NO_FLIGHTS_ERROR = "/error_no_flights.jsp";

	public static final String PAGE_DEFAULT = "/default.jsp";
	public static final String PAGE_AUTHORIZED = "/authorised.jsp";
	public static final String PAGE_ERROR = "/error.jsp";
	public static final String PAGE_HOME = "/index.jsp";
	public static final String PAGE_FLIGHT_LIST="/flight_list.jsp";

	public static final String SQL_STATEMENT_DIRECTION_CODE = "select distinct direction.direction_code from direction where direction.direction_city = ?;";
	public static final String SQL_STATEMENT_USER_NAME = "select user_name from user join logon_data on user.user_id = logon_data.user_id where logon_data.login=? and logon_data.password=?;";
	public static final String SQL_STATEMENT_ALL_DIRECTIONS = "select distinct   direction.direction_city from direction;";
	//public static final String SQL_STATEMENT_SEARCH_FLIGHT = "select   n1.direction_code, n1.direction_city, t2.departure_date, t2.departure_time, n2.direction_code, n2.direction_city, t2.arrival_date, t2.arrival_time from flight as t2 join direction as n1 on n1.direction_id = t2.departure_id join direction as n2 on n2.direction_id = t2.arrival_id where n1.direction_code='MSQ' and n2.direction_code = 'DME' and t2.departure_date='2017-06-19' and t2.arrival_date='2017-06-19';";
	public static final String SQL_STATEMENT_SEARCH_FLIGHT = "select   n1.direction_code, n1.direction_city, t2.departure_date, t2.departure_time, n2.direction_code, n2.direction_city, t2.arrival_date, t2.arrival_time from flight as t2 join direction as n1 on n1.direction_id = t2.departure_id join direction as n2 on n2.direction_id = t2.arrival_id where  n1.direction_code=? and n2.direction_code=? and t2.departure_date=? and t2.arrival_date=?; ";
}
