package App;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Figura {
    private Random rand = new Random();
    public String typ;
    public ArrayList<Integer> punkt_x = new ArrayList<Integer>();
    public ArrayList<Integer> punkt_y = new ArrayList<Integer>();
    public Color kolor;


    Figura() {
        kolor = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());

        int x = rand.nextInt(99);
        int y = rand.nextInt(99);
        int x2, y2, x3, y3;

        switch(rand.nextInt(3)) {
            case 0:
                typ = "rectangle";
                add_punkt(x, y);
                x2 = rand.nextInt(99-x)+1;
                y2 = rand.nextInt(99-y)+1;
                add_punkt(x2, y2);
//                System.out.println("rectangle: "+x+" "+y+" "+x2+" "+y2);
                break;
            case 1:
                typ = "oval";
                add_punkt(x, y);
                x2 = rand.nextInt(99-x)+1;
                y2 = rand.nextInt(99-y)+1;
                add_punkt(x2, y2);
//                System.out.println("oval: "+x+" "+y+" "+x2+" "+y2);
                break;
            case 2:
                typ = "triangle";
                add_punkt(x, y);
                do {
                    x2 = rand.nextInt(99-x)+1;
                    y2 = rand.nextInt(99-y)+1;
                } while(x2==x && y2 == y);
                do {
                    x3 = rand.nextInt(99-x)+1;
                    y3 = rand.nextInt(99-y)+1;
                } while((x3==x && y3 == y) || (x3==x2 && y3 == y2));
                add_punkt(x2, y2);
                add_punkt(x3, y3);
//                System.out.println("triangle: "+x+" "+y+" "+x2+" "+y2+" "+x3+" "+y3);
                break;
        }
    }

    public void add_punkt(int x, int y) {
        punkt_x.add(x);
        punkt_y.add(y);
    }

    public String getType() {
        return typ;
    }

    public int get_x(int i) {
        return punkt_x.get(i);
    }

    public int get_y(int i) {
        return punkt_y.get(i);
    }

    public Color getKolor() {
        return kolor;
    }

    public String toString() {
        String string = typ + System.getProperty("line.separator");
        for(int i = 0 ; i < punkt_x.size(); ++i) {
            string += ("x = " + (punkt_x.get(i)).toString());
            string += System.getProperty("line.separator");
            string += ("y = " + (punkt_y.get(i)).toString());
            string += System.getProperty("line.separator");
        }
        return string;
    }

}
