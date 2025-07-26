package ForceGraphLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUi extends JPanel {
    private JTextField nodeCountField;
    private JTextField edgeCountField;
    private JTextField iterationCountField;
    private JTextField widthField;
    private JTextField heightField;
    private JCheckBox showUIRadioButton;
    private JButton startButton;
    private JFrame parentFrame;

    public StartUi(int width, int height, JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setPreferredSize(new Dimension(width, height));
        setLayout(new GridLayout(8, 2)); // Adjust for added fields

        // Node Count
        add(new JLabel("Node Count:"));
        nodeCountField = new JTextField("100");
        add(nodeCountField);

        // Edge Count
        add(new JLabel("Edge Count:"));
        edgeCountField = new JTextField("200");
        add(edgeCountField);

        // Iteration Count
        add(new JLabel("Iterations:"));
        iterationCountField = new JTextField("500");
        add(iterationCountField);

        // Width
        add(new JLabel("Width:"));
        widthField = new JTextField("1080");
        add(widthField);

        // Height
        add(new JLabel("Height:"));
        heightField = new JTextField("800");
        add(heightField);

        // Show UI Checkbox
        add(new JLabel("Show UI:"));
        showUIRadioButton = new JCheckBox();
        showUIRadioButton.setSelected(true);
        add(showUIRadioButton);

        // Start Button
        startButton = new JButton("Start");
        add(startButton);
        add(new JLabel()); // Filler for grid alignment

        // Start Button Listener
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nodeCount = Integer.parseInt(nodeCountField.getText());
                int edgeCount = Integer.parseInt(edgeCountField.getText());
                int iterations = Integer.parseInt(iterationCountField.getText());
                int width = Integer.parseInt(widthField.getText());
                int height = Integer.parseInt(heightField.getText());
                boolean showUI = showUIRadioButton.isSelected();

                parentFrame.dispose();

                try {
                    Main.startApplication(nodeCount, edgeCount, iterations, width, height, showUI);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
