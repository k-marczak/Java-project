package App;


public class Main extends Thread {

    public Rysowanie rys;
    public Main() {
        rys = new Rysowanie(this);
        rys.add_to_scal(rys);
    }

    public static void main(String[] args) {

        Main m = new Main();
        File_io Zapis = new File_io(m);
        Zapis.start(m.rys.getFigury());

    }

}
