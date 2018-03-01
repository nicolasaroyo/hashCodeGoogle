package main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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
	
	private List<String> read(String inputName) throws URISyntaxException {		
		Path file = Paths.get(this.getClass().getResource(inputName).toURI());
		List<String> input = null;
		try {
			input = Files.lines(file).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	public Input importFile(String fileName) throws URISyntaxException {
		final List<String> lines = this.read(fileName);
		
		Optional<Input> input = lines.stream()
				.findFirst()
				.map(this.mapperInitLine::inputToInput);
		
		lines.remove(0);
		
		List<Ride> rides = lines.stream()
				.map(this.mapperRides::inputToRide)
				.collect(Collectors.toList());
		
		input.get().setRides(rides);
		
		return input.get();
	}

	int i;
	public void writeOutput(String outputFileName, Output output) throws IOException {
		Path file = Paths.get(outputFileName);
		
		i=0;
		
		List<String> linesToWrite = output.getOutput().stream()
				.map(intList -> this.formatLine(intList, i++))
				.collect(Collectors.toList());
		
		Files.write(file, linesToWrite, Charset.forName("UTF-8"));
	}
	
	private String formatLine(List<Integer> intList, int i) {
		String line = i + " ";
		
		for(int j = 0; j < intList.size(); j++) {
			line = line + intList.get(j) + " ";
		}
		
		return line;
	}

}
