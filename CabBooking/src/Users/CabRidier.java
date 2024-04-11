package Users;

import Basic.User;
import DTO.CabRide;

import java.util.ArrayList;
import java.util.List;

public class CabRidier extends User {
    private List<CabRide> cabRideList=new ArrayList<>();
    private int totalTrips=0;
    private int totalFare=0;
    private double totalZolaCommision=0;

    public CabRidier(int id, String name, String password, int age, char gender, String location) {
        super(id, name, password, age, gender, location);
    }

    public List<CabRide> getCabRideList() {
        return cabRideList;
    }

    public void addCabRideList(CabRide cabRide) {
        this.cabRideList.add(cabRide);
    }

    public int getTotalTrips() {
        return totalTrips;
    }

    public void setTotalTrips() {
        this.totalTrips++;
    }

    public int getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(int totalFare) {
        this.totalFare += totalFare;
    }

    public double getTotalZolaCommision() {
        return totalZolaCommision;
    }

    public void setTotalZolaCommision(double totalZolaCommision) {
        this.totalZolaCommision += totalZolaCommision;
    }
}
