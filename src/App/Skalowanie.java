package App;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class Skalowanie extends JFrame {
    public int size_x;
    public int size_y;

    public Skalowanie() {
        setTitle("Okienko");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();

        size_x = this.getWidth();
        size_y = this.getHeight();

        getContentPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent event) {
                Component c = (Component)event.getSource();
//                System.out.println("SCAL - W: " + c.getWidth() + " H: " + c.getHeight());
                size_x = c.getWidth();
                size_y = c.getHeight();
            }
        });
    }
}
