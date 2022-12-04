package advent.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Utils {

	public static Stream<String> input(String day) throws IOException {
		return Files.readAllLines(Path.of("input/"+day+"/input.txt")).stream();
	}
}
