package org.bmck.simulator;

import java.util.Optional;

/**
 * Interface representing a simulator.
 */
public interface Simulator {

    /**
     * Processes a command and returns the result as an optional string.
     *
     * @param command The command to process.
     * @return An optional string representing the result of the command,
     *         or an empty optional if the command is invalid or produces no output.
     */
    Optional<String> processCommand(String command);
}
