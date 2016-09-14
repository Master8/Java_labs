package com.michael.lab3.task6;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by maste on 10.09.2016.
 */
public class Solution
{
    public static void main(String[] args)
    {
        float sum = 500; // 500 руб. на счете
        float percent = 0.00000001f;  // 0.000001% ежемесячно

        sum *= 1 + percent * 12;

        System.out.println("Сумма на счете через год: " + sum);


        BigDecimal sumD = new BigDecimal("500"); // 500 руб. на счете
        BigDecimal percentD = new BigDecimal("0.00000001");  // 0.000001% ежемесячно

        // Считаем проценты за год
        for(int i = 1; i <= 12; i++)
            sumD = sumD.add(sumD.multiply(percentD));

        System.out.println("Сумма на счете через год: " + sumD);
    }
}
