package com.michael.lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Solution
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Photos");
        frame.setPreferredSize(new Dimension(1500, 1000));
        frame.setResizable(false);

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        frame.setLayout(layout);

        ImageIcon image = new ImageIcon("images/14.jpg");
        JLabel label = new JLabel(image);

        JButton button1 = new JButton("photo 1");
        JButton button2 = new JButton("photo 2");
        JButton button3 = new JButton("photo 3");
        JButton button4 = new JButton("photo 4");

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(label)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(button3)
                        .addComponent(button4)));

        //layout.linkSize(SwingConstants.HORIZONTAL, button1, button2, button3, button4);

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(label)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(button3)
                        .addComponent(button4)));

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
