package engine;

import java.util.ArrayList;
import java.util.List;

import engines.Engine;
import engines.RandomEngine;
import engines.StupidEngine;
import main.Output;
import problem.Input;
import problem.Ride;

public class BestRidesCalculator {

	private static final int NB_RANDOM_ENGINES = 10;

	public Output calculateBestOutput(final Input input) {
		final List<Engine> engines = this.getEnginesToTry();

		int bestScore = 0;
		Output bestOutput = null;

		for (final Engine engine : engines) {
			final Output currentOutput = engine.calculateRides(input);
			final int currentScore = this.calculateScore(currentOutput, input);
			System.out.println(String.format("Engine %s had a score of %d", engine.getClass().getName(), currentScore));
			if (currentScore > bestScore) {
				bestScore = currentScore;
				bestOutput = currentOutput;
			}
		}

		return bestOutput;
	}

	private int calculateScore(final Output output, final Input input) {
		final List<List<Integer>> vehicles = output.getOutput();
		return vehicles.stream().mapToInt(v -> this.calculateScoreVehicle(v, input)).sum();
	}

	private int calculateScoreVehicle(final List<Integer> vehicle, final Input input) {
		int step = 0;
		int score = 0;
		int vehicleRow = 0;
		int vehicleColumn = 0;
		for (final Integer rideNb : vehicle) {
			final Ride ride = input.getRides().get(rideNb);
			step += Math.abs(ride.getStart().getColumn() - vehicleColumn);
			step += Math.abs(ride.getStart().getRow() - vehicleRow);
			vehicleColumn = ride.getStart().getColumn();
			vehicleRow = ride.getStart().getRow();
			if (step <= ride.getEarliestStart()) {
				step = ride.getEarliestStart();
				score += input.getBonusForStartingTime();
			}
			final int distanceToFinish = Math.abs(ride.getStart().getColumn() - vehicleColumn)
					+ Math.abs(ride.getStart().getRow() - vehicleRow);
			step += distanceToFinish;
			if (step <= ride.getLatestFinish()) {
				score += distanceToFinish;
			}
		}
		return score;
	}

	private List<Engine> getEnginesToTry() {
		final List<Engine> engines = new ArrayList<>();
		// For now, we add a lot of random engines.
		for (int i = 0; i < NB_RANDOM_ENGINES; i++) {
			engines.add(new RandomEngine());
		}
		engines.add(new StupidEngine());
		return engines;
	}
}
