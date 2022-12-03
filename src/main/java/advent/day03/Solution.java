package advent.day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	private static final Path INPUT_FILE = Path.of("input/day3/input.txt");
//	private static final Path INPUT_FILE = Path.of("input/day3/input-test.txt");

	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();
		System.out.println("step1: " + solution.solveStep1());
		System.out.println("step2: " + solution.solveStep2());
	}

	public int solveStep1() throws IOException {
		return Files.readAllLines(INPUT_FILE).stream()
			.map(line -> {
				char[] compartment1 = line.substring(0, line.length()/2).toCharArray();
				char[] compartment2 = line.substring(line.length()/2, line.length()).toCharArray();
				return new char[][] { compartment1, compartment2 };
		}).map(arrays -> {
			Arrays.sort(arrays[0]);
			Arrays.sort(arrays[1]);
			return findCommonChars(arrays[0],arrays[1])[0];
		}).map(Solution::toPriority).reduce(0, (a, b) -> a + b);
	}

	public int solveStep2() throws IOException {
		int[] i = { 0 };
		return Files.readAllLines(INPUT_FILE).stream().map(String::toCharArray)
			.map(arr -> new Object[] { i[0]++, arr })
			.collect(Collectors.groupingBy(arr -> ((int) arr[0]) / 3))
			.values().stream()
			.map(arrays ->{
			char[] e1 = (char[]) arrays.get(0)[1];
			char[] e2 = (char[]) arrays.get(1)[1];
			char[] e3 = (char[]) arrays.get(2)[1];
			Arrays.sort(e1);
			Arrays.sort(e2);
			Arrays.sort(e3);
			char[] commonE1E2 = findCommonChars(e1, e2);
			return findCommonChars(commonE1E2, e3)[0];
		}).map(Solution::toPriority).reduce(0, (a, b) -> a + b);
	}
	
	private char[] findCommonChars(char[] a, char[] b) {
		List<Character> list= new ArrayList<>();
		for (int i = 0, j = 0; ;) {
			if (a[i] == b[j]) {
				list.add(a[i]);
				if(a.length>i+1) {
					i++;
				}else if(b.length>j+1) {
					j++;
				}else {
					return toCharArray(list);
				}
			} else if (a[i] < b[j]) {
				if(a.length>i+1) {
					i++;
				}else {
					return toCharArray(list);
				}
			} else if(b[j] < a[i]){
				if(b.length>j+1){
					j++;
				}else {
					return toCharArray(list);
				}
			}
		}
	}
	
	private char[] toCharArray(List<Character> list) {
		return list.stream()
				.collect(() -> new StringBuilder(), (a, b) -> a.append(b), (a, b) -> a.append(b)).toString()
				.toCharArray();
	}

	private static int toPriority(char c) {
		return c < 'a' ? c - 'A' + 27 : c - 'a' + 1;
	}
}
