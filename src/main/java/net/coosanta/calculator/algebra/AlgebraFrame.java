package net.coosanta.calculator.algebra;

import net.coosanta.calculator.CalculatorFrame;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.swing.*;
import java.awt.*;

public class AlgebraFrame extends CalculatorFrame {
    protected JTextArea inputArea;
    protected JPanel displayPanel;

    public AlgebraFrame(Dimension frameSize, Point location) {
        super(frameSize, location);
    }

    @Override
    protected JPanel centerPanelBuilder() {
        // Create a panel to hold title, image, and button
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Stack components vertically

        // Add a title above the image
        JLabel titleLabel = new JLabel("Advanced Graphing and Algebra Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the title horizontally

        // Text are for input
        inputArea = new JTextArea(2, 20);
        inputArea.setFont(new Font("Serif", Font.PLAIN, 20));
        JScrollPane inputAreaScrollPane = new JScrollPane(inputArea);

        // Display panel for rendering LaTeX
        displayPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                renderLaTeX((Graphics2D) g, inputArea.getText());
            }
        };

        JScrollPane displayPanelScrollArea = new JScrollPane(displayPanel);

        // Listen for changes in the input area and update the display panel
        inputArea.addCaretListener(e -> displayPanel.repaint());

        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(inputAreaScrollPane);
        centerPanel.add(displayPanelScrollArea);

        return centerPanel;
    }

    private void renderLaTeX(Graphics2D g, String input) {
        try {
            TeXFormula formula = new TeXFormula(input);
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 48);

            // Set preferred size based on the rendered icon size
            displayPanel.setPreferredSize(new Dimension(icon.getIconWidth() + 100, icon.getIconHeight() + 100));
            displayPanel.revalidate();

            icon.paintIcon(displayPanel, g, 50, 50);
        } catch (Exception e) {
            g.setFont(new Font("Serif", Font.PLAIN, 24));
            g.setColor(Color.RED);
            g.drawString("Invalid LaTeX: " + e.getMessage(), 50, 100);
        }
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
            new AlgebraFrame(getSize(), getLocation());
            dispose();
        });

        bottomPanel.add(label); // Components Added using Flow Layout
        bottomPanel.add(returnButton);
        bottomPanel.add(resetButton);


        return bottomPanel;
    }
}
