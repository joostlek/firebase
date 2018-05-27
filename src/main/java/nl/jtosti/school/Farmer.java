package nl.jtosti.school;

public class Farmer {
    private int id;
    private String name;
    private Farm farm;

    public Farmer(int id, String name, Farm farm) {
        this.id = id;
        this.name = name;
        this.farm = farm;
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

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
