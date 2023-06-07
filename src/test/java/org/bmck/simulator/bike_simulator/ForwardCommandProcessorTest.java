package org.bmck.simulator.bike_simulator;

import org.bmck.logger.SoutLogger;
import org.bmck.points.Coordinate;
import org.bmck.shapes.SquareGrid;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ForwardCommandProcessorTest {

    @Test
    void testProcessCommand_MoveForwardSuccessfully() {
        // Create mock objects
        BikeSimulator simulator = mock(BikeSimulator.class);
        SquareGrid shape = mock(SquareGrid.class);
        SoutLogger logger = mock(SoutLogger.class);

        // Set up the simulator and shape
        Coordinate currentCoordinate = new Coordinate(5, 5);
        Coordinate facing = new Coordinate(0, 1);
        Coordinate nextCoordinate = new Coordinate(5, 6);
        when(simulator.getCoordinate()).thenReturn(currentCoordinate);
        when(simulator.getFacing()).thenReturn(facing);
        when(shape.isOnTheGrid(nextCoordinate)).thenReturn(true);

        // Create the command processor instance
        ForwardCommandProcessor commandProcessor = new ForwardCommandProcessor();

        // Process the command
        String[] commandValues = new String[0];
        commandProcessor.processCommand(commandValues, simulator, shape, logger);

        // Verify that the getCoordinate and getFacing methods were invoked
        verify(simulator).setCoordinate(nextCoordinate);
    }

    @Test
    void testProcessCommand_BikeFallsOffGrid() {
        // Create mock objects
        BikeSimulator simulator = mock(BikeSimulator.class);
        SquareGrid shape = mock(SquareGrid.class);
        SoutLogger logger = mock(SoutLogger.class);

        // Set up the simulator and shape
        Coordinate currentCoordinate = new Coordinate(0, 0);
        Coordinate facing = new Coordinate(0, 1);
        Coordinate nextCoordinate = new Coordinate(0, 2);
        when(simulator.getCoordinate()).thenReturn(currentCoordinate);
        when(simulator.getFacing()).thenReturn(facing);
        when(shape.isOnTheGrid(nextCoordinate)).thenReturn(false);

        // Create the command processor instance
        ForwardCommandProcessor commandProcessor = new ForwardCommandProcessor();

        // Process the command
        String[] commandValues = new String[0];
        commandProcessor.processCommand(commandValues, simulator, shape, logger);

        // Verify that the logger is called
        verify(logger).warn("Cannot move forward, bike will fall off the grid.");

        // Verify that the getCoordinate and getFacing methods were invoked
        verify(simulator).getCoordinate();
        verify(simulator).getFacing();
    }
}
