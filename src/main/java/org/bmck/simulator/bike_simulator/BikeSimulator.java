package org.bmck.simulator.bike_simulator;

import org.bmck.simulator.Simulator;
import org.bmck.utils.CommandUtil;

import java.util.Optional;

/**
 * The main BikeSimulator implementation of the Simulator interface.
 */
public class BikeSimulator implements Simulator {

    @Override
    public Optional<String> processCommand(String command) {
        String[] commandValues = CommandUtil.getCommandValues(command);
        System.out.println(commandValues);

        return Optional.empty();
    }
}
