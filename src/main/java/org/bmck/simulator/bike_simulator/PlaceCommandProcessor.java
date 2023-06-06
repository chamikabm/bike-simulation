package org.bmck.simulator.bike_simulator;

import org.bmck.logger.SoutLogger;
import org.bmck.shapes.SquareGrid;
import org.bmck.simulator.CommandProcessor;

import java.util.Optional;

/**
 * The command processor implementation for the PLACE command.
 */
public class PlaceCommandProcessor implements CommandProcessor<BikeSimulator, SquareGrid, SoutLogger> {

    /**
     * Processes the PLACE command, placing the bike on the specified coordinates and facing direction.
     *
     * @param commandValues The array of command values.
     * @param simulator     The bike simulator instance.
     * @param shape         The square grid shape.
     * @param logger        The logger instance.
     * @return An optional string representing the result of the command processing.
     */
    @Override
    public Optional<String> processCommand(String[] commandValues, BikeSimulator simulator, SquareGrid shape, SoutLogger logger) {

        return Optional.empty();
    }
}
