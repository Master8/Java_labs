package com.michael.lab2.task2;

/**
 * Created by maste on 09.09.2016.
 */
public class Solution
{
    public static void main(String[] args)
    {
        int leftOperand = Integer.parseInt(args[0]);
        int rightOperand = Integer.parseInt(args[2]);
        String operation = args[1];

        System.out.println(count(leftOperand, rightOperand, operation));
    }

    public static int count(int leftOperand, int rightOperand, String operation)
    {
        switch (operation)
        {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                return leftOperand / rightOperand;
        }

        return 0;
    }
}
