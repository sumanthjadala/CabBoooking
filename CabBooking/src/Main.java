import DTO.Available;
import DTO.CabRide;
import DTO.CustomerRide;
import DTO.Location;

import Managers.AdminManager;
import Managers.CabDriverManager;
import Managers.CustomerManager;
import Managers.LocationManager;
import Users.CabRidier;
import Users.Customer;

import java.util.*;

public class Main {
    static void getUserDetails(){

    }
    public static void main(String[] args) {
        CabDriverManager cb=CabDriverManager.getInstance();
        CustomerManager cm=CustomerManager.getInstance();
        LocationManager lm=LocationManager.getInstance();
        Scanner sc = new Scanner(System.in);
        while(true) {

            System.out.println("Please Enter what type of user you are : \n cabDriver \n admin \n customer \n");
            String userType = sc.nextLine();

            if (userType.equals("cabDriver")) {
                System.out.println("Please Enter your userName");
                String userName = sc.nextLine();
                System.out.println("Please Enter your Password");
                String password = sc.nextLine();
                int cabRidierId=cb.validUser(userName, password);
                List<CabRide> cabRideList=cb.history(cabRidierId);
                for(CabRide c:cabRideList){
                    System.out.println(c);
                }

            } else if (userType.equals("admin")) {
                AdminManager am=AdminManager.getInstance();
                System.out.println("Please Enter your userName");
                String userName = sc.nextLine();
                System.out.println("Please Enter your Password");
                String password = sc.nextLine();
                System.out.println();
                am.validUser(userName,password);
                System.out.println("Enter You customer ID you are looking for");
                int customerId=sc.nextInt();
                sc.nextLine();
                System.out.println(am.getCustomerDetails(customerId));
                System.out.println("Enter You CabDriver ID you are looking for");
                int cabDriverId=sc.nextInt();
                sc.nextLine();
                System.out.println(am.getcabDriverDetails(cabDriverId));
            } else if (userType.equals("customer")) {
                System.out.println("Please Enter your userName");
                String userName = sc.nextLine();
                System.out.println("Please Enter your Password");
                String password = sc.nextLine();
                int customerId=cm.validUser(userName, password);
                System.out.println("Please the Enter the your Source");
                String source=sc.nextLine();
                System.out.println("Please the Enter the your Destination");
                String destination=sc.nextLine();
                List<Available> cabList=cb.getCabDriverList(source);
                int totalDistance=lm.distanceBetweenTwoPoints(source,destination);
                for(Available cab:cabList){
                    System.out.println(cab.getLocation()+" "+cab.getAvailableList()+" "+cab.getDistance());

                }
                System.out.println("Please choose one of the Cab Id");
                int selectedCabId=sc.nextInt();
                sc.nextLine();
                cm.addRide(customerId,source,destination,selectedCabId,totalDistance);
                cb.bookCab(selectedCabId,source,destination,totalDistance,customerId);

            } else {
                System.out.println("Please Enter Valid Type of User ");
            }
        }
    }

}

