package DTO;

public class CustomerDetails {
    private int customerId;
    private int totalTrips;
    private int totalFare;

    public CustomerDetails(int customerId, int totalTrips, int totalFare) {
        this.customerId = customerId;
        this.totalTrips = totalTrips;
        this.totalFare = totalFare;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "customerId=" + customerId +
                ", totalTrips=" + totalTrips +
                ", totalFare=" + totalFare +
                '}';
    }
}
