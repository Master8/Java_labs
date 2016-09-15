package com.michael.lab4;

import java.util.ArrayList;

/**
 * Created by maste on 15.09.2016.
 */
public class PolygonalChain
{
    private ArrayList<Point> points = new ArrayList<>();

    public void addPoint(Point point)
    {
        points.add(point);
    }

    public Point getPoint(int index)
    {
        return points.get(index);
    }

    public double calculateLength()
    {
        double length = 0;

        for (int i = 0; i < points.size() - 1; i++)
            length += points.get(i).calculateDistance(points.get(i + 1));

        return length;
    }

    public ArrayList<Point> getPoints(Point targetPoint)
    {
        ArrayList<Point> result = new ArrayList<>();

        for (Point point : points)
        {
            if (point.equals(targetPoint))
                result.add(point);
        }

        return result;
    }

    @Override
    public String toString()
    {
        String result = "";

        for (Point point : points)
        {
            result += point.toString() + " - ";
        }

        return result;
    }
}
