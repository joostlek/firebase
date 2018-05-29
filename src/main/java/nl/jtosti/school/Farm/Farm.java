package nl.jtosti.school.Farm;

import nl.jtosti.school.Crop;
import nl.jtosti.school.Farmer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Farm {
    private int id;
    private String name;
    private String address;
    private List<Crop> crops;
    private List<Farmer> farmers;

    public Farm() {
    }

    public Farm(int id, String name, String address, List<Crop> crops, List<Farmer> farmers) {
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

    public List<Crop> getCrops() {
        return crops;
    }

    public void setCrops(List<Crop> crops) {
        this.crops = crops;
    }

    public void addCrop(Crop crop) {
        this.crops.add(crop);
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }

    public void addFarmer(Farmer farmer) {
        this.farmers.add(farmer);
    }
}
