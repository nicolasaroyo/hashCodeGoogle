package mapper;

import problem.Input;

public class MapperInitLine {
	
	public Input inputToInput(final String inputLine) {
		final String[] splittedLine = inputLine.split(" ");
		
		final Input input = new Input();
		input.setNbRows(Integer.valueOf(splittedLine[0]));
		input.setNbColumns(Integer.valueOf(splittedLine[1]));
		input.setNbVehicles(Integer.valueOf(splittedLine[2]));
		input.setBonusForStartingTime(Integer.valueOf(splittedLine[4]));
		input.setNbSteps(Integer.valueOf(splittedLine[5]));
		
		return input;
	}

}
