package Managers;

import DTO.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationManager {
    private static LocationManager locationManager;
    private static List<Location> locationList=new ArrayList<>();
    static {
        locationManager=new LocationManager();
        locationList.add(new Location(1,"A",0));
        locationList.add(new Location(2,"B",10));
        locationList.add(new Location(3,"C",3));
        locationList.add(new Location(4,"D",9));
        locationList.add(new Location(5,"E",5));
        locationList.add(new Location(6,"F",12));
        locationList.add(new Location(7,"G",7));
    }
    private LocationManager(){

    }
    public static LocationManager getInstance(){
        return locationManager;
    }
    public String addLocation(Location location){
        locationList.add(location);
        return "New Location is added";
    }
    public int distanceBetweenTwoPoints(String source,String cabDriverLocation){
        int sourceDisFromOrigin=0;
        int cabDriverFromOrigin=0;
        for(Location l:locationList){
            if(l.getName().equals(source)){
                sourceDisFromOrigin=l.getDistance();
            }if(l.getName().equals(cabDriverLocation)){
                cabDriverFromOrigin=l.getDistance();
            }
        }
        return Math.abs(sourceDisFromOrigin-cabDriverFromOrigin);
    }
}
