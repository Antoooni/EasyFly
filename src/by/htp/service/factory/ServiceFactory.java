package by.htp.service.factory;

import by.htp.service.AuthorizationService;
import by.htp.service.AuthorizationServiceImpl;
import by.htp.service.DirectionCodeService;
import by.htp.service.DirectionCodeServiceImpl;
import by.htp.service.DirectionService;
import by.htp.service.DirectionServiceImpl;
import by.htp.service.FlightListService;
import by.htp.service.FlightListServiceImpl;

public class ServiceFactory {
	
	private AuthorizationService authorizationService;
	private DirectionService directionService;

	public ServiceFactory() {

	}

	private static class ServiceFactoryHolder {
		private final static ServiceFactory instance = new ServiceFactory();
	}

	public static ServiceFactory getInstance() {
		return ServiceFactoryHolder.instance;
	}
	
	
	
	public DirectionService getDirectionService() {
		return new DirectionServiceImpl();
	}
	
	public AuthorizationService getAuthorizationService(){
		return new AuthorizationServiceImpl();
	}
	
	public DirectionCodeService getDirectionCodeService(){
		return new DirectionCodeServiceImpl();
	}



	public FlightListService getFlightListService(){
		return new FlightListServiceImpl();
	}

}
