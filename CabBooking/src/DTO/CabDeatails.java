package DTO;

public class CabDeatails {
    private int cabDriverid;
    private int totalFareCollected;
    private double totalZoleCommission;
    private  int totalTrips;

    public CabDeatails(int cabDriverid, int totalFareCollected, double totalZoleCommission, int totalTrips) {
        this.cabDriverid = cabDriverid;
        this.totalFareCollected = totalFareCollected;
        this.totalZoleCommission = totalZoleCommission;
        this.totalTrips = totalTrips;
    }

    @Override
    public String toString() {
        return "CabDeatails{" +
                "CabDriverid=" + cabDriverid +
                ", totalFareCollected=" + totalFareCollected +
                ", totalZoleCommission=" + totalZoleCommission +
                ", totalTrips=" + totalTrips +
                '}';
    }
}
