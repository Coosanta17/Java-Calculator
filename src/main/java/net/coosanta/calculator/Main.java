package net.coosanta.calculator;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Set screen size to 3/4 of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * 0.75);
        int height = (int) (screenSize.getHeight() * 0.75);
        Dimension frameSize = new Dimension(width, height);

        // Set center of screen
        Point centerPoint = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int windowX = centerPoint.x - (width/2);
        int windowY = centerPoint.y - (height/2);
        Point adjustedCenterPoint = new Point(windowX, windowY);

        new CalculatorFrame(frameSize, adjustedCenterPoint);
    }
}
