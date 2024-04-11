package Managers;

import DTO.CustomerDetails;
import DTO.CustomerRide;
import Users.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

    private static CustomerManager customerManager;
    private static List<Customer> customerList=new ArrayList<>();
    static {
        customerManager=new CustomerManager();
        customerList.add(new Customer(1,"zz","11",39,'M',"A"));
        customerList.add(new Customer(2,"yy","22",40,'F',"A"));
        customerList.add(new Customer(3,"xx","33",29,'M',"A"));
        customerList.add(new Customer(4,"ww","44",50,'F',"A"));

    }
    private CustomerManager(){

    }
    public static CustomerManager getInstance(){
        return  customerManager;
    }
    public int validUser(String userName,String password){
        for(Customer c:customerList){
            if(c.getName().equals(userName)){
                if(c.getPassword().equals(password)){
                    System.out.println("welCome " + userName);
                    return c.getId();
                }else{
                    System.out.println("Invalid Password");
                    return -1;
                }
            }
        }
        System.out.println("Invalid User");
        return -1;
    }
    public String addCustomer(Customer customer){
        customerList.add(customer);
        return "Customer is Added";
    }
    public void addRide(int customerId,String source,String destination,int cabRiderId,int distance){
        for(Customer c:customerList){
            if(c.getId()==customerId){
                c.addCustomerRide(new CustomerRide(source,destination,cabRiderId,distance*10));
                c.setTotalFare(distance*10);
                c.setTotalTrips();
                break;
            }
        }
    }
    public List<CustomerRide> history(int customerId){
        for(Customer c:customerList){
            if(c.getId()==customerId){
                return c.getCustomerRideList();
            }
        }
        return new ArrayList<>();
    }
    public CustomerDetails getDetails(int customerId){
        for(Customer c:customerList){
            if(customerId==c.getId()){
                return new CustomerDetails(c.getId(),c.getTotalTrips(),c.getTotalFare());
            }
        }
        return null;
    }
}
