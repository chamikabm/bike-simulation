package org.bmck.simulator.bike_simulator;

import org.bmck.logger.SoutLogger;
import org.bmck.shapes.SquareGrid;
import org.bmck.simulator.CommandProcessor;

import java.util.Optional;

/**
 * The command processor implementation for the TURN_RIGHT command.
 */
public class TurnRightCommandProcessor implements CommandProcessor<BikeSimulator, SquareGrid, SoutLogger> {

    /**
     * Processes the TURN_RIGHT command, turning the bike right by changing its facing direction.
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
