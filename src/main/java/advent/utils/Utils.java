package advent.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Utils {

	public static Stream<String> input(String day) throws IOException {
		return input(day, "");
	}
	
	public static Stream<String> input(String day, String suffix) throws IOException {
		return Files.readAllLines(Path.of("input/"+day+"/input"+suffix+".txt")).stream();
	}
	
	public static String readline(String day) throws IOException {
		return readline(day, "");
	}
	public static String readline(String day, String suffix) throws IOException {
		try(BufferedReader r=new BufferedReader(new FileReader("input/"+day+"/input"+suffix+".txt"))){
			return r.readLine();
		}
	}
}
