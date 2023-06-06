package org.bmck;

import org.bmck.inputs.ConsoleInputProvider;
import org.bmck.inputs.InputProvider;

/**
 * The main entry point for the Bike Simulator application.
 */
public class BikeSimulatorApp {
    /**
     * The main method to start the Bike Simulator application.
     *
     * @param args The command line arguments.
     */
    public static void main( String[] args ) {
        // Take the input from the console.
        try (InputProvider inputProvider = new ConsoleInputProvider()) {
            while (true) {
                System.out.print("Enter a command (or 'exit' to quit): ");
                String command = inputProvider.getInput();

                // Check if the user wants to exit
                if (command.equalsIgnoreCase("exit")) {
                    break; // Exit the loop and terminate the program
                }

                // Process the command and print output if present.
                System.out.println("Command to process: " + command);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
