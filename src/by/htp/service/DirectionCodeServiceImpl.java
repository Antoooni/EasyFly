package by.htp.service;

import by.htp.bin.Direction;
import by.htp.dao.DirectionCodeDao;
import by.htp.dao.factory.DaoFactory;

public class DirectionCodeServiceImpl implements DirectionCodeService {
	private DirectionCodeDao directionCode;
//	DaoFactory daoFactory = new DaoFactory();

	public DirectionCodeServiceImpl() {
		directionCode = DaoFactory.getInstance().getDirectionCodeDao();
	}

	@Override
	public String directionCode(String direction) {
		String destinationCode = directionCode.directionCode(direction);
		return destinationCode;
	}


}
