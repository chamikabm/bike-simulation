package org.bmck.inputs;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {
    private final Scanner scanner;

    public ConsoleInputProvider() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}

