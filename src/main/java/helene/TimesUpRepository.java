package helene;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naroyo.rest.timesup.Mot;

public class TimesUpRepository {

	private final ObjectMapper objectMapper = new ObjectMapper();

	private static final String DATABASE_FILE_NAME = "db.json";

	private ListeMots readFile() {
		final InputStream inputStream = this.getClass().getResourceAsStream(DATABASE_FILE_NAME);
		ListeMots liste = new ListeMots();
		try {
			liste = this.objectMapper.readValue(inputStream, ListeMots.class);
			inputStream.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return liste;
	}

	private boolean writeFile(final ListeMots liste) {
		String json = null;
		try {
			json = this.objectMapper.writeValueAsString(liste);
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		}
		try (final PrintWriter output = new PrintWriter(this.getClass().getResource(DATABASE_FILE_NAME).getPath())) {
			output.println(json);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Mot> findAll() {
		return this.readFile().getListe();
	}

	public boolean addMot(final Mot mot) {
		final ListeMots liste = this.readFile();
		liste.getListe().add(mot);
		return this.writeFile(liste);
	}
}
