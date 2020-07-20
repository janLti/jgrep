package org.altenter.jgrep;

import java.io.PrintStream;

public class Jgrep {
    public static void main(String... args) {
        if (args.length == 0) {
            printHelp();
            return;
        }
    }

    private static void printHelp() {
        PrintStream ps = System.out;
        ps.printf("Usage:");
    }
}
