package org.bmck.simulator.bike_simulator;

import org.bmck.enums.ValidCommand;
import org.bmck.simulator.Simulator;
import org.bmck.utils.CommandUtil;

import java.util.Optional;

/**
 * The main BikeSimulator implementation of the Simulator interface.
 */
public class BikeSimulator implements Simulator {

    @Override
    public Optional<String> processCommand(String command) {
        Optional<String[]> commandValues = CommandUtil.getCommandValues(command);

        if (commandValues.isEmpty()) {
            System.out.println("You must provide a valid command to progress.");
            return Optional.empty();
        }

        Optional<ValidCommand> inputCommand = ValidCommand.fromString(commandValues.get()[0]);
        if (inputCommand.isEmpty()) {
            System.out.println("Invalid command");
            return Optional.empty();
        }

        return Optional.empty();
    }
}
