package mapper;

import problem.Coordinate;
import problem.Input;
import problem.Ride;

public class MapperRides {

	public Ride inputToRide(final String inputLine) {
		final String[] splittedLine = inputLine.split(" ");
		
		final Ride ride = new Ride();
		final Coordinate coordStart = new Coordinate();
		coordStart.setRow(Integer.valueOf(splittedLine[0]));
		coordStart.setColumn(Integer.valueOf(splittedLine[1]));
		
		final Coordinate coordFinish = new Coordinate();
		coordFinish.setRow(Integer.valueOf(splittedLine[3]));
		coordFinish.setColumn(Integer.valueOf(splittedLine[4]));
		
		ride.setStart(coordStart);
		ride.setFinish(coordFinish);
		ride.setEarliestStart(Integer.valueOf(splittedLine[5]));
		ride.setLatestFinish(Integer.valueOf(splittedLine[6]));
		
		return ride;
	}
}
