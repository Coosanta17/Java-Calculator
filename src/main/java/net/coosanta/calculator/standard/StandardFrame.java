package net.coosanta.calculator.standard;

import net.coosanta.calculator.CalculatorFrame;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class StandardFrame extends CalculatorFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private short iHateThisIHateThisHelpHelpHelpHelp;

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
            resultLabel.setText(wittyError(true));
            System.out.println("Bro just tried to divide by zero");
        } catch (Exception e) {
            resultLabel.setText(wittyError(false));
        }
    }

    private double evaluateExpression(String expression) {
        Expression expressionizedExpression = new ExpressionBuilder(expression).build();
        return expressionizedExpression.evaluate();
    }

    // If you don't like bad code skip this method and the next.
    private String wittyError(boolean isDivisionByZero) {
        Random seed = new Random(Math.round(Math.random()*Long.MAX_VALUE));
        Random random = new Random(seed.nextLong(Long.MIN_VALUE, Long.MAX_VALUE)); // The random number generator seed needs a random number generator with seed made by a random number generator!!!!!!
        String response = ""; // Idk why the string needs to be empty since it will be filled before any operations are done on it

        if (isDivisionByZero) {
            if (iHateThisIHateThisHelpHelpHelpHelp >= 1 && iHateThisIHateThisHelpHelpHelpHelp < 3) {
                int option = random.nextInt(7);
                response = switch (option) {
                    case 0,3 -> "I told you already!!";
                    case 1,6 -> "Bro stop!";
                    case 2,4 -> "Stop it.";
                    case 5 -> "You've tried to divide by zero " + iHateThisIHateThisHelpHelpHelpHelp + " times!!";
                    default -> "HelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelp";
                };
            } else if (iHateThisIHateThisHelpHelpHelpHelp >= 3 && iHateThisIHateThisHelpHelpHelpHelp < Short.MAX_VALUE) {
                response = "You've tried to divide by zero " + iHateThisIHateThisHelpHelpHelpHelp + " times!!";
            } else if (iHateThisIHateThisHelpHelpHelpHelp == Short.MAX_VALUE) {
                final Point centerPoint = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

                this.setVisible(false);
                JDialog whatTheFuckDude = new JDialog(this, "You've divided by zero too much!");

                whatTheFuckDude.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                final int fatness = this.getWidth();
                final int tallness = this.getHeight();
                int thingX = (int) Math.round(
                        Math.max(
                                fatness / 3.0,
                                100
                        )
                );
                int thingY = (int) Math.round(
                        Math.max(
                                tallness / 3.0,
                                50
                        )
                );
                whatTheFuckDude.setSize(thingX, thingY);

                int adjustedX = centerPoint.x - (thingX / 2);
                int adjustedY = centerPoint.y - (thingY / 2);
                whatTheFuckDude.setLocation(adjustedX,adjustedY);

                final JPanel thePanelOrSomethingLikeThat = divisionByZeroDialogPanelCreatorThing();

                whatTheFuckDude.add(thePanelOrSomethingLikeThat);
                whatTheFuckDude.setVisible((((((((((((((((((((((
                        ((((((((((((((((((((((((((((((((((
                                ((((((((((((((((((((((((((((((((((((((((((((((
                                        ((((((((((((((((((((((((((((((((true)))))))))))
                                        ))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))
                                )))))))))))))))))))))))))))))))))))))))
                        ))))))))))))))))))))))));
                whatTheFuckDude.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        System.exit(0);
                    }
                });
            }
            else {
                int option = random.nextInt(6);
                response = switch (option) {
                    case 0, 1 -> "idk bro";
                    case 2 -> "try it yourself";
                    case 3 -> "I'd like to see you try";
                    case 4 -> "infinity or something";
                    case 5 -> "I don't feel like it";
                    default -> "If you see this then you have broken something";
                };
            }
            iHateThisIHateThisHelpHelpHelpHelp += 1;
            response = response + " (Error: Division by Zero)";

        } else {
            int option = random.nextInt(3);
            response = switch (option) {
                case 0 -> "I can't read what you write";
                case 1 -> "Illegible math";
                case 2 -> "Believe it or not, math is required to calculate math.";
                default -> "yesyesyesyesyesyesyesyesyesyesyesyesyesyesyesyesyesyesyes";
            };
            response = response + " (Error: Invalid Expression)";
        }
        return response;
    }

    private static JPanel divisionByZeroDialogPanelCreatorThing() {
        JLabel kdfjgturjkfjdsjfj = new JLabel("Congratulation! You have reached the divide by zero limit!");
        JLabel floesdosowoewewpeopaodeed = new JLabel("The program will now terminate.");
        JButton toGetToTheOtherSize = new JButton("Ok");
        JButton toGetToTheIdiotsHouseKnockKnockWhosThereTheChickenChickenWhoChickenSaysYouAreAnIdiotIfYouThinkYouCanFixThis = new JButton("Ok");

        toGetToTheOtherSize.addActionListener(ppVerySmallHaHaMicrosoftGetIt -> System.exit(0));
        toGetToTheIdiotsHouseKnockKnockWhosThereTheChickenChickenWhoChickenSaysYouAreAnIdiotIfYouThinkYouCanFixThis.addActionListener(Q_Q -> System.exit(0));

        JPanel thePanelOrSomethingLikeThat = new JPanel();
        JPanel whyDidTheChickenCrossTheRoad = new JPanel();

        thePanelOrSomethingLikeThat.setLayout(new BoxLayout(thePanelOrSomethingLikeThat, BoxLayout.Y_AXIS));

        whyDidTheChickenCrossTheRoad.add(toGetToTheOtherSize);
        whyDidTheChickenCrossTheRoad.add(toGetToTheIdiotsHouseKnockKnockWhosThereTheChickenChickenWhoChickenSaysYouAreAnIdiotIfYouThinkYouCanFixThis);;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

        thePanelOrSomethingLikeThat.add(kdfjgturjkfjdsjfj);
        thePanelOrSomethingLikeThat.add(floesdosowoewewpeopaodeed);
        thePanelOrSomethingLikeThat.add(whyDidTheChickenCrossTheRoad);
        return thePanelOrSomethingLikeThat;
    }

    @Override
    protected void createNewFrame() {
        new StandardFrame(getSize(), getLocation());
    }
}
