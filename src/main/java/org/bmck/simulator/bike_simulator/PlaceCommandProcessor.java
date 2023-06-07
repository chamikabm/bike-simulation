package org.bmck.simulator.bike_simulator;

import org.bmck.enums.ValidDirection;
import org.bmck.logger.SoutLogger;
import org.bmck.points.Coordinate;
import org.bmck.shapes.SquareGrid;
import org.bmck.simulator.CommandProcessor;
import org.bmck.utils.CoordinateUtil;

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
        if (commandValues.length != 4) {
            logger.warn("Invalid command");
            return Optional.empty();
        }

        Integer x = CoordinateUtil.getCoordinateValue(commandValues[1]);
        Integer y = CoordinateUtil.getCoordinateValue(commandValues[2]);
        if (!CoordinateUtil.validCoordinates(x, y)) {
            logger.warn("Invalid command");
            return Optional.empty();
        }

        Coordinate nextCoordinate = new Coordinate(x, y);
        Optional<ValidDirection> facingDirection = ValidDirection.fromString(commandValues[3]);
        if (facingDirection.isEmpty()) {
            logger.warn("Invalid command");
            return Optional.empty();
        }

        if (shape.isOnTheGrid(nextCoordinate)) {
            simulator.setCoordinate(nextCoordinate);
            simulator.setPlaced(true);
            simulator.setFacing(ValidDirection.getFacingCoordinates(facingDirection.get()));
        } else {
            logger.warn("Bike must be placed on the grid.");
        }

        return Optional.empty();
    }
}
