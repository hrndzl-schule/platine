import java.io.*;
import java.util.Scanner;

public class Main {
    private static Bohrloch[] bohrloecher = new Bohrloch[10];
    Graph graph = new Graph();

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
        return Math.sqrt(Math.pow(bohrloch2.getX() - bohrloch1.getX(), 2) + Math.pow(bohrloch2.getY() - bohrloch1.getY(), 2));
    }

    public static double maximumsMetrik(Bohrloch bohrloch1, Bohrloch bohrloch2) {
        return Math.max(Math.abs(bohrloch2.getY() - bohrloch1.getY()), Math.abs(bohrloch2.getX() - bohrloch1.getX()));
    }

    public static double manhattanMetrik(Bohrloch bohrloch1, Bohrloch bohrloch2) {
        return Math.abs(bohrloch2.getX() - bohrloch1.getX()) + Math.abs(bohrloch2.getY() - bohrloch1.getY());
    }

    public static void entfernungenZuweisen() {
        for (int i = 0; i < bohrloecher.length; i++) {
            for (int j = 0; j < bohrloecher[i].entfernungArray().length; j++) {
                if (j < bohrloecher[i].entfernungArray().length - 1) {
                    bohrloecher[i].setEntfernung(j, eukledischeMetrik(bohrloecher[j], bohrloecher[j+1]));
                } else if (j < bohrloecher[i].entfernungArray().length) {
                    bohrloecher[i].setEntfernung(j, eukledischeMetrik(bohrloecher[j], bohrloecher[0]));
                }
            }
        }
    }

    public static void route(int i) {
        double kleinsteEntfernung = eukledischeMetrik(bohrloecher[i], bohrloecher[i+1]);
        int indexKleinsteEntfernung = 0;
        for (int j = 0; j < bohrloecher[0].entfernungArray().length; j++) {
            if (eukledischeMetrik(bohrloecher[i], bohrloecher[j]) < kleinsteEntfernung && !bohrloecher[i].isBesucht()) {
                indexKleinsteEntfernung = j + 1;
            }
        }
        bohrloecher[i].setNext(bohrloecher[indexKleinsteEntfernung].getName());
        bohrloecher[i].setBesucht(true);
        for (int j = 0; j < bohrloecher.length; j++) {
            if (bohrloecher[j].getName().equals(bohrloecher[indexKleinsteEntfernung].getName())) {
                bohrloecher[j].setNext(true);
                bohrloecher[j].setBesucht(true);
                bohrloecher[j].setNext(false);
                route(j);
                break;
            }
        }
        
        for (int j = 0; j < bohrloecher.length; j++) {
            if (bohrloecher[j].isNext()) {
                bohrloecher[j].setNext(false);
                bohrloecher[j].setBesucht(true);
                route(j);
                break;
            }
        }
    }

    public static void bestimmeNext(Bohrloch[] arr, int index) {
        double kleinsteEntfernung = eukledischeMetrik(arr[index], arr[0]);
        int indexKleinsteEntfernung = 0;
        for (int i = 0; i < arr.length; i++) {
            if (eukledischeMetrik(arr[index], arr[i]) < kleinsteEntfernung) {
                kleinsteEntfernung = eukledischeMetrik(arr[index], arr[i]);
                indexKleinsteEntfernung = i;
                arr[index].setNext(arr[i].getName());
                break;
            }
        }
    }
    
    public static void erstelleGraph() {
        
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        initializeBohrloecher();
        readFromCSV();
        
        // bestimmeNext(bohrloecher, 0);
        // entfernungenZuweisen();
        // route(0);
    }
}