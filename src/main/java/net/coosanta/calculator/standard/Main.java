package net.coosanta.calculator.standard;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void gui(Dimension frameSize) {
        System.out.println("Opening Standard Calculator GUI...");

        JFrame standardCalculatorFrame = new JFrame("Standard Calculator");
        standardCalculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        standardCalculatorFrame.setSize(frameSize);
        standardCalculatorFrame.setLocationRelativeTo(null);

        standardCalculatorFrame.setVisible(true);
    }
}
