package org.bmck.simulator.bike_simulator;

import org.bmck.enums.ValidDirection;
import org.bmck.logger.SoutLogger;
import org.bmck.points.Coordinate;
import org.bmck.shapes.SquareGrid;
import org.bmck.simulator.CommandProcessor;
import org.bmck.utils.DirectionUtil;

import java.util.Optional;

/**
 * The command processor implementation for the GPS_REPORT command.
 */
public class GPSReportCommandProcessor implements CommandProcessor<BikeSimulator, SquareGrid, SoutLogger> {

    /**
     * Processes the GPS_REPORT command, providing the current position and facing direction of the bike.
     *
     * @param commandValues The array of command values.
     * @param simulator     The bike simulator instance.
     * @param shape         The square grid shape.
     * @param logger        The logger instance.
     * @return An optional string representing the result of the command processing.
     */
    @Override
    public Optional<String> processCommand(String[] commandValues, BikeSimulator simulator, SquareGrid shape, SoutLogger logger) {
        Coordinate coordinate = simulator.getCoordinate();
        Optional<ValidDirection> facingDirection = DirectionUtil.getFacingDirection(simulator.getFacing());

        if (facingDirection.isEmpty()) {
            // Invalid facing direction.
            logger.warn("Invalid facing direction");
            return Optional.empty();
        }

        return Optional.of(String.format("%s, %s", coordinate.getPrintableLocation(), facingDirection.get()));
    }
}
