package ForceGraphLayout;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Initialize and show the StartUi
        JFrame startFrame = new JFrame("Force Layout Graph - Settings");
        StartUi startPanel = new StartUi(400, 300, startFrame); // Pass the frame reference
        startFrame.add(startPanel);
        startFrame.pack();
        startFrame.setVisible(true);
        startFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public static void startApplication(int nodeCount, int edgeCount, int iterations, int width, int height, boolean showUI) throws InterruptedException {
        long seed = 30;
        int seed1 = 40;

        Graph graph = new Graph(nodeCount, edgeCount, seed, width, height);
        FRAlgorithm alg = new FRAlgorithm(graph, iterations, width, height, seed1);

        JFrame frame = null;
        UI panel = null;

        if (showUI) {
            frame = new JFrame("Force Layout Graph");
            panel = new UI(graph);
            frame.add(panel);
            frame.setVisible(true);
            frame.setSize(width, height);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < iterations; i++) {
            if (!alg.run()) {
                Logger.log("Not a good idea to proceed so closing", LogLevel.Success);
                break;
            } else {
                Logger.log("i am in working", LogLevel.Info);
                if (showUI) {
                    panel.updateGraph();
                    panel.repaint();
                }
            }
        }

        long end = System.currentTimeMillis();
        Logger.log("Time used " + (end - start) + " ms, " + ((end - start) / 1000) + " s, "
                + (double) ((end - start) / 1000) * (1 / 60.0) + " min", LogLevel.Success);
    }

}