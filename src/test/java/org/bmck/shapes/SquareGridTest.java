package org.bmck.shapes;

import org.bmck.points.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SquareGridTest {

    @Test
    void isOnTheGrid() {
        // Create a SquareGrid with minCoordinate (0, 0) and maxCoordinate (7, 7)
        SquareGrid squareGrid = new SquareGrid(new Coordinate(0, 0), new Coordinate(7, 7));

        // Test case 1: Coordinate within the grid
        Coordinate coordinate1 = new Coordinate(2, 3);
        assertTrue(squareGrid.isOnTheGrid(coordinate1));

        // Test case 2: Coordinate outside the grid (negative x value)
        Coordinate coordinate2 = new Coordinate(-1, 3);
        assertFalse(squareGrid.isOnTheGrid(coordinate2));

        // Test case 3: Coordinate outside the grid (x value greater than max x)
        Coordinate coordinate3 = new Coordinate(8, 3);
        assertFalse(squareGrid.isOnTheGrid(coordinate3));

        // Test case 4: Coordinate outside the grid (negative y value)
        Coordinate coordinate4 = new Coordinate(2, -1);
        assertFalse(squareGrid.isOnTheGrid(coordinate4));

        // Test case 5: Coordinate outside the grid (y value greater than max y)
        Coordinate coordinate5 = new Coordinate(2, 8);
        assertFalse(squareGrid.isOnTheGrid(coordinate5));

        // Test case 7: Coordinate on the min boundary of the grid
        Coordinate coordinate6 = new Coordinate(0, 0);
        assertTrue(squareGrid.isOnTheGrid(coordinate6));

        // Test case 8: Coordinate on the max boundary of the grid
        Coordinate coordinate7 = new Coordinate(7, 7);
        assertTrue(squareGrid.isOnTheGrid(coordinate7));

        // Test case 9: Coordinate outside the grid (x value equal to max x, y value greater than max y)
        Coordinate coordinate8 = new Coordinate(7, 8);
        assertFalse(squareGrid.isOnTheGrid(coordinate8));
    }
}