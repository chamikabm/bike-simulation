package org.bmck.enums;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ValidCommandTest {

    @Test
    void fromString() {
        // Test case 1: Valid command "PLACE"
        String value1 = "PLACE";
        ValidCommand expected1 = ValidCommand.PLACE;
        Optional<ValidCommand> actual1 = ValidCommand.fromString(value1);
        assertEquals(expected1, actual1.get());

        // Test case 2: Valid command "FORWARD"
        String value2 = "FORWARD";
        ValidCommand expected2 = ValidCommand.FORWARD;
        Optional<ValidCommand> actual2 = ValidCommand.fromString(value2);
        assertEquals(expected2, actual2.get());

        // Test case 3: Valid command "TURN_LEFT"
        String value3 = "TURN_LEFT";
        ValidCommand expected3 = ValidCommand.TURN_LEFT;
        Optional<ValidCommand> actual3 = ValidCommand.fromString(value3);
        assertEquals(expected3, actual3.get());

        // Test case 4: Valid command "TURN_RIGHT"
        String value4 = "TURN_RIGHT";
        ValidCommand expected4 = ValidCommand.TURN_RIGHT;
        Optional<ValidCommand> actual4 = ValidCommand.fromString(value4);
        assertEquals(expected4, actual4.get());

        // Test case 5: Valid command "GPS_REPORT"
        String value5 = "GPS_REPORT";
        ValidCommand expected5 = ValidCommand.GPS_REPORT;
        Optional<ValidCommand> actual5 = ValidCommand.fromString(value5);
        assertEquals(expected5, actual5.get());

        // Test case 6: Invalid command "INVALID_COMMAND"
        String value6 = "INVALID_COMMAND";
        Optional<ValidCommand> actual6 = ValidCommand.fromString(value6);
        assertNull(actual6.orElse(null));

        // Test case 7: Null command
        String value7 = null;
        Optional<ValidCommand> actual7 = ValidCommand.fromString(value7);
        assertNull(actual7.orElse(null));
    }
}