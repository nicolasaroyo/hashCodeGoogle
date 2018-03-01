package engine;

import java.util.ArrayList;
import java.util.List;

import engines.Engine;
import engines.StupidEngine;
import main.Output;
import problem.Input;

public class BestRidesCalculator {

	public Output calculateBestOutput(final Input input) {
		return null;
	}

	private List<Engine> getEnginesToTry() {
		final List<Engine> engines = new ArrayList<>();
		engines.add(new StupidEngine());
		return engines;
	}
}
