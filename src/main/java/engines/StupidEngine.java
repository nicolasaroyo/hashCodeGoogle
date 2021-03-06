package engines;

import java.util.ArrayList;
import java.util.List;

import main.Output;
import problem.Input;

public class StupidEngine implements Engine {

	@Override
	public Output calculateRides(final Input input) {
		final Output output = new Output();

		final List<List<Integer>> vehicles = new ArrayList<>();
		for (int i = 0; i < input.getNbVehicles(); i++) {
			vehicles.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < input.getRides().size(); i++) {
			vehicles.get(i % input.getNbVehicles()).add(i);
		}

		output.setOutput(vehicles);
		return output;
	}
}
