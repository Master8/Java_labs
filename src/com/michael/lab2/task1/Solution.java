package com.michael.lab2.task1;

/**
 * Created by maste on 09.09.2016.
 */
public class Solution
{
    public static void main(String[] args)
    {
        for (String arg : args)
        {
            long number = Long.parseLong(arg);
            System.out.println(number + " = " + defineType(number));
        }
    }

    public static String defineType(long number)
    {
        if (number >= -128 && number <= 127)
            return "byte";
        if (number >= -32768 && number <= 32767)
            return "short";
        if (number >= -2147483648  && number <= 2147483647)
            return "int";

        return "long";
    }
}
