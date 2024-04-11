package DTO;

public class CustomerRide {
    private String source;
    private String destination;
    private  int cab_details;
    private int fare;

    public CustomerRide(String source, String destination, int cab_details, int fare) {
        this.source = source;
        this.destination = destination;
        this.cab_details = cab_details;
        this.fare = fare;
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

    public int getCab_details() {
        return cab_details;
    }

    public void setCab_details(int cab_details) {
        this.cab_details = cab_details;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "CustomerRide{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", cab_details=" + cab_details +
                ", fare=" + fare +
                '}';
    }
}
