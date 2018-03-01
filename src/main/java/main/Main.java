package main;

import engine.BestRidesCalculator;
import problem.Input;

public class Main {

	private static final String FILE_NAME = "toto.input";
	private static final String OUTPUT_FILE_NAME = "banane.txt";

	public static void main(final String[] args) {
		final FileManager fm = new FileManager();
		final Input input = fm.importFile(FILE_NAME);
		final Output output = new BestRidesCalculator().calculateBestOutput(input);

		fm.writeOutput(OUTPUT_FILE_NAME, output);
	}
}
