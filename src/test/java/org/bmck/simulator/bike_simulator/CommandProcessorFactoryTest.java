package org.bmck.simulator.bike_simulator;

import org.bmck.enums.ValidCommand;
import org.bmck.logger.SoutLogger;
import org.bmck.shapes.SquareGrid;
import org.bmck.simulator.CommandProcessor;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandProcessorFactoryTest {

    private CommandProcessorFactory commandProcessorFactory;

    @BeforeEach
    void setUp() {
        commandProcessorFactory = new CommandProcessorFactory();
    }

    @Test
    void testCreateCommandProcessor() {
        // Test PLACE command processor
        CommandProcessor<BikeSimulator, SquareGrid, SoutLogger> placeProcessor =
                commandProcessorFactory.createCommandProcessor(ValidCommand.PLACE);
        assertNotNull(placeProcessor);
        assertTrue(placeProcessor instanceof PlaceCommandProcessor);

        // Test FORWARD command processor
        CommandProcessor<BikeSimulator, SquareGrid, SoutLogger> forwardProcessor =
                commandProcessorFactory.createCommandProcessor(ValidCommand.FORWARD);
        assertNotNull(forwardProcessor);
        assertTrue(forwardProcessor instanceof ForwardCommandProcessor);

        // Test TURN_LEFT command processor
        CommandProcessor<BikeSimulator, SquareGrid, SoutLogger> turnLeftProcessor =
                commandProcessorFactory.createCommandProcessor(ValidCommand.TURN_LEFT);
        assertNotNull(turnLeftProcessor);
        assertTrue(turnLeftProcessor instanceof TurnLeftCommandProcessor);

        // Test TURN_RIGHT command processor
        CommandProcessor<BikeSimulator, SquareGrid, SoutLogger> turnRightProcessor =
                commandProcessorFactory.createCommandProcessor(ValidCommand.TURN_RIGHT);
        assertNotNull(turnRightProcessor);
        assertTrue(turnRightProcessor instanceof TurnRightCommandProcessor);

        // Test GPS_REPORT command processor
        CommandProcessor<BikeSimulator, SquareGrid, SoutLogger> gpsReportProcessor =
                commandProcessorFactory.createCommandProcessor(ValidCommand.GPS_REPORT);
        assertNotNull(gpsReportProcessor);
        assertTrue(gpsReportProcessor instanceof GPSReportCommandProcessor);

    }
}
