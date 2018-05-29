package nl.jtosti.school.Farm;

import nl.jtosti.school.Crop;
import nl.jtosti.school.Farmer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Farm {
    private int id;
    private String name;
    private String address;
    private ArrayList<Crop> crops;
    private ArrayList<Farmer> farmers;

    public Farm() {
    }

    public Farm(int id, String name, String address, ArrayList<Crop> crops, ArrayList<Farmer> farmers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.crops = crops;
        this.farmers = farmers;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Crop> getCrops() {
        return crops;
    }

    public void setCrops(ArrayList<Crop> crops) {
        this.crops = crops;
    }

    public ArrayList<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(ArrayList<Farmer> farmers) {
        this.farmers = farmers;
    }

    public void addCrop(Crop crop) {
        this.crops.add(crop);
    }

    public void addFarmer(Farmer farmer) {
        this.farmers.add(farmer);
    }
}
