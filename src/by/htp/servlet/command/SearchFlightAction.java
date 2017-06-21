package by.htp.servlet.command;

import static by.htp.util.ConstantValue.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bin.Flight;
import by.htp.bin.User;
import by.htp.service.DirectionCodeService;
import by.htp.service.FlightListService;
import by.htp.service.exception.ServiceNoSuchFlightsException;
import by.htp.service.factory.ServiceFactory;

public class SearchFlightAction implements CommandAction {
	ServiceFactory serviceFactory = new ServiceFactory();
	
	private FlightListService flightListService;
	private DirectionCodeService  rirectionCodeService;

	public SearchFlightAction() {
		flightListService = serviceFactory.getFlightListService();
		rirectionCodeService= serviceFactory.getDirectionCodeService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String page = request.getParameter(PAGE_FLIGHT_LIST);
		String departureCity =request.getParameter(REQUEST_PARAM_DIRECTION_FROM);
		String arrivalCity = request.getParameter(REQUEST_PARAM_DIRECTION_TO);
		String departureDateSQL = request.getParameter(REQUEST_PARAM_DEPARTURE_DATE);
		String arrivalDateSQL = request.getParameter(REQUEST_PARAM_ARRIVAL_DATE);
		String userRole=request.getParameter(REQUEST_PARAM_USER);
		try{
			String departureCode = rirectionCodeService.directionCode(departureCity); //convert departure city to airport code
			String arrivalCode = rirectionCodeService.directionCode(arrivalCity); //convert arrival city to airport code
			
			List<Flight> listFlight=flightListService.flightList( departureCode,  arrivalCode,  departureDateSQL,  arrivalDateSQL);
			//подменять MSQ Minsk на MSQ
			request.setAttribute(REQUEST_PARAM_FLIGHTS_LIST, listFlight);
			if(userRole==null){
				page= PAGE_FLIGHT_LIST;
			}
			else
				page= PAGE_FLIGHT_LIST_CHANGING;
		}
		catch(ServiceNoSuchFlightsException e){
			page= PAGE_NO_FLIGHTS_ERROR;
			request.setAttribute(REQUEST_PARAM_ERROR_MSG, e.getMessage());
		}
		

		return page;
	}

}
