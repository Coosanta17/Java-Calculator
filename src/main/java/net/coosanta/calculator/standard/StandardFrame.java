package net.coosanta.calculator.standard;

import net.coosanta.calculator.CalculatorFrame;

import javax.swing.*;
import java.awt.*;

public class StandardFrame extends CalculatorFrame {

    public StandardFrame(Dimension frameSize, Point location) {
        super(frameSize, location);
    }

    @Override
    protected JPanel centerPanelBuilder() {
        // Create a panel to hold title, image, and button
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Stack components vertically

        // Add a title above the image
        JLabel titleLabel = new JLabel("Title Text", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Papyrus", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the title horizontally

        // Load an image in the center
        ImageIcon placeholderIcon = new ImageIcon(PLACEHOLDER_IMAGE);
        JLabel imageLabel = new JLabel(placeholderIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the image horizontally

        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(imageLabel);

        return centerPanel;
    }

    @Override
    protected JPanel bottomPanelBuilder() {
        // Create the panel at bottom
        JPanel bottomPanel = new JPanel();

        JLabel label = new JLabel("Bottom Text");

        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> {
            new CalculatorFrame(getSize(), getLocation());
            dispose();
        });

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            new StandardFrame(getSize(), getLocation());
            dispose();
        });

        bottomPanel.add(label); // Components Added using Flow Layout
        bottomPanel.add(returnButton);
        bottomPanel.add(resetButton);


        return bottomPanel;
    }
}
