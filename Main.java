import java.io.*;
import java.util.Scanner;

public class Main {
    private static Bohrloch[] bohrloecher = new Bohrloch[10];
    public static void initializeBohrloecher() {
        for(int i = 0; i < bohrloecher.length; i++) {
            bohrloecher[i] = new Bohrloch();
        }
    }
    
    public static void readFromCSV() throws FileNotFoundException {
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
    
    public static double eukledischeMetrik(Bohrloch bohrloch1, Bohrloch bohrloch2) {
        double xsquare = Math.pow(bohrloch2.getX() - bohrloch1.getX(), 2);
        double ysquare = Math.pow(bohrloch2.getY() - bohrloch1.getY(), 2);
        double result = Math.sqrt(xsquare + ysquare);
        return result;
    }
    
    public static double maximumsMetrik(Bohrloch bohrloch1, Bohrloch bohrloch2) {
        return Math.max(Math.abs(bohrloch2.getY() - bohrloch1.getY()), Math.abs(bohrloch2.getX() - bohrloch1.getX()));
    }
    
    public static double manhattanMetrik(Bohrloch bohrloch1, Bohrloch bohrloch2) {
        return Math.abs(bohrloch2.getX() - bohrloch1.getX()) + Math.abs(bohrloch2.getY() - bohrloch1.getY());
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        initializeBohrloecher();
        readFromCSV();
        
        for (int i = 0; i < bohrloecher.length; i++) {
            
        }
    }
}