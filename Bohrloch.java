public class Bohrloch {
    private int x, y;
    private String name, next;
    private double[] entfernung = new double[10];
    private boolean besucht, istNaechste;
    
    public Bohrloch(String name, int x, int y) {
        this.name = name;
        this.next = null;
        this.x = x;
        this.y = y;
        this.besucht = false;
        this.istNaechste = false;
    }
    
    public Bohrloch() {
        
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getX() {
        return this.x;
    }
    
    public double getXDouble() {
        return Double.valueOf(this.x);
    }
    
    public int getY() {
        return this.y;
    }
    
    public double getYDouble() {
        return Double.valueOf(this.y);
    }
    
    public double getEntfernung(int i) {
        return this.entfernung[i];
    }
    
    public void setEntfernung(int i, double value) {
        this.entfernung[i] = value;
    }
    
    public double[] entfernungArray() {
        return this.entfernung;
    }
    
    public void setBesucht(boolean b) {
        this.besucht = b;
    }
    
    public boolean isBesucht() {
        return this.besucht;
    }
    
    public void setNext(String next) {
        this.next = next;
    }
    
    public String getNext() {
        return this.next;
    }
    
    // public void bestimmeNext() {
        
    // }
    
    public boolean isNext() {
        return this.istNaechste;
    }
    
    public void setNext(boolean b) {
        this.istNaechste = b;
    }
}