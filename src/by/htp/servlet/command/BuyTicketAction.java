package by.htp.servlet.command;

import static by.htp.util.ConstantValue.*;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bin.Baggage;
import by.htp.bin.Flight;
import by.htp.bin.Passenger;
import by.htp.bin.Ticket;
import by.htp.service.CreatePassengerService;
import by.htp.service.CreateTicketService;
import by.htp.service.factory.ServiceFactory;

public class BuyTicketAction implements CommandAction {
	ServiceFactory serviceFactory = new ServiceFactory();

	private CreatePassengerService createPassengerService;
	private CreateTicketService createTicketService;

	public BuyTicketAction() {
		createPassengerService = serviceFactory.getCreatePassengerService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Ticket ticket = new Ticket();
		HttpSession session = request.getSession(true);
		session.getAttribute("flight");
		Flight flight = (Flight) session.getAttribute("flight");
		System.out.println("flight " + flight.getDepartureDate() + " " + flight.getFlightCode());
		
		// create passenger
		Passenger passenger = new Passenger();
		Baggage baggage = null;

		passenger.setName(request.getParameter(REQUEST_PARAM_PASSENGER_NAME));
		passenger.setSurname(request.getParameter(REQUEST_PARAM_PASSENGER_SURNAME));
		passenger.setMiddleName(request.getParameter(REQUEST_PARAM_PASSENGER_MIDNAME));
		passenger.setAge(Integer.valueOf(request.getParameter(REQUEST_PARAM_PASSENGER_AGE)));
		passenger.setDateOfBirth(request.getParameter(REQUEST_PARAM_PASSENGER_BIRTH));
		passenger.setSex(request.getParameter(REQUEST_PARAM_PASSENGER_SEX));
		passenger.setPassportId(request.getParameter(REQUEST_PARAM_PASSENGER_PASSPORT_NUMBER));
		passenger.setPassportExpirty(Date.valueOf(request.getParameter(REQUEST_PARAM_PASSENGER_PASSPORT_EXPIRTY)));
		passenger.setBaggage(Baggage.valueOf(request.getParameter(REQUEST_PARAM_PASSENGER_BAGGAGE).toUpperCase()));

		int passengerId = createPassengerService.passenger(passenger);
		System.out.println(passenger.toString());

		// create ticket
		ticket.setPassengerId(passengerId);
		ticket.setFlightId(flight.getFlightId());
		ticket.setPrimaryBoarding(convertAnswer(request.getParameter(REQUEST_PARAM_TICKET_PRIMARY_BOARDING)));
		ticket.setOnlineCheckIn(convertAnswer(request.getParameter(REQUEST_PARAM_TICKET_CHECKIN)));
//		ticket.setTotalAmount(request.getParameter());
		int ticketId = createTicketService.ticket(ticket);
		
		//create ticket list
		int ticketListId = createTicketService.ticketList(user, ticketId);
		return null;
	}

	private boolean convertAnswer(String s) {
		s.toUpperCase();
		if (s.equals("YES"))
			return true;
		else
			return false;
	}
}
