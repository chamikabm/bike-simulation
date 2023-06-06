package org.bmck.points;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinateTest {

    @Test
    void getPrintableLocation() {
        // Test case 1: Coordinate with positive values
        Coordinate coordinate1 = new Coordinate(2, 3);
        String expected1 = "(2,3)";
        String actual1 = coordinate1.getPrintableLocation();
        assertEquals(expected1, actual1);

        // Test case 2: Coordinate with negative values
        Coordinate coordinate2 = new Coordinate(-1, -4);
        String expected2 = "(-1,-4)";
        String actual2 = coordinate2.getPrintableLocation();
        assertEquals(expected2, actual2);

        // Test case 3: Coordinate with zero values
        Coordinate coordinate3 = new Coordinate(0, 0);
        String expected3 = "(0,0)";
        String actual3 = coordinate3.getPrintableLocation();
        assertEquals(expected3, actual3);
    }
}