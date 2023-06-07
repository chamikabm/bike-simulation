package org.bmck;

import org.bmck.inputs.ConsoleInputProvider;
import org.bmck.inputs.InputProvider;
import org.bmck.logger.Logger;
import org.bmck.logger.SoutLogger;
import org.bmck.points.Coordinate;
import org.bmck.shapes.Shape;
import org.bmck.shapes.SquareGrid;
import org.bmck.simulator.Simulator;
import org.bmck.simulator.bike_simulator.BikeSimulator;
import org.bmck.utils.ConfigUtil;

import java.util.Optional;

import static org.bmck.constants.BikeSimulatorConstants.MAX_COORDINATE_KEY;
import static org.bmck.constants.BikeSimulatorConstants.MIN_COORDINATE_KEY;


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
        // Get Min-Max Coordinate Config Values
        int minCoordinateValue = ConfigUtil.getIntProperty(MIN_COORDINATE_KEY);
        int maxCoordinateValue = ConfigUtil.getIntProperty(MAX_COORDINATE_KEY);

        // Prepare Min-Max Coordinates
        Coordinate minCoordinate = new Coordinate(minCoordinateValue, minCoordinateValue);
        Coordinate maxCoordinate =  new Coordinate(maxCoordinateValue, maxCoordinateValue);

        // Create the Grid
        Shape grid = new SquareGrid(minCoordinate, maxCoordinate);

        // Create logger
        Logger logger = new SoutLogger();

        // Create Simulator
        Simulator bikeSimulator = new BikeSimulator(grid, logger);

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
