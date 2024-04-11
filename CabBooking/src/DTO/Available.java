package DTO;

import java.util.ArrayList;
import java.util.List;

public class Available {
    private String location;
    private List<Integer> AvailableList=new ArrayList<>();
    private int distance;
    private int tripsMade;

    public int getTripsMade() {
        return tripsMade;
    }

    public void setTripsMade(int tripsMade) {
        this.tripsMade = tripsMade;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Integer> getAvailableList() {
        return AvailableList;
    }
    public void clearList(){
        AvailableList.clear();
    }

    public void addAvailableList(Integer a) {
        this.AvailableList.add(a);
    }
}
