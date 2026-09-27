package pt.upt.quality.campusride;

public class RentalService {
    private final Fleet fleet;

    public RentalService(Fleet fleet) {
        this.fleet = fleet;
    }

    public void rentVehicle(String id) {
        findOrFail(id).rent();
    }

    public void returnVehicle(String id) {
        findOrFail(id).returnVehicle();
    }

    public double estimatePrice(String id, int minutes) {
        return findOrFail(id).calculatePrice(minutes);
    }

    private Vehicle findOrFail(String id) {
        Vehicle vehicle = fleet.findById(id);
        if (vehicle == null) {
            throw new IllegalArgumentException("Unknown vehicle: " + id);
        }
        return vehicle;
    }
}