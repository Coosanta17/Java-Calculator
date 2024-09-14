package net.coosanta.calculator;

import javax.swing.*;
import java.awt.*;

import static net.coosanta.calculator.Main.WINDOW_FRAME_NAME;

public abstract class CalculatorFrame extends WindowFrame {
    public CalculatorFrame(Dimension frameSize, Point location, String name){
        super(frameSize, location, name);
    }

    @Override
    protected JPanel bottomPanelBuilder() {
        // Create the panel at bottom
        JPanel bottomPanel = new JPanel();

        JLabel label = new JLabel("Bottom Text");

        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> {
            new WindowFrame(getSize(), getLocation(), WINDOW_FRAME_NAME);
            dispose();
        });

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            createNewFrame();
            dispose();
        });

        bottomPanel.add(label); // Components Added using Flow Layout
        bottomPanel.add(returnButton);
        bottomPanel.add(resetButton);


        return bottomPanel;
    }

    protected abstract void createNewFrame();
}
