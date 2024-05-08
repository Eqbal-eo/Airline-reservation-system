package ucakrezervasyonsystem;


public class City {
    static int class_id = 0;
    private int id;
    private String name;

    public City(String name) {
        this.id = class_id;
        this.name = name;
        class_id++;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name; 
    }
    
    
    
}
