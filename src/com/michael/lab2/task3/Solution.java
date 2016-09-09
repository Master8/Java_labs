package com.michael.lab2.task3;

/**
 * Created by maste on 09.09.2016.
 */
public class Solution
{
    public static void main(String[] args)
    {
        int numberDec = Integer.parseInt(args[0], Integer.parseInt(args[1]));

        System.out.println(args[0] + " (" + args[1] + ")");
        System.out.println(numberDec + " (10)");
        System.out.println(Integer.toString(numberDec, Integer.parseInt(args[2])) + " (" + args[2] + ")");
    }
}
