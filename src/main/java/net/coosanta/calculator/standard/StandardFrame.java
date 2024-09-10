package net.coosanta.calculator.standard;

import net.coosanta.calculator.CalculatorFrame;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.*;
import java.awt.*;

public class StandardFrame extends CalculatorFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public StandardFrame(Dimension frameSize, Point location) {
        super(frameSize, location, "Standard Calculator");
    }

    @Override
    protected JPanel centerPanelBuilder() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Standard Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Text field for input (one-line)
        inputField = new JTextField();
        inputField.setFont(new Font("Serif", Font.PLAIN, 20));
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, inputField.getPreferredSize().height));

        // Result label to show the output
        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Equals button
        JButton equalsButton = new JButton("Equals");
        equalsButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        equalsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        equalsButton.addActionListener(e -> calculateAndDisplayResult());

        // Also can press Enter to calculate
        inputField.addActionListener(e -> calculateAndDisplayResult());

        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(inputField);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(equalsButton);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(resultLabel);

        return centerPanel;
    }

    private void calculateAndDisplayResult() {
        try {
            // Get the input from the text field, trimmed to prevent leading and trailing spaces
            String input = inputField.getText().trim();

            // Check if the input is valid
            if (!input.matches("[0-9+\\-*/.()\\s]+")) {
                resultLabel.setText("Error: Invalid Input");
                return;
            }

            double result = evaluateExpression(input);

            // Display the result
            resultLabel.setText("Result: " + result);

        } catch (ArithmeticException e) {
            resultLabel.setText("Error: Division by Zero");
        } catch (Exception e) {
            resultLabel.setText("Error: Invalid Expression");
        }
    }

    private double evaluateExpression(String expression) {
        Expression expressionizedExpression = new ExpressionBuilder(expression).build();
        return expressionizedExpression.evaluate();
    }

    @Override
    protected void createNewFrame() {
        new StandardFrame(getSize(), getLocation());
    }
}
