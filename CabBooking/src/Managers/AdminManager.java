package Managers;
import DTO.CabDeatails;
import DTO.CustomerDetails;
import DTO.Location;
import Users.Admin;
import Users.CabRidier;
import Users.Customer;
import java.util.ArrayList;
import java.util.List;

public class AdminManager {
    private static List<Admin> adminList=new ArrayList<>();
    private static AdminManager adminManager;
    static {
        adminManager=new AdminManager();
        adminList.add(new Admin(1,"sumanth","rohit",24,'M'));
    }
    private AdminManager(){
    }
    public static AdminManager getInstance(){
        return adminManager;
    }
    public String validUser(String userName,String password){
        for(Admin admin:adminList){
            if(admin.getUserName().equals(userName) && admin.getPassword().equals(password)){
                return "welcome "+ userName;
            }
        }
        return "Invalid Admin details";
    }
    public void addLocAation(Location location){
        LocationManager lm=LocationManager.getInstance();
        lm.addLocation(location);
    }
    public void addCustomer(Customer customer){
        CustomerManager cm=CustomerManager.getInstance();
        cm.addCustomer(customer);
    }
    public void addCabRidier(CabRidier cabRidier){
        CabDriverManager cdm=CabDriverManager.getInstance();
        cdm.addCabRidier(cabRidier);
    }
    public CabDeatails getcabDriverDetails(int cabDriverId){
        CabDriverManager cdm=CabDriverManager.getInstance();
        return cdm.getDetails(cabDriverId);
    }
    public CustomerDetails getCustomerDetails(int customerId){
        CustomerManager cm=CustomerManager.getInstance();
        return cm.getDetails(customerId);
    }
}
