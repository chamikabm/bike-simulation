package org.bmck.simulator.bike_simulator;

import org.bmck.enums.ValidCommand;
import org.bmck.logger.Logger;
import org.bmck.logger.SoutLogger;
import org.bmck.points.Coordinate;
import org.bmck.shapes.Shape;
import org.bmck.shapes.SquareGrid;
import org.bmck.simulator.CommandProcessor;
import org.bmck.simulator.Simulator;
import org.bmck.utils.CommandUtil;

import java.util.Optional;

/**
 * The main BikeSimulator implementation of the Simulator interface.
 */
public class BikeSimulator implements Simulator {

    private final Shape grid;
    private final Logger logger;
    private boolean isPlaced;
    private Coordinate coordinate;
    private Coordinate facing;
    private final CommandProcessorFactory commandProcessorFactory;


    /**
     * Constructs a BikeSimulator with the specified grid and logger.
     *
     * @param grid   The grid for the simulator.
     * @param logger The logger for the simulator.
     */
    public BikeSimulator(Shape grid, Logger logger) {
        this.grid = grid;
        this.logger = logger;

        // Initialize command processor factory
        commandProcessorFactory = new CommandProcessorFactory();
    }

    /**
     * Processes the given command and returns the result as an optional string.
     *
     * @param command The command to be processed.
     * @return An optional string representing the result of the command processing.
     */

    @Override
    public Optional<String> processCommand(String command) {
        Optional<String[]> commandValues = CommandUtil.getCommandValues(command);

        if (commandValues.isEmpty()) {
            System.out.println("You must provide a valid command to progress.");
            return Optional.empty();
        }

        Optional<ValidCommand> inputCommand = ValidCommand.fromString(commandValues.get()[0]);
        if (inputCommand.isEmpty()) {
            System.out.println("Invalid command");
            return Optional.empty();
        }

        if (!isPlaced && (inputCommand.get() != ValidCommand.PLACE)) {
            logger.info("Robot must be placed before executing other commands than PLACE.");
            return Optional.empty();
        }

        if (grid instanceof SquareGrid squareGrid) {
            CommandProcessor<BikeSimulator, SquareGrid, SoutLogger> commandProcessor =
                    commandProcessorFactory.createCommandProcessor(inputCommand.get());
            if (commandProcessor != null) {
                return commandProcessor
                        .processCommand(commandValues.get(), this, squareGrid, (SoutLogger) logger);
            } else {
                logger.warn("Command processor not found for the command: " + inputCommand);
            }
        } else {
            logger.warn("Grid type unsupported for bike simulation.");
            return Optional.empty();
        }

        return Optional.empty();
    }

    /**
     * Checks if the bike has been placed on the grid.
     *
     * @return true if the bike has been placed, false otherwise.
     */
    public boolean isPlaced() {
        return isPlaced;
    }

    /**
     * Retrieves the current coordinate of the bike.
     *
     * @return The current coordinate of the bike.
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Retrieves the current facing direction of the bike.
     *
     * @return The current facing direction of the bike.
     */
    public Coordinate getFacing() {
        return facing;
    }

    /**
     * Sets the placement status of the bike on the grid.
     *
     * @param placed The placement status of the bike.
     */
    void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    /**
     * Sets the current coordinate of the bike.
     *
     * @param coordinate The current coordinate of the bike.
     */
    void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Sets the current facing direction of the bike.
     *
     * @param facing The current facing direction of the bike.
     */
    void setFacing(Coordinate facing) {
        this.facing = facing;
    }
}
