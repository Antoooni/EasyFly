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
	public static final String ACTION_FLIGHT_INFO = "buy";
	public static final String ACTION_BUY_TICKET = "buy_ticket";

	public static final String REQUEST_PARAM_LOGIN = "login";
	public static final String REQUEST_PARAM_PASSWORD = "pass";
	public static final String REQUEST_PARAM_USER = "user_data";
	public static final String REQUEST_PARAM_LIST_DIRECTION = "list_directions";
	public static final String REQUEST_PARAM_FLIGHTS_LIST = "list_flights";
	public static final String REQUEST_PARAM_FLIGHT_INFO = "flight";
	public static final String REQUEST_PARAM_EXIST_USER = "user_exist";
	public static final String REQUEST_PARAM_EXIST_EMAIL = "email_exist";
	public static final String REQUEST_PARAM_CREATED_SUCCESSFULLY ="success";

	public static final String REQUEST_PARAM_USER_LOGIN = "create_login";
	public static final String REQUEST_PARAM_USER_USER_EMAIL = "create_email";
	public static final String REQUEST_PARAM_USER_PASSWORD = "create_password";
	public static final String REQUEST_PARAM_USER_CONFIRM_PASSWORD = "create_password1";
	public static final String REQUEST_PARAM_USER_FIRST_NAME = "name[first]";
	public static final String REQUEST_PARAM_USER_SURNAME = "name[last]";
	
	public static final String REQUEST_PARAM_PASSENGER_NAME = "passenger_name";
	public static final String REQUEST_PARAM_PASSENGER_SURNAME = "passenger_surname";
	public static final String REQUEST_PARAM_PASSENGER_MIDNAME = "passenger_midname";
	public static final String REQUEST_PARAM_PASSENGER_AGE = "passenger_age";
	public static final String REQUEST_PARAM_PASSENGER_BIRTH = "passenger_birth";
	public static final String REQUEST_PARAM_PASSENGER_SEX = "passenger_sex";
	public static final String REQUEST_PARAM_PASSENGER_PASSPORT_NUMBER = "passenger_passport_number";
	public static final String REQUEST_PARAM_PASSENGER_PASSPORT_EXPIRTY = "passenger_passport_expirty";
	public static final String REQUEST_PARAM_PASSENGER_BAGGAGE = "passenger_baggage";
	public static final String REQUEST_PARAM_TICKET_PRIMARY_BOARDING ="passenger_boarding";
	public static final String REQUEST_PARAM_TICKET_CHECKIN="passenger_checkin";
	
	
	
	public static final String REQUEST_PARAM_SELECTED_FLIGHT_ID = "flight_id";

	// request parameters from main search
	public static final String REQUEST_PARAM_DIRECTION_FROM = "direction_from";
	public static final String REQUEST_PARAM_DIRECTION_TO = "direction_to";
	public static final String REQUEST_PARAM_DEPARTURE_DATE = "departure_date";
	public static final String REQUEST_PARAM_ARRIVAL_DATE = "arrival_date";

	public static final String REQUEST_PARAM_ERROR_MSG = "errog_msg";
	public static final String PAGE_NO_FLIGHTS_ERROR = "/error_no_flights.jsp";

	public static final String PAGE_DEFAULT = "/default.jsp";
	public static final String PAGE_AUTHORIZED = "/authorised.jsp";
	public static final String PAGE_ERROR = "/error.jsp";
	public static final String PAGE_HOME = "/index.jsp";
	public static final String PAGE_FLIGHT_LIST = "/flight_list.jsp";
	public static final String PAGE_FLIGHT_LIST_CHANGING = "/flights_change.jsp";
	public static final String PAGE_FLIGHT_INFO = "/flight.jsp";
	public static final String PAGE_REGISTRATION = "/registration.jsp";
	public static final String PAGE_REGISTRATION_SUCCESS = "/registration_ok.jsp";

	public static final String SQL_STATEMENT_DIRECTION_CODE = "select distinct direction.direction_code from direction where direction.direction_city = ?;";
	public static final String SQL_STATEMENT_USER_NAME = "select user_name, user_surname, role from user join logon_data on user.user_id = logon_data.user_id where logon_data.login=? and logon_data.password=?';";
	public static final String SQL_STATEMENT_ALL_DIRECTIONS = "select distinct   direction.direction_city from direction;";
	public static final String SQL_STATEMENT_SEARCH_FLIGHT = "select   n1.direction_code, n1.direction_city, t2.departure_date, t2.departure_time, n2.direction_code, n2.direction_city, t2.arrival_date, t2.arrival_time, t2.flight_id, t2.flight_code from flight as t2 join direction as n1 on n1.direction_id = t2.departure_id join direction as n2 on n2.direction_id = t2.arrival_id where  n1.direction_code=? and n2.direction_code=? and t2.departure_date=? and t2.arrival_date=?; ";
	public static final String SQL_STATEMENT_SEARCH_SELECTED_FLIGHT = "select   n1.direction_code, n1.direction_city, t2.departure_date, t2.departure_time, n2.direction_code, n2.direction_city, t2.arrival_date, t2.arrival_time, t2.flight_id, n3.airplane_name, t2.flight_code  from flight as t2 join direction as n1 on n1.direction_id = t2.departure_id join direction as n2 on n2.direction_id = t2.arrival_id join airplane as n3 on t2.plane_id=n3.airplane_id  where  t2.flight_id=? ";
	public static final String SQL_STATEMENT_CREATE_USER_LOGON_DATA = "INSERT INTO logon_data (login, password) VALUES (?, ?);";
	public static final String SQL_STATEMENT_CREATE_USER_DATA="INSERT INTO user (user_id, user_name, user_surname, user_email, ticket_list_id) select  user_id , ?, ?, ?, null from logon_data where login = ?";
	public static final String SQL_STATEMENT_IF_USER_LOGIN_EXIST = "select count(*) from logon_data where login=?;";
	public static final String SQL_STATEMENT_IF_USER_EMAIL_EXIST="select count(*) from user where user_email=?;";
	public static final String SQL_STATEMENT_CREATE_PASSANGER ="INSERT INTO passenger (name, surname, middlename, birthday, age, gender, passport_number, passport_expirty, baggage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	public static final String SQL_STATEMENT_CREATE_TICKET = "INSERT INTO ticket (flight_id, passenger_id, primary_boarding, online-checkin, total_amount) VALUES (?, ?, ?, ?, ?);";
	public static final String SQL_STATEMENT_CREATE_TICKET_LIST ="INSERT INTO ticket_list (ticket_id, user_id) VALUES (?,?);";
}
