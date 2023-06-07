package org.bmck.utils;

/**
 * Utility class for parsing and validating coordinates.
 */
public class CoordinateUtil {
    private CoordinateUtil() {
        // Private constructor to prevent instantiation.
    }

    /**
     * Parses a coordinate value from a string.
     *
     * @param coordinateValue The string to parse.
     * @return The parsed coordinate value, or null if the string is invalid.
     */
    public static Integer getCoordinateValue(String coordinateValue) {
        try {
            return Integer.parseInt(coordinateValue, 10);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }

    /**
     * Checks if the provided x and y coordinates are valid.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return true if the coordinates are valid, false otherwise.
     */
    public static boolean validCoordinates(Integer x, Integer y) {
        return x != null && y != null && x >= 0 && y >= 0;
    }
}
