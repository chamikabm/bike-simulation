package org.bmck.simulator.bike_simulator;

import org.bmck.enums.ValidCommand;
import org.bmck.logger.SoutLogger;
import org.bmck.shapes.SquareGrid;
import org.bmck.simulator.CommandProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * The factory class for creating command processors based on the specified valid command.
 */
public class CommandProcessorFactory {
    private final Map<ValidCommand, CommandProcessor<BikeSimulator, SquareGrid, SoutLogger>> commandProcessors;

    /**
     * Constructs a CommandProcessorFactory and initializes the command processors map.
     */
    public CommandProcessorFactory() {
        // Initialize command processors
        commandProcessors = new HashMap<>();
        commandProcessors.put(ValidCommand.PLACE, new PlaceCommandProcessor());
        commandProcessors.put(ValidCommand.FORWARD, new ForwardCommandProcessor());
        commandProcessors.put(ValidCommand.TURN_LEFT, new TurnLeftCommandProcessor());
        commandProcessors.put(ValidCommand.TURN_RIGHT, new TurnRightCommandProcessor());
        commandProcessors.put(ValidCommand.GPS_REPORT, new GPSReportCommandProcessor());
    }

    /**
     * Creates a command processor for the specified valid command.
     *
     * @param command The valid command for which the command processor needs to be created.
     * @return The command processor for the specified valid command, or null if not found.
     */
    public CommandProcessor<BikeSimulator, SquareGrid, SoutLogger> createCommandProcessor(ValidCommand command) {
        return commandProcessors.get(command);
    }
}
