package DTO;

public class CabRide {
    private String source;
    private String destination;
    private int customerDetails;
    private int fare;
    private double zulaCommission;

    public CabRide(String source, String destination, int customerDetails, int fare, double zulaCommission) {
        this.source = source;
        this.destination = destination;
        this.customerDetails = customerDetails;
        this.fare = fare;
        this.zulaCommission = zulaCommission;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(int customerDetails) {
        this.customerDetails = customerDetails;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public double getZulaCommission() {
        return zulaCommission;
    }

    public void setZulaCommission(double zulaCommission) {
        this.zulaCommission = zulaCommission;
    }

    @Override
    public String toString() {
        return "CabRide{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", customerDetails=" + customerDetails +
                ", fare=" + fare +
                ", zulaCommission=" + zulaCommission +
                '}';
    }
}
