package Users;

import Basic.User;
import DTO.CustomerRide;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<CustomerRide> customerRideList=new ArrayList<>();
    private int totalTrips=0;
    private int totalFare=0;

    public Customer(int id, String name, String password, int age, char gender, String location){
        super(id,name,password,age,gender,location);
    }

    public List<CustomerRide> getCustomerRideList() {
        return customerRideList;
    }

    public void addCustomerRide(CustomerRide customerRideList) {
        this.customerRideList.add(customerRideList);
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
}
