package by.htp.servlet.command;

import static by.htp.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bin.Flight;
import by.htp.service.SelectedFlightService;
import by.htp.service.factory.ServiceFactory;

public class FlightInfoAction implements CommandAction {

	private ServiceFactory serviceFactory = new ServiceFactory();

	private SelectedFlightService selectedFlightService;

	public FlightInfoAction() {
		selectedFlightService = serviceFactory.getSelectedFlightService();

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_FLIGHT_INFO;

		int flightId = Integer.valueOf(request.getParameter(REQUEST_PARAM_SELECTED_FLIGHT_ID));
		System.out.println("Selected flight ID: " + flightId);
		
		Flight flight = selectedFlightService.flight(flightId);
		request.setAttribute(REQUEST_PARAM_FLIGHT_INFO, flight);
		
		System.out.println(flight.toString());
		return page;
	}

}
