package org.example;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;


import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Locale;

import static org.example.Method.addFromField;
import static org.example.Method.playSound;

public class MainFrame extends JFrame {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JTextField TextField;
    private JPanel mainPanel;
    private JPanel MainPanel;
    private JPanel Input;
    private JButton endButton;
    private JTextField inputTextField;
    private JButton putButton;
    private JLabel status;
    private JPanel Output;
    private JLabel infoLabel;


    public MainFrame() {
        LinkedList<Integer> measures = new LinkedList<>();
        setContentPane(mainPanel);
        setTitle("MyPulsev105");
        setSize(500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setIconImage(new ImageIcon("logo.png").getImage());
        inputTextField.setBorder(null);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoLabel.setVisible(false);
                Input.setVisible(true);
            }
        });
        putButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addFromField(inputTextField.getText(), status) > 0)
                    measures.add(addFromField(inputTextField.getText(), status));
            }
        });
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input.setVisible(false);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input.setVisible(false);
                setLabelText(measures.toString(), infoLabel);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input.setVisible(false);
                setLabelText("Work in progress", infoLabel);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input.setVisible(false);
                setLabelText("Usunieto ostatni pomiar", infoLabel);
                measures.remove(measures.size() - 1);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input.setVisible(false);
                setLabelText("Usunieto wszystkie pomiary", infoLabel);
                measures.clear();
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input.setVisible(false);
                if (measures.isEmpty()) setLabelText("Tablica jest pusta", infoLabel);
                else {
                    Double average = 0.0;
                    for (Integer measure : measures) {
                        average += measure;
                    }
                    average /= measures.size();
                    setLabelText("Srednia z pomiarow:" + average, infoLabel);
                }
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input.setVisible(false);
                if (measures.isEmpty()) setLabelText("Tablica jest pusta", infoLabel);
                else {
                    LinkedList<Integer> xMeasures = new LinkedList<>(measures);
                    Double Median = 0.0;
                    xMeasures.sort(Comparator.naturalOrder());
                    if (xMeasures.size() % 2 == 0)
                        Median = (double) ((xMeasures.get(xMeasures.size() / 2 - 1) + xMeasures.get(xMeasures.size() / 2)) / 2);
                    else Median = (double) (xMeasures.get(xMeasures.size() / 2));
                    setLabelText("Mediana z pomiarow wynosi " + Median, infoLabel);
                }
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input.setVisible(false);
                String tooSmallMeasures = "";
                String tooHighMeasures = "";
                String normalMeasures = "";
                for (Integer measure : measures) {
                    if (measure < 60) tooSmallMeasures += " " + measure;
                    else if (measure < 120) normalMeasures += " " + measure;
                    else tooHighMeasures += " " + measure;

                }
                setLabelText("za male pomiary:" + tooSmallMeasures + "\n" + "normalne pomiary:" + normalMeasures + "\n" + "za duze pomiary:" + tooHighMeasures + "\n" + "najmniejszy pomiar:" + Collections.min(measures) + "\n" + "najwiekszy pomiar:" + Collections.max(measures), infoLabel);
            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JumpingWindows.jump();
                playSound(new File("aha1.wav"));
            }
        });
    }

    public static void main(String[] args) {
        new MainFrame();

    }

    private static void setLabelText(String xd, JLabel label) {
        label.setText("<html>" + xd.replaceAll("\n", "<br>") + "</html>");
        label.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(13, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setBackground(new Color(-16777216));
        mainPanel.setMaximumSize(new Dimension(500, 950));
        mainPanel.setPreferredSize(new Dimension(500, 950));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Vladimir Script", Font.PLAIN, 50, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-65536));
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(10);
        label1.setIcon(new ImageIcon(getClass().getResource("/serce.gif")));
        label1.setIconTextGap(7);
        label1.setText("MyPulse v1.05");
        label1.setVerticalAlignment(1);
        mainPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(500, 100), null, 0, false));
        button1 = new JButton();
        button1.setBackground(new Color(-65536));
        button1.setBorderPainted(false);
        button1.setFocusable(false);
        Font button1Font = this.$$$getFont$$$("Times New Roman", Font.BOLD, 25, button1.getFont());
        if (button1Font != null) button1.setFont(button1Font);
        button1.setForeground(new Color(-16777216));
        button1.setText("Wpisz recznie pomiary");
        mainPanel.add(button1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(380, 25), new Dimension(380, 25), 0, false));
        button2 = new JButton();
        button2.setBackground(new Color(-65536));
        button2.setBorderPainted(false);
        button2.setFocusable(false);
        Font button2Font = this.$$$getFont$$$("Times New Roman", Font.BOLD, 25, button2.getFont());
        if (button2Font != null) button2.setFont(button2Font);
        button2.setForeground(new Color(-16777216));
        button2.setText("Wczytaj pomiary z pliku");
        mainPanel.add(button2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(380, 25), new Dimension(380, 25), 0, false));
        button3 = new JButton();
        button3.setBackground(new Color(-65536));
        button3.setBorderPainted(false);
        button3.setFocusable(false);
        Font button3Font = this.$$$getFont$$$("Times New Roman", Font.BOLD, 25, button3.getFont());
        if (button3Font != null) button3.setFont(button3Font);
        button3.setForeground(new Color(-16777216));
        button3.setText("Wypisz pomiary");
        mainPanel.add(button3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(380, 25), new Dimension(380, 25), 0, false));
        button4 = new JButton();
        button4.setBackground(new Color(-65536));
        button4.setBorderPainted(false);
        button4.setFocusable(false);
        Font button4Font = this.$$$getFont$$$("Times New Roman", Font.BOLD, 25, button4.getFont());
        if (button4Font != null) button4.setFont(button4Font);
        button4.setForeground(new Color(-16777216));
        button4.setText("Usun ostatni pomiar");
        mainPanel.add(button4, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(380, 25), new Dimension(380, 25), 0, false));
        button5 = new JButton();
        button5.setBackground(new Color(-65536));
        button5.setBorderPainted(false);
        button5.setFocusable(false);
        Font button5Font = this.$$$getFont$$$("Times New Roman", Font.BOLD, 25, button5.getFont());
        if (button5Font != null) button5.setFont(button5Font);
        button5.setForeground(new Color(-16777216));
        button5.setText("Usun wszystkie pomiary");
        mainPanel.add(button5, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(380, 25), new Dimension(380, 25), 0, false));
        button6 = new JButton();
        button6.setBackground(new Color(-65536));
        button6.setBorderPainted(false);
        button6.setFocusable(false);
        Font button6Font = this.$$$getFont$$$("Times New Roman", Font.BOLD, 25, button6.getFont());
        if (button6Font != null) button6.setFont(button6Font);
        button6.setForeground(new Color(-16777216));
        button6.setText("Srednia z pomiarow");
        mainPanel.add(button6, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(380, 25), new Dimension(380, 25), 0, false));
        button7 = new JButton();
        button7.setBackground(new Color(-65536));
        button7.setBorderPainted(false);
        button7.setFocusable(false);
        Font button7Font = this.$$$getFont$$$("Times New Roman", Font.BOLD, 25, button7.getFont());
        if (button7Font != null) button7.setFont(button7Font);
        button7.setForeground(new Color(-16777216));
        button7.setText("Mediana z pomiarow");
        mainPanel.add(button7, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(380, 25), new Dimension(380, 25), 0, false));
        button8 = new JButton();
        button8.setBackground(new Color(-65536));
        button8.setBorderPainted(false);
        button8.setFocusable(false);
        Font button8Font = this.$$$getFont$$$("Times New Roman", Font.BOLD, 25, button8.getFont());
        if (button8Font != null) button8.setFont(button8Font);
        button8.setForeground(new Color(-16777216));
        button8.setText("Ocen pomiary");
        mainPanel.add(button8, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(380, 25), new Dimension(380, 25), 0, false));
        button9 = new JButton();
        button9.setBackground(new Color(-65536));
        button9.setBorderPainted(false);
        button9.setFocusable(false);
        Font button9Font = this.$$$getFont$$$("Times New Roman", Font.BOLD, 25, button9.getFont());
        if (button9Font != null) button9.setFont(button9Font);
        button9.setForeground(new Color(-16777216));
        button9.setText("Zakoncz program");
        mainPanel.add(button9, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(380, 25), new Dimension(380, 25), 0, false));
        button10 = new JButton();
        button10.setBackground(new Color(-65536));
        button10.setBorderPainted(false);
        button10.setFocusable(false);
        Font button10Font = this.$$$getFont$$$("Times New Roman", Font.BOLD, 25, button10.getFont());
        if (button10Font != null) button10.setFont(button10Font);
        button10.setForeground(new Color(-16777216));
        button10.setText("???");
        mainPanel.add(button10, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(380, 25), new Dimension(380, 25), 0, false));
        MainPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout(0, 0));
        MainPanel.setBackground(new Color(-16777216));
        MainPanel.setVisible(true);
        mainPanel.add(MainPanel, new GridConstraints(12, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 300), null, 0, false));
        Output = new JPanel();
        Output.setLayout(new GridBagLayout());
        Output.setOpaque(false);
        Output.setPreferredSize(new Dimension(500, 300));
        Output.setVisible(true);
        MainPanel.add(Output, BorderLayout.NORTH);
        infoLabel = new JLabel();
        Font infoLabelFont = this.$$$getFont$$$("Rage Italic", Font.BOLD, 40, infoLabel.getFont());
        if (infoLabelFont != null) infoLabel.setFont(infoLabelFont);
        infoLabel.setForeground(new Color(-65536));
        infoLabel.setHorizontalAlignment(2);
        infoLabel.setHorizontalTextPosition(2);
        infoLabel.setPreferredSize(new Dimension(500, 300));
        infoLabel.setText("");
        infoLabel.setVisible(true);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        Output.add(infoLabel, gbc);
        Input = new JPanel();
        Input.setLayout(new GridBagLayout());
        Input.setBackground(new Color(-16777216));
        Input.setMaximumSize(new Dimension(500, 950));
        Input.setPreferredSize(new Dimension(500, 200));
        Input.setVisible(false);
        mainPanel.add(Input, new GridConstraints(11, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        endButton = new JButton();
        endButton.setBackground(new Color(-65536));
        endButton.setBorderPainted(false);
        endButton.setFocusable(false);
        Font endButtonFont = this.$$$getFont$$$("Rage Italic", Font.BOLD, 25, endButton.getFont());
        if (endButtonFont != null) endButton.setFont(endButtonFont);
        endButton.setForeground(new Color(-16777216));
        endButton.setLabel("Zakoncz");
        endButton.setMargin(new Insets(0, 0, 0, 0));
        endButton.setPreferredSize(new Dimension(100, 40));
        endButton.setText("Zakoncz");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0, 0, 40, 0);
        Input.add(endButton, gbc);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-16777216));
        panel1.setPreferredSize(new Dimension(250, 80));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 10);
        Input.add(panel1, gbc);
        status = new JLabel();
        Font statusFont = this.$$$getFont$$$("Rage Italic", Font.BOLD, 25, status.getFont());
        if (statusFont != null) status.setFont(statusFont);
        status.setForeground(new Color(-65536));
        status.setHorizontalAlignment(2);
        status.setHorizontalTextPosition(2);
        status.setPreferredSize(new Dimension(100, 33));
        status.setText("");
        status.setVerticalAlignment(0);
        status.setVerticalTextPosition(0);
        panel1.add(status, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        inputTextField = new JTextField();
        inputTextField.setBackground(new Color(-65536));
        inputTextField.setFocusable(true);
        inputTextField.setForeground(new Color(-16777216));
        inputTextField.setHorizontalAlignment(0);
        inputTextField.setMargin(new Insets(3, 8, 3, 8));
        inputTextField.setMaximumSize(new Dimension(250, 40));
        inputTextField.setMinimumSize(new Dimension(250, 40));
        inputTextField.setPreferredSize(new Dimension(220, 40));
        panel1.add(inputTextField, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        putButton = new JButton();
        putButton.setBackground(new Color(-65536));
        putButton.setBorderPainted(false);
        putButton.setFocusable(false);
        Font putButtonFont = this.$$$getFont$$$("Rage Italic", Font.BOLD, 25, putButton.getFont());
        if (putButtonFont != null) putButton.setFont(putButtonFont);
        putButton.setForeground(new Color(-16777216));
        putButton.setLabel("Wpisz");
        putButton.setMargin(new Insets(0, 0, 0, 0));
        putButton.setPreferredSize(new Dimension(100, 40));
        putButton.setText("Wpisz");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0, 0, 40, 0);
        Input.add(putButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
