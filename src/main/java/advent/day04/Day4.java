package advent.day04;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Day4 {

	public long solveStep1(Stream<String> inputStream) {
		return findOverlap(inputStream, arr -> 
			   (arr[0] <= arr[2] && arr[1] >= arr[3])
			|| (arr[0] >= arr[2] && arr[1] <= arr[3]));
	}
	public long solveStep2(Stream<String> inputStream)  {
		return findOverlap(inputStream, arr -> 
			   (arr[0] >= arr[2] && arr[0] <= arr[3])
			 ||(arr[1] >= arr[2] && arr[1] <= arr[3])
			 ||(arr[2] >= arr[0] && arr[2] <= arr[1])
			 ||(arr[3] >= arr[0] && arr[3] <= arr[1]));
	}
		
	private long findOverlap(Stream<String> inputStream, Predicate<? super Integer[]> filter) {
		return inputStream
				.map(line -> line.split("[,-]"))
				.map(arr -> Arrays.asList(arr).stream().map(Integer::parseInt).toList().toArray(new Integer[4]))
				.filter(filter)
				.count();
	}

}
