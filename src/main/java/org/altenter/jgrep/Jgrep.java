package org.altenter.jgrep;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.io.IOException;

public class Jgrep {
	public static void main(String... args) throws IOException {
		if (args.length == 0 || args.length < 2) {
			printHelp();
			return;
		}

		List<String> search = getSearchStrings(args);

		printLines(search, args[args.length - 1]);
	}

	static void printLines(List<String> search, String filename) throws IOException {
		System.out.printf("Search in: %s", filename);
		System.out.println();
		System.out.println();
		System.out.println("Found lines:");
		System.out.println();

		Counter counter = new Counter();

		Path p = Paths.get(filename);
		if (Files.isDirectory(p))
			return;

		Stream<String> lines = Files.lines(p);
		lines.forEach(s -> {
			for (String m : search) {
				if (s.contains(m)) {
					System.out.println(s);
					counter.incr();
					break;
				}
			}
		});

		System.out.println();
		System.out.printf("Total lines: %d", counter.n);
		System.out.println();
	}

	static List<String> getSearchStrings(String... args) {
		List<String> searches = new ArrayList<>();
		for (String s : args)
			searches.add(s);
		searches.remove(searches.size() - 1);
		System.out.print("Search for: ");
		System.out.println(searches);
		return searches;
	}

	private static void printHelp() {
		PrintStream ps = System.out;
		ps.println();
		ps.println("Usage:");
		ps.println("jrep searchstrings file");
		ps.println("-searchstrings   search strings separated by spaces");
		ps.println();
	}

	private static class Counter {
		private Integer n = 0;

		private void incr() {
			n++;
		}
	};
}
