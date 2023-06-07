package org.bmck.simulator.bike_simulator;

import org.bmck.enums.ValidDirection;
import org.bmck.logger.SoutLogger;
import org.bmck.points.Coordinate;
import org.bmck.shapes.SquareGrid;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PlaceCommandProcessorTest {

    @Test
    void testProcessCommand_ValidCommand() {
        // Create the necessary mock objects
        BikeSimulator simulator = mock(BikeSimulator.class);
        SquareGrid shape = mock(SquareGrid.class);
        SoutLogger logger = mock(SoutLogger.class);

        // Set up the command values
        String[] commandValues = {"PLACE", "2", "3", "NORTH"};

        // Set up the mock objects
        when(shape.isOnTheGrid(any(Coordinate.class))).thenReturn(true);

        PlaceCommandProcessor commandProcessor = new PlaceCommandProcessor();

        // Invoke the processCommand method
        Optional<String> result = commandProcessor.processCommand(commandValues, simulator, shape, logger);

        // Verify the result
        assertTrue(result.isEmpty());

        // Verify that the mock objects were interacted with correctly
        verify(shape).isOnTheGrid(new Coordinate(2, 3));
        verify(simulator).setCoordinate(new Coordinate(2, 3));
        verify(simulator).setPlaced(true);
        verify(simulator).setFacing(ValidDirection.getFacingCoordinates(ValidDirection.NORTH));
        verifyNoMoreInteractions(simulator, shape, logger);
    }

    @Test
    void testProcessCommand_InvalidCommand() {
        // Create the necessary mock objects
        BikeSimulator simulator = mock(BikeSimulator.class);
        SquareGrid shape = mock(SquareGrid.class);
        SoutLogger logger = mock(SoutLogger.class);

        // Set up the command values
        String[] commandValues = {"PLACE", "2", "3"};

        PlaceCommandProcessor commandProcessor = new PlaceCommandProcessor();

        // Invoke the processCommand method
        Optional<String> result = commandProcessor.processCommand(commandValues, simulator, shape, logger);

        // Verify the result
        assertTrue(result.isEmpty());

        // Verify that the mock objects were interacted with correctly
        verify(logger).warn("Invalid command");
        verifyNoMoreInteractions(simulator, shape, logger);
    }

    @Test
    void testProcessCommand_InvalidCoordinates() {
        // Create the necessary mock objects
        BikeSimulator simulator = mock(BikeSimulator.class);
        SquareGrid shape = mock(SquareGrid.class);
        SoutLogger logger = mock(SoutLogger.class);

        // Set up the command values
        String[] commandValues = {"PLACE", "5", "6", "NORTH"};

        // Set up the mock objects
        when(shape.isOnTheGrid(any(Coordinate.class))).thenReturn(false);

        PlaceCommandProcessor commandProcessor = new PlaceCommandProcessor();

        // Invoke the processCommand method
        Optional<String> result = commandProcessor.processCommand(commandValues, simulator, shape, logger);

        // Verify the result
        assertTrue(result.isEmpty());

        // Verify that the mock objects were interacted with correctly
        verify(logger).warn("Bike must be placed on the grid.");
        verify(shape).isOnTheGrid(new Coordinate(5, 6));
        verifyNoMoreInteractions(simulator, shape, logger);
    }

    @Test
    void testProcessCommand_InvalidFacingDirection() {
        // Create the necessary mock objects
        BikeSimulator simulator = mock(BikeSimulator.class);
        SquareGrid shape = mock(SquareGrid.class);
        SoutLogger logger = mock(SoutLogger.class);

        // Set up the command values
        String[] commandValues = {"PLACE", "2", "3", "INVALID"};

        // Set up the mock objects
        when(shape.isOnTheGrid(any(Coordinate.class))).thenReturn(true);

        PlaceCommandProcessor commandProcessor = new PlaceCommandProcessor();

        // Invoke the processCommand method
        Optional<String> result = commandProcessor.processCommand(commandValues, simulator, shape, logger);

        // Verify the result
        assertTrue(result.isEmpty());

        // Verify that the mock objects were interacted with correctly
        verify(logger).warn("Invalid command");
    }

}
