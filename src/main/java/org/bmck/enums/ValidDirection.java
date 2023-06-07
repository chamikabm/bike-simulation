package org.bmck.enums;

import org.bmck.points.Coordinate;

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
}
