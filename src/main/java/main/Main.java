package main;

import java.io.File;

import problem.Input;

public class Main {

	private static final String FILE_NAME = "toto.input";
	private static final String OUTPUT_FILE_NAME = "banane.txt";

	public static void main(final String[] args) {
		final FileManager fm = new FileManager();

		final File file = fm.importFile(FILE_NAME);
		final Input input = fm.parseFile(file);

		// FAIRE NOTRE ALGO

		// FAIRE L'OUTPUT
		final Output output = new Output();
		fm.writeOutput(OUTPUT_FILE_NAME, output);
	}
}
