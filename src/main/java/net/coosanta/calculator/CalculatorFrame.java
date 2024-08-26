package net.coosanta.calculator;

import net.coosanta.calculator.algebra.AlgebraFrame;
import net.coosanta.calculator.standard.StandardFrame;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame(Dimension frameSize, Point location) {
        super("Calculator");
        setSize(frameSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(location);

        loadPanels();

        setVisible(true);
    }

    protected void loadPanels() {
        // Load panels
        getContentPane().add(BorderLayout.NORTH, menuBarBuilder());
        getContentPane().add(BorderLayout.CENTER, centerPanelBuilder());
        getContentPane().add(BorderLayout.SOUTH, bottomPanelBuilder());
    }

    protected JMenuBar menuBarBuilder() {
        JMenuBar menuBar = new JMenuBar();

        // Define menus, their items, and corresponding actions in a nested LinkedHashMap
        Map<String, Map<String, Runnable>> menus = new LinkedHashMap<>();

        // If you do not like Lambdas do not read the following section.

        // File menu
        Map<String, Runnable> fileMenuItems = new LinkedHashMap<>();
        fileMenuItems.put("New", () -> System.out.println("New"));
        fileMenuItems.put("Open", () -> System.out.println("Open"));
        fileMenuItems.put("Save", () -> System.out.println("Save"));
        fileMenuItems.put("Help", () -> System.out.println("Help"));
        fileMenuItems.put("Quit", () -> System.exit(0));
        menus.put("FILE", fileMenuItems);

        // Edit menu
        Map<String, Runnable> editMenuItems = new LinkedHashMap<>();
        editMenuItems.put("Cut", () -> System.out.println("Cut"));
        editMenuItems.put("Copy", () -> System.out.println("Copy"));
        editMenuItems.put("Paste", () -> System.out.println("Paste"));
        menus.put("EDIT", editMenuItems);

        // View menu
        Map<String, Runnable> viewMenuItems = new LinkedHashMap<>();
        viewMenuItems.put("Zoom In", () -> System.out.println("Zoom In"));
        viewMenuItems.put("Zoom Out", () -> System.out.println("Zoom Out"));
        viewMenuItems.put("Fullscreen", () -> System.out.println("Fullscreen"));
        menus.put("VIEW", viewMenuItems);

        // Create menus and their items
        menus.forEach((menuName, menuItems) -> {
            JMenu menu = new JMenu(menuName);
            menuItems.forEach((itemName, action) -> {
                JMenuItem menuItem = new JMenuItem(itemName);
                menuItem.addActionListener(e -> action.run());
                menu.add(menuItem);
            });
            menuBar.add(menu);
        });

        return menuBar;
    }

    protected JPanel centerPanelBuilder() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Stack components vertically

        // Add a title above the image
        JLabel titleLabel = new JLabel("Select Calculator!!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the title horizontally

        // Create buttons below the image
        JButton standardCalculatorButton = new JButton("Standard Calculator");
        standardCalculatorButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        standardCalculatorButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton advancedAlgebraAndGraphingCalculatorButton = new JButton("Algebra and Graphing Calculator");
        advancedAlgebraAndGraphingCalculatorButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        advancedAlgebraAndGraphingCalculatorButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        standardCalculatorButton.addActionListener(e -> {
            new StandardFrame(getSize(), getLocation());
            dispose();
        });
        advancedAlgebraAndGraphingCalculatorButton.addActionListener(e -> {
            new AlgebraFrame(getSize(), getLocation());
            dispose();
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(standardCalculatorButton);
        buttonsPanel.add(Box.createHorizontalStrut(10)); // Add space between buttons
        buttonsPanel.add(advancedAlgebraAndGraphingCalculatorButton);

        // Add spacing between components
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(10)); // Useless??
        centerPanel.add(buttonsPanel);

        return centerPanel;
    }

    protected JPanel bottomPanelBuilder() {
        // Create the panel at bottom
        JPanel bottomPanel = new JPanel();

        JLabel label = new JLabel("Bottom Text");
        // JTextField textField = new JTextField(15); // accepts up to 15 characters
        // JButton btn_send = new JButton("Send");
        // JButton btn_reset = new JButton("Reset");
        bottomPanel.add(label); // Components Added using Flow Layout
        // bottomPanel.add(textField);
        // bottomPanel.add(btn_send);
        // bottomPanel.add(btn_reset);

        return bottomPanel;
    }
}
