package org.bmck.shapes;

import org.bmck.points.Locatable;

/**
 * Abstract class representing a grid.
 *
 * @param <T> The type of locatable object used in the grid.
 */
public abstract class Grid<T extends Locatable> implements Shape {
    private final T minPoint;
    private final T maxPoint;

    /**
     * Constructs a Grid with the specified minimum and maximum points.
     *
     * @param minPoint The minimum point of the grid.
     * @param maxPoint The maximum point of the grid.
     */
    public Grid(T minPoint, T maxPoint) {
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

    /**
     * Retrieves the minimum point of the grid.
     *
     * @return The minimum point as a locatable object.
     */
    public T getMinPoint() {
        return minPoint;
    }

    /**
     * Retrieves the maximum point of the grid.
     *
     * @return The maximum point as a locatable object.
     */
    public T getMaxPoint() {
        return maxPoint;
    }

    /**
     * Checks if a given point is on the grid.
     *
     * @param point The point to check.
     * @return true if the point is on the grid, false otherwise.
     */
    public abstract boolean isOnTheGrid(T point);
}
