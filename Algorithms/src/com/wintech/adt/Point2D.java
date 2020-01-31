/**
 * @author Prabu
 * @date Mar 20, 2012
 * 
 *  Compilation:  javac Point2D.java
 *
 *  Immutable point data type for points in the plane.
 */
package com.wintech.adt;

public class Point2D {

    private final double x;     // x coordinate
    private final double y;     // y coordinate
    
    // Create a new point (x, y)
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // Return the x-coordinate of this point
    public double x() { return x; }
    
    // Return the y-coordinate of this point
    public double y() { return y; }
    
    // Return the radius of this point in polar coordinates
    public double r() { return Math.sqrt(x*x + y*y); }
}
