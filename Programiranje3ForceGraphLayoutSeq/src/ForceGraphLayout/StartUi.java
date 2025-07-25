package ForceGraphLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUi extends JPanel {
    private JTextField nodeCountField;
    private JTextField widthField;
    private JTextField heightField;
    private JCheckBox showUIRadioButton;
    private JButton startButton;
    private JFrame parentFrame; // Reference to the parent JFrame

    public StartUi(int width, int height, JFrame parentFrame) {
        this.parentFrame = parentFrame; // Store the parent frame
        setPreferredSize(new Dimension(width, height));
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Node Count:"));
        nodeCountField = new JTextField("100");
        add(nodeCountField);

        add(new JLabel("Width:"));
        widthField = new JTextField("1080");
        add(widthField);

        add(new JLabel("Height:"));
        heightField = new JTextField("800");
        add(heightField);

        add(new JLabel("Show UI:"));
        showUIRadioButton = new JCheckBox();
        showUIRadioButton.setSelected(true);
        add(showUIRadioButton);

        startButton = new JButton("Start");
        add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nodeCount = Integer.parseInt(nodeCountField.getText());
                int width = Integer.parseInt(widthField.getText());
                int height = Integer.parseInt(heightField.getText());
                boolean showUI = showUIRadioButton.isSelected();

                // Close the StartUi frame
                parentFrame.dispose();

                // Run the main application directly (sequentially)
                try {
                    Main.startApplication(nodeCount, width, height, showUI);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}