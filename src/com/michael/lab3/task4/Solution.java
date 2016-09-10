package com.michael.lab3.task4;

/**
 * Created by maste on 10.09.2016.
 */
public class Solution
{
    public static void main(String[] args)
    {
        float a = 0.3f;
        float b = 0.4f;
        float sum = a + b;
        float c = 0.7f;
        float d = 1.0f/0.0f;
        float n = 0.0f/0.0f;

        System.out.println(compareNumber(sum, c, 6));
    }

    public static boolean compareNumber(float a, float b, int precision)
    {
        if (Float.isInfinite(a) && Float.isInfinite(b))
            return true;

        if (Float.isNaN(a) && Float.isNaN(b))
            return true;

        return Math.abs(a - b) < Math.pow(10, precision * (-1));
    }
}
