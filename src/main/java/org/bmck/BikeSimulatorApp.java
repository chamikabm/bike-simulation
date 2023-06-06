package org.bmck;

import org.bmck.inputs.ConsoleInputProvider;
import org.bmck.inputs.InputProvider;
import org.bmck.simulator.bike_simulator.BikeSimulator;

import java.util.Optional;


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
        // Create Simulator
        BikeSimulator bikeSimulator = new BikeSimulator();

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
                Optional<String> commandOutput = bikeSimulator.processCommand(command);
                commandOutput.ifPresent(System.out::println);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
