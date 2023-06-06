package org.bmck.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.bmck.constants.BikeSimulatorConstants.CONFIG_FILE_PATH;

/**
 * Utility class for retrieving configuration properties.
 */
public class ConfigUtil {
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private ConfigUtil() {
        // Private constructor to prevent instantiation.
    }

    /**
     * Retrieves an integer property value based on the specified key.
     *
     * @param key The key of the property to retrieve.
     * @return The integer value of the property, or 0 if the property is not found or invalid.
     */
    public static int getIntProperty(String key) {
        return Integer.parseInt(getProperty(key));
    }

    /**
     * Retrieves a boolean property value based on the specified key.
     *
     * @param key The key of the property to retrieve.
     * @return The boolean value of the property, or false if the property is not found or invalid.
     */
    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }

    public static String getStringProperty(String key) {
        return getProperty(key);
    }

    /**
     * Retrieves a string property value based on the specified key.
     *
     * @param key The key of the property to retrieve.
     * @return The string value of the property, or an empty string if the property is not found.
     * @throws IllegalArgumentException if the value is not found for the given key
     */
    private static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            return value;
        }

        throw new IllegalArgumentException("Configuration not found for key: " + key);
    }

    /**
     * Uses to load the configuration files once when the class is loaded.
     */
    private static void loadProperties() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE_PATH))) {
            properties.load(reader);
        } catch (IOException e) {
            // Handle the exception as needed, Report the error to logging service or throw custom error.
            e.printStackTrace();
        }
    }
}
