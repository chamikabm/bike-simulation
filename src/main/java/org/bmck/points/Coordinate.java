package org.bmck.points;

/**
 * Represents a coordinate with x and y values.
 */
public record Coordinate(int x, int y) implements Locatable {

    /**
     * Retrieves a printable representation of the coordinate's location.
     *
     * @return The printable location as a string.
     */
    @Override
    public String getPrintableLocation() {
        return "(%d,%d)".formatted(x, y);
    }
}
