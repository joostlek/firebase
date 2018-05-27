package nl.jtosti.school;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crop {
    private int id;
    private String name;
    private Map<String, Boolean> farms;

    public Crop() {
    }

    public Crop(int id, String name, Map<String, Boolean> farms) {
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

    public Map<String, Boolean> getFarms() {
        return farms;
    }

    public void setFarms(Map<String, Boolean> farms) {
        this.farms = farms;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("name", this.name);
        map.put("farms", this.farms);
        return map;
    }
}
