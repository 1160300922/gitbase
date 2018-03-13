/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P2.turtle;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
    	double angle = 0;
        if(sides < 3)
        {
        	System.out.println("wrong sides!");
        	System.exit(0);
        }
        else
        	angle = 180 * (sides - 2) / sides;
        return angle;
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        int sides;
        double side;
        side = 360 / (180 - angle);
        sides = (int) Math.rint(side);
        return sides;
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        double angle;
        angle = calculateRegularPolygonAngle(sides);
        for(int i = 0; i < sides; i++)
        {
        	turtle.forward(sideLength);
        	turtle.turn(angle);
        }
    }

    /**
     * Given the current direction, current location, and a target location, calculate the heading
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentHeading. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY,
                                                 int targetX, int targetY) {
        double r, angle, currentangle;
        r = Math.atan2(targetY - currentY, targetX - currentX);
        angle = Math.toDegrees(r);
        currentangle = 180 - angle - currentHeading;
        if(currentangle > 360)
        	currentangle = currentangle - 360;
        return currentangle;
    }

    /**
     * Given a sequence of points, calculate the heading adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateHeadingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
        List<Double> angles = new ArrayList<>();
        double r;
        List<Double> rangle = new ArrayList<>();
        for(int i = 2; i < xCoords.size(); i++)
        {
        	int x1 = xCoords.get(i - 1);
        	int x2 = xCoords.get(i);
        	int y1 = yCoords.get(i - 1);
        	int y2 = yCoords.get(i);
        	r = Math.atan2(y2 - y1, x2 - x1);
        	rangle.add(Math.toDegrees(r));
        }
        for(int i = 1; i < xCoords.size(); i++)
        {
        	int x1 = xCoords.get(i - 1);
        	int x2 = xCoords.get(i);
        	int y1 = yCoords.get(i - 1);
        	int y2 = yCoords.get(i);
        	angles.add(calculateHeadingToPoint(rangle.get(i - 1), x1, y1, x2, y2));
        }
        return angles;
    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
    	drawSquare(turtle, 40);
    	turtle.turn(90);
    	turtle.forward(40);
    	turtle.turn(90);
    	turtle.forward(40);
    	turtle.turn(315);
    	turtle.forward(60);
    	turtle.turn(225);
    	turtle.forward(40);
    	turtle.turn(180);
    	turtle.forward(40);
    	turtle.turn(90);
    	turtle.forward(40);
    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        drawSquare(turtle, 40);
        //drawPersonalArt(turtle);
        // draw the window
        turtle.draw();
    }

}
