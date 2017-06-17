package by.htp.service.impl;

import by.htp.bin.Direction;
import by.htp.dao.DirectionCodeDao;
import by.htp.dao.factory.DaoFactory;
import by.htp.service.DirectionCodeService;

public class DirectionCodeServiceImpl implements DirectionCodeService {
	private DirectionCodeDao directionCode;
	DaoFactory daoFactory = new DaoFactory();

	public DirectionCodeServiceImpl() {
		directionCode = daoFactory.getDirectionCodeDao();
	}

	@Override
	public String directionCode(String direction) {
		String destinationCode = directionCode.directionCode(direction);
		return destinationCode;
	}


}
