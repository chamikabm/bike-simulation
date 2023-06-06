package org.bmck.enums;

import java.util.Optional;

/**
 * Enumeration representing valid commands in the BikeSimulator application.
 */
public enum ValidCommand {
    PLACE,
    FORWARD,
    TURN_LEFT,
    TURN_RIGHT,
    GPS_REPORT;

    /**
     * Converts a string value to the corresponding ValidCommand enumeration value.
     *
     * @param value The string value to convert.
     * @return The ValidCommand enumeration value corresponding to the given string value,
     *         or null if the string value is invalid.
     */
    public static Optional<ValidCommand> fromString(String value) {
        try {
            return Optional.of(valueOf(value));
        } catch (IllegalArgumentException | NullPointerException e) {
            return Optional.empty();
        }
    }
}
