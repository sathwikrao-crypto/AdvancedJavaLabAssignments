// Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by implementing the event handling mechanism with addActionListener( ).


package SwingPrograms_4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingPrograms_4c extends JFrame implements ActionListener {
    JButton digitalBtn, hourGlassBtn;
    JLabel messageLabel;

    public SwingPrograms_4c() {
        setTitle("Button Event Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Load images from /images folder inside src
        digitalBtn = new JButton("Digital Clock",
                new ImageIcon(getClass().getResource("/images/digital.png.png")));
        hourGlassBtn = new JButton("Hour Glass",
                new ImageIcon(getClass().getResource("/images/hourglass.png.png")));

        messageLabel = new JLabel("Press a button...");

        // Add ActionListeners
        digitalBtn.addActionListener(this);
        hourGlassBtn.addActionListener(this);

        // Add components
        add(digitalBtn);
        add(hourGlassBtn);
        add(messageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == digitalBtn) {
            messageLabel.setText("Digital Clock is pressed");
        } else if (e.getSource() == hourGlassBtn) {
            messageLabel.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        new SwingPrograms_4c();
    }
}