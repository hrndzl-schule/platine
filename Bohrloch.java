public class Bohrloch {
    private int x, y;
    private String name;
    private double[] entfernung = new double[10];
    
    public Bohrloch(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
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
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getEntfernung(int i) {
        return this.entfernung[i];
    }
    
    public void setEntfernung(int i, int value) {
        this.entfernung[i] = value;
    }
}