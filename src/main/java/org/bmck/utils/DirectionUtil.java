package org.bmck.utils;

import org.bmck.enums.ValidDirection;
import org.bmck.points.Coordinate;

import java.util.Optional;

/**
 * Utility class for direction-related operations.
 */
public class DirectionUtil {
    private DirectionUtil() {
        // Private constructor to prevent instantiation.
    }

    /**
     * Retrieves the facing direction based on the provided coordinate.
     *
     * @param facingCoordinate The coordinate representing the facing direction.
     * @return The ValidDirection enumeration value corresponding to the facing direction,
     *         or an empty optional if the coordinate does not represent a valid direction.
     */
    public static Optional<ValidDirection> getFacingDirection(Coordinate facingCoordinate) {
        for (ValidDirection direction : ValidDirection.values()) {
            Coordinate directionCoordinate = ValidDirection.getFacingCoordinates(direction);
            if (directionCoordinate.x() == facingCoordinate.x()
                    && directionCoordinate.y() == facingCoordinate.y()) {
                return Optional.of(direction);
            }
        }
        return Optional.empty(); // No matching direction found
    }
}

