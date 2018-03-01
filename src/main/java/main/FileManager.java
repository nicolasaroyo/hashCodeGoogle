package main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import mapper.MapperInitLine;
import mapper.MapperRides;
import problem.Input;
import problem.Ride;

public class FileManager {

	private MapperInitLine mapperInitLine = new MapperInitLine();
	private MapperRides mapperRides = new MapperRides();

	private List<String> read(final String inputName) throws URISyntaxException {
		final Path file = Paths.get(this.getClass().getResource(inputName).toURI());
		List<String> input = null;
		try {
			input = Files.lines(file).collect(Collectors.toList());
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	public Input importFile(final String fileName) throws URISyntaxException {
		final List<String> lines = this.read(fileName);

		final Optional<Input> input = lines.stream().findFirst().map(this.mapperInitLine::inputToInput);

		lines.remove(0);

		final List<Ride> rides = lines.stream().map(this.mapperRides::inputToRide).collect(Collectors.toList());

		input.get().setRides(rides);

		return input.get();
	}

	int i;

	public void writeOutput(final String outputFileName, final Output output) throws IOException {
		final Path file = Paths.get(outputFileName);

		this.i = 1;

		final List<String> linesToWrite = output.getOutput().stream().map(intList -> this.formatLine(intList, this.i++))
				.collect(Collectors.toList());

		Files.write(file, linesToWrite, Charset.forName("UTF-8"));
	}

	private String formatLine(final List<Integer> intList, final int i) {
		String line = i + " ";

		for (int j = 0; j < intList.size(); j++) {
			line = line + intList.get(j) + " ";
		}

		return line;
	}

}
