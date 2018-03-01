package main;

import java.io.File;

import problem.Input;

public class Main {

	private static final String FILE_NAME = "toto.input";

	public static void main(final String[] args) {
		final FileManager fm = new FileManager();

		final File file = fm.importFile(FILE_NAME);
		final Input input = fm.parseFile(file);

		// FAIRE NOTRE ALGO

		// FAIRE L'OUTPUT

	}
}
