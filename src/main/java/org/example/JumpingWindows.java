package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JumpingWindows extends JFrame {

    private JLabel label;
    private Timer timer;
    private int deltaX = 1;
    private int deltaY = 1;

    public JumpingWindows(String name, int x, int y) {
        super("OPETANY PRZEZ JASPERA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(x, y);

        label = new JLabel();
        label.setIcon(new ImageIcon(name));
        add(label);
        setLocation(randomStartingPoint());

        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);

        startTimer();
    }

    private Point randomStartingPoint() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int maxX = (int) screenSize.getWidth() - getWidth();
        int maxY = (int) screenSize.getHeight() - getHeight();

        int randomX = (int) (Math.random() * maxX);
        int randomY = (int) (Math.random() * maxY);

        return new Point(randomX, randomY);
    }

    private void startTimer() {
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point currentLocation = getLocation();
                int newX = currentLocation.x + deltaX;
                int newY = currentLocation.y + deltaY;

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                if (newX < 0 || newX + getWidth() > screenSize.width) {
                    deltaX *= -1;
                }
                if (newY < 0 || newY + getHeight() > screenSize.height) {
                    deltaY *= -1;
                }

                setLocation(newX, newY);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        jump();
    }

    static public void jump(){

        for (int i = 0; i < 100; i++) {
            SwingUtilities.invokeLater(() -> new JumpingWindows("1.gif",500,500));
            SwingUtilities.invokeLater(() -> new JumpingWindows("3.gif",500,500));
            SwingUtilities.invokeLater(() -> new JumpingWindows("4.gif",500,500));
            SwingUtilities.invokeLater(() -> new JumpingWindows("5.gif",500,500));
            SwingUtilities.invokeLater(() -> new JumpingWindows("6.gif",500,500));
            SwingUtilities.invokeLater(() -> new JumpingWindows("7.gif",500,500));

        }

    }
}