package org.bmck.simulator.bike_simulator;

import org.bmck.logger.SoutLogger;
import org.bmck.points.Coordinate;
import org.bmck.shapes.SquareGrid;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TurnLeftCommandProcessorTest {

    @Test
    void testProcessCommand() {
        // Create the necessary mock objects
        BikeSimulator simulator = mock(BikeSimulator.class);
        SquareGrid shape = mock(SquareGrid.class);
        SoutLogger logger = mock(SoutLogger.class);

        // Set up the command values
        String[] commandValues = {"TURN_LEFT"};

        // Set up the mock objects
        when(simulator.getFacing()).thenReturn(new Coordinate(0, 1));

        TurnLeftCommandProcessor commandProcessor = new TurnLeftCommandProcessor();

        // Invoke the processCommand method
        Optional<String> result = commandProcessor.processCommand(commandValues, simulator, shape, logger);

        // Verify the result
        assertTrue(result.isEmpty());

        // Verify that the mock objects were interacted with correctly
        verify(simulator).getFacing();
        verify(simulator).setFacing(new Coordinate(-1, 0));
        verifyNoMoreInteractions(simulator, shape, logger);
    }
}
