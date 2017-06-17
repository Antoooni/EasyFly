package by.htp.util;

public class ConstantValue {
	ConstantValue() {
	}

	public static final String VALUE_OF_A_REQUEST_PARAMETER = "action";

	public static final String ACTION_AUTHORISE = "login";
	public static final String ACTION_LOGOUT = "logout";
	public static final String ACTION_GO_HOME = "go_home";
	public static final String ACTION_SEARCH = "go_search";
	public static final String ACTION_REGISTRATION = "registration";
	public static final String ACTION_CREATE_USER = "create_user";

	public static final String REQUEST_PARAM_LOGIN = "login";
	public static final String REQUEST_PARAM_PASSWORD = "pass";
	public static final String REQUEST_PARAM_USER_NAME = "user_name";
	public static final String REQUEST_PARAM_LIST_DIRECTION = "list_directions";
	public static final String REQUEST_PARAM_FLIGHTS_LIST = "list_flights";
	public static final String REQUEST_PARAM_EXIST_USER = "user_exist";
	public static final String REQUEST_PARAM_EXIST_EMAIL = "email_exist";
	public static final String REQUEST_PARAM_CREATED_SUCCESSFULLY ="success";

	public static final String REQUEST_PARAM_USER_LOGIN = "create_login";
	public static final String REQUEST_PARAM_USER_USER_EMAIL = "create_email";
	public static final String REQUEST_PARAM_USER_PASSWORD = "create_password";
	public static final String REQUEST_PARAM_USER_CONFIRM_PASSWORD = "create_password1";
	public static final String REQUEST_PARAM_USER_FIRST_NAME = "name[first]";
	public static final String REQUEST_PARAM_USER_SURNAME = "name[last]";

	// request parameters from main search
	public static final String REQUEST_PARAM_DIRECTION_FROM = "direction_from";
	public static final String REQUEST_PARAM_DIRECTION_TO = "direction_to";
	public static final String REQUEST_PARAM_DEPARTURE_DATE = "departure_date";
	public static final String REQUEST_PARAM_ARRIVAL_DATE = "arrival_date";

	public static final String REQUEST_PARAM_ERROR_MSG = "errog_msg";
	public static final String PAGE_NO_FLIGHTS_ERROR = "/WEB-INF/error_no_flights.jsp";

	public static final String PAGE_DEFAULT = "/default.jsp";
	public static final String PAGE_AUTHORIZED = "/WEB-INF/authorised.jsp";
	public static final String PAGE_ERROR = "/WEB-INF/error.jsp";
	public static final String PAGE_HOME = "/WEB-INF/index.jsp";
	public static final String PAGE_FLIGHT_LIST = "/WEB-INF/flight_list.jsp";
	public static final String PAGE_REGISTRATION = "/WEB-INF/registration.jsp";
	public static final String PAGE_REGISTRATION_SUCCESS = "/WEB-INF/registration_ok.jsp";

	public static final String SQL_STATEMENT_DIRECTION_CODE = "select distinct direction.direction_code from direction where direction.direction_city = ?;";
	public static final String SQL_STATEMENT_USER_NAME = "select user_name from user join logon_data on user.user_id = logon_data.user_id where logon_data.login=? and logon_data.password=?;";
	public static final String SQL_STATEMENT_ALL_DIRECTIONS = "select distinct   direction.direction_city from direction;";
	public static final String SQL_STATEMENT_SEARCH_FLIGHT = "select   n1.direction_code, n1.direction_city, t2.departure_date, t2.departure_time, n2.direction_code, n2.direction_city, t2.arrival_date, t2.arrival_time, t2.flight_id from flight as t2 join direction as n1 on n1.direction_id = t2.departure_id join direction as n2 on n2.direction_id = t2.arrival_id where  n1.direction_code=? and n2.direction_code=? and t2.departure_date=? and t2.arrival_date=?; ";
	public static final String SQL_STATEMENT_CREATE_USER_LOGON_DATA = "INSERT INTO logon_data (login, password) VALUES (?, ?);";
	public static final String SQL_STATEMENT_CREATE_USER_DATA="INSERT INTO user (user_id, user_name, user_surname, user_email, ticket_list_id) select  user_id , ?, ?, ?, null from logon_data where login = ?";
	public static final String SQL_STATEMENT_IF_USER_LOGIN_EXIST = "select count(*) from logon_data where login=?;";
	public static final String SQL_STATEMENT_IF_USER_EMAIL_EXIST="select count(*) from user where user_email=?;";
}
