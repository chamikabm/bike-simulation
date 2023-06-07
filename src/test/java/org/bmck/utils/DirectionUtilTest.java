package org.bmck.utils;

import org.bmck.enums.ValidDirection;
import org.bmck.points.Coordinate;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DirectionUtilTest {

    @Test
    void getFacingDirection() {
        // Test case 1: Coordinate (0, 1) should return ValidDirection.NORTH
        Coordinate coordinate1 = new Coordinate(0, 1);
        ValidDirection expected1 = ValidDirection.NORTH;
        Optional<ValidDirection> actual1 = DirectionUtil.getFacingDirection(coordinate1);
        assertEquals(expected1, actual1.orElse(null));

        // Test case 2: Coordinate (1, 0) should return ValidDirection.EAST
        Coordinate coordinate2 = new Coordinate(1, 0);
        ValidDirection expected2 = ValidDirection.EAST;
        Optional<ValidDirection> actual2 = DirectionUtil.getFacingDirection(coordinate2);
        assertEquals(expected2, actual2.orElse(null));

        // Test case 3: Coordinate (0, -1) should return ValidDirection.SOUTH
        Coordinate coordinate3 = new Coordinate(0, -1);
        ValidDirection expected3 = ValidDirection.SOUTH;
        Optional<ValidDirection> actual3 = DirectionUtil.getFacingDirection(coordinate3);
        assertEquals(expected3, actual3.orElse(null));

        // Test case 4: Coordinate (-1, 0) should return ValidDirection.WEST
        Coordinate coordinate4 = new Coordinate(-1, 0);
        ValidDirection expected4 = ValidDirection.WEST;
        Optional<ValidDirection> actual4 = DirectionUtil.getFacingDirection(coordinate4);
        assertEquals(expected4, actual4.orElse(null));

        // Test case 5: Invalid coordinate, no matching direction found, should return null
        Coordinate coordinate5 = new Coordinate(2, 2);
        Optional<ValidDirection> actual5 = DirectionUtil.getFacingDirection(coordinate5);
        assertNull(actual5.orElse(null));
    }
}