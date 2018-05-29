package nl.jtosti.school;

import nl.jtosti.school.Farm.Farm;

public class Farmer {
    private int id;
    private String name;
    private int farm;

    public Farmer() {
    }

    public Farmer(int id, String name, int farm) {
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

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }
}
