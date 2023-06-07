package org.bmck.enums;

import org.bmck.points.Coordinate;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ValidDirectionTest {

    @Test
    void getFacingCoordinates() {
        // Test case 1: Valid direction "NORTH"
        ValidDirection direction1 = ValidDirection.NORTH;
        Coordinate expected1 = new Coordinate(0, 1);
        Coordinate actual1 = ValidDirection.getFacingCoordinates(direction1);
        assertEquals(expected1.x(), actual1.x());
        assertEquals(expected1.y(), actual1.y());

        // Test case 2: Valid direction "EAST"
        ValidDirection direction2 = ValidDirection.EAST;
        Coordinate expected2 = new Coordinate(1, 0);
        Coordinate actual2 = ValidDirection.getFacingCoordinates(direction2);
        assertEquals(expected2.x(), actual2.x());
        assertEquals(expected2.y(), actual2.y());

        // Test case 3: Valid direction "SOUTH"
        ValidDirection direction3 = ValidDirection.SOUTH;
        Coordinate expected3 = new Coordinate(0, -1);
        Coordinate actual3 = ValidDirection.getFacingCoordinates(direction3);
        assertEquals(expected3.x(), actual3.x());
        assertEquals(expected3.y(), actual3.y());

        // Test case 4: Valid direction "WEST"
        ValidDirection direction4 = ValidDirection.WEST;
        Coordinate expected4 = new Coordinate(-1, 0);
        Coordinate actual4 = ValidDirection.getFacingCoordinates(direction4);
        assertEquals(expected4.x(), actual4.x());
        assertEquals(expected4.y(), actual4.y());
    }

    @Test
    void fromString() {
        // Test case 1: Valid direction "NORTH"
        String value1 = "NORTH";
        ValidDirection expected1 = ValidDirection.NORTH;
        Optional<ValidDirection> actual1 = ValidDirection.fromString(value1);
        assertEquals(expected1, actual1.get());

        // Test case 2: Valid direction "EAST"
        String value2 = "EAST";
        ValidDirection expected2 = ValidDirection.EAST;
        Optional<ValidDirection> actual2 = ValidDirection.fromString(value2);
        assertEquals(expected2, actual2.get());

        // Test case 3: Valid direction "SOUTH"
        String value3 = "SOUTH";
        ValidDirection expected3 = ValidDirection.SOUTH;
        Optional<ValidDirection> actual3 = ValidDirection.fromString(value3);
        assertEquals(expected3, actual3.get());

        // Test case 4: Valid direction "WEST"
        String value4 = "WEST";
        ValidDirection expected4 = ValidDirection.WEST;
        Optional<ValidDirection> actual4 = ValidDirection.fromString(value4);
        assertEquals(expected4, actual4.get());

        // Test case 5: Invalid direction "INVALID_DIRECTION"
        String value5 = "INVALID_DIRECTION";
        Optional<ValidDirection> actual5 = ValidDirection.fromString(value5);
        assertNull(actual5.orElse(null));

        // Test case 6: Null direction
        String value6 = null;
        Optional<ValidDirection> actual6 = ValidDirection.fromString(value6);
        assertNull(actual6.orElse(null));
    }
}