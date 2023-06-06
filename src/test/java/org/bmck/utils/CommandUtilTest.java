package org.bmck.utils;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CommandUtilTest {

    @Test
    void testGetCommandValues() {
        // Test case 1: Valid command with comma-separated values
        String command1 = "cmd1,cmd2,cmd3";
        String[] expected1 = {"cmd1", "cmd2", "cmd3"};
        Optional<String[]> actual1 = CommandUtil.getCommandValues(command1);
        assertArrayEquals(expected1, actual1.get());

        // Test case 2: Valid command with space-separated values
        String command2 = "cmd1 cmd2 cmd3";
        String[] expected2 = {"cmd1", "cmd2", "cmd3"};
        Optional<String[]> actual2 = CommandUtil.getCommandValues(command2);
        assertArrayEquals(expected2, actual2.get());

        // Test case 3: Valid command with mixed comma and space-separated values
        String command3 = "cmd1, cmd2 cmd3";
        String[] expected3 = {"cmd1", "cmd2", "cmd3"};
        Optional<String[]> actual3 = CommandUtil.getCommandValues(command3);
        assertArrayEquals(expected3, actual3.get());

        // Test case 4: Empty command
        String command4 = "";
        Optional<String[]> actual4 = CommandUtil.getCommandValues(command4);
        assertNull(actual4.orElse(null));

        // Test case 5: Null command, Throws error but return null
        String command5 = null;
        Optional<String[]> actual5 = CommandUtil.getCommandValues(command5);
        assertNull(actual5.orElse(null));
    }
}