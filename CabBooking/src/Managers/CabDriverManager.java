package Managers;

import DTO.Available;
import DTO.CabDeatails;
import DTO.CabRide;
import Users.CabRidier;
import Users.Customer;

import java.util.*;

public class CabDriverManager{
    private int prevRided=0;
    private static List<CabRidier> cabRidierList=new ArrayList<>();
    private static CabDriverManager cabDriverManager;

    static {
        cabDriverManager=new CabDriverManager();
        cabRidierList.add(new CabRidier(1,"aaa","111",38,'M',"D"));
        cabRidierList.add(new CabRidier(2,"bbb","222",40,'M',"G"));
        cabRidierList.add(new CabRidier(3,"ccc","333",20,'F',"G"));
        cabRidierList.add(new CabRidier(4,"ddd","444",30,'F',"A"));
    }
    private CabDriverManager(){

    }
    public static CabDriverManager getInstance(){
        return cabDriverManager;
    }
    public int validUser(String username,String password) {
            for(CabRidier cr:cabRidierList){
                if(cr.getName().equals(username)){
                    if(cr.getPassword().equals(password)){
                        System.out.println("Welcome "+ username);
                        return cr.getId();
                    }else{
                        System.out.println("Invalid Password");
                        return -1;
                    }
                }
            }
            System.out.println("Welcome User");
            return -1;
    }
    public String addCabRidier(CabRidier cabRidier){
        cabRidierList.add(cabRidier);
        return "New cabRidier is Added";
    }
    public List<Available> getCabDriverList(String source){
        List<Available> availables=new ArrayList<>();
        LocationManager lm=LocationManager.getInstance();
        int nearest=Integer.MAX_VALUE;
        Map<String,Available> cabAndDistance=new HashMap<>();
        for(CabRidier cr:cabRidierList){
            if(prevRided!=cr.getId()){
                int distance=lm.distanceBetweenTwoPoints(source,cr.getLocation());
                if(distance<nearest){
                    nearest=distance;
                }
                if(cabAndDistance.containsKey(cr.getLocation())){
                    Available a=cabAndDistance.get(cr.getLocation());
                    if(a.getTripsMade()>cr.getTotalTrips() || a.getTripsMade()<cr.getTotalTrips()){
                        a.clearList();
                        a.setTripsMade(cr.getTotalTrips());
                    }
                    a.addAvailableList(cr.getId());
                    cabAndDistance.put(cr.getLocation(),a);
                }else{
                    Available a=new Available();
                    a.setLocation(cr.getLocation());
                    a.setDistance(distance);
                    a.setTripsMade(cr.getTotalTrips());
                    a.addAvailableList(cr.getId());
                    cabAndDistance.put(cr.getLocation(),a);
                }
            }
        }
        for(String loc:cabAndDistance.keySet()){
            if(cabAndDistance.get(loc).getDistance()==nearest){
                availables.add(cabAndDistance.get(loc));
            }
        }
        return availables;
    }
    public String bookCab(int cabDriverid,String source,String destination,int distance,int customerId){
        CustomerManager customerManager=CustomerManager.getInstance();
        for(CabRidier cr:cabRidierList){
            if(cr.getId()==cabDriverid){
                cr.setLocation(destination);
                prevRided=cr.getId();
                cr.addCabRideList(new CabRide(source,destination,customerId,distance*10,distance*10*0.3));
                cr.setTotalFare(distance*10);
                cr.setTotalZolaCommision(distance*10*0.3);
                cr.setTotalTrips();
                break;
            }
        }
        return "Successfully Cab Booked";
    }
    public List<CabRide> history(int cabDriverId){
        for(CabRidier cr:cabRidierList){
            if(cr.getId()==cabDriverId){
                return cr.getCabRideList();
            }
        }
        return  new ArrayList<>();
    }
    public CabDeatails getDetails(int cabDriverId){
        for(CabRidier cr:cabRidierList){
            if(cabDriverId==cr.getId()){
                return new CabDeatails(cr.getId(),cr.getTotalFare(),cr.getTotalZolaCommision(),cr.getTotalTrips());
            }
        }
        return null;
    }
}
