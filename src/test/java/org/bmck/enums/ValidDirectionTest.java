package org.bmck.enums;

import org.bmck.points.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}