package by.htp.service.factory;

import by.htp.service.AuthorizationService;
import by.htp.service.AuthorizationServiceImpl;
import by.htp.service.ChangeFlightService;
import by.htp.service.ChangeFlightServiceImpl;
import by.htp.service.CreatePassengerService;
import by.htp.service.CreatePassengerServiceImpl;
import by.htp.service.CreateTicketService;
import by.htp.service.CreateTicketServiceImpl;
import by.htp.service.DirectionCodeService;
import by.htp.service.DirectionCodeServiceImpl;
import by.htp.service.DirectionService;
import by.htp.service.DirectionServiceImpl;
import by.htp.service.FlightListService;
import by.htp.service.FlightListServiceImpl;
import by.htp.service.SelectedFlightService;
import by.htp.service.SelectedFlightServiceImpl;
import by.htp.service.UserCreateService;
import by.htp.service.UserCreateServiceImpl;

public class ServiceFactory {

	private static final AuthorizationService authorizationService=new AuthorizationServiceImpl();
	private static final DirectionService directionService= new DirectionServiceImpl();
	private static final DirectionCodeService directionCodeService = new DirectionCodeServiceImpl();
	private static final UserCreateService userCreateService = new UserCreateServiceImpl();
	private static final FlightListService flightListService = new FlightListServiceImpl();
	private static final SelectedFlightService selectedFlightService = new SelectedFlightServiceImpl();
	private static final CreatePassengerService createPassengerService = new CreatePassengerServiceImpl();
	private static final CreateTicketService createTicketService = new CreateTicketServiceImpl();
	private static final ChangeFlightService changeFlightService = new ChangeFlightServiceImpl();

	private ServiceFactory() { 

	}

	private static class ServiceFactoryHolder {
		private final static ServiceFactory instance = new ServiceFactory();
	}

	public static ServiceFactory getInstance() {
		return ServiceFactoryHolder.instance;
	}

	public DirectionService getDirectionService() {
		return directionService;
	}

	public AuthorizationService getAuthorizationService() {
		return authorizationService;
	}

	public DirectionCodeService getDirectionCodeService() {
		return directionCodeService;
	}

	public UserCreateService getUserCreateService() {
		return userCreateService;
	}

	public FlightListService getFlightListService() {
		return flightListService;
	}

	public SelectedFlightService getSelectedFlightService() {
		return selectedFlightService;
	}
	public CreatePassengerService getCreatePassengerService(){
		return createPassengerService;
	}
	public CreateTicketService getCreateTicketService(){
		return createTicketService;
	}
	public ChangeFlightService getChangeFlightService(){
		return changeFlightService;
	}
}
