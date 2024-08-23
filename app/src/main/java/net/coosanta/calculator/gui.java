package net.coosanta.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

class gui {
    public static void main(String[] args) {
        // Set screen size to 3/4 of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * 0.75);
        int height = (int) (screenSize.getHeight() * 0.75);

        // Create frame
        JFrame jframe = new JFrame("Calculator");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(width, height);
        jframe.setLocationRelativeTo(null); // Center the frame

        // Load panels
        JMenuBar menuBar = createMenuBar();
        JPanel centerPanel = createCenterPanel();
        JPanel bottomPanel = createBottomPanel();

        // Wrap the centerPanel in a panel with GridBagLayout to center it
        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // Center the content
        wrapperPanel.add(centerPanel, gbc);

        //Adding Components to the frame using border layout.
        jframe.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        jframe.getContentPane().add(BorderLayout.NORTH, menuBar);
        jframe.getContentPane().add(BorderLayout.CENTER, wrapperPanel);

        jframe.setVisible(true);
    }

    private static JMenuBar createMenuBar() {
        // Create menubar button
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("FILE");
        menuBar.add(fileMenu);

        // create options in the FILE menu
        JMenuItem[] fileMenuItems = new JMenuItem[5];
        fileMenuItems[0] = new JMenuItem("Save");
        fileMenuItems[1] = new JMenuItem("Quit");
        fileMenuItems[2] = new JMenuItem("Open");
        fileMenuItems[3] = new JMenuItem("New");
        fileMenuItems[4] = new JMenuItem("Help");

        for (JMenuItem fileMenuItem : fileMenuItems) {
            fileMenu.add(fileMenuItem);
        }
        return menuBar;
    }

    private static JPanel createCenterPanel() {
        // Create a panel to hold title, image, and button
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Stack components vertically

        // Add a title above the image
        JLabel titleLabel = new JLabel("Title Text", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Set the title to be bold and larger
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the title horizontally

        // Load an image in the center
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(gui.class.getResource("/placeholder.png")));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the image horizontally

        // Create a button below the image
        JButton button = new JButton("Button Text");
        button.setFont(new Font("Arial", Font.PLAIN, 12)); // Set the button text to be smaller
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button horizontally

        // Add spacing between components (so much repetition 😭)
        centerPanel.add(Box.createVerticalStrut(20)); // Add space above the title
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(10)); // Add space between the title and image
        centerPanel.add(imageLabel);
        centerPanel.add(Box.createVerticalStrut(10)); // Add space between the image and button
        centerPanel.add(button);
        centerPanel.add(Box.createVerticalStrut(20)); // Add space below the button

        return centerPanel;
    }

    private static JPanel createBottomPanel() {
        // Create the panel at bottom
        JPanel bottomPanel = new JPanel();

        JLabel label = new JLabel("Bottom Text");
        // JTextField textField = new JTextField(15); // accepts upto 15 characters
        // JButton btn_send = new JButton("Send");
        // JButton btn_reset = new JButton("Reset");
        bottomPanel.add(label); // Components Added using Flow Layout
        // bottomPanel.add(textField);
        // bottomPanel.add(btn_send);
        // bottomPanel.add(btn_reset);

        return bottomPanel;
    }
}
