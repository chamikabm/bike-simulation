package org.bmck.simulator.bike_simulator;

import org.bmck.enums.ValidDirection;
import org.bmck.logger.SoutLogger;
import org.bmck.points.Coordinate;
import org.bmck.shapes.SquareGrid;
import org.bmck.utils.DirectionUtil;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GPSReportCommandProcessorTest {

    @Test
    void testProcessCommand_ValidFacingDirection() {
        // Create the necessary mock objects
        BikeSimulator simulator = mock(BikeSimulator.class);
        SquareGrid shape = mock(SquareGrid.class);
        SoutLogger logger = mock(SoutLogger.class);

        // Set up the mock objects
        Coordinate coordinate = new Coordinate(3, 4);
        when(simulator.getCoordinate()).thenReturn(coordinate);
        when(simulator.getFacing()).thenReturn(new Coordinate(0, 1));

        // Mock the static method using mockito-inline
        try (MockedStatic<DirectionUtil> directionUtilMock = mockStatic(DirectionUtil.class)) {
            directionUtilMock.when(() -> DirectionUtil.getFacingDirection(any(Coordinate.class)))
                    .thenReturn(Optional.of(ValidDirection.NORTH));

            GPSReportCommandProcessor commandProcessor = new GPSReportCommandProcessor();

            // Invoke the processCommand method
            Optional<String> result = commandProcessor.processCommand(new String[0], simulator, shape, logger);

            // Verify the result
            assertTrue(result.isPresent());
            assertEquals("(3,4), NORTH", result.get());

            // Verify that the mock objects were interacted with correctly
            verify(logger, never()).warn(anyString());
            verify(simulator).getCoordinate();
            verify(simulator).getFacing();
            verifyNoMoreInteractions(simulator, shape, logger);
        }
    }

    @Test
    void testProcessCommand_InvalidFacingDirection() {
        // Create the necessary mock objects
        BikeSimulator simulator = mock(BikeSimulator.class);
        SquareGrid shape = mock(SquareGrid.class);
        SoutLogger logger = mock(SoutLogger.class);

        // Set up the mock objects
        Coordinate coordinate = new Coordinate(3, 4);
        when(simulator.getCoordinate()).thenReturn(coordinate);
        when(simulator.getFacing()).thenReturn(new Coordinate(1, 0)); // Invalid facing direction

        // Mock the static method using mockito-inline
        try (MockedStatic<DirectionUtil> directionUtilMock = mockStatic(DirectionUtil.class)) {
            directionUtilMock.when(() -> DirectionUtil.getFacingDirection(any(Coordinate.class)))
                    .thenReturn(Optional.empty());

            GPSReportCommandProcessor commandProcessor = new GPSReportCommandProcessor();

            // Invoke the processCommand method
            Optional<String> result = commandProcessor.processCommand(new String[0], simulator, shape, logger);

            // Verify the result
            assertTrue(result.isEmpty());

            // Verify that the mock objects were interacted with correctly
            verify(logger).warn("Invalid facing direction");
            verify(simulator).getCoordinate();
            verify(simulator).getFacing();
            verifyNoMoreInteractions(simulator, shape, logger);
        }
    }
}
