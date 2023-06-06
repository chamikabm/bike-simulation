package org.bmck.logger;

import org.bmck.utils.ConfigUtil;

import static org.bmck.constants.BikeSimulatorConstants.SYSTEM_LOGGING_ENABLED_KEY;

/**
 * Implementation of the Logger interface that logs messages to the standard output.
 */
public class SoutLogger implements Logger {
    private final boolean loggingEnabled;

    /**
     * Constructs a SoutLogger and initializes the loggingEnabled flag based on the system configuration.
     */
    public SoutLogger() {
        loggingEnabled = ConfigUtil.getBooleanProperty(SYSTEM_LOGGING_ENABLED_KEY);
    }

    /**
     * Logs an informational message.
     *
     * @param message The message to be logged.
     */
    @Override
    public void info(String message) {
        if (loggingEnabled) {
            System.out.println("[INFO] " + message);
        }
    }

    /**
     * Logs a warning message.
     *
     * @param message The message to be logged.
     */
    @Override
    public void warn(String message) {
        if (loggingEnabled) {
            System.out.println("[WARN] " + message);
        }
    }

    /**
     * Logs an error message.
     *
     * @param message The message to be logged.
     */
    @Override
    public void error(String message) {
        if (loggingEnabled) {
            System.out.println("[ERROR] " + message);
        }
    }
}
