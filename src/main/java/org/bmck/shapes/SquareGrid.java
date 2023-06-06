package org.bmck.shapes;

import org.bmck.points.Coordinate;

/**
 * A square grid implementation of the Grid class.
 */
public class SquareGrid extends Grid<Coordinate> {

    /**
     * Constructs a SquareGrid with the specified minimum and maximum coordinates.
     *
     * @param minCoordinate The minimum coordinate of the grid.
     * @param maxCoordinate The maximum coordinate of the grid.
     */
    public SquareGrid(Coordinate minCoordinate, Coordinate maxCoordinate) {
        super(minCoordinate, maxCoordinate);
    }

    /**
     * Checks if the given coordinate is within the boundaries of the square grid.
     *
     * @param coordinate the coordinate to check
     * @return true if the coordinate is within the grid boundaries, false otherwise
     */
    @Override
    public boolean isOnTheGrid(Coordinate coordinate) {
        int x = coordinate.x();
        int y = coordinate.y();

        int minX = this.getMinPoint().x();
        int minY = this.getMinPoint().y();
        int maxX = this.getMaxPoint().x();
        int maxY = this.getMaxPoint().y();

        return x >= 0 && y >= 0 && x >= minX && x <= maxX && y >= minY && y <= maxY;
    }
}
