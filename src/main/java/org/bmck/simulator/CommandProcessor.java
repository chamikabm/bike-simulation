package org.bmck.simulator;

import org.bmck.logger.Logger;
import org.bmck.shapes.Shape;

import java.util.Optional;

/**
 * The generic interface for a command processor.
 *
 * @param <S> The type of simulator.
 * @param <T> The type of shape.
 * @param <L> The type of logger.
 */
public interface CommandProcessor<S extends Simulator, T extends Shape, L extends Logger> {

    /**
     * Processes the command with the provided command values, simulator, shape, and logger.
     *
     * @param commandValues The array of command values.
     * @param simulator     The simulator instance.
     * @param shape         The shape instance.
     * @param logger        The logger instance.
     * @return An optional string representing the result of the command processing.
     */
    Optional<String> processCommand(String[] commandValues, S simulator, T shape, L logger);
}

