package org.bmck.utils;

import java.util.Optional;

/**
 * Utility class for parsing and manipulating commands.
 */
public class CommandUtil {
    private CommandUtil() {
        // Private constructor to prevent instantiation.
    }

    /**
     * Splits a command string into individual values.
     *
     * @param command The command string to split.
     * @return An array of command values, or null if the command is invalid.
     */
    public static Optional<String[]> getCommandValues(String command) {
        if (command == null || command.isEmpty()) {
            return Optional.empty();
        }

        try {
            return Optional.of(command.split("[,\\s]+"));
        } catch (Exception e) {
            System.err.println("Error while splitting the commands. Error: " + e.getMessage());
            return Optional.empty();
        }
    }
}
