package engines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import main.Output;
import problem.Input;

public class RandomEngine implements Engine {

	@Override
	public Output calculateRides(final Input input) {
		final Random r = new Random();
		final Output output = new Output();

		final List<List<Integer>> vehicles = new ArrayList<>();
		for (int i = 0; i < input.getNbVehicles(); i++) {
			vehicles.add(new ArrayList<Integer>());
		}

		final List<Integer> shuffledRides = new ArrayList<>();
		for (int i = 0; i < input.getRides().size(); i++) {
			shuffledRides.add(i);
		}

		Collections.shuffle(shuffledRides);

		for (final Integer i : shuffledRides) {
			vehicles.get(r.nextInt(input.getNbVehicles())).add(i);
		}

		output.setOutput(vehicles);
		return output;
	}
}
