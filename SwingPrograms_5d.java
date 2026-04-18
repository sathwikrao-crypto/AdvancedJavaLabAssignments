// Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and Yellow and display the concerned color whenever the specific tab is selected in the Pan

package SwingPrograms_5;

import javax.swing.*;
import java.awt.*;

public class SwingPrograms_5d extends JFrame {
    JTabbedPane tabbedPane;

    public SwingPrograms_5d() {
        setTitle("Tabbed Pane Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        // Panels that fill the tab area with color
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);

        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);

        // Add tabs
        tabbedPane.addTab("Cyan", cyanPanel);
        tabbedPane.addTab("Magenta", magentaPanel);
        tabbedPane.addTab("Yellow", yellowPanel);

        // Listener to show which tab is selected
        tabbedPane.addChangeListener(e -> {
            int index = tabbedPane.getSelectedIndex();
            String title = tabbedPane.getTitleAt(index);
            System.out.println("Selected tab: " + title);
        });

        add(tabbedPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingPrograms_5d();
    }
}