package org.bmck.simulator.bike_simulator;

import org.bmck.logger.SoutLogger;
import org.bmck.points.Coordinate;
import org.bmck.shapes.SquareGrid;
import org.bmck.simulator.CommandProcessor;

import java.util.Optional;

/**
 * The command processor implementation for the FORWARD command.
 */
public class ForwardCommandProcessor implements CommandProcessor<BikeSimulator, SquareGrid, SoutLogger> {

    /**
     * Processes the FORWARD command, moving the bike one step forward in the current facing direction.
     *
     * @param commandValues The array of command values.
     * @param simulator     The bike simulator instance.
     * @param shape         The square grid shape.
     * @param logger        The logger instance.
     * @return An optional string representing the result of the command processing.
     */
    @Override
    public Optional<String> processCommand(String[] commandValues, BikeSimulator simulator, SquareGrid shape, SoutLogger logger) {
        Coordinate currentCoordinate = simulator.getCoordinate();
        Coordinate facing = simulator.getFacing();

        Coordinate nextCoordinate = new Coordinate(
                currentCoordinate.x() + facing.x(),
                currentCoordinate.y() + facing.y()
        );

        if (shape.isOnTheGrid(nextCoordinate)) {
            simulator.setCoordinate(nextCoordinate);
        } else {
            logger.warn("Cannot move forward, bike will fall off the grid.");
        }

        return Optional.empty();
    }
}
