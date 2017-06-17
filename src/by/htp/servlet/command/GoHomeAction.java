package by.htp.servlet.command;

import static by.htp.util.ConstantValue.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bin.FlightDirection;

import by.htp.service.DirectionService;
import by.htp.service.factory.ServiceFactory;
import by.htp.service.impl.DirectionServiceImpl;

public class GoHomeAction implements CommandAction {
	ServiceFactory serviceFactory = new ServiceFactory();
	private DirectionService directionService;

	public GoHomeAction() {

		directionService = serviceFactory.getDirectionService();

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_DEFAULT;
		List<FlightDirection> flightDirection = directionService.listDirections();
		// вывести список направлений dropdown
		request.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);
		page = PAGE_HOME;

		return page;
	}

}
