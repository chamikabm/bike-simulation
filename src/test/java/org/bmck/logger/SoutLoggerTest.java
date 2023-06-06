package org.bmck.logger;

import org.bmck.utils.ConfigUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.bmck.constants.BikeSimulatorConstants.SYSTEM_LOGGING_ENABLED_KEY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class SoutLoggerTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalSystemOut = System.out;
    private SoutLogger logger;

    @BeforeEach
    void setUp() {
        try (MockedStatic<ConfigUtil> ignored = mockStatic(ConfigUtil.class)) {
            when(ConfigUtil.getBooleanProperty(SYSTEM_LOGGING_ENABLED_KEY)).thenReturn(true);
            logger = new SoutLogger();
            System.setOut(new PrintStream(outputStream));
        }
    }

    @AfterEach
    public void cleanup() {
        System.setOut(originalSystemOut);
    }

    @Test
    void info() {
        logger.info("Test Info Message");
        assertEquals("[INFO] Test Info Message" + System.lineSeparator(), outputStream.toString());
    }

    @Test
    void warn() {
        logger.warn("Test Warn Message");
        assertEquals("[WARN] Test Warn Message" + System.lineSeparator(), outputStream.toString());
    }

    @Test
    void error() {
        logger.error("Test Error Message");
        assertEquals("[ERROR] Test Error Message" + System.lineSeparator(), outputStream.toString());
    }
}