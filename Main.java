import java.io.*;
import java.util.Scanner;

public class Main {
    private Bohrloch[] bohrloecher = new Bohrloch[100];
    public void initializeBohrloecher() {
        for(int i = 0; i < bohrloecher.length; i++) {
            bohrloecher[i] = new Bohrloch();
        }
    }
    
    public void readFromCSV() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("koordinaten.csv"));
        int i = 0;
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String[] data = line.split(",");
            bohrloecher[i].setX(Integer.valueOf(data[0]));
            bohrloecher[i].setY(Integer.valueOf(data[1]));
            bohrloecher[i].setName(data[2]);
            i++;
        }
    }
}