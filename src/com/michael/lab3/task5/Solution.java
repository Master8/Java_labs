package com.michael.lab3.task5;

/**
 * Created by maste on 10.09.2016.
 */
public class Solution
{
    public static void main(String[] args)
    {
        float f1 = 0.0f/1.0f;
        float f2 = 0.0f/-1.0f;
        System.out.println("f1="+f1);
        System.out.println("f2="+f2);
        System.out.println("f1==f2: "+ compareNumber(f1, f2));
    }

    public static boolean compareNumber(float a, float b)
    {
        if (Float.isInfinite(a) && Float.isInfinite(b))
            return true;

        if (Float.isNaN(a) && Float.isNaN(b))
            return true;

        if (Float.floatToIntBits(a) != Float.floatToIntBits(b))
            return false;

        return Math.abs(a - b) < Math.pow(10, 6 * (-1));
    }
}
