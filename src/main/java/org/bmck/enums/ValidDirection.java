package org.bmck.enums;

import org.bmck.points.Coordinate;

import java.util.Optional;

/**
 * Enumeration representing valid directions in the BikeSimulator application.
 */
public enum ValidDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    /**
     * Retrieves the facing coordinates for the specified ValidDirection.
     *
     * @param value The ValidDirection for which to retrieve the facing coordinates.
     * @return The facing coordinates as a Coordinate object.
     */
    public static Coordinate getFacingCoordinates(ValidDirection value) {
        return switch (value) {
            case NORTH -> new Coordinate(0, 1);
            case EAST -> new Coordinate(1, 0);
            case SOUTH -> new Coordinate(0, -1);
            case WEST -> new Coordinate(-1, 0);
            default -> null;
        };
    }

    /**
     * Converts a string value to the corresponding ValidDirection enumeration value.
     *
     * @param value The string value to convert.
     * @return The ValidDirection enumeration value corresponding to the given string value,
     *         or null if the string value is invalid.
     */
    public static Optional<ValidDirection> fromString(String value) {
        try {
            return Optional.of(valueOf(value));
        } catch (IllegalArgumentException | NullPointerException e) {
            return Optional.empty();
        }
    }

}
