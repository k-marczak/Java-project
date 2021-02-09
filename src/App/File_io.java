package App;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class File_io extends Thread {

    private Main main;

    public File_io(Main m) {
        main = m;
    }

    public void start(ArrayList<Figura> figureList) {
        String directory = System.getProperty("user.dir");
        String absolutePath = directory + File.separator + "savedFigures.txt";

        System.out.println(absolutePath);

        synchronized(main) {
            try {
                while(true)
                {
                    main.wait();
//                    if(0 == figureList.size()) {
//                        continue;
//                    }

                    Figura najnowsza = figureList.get(figureList.size() -1);
                    System.out.println(najnowsza.toString());

                    try (FileWriter fileWriter = new FileWriter(absolutePath, true)) {
                        fileWriter.write(najnowsza.toString());

                    } catch (IOException e) {
                        System.out.println("File write error: " + e.getMessage());
                    }
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}