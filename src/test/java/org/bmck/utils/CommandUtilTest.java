package org.bmck.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CommandUtilTest {

    @Test
    void testGetCommandValues() {
        // Test case 1: Valid command with comma-separated values
        String command1 = "cmd1,cmd2,cmd3";
        String[] expected1 = {"cmd1", "cmd2", "cmd3"};
        String[] actual1 = CommandUtil.getCommandValues(command1);
        assertArrayEquals(expected1, actual1);

        // Test case 2: Valid command with space-separated values
        String command2 = "cmd1 cmd2 cmd3";
        String[] expected2 = {"cmd1", "cmd2", "cmd3"};
        String[] actual2 = CommandUtil.getCommandValues(command2);
        assertArrayEquals(expected2, actual2);

        // Test case 3: Valid command with mixed comma and space-separated values
        String command3 = "cmd1, cmd2 cmd3";
        String[] expected3 = {"cmd1", "cmd2", "cmd3"};
        String[] actual3 = CommandUtil.getCommandValues(command3);
        assertArrayEquals(expected3, actual3);

        // Test case 4: Empty command
        String command4 = "";
        String[] expected4 = null;
        String[] actual4 = CommandUtil.getCommandValues(command4);
        assertArrayEquals(expected4, actual4);

        // Test case 5: Null command, Throws error but return null
        String command5 = null;
        String[] expected5 = null;
        String[] actual5 = CommandUtil.getCommandValues(command5);
        assertArrayEquals(expected5, actual5);
    }
}