package thread.projava8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DaemonTest {
    private JFrame frame;
    public static void main(String[] args) {
        DaemonTest t = new DaemonTest();
    }
    public DaemonTest() {
        frame = new JFrame("Hello World");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                frame.setVisible(false);
                frame.removeWindowListener(this);
                frame.dispose();
                frame = null;
            }
        });
        Container pane = frame.getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(new JLabel("Hello world."));
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}