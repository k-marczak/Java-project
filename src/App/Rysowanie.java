package App;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Rysowanie extends JPanel implements ActionListener  {

    private Timer timer = new Timer(5, (ActionListener) this);
    private ArrayList<Figura> figury = new ArrayList<Figura>();
    public Skalowanie skal = new Skalowanie();
    private int frame_counter = 0;
    private Main main;

    public void add_to_scal(Component c) {
        setSize(800,600);
        skal.add(c);
    }

    public ArrayList<Figura> getFigury(){
        return figury;
    }

    public Rysowanie(Main m) {
//        System.out.println("W: " + skal.size_x + " H: " + skal.size_y);
        setSize(skal.size_x, skal.size_y);
        main = m;

    }

    public void actionPerformed(ActionEvent event) {
        synchronized(main) {
            frame_counter++;

            if(50 <= frame_counter)
            {
                frame_counter = 0;
                Figura f = new Figura();
                figury.add(f);

                main.notify();
            }
            repaint();
        }
    }

    private int rescale_x(int percent) {
        return percent * skal.size_x / 100;
    }

    private int rescale_y(int percent) {
        return percent * skal.size_y / 100;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setSize(skal.size_x, skal.size_y);

        this.setBackground(Color.LIGHT_GRAY);

        String typ;
        for(Figura f : figury)
        {
            typ = f.getType();
            g.setColor(f.getKolor());
            if ("rectangle".equals(typ)){
                g.drawRect(rescale_x(f.get_x(0)), rescale_y(f.get_y(0)), rescale_x(f.get_x(1)), rescale_y(f.get_y(1)));
            } else if ("oval" == typ) {
                g.drawOval(rescale_x(f.get_x(0)), rescale_y(f.get_y(0)), rescale_x(f.get_x(1)), rescale_y(f.get_y(1)));
            } else if ("triangle" == typ) {
                Polygon p = new Polygon();
                p.addPoint(rescale_x(f.get_x(0)), rescale_y(f.get_y(0)));
                p.addPoint(rescale_x(f.get_x(1)), rescale_y(f.get_y(1)));
                p.addPoint(rescale_x(f.get_x(2)), rescale_y(f.get_y(2)));
                g.drawPolygon(p);
            }
        }

        timer.start();
    }
}
