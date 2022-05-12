public class Bohrloch {
    private int x, y;
    private String name;
    
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
}