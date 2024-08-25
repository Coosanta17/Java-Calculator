package net.coosanta.calculator;

import net.coosanta.calculator.standard.StandardFrame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class CalculatorFrame extends JFrame {
    protected static final URL PLACEHOLDER_IMAGE = Objects.requireNonNull(Main.class.getResource("/placeholder.png"));

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

        // Create a button below the image
        JButton standardCalculatorButton = new JButton("Standard Calculator");
        standardCalculatorButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12)); // Set the button text to be smaller
        standardCalculatorButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button horizontally

        standardCalculatorButton.addActionListener(e -> {
            // Close the current window
            dispose();
            // Open the standard calculator
            new StandardFrame(getSize(), getLocation());
        });

        // Add spacing between components
        centerPanel.add(Box.createVerticalStrut(20)); // Add space above the title
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(10)); // Add space between the title and image
        centerPanel.add(imageLabel);
        centerPanel.add(Box.createVerticalStrut(10)); // Add space between the image and button
        centerPanel.add(standardCalculatorButton);
        centerPanel.add(Box.createVerticalStrut(20)); // Add space below the button

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
