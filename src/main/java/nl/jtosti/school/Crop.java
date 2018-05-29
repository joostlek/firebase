package nl.jtosti.school;

import nl.jtosti.school.Farm.Farm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crop {
    private int id;
    private String name;
    private List<Integer> farms;

    public Crop() {
    }

    public Crop(int id, String name, List<Integer> farms) {
        this.id = id;
        this.name = name;
        this.farms = farms;
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

    public List<Integer> getFarms() {
        return farms;
    }

    public void setFarms(List<Integer> farms) {
        this.farms = farms;
    }

    public void addFarm(Farm farm) {
        this.farms.add(farm.getId());
    }
}
