package helene;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {
	
	//TODO  write read file
	public static List<String> read(String inputName) {
		Path file = Paths.get(inputName);
		List<String> ans = null;
		try {
			ans = Files.lines(file).collect(Collectors.toCollection(ArrayList::new));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ans;
	}

	public static void write(List<String> text, String outputName, boolean override){
		Path file = Paths.get(outputName);
		try {
			if (override) {
				Files.write(file, text, Charset.forName("UTF-8"));
			}
			else {
				Files.write(file, text, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public static void write(List<String> text, String outputName){
		write(text, outputName, true);
	} 
}
