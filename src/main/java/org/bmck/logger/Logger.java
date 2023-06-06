package org.bmck.logger;

/**
 * Interface for a logger.
 */
public interface Logger {
    /**
     * Logs an informational message.
     *
     * @param message The message to log.
     */
    void info(String message);

    /**
     * Logs a warning message.
     *
     * @param message The message to log.
     */
    void warn(String message);

    /**
     * Logs an error message.
     *
     * @param message The message to log.
     */
    void error(String message);
}
