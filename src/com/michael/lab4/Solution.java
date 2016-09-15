package com.michael.lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by maste on 15.09.2016.
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        boolean isContinue = true;

        while (isContinue)
        {
            PolygonalChain polygonalChain = new PolygonalChain();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int count = 0;
            double x = 0, y = 0;

            System.out.println("Введите количество точек:");
            count = Integer.parseInt(reader.readLine());

            for (int i = 0; i < count; i++)
            {
                System.out.println("Введите x:");
                x = Double.parseDouble(reader.readLine());

                System.out.println("Введите y:");
                y = Double.parseDouble(reader.readLine());

                polygonalChain.addPoint(new Point(x, y));
            }

            System.out.println(polygonalChain.toString());
            System.out.println("Длинна: " + polygonalChain.calculateLength());

            System.out.println("Выберите точку");
            System.out.println("Введите x:");
            x = Double.parseDouble(reader.readLine());

            System.out.println("Введите y:");
            y = Double.parseDouble(reader.readLine());

            ArrayList<Point> list = polygonalChain.getPoints(new Point(x, y));

            for (Point point : list)
            {
                System.out.println(point.toString());
            }

            System.out.println("Выйти? yes/no");
            String answer = reader.readLine();

            if (answer.equals("yes"))
                isContinue = false;
        }
    }
}
